package proyect.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPRESAS")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema
    private Long id;

    @Schema
    @Column(name = "nombre_empresa")
    private String nombre;

    @Schema
    @Column(name = "numero_empleados")
    private int empleados;

    @Schema
    @Column(name = "numero_seguridad_social", unique = true)
    private String numeroSeguridadSocial;

    @Schema
    @Column(name = "propietario")
    private String propietario;

    @Schema
    @Column(name = "direccion_empresa")
    private String direccion;

    @Schema
    @Column(name = "numero_telefono", unique = true)
    private String numeroTelefono;

    @Schema
    @Column(unique = true)
    private String correoElectronico;

    @Schema
    @Column(name = "tipo_empresa")
    private String tipo;

    @Schema
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Oferta> ofertas;

    public Empresa() {
    }

    public Empresa(Long id, String nombre, int empleados, String numeroSeguridadSocial, String propietario,
            String direccion, String numeroTelefono, String correoElectronico, String tipo, List<Oferta> ofertas) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.propietario = propietario;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
        this.tipo = tipo;
        this.ofertas = (ofertas != null) ? ofertas : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        if (empleados >= 0) {
            this.empleados = empleados;
        } else {
            throw new IllegalArgumentException("El número de empleados debe ser mayor o igual a cero.");
        }
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = (ofertas != null) ? ofertas : new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, correoElectronico, empleados, id, nombre, propietario, numeroTelefono,
                numeroSeguridadSocial, tipo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        return Objects.equals(direccion, other.direccion) && Objects.equals(correoElectronico, other.correoElectronico)
                && empleados == other.empleados && Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
                && Objects.equals(propietario, other.propietario) && Objects.equals(numeroTelefono, other.numeroTelefono)
                && Objects.equals(numeroSeguridadSocial, other.numeroSeguridadSocial) && Objects.equals(tipo, other.tipo);
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nombre=" + nombre + ", empleados=" + empleados + ", numeroSeguridadSocial="
                + numeroSeguridadSocial + ", propietario=" + propietario + ", direccion=" + direccion
                + ", numeroTelefono=" + numeroTelefono + ", correoElectronico=" + correoElectronico + ", tipo=" + tipo
                + "]";
    }
}
