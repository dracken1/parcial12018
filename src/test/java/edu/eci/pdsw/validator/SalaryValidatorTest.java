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
			validator.validate(employee);
			if(validator.validate(employee).get() == ErrorType.INVALID_EPS_AFFILIATION) {
				return false;
			}
			else if(validator.validate(employee).get() == ErrorType.INVALID_ID) {
				return false;
			}
			else if(validator.validate(employee).get() == ErrorType.INVALID_PREPAGADA_AFILIATION) {
				return false;
			}
			else if(validator.validate(employee).get() == ErrorType.INVALID_SISBEN_AFFILIATION) {
				return false;
			}
			else if(validator.validate(employee).get() == ErrorType.INVALID_SALARY) {
				return false;
			}
			else {
				return true;
			}			
		});
	}
}
