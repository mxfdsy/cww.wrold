package cww.world;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 小武 on 2018/8/13.
 */
@SpringBootApplication
@MapperScan(basePackages = "cww.world.mapper")
public class myApplication {
    public static void main(String[] args) {
            SpringApplication.run(myApplication.class, args);
    }
}
