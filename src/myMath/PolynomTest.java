package myMath;


/**                  			  **Polynom Tester** 

 ****Test 1****
 **constructor**
Expected output:

 **good samples**					**bad samples**

1)	13.0x^3+2.0x^2+2.0x				1)	javax.management.RuntimeErrorException: -2w not valid double
2)	-13.0x^3-2.0x^2-2.0x			2)	javax.management.RuntimeErrorException: 2*3x not valid int
3)	2.0x^2-2.0x						3)	javax.management.RuntimeErrorException: 12f not valid double
4)	-13.0x^3-4.0x					4)	javax.management.RuntimeErrorException: ^x not valid int


 ****Test 2****
 **f method**

 *Expected output:

f(x)=x^4+5.0x^3+x^2+4.0x+2.0

2)	f(0.0)=2.0									9)	f(4.9)=1210.3351000000002			
3)	f(0.7)=7.245099999999999					10)	f(5.6000000000000005)=1917.2896000000005
4)	f(1.4)=27.121599999999994					11)	f(6.300000000000001)=2892.421100000001
5)	f(2.0999999999999996)=80.56309999999996		12)	f(7.000000000000001)=4195.000000000002
6)	f(2.8)=192.26559999999995					13)	f(7.700000000000001)=5890.059100000003
7)	f(3.5)=392.6875								14)	f(8.4)=8048.393600000002
8)	f(4.2)=718.0496								15)	f(9.1)=10746.561099999997
16)	f(9.799999999999999)=14066.881599999997


 *****Test 3****
 **subtract, add monom , add polynom,"is_zero"**

new p1:	x^4+5.0x^3+x^2+4.0x+2.0
new p2:	x^4+3.0x^3+x^2+2.0x+6.0
 **apply: add p1+p2**
p1: 2.0x^4+8.0x^3+2.0x^2+6.0x+8.0	is zero:	false
 **apply: sub p1-p2**
p1: x^4+5.0x^3+x^2+4.0x+2.0	is zero:	false
 **sub p1-p1**
p1: 
 **creating p1**
p1: x^4+5.0x^3+x^2+4.0x+2.0
 **add p1+p1**
p1: 2.0x^4+10.0x^3+2.0x^2+8.0x+4.0	is zero:	false
 **creating new p3**
p3: x^4+5.0x^3+x^2+4.0x+2.0
 **apply:sub p1-p3**
p1: x^4+5.0x^3+x^2+4.0x+2.0	is zero:	false
 **apply:sub p1-p3**
p1: 	is zero:	true
 **testing epsilon diviation**
p3: x^4+5.0x^3+x^2+4.0x+2.0/np4: x^4+5.0x^3+x^2+4.0x+2.0
 **apply substruction:**
p3: 	is zero:	true


 ***Test 4*** 
 **test root method**

 ***Good Examples*** 

x^2-4
root:	1.9999999925494194

x^3+x^2-16
root:	2.22677237726748

 ***Bad Examples***
x^3+x^2-16.0		java.lang.RuntimeException: Function Doesnt Rooted In Given Interval

x^4+8.0x^3+16.0x+4.0	java.lang.RuntimeException: Function Doesnt Rooted In Given Interval

 *
 ***Test 5***
***derivative*** 
p1)before op: x^16+12.0x^3+x^2+7.5
p1)after op: 16.0x^15+36.0x^2+2.0x

***copy***
**applying copy opperation:**
Copy p1 to p2
p2) x^16+12.0x^3+x^2+7.5

***applaying equal method: p1 eq p2?***
true
***p2 eq p2?***
x^16+12.0x^3+x^2+7.5
true
***p3 eq p2?***
3.0x^3+x^2+x
false

 ***Test 6***
f(x)=2x
calculate the area sum
area:  35.9999993942228

f(x)=2x^3+2x^2+2
calculate the area sum
area:  803.9999746540111

f(x)=-2x^8+8x^2+13
calculate the area sum
area:  20.928468752204605

f(x)=0
calculate the area sum
area:  0.0

f(x)=-x^2
calculate the area sum
area:  0.0

 *
 *
 */


