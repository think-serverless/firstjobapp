package com.practice.firstjobapp.company;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	CompanyRepository companyRepository;
	

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public void createCompanies(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	public boolean updateComapny(Long id, Company updateCompamny) {
		// TODO Auto-generated method stub
		Optional<Company> optionalComp = companyRepository.findById(id);
			if(optionalComp.isPresent()) {
				Company comp = optionalComp.get();
				comp.setDescription(updateCompamny.getDescription());
				comp.setName(updateCompamny.getName());
				companyRepository.save(comp);
				return true;
			}
		return false;
	}

}
