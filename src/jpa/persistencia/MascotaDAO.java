package jpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpa.entidad.Mascota;

public class MascotaDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();

    public void guardar(Mascota mascota) {
        em.getTransaction().begin();
        try {
            em.persist(mascota);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

}
