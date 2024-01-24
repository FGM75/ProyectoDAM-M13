package proyect.bean;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;


@Entity
public class Oferta<Estudiante> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1001", description = "Identificador numérico de la oferta, clave primaria")
    private Long id;

    @Schema(example = "Desarrollador Senior", description = "Título de la oferta")
    private String titulo;

    @Schema(example = "Descripción detallada del trabajo", description = "Descripción de la oferta")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @ManyToMany(mappedBy = "ofertas")
    @JsonIgnore
    private List<Estudiante> estudiantes;

    public Oferta(Long id, String titulo, String descripcion, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

    public Oferta(Long id, String titulo, String descripcion, Empresa empresa, List<Estudiante> estudiantes) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.estudiantes = estudiantes;
    }

    public Oferta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, descripcion, id, titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Oferta other = (Oferta) obj;
        return Objects.equals(empresa, other.empresa) && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
    }

    @Override
    public String toString() {
        return "Oferta [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", empresa=" + empresa
                + "]";
    }
}
