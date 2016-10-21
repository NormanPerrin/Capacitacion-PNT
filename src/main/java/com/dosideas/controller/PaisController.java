package com.dosideas.controller;

import com.dosideas.domain.Pais;
import com.dosideas.service.PaisService;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaisController {

    @Autowired
    private PaisService paisService;
    
    @Autowired
    private ProvinciaService provinciaService;
    
    
    @RequestMapping("/paises")
    public String paises(Model model) {
        model.addAttribute("paises", paisService.buscarTodos());
        return "pais";
    }
    
    @RequestMapping("/paises/{id}/provincias")
    public String provincias(@PathVariable("id") Long id, Model model) {
        Pais pais = paisService.buscarPorId(id);
        if (pais == null) {
            model.addAttribute("error", "Id no encontrado");
            return "error";
        }
        
        model.addAttribute("pais", pais);
        model.addAttribute("provincias", provinciaService.buscarProvinciasPorPaisId(id));
        return "provincias";
    }
    
    public void agregarProvincia() {
        // TODO
    }

}
