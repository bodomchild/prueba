package jpa.servicio;

import java.util.Locale;
import java.util.Scanner;
import jpa.entidad.Mascota;
import jpa.entidad.Usuario;
import jpa.persistencia.MascotaDAO;
import jpa.persistencia.UsuarioDAO;

public class MascotaServicio {

    private MascotaDAO mascotaDao = new MascotaDAO();
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    public void crear() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        System.out.print("Ingrese nombre de la mascota: > ");
        String nombre = sc.next();

        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);

        System.out.print("Ingrese id del dueño: > ");
        Long idDueno = sc.nextLong();

        Usuario dueno = usuarioDao.buscarPorId(idDueno);

        mascota.setDueno(dueno);

        mascotaDao.guardar(mascota);
    }

}
