package com.julian.bella.api.dto;

import java.util.List;

public class UserListDto extends GenericListDto<UserDto> {

	public UserListDto(List<UserDto> list) {
		super(list);
	}
}
