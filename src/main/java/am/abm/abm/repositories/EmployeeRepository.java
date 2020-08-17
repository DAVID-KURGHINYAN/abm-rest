package am.abm.abm.repositories;

import am.abm.abm.models.enities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
    List<Employee> findAllByLastNameAndFirstName(String lastName, String firstName);

    List<Employee> findAllByLastNameOrFirstName(String lastName, String firstName);
}
