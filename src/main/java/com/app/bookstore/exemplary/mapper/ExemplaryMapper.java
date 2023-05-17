package com.app.bookstore.exemplary.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.exemplary.Exemplary;
import com.app.bookstore.exemplary.dto.ExemplaryCreateDTO;
import com.app.bookstore.exemplary.dto.ExemplaryGetDTO;

@Component
public class ExemplaryMapper {
	
	public Exemplary exemplaryCreateDTO2Exemplary(ExemplaryCreateDTO exemplaryCreateDTO) {
		Exemplary exemplary = new Exemplary();
		exemplary.setPageNumber(exemplaryCreateDTO.getPageNumber());
		exemplary.setReleaseDate(exemplaryCreateDTO.getReleaseDate());
		exemplary.setStampCode(exemplaryCreateDTO.getStampCode());
		
		return exemplary;
	}
	
	public ExemplaryGetDTO exemplary2ExemplaryGetDTO(Exemplary exemplary) {
		
		ExemplaryGetDTO exemplaryGetDTO = new ExemplaryGetDTO();
		exemplaryGetDTO.setId(exemplary.getId());
		exemplaryGetDTO.setPageNumber(exemplary.getPageNumber());
		exemplaryGetDTO.setReleaseDate(exemplary.getReleaseDate());
		exemplaryGetDTO.setStampCode(exemplary.getStampCode());
		return exemplaryGetDTO;
	}
	
	public List<ExemplaryGetDTO> exemplaryList2ExemplaryGetDTOList(List<Exemplary> exemplaryList){
		return exemplaryList.stream()
				.map(exemplary -> exemplary2ExemplaryGetDTO(exemplary))
				.toList();
	}

}
