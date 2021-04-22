package jpa.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpa.entidad.Usuario;

public class UsuarioDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();

    public void guardar(Usuario usuario) {
        em.getTransaction().begin();
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        return usuario;
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre", Usuario.class).setParameter("nombre", nombre).getResultList();
        return usuarios;
    }

    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = em.createQuery("SELECT DISTINCT u FROM Usuario u LEFT JOIN FETCH u.mascotas", Usuario.class).getResultList();
        return usuarios;
    }

}
