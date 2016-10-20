package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    
    Collection<Provincia> findByNombreIgnoreCase(String nombre);
    Collection<Provincia> findByNombreContaining(String nombre);
    Collection<Provincia> findByPaisNombreContaining(String nombre);
}
