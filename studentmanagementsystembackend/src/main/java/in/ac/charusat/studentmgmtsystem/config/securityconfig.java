package in.ac.charusat.studentmgmtsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter {

    @Autowired
        DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(dataSource)
                    .withDefaultSchema()
                    .withUser(
                            User.withUsername("mohit")
                                    .password("meet1803")
                                    .roles("ADMIN")
                    );
//                    .withUser(
//                                User.withUsername("user")
//                                        .password("user")
//                                        .roles("USER")
//                    );

//        auth.inMemoryAuthentication()
//                .withUser("mohit")
//                .password("meet1803")
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password("user")
//                .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getpass(){
        return NoOpPasswordEncoder.getInstance();
    }
}
