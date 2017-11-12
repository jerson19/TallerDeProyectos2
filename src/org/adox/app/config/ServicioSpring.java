package org.adox.app.config;

import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import org.adox.app.common.ConstantesApp;
import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServicioSpring {

    private ApplicationContext appContext = null;
    private EntityManagerFactory emf = null;
    static Logger oClass = Logger.getLogger("ServicioSpring");

    public ServicioSpring() {
        init();
    }

    private void init() {
        try {
            appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
            //LogsUtil.Show(oClass, " Spring init ::: " + appContext.getDisplayName() + " ::: Exito!!!");
        } catch (Exception e) {
            LogsUtil.Msg(oClass, "El Modulo de Seguridad a Fallado en Inicializar ", "Atencion", JOptionPane.ERROR_MESSAGE);
            LogsUtil.LogsApp(oClass, " El Modulo de Seguridad a Fallado en Inicializar !!! " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        }
    }

    public Object getBean(String beanName) {
        Object objBean = null;
        try {
            objBean = appContext.getBean(beanName);
            //LogsUtil.Show(oClass, " Spring getBean ::: " + appContext.getBean(beanName) + " ::: Success!!!");
        } catch (Exception e) {
            LogsUtil.Msg(oClass, "El Modulo de Seguridad esta con Errores", "Atencion", JOptionPane.ERROR_MESSAGE);
            LogsUtil.LogsApp(oClass, " Spring ::: Fallo Obteniendo el Bean !!! "+ beanName+ " - " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            System.exit(0);
        }
        return objBean;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        emf = (EntityManagerFactory) appContext.getBean("entityManagerFactory", EntityManagerFactory.class);
        return emf;
    }
}
