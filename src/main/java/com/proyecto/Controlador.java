package com.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador{
	
	@Autowired
	private Servicios serv;
	
	@RequestMapping("/")
	public String vistaPrincipal(Model modelo) {
		List<Dispositivo> lista = serv.listar();
		modelo.addAttribute("lista", lista);
		return "index";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoProducto(Model modelo) {
		Dispositivo dispo = new Dispositivo();
		modelo.addAttribute("dispo", dispo);
		return "nuevo_dispositivo";
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String guardarDispositivo(@ModelAttribute("dispo") Dispositivo dispo) {
		serv.guardar(dispo);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView mostrarEdicion(@PathVariable(name="id") long id) {
		ModelAndView mav = new ModelAndView("editar_dispositivo");
		Dispositivo dispositivo = serv.buscar(id);
		mav.addObject("dispo", dispositivo);
		return mav;
	}
	
	@RequestMapping("/borrar/{id}")
	public String borrarDispositivo(@PathVariable(name="id") long id){
		serv.borrar(id);
		return "redirect:/";
	}
	
}
