import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        System.out.println(session.getProperties());
       /* DepartamentEntity departament = session.get(DepartamentEntity.class, "10");
        System.out.println("Dades del departament:");
        System.out.println(departament.getNumber() + " " + departament.getName() + " " + departament.getLocation());
        System.out.println("Número d'empleats al departament: " + departament.getEmpsByDeptno().size());
        System.out.println("Empleats del departament:");
        departament.getEmpsByDeptno().forEach(System.out::println);
        EmpleatEntity empleat = session.get(EmpleatEntity.class, "7788");
        System.out.println("Dades de l'empleat:");
        System.out.println(empleat);
        System.out.println("Dades del departament de l'empleat");
        System.out.println(empleat.getDeptByDeptno());*/
    }
}
