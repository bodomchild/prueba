package jpa;

import jpa.entidad.Usuario;
import jpa.persistencia.UsuarioDAO;

public class Main {

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNombre("Fer");
        dao.guardar(usuario);
        System.out.println(dao.buscarTodos());
    }

}
