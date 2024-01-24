package proyect.seguridad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSeguridad<JwtFilter> {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth,
                                                      PasswordEncoder passwordEncoder,
                                                      UserDetailsService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        return auth.build();
    }

    @SuppressWarnings("deprecation")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        RequestMatcher authPathMatcher = new AntPathRequestMatcher("/auth/**");

        RequestMatcher getofertasMatcher = new AntPathRequestMatcher("/ofertas/**", HttpMethod.GET.name());
        RequestMatcher postofertasMatcher = new AntPathRequestMatcher("/ofertas/**", HttpMethod.POST.name());
        RequestMatcher putofertasMatcher = new AntPathRequestMatcher("/ofertas/**", HttpMethod.PUT.name());
        RequestMatcher deleteofertasMatcher = new AntPathRequestMatcher("/ofertas/**", HttpMethod.DELETE.name());

        RequestMatcher getempresaMatcher = new AntPathRequestMatcher("/empresa/**", HttpMethod.GET.name());
        RequestMatcher postempresaMatcher = new AntPathRequestMatcher("/empresa/**", HttpMethod.POST.name());
        RequestMatcher putempresaMatcher = new AntPathRequestMatcher("/empresa/**", HttpMethod.PUT.name());
        RequestMatcher deleteempresaMatcher = new AntPathRequestMatcher("/empresa/**", HttpMethod.DELETE.name());

        RequestMatcher estudianteRequestsMatcher = new AntPathRequestMatcher("/estudiante/**");

        http.authorizeRequests().requestMatchers(authPathMatcher).permitAll();

        http.authorizeRequests().requestMatchers(getofertasMatcher).hasAuthority(UserAuthority.READ.toString());
        http.authorizeRequests().requestMatchers(postofertasMatcher).hasAuthority(UserAuthority.WRITE.name());
        http.authorizeRequests().requestMatchers(putofertasMatcher).hasAuthority(UserAuthority.WRITE.name());
        http.authorizeRequests().requestMatchers(deleteofertasMatcher).hasAuthority(UserAuthority.WRITE.name());

        http.authorizeRequests().requestMatchers(getempresaMatcher).hasAuthority(UserAuthority.READ.toString());
        http.authorizeRequests().requestMatchers(postempresaMatcher).hasAuthority(UserAuthority.WRITE.name());
        http.authorizeRequests().requestMatchers(putempresaMatcher).hasAuthority(UserAuthority.WRITE.name());
        http.authorizeRequests().requestMatchers(deleteempresaMatcher).hasAuthority(UserAuthority.WRITE.name());

        http.authorizeRequests().requestMatchers(estudianteRequestsMatcher).hasAuthority(UserAuthority.READ.name());

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
