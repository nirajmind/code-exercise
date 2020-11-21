package niraj.code.service;

import niraj.code.domain.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Employee}.
 */
public interface EmployeeService {

    /**
     * Save a employee.
     *
     * @param employee the entity to save.
     * @return the persisted entity.
     */
    Employee save(Employee employee);

    /**
     * Get all the employees.
     *
     * @return the list of entities.
     */
    List<Employee> findAll();


    /**
     * Get the "id" employee.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Employee> findOne(Long id);

    /**
     * Delete the "id" employee.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    List<Employee> updateEmployeeSalaryByPlace(String place, Double salary);
    
    List<Employee> findEmployeesByPlacePageable(String place, Pageable pageable);
    
    List<Employee> findEmployeesByPlace(String place);
    
    List<Double> getSalariesBycompetency(String competency);
}
