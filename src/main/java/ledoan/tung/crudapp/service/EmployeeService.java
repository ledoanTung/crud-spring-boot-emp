package ledoan.tung.crudapp.service;

import ledoan.tung.crudapp.model.Employee;
import ledoan.tung.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }
     public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
     }

     public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).get();
     }

     public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
     }
}
