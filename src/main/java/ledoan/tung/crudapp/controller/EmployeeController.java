package ledoan.tung.crudapp.controller;

import ledoan.tung.crudapp.model.Employee;
import ledoan.tung.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> allEmployee(){
        List<Employee> employee = employeeService.findAllEmployee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee){
        Employee addEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
