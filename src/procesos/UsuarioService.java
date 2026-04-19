package procesos;
import java.util.ArrayList;
import modelos.Usuario;

public class UsuarioService {
	private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public Usuario buscarPorId(long id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}
