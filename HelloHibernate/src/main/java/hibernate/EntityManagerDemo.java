package hibernate;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerDemo {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();

        Person person = new Person("Sidor", "Sidorov");

        // Добавляем
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        // Поиск
        em.getTransaction().begin();
        Person foundPerson = em.find(Person.class, 1);
        em.getTransaction().commit();
        System.out.println(foundPerson);

        // Изменение
        foundPerson.setLastname("Dmitrijevich");
        em.getTransaction().begin();
        em.merge(foundPerson);
        em.getTransaction().commit();

        // Удаление
        em.getTransaction().begin();
        Person removePerson = em.find(Person.class, 5);
        em.remove(removePerson);
        em.getTransaction().commit();
    }
}
