package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.impl.ProvinciaServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class ProvicinciaServiceTest {
    
    private ProvinciaService service;
    
    @Before 
    public void setup() {
        service = new ProvinciaServiceImpl(new ProvinciaRepositoryImpl());
    }

    @Test
    public void buscarPorId_idExistente_retornaProvinciaSolicitada() {
        Provincia provincia = service.buscarPorId(4L);

        assertEquals(4, provincia.getId());
        assertEquals("PROVINCIA 4", provincia.getNombre());
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorId_idNull_lanzarExcepcion() {
        service.buscarPorId(null);
    }

    @Test
    public void buscarPorId_idInexistente_retornaNull() {
        Provincia provincia = service.buscarPorId(5L);

        assertNull(provincia);
    }
}
