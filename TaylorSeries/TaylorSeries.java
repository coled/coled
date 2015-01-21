import java.util.Scanner;

public class TaylorSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		double x = 0;
		int t = 0;
		double e = 0;
		double sum =1;
		double num=1;
		double den=1;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a double value for x (-50 <= x <= 50):");
		
		x = keyboard.nextDouble();
		// may need nested loop statements
		
		if(x >= -50 && x<= 50);
		
		else{
			do{	
				System.out.println("Invalid input for x.");
				System.out.println("Enter a double value for x (-50 <= x <= 50):");
				x = keyboard.nextDouble();
			}
				while (x < -50 || x > 50);
			}

		System.out.println("Enter t (1 <= t < 64), the number of terms for the Taylor Series:");
		
		t = keyboard.nextInt();
		
		if (t >= 1 && t < 64);
		
		else{
			do{
				System.out.println("Invalid input for t.");
				System.out.println("Enter t (1 <= t < 64), the number of terms for the Taylor Series:");
				t = keyboard.nextInt();
			}
				while (t < 1 || t > 64);
			}
	
		
		for ( int i=1 ; i < t ; i++)
		{
			num = num * x;
			den = den * i;
				
			sum = (num /den) + sum;
		}
		System.out.println("sum"+sum);
		}
	
	

	}
	
	
		
		
		
		
		
	
		
		
		
	


