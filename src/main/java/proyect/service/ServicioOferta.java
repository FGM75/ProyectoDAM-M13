package proyect.service;

import org.springframework.http.ResponseEntity;
import proyect.bean.*;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

public interface ServicioOferta {
    List<Oferta> buscarTodas();
    Optional<Oferta> buscarPorId(Long id);

    Oferta obtenerUnaOferta(Long id);

    List<Oferta> obtenerOfertasPorIdEmpresa(Long id);

    Optional<Oferta> obtenerOfertaPorEmpresa(Long idEmpresa, Long idOferta);

    ResponseEntity<Oferta> crearOfertaParaEmpresa(Oferta oferta, Long idEmpresa);

    Oferta actualizarOferta(Long id, Oferta nuevaOferta) throws AccountNotFoundException;

    void eliminarOferta(Long idEmpresa, Long idOferta);

    List<Oferta> obtenerTodasLasOfertas();
}
