package proyect.service;

import proyect.bean.*;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> buscarTodas();

    Optional<Empresa> buscarPorId(Long id);

    List<Empresa> buscarEmpresasPorNombre(String nombre);

    Optional<Empresa> buscarPorNombre(String nombre);

    List<Empresa> buscarEmpresasPorTipo(String tipo);

    Optional<Empresa> buscarPorCorreoElectronico(String correoElectronico);

    List<Empresa> buscarEmpresasPorRangoDeEmpleados(int minEmpleados, int maxEmpleados);

    List<Empresa> buscarEmpresasPorCorreoElectronico(String correoElectronico);

    void eliminarPorId(@PathVariable Long id);

    Empresa guardar(Empresa nuevaEmpresa);

    Empresa reemplazarEmpresa(Empresa nuevaEmpresa, Long id);
}
