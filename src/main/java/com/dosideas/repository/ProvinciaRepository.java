package com.dosideas.repository;

import com.dosideas.domain.Provincia;

public interface ProvinciaRepository {
    
    Provincia buscarPorId(Long id);
    
}
