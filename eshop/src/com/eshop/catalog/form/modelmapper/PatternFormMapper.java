package com.eshop.catalog.form.modelmapper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.catalog.form.PatternForm;
import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.service.PatternService;

@Component("patternFormMapper")
public class PatternFormMapper implements FormModelMapper<PatternForm, Pattern> {

	@Inject
	private PatternService patternService;

	@Override
	public PatternForm mapModelToForm(Pattern model) {
		PatternForm form = new PatternForm(model.getName(), model.getBrand(), model.getDescription(), model.getWarranty(),
				model.getImportantNotes(), model.getImages());
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		return form;
	}

	@Override
	public Pattern mapFormToNewModel(PatternForm form) {
		Pattern model = new Pattern(form.getName(), form.getBrand(), form.getDescription(), form.getWarranty(), form.getImportantNotes(),
				form.getImages());
		return model;
	}

	@Override
	public Pattern mapFormToExistingModel(PatternForm form) {
		Pattern model = patternService.getPatternById(form.getId());
		model.setVersion(form.getVersion());
		model.setDescription(form.getDescription());
		model.setImportantNotes(form.getImportantNotes());
		model.setWarranty(form.getWarranty());
		model.setImages(form.getImages());
		return model;
	}

}
