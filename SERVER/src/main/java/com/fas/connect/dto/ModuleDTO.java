package com.fas.connect.dto;


import com.fas.connect.entities.ModuleName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModuleDTO {
	private Long id;
	private ModuleName moduleName;
	private String description;
	
	
}
