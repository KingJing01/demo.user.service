package com.xsungroup.utils.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.xinya.tools.mybatis.handler.AutoEnumTypeHandler;
import com.xinya.tools.mybatis.handler.BaseEnum;
import com.xinya.tools.mybatis.page.MySQLDialect;
import com.xinya.tools.mybatis.page.PageableInterceptor;
import com.xsungroup.domain.enums.DriverStatusEnum;
import com.xsungroup.domain.enums.ProcessingStatusEnum;
import com.xsungroup.repository.handler.EnumTypeHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**  
 * Druid的DataResource配置类  
 * 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，  
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")  
 * 获取application配置文件中的变量。 这里采用第一种要方便些  
 * Created by sun on 2017-1-20.  
 */
@Order(-99)
@Configuration
@ConfigurationProperties
@EnableTransactionManagement
public class DruidDataSourceConfig{

    @Autowired
    private Environment env;

    @RefreshScope
    @Bean  
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("spring.datasource.url"));
        datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));  
        datasource.setUsername(env.getProperty("spring.datasource.username"));  
        datasource.setPassword(env.getProperty("spring.datasource.password"));  
        datasource.setInitialSize(Integer.valueOf(env.getProperty("spring.datasource.initialSize")));  
        datasource.setMinIdle(Integer.valueOf(env.getProperty("spring.datasource.minIdle")));  
        datasource.setMaxWait(Long.valueOf(env.getProperty("spring.datasource.maxWait")));  
        datasource.setMaxActive(Integer.valueOf(env.getProperty("spring.datasource.maxActive")));
        //datasource.setValidationQueryTimeout(Integer.valueOf(env.getProperty("spring.datasource.timeout")));
        datasource.setMinEvictableIdleTimeMillis(
                Long.valueOf(env.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
        try {
            datasource.setFilters("stat,wall");  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return datasource;  
    }  
  
    @Bean
    public ServletRegistrationBean druidServlet() {  
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();  
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");  
        Map<String, String> initParameters = new HashMap<String, String>();  
        initParameters.put("loginUsername", "admin");// 用户名
        initParameters.put("loginPassword", "admin");// 密码
        initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能  
        //initParameters.put("allow", "127.0.0.1"); IP白名单 (没有配置或者为空，则允许所有访问)
        // initParameters.put("deny", "192.168.20.38");// IP黑名单  
        // (存在共同时，deny优先于allow)  
        servletRegistrationBean.setInitParameters(initParameters);  
        return servletRegistrationBean;  
    }
  
    @Bean  
    public FilterRegistrationBean filterRegistrationBean() {  
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();  
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");  
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");  
        return filterRegistrationBean;  
    }  
  
    // 按照BeanId来拦截配置 用来bean的监控  
    @Bean(value = "druid-stat-interceptor")  
    public DruidStatInterceptor DruidStatInterceptor() {
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
        return druidStatInterceptor;  
    }  
  
    @Bean  
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {  
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();  
        beanNameAutoProxyCreator.setProxyTargetClass(true);  
        // 设置要监控的bean的id  
        //beanNameAutoProxyCreator.setBeanNames("sysRoleMapper","loginController");  
        beanNameAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");  
        return beanNameAutoProxyCreator;  
    }
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource,
                                                   org.apache.ibatis.session.Configuration config) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xinya.repository.entity");
        sqlSessionFactoryBean.setConfiguration(config);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{paginationInterceptor()});
        try {
            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:mapper/*.xml"));
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            //注册自定义类型处理
            TypeHandlerRegistry  typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
            typeHandlerRegistry.register(EnumTypeHandler.class);
            return sqlSessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SqlSessionFactory build error", e);
        }
    }
    /**
     * 分页插件
     */
    @Bean
    public PageableInterceptor paginationInterceptor() {
        PageableInterceptor pageableInterceptor = new PageableInterceptor();
        pageableInterceptor.setDialect(new MySQLDialect());
        return pageableInterceptor;
    }



    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatiesConfig(){
        return new org.apache.ibatis.session.Configuration();
    }
  
} 