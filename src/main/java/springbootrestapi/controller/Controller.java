package springbootrestapi.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import springbootrestapi.dao.EmployeeDao;
import springbootrestapi.model.Employee;

@RestController
@RequestMapping("/company")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class Controller {
	
	@Autowired
    EmployeeDao empDao;
    
	@ApiOperation(value = "Add a Employee")
    @PostMapping("/employees")
	public String create(@Valid @RequestBody Employee data) {
		return empDao.create(data);	
	}
	
	@ApiOperation(value = "Get all Employees")
    @GetMapping("/employees")
	public List<Employee> getAll() {
		return empDao.getAll();	
	}
	
	
	@ApiOperation(value = "Get all Employees on Condition")
    @GetMapping("/employees/all")
	public List<Object> getAllQuery() {
		return empDao.getAllQuery();	
	}
	
	
	@ApiOperation(value = "Get all Employees on Condition")
    @GetMapping("/employees/name")
	public Object getByName() {
		return empDao.getAllEmployeesDetailsByName();	
	}

    
	/*
	 * @GetMapping("/employees/all") public Collection<Employee>
	 * getAllEmployeeDetails() { return empDao.getAllEmployeeDetails(); }
	 */
	@ApiOperation(value = "Get Employee by Id")
    @GetMapping("/employees/{id}")
   	public ResponseEntity<Employee> getById(@PathVariable(name="id") Long id) {
   		if(empDao.getById(id) == null)	{
   			return ResponseEntity.notFound().build();
   		}
   		return ResponseEntity.ok(empDao.getById(id));
   	}
    
	@ApiOperation(value = "Update a Employee")
    @PutMapping("/employees/{id}")
   	public ResponseEntity<String> update(@PathVariable(name="id") Long id, @RequestBody Employee data) {  	
    	if(empDao.getById(id) == null) {
    		return ResponseEntity.notFound().build();
    	}
    	Employee emp = empDao.getById(id);
    	emp.setId(data.getId());
    	emp.setName(data.getName());
    	emp.setDesignation(data.getDesignation());
    	emp.setSkills(data.getSkills());
    	return ResponseEntity.ok(empDao.create(emp));
   	}
    
	@ApiOperation(value = "Delete a Employee")
    @DeleteMapping("/employees/{id}")
   	public ResponseEntity<Employee> delete(@PathVariable(name="id") Long id) {  	
    	if(empDao.getById(id) == null) {
    		return ResponseEntity.notFound().build();
    	}
    	Employee emp = empDao.getById(id);
    	empDao.delete(emp);
    	return ResponseEntity.ok().build();
   	}
}
