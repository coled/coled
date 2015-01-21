import java.util.Random; 
public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
		
		 int [] a = new	int [10];
		
		for(int i =0; i<a.length; i++){
			a[i]= (int) (Math.random() * 100);
		}
		
		
		
		Integer [] b = new	Integer [100];
		
		for(int i =0; i<b.length; i++){
			b[i]= (int) (Math.random() * 100);
		}
		
		int k = (int) (Math.random() * 100);
		Integer t = new Integer (k);
		
		
	//	System.out.println("Before sort:");
	//	System.out.println(print(a));
		
		//selection(a);
		//bubble(a);
		insertion(b);
		//bogoSort(a);
	//	System.out.println("After sort: ");
		//System.out.println(print(a));
		
		
		System.out.println("Target: "+ t);
		System.out.println(print(b));
		System.out.println(printI(b));
		
		
		System.out.println(binary(b , t , 0 , b.length-1));
		
		
		
		
		
	}
	
	
	public static <T extends Comparable<T>> int binary(T [] array, T target, int lo, int hi){
		
		if(lo > hi){
			int i = -1;
			return i; // not found
		}
		
		int mid = (lo/2) + ( hi/2);
		if(target.compareTo(array[mid]) == 0) return mid;
		if(target.compareTo(array[mid]) < 0) {
			return binary(array, target, lo, mid - 1);
			
		} if (target.compareTo(array[mid]) > 0){
			return binary(array, target, mid + 1, hi);
		} 
		else {
			return mid;
		}
		
	}//binary
	
	
	
	
	
	
	
	
	
	
	
	
	
	//insertion sort
	public static void insertion(Integer[] b){
		for(int i =0; i<b.length; i++){
			for(int j = i; j>0; j--){
		if(b[j-1] > b[j]){
			int temp = b[j];
			b[j]=b[j-1];
			b[j-1]= temp;
		}
	}
				
	}
		
}
	
	
	public static void selection(int [] a){
		// selection sort working!
		for(int i =0; i<a.length-1; i++){
			int minIndex = i;
			for(int j=i+1; j<a.length; j++){
				if(a[minIndex]> a[j])
				{
					minIndex=j;
				}
			}
			int temp = a[i];
			a[i]=a[minIndex];
			a[minIndex]=temp;
		}
		}
		

	public static void bubble(int [] a){
		// bubble sort
		for(int i =0; i<a.length-1; i++){
			for(int j =0; j<a.length-1; j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		}// bubble
		
	  private static final Random generator = new Random();  
	  
	    public static void bogoSort(int[] data)  
	    {  int count=0;
	        while (!isSorted(data)) {  
	        	
	            for (int i = 0; i < data.length; i++){  
	                int randomPosition = generator.nextInt(data.length);  
	  
	                int temp = data[i];  
	                data[i] = data[randomPosition];  
	                data[randomPosition] = temp;  
	              System.out.println(print(data)+count);
	              count++;
	            }  
	        }  
	    }  
	    
	 private static boolean isSorted(int[] data)  
	    {  
	        for (int i = 1; i < data.length; i++)  
	            if (data[i] < data[i - 1])  
	                return false;  
	  
	        return true;  
	    }  
	    
	public static int min(int [] a){
			int minimum=a[0];
			for(int i =0; i<a.length; i++){	
				if(a[i]<minimum){
					minimum=a[i];
				}
		}
			return minimum;
		}
		
		
		
		
	public static String print(int [] a){
		// print out sorted array a
		StringBuffer sb= new StringBuffer();
		for(int x=0; x< a.length; x++){
			sb.append(a[x]);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	
	public static String print(Integer [] b){
		// print out sorted array a
		StringBuffer sb= new StringBuffer();
		for(int x=0; x< b.length; x++){
			sb.append(b[x]);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static String printI(Integer [] b){
		// print out sorted array a
		StringBuffer sb= new StringBuffer();
		for(int x=0; x< b.length; x++){
			sb.append(x);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	
	
}
