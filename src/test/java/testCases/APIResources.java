package testCases;

public enum APIResources {
	
		
		AddPlaceAPI("api/v1/Authors/authors/books/{id}"),
		getAuthors("/api/v1/Authors"),
		updateId("/api/v1/Authors/{id}"),
		DeleteBook("/api/v1/Books/{id}");
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
