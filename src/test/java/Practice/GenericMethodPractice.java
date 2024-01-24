package Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
          int sum= add(20,30);
           System.out.println(sum);
           int su=sub(sum,10);
           System.out.println(su);
           int ml=mul(sum, su);
           System.out.println(ml);
	}
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}
	public static int sub(int c,int d)
	{
		int e=c-d;
		return e;
	}
   public static int mul(int f,int g)
   {
	   int h=f*g;
	   return h;
   }
}
