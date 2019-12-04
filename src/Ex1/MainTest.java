package Ex1;

import java.util.Stack;

public class MainTest {

//	String OP;
//
//	public static function testinit(String a) {
//
//
//		
//		
//		
//		
		
//		while(a.charAt(i) != '(') {
//			temp += a.charAt(i);
//			i++;
//		}
//		if(chack_OP(temp)) {
//			String OP = temp;
//		}
//
//		i++;
//		int count = 0;
//		int start_index = i;
//		int end_index;
//		boolean flag = true;
//		String left_side ="";
//
//		while(a.charAt(i)!='(') {
//			left_side+= a.charAt(i++);
//		}
//		
//		while(flag) {
//			
//			left_side+= a.charAt(i);
//			if(a.charAt(i)=='(') {
//				count++;
//
//			}else if(a.charAt(i)==')') {
//				count --;
//			}
//			i++;
//			if (count == 0) flag = false ;
//		}
//		return a;

//
//	}


	private static boolean chack_OP(String temp) {
		// TODO Auto-generated method stub
		return false;
	}


	public static void main(String[] args) {

		System.out.println("---------------------------");
		Polynom a = new Polynom("0");
		ComplexFunction cf = new ComplexFunction(a);
		function cf1 = cf.initFromString("div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)");
		ComplexFunction cf2 = new ComplexFunction(cf1);
		System.out.println(cf2);
		System.out.println("---------------------------");
		


}}
