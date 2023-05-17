package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.exemplary.dto.ExemplaryCreateDTO;
import com.app.bookstore.exemplary.dto.ExemplaryGetDTO;
import com.app.bookstore.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {
	
	@Autowired
	private ExemplaryMapper exemplaryMapper;
	
	@Autowired
	private ExemplaryService exemplaryService;
	
	@PostMapping()
	public ResponseEntity<ExemplaryGetDTO> create(@RequestBody ExemplaryCreateDTO exemplaryCreateDTO){
		Exemplary exemplary = exemplaryService.create(exemplaryMapper.exemplaryCreateDTO2Exemplary(exemplaryCreateDTO), exemplaryCreateDTO.getBookId());
		return new ResponseEntity<>(exemplaryMapper.exemplary2ExemplaryGetDTO(exemplary),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ExemplaryGetDTO findById(@PathVariable Integer id) {
		Exemplary exemplary = exemplaryService.findById(id);
		return exemplaryMapper.exemplary2ExemplaryGetDTO(exemplary);
	}
	
	@GetMapping("/list")
	public List<ExemplaryGetDTO> findAll() {
		return exemplaryMapper.exemplaryList2ExemplaryGetDTOList(exemplaryService.findAll());
	}
	
	@PutMapping("/{id}")
	public ExemplaryGetDTO updateExemplary(@RequestBody ExemplaryCreateDTO exemplaryCreateDTO, @PathVariable Integer id) {
		Exemplary exemplary = exemplaryMapper.exemplaryCreateDTO2Exemplary(exemplaryCreateDTO);
		Exemplary exemplaryUpdate = exemplaryService.update(exemplary, id);
		return exemplaryMapper.exemplary2ExemplaryGetDTO(exemplaryUpdate);
	}
	
	@DeleteMapping("/{id}")
	public void deleteExemplary(@PathVariable Integer id) {
		exemplaryService.delete(id);
	}

}
