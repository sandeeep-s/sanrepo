package com.eshop.base.form.modelmapper;

import com.eshop.base.form.BaseForm;
import com.eshop.base.model.EntityBase;

public interface FormModelMapper<Form extends BaseForm, Model extends EntityBase> {

	public Form mapModelToForm(Model model);
	
	public Model mapFormToNewModel(Form form);

	public Model mapFormToExistingModel(Form form);

}
