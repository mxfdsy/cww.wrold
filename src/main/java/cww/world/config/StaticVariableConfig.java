package cww.world.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import java.util.HashMap;
import java.util.Map;

/**
 * @Descriptions: 全局变量的定义
 * @Author: cww
 * @Date : 2018-03-06 15:07
 */
@Configuration
public class StaticVariableConfig {

    /**
     * thymleaf 全局变量定义
     * @param viewResolver
     */
    @Autowired
    public void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver, Environment environment) {
        if(viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("SYS_NAME", environment.getProperty("sys.name"));
            viewResolver.setStaticVariables(vars);
        }
    }
}
