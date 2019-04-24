package com.spring.security.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//enable spring security to the application
@EnableWebSecurity
//so springboot automatically loads this during configuration
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //if you don't want to authorize all requests you can add antMatchers and add the appropriate urls
        //httpSecurity.authorizeRequests().antMatchers("/rest/hello").denyAll().and().httpBasic();
        //permit all and any requests and give me all the httpbasic authentacations
        httpSecurity.authorizeRequests().anyRequest().permitAll().and().httpBasic();

        //disable cross site request forgery for simplicity 
        httpSecurity.csrf().disable();
    }


}
