package proyect.bean;


public enum RolUsuario {
    ROLE_READ("Rol de Lectura"),
    ROLE_WRITE("Rol de Escritura"), ;

    private final String descripcion;

    RolUsuario(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
