package com.ibm.academia.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.academia.apirest.models.entities.GeolocalizacionDTO;

//import lombok.extern.log4j.Log4j2;

//@Log4j2
@RestController
@RequestMapping("/sucursal")
public class Controller 
{	
	@Autowired
	private  RestTemplate restTemplate;
	
	@GetMapping("/lista")
	public String getSucursales()
	{
		String url = "https://www.banamex.com/localizador/jsonP/json5.json";		
		
		try{
				String geolocalizacion = restTemplate.getForObject(url, String.class);
				geolocalizacion = geolocalizacion.substring(geolocalizacion.indexOf("(") + 1, geolocalizacion.lastIndexOf(")"));			
				ObjectMapper mapper = new ObjectMapper();			
				GeolocalizacionDTO geolocalizacionDTO = mapper.readValue(geolocalizacion, GeolocalizacionDTO.class);
				List<String> lista = geolocalizacionDTO.getServicios().get("100").get("0").get("2");
			 	lista.forEach(System.out::println);
				//log.info(lista);
				
		    }catch (Exception e) {
				e.getMessage();				
			}	
		     
		return " ";
	}
}
