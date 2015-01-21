
public class FinalExamPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

					// x,y
		int [] array= {5,5};
		
		System.out.println(F(array));
		
		 String name;
		 int age;
		
		
		
	}

	
	 public static int F(int [] f){
		int sum=0;
			for(int i = 0; i< f.length ; i++)
			{
				sum = sum + f[i] * f[i];
			}
	return sum;
	
}

	// 10 methods 
	 
	 public static double sum(double[ ][ ][ ][ ] array){
		 double sum=0;
		 if(array == null){
			 return sum;
		 }
		 for(int i=0; i<array.length; i++){
			 for(int j=0; j < array[i].length; j++){
				 for(int k=0; k < array[i][j].length; k++){
					 for(int l=0; l < array[i][j][k].length; l++){
						 
						 sum = sum + array[i][j][k][l];
					 }
				 }
			 }
		 }
		 return sum;
	 }
	 
	 
	 public static boolean contains(String element, String[ ][ ][ ][ ] array){
		 boolean contains=false;
		 
		 for(int i=0; i<array.length; i++){
			 for(int j=0; j < array[i].length; j++){
				 for(int k=0; k < array[i][j].length; k++){
					 for(int l=0; l < array[i][j][k].length; l++){
						 
						 if(element.equalsIgnoreCase(array[i][j][k][l]));{
							 contains=true;
						 }
					 }
				 }
			 }
		 }
		 return contains;
	 }
	 
	 
	 // 11 overloaded constructors
	 String name;
	 int age;
	 
	 FinalExamPractice(){
		 this.name="no name";
		 this.age= 0;
	 }
	 
	 FinalExamPractice(String n, int a){
		 this.name=n;
		 this.age= a;
	 }
	 
	 // 12 overloaded methods
	 
	boolean compareTo(String s){
		 boolean equal=false;
		 if(this.name.equalsIgnoreCase(s)){
			 equal=true;
		 }
		 
		 return equal;
	 }
	 
	int compareTo(int a){
		 int equal=0;
		 if(this.age==a){
			 equal=0;
		 }
		 if(this.age<a){
			 equal=-1;
		 }
		 if(this.age>a){
			 equal=1;
		 }
		 return equal;
	 }
	 
	
	//13
	
	int [] [] array = {
			{ 0, 0, 0 },
			{ 0, 0, 0 }
	};
	
	// 14
	int [] [] array2 = new int [2][3];{
	
	for(int i=0; i<array2.length; i++){
		for(int j=0; j< array2[0].length; j++){
			array2 [i] [j] = 0;
		}
	}
	}
	
	//15
	String [] [] string1={
			{ " ", " ", " " },
			{ " ", " " }
	};
	

	
	
}
	
