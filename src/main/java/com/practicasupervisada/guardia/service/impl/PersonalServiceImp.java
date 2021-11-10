package com.practicasupervisada.guardia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicasupervisada.guardia.dao.PersonalRepo;
import com.practicasupervisada.guardia.dominio.Personal;
import com.practicasupervisada.guardia.service.PersonalService;

@Service
public class PersonalServiceImp implements PersonalService {
	
	@Autowired
	private PersonalRepo personalRepo;
	
	@Override
	public Personal crearPersonal(Personal p) {
		return personalRepo.save(p);
	}

	@Override
	public List<Personal> getAllPersonal() {
		return personalRepo.findAll();
	}

	@Override
	public void eliminarPersonal(int idPersonal) {
		personalRepo.deleteById(idPersonal);	
	}

	@Override
	public Optional<Personal> findById(int idPersonal) {
		return personalRepo.findById(idPersonal);
	}

}
