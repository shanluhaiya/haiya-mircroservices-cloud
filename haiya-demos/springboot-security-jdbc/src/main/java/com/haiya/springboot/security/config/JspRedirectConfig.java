package com.haiya.springboot.security.config;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

//@Configuration
//public class JspRedirectConfig {
//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
//        return (factory) -> {
//            factory.addConnectorCustomizers((context) -> {
//                /**
//                 * 模块中webapp相对路径
//                 */
//                String relationPath = "src/main/webapp";
//                File docBaseFile = new File(relationPath);
//                if (docBaseFile.exists()) {
//                    context.setDocBase(docBaseFile.getAbsolutePath());
//                }
//            });
//        };
//    }
//}
