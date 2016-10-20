package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvicinciaServiceTest {

    @Autowired
    private ProvinciaService service;

    @Test
    public void buscarPorId_idExistente_retornaProvinciaSolicitada() {
        System.out.println("------------------------------> " + service.getClass().getName());
        
        Provincia provincia = service.buscarPorId(4L);

        assertEquals(4, provincia.getId());
        assertEquals("Chaco", provincia.getNombre());
    }

    @Test
    public void buscarPorId_idInexistente_retornaNull() {
        Provincia provincia = service.buscarPorId(21L);

        assertNull(provincia);
    }

    @Test
    public void buscarPorNombreExacto_nombreExistente_retornaListaDeProvinciasConDichoNombre() {
        Collection<Provincia> provincias = service.buscarPorNombreExacto("Buenos Aires");

        assertTrue(provincias.size() > 0);
        assertTrue(provincias.stream().allMatch((provincia) -> provincia.getNombre().toLowerCase().equals("buenos aires")));
    }

    @Test
    public void buscarPorNombreExacto_nombreInexistente_retornaListaVacia() {
        Collection<Provincia> provincias = service.buscarPorNombreExacto("Zarasa");

        assertTrue(provincias.isEmpty());
    }

    @Test(expected = NombreInvalidoException.class)
    public void buscarPorNombreExacto_ingresandoNull_lanzaNombreInvalidoException() {
        service.buscarPorNombreExacto(null);
    }

    @Test(expected = NombreInvalidoException.class)
    public void buscarPorNombreExacto_nombreDeMenosDeTresCaracteres_lanzaNombreInvalidoException() {
        service.buscarPorNombreExacto("SA");
    }

    @Test
    public void buscarPorNombreContiene_ingresandoParteExistente_retornaListaDeProvinciasConDichaParte() {
        Collection<Provincia> provincias = service.buscarPorNombreContiene("Co");

        assertTrue(provincias.size() > 0);
        assertTrue(provincias.stream().allMatch((provincia) -> provincia.getNombre().contains("Co")));
    }

    @Test
    public void buscarPorNombreContiene_ingresandoParteInexistente_retornaListaVacia() {
        Collection<Provincia> provincias = service.buscarPorNombreContiene("Zarasa");

        assertTrue(provincias.isEmpty());
    }

    @Test(expected = NombreInvalidoException.class)
    public void buscarPorNombreContiene_ingresandoNull_lanzaNombreInvalidoException() {
        service.buscarPorNombreContiene(null);
    }
    
    @Test
    public void buscarPorNombrePais_paisExistenteConProvincias_listaProvincias() {
        Collection<Provincia> provincias = service.buscarPorNombrePaisContiene("Argen");
        
        assertTrue(provincias.stream().allMatch((provincia) -> provincia.getPais().getNombre().contains("Argen")));
    }
    
    @Test
    public void buscarPorNombrePais_paisExistenteSinProvincias_listaVacia() {
        Collection<Provincia> provincias = service.buscarPorNombrePaisContiene("Bra");
        
        assertTrue(provincias.isEmpty());
    }
    
    @Test
    public void buscarPorNombrePais_paisInexistente_listaVacia() {
        Collection<Provincia> provincias = service.buscarPorNombrePaisContiene("Bra");
        
        assertTrue(provincias.isEmpty());
    }
    
    @Test(expected = NombreInvalidoException.class)
    public void buscarPorNombrePais_conNull_lanzaNombreInvalidoException() {
        service.buscarPorNombrePaisContiene(null);
    }
    
    // FIX
    @Test
    public void grabarProvincia_provincia() {
        
    }
}
