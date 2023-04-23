package dev.pasha.restapi.controller;

import dev.pasha.restapi.exceptions.BadRequest;
import dev.pasha.restapi.exceptions.NotFound;
import dev.pasha.restapi.model.Employee;
import dev.pasha.restapi.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Employee> findAll() {
        return repo.findAll();
    }

    @GetMapping("{stringId}")
    public Employee getById(@PathVariable String stringId) {
        Integer id = tryParseInt(stringId);
        Optional<Employee> employee = repo.findById(id);
        if (employee.isEmpty())
            throw new NotFound();

        return employee.get();
    }

    @PostMapping
    public Employee create(@RequestBody Map.Entry<String, String> newEmployee) {
        return createOrUpDate(null, newEmployee);
    }

    @PutMapping("{stringId}")
    public Employee update(
            @PathVariable String stringId,
            @RequestBody Map.Entry<String, String> newData
    ) {
        Integer id = tryParseInt(stringId);
        if (repo.findById(id).isEmpty())
            throw new NotFound();

        return createOrUpDate(id, newData);
    }

    @DeleteMapping("{stringId}")
    public void delete(@PathVariable String stringId) {
        Integer id = tryParseInt(stringId);
        if (repo.findById(id).isEmpty())
            throw new NotFound();

        repo.deleteById(id);
    }

    private int tryParseInt(String stringInt) {
        try {
            return Integer.parseInt(stringInt);
        } catch (NumberFormatException e) {
            throw new BadRequest();
        }
    }

    private Employee createOrUpDate(Integer id, Map.Entry<String, String> data) {
        String name = data.getKey();
        String role = data.getValue();
        return repo.save(new Employee(id, name, role));
    }
}
