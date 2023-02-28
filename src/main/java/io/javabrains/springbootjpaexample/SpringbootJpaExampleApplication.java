package io.javabrains.springbootjpaexample;

import io.javabrains.springbootjpaexample.models.Employee;
import io.javabrains.springbootjpaexample.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootJpaExampleApplication {

    //For reading and writing
/*    @PersistenceUnit
    private EntityManagerFactory emf;*/

    //Only for reading
/*    @PersistenceContext
    private EntityManager entityManager;*/

    final
    EmployeeRepository employeeRepository;

    public SpringbootJpaExampleApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaExampleApplication.class, args);
    }

    @PostConstruct
    @Transactional(readOnly = true)
    public void start() {
        Employee e = new Employee();
        e.setAge(34);
        e.setName("Vitor Silva");
        e.setSsn("1234");
        e.setDob(new Date());

        Optional<Employee> employee = employeeRepository.findById(1);
        if (employee.isPresent()) {
            System.out.println(employee.get());
            updateEmployee(employee.get());
            //updateEmployeeAndAccessCard(employee.get());
        }

//        EntityManager entityManager = emf.createEntityManager();
/*        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(e);
        transaction.commit();
        //entityManager.close();*/

/*        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println(employee);*/
    }

    @Transactional
    void updateEmployeeAndAccessCard(Employee e){
        //employeeRepository.save(e);
        updateEmployee(e);
        //accessCarRepository.save(a);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    void updateEmployee(Employee employee) {
        employee.setName("Updated name 2");
        // get Transaction object
        // start transaction
        employeeRepository.save(employee);
        // end transaction
        // handle rollback
    }

}
