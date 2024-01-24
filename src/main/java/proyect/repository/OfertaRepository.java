package proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.bean.*;


public interface OfertaRepository extends JpaRepository <Oferta, Long> {
	
    Optional<Oferta> findById(Long id);
	void deleteById(Long id);

}
