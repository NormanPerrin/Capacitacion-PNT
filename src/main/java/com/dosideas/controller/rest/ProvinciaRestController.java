package com.dosideas.controller.rest;

import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController {
    
    @Autowired
    private ProvinciaService provinciaService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Provincia buscarPorId(@PathVariable Long id) {
        return provinciaService.buscarPorId(id);
    }
    
}
