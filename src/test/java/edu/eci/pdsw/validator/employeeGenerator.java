package edu.eci.pdsw.validator;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

import edu.eci.pdsw.model.Employee;
import edu.eci.pdsw.model.SocialSecurityType;

public class employeeGenerator {	
	
	
	public static  Gen<Employee> employees(){
		return employeeId().zip(employeeSalary(),employeeSST(),
		        (id, salary,SST) -> new Employee(id, salary,SST));
	}
	
	private static  Gen<Integer> employeeId(){		
		return integers().from(1000).upToAndIncluding(100000);
	}
	
	private static  Gen<Integer> employeeSalary(){
		return integers().from(100).upToAndIncluding(50000);
	}
	
	private static  Gen<SocialSecurityType>  employeeSST(){
		return Generate.enumValues(SocialSecurityType.class);
	}
}
