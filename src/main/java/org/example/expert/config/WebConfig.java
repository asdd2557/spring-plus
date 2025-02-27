//package org.example.expert.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    private final JwtUtil jwtUtil;
//
//    public WebConfig(JwtUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new AuthUserArgumentResolver(jwtUtil));
//    }
//}
