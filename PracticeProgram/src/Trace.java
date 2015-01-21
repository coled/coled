public class Trace {
      public static void main(String[] args){
            Trace trace1 = new Trace();
            int[][] a = trace1.r();
            int[][] b = new int[4][3];
            Trace trace2 = new Trace(b);
            System.out.println( a.length );
            System.out.println( b[2].length );
            System.out.println( a[1][3] );
            System.out.println( b[0][1] );
            trace1.f(1, 1, 2, 0);
            trace2.f(0, 0, 2, 1);
            System.out.println( a[1][1] );
System.out.println( b[0][0] ); System.out.println( Trace.g() ); System.out.println( Trace.q()[1][1] ); System.out.println( Trace.t(1) );
      }
      //The rest of this class is on next page.
//1.____________________________
//2.____________________________
//3.____________________________
//4.____________________________
//5.____________________________
//6.____________________________
//7.____________________________
//8.____________________________
//9.____________________________

private int[][] a;
      private static int[][] b = {
            {1, 4, 2},
            {3, 0, 1},
            {4, 1}
      };
      private static int x;
      public Trace(){
            a = new int[2][4];
b(a);
x++; }
      public Trace(int[][] a){
            this.a = a;
x++; }
      public static void b(int[][] a){
            for(int i = 0; i < a.length; i++){
                  for(int j = 0; j < a[i].length; j++){
                        a[i][j] = j + 1;
} }
x++; }
      public static void f(int i, int j, int p, int q){
            int t = b[i][j];
            b[i][j] = b[p][q];
            b[p][q] = t;
            x++;
}
      public static int g(){
            return x;
}
      public static int[][] q(){
            x++;
return b; }
      public int[][] r(){
            x++;
return a; }
      public static int t(int j){
            int p = 0;
            for(int i = 0; i < b.length; i++){
                  p += b[i][j];
            }
            x++;
            return p;
      }
}//End of Trace Class