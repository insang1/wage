package insang.hansung.wage;

public class Wage {
	static public int calculatePay(Proficiency p, int hours) {
		int h_salary=0;
		int wage=0;
		if (hours<0 || hours>40) throw new InvalidInputException();
		if (0<hours && hours<=3) 
			if (p==Proficiency.E)h_salary=80000;
			else h_salary=40000;
		else if (3<hours && hours<=5) 
			if (p==Proficiency.E)h_salary=100000;
			else h_salary=50000;
		else if (5<hours && hours<=40) 
			if (p==Proficiency.E)h_salary=120000;
			else h_salary=60000;
		
		wage = h_salary*hours;

		return wage;
	}
}
