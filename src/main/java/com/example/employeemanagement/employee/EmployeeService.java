package com.example.employeemanagement.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1L, "Nguyen Van A", "a@example.com"),
            new Employee(2L, "Tran Thi B", "b@example.com")
    ));
    private final AtomicLong nextId = new AtomicLong(3);

    public List<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

    public Optional<Employee> findById(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    public List<Employee> searchByName(String name) {
        if (name == null || name.isBlank()) {
            return findAll();
        }
        return employees.stream()
                .filter(employee -> employee.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public Employee create(EmployeeCreateRequest request) {
        Employee employee = new Employee(nextId.getAndIncrement(), request.name(), request.email());
        employees.add(employee);
        return employee;
    }
}
