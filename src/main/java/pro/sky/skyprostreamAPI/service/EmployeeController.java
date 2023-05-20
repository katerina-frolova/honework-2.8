package pro.sky.skyprostreamAPI.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprostreamAPI.model.Employee;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService service;
    EmployeeController(EmployeeService service){
        this.service = service;
    }
   @GetMapping("/max-salary")
    public Employee getMax(@RequestParam("departmentId") Integer id){
        return service.getMax(id);
   }
    @GetMapping("/min-salary")
    public Employee getMin(@RequestParam("departmentId") Integer id) {
        return service.getMin(id);
    }
    @GetMapping("/departments/all")
    public List<Employee> getEmployee (@RequestParam(value = "departmentId", required = false) Integer id){
        if (id==null){
            return service.printAll();
        }
        return service.printByDept(id);
    }


}
