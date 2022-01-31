package com.css862.product.catalog.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {
	
	@SerializedName("products")
	@Expose
	private String name;
	

	@SerializedName("description")
	@Expose
	private String description;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

}
