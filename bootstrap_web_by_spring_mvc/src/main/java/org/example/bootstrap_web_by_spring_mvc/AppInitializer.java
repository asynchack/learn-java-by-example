package org.example.bootstrap_web_by_spring_mvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.bootstrap_web_by_spring_mvc
 * @date 2024/2/7 07:54
 */
public class AppInitializer implements WebApplicationInitializer {
    HttpMessageConverter

    @Override
    public void onStartup(javax.servlet.ServletContext container) throws ServletException{
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("org.example.bootstrap_web_by_spring_mvc");
        container.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}


