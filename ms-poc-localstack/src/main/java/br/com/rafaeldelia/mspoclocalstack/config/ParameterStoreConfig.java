package br.com.rafaeldelia.mspoclocalstack.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * Config para recuperar a variável da AWS ou do yml.
 */
@Configuration
@Data
@EnableConfigurationProperties
public class ParameterStoreConfig {

	/**
	 * /config/{spring.application.name}_{spring.profiles}/ e o atributo concatenado
	 * para buscar esses parametros
	 */
	@Value("${helloWorld}")
	private String parametro;
}