package com.css862.product.catalog.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductCatalogSearch {

	@SerializedName("product")
	@Expose
	private ProductData product;

	public ProductData getProduct() {
		return product;
	}

	public void setProduct(ProductData product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductCatalogSearch [product=" + product + "]";
	}

	
}
