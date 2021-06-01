package library.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/index").setViewName("home"); 
            registry.addViewController("/showBooks").setViewName("showBooks");
            registry.addViewController("/register").setViewName("register");
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/ownPage").setViewName("ownPage");
	}

}
