package niraj.code.service.impl;

import niraj.code.service.EmployeeService;
import niraj.code.domain.Employee;
import niraj.code.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Employee}.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Save a employee.
     *
     * @param employee the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Employee save(Employee employee) {
        log.debug("Request to save Employee : {}", employee);
        return employeeRepository.save(employee);
    }

    /**
     * Get all the employees.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        log.debug("Request to get all Employees");
        return employeeRepository.findAll();
    }


    /**
     * Get one employee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findOne(Long id) {
        log.debug("Request to get Employee : {}", id);
        return employeeRepository.findById(id);
    }

    /**
     * Delete the employee by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Employee : {}", id);
        employeeRepository.deleteById(id);
    }

	@Override
	public List<Employee> updateEmployeeSalaryByPlace(String place, Double salary) {
		log.debug("Request to update for all Employees matching place : {} ", place);
		List<Employee> employees = findEmployeesByPlace(place);
		if(salary <= 55) {
			employees.parallelStream().forEach(e -> e.setSalary(e.getSalary() + (e.getSalary()*salary)/100));
		}
		return employeeRepository.saveAll(employees);
	}

	@Override
	public List<Employee> findEmployeesByPlacePageable(String place, Pageable pageable) {
		log.debug("Request to get all Employees by place : {} ", place);
		return employeeRepository.findEmployeesByPlacePaged(place, pageable);
	}

	@Override
	public List<Employee> findEmployeesByPlace(String place) {
		log.debug("Request to get all Employees by place : {} ", place);
		return employeeRepository.findEmployeesByPlace(place);
	}

	@Override
	public List<Double> getSalariesBycompetency(String competency) {
		log.debug("Request to get all salaries by competency : {} ", competency);
		return employeeRepository.findSalariesBycompetency(competency);
	}
}
