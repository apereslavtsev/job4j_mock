package ru.job4j.site.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.job4j.site.handler.RestTemplateResponseErrorHandler;

/**
 * CheckDev пробное собеседование
 * WebConfig добавляем в WebConfigurer глобальный перехватчик запроса.
 *
 * @author Dmitry Stepanov
 * @version 24.09.2023 16:50
 */
@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final InterceptorSite interceptorSite;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorSite);
    }

    @Bean
    @Scope("prototype")
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
}
