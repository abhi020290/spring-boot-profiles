package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private Environment environment;

    @Autowired
    private EnvironmentConfigBean configBean;

    @Autowired
    ReloadableProperties reloadableProperties;

    @Value("${message.welcome}")
    String welcome;

    @Value("${message.thanks}")
    String thanks;

    @RequestMapping("trigger")
    String getMessage(){
        return "Welcome :"+welcome+" , Thanks : "+thanks;
    }

    @RequestMapping("environment")
    String environment(){
        return configBean.getColor();
    }

    @RequestMapping("change")
    String change(){
        return environment.toString();
    }

    @RequestMapping("getProperty")
    String getProperty(){
        return reloadableProperties.getProperty("message.welcome");
    }

    @RequestMapping("setProperty")
    String setProperty(){
         reloadableProperties.setProperty("message.welcome",welcome);
         return reloadableProperties.getProperty("message.welcome");
    }
}
