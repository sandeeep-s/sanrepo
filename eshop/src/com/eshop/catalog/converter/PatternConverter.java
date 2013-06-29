package com.eshop.catalog.converter;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.core.convert.converter.Converter;

import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.service.PatternService;

public class PatternConverter implements Converter<String, Pattern> {

	@Inject
	@Named("patternService")
	private PatternService patternService;

	public PatternService getPatternService() {
		return patternService;
	}

	public void setPatternService(PatternService patternService) {
		this.patternService = patternService;
	}

	@Override
	public Pattern convert(String id) {
		if ("-1".equals(id)){
			return null;
		}
		return patternService.getPatternById(Long.valueOf(id));
	}

}
