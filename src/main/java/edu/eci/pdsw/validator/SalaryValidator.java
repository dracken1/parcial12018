package edu.eci.pdsw.validator;

import java.util.Optional;

import edu.eci.pdsw.model.Employee;
import edu.eci.pdsw.model.SocialSecurityType;

/**
 * Utility class to validate an employee's salary
 */
public class SalaryValidator implements EmployeeValidator {
	/**
	 * {@inheritDoc}}
	 */
	public Optional<ErrorType> validate(Employee employee) {
		int id = employee.getPersonId();
		long salary = employee.getSalary();
		if(!(id >= 1000 && id <= 100000)) {
			return Optional.of(ErrorType.INVALID_ID);
		}
		else if (!(salary>100 && salary<=50000)) {
			return Optional.of(ErrorType.INVALID_SALARY);
		}
		else if (!(salary < 1500 && employee.getSocialSecurityType() == SocialSecurityType.SISBEN)) {
			return Optional.of(ErrorType.INVALID_SISBEN_AFFILIATION);
		}
		else if (!(salary < 10000 && employee.getSocialSecurityType() == SocialSecurityType.EPS)) {
			return Optional.of(ErrorType.INVALID_EPS_AFFILIATION);
		}
		else if (!(salary > 10000 && employee.getSocialSecurityType() == SocialSecurityType.PREPAID)) {
			return Optional.of(ErrorType.INVALID_PREPAGADA_AFILIATION);
		}
		else {
			return Optional.empty();
		}		
	}
}
