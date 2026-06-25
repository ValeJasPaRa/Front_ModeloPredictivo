package pe.edu.upc.tp_backend.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp_backend.dtos.UsuarioPerfilDTO;
import pe.edu.upc.tp_backend.entities.Usuario;
import pe.edu.upc.tp_backend.repositories.IUsuarioRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IUsuarioService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioR;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<Usuario> list() { return usuarioR.findAll(); }


    @Override
    public void insert(Usuario usuario) {
        usuario.setPassword_usuario(passwordEncoder.encode(usuario.getPassword_usuario()));
        usuarioR.save(usuario);
    }


    @Override
    public Usuario listId(int id) { return usuarioR.findById(id).orElse(new Usuario()); }

  /* @Override
    public void update(Usuario usuario) {
        usuario.setPassword_usuario(passwordEncoder.encode(usuario.getPassword_usuario()));
        usuarioR.save(usuario);
    }*/

   //update con contraseña controlada si es que no hay cambio
    @Override
    public void update(Usuario usuario) {
        Usuario existe = usuarioR.findById(usuario.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Solo actualizamos los campos que el usuario puede editar
        existe.setNombre_usuario(usuario.getNombre_usuario());
        existe.setDni_usuario(usuario.getDni_usuario());
        existe.setCorreo_usuario(usuario.getCorreo_usuario());
        existe.setSexo_usuario(usuario.getSexo_usuario());
        existe.setTelefono_usuario(usuario.getTelefono_usuario());
        existe.setDireccion_usuario(usuario.getDireccion_usuario());

        // Rol y empresa — solo actualizamos si vienen en el DTO
        if (usuario.getId_rol() != null) {
            existe.setId_rol(usuario.getId_rol());
        }
        if (usuario.getIdEmpresa() != null) {
            existe.setIdEmpresa(usuario.getIdEmpresa());
        }

        // Contraseña — solo cambia si no es "NO_CHANGE"
        if (!"NO_CHANGE".equals(usuario.getPassword_usuario())) {
            existe.setPassword_usuario(
                    passwordEncoder.encode(usuario.getPassword_usuario())
            );
        }
        usuarioR.save(existe);
    }

    @Override
    public void delete(int id) { usuarioR.deleteById(id); }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioR.findByCorreo_usuario(email);
    }

    @Override
    public List<Usuario> BuscarUsuarioxNombre(String name) {
        return usuarioR.Buscaruserxname(name);
    }

    @Override
    public UsuarioPerfilDTO obtenerPerfil(String username) {
        Usuario u = usuarioR.findByUsernameConDetalle(username);
        if (u == null)
            throw new RuntimeException("Usuario no encontrado: " + username);

        UsuarioPerfilDTO dto = new UsuarioPerfilDTO();

        // Datos del usuario
        dto.setId_usuario(u.getId_usuario());
        dto.setNombre_usuario(u.getNombre_usuario());
        dto.setDni_usuario(u.getDni_usuario());
        dto.setCorreo_usuario(u.getCorreo_usuario());
        dto.setSexo_usuario(u.getSexo_usuario());
        dto.setTelefono_usuario(u.getTelefono_usuario());
        dto.setDireccion_usuario(u.getDireccion_usuario());
        dto.setFechaRegistro_usuario(u.getFechaRegistro_usuario());

        // Datos del Rol
        dto.setId_rol(u.getId_rol().getId_rol());
        dto.setTipo_rol(u.getId_rol().getTipo_rol());
        dto.setDescripcion_rol(u.getId_rol().getDescripcion_rol());

        // Datos de la Empresa
        dto.setId_empresa(u.getIdEmpresa().getIdEmpresa());
        dto.setNombre_empresa(u.getIdEmpresa().getName_empresa());
        dto.setRuc_empresa(u.getIdEmpresa().getRuc_empresa());
        dto.setSector_empresa(u.getIdEmpresa().getSector_empresa());

        return dto;
    }

    @Override
    public List<UsuarioPerfilDTO> listarPorEmpresa(int idEmpresa) {
        List<Usuario> usuarios = usuarioR.findByEmpresa(idEmpresa);
        return usuarios.stream().map(u -> {
            UsuarioPerfilDTO dto = new UsuarioPerfilDTO();
            dto.setId_usuario(u.getId_usuario());
            dto.setNombre_usuario(u.getNombre_usuario());
            dto.setDni_usuario(u.getDni_usuario());
            dto.setCorreo_usuario(u.getCorreo_usuario());
            dto.setSexo_usuario(u.getSexo_usuario());
            dto.setTelefono_usuario(u.getTelefono_usuario());
            dto.setDireccion_usuario(u.getDireccion_usuario());
            dto.setFechaRegistro_usuario(u.getFechaRegistro_usuario());
            dto.setId_rol(u.getId_rol().getId_rol());
            dto.setTipo_rol(u.getId_rol().getTipo_rol());
            dto.setId_empresa(u.getIdEmpresa().getIdEmpresa());
            dto.setNombre_empresa(u.getIdEmpresa().getName_empresa());
            return dto;
        }).collect(Collectors.toList());
    }
}
