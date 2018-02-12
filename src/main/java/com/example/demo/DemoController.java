package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoModel;
import com.example.demo.repository.DemoModelRepository;

@RestController
@RequestMapping("/DemoApp")
public class DemoController {
	
	@Autowired
	DemoModel demoModel;

	@Autowired
	DemoModelRepository demoModelRepository;

	@RequestMapping(value="/getName" , method= RequestMethod.GET)
	public ResponseEntity<DemoModel> getName() {
		demoModel.setName("Diksha");
		demoModel.setAge(26);
		return new ResponseEntity<DemoModel>(demoModel, HttpStatus.OK);
	}

	@RequestMapping(value="/getStudentName" , method= RequestMethod.GET)
	public ResponseEntity<List<DemoModel>> getStudentName() {
		List<DemoModel> aa = (List<DemoModel>)demoModelRepository.findAll();
		return new ResponseEntity<List<DemoModel>>(aa, HttpStatus.OK);
	}

}
