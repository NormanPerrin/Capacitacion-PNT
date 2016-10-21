package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
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
    
    @Autowired
    private PaisService servicePais;

    @Test
    public void buscarPorId_idExistente_retornaProvinciaSolicitada() {
        Provincia provincia = service.buscarPorId(4L);

        assertEquals(new Long(4), provincia.getId());
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

    @Test
    public void buscarProvinciasPorPaisId_conIdExistente_retornaListaProvinciasDelPais() {
        Collection<Provincia> provincias = service.buscarProvinciasPorPaisId(1L);
        
        assertEquals(20, provincias.size());
        assertTrue(provincias.stream().allMatch((provincia) -> provincia.getPais().getId() == 1L));
    }
    
    @Test
    public void buscarProvinciasPorPaisId_conIdInexistente_retornaListaVacia() {
        Collection<Provincia> provincias = service.buscarProvinciasPorPaisId(21L);
        
        assertTrue(provincias.isEmpty());
    }
    
    @Test
    public void grabarProvincia_provinciaValida_agregaProvincia() {
        Provincia provincia = new Provincia();
        provincia.setNombre("Tierra del fuego");
        provincia.setPais(servicePais.buscarPorId(1L));
        
        service.grabarProvincia(provincia);
        
        assertNotNull(service.buscarPorId(21L));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void grabarProvincia_provinciaCamposInvalidos_lanzaIllegalArgumentException() {
        Provincia provincia = new Provincia();
        provincia.setNombre(null);
        provincia.setPais(null);
        
        service.grabarProvincia(provincia);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void grabarProvincia_null_lanzaIllegalArgumentException() {
        service.grabarProvincia(null);
    }
}
