package org.adox.app.config.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.adox.app.common.ConstantesApp;

public class _CFGConexionManager {

    private _CFGConexionManager serviceManager;
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantesApp.EntityManagerFactory);

    public _CFGConexionManager() {
        this.serviceManager = this;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void create(Object object) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Object object) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(object));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
