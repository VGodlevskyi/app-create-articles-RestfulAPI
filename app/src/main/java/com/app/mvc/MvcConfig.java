package com.app.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        String[][] mappings = {
                //  mapping     file name in `resources/templates` folder `.html`
                {"/"      , "menu" },
                {"/home"  , "home" },
                {"/articles/statistic"  , "statistic" },
                {"/articles/all" , "articles"},
        };

        for (String[] item: mappings) {
            registry.addViewController(item[0]).setViewName(item[1]);
        }
    }


}
