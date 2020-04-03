package com.frameworkset.sqlexecutor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  @author yinbp [122054810@qq.com]
 *
 */

//改变自动扫描的包
//@ComponentScan(basePackages = {"org.bboss.elasticsearchtest.springboot",
//        "org.frameworkset.elasticsearch.boot"})
@SpringBootApplication(scanBasePackages = "com.frameworkset.sqlexecutor")
public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);
    public Application(){
        System.out.println("aa");
//        db2DBdemo.scheduleImportData();
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }




}
