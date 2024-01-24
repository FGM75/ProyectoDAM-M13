package proyect.bean;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class RolEstudiante implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;

    private String contraseña;

    @Column(unique = true)
    private String correoElectronico;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<RolUsuario> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "estudiante_ofertas",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "oferta_id")
    )
    private List<Oferta> ofertas;

    public RolEstudiante() {
    }

    public RolEstudiante(Long id, String nombreUsuario, String contraseña, String correoElectronico, List<RolUsuario> roles, List<Oferta> ofertas) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.roles = roles;
        this.ofertas = ofertas;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (RolUsuario rol : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.toString()));
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.contraseña;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }
}
