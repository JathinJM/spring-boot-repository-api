package springbootrestapi.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
/*import java.util.Collection;*/
import java.util.List;/*
						import java.util.Set;*/
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootrestapi.model.Employee;
import springbootrestapi.model.Role;
import springbootrestapi.repository.EmployeeRepository;
import springbootrestapi.repository.RoleRepository;

@Service
@Transactional
public class EmployeeDao {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Autowired
	public RoleRepository roleRepository;

	public String create(Employee data) {
		Employee user = employeeRepository.save(data);
		Role role = new Role();
		
		List<Role> list = new ArrayList<Role>();
		data.getRole().forEach(item -> {
			role.setName(item.getName());
			role.setEmployee(user);
			list.add(roleRepository.save(role));
		});
		
		return "Sucess";

	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();

	}
	
	public List<Object> getAllQuery() {
	return employeeRepository.getAllEmployeesDetails();
	}
	
	public Object getAllEmployeesDetailsByName() {
		return employeeRepository.getAllEmployeesDetailsByName();
	}
	
	
	public Employee getById(Long id) {
		return employeeRepository.findOne(id);

	}

	public void delete(Employee data) {
		employeeRepository.delete(data);

	}

	/*
	 * public Collection<Employee> getAllEmployeeDetails(){ return
	 * employeeRepository.getAllEmployeesDetails(); }
	 */

}
