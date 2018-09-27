package edu.eci.pdsw.validator;

import static org.quicktheories.QuickTheory.qt;

import edu.eci.pdsw.model.Employee;
import edu.eci.pdsw.model.SocialSecurityType;
import edu.eci.pdsw.validator.employeeGenerator;
import static org.quicktheories.generators.SourceDSL.*;

import java.util.Optional;

import org.junit.Test;

/**
 * Test class for {@linkplain SalaryValidator} class
 */
public class SalaryValidatorTest {

	/**
	 * The class under test.
	 */
	private SalaryValidator validator = new SalaryValidator();
	/**
	 * {@inheritDoc}}
	 */
	@Test
	public void validateTest() {		
		qt()
		.forAll(employeeGenerator.employees())
		.check( employee ->{			
			if(validator.validate(employee).get().equals(ErrorType.INVALID_EPS_AFFILIATION)) {
				System.out.println("Falla, entra if 1");
				return false;
			}
			else if(validator.validate(employee).get().equals(ErrorType.INVALID_ID)) {
				System.out.println("Falla, entra if 2");
				return false;
			}
			else if(validator.validate(employee).get().equals(ErrorType.INVALID_PREPAGADA_AFILIATION)) {
				System.out.println("Falla, entra if 3");
				return false;
			}
			else if(validator.validate(employee).get().equals(ErrorType.INVALID_SISBEN_AFFILIATION)) {
				System.out.println("Falla, entra if 4");
				return false;
			}
			else if(validator.validate(employee).get().equals(ErrorType.INVALID_SALARY)) {
				System.out.println("Falla, entra if 5");
				return false;
			}
			else {
				System.out.println("Success!");
				return true;
			}			
		});
	}
}
