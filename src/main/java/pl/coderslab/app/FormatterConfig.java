package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderslab.converter.CommentConverter;
import pl.coderslab.converter.DateTimeConverter;
import pl.coderslab.converter.TweetConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class FormatterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
        registry.addConverter(tweetConverter());
        registry.addConverter(commentConverter());
    }

    @Bean
    public DateTimeConverter dateConverter(){
        return new DateTimeConverter();
    }

    @Bean
    public TweetConverter tweetConverter(){
        return new TweetConverter();
    }

    @Bean
    public CommentConverter commentConverter(){
        return new CommentConverter();
    }

}
