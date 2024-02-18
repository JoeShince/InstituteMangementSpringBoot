//package com.sample.instituremanagement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AuthConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${security.enable-csrf}")
//    private boolean csrfEnabled;
//
//    @Override
//    protected void configure( http) throws Exception {
//        super.configure(http);
//
//        if(!csrfEnabled)
//        {
//            http.csrf(AbstractHttpConfigurer::disable);
//
//        }
//    }
//}