public class PolynomTest {
	public static void main(String[] args) {
		
				test1();
				test2();
				test3();
		test4();
				test5();
				test6();

	}
	public static void test1() {
		//good samples: 
		System.out.println("****Test 1****"+"\n");
		System.out.println("**good samples**"+"\n");
		String a = "2x+2x^2+13x^3";
		Polynom p1 = new Polynom(a);
		System.out.println("1)	"+p1);

		a  = "-2x-2x^2-13x^3";
		p1 = new Polynom(a);
		System.out.println("2)	"+p1);

		a  = "-2x+2x^2-13x^3+13x^3";
		p1 = new Polynom(a);
		System.out.println("3)	"+p1);

		a  = "-2x-2x-2x^2+2x^2-13x^3";
		p1 = new Polynom(a);
		System.out.println("4)	"+p1+"\n");

		//bad samples
		try {
			System.out.println("**bad samples**"+"\n");
			a  = "-2x-2wx^2-13ex^3";
			p1 = new Polynom(a);
			System.out.println("1)	"+p1);
		}catch(Exception e) {
			System.out.println("1)	"+e);
		}
		try {
			a  = "-2x^2*3x-13x^3";
			p1 = new Polynom(a);
			System.out.println("2)	"+p1);
		}catch(Exception e) {
			System.out.println("2)	"+	e);
		}
		try {
			a  = "--2x^1+13x+12f";
			p1 = new Polynom(a);
			System.out.println("3)	"+p1 );
		}catch(Exception e) {
			System.out.println("3)	"+e);
		}
		try {
			a  = "-+2x^^x-+2x^2-13x^3";
			p1 = new Polynom(a);
			System.out.println("4)	"+p1);
		}catch(Exception e) {
			System.out.println("4)	"+e);
		}
	}


	public static void test2() {
		System.out.println("****Test 2****");
		String a= "2+4x+x^2+5x^3+x^4";
		Polynom p= new Polynom(a);
		System.out.println("f(x)="+p+"\n");
		int t=1;
		for (double i = 0; i < 10; i=i+0.7) {
			t++;
			System.out.println(t+")	"+"f("+i+")="+p.f(i));
		}
	}


	public static void test3() {
		System.out.println("\n"+"****Test 3****");

		String[] a= {"2","4x","x^2","5x^3","x^4"};
		Polynom_able p1 = new Polynom();
		for (int i = 0; i < a.length; i++) {
			Monom m1 = new Monom(a[i]);
			p1.add(m1);
		}
		System.out.println("new p1:	"+p1);

		String[] b= {"6","2x","1x^2","3x^3","x^4"};
		Polynom_able p2 = new Polynom();
		for (int i = 0; i < a.length; i++) {
			Monom m1 = new Monom(b[i]);
			p2.add(m1);
		}
		System.out.println("new p2:	"+p2);

		System.out.println(	"**apply: add p1+p2**");
		p1.add(p2);
		System.out.println("p1: "+p1+"	is zero:	"+p1.isZero());

		System.out.println("**apply: sub p1-p2**");
		p1.substract(p2);
		System.out.println("p1: "+p1+"	is zero:	"+p1.isZero());

		System.out.println("**sub p1-p1**");
		p1.substract(p1);
		System.out.println("p1: "+p1);

		String[] s= {"2","4x","x^2","5x^3","x^4"};
		p1 = new Polynom();
		for (int i = 0; i < a.length; i++) {
			Monom m1 = new Monom(s[i]);
			p1.add(m1);
		}
		System.out.println("**creating p1**");
		System.out.println("p1: "+p1);

		System.out.println("**add p1+p1**");
		p1.add(p1);
		System.out.println("p1: "+p1+"	is zero:	"+p1.isZero());

		String[] c= {"2","4x","x^2","5x^3","x^4"};
		Polynom_able p3 = new Polynom();
		for (int i = 0; i < a.length; i++) {
			Monom m1 = new Monom(c[i]);
			p3.add(m1);
		}
		System.out.println("**creating new p3**");
		System.out.println("p3: "+p3);

		System.out.println("**apply:sub p1-p3**");
		p1.substract(p3);
		System.out.println("p1: "+p1+"	is zero:	"+p1.isZero());
		//
		System.out.println("**apply:sub p1-p3**");
		p1.substract(p3);
		System.out.println("p1: "+p1+"	is zero:	"+p1.isZero());

		String[] e= {"2.0000001","4.0000001x","0.0000001x^2","5.0000001x^3","0.0000001x^4"};
		Polynom_able p4 = new Polynom();
		for (int i = 0; i < a.length; i++) {
			Monom m1 = new Monom(c[i]);
			p4.add(m1);
		}
		System.out.println("**testing epsilon diviation**");
		System.out.println("p3: "+p3+"/n"+"p4: "+p4);
		p3.substract(p4);
		System.out.println("**apply substruction:**");

		System.out.println("p3: " +p3+"	is zero:	"+p3.isZero());
	}


