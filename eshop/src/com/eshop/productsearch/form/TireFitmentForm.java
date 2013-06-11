package com.eshop.productsearch.form;

import java.util.ArrayList;
import java.util.List;

import com.eshop.vehiclefitment.model.FitmentComponent;

public class TireFitmentForm {

	private List<TireFitmentComponentForm> fitmentComponentForms = new ArrayList<TireFitmentComponentForm>();

	public List<TireFitmentComponentForm> getFitmentComponentForms() {
		return fitmentComponentForms;
	}

	public void setFitmentComponentForms(List<TireFitmentComponentForm> fitmentComponentForms) {
		if (null == fitmentComponentForms) {
			return;
		}
		this.fitmentComponentForms = fitmentComponentForms;
	}

	public boolean equals(Object other) {
		if (null == other || !(other instanceof TireFitmentForm)) {
			return false;
		}

		if (this == other) {
			return true;
		}

		TireFitmentForm that = (TireFitmentForm) other;

		if (this.fitmentComponentForms.size() != that.fitmentComponentForms.size()) {
			return false;
		}

		if (this.fitmentComponentForms.containsAll(that.fitmentComponentForms)) {
			return true;
		}

		return false;
	}

	public int hashCode() {
		int result = 1;
		for (TireFitmentComponentForm tireFitmentComponentForm : fitmentComponentForms) {
			result += tireFitmentComponentForm.hashCode();
		}
		return result;
	}
}
