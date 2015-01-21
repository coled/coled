import java.util.Scanner;
public class Max {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard= new Scanner(System.in);
		double max =0;
		double [] nums = new double [100];
		System.out.println("Enter double values to find the max value.\n Enter the value -1 to compute maximum once all desired values are entered. ");
		
		for(int i=0; i <nums.length; i++){	
			nums[i] = keyboard.nextDouble();
			if(keyboard.nextDouble()==-1){
				break;
			}
		}
			for(int k=0; k< nums.length; k++){
			if(nums[k]> max){
				max = nums[k];
			}
		}	
			System.out.println("Max value is "+max);
	}
		
	}
