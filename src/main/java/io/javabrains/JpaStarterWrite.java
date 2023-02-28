package io.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

//docker run -p3306:3306 --name mysql_container -e MYSQL_ROOT_PASSWORD=dev12345 -d mysql:8.0.30
public class JpaStarterWrite {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Foo Bar");
        employee1.setSsn("123");
        employee1.setDob(new Date());
        employee1.setAge(20);
        employee1.setType(EmployeeType.CONTRACTOR);


        Employee employee2 = new Employee();
        employee2.setName("Baz Baz");
        employee2.setSsn("1234");
        employee2.setDob(new Date());
        employee2.setAge(30);
        employee2.setType(EmployeeType.FULL_TIME);

        AccessCard card1 = new AccessCard();
        card1.setIssuedDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0.0");
        card1.setOwner(employee1);
        employee1.setCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setOwner(employee2);
        employee2.setCard(card2);

        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setSalary(1000);
        payStub1.setEmployee(employee1);
        employee1.addPayStub(payStub1);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setSalary(2000);
        payStub2.setEmployee(employee1);
        employee1.addPayStub(payStub2);

        EmailGroup group1 = new EmailGroup();
        group1.setName("Company Watercooler discussions");
        group1.addMember(employee1);
        group1.addMember(employee2);
        employee1.addEmailSubscription(group1);
        employee2.addEmailSubscription(group1);

        EmailGroup group2 = new EmailGroup();
        group2.setName("Engineering");
        employee1.addEmailSubscription(group2);
        group2.addMember(employee1);

        employee1.setPayStubs(List.of(payStub1, payStub2));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee1);
        //entityManager.detach(employee1);// remove employee1 to the management state to the detach state
        //entityManager.merge(employee1); // merge the entity detached back to the management state

        entityManager.persist(employee2);

        entityManager.persist(card1);
        entityManager.persist(card2);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(group1);
        entityManager.persist(group2);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();


/*        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Employee employee2 = entityManager.find(Employee.class, 1);

        transaction.begin();    // any change to the database - create/update/delete must be done in a transaction
        entityManager.remove(employee2);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();


        System.out.println(employee2);*/


    }
}
