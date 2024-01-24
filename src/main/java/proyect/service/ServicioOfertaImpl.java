package proyect.service;

import proyect.bean.*;
import proyect.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.el.MethodNotFoundException;

import java.nio.channels.NotYetConnectedException;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class ServicioOfertaImpl implements ServicioOferta {

    private final OfertaRepository ofertaRepository;
    private final EmpresaRepository empresaRepository;

    public ServicioOfertaImpl(OfertaRepository ofertaRepository, EmpresaRepository empresaRepository) {
        this.ofertaRepository = ofertaRepository;
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Oferta> buscarTodas() {
        return ofertaRepository.findAll();
    }

    @Override
    public Optional<Oferta> buscarPorId(Long id) {
        return ofertaRepository.findById(id);
    }

    public List<Oferta> buscarTodasOfertas() {
        return ofertaRepository.findAll();
    }

    public Oferta obtenerUnaOferta(Long id) {
        return ofertaRepository.findById(id).orElseThrow();
    }

    public List<Oferta> obtenerOfertasPorIdEmpresa(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.map(Empresa::getOfertas).orElseThrow();
    }

    public Optional<Oferta> obtenerOfertaPorEmpresa(Long idEmpresa, Long idOferta) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        Optional<Oferta> oferta = ofertaRepository.findById(idOferta);

        if (empresa.isPresent() && oferta.isPresent() && empresa.get().getOfertas().contains(oferta.get())) {
            return oferta;
        } else {
            throw new NotYetConnectedException();
        }
    }

    public ResponseEntity<Oferta> crearOfertaParaEmpresa(Oferta oferta, Long idEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        if (empresa.isPresent()) {
            oferta.setEmpresa(empresa.get());
            Oferta nuevaOferta = ofertaRepository.save(oferta);
            return ResponseEntity.ok(nuevaOferta);
        } else {
            throw new MethodNotFoundException();
        }
    }
   

    public Oferta actualizarOferta(Long id, Oferta nuevaOferta) throws AccountNotFoundException {
        return ofertaRepository.findById(id)
                .map(oferta -> {
                    oferta.setTitulo(nuevaOferta.getTitulo());
                    oferta.setDescripcion(nuevaOferta.getDescripcion());
                    return ofertaRepository.save(oferta);
                })
                .orElseThrow(() -> new AccountNotFoundException());
    }

    @Transactional
    public void eliminarOferta(Long idEmpresa, Long idOferta) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        Optional<Oferta> oferta = ofertaRepository.findById(idOferta);

        if (empresa.isPresent() && oferta.isPresent() && empresa.get().getOfertas().contains(oferta.get())) {
            empresa.get().getOfertas().remove(oferta.get());
            ofertaRepository.deleteById(idOferta);
        } else {
            throw new NotYetConnectedException();
        }
    }

	@Override
	public List<Oferta> obtenerTodasLasOfertas() {
		// TODO Auto-generated method stub
		return null;
	}




}
