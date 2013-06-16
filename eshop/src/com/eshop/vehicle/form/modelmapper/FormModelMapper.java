package com.eshop.vehicle.form.modelmapper;

public interface FormModelMapper<Form, Model> {

	public Form mapModelToForm(Model model);
	
	public Model mapFormToNewModel(Form form);

	public Model mapFormToExistingModel(Form form);

}
