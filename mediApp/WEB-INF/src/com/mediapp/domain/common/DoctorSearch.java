package com.mediapp.domain.common;

import java.util.List;

public class DoctorSearch  extends MediAppBaseDomain{

	private static final long serialVersionUID = 1110L;

	SearchCriteria searchCriteria;
	
	List <SearchResult> searchResult;

	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public List<SearchResult> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<SearchResult> searchResult) {
		this.searchResult = searchResult;
	}

		
}
