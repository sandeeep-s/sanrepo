package com.eshop.vehicle.form.modelmapper;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

import com.eshop.base.form.modelmapper.FormModelMapper;
import com.eshop.common.form.MediaForm;
import com.eshop.common.model.Media;
import com.eshop.vehicle.form.VehicleMakeForm;
import com.eshop.vehicle.model.VehicleMake;
import com.eshop.vehicle.persistence.VehicleMakeDAO;

@Component("vehicleMakeFormMapper")
public class VehicleMakeFormMapper implements FormModelMapper<VehicleMakeForm, VehicleMake> {

	@Inject
	private VehicleMakeDAO vehicleMakeDAO;

	@Override
	public VehicleMakeForm mapModelToForm(VehicleMake model) {
		VehicleMakeForm form = new VehicleMakeForm();
		form.setId(model.getId());
		form.setVersion(model.getVersion());
		form.setName(model.getName());
		Media media = model.getLogoImage();
		MediaForm mediaForm = new MediaForm(media.getMediaType(), media.getMediaFileName(), media.getMediaName(), media.getMediaThumbnailFileName(), media.getMediaThumbnailFileName());
		form.setLogoImage(mediaForm);
		return form;
	}

	@Override
	public VehicleMake mapFormToNewModel(VehicleMakeForm form) {
		MediaForm mediaForm = form.getLogoImage();
		Media media = new Media(mediaForm.getMediaType(), mediaForm.getMediaFileName(), mediaForm.getMediaName(), mediaForm.getMediaThumbnailFileName(), mediaForm.getMediaThumbnailFileName());
		VehicleMake model = new VehicleMake(form.getName(), media);
		return model;
	}

	@Override
	public VehicleMake mapFormToExistingModel(VehicleMakeForm form) {
		MediaForm mediaForm = form.getLogoImage();
		Media media = new Media(mediaForm.getMediaType(), mediaForm.getMediaFileName(), mediaForm.getMediaName(), mediaForm.getMediaThumbnailFileName(), mediaForm.getMediaThumbnailFileName());
		VehicleMake model = vehicleMakeDAO.findById(form.getId());
		model.setVersion(form.getVersion());
		model.setLogoImage(media);
		return model;
	}

}
