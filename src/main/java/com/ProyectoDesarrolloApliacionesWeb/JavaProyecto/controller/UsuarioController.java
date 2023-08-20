package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Gender;
import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Usuario;
import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository.GeneroRepository;
import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    
	public DataSource dataSource;
	public UsuarioRepository ur;
    public GeneroRepository gr;
	
	public UsuarioController(UsuarioRepository ur, DataSource dataSource, GeneroRepository gr) {
		this.gr = gr;
		this.dataSource = dataSource;
		this.ur = ur;
	}


	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("message", "Listado de usuarios de la empresa");
		model.addAttribute("style", "css/style.css");
		
		List<Usuario> lstUsuarios = ur.findAll();
		model.addAttribute("lstUsuarios", lstUsuarios);
		
		return "usuarios/index";
	}

	@GetMapping("/registerUsuario")
	public String frmRegisterUsuario(Model model) {
		model.addAttribute("title", "Registro de nuevo usuario");
		model.addAttribute("style", "../css/style.css");

		List<Gender> generos = gr.findAll(); 
		model.addAttribute("generos", generos);

		Usuario objUsu = new Usuario();
		model.addAttribute("objusu", objUsu);
		
		return "usuarios/registerUsuario";
	}
	
	@PostMapping("registerUsuario")
	public String registerUsuario(Usuario objUsu) {
		ur.save(objUsu);
		
		return "redirect:/usuarios";
	}
 
	@GetMapping("/frmUpdateUsuario/{id}")
	public String frmUpdateUsuario(@PathVariable Integer id, Model model) {
		model.addAttribute("title", "Actulizar Usuario");
		model.addAttribute("style", "../../css/style.css");
		
		Optional<Usuario> oUsu = ur.findById(id);
		
		if(oUsu.isEmpty()) return "404";
		
		Usuario objUsu = oUsu.get();
		model.addAttribute("objUsu", objUsu);
		
		return "usuarios/updateUsuario";
	}


	@PostMapping("updateUsuario/{id}")
	public String updateUsuario(@PathVariable Integer id, Usuario objUsuFrm) {
		Optional<Usuario> oUsu = ur.findById(id);
		
		if(oUsu.isEmpty()) return "404";
		
		Usuario objUsu = oUsu.get();
		objUsu.setNameuser(objUsuFrm.getNameuser());
		objUsu.setLastnameuser(objUsuFrm.getLastnameuser());
		objUsu.setPassworduser(objUsuFrm.getPassworduser());
		objUsu.setAddress(objUsuFrm.getAddress());
		//objPro.setCategory(objProFrm.getCategory());
		
		ur.save(objUsu);
		
		return "redirect:/usuarios";
	}
	 
	@GetMapping("deleteUsuario/{id}")
	public String deleteUsuario(@PathVariable Integer id) {
		ur.deleteById(id);
		
		return "redirect:/usuarios";
	}
 
	@GetMapping("downloadReporte")
	public void downloadReporte(HttpServletResponse response) throws SQLException {
		try {
			InputStream is = new ClassPathResource("reports/reportusuarios.jasper").getInputStream();
			JasperReport report = (JasperReport) JRLoader.loadObject(is);
			
			Connection connection = dataSource.getConnection();
			Map<String, Object> parameters = new HashMap<>();
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, connection);
			response.setContentType("application/pdf");
			OutputStream os = response.getOutputStream();
		
			JasperExportManager.exportReportToPdfStream(jasperPrint, os);
			
		} catch (IOException |JRException e) {
			e.printStackTrace();
		}
		

	}
}
