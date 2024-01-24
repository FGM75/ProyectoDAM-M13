package proyect.service;

import proyect.bean.*;
import proyect.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImple implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImple(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Empresa> buscarTodas() {
        return this.empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> buscarPorId(Long id) {
        return this.empresaRepository.findById(id).map(empresa -> {
            empresa.setNombre(empresa.getNombre().toUpperCase());
            return empresa;
        });
    }

    @Override
    public List<Empresa> buscarEmpresasPorNombre(String nombre) {
        return this.empresaRepository.findByNameContaining(nombre);
    }

    @Override
    public Optional<Empresa> buscarPorNombre(String nombre) {
        return Optional.ofNullable(this.empresaRepository.findByName(nombre));
    }

    @Override
    public List<Empresa> buscarEmpresasPorTipo(String tipo) {
        return this.empresaRepository.findByType(tipo);
    }

    @Override
    public Optional<Empresa> buscarPorCorreoElectronico(String correoElectronico) {
        return this.empresaRepository.findByEmail(correoElectronico);
    }

    @Override
    public List<Empresa> buscarEmpresasPorRangoDeEmpleados(int minEmpleados, int maxEmpleados) {
        return this.empresaRepository.findByEmployeesBetween(minEmpleados, maxEmpleados);
    }

    @Override
    public List<Empresa> buscarEmpresasPorCorreoElectronico(String correoElectronico) {
        return this.empresaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa guardar(Empresa nuevaEmpresa) {
        return empresaRepository.save(nuevaEmpresa);
    }

    @Override
    public Empresa reemplazarEmpresa(Empresa nuevaEmpresa, Long id) {
        return empresaRepository.findById(id).map(empresa -> {
            empresa.setNombre(nuevaEmpresa.getNombre());
            empresa.setEmpleados(nuevaEmpresa.getEmpleados());
            empresa.setNumeroSeguridadSocial(nuevaEmpresa.getNumeroSeguridadSocial());
            empresa.setPropietario(nuevaEmpresa.getPropietario());
            empresa.setDireccion(nuevaEmpresa.getDireccion());
            empresa.setNumeroTelefono(nuevaEmpresa.getNumeroTelefono());
            empresa.setCorreoElectronico(nuevaEmpresa.getCorreoElectronico());
            empresa.setTipo(nuevaEmpresa.getTipo());
            return empresaRepository.save(empresa);
        }).orElseGet(() -> {
            nuevaEmpresa.setId(id);
            return empresaRepository.save(nuevaEmpresa);
        });
    }


}
