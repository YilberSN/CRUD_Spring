package com.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Servicios {
	
	@Autowired
	private DispositivoRepositorio repo;
	
	public List<Dispositivo> listar(){
		return repo.findAll();
	}
	
	public void guardar(Dispositivo dispo) {
		repo.save(dispo);
	}
	
	public Dispositivo buscar(long id) {
		return repo.findById(id).get();
	}
	
	public void borrar(long id) {
		repo.deleteById(id);
	}
	
}
