package com.rm.example.demo.webService.conf;

import com.rm.example.demo.webService.service.AppService;
import com.rm.example.demo.webService.service.AppServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/20
 */
@Configuration
public class CxfConfig {
    //默认servlet路径/*,如果覆写则按照自己定义的来
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    //把实现类交给spring管理
    @Bean
    public AppService appService() {
        return new AppServiceImpl();
    }

    //终端路径
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), appService());
        endpoint.publish("/user");
        return endpoint;
    }
}
