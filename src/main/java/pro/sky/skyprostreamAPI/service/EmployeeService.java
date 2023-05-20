package pro.sky.skyprostreamAPI.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprostreamAPI.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private static final int size = 10;
    private Employee [] employee = new Employee [size];

    EmployeeService () {
        employee[0] = new Employee("Василевская Варвара Алексеевна",2, 114_000);
        employee[1] = new Employee("Никифоров Павел Петрович",3, 47_000);
        employee[2] = new Employee("Дьячкова Кира Андреевна", 3, 265_000);
        employee[3] = new Employee("Рожков Савелий Матвеевич", 1, 151_000);
        employee[4] = new Employee("Шарова Полина Тимофеевна", 3, 139_000);
        employee[5] = new Employee("Панова Софья Петровна", 4, 158_000);
        employee[6] = new Employee("Петухов Руслан Аркадьевич", 1, 129_000);
        employee[7] = new Employee("Гурьев Тихон Антонович", 4, 83_000);
        employee[8] = new Employee("Богданова Диана Даниловна", 5, 258_000);
        employee[9] = new Employee("Смирнов Олег Тихонович", 3, 127_000);
    }
    public Employee getMax(int department) {
        return Arrays.stream(employee)
                .filter(e -> e!=null)
                .filter(e -> e.getDepartment == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Некорректное значение"));
    }

    public Employee getMin(int department) {
        return Arrays.stream(employee)
                .filter(e -> e!=null)
                .filter(e->e.getDepartment == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new IllegalArgumentException("Некорректное значение"));
    }

    public List<Employee> printAll(){
        return  Arrays.stream(employee)
                .filter(e -> e!=null)
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
    public List<Employee> printByDept(Integer id){
        return  Arrays.stream(employee)
                .filter(e -> e!=null)
                .filter(e->e.getDepartment == id)
                .collect(Collectors.toList());
    }


}