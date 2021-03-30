package com.kyw.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kyw
 * @version 1.0
 * @date 2021/3/29 14:37
 */
@Configuration
public class MySelRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
