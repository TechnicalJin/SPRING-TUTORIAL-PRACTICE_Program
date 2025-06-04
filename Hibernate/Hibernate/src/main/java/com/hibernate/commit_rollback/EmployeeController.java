/*
package com.hibernate.commit_rollback;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveEmployee(employee);
            return "Employee saved successfully!";
        } catch (Exception e) {
            return "Transaction Failed: " + e.getMessage();
        }
    }
}
*/
