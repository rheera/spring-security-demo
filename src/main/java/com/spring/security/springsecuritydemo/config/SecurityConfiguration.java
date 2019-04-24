package com.spring.security.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

        //permit all and any requests and give me all the httpbasic authentications
        //httpSecurity.authorizeRequests().anyRequest().permitAll().and().httpBasic();

        /*now that we have some users in the authentication manager we can allow only the users in the manager
        we are saying every request should be authenticated
         */
        httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();

        //disable cross site request forgery for simplicity
        httpSecurity.csrf().disable();
    }

    /*to authenticate this particular server, give our own usernames and passwords,
    in memory authentication lets you put the username and password right here
    we created 2 users for the authentication manager
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Raman").password("test").roles("USER").and()
                .withUser("demo").password("test2").roles("admin");
    }

}
