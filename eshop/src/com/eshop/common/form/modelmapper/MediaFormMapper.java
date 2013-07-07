package com.eshop.common.form.modelmapper;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.common.form.MediaForm;
import com.eshop.common.model.Media;

public class MediaFormMapper implements FormModelMapper<MediaForm, Media>{

	@Override
	public MediaForm mapModelToForm(Media model) {
		return null;
	}

	@Override
	public Media mapFormToNewModel(MediaForm form) {
		return null;
	}

	@Override
	public Media mapFormToExistingModel(MediaForm form) {
		// TODO Auto-generated method stub
		return null;
	}

}
