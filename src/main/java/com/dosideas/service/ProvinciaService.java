package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.Collection;

public interface ProvinciaService {
    Provincia buscarPorId(long id);
    Collection<Provincia> buscarPorNombreExacto(String nombre);
    Collection<Provincia> buscarPorNombreContiene(String nombre);
    Collection<Provincia> buscarPorNombrePaisContiene(String nombre);
}
