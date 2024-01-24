package proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.bean.Empresa;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findById(Long id);

    List<Empresa> findAll();

    List<Empresa> findByIdIn(List<Long> ids);

    Optional<Empresa> findByEmail(String email);

    List<Empresa> findByEmployeesIn(List<Integer> employees);

    List<Empresa> findCompaniesBySocialSecurityNumberOrderByNameDesc(String name);

    List<Empresa> findBySocialSecurityNumber(String SSN);

    Empresa findByName(String name);

    List<Empresa> findByEmployeesGreaterThan(int numberOfEmployees);

    List<Empresa> findByOwner(String ownerName);

    List<Empresa> findByNameContaining(String name);

    List<Empresa> findByEmployeesBetween(int minEmployees, int maxEmployees);

    List<Empresa> findByType(String type);

    @Query("SELECT c FROM Empresa c WHERE c.name LIKE %:name%")
    List<Empresa> findByNameLike(String name);

    List<Empresa> findByEmployeesLessThan(int maxEmployees);

    List<Empresa> findByTypeAndEmployeesBetween(String type, int minEmployees, int maxEmployees);

    List<Empresa> findByEmailOrPhoneNumber(String email, String phoneNumber);

    @Query("SELECT c FROM Empresa c WHERE c.name = :name AND c.type = :type")
    List<Empresa> findByNameAndType(String name, String type);

    @Query("SELECT c FROM Empresa c WHERE c.offers IS EMPTY")
    List<Empresa> findCompaniesWithoutOffers();
}
