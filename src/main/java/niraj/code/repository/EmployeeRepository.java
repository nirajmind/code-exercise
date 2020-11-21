package niraj.code.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niraj.code.domain.Employee;

/**
 * Spring Data repository for the Employee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Modifying
	@Query("update Employee e set e.salary=?2 where e.place=?1")
	int updateEmployeeSalaryByPlace(@Param("place") String place, @Param("salary") Double salary);

	@Transactional(readOnly = true)
	@Query("select e from Employee e where e.place=?1")
	List<Employee> findEmployeesByPlace(String place);
	
	@Transactional(readOnly = true)
	@Query("select e from Employee e where e.place=?1")
	List<Employee> findEmployeesByPlacePaged(String place, Pageable pageable);
	
	@Transactional(readOnly = true)
	@Query("select e.salary from Employee e where e.competencies=?1")
	List<Double> findSalariesBycompetency(String competency);
}
