package com.practice.firstjobapp.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies(){
		return new ResponseEntity<List<Company>>(companyService.getAllCompanies(), HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		Company company = companyService.getCompanyById(id);
		if(company != null) {
			return new ResponseEntity<Company>(companyService.getCompanyById(id), HttpStatus.OK);
		}
		return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		
	}

	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		companyService.createCompanies(company);
		return new ResponseEntity<String>("Company Created Successfully", HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
		boolean isUpdated = companyService.updateComapny(id, company);
		if(isUpdated) {
			return new ResponseEntity<String>("Company updated Successfully", HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id){
		boolean isDeleted = companyService.deleteCompanyById(id);
		if(isDeleted) {
			return new ResponseEntity<String>("Company Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
