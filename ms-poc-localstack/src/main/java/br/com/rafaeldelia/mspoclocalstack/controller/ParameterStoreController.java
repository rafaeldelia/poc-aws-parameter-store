package br.com.rafaeldelia.mspoclocalstack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaeldelia.mspoclocalstack.config.ParameterStoreConfig;
import lombok.RequiredArgsConstructor;

/**
 * Controller para testes
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/parameter")
public class ParameterStoreController {

	private	final ParameterStoreConfig config;

	@GetMapping
	public String getConfiguration() {
		return config.getParametro();
	}
}