package com.julian.bella.api.dto;

import java.util.List;

public class GenericListDto <T> {

	private List<T> list;

	public GenericListDto(List<T> list) {
		this.list = list;
	}

	public List<T> getDtoList() {
		return list;
	}

	public void setDtoList(List<T> list) {
		this.list = list;
	}
}
