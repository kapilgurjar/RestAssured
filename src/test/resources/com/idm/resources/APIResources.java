package com.idm.resources;

public enum APIResources {
	
	AddPlaceAPI("api/v1/Authors/authors/books/{id}"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