	public static void test4() {

		System.out.println("\n"+"***Test 4***"+"\n"+"***Good Examples***");
		String test = "x^2-4" ; 
		Polynom p1 = new Polynom(test);
		System.out.println();
		System.out.println(test);
		System.out.println("root:	"+p1.root(0, 12, 0.0000001));
		System.out.println();
		p1 = new Polynom("x^3+x^2-16");
		System.out.println("x^3+x^2-16");
		System.out.println("root:	"+p1.root(0, 12, 0.0000001));
		System.out.println("\n"+"***Bad Examples***");
		try {
			p1=new Polynom("x^3+x^2-16");
			System.out.println("root:	"+p1.root(4, 20, 0.0000001));
		}catch (Exception e) {
			System.out.println(p1+"\t\t"+ e);
		}
		System.out.println();
		try {
			p1=new Polynom("x^4+8x^3+16x+4");
			System.out.println("root:	"+p1.root(0, 100000, 0.0000001));
		}catch (Exception e) {
			System.out.println(p1+"\t"+ e);
		}
		System.out.println();
		try {
			p1=new Polynom("-3x^3-2x^2+x+0.5");
			System.out.println("root:	"+p1.root(-10, -0.1, 0.0000001));
		}catch (Exception e) {
			System.out.println(p1+"\t"+ e);
		}
	}

	public static void test5() {
		//is zero, copy,equal
		System.out.println("\n"+"***Test 5***"+"\n");
		Polynom p1 = new Polynom();
		System.out.println("***derivative*** ");
		String[] test = {"x^2","12x^3","x^16","7.5"};

		for (int i = 0; i < test.length; i++) {
			Monom a= new Monom(test[i]);
			p1.add(a);
		}
		System.out.println("p1)before op: "+p1);
		System.out.println("p1)after op: "+p1.derivative()+"\n");
		System.out.println("***copy***");
		Polynom_able p2=new Polynom();
		System.out.println("**applying copy opperation:**");
		System.out.println("Copy p1 to p2");
		p2=p1.copy();
		System.out.println("p2) "+p2+"\n"+"\n"+"***applaying equal method: p1 eq p2?***");
		System.out.println(p2.equals(p1));
		System.out.println("***p2 eq p2?***");
		System.out.println(p2);
		System.out.println(p2.equals(p2));
		System.out.println("***p3 eq p2?***");
		Polynom p3 = new Polynom("x+x^2+3x^3");
		System.out.println(p3);
		System.out.println(p3.equals(p2));

	}
	public static void test6(){
		System.out.println("\n"+"***Test 6***");
		String test = "2x";
		System.out.println("f(x)="+test);
		Polynom p1 = new Polynom(test);

		System.out.println("calculate the area sum");
		System.out.println("area:  "+p1.area(0, 6, 0.0000001));
		String test2 = "2x^3+2x^2+2";
		System.out.println("\n"+"f(x)="+test2);
		Polynom p2 = new Polynom(test2);

		System.out.println("calculate the area sum");
		System.out.println("area:  "+p2.area(0, 6, 0.0000001));

		String test3 = "-2x^8+8x^2+13";
		System.out.println("\n"+"f(x)="+test3);
		Polynom p3 = new Polynom(test3);

		System.out.println("calculate the area sum");
		System.out.println("area:  "+p3.area(0, 6, 0.00001));

		String test4 = "0";
		System.out.println("\n"+"f(x)="+test4);
		Polynom p4 = new Polynom(test4);

		System.out.println("calculate the area sum");
		System.out.println("area:  "+p4.area(0, 6, 0.00001));

		String test5 = "-x^2";
		System.out.println("\n"+"f(x)="+test5);
		Polynom p5 = new Polynom(test5);

		System.out.println("calculate the area sum");
		System.out.println("area:  "+p5.area(0, 6, 0.00001));

		System.out.println("***Bad Inputs***");
		String test6 = "x^2";
		System.out.println("\n"+"f(x)="+test6);
		Polynom p6 = new Polynom(test6);
		try {
			System.out.println("calculate the area sum");
			System.out.println("area:  "+p6.area(0, 6, -0.00001));
		}catch (Exception e) {
			System.out.println(p6 +""+ e+": -0.00001");}

		String test7 = "x^2";
		System.out.println("\n"+"f(x)="+test7);
		Polynom p7 = new Polynom(test7);
		try {
			System.out.println("calculate the area sum");
			System.out.println("area:  "+p6.area(0, 6, 0.0));
		}catch (Exception e) {
			System.out.println(p7 +""+ e + ": 0.0");}
	}
}
