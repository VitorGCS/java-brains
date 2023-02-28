package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

/*        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println("#############################");
        System.out.println(employee.getName());
        System.out.println("#############################");
        System.out.println(employee.getCard());*/

/*        AccessCard card = entityManager.find(AccessCard.class,3);
        System.out.println(card.getOwner());*/

/*        PayStub payStub = entityManager.find(PayStub.class,6);
        System.out.println(payStub);*/

       /* System.out.println("*************** Before fetching Employee");
        Employee employee = entityManager.find(Employee.class,1);
        System.out.println("*************** Before accessing Paystubs");
        System.out.println(employee.getPayStubs());*/

        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 7); // object in a "Managed state"
        System.out.println("****** Got email group. Now accessing members  ******");
        System.out.println(emailGroup.getMembers());
    }
}
