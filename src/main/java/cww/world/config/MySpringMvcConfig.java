//package cww.world.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.Arrays;
//
///**
// * @author 小武 on 2018/8/22.
// */
//@Configuration
//public class MySpringMvcConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    Interceptor interceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor).addPathPatterns("/**")
//                .excludePathPatterns(Arrays.asList("/css/**", "/font/**", "/jquery/com/**", "/lay/modules","/layui.all.js","/layui.js"));
//        super.addInterceptors(registry);
//    }
//}
