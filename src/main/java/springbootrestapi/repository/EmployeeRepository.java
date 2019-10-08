package springbootrestapi.repository;
/*import java.util.Collection;
import java.util.Set;*/


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/*import org.springframework.data.jpa.repository.Query;*/
import org.springframework.stereotype.Repository;
import springbootrestapi.model.*;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


	  String Q_GET_ALL_EMP = "SELECT u.id,u.name,u.skills,u.designation FROM Employee u WHERE u.name = 'Jathin'";  
	  @Query(Q_GET_ALL_EMP) Object getAllEmployeesDetailsByName();
 
	  @Query(value= "select id,name,skills,designation from employees where id in (select emp_id from role)", nativeQuery = true)
	  List<Object> getAllEmployeesDetails();

}
