package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;

public class ProvinciaRepositoryImpl implements ProvinciaRepository {

    @Override
    public Provincia buscarPorId(Long id) {
        return existe(id) ? new Provincia(4, "PROVINCIA 4") : null;
    }

    private boolean existe(Long id) {
        return id == 4;
    }

}
