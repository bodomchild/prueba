package jpa.servicio;

import java.util.Locale;
import java.util.Scanner;
import jpa.entidad.Usuario;
import jpa.persistencia.UsuarioDAO;

public class UsuarioServicio {

    private UsuarioDAO dao = new UsuarioDAO();

    public void crearUsuario() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        System.out.print("Ingrese nombre: > ");
        String nombre = sc.next();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);

        dao.guardar(usuario);
    }

    public void mostrarUsuarios() {
        for (Usuario usuario : dao.buscarTodos()) {
            System.out.println(usuario);
        }
    }

    public void buscarPorNombre() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        System.out.print("Ingrese el nombre: > ");
        String nombre = sc.next();

        System.out.printf("Estos son los usuarios con nombre %s%n", nombre);
        for (Usuario usuario : dao.buscarPorNombre(nombre)) {
            System.out.println(usuario);
        }
    }

}
