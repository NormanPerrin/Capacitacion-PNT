package com.dosideas.service.impl;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {
    
    @Autowired
    private ProvinciaRepository provinciaRepository;
    
    @Override
    public Provincia buscarPorId(long id) {
        return provinciaRepository.findOne(id);
    }

    @Override
    public Collection<Provincia> buscarPorNombreExacto(String nombre) {
        if (nombre == null || nombre.length() < 3) {
            throw new NombreInvalidoException();
        }
        
        return provinciaRepository.findByNombreIgnoreCase(nombre);
    }

    @Override
    public Collection<Provincia> buscarPorNombreContiene(String nombre) {
        if (nombre == null) {
            throw new NombreInvalidoException();
        }
        
        return provinciaRepository.findByNombreContaining(nombre);
    }

    @Override
    public Collection<Provincia> buscarPorNombrePaisContiene(String nombre) {
        if (nombre == null) {
            throw new NombreInvalidoException();
        }
                
        return provinciaRepository.findByPaisNombreContaining(nombre);
    }
    
    

}
