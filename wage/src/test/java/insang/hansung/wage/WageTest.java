package insang.hansung.wage;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class WageTest {
	
	int expectedWage;
	Proficiency type;
	int workingHours;
	
	@Parameters
	public static Collection getParameters() {
		return Arrays.asList(new Object[][] {
			{ 160000, Proficiency.E, 2 },
			{ 3600000, Proficiency.E, 30},
		});
	}
	
	public WageTest(int expectedWage, Proficiency type, int workingHours) {
		this.expectedWage = expectedWage;
		this.type = type;
		this.workingHours = workingHours;
	}
	
	@Test
	public void test_caculatePay_with_each_choice() {
		int wage = Wage.calculatePay(type, workingHours);
		assertEquals(expectedWage, wage);
	}
	
	@Test(expected=InvalidInputException.class)
	public void test_caculatePay_with_invalid_inputs_less_than_0() {
		int wage = Wage.calculatePay(Proficiency.E, -10);
	}
	
	@Test(expected=InvalidInputException.class)
	public void test_caculatePay_with_invalid_inputs_more_than_40() {
		int wage = Wage.calculatePay(Proficiency.B, 50);
	}
	
	@Test(expected=InvalidInputException.class)
	public void test_caculatePay_with_invalid_inputs_more_than_100() {
		int wage = Wage.calculatePay(Proficiency.B, 150);
	}

}
