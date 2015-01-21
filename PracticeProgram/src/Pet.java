
public class Pet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age1=5;
		int age2=9;
		
		
		Pet cole= new Pet();
		
		cole = new Pet(age1);
	}

	String name;
	int age;
	String [] siblings;
	
	
	Pet(){
		this.age=0;
	}
	
	Pet(int a){
		this.age= a;
	}
	
	
	
	public int compareTo(Pet p){
		int result =0;
		if(p == null){
			System.out.println("Pet 'p's age is null. exiting program.");
			System.exit(0);
		}
		
		if(this.age < p.age){
			result =-1;
		}
		if(this.age > p.age){
			result =1;
		}
		if(this.age == p.age){
			result =0;
		}
		return result;
	}
	
	
}
