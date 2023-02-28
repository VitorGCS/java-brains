package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Fetch data from DB
        Employee employee = entityManager.find(Employee.class, 1);

        //Delete the data
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee); // entity goes from the Managed state to the "Remove state"
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}
