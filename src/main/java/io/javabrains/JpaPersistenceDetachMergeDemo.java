package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

//docker run -p3306:3306 --name mysql_container -e MYSQL_ROOT_PASSWORD=dev12345 -d mysql:8.0.30
public class JpaPersistenceDetachMergeDemo {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("new Employee");
        employee1.setSsn("12345");
        employee1.setDob(new Date());
        employee1.setAge(25);
        employee1.setType(EmployeeType.FULL_TIME);
        //Until here the object is in a "Transient state"

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee1);// when we do a .persist the state change to "Managed state"
        employee1.setAge(45);
        entityManager.flush();
        entityManager.detach(employee1);
        //entityManager.clear(); //like detach all the entities in the managed state
        debugEmployee(employee1);

        Employee managedEmployee = entityManager.find(Employee.class, 1);

        managedEmployee.setAge(25);
        managedEmployee.setDob(null);

        //entityManager.detach(managedEmployee);
        entityManager.refresh(managedEmployee);

/*        fixEmployee(employee1);

        entityManager.merge(employee1);*/

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void fixEmployee(Employee employee){
        employee.setAge(50);
    }

    private static void debugEmployee(Employee employee){
        employee.setAge(100);
        employee.setSsn("9999");
    }
}
