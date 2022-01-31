package com.css862.product.catalog.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductData {

	@SerializedName("product_name")
	@Expose
	private String productName;
	
	@Expose
	private Integer limit = 25;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "ProductData [productName=" + productName + ", limit=" + limit + "]";
	}
	
}
