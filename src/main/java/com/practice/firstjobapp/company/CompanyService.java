package com.practice.firstjobapp.company;

import java.util.List;


public interface CompanyService {

	List<Company> getAllCompanies();
	void createCompanies(Company company);
	Company getCompanyById(Long id);
	boolean deleteCompanyById(Long id);
	boolean updateComapny(Long id, Company updateCompamny); 
}
