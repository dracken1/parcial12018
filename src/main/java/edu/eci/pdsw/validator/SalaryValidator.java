package edu.eci.pdsw.validator;

import java.util.Optional;

import edu.eci.pdsw.model.Employee;
import edu.eci.pdsw.model.SocialSecurityType;

/**
 * Utility class to validate an employee's salary
 */
public class SalaryValidator implements EmployeeValidator {
	
	int id;
	long salary;
	/**
	 * {@inheritDoc}}
	 */
	
	public Optional<ErrorType> validate(Employee employee) {
		id = employee.getPersonId();
		salary = employee.getSalary();
		if(!(id >= 1000 && id <= 100000)) {
			System.out.println("Entra if 1");
			return Optional.of(ErrorType.INVALID_ID);
		}
		else if (!(salary>=100 && salary<=50000)) {
			System.out.println("Entra if 2");
			return Optional.of(ErrorType.INVALID_SALARY);
		}
		else if (salaryValidatorSISBEN(employee)) {
			System.out.println("Entra if 3");
			return Optional.empty();
		}
		else if (!(salaryValidatorSISBEN(employee))) {
			System.out.println("Entra if 4");
			return Optional.of(ErrorType.INVALID_SISBEN_AFFILIATION);
		}
		else if (salaryValidatorEPS(employee)) {
			System.out.println("Entra if 5");
			return Optional.empty();
		}
		else if (!(salaryValidatorEPS(employee))) {
			System.out.println("Entra if 6");
			return Optional.of(ErrorType.INVALID_EPS_AFFILIATION);
		}
		else if (salaryValidatorPREPAID(employee)) {
			System.out.println("Entra if 7");
			return Optional.empty();
		}
		else if (!(salaryValidatorPREPAID(employee))) {
			System.out.println("Entra if 8");
			return Optional.of(ErrorType.INVALID_PREPAGADA_AFILIATION);
		}
		else {
			System.out.println("No entra if");
			return Optional.empty();
		}		
	}
	
	private boolean salaryValidatorSISBEN(Employee employee) {
		return salary < 1500 && employee.getSocialSecurityType() == SocialSecurityType.SISBEN;
	}
		
	private boolean salaryValidatorEPS(Employee employee) {
		return salary < 10000 && employee.getSocialSecurityType() == SocialSecurityType.EPS;
	}
	
	private boolean salaryValidatorPREPAID(Employee employee) {
		return salary > 10000 && employee.getSocialSecurityType() == SocialSecurityType.PREPAID;
	}
}
