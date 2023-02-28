package io.javabrains;

import javax.persistence.*;
import java.util.List;

public class jpaJPQLExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

/*        int minAge = 25;
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e where e.age > :minAge", Employee.class);

        query.setParameter("minAge", minAge);//prevents SQL Injection*/

        TypedQuery<Employee> query = entityManager.createNamedQuery("emp name asc", Employee.class);
        query.setParameter("age", 25);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e));

        entityManager.close();
        entityManagerFactory.close();

    }
}
