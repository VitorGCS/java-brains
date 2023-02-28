package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

//docker run -p3306:3306 --name mysql_container -e MYSQL_ROOT_PASSWORD=dev12345 -d mysql:8.0.30
public class JpaPersistenceContextDemo {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("new Employee");
        employee1.setSsn("12345");
        employee1.setDob(new Date());
        employee1.setAge(25);
        employee1.setType(EmployeeType.FULL_TIME);
        //Until here the object is in a "Transient state"

        System.out.println("*************************** Created Employee Instance");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        System.out.println("*************************** Starting transaction");

        entityManager.persist(employee1);// when we do a .persist the state change to "Managed state"
        System.out.println("*************************** After Persist method called");

        Employee employeeFound = entityManager.find(Employee.class, 1);
        System.out.println(employee1);
        System.out.println(employeeFound);

        //entityManager.flush(); // flush() => forces to write all the changes (in the managed area) to the DataBase
        transaction.commit();
        System.out.println("*************************** After transaction closed");
        entityManager.close();
        entityManagerFactory.close();
    }
}
