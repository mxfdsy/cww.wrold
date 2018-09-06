//package cww.world.controller.test;
//
///**
// * @author 小武 on 2018/8/23.
// */
//import cww.world.common.util.RedisUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/caches")
//public class CacheController {
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @RequestMapping("/test")
//    public String  test(){
//        redisUtils.set("123", "hello world");
//        System.out.println("进入了方法");
//        String string= redisUtils.get("123").toString();
//        return string;
//    }
//
//}