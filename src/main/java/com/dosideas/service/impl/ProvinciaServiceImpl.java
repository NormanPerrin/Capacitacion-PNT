package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;

public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository provinciaRepository;
    
    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }
    
    @Override
    public Provincia buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Null recibido");
        }
        return provinciaRepository.buscarPorId(id);
    }
}
