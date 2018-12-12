package br.com.christian.customerregistration.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Configuration
@ApplicationScope
public class ModelMapperConfiguration {

    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        log.warn("Criando instância do ModelMapper");
        return modelMapper;
    }
}
