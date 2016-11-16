public class Comparador {

	
	public static void main(String[] args) {
	/*	Date f1 = new Date();
		Date f2 = new Date();
		Date f3 = new Date();
		
		Calendar cal = new GregorianCalendar(2016, 10, 2);
		f2 = cal.getTime();
		
		System.out.println(f1);
		System.out.println(f2);
		
		System.out.println(f1.compareTo(f2));
		System.out.println(f1.compareTo(f3));
		*//*/*/
/***		
 *  int java.util.Date.compareTo(Date arg0)


		the value 0 if the argument Date is equal to this Date;
		 a value less than 0 if this Date is before the Date argument;
		  and a value greater than 0 if this Date is after the Date argument. 
*/
		int num = 0;
		try {
			
			throw new NullPointerException();
		} catch (Exception e) {
			e.printStackTrace();
			num = 2;
			 
		}finally {
			System.out.println("finally ok");
			
		}
		
		System.out.println("el numero es " + num);
		
	}
}
