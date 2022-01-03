package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GeolocalizacionDTO implements Serializable
{
	 
	@JsonProperty(value = "Servicios")
	private HashMap<String, HashMap<String, HashMap<String, List<String>>>> servicios;
	
	private static final long serialVersionUID = -4474668175542683573L;
	
}
