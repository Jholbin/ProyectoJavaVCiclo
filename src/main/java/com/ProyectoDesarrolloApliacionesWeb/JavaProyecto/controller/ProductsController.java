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
import org.springframework.web.bind.annotation.RequestParam;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Category;
import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Product;
import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository.ProductRepository;
import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository.categoryRepository;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	public ProductRepository pr;
	public DataSource dataSource;
	public categoryRepository cr;
	
	public ProductsController(ProductRepository pr, DataSource dataSource, categoryRepository cr) {
		this.pr = pr;
		this.dataSource = dataSource;
		this.cr = cr;
	}


	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("message", "Listado de productos de la empresa");
		model.addAttribute("style", "css/style.css");
		
		List<Product> lstProducts = pr.findAll();
		model.addAttribute("lstProducts", lstProducts);
		
		return "products/index";
	}

	@GetMapping("/registerProduct")
	public String frmRegisterProduct(Model model) {
		model.addAttribute("title", "Registro de nuevo producto");
		model.addAttribute("style", "../css/style.css");

		List<Category> categories = cr.findAll(); 
		model.addAttribute("categories", categories);

		Product objPro = new Product();
		model.addAttribute("objPro", objPro);
		
		return "products/registerProduct";
	}
	
	@PostMapping("registerProduct")
	public String registerEmployee(Product objPro) {
		pr.save(objPro);
		
		return "redirect:/products";
	}

	@GetMapping("/frmUpdateProduct/{id}")
	public String frmUpdateEmployee(@PathVariable Integer id, Model model) {
		model.addAttribute("title", "Actulizar producto");
		model.addAttribute("style", "../../css/style.css");
		
		Optional<Product> oPro = pr.findById(id);
		
		if(oPro.isEmpty()) return "404";
		
		Product objPro = oPro.get();
		model.addAttribute("objPro", objPro);
		
		return "products/updateProduct";
	}


	@PostMapping("updateProduct/{id}")
	public String updateEmployee(@PathVariable Integer id, Product objProFrm) {
		Optional<Product> oPro = pr.findById(id);
		
		if(oPro.isEmpty()) return "404";
		
		Product objPro = oPro.get();
		objPro.setName_product(objProFrm.getName_product());
		objPro.setDescription(objProFrm.getDescription());
		objPro.setUnit_price(objProFrm.getUnit_price());
		objPro.setStock(objProFrm.getStock());
		//objPro.setCategory(objProFrm.getCategory());
		
		pr.save(objPro);
		
		return "redirect:/products";
	}
	
	@GetMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		pr.deleteById(id);
		
		return "redirect:/products";
	}

	@GetMapping("/search")
	public String searchProducts(@RequestParam String nombre, Model model) {
    List<Product> products = pr.findByDescriptionContaining(nombre);
    model.addAttribute("products", products);
    return "products/searchResults";
	}

	@GetMapping("/searchcat")
	public String searchProductscat(@RequestParam String category, Model model) {

    List<Product> products = pr.findByCategoryDescriptionContaining(category);
	
    model.addAttribute("products", products);

    return "products/searchResultsCat";
	}

	@GetMapping("downloadReport")
	public void downloadReport(HttpServletResponse response) throws SQLException {
		try {
			InputStream is = new ClassPathResource("reports/reporteProductos.jasper").getInputStream();
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
