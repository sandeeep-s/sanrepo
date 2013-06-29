package com.eshop.base.form;

import java.io.Serializable;

public abstract class BaseForm implements Serializable {

	private Long id;

	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
