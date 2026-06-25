package pe.edu.upc.tp_backend.servicesinterfaces;

import pe.edu.upc.tp_backend.dtos.UsuarioDTO;
import pe.edu.upc.tp_backend.dtos.UsuarioPerfilDTO;
import pe.edu.upc.tp_backend.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> list();
    public void insert(Usuario usuario);
    public Usuario listId(int id);
    public void update(Usuario usuario);
    public void delete(int id);
    public Optional<Usuario> findByEmail(String email);
    public List<Usuario> BuscarUsuarioxNombre(String name);

    //agregado para vistas de la cuenta
    public UsuarioPerfilDTO obtenerPerfil(String username);

    List<UsuarioPerfilDTO> listarPorEmpresa(int idEmpresa);

}
