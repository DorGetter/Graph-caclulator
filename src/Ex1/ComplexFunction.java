package Ex1;



/**
 **Class Explanation**
 * ---------------------------------------------------------------------------------------------------------------------
 * This class represents ComplexFunction OBJ. 																			|																				|
 * ComplexFunction is a obj. which contain two obj- Polynom/Monom/complex function and an opperation between them. 		|
 * ComplexFunction class works as following: 																			|
 * *Receiving F(x) ,G(x), and Operation to apply between them (G(x) can be null- in that case Op will be none).			|												|
 *----------------------------------------------------------------------------------------------------------------------																														|
 * 											**Methods implemented**
 * ---------------------------------------------------------------------------------------------------------------------
 * 1) 	ComplexFunction(function p1)			-Constructor Num 1.														|
 * 2)	ComplexFunction(op,left,right)			-Constructor Num 2.														|
 * 3)	add(Polynom_able)					 	-Adding two Polynom_able objects into one.								|
 * 4)	add(Monom)								-Adding Monom into the Polynom.											|
 * 5)	substruct(Polnom_able) 					-Substruction of two Polnoms.											|
 * 6)	multiply								-Multiplying two Polynoms.												|
 * 7)	equals									-Check if two Polynoms are equal- by deviation of Epsilon.				|
 * 8)	isZero					-Check if Polynom is equal to zero.														|
 * 9)	root					-Calculate the point which the Polynom==zero between x0,x1 with deviation of Epsilon.	|
 * 10)	Copy					-Crates deep copy of Polynom.															|
 * 11)	Derivative				-Derivative the Polynom.																|
 * 12)	area					-Calculates the area size between the function to positive x axis.						|
 * 13)	multiply				-Multiply Polynom by Monom. 															|
 * 14) 	Iterator				-Returns Iterator from Class Iterator.													|
 * 15) 	toString				-Returns a String of the Polynom.														|
 * ---------------------------------------------------------------------------------------------------------------------
 * 										**Legit ComplexFunction**
 * ----------------------------------------------------------------------------------------------------------------------
 * Polynom will be only in the form of String containing valid Monoms: ax^b +/- ax^b +/- .... +/- ax^b.					|
 * the following cases are not valid: 																					|
 * 1) arithmetical operation within the equation that are not +\-.														|
 * 2) String containing letters or different characters other then 'x' (small x), '^' if there is a power.				|
 * ----------------------------------------------------------------------------------------------------------------------
 * 									
 * @author DorGetter && OmerRugi
 *
 */

public class ComplexFunction implements complex_function {

	private function left, right;															//left,right are F(x),G(x).															
	private Operation op=Operation.None;													//Operation.



	/*
	 * default Constructor Creating an empty ComplexFunction.
	 * Not available to User.  
	 */
	private ComplexFunction() {}

	/**
	 * 			ComplexFunction Constructor Num 0: 
	 * initialized a ComplexFunction from F(x) only. 
	 * 
	 * Valid inputs:	Every Obj which implements function interface.	
	 *  
	 * 							 Way of action:
	 *  *	Receiving function implementor.
	 *  **	Declare the Operation as None. 
	 *  *** Set p1 to be the function on the L.H.S of the ComplexFunction obj.  
	 * @param p1: Function implementor obj. 
	 */
	public ComplexFunction(function p) {

		this.op = Operation.None;
		function p1 = p.copy();
		this.left = p1;
	}

	/**
	 * 			ComplexFunction Constructor Num 1: 
	 * initialized a ComplexFunction from F(x), G(X) and String represent operation. 
	 * 
	 * Valid inputs:	+Every Obj which implements function interface- as F(X),G(x).
	 *					+Operation from the Enum class && slight deviations:
	 *				(+) opp: Plus , plus.				
	 *				(*) opp: Times, times, mult, mul.	
	 *				(/) opp: Divid, divid, div.
	 *			   (MAX)opp: Max, max.
	 *			   (MIN)opp: Min, min.
	 *			  (Comp)opp: Comp, comp.   					
	 *  		  (NONE)opp; None, none.
	 * 							 Way of action:
	 *  *		Using switch case on the operation String Routing the function to the specific op case.
	 *  **		creating a new Complex Function. 
	 *  ***		Setting the the op to the 'this' (the object in class) to the specific operation. 
	 *  **** 	Setting the Left of 'this' C.F to the 'left' function obj. 
	 *  ***** 	Setting the Right of 'this' C.F to the 'right' function obj.
	 *  %%      if the op given isn't valid (not from the list above) by default case the function will throw new exception. 
	 * 
	 * @param op   : String containing the Operation type wished between F(x), G(x).
	 * @param left : implementor obj. of function.   
	 * @param right: implementor obj. of function. 
	 */
	public ComplexFunction(String op, function left_org, function right_org) {

		function left  = left_org.copy();
		function right = right_org.copy();


		switch (op) {
		case "plus":
		case "Plus":
			ComplexFunction cf = new ComplexFunction(Operation.Plus, left,right);
			this.left = cf.left;
			this.right = cf.right;
			this.op = cf.op;
			break;

		case "times":
		case "mult":
		case "mul":
		case "Times":
			ComplexFunction cf1 = new ComplexFunction(Operation.Times, left,right);
			this.left = cf1.left;
			this.right = cf1.right;
			this.op = cf1.op;
			break;


		case "divid":
		case "div":
		case "Divid":
			ComplexFunction cf2 = new ComplexFunction(Operation.Divid, left,right);
			this.left = cf2.left;
			this.right = cf2.right;
			this.op = cf2.op;
			break;


		case "max":
		case "Max":
			ComplexFunction cf3 = new ComplexFunction(Operation.Max, left,right);
			this.left = cf3.left;
			this.right = cf3.right;
			this.op = cf3.op;
			break;

		case "min":
		case "Min":
			ComplexFunction cf4 = new ComplexFunction(Operation.Min, left,right);
			this.left = cf4.left;
			this.right = cf4.right;
			this.op = cf4.op;
			break;

		case "none":
		case "None":
			ComplexFunction cf5 = new ComplexFunction(Operation.None, left,right);
			this.left = cf5.left;
			this.right = cf5.right;
			this.op = cf5.op;
			break;

		case "comp":
		case "Comp":
			ComplexFunction cf6 = new ComplexFunction(Operation.Comp, left,right);
			this.left = cf6.left;
			this.right = cf6.right;
			this.op = cf6.op;
			break;


		default:
			throw new RuntimeException("Not a valid op");
		}

	}


	/**
	 			ComplexFunction Constructor Num 2: 
	 * initialized a ComplexFunction from F(x), G(X) and Operation. 
	 * 
	 * Valid inputs:	+Every Obj which implements function interface- as F(X),G(x).
	 *					+Operation from the Enum class && small deviations:
	 *					 opp: Plus, Divide, Times, Comp, None, Max, Min.   	
	 *					+ComplexFunction can receive G(x) (right) only if there is F(x) (left). 
	 *					+ComplexFunction have to receive F(x) ~~ meaning can't be initialized from to null functions. 
	 *
	 *					 Way of action:
	 *  *		Define if the op is None || other op.
	 *  **		None case:  define if the input variables input is valid aka (+ number 3,+ number 4). 
	 *  				    if valid aka there is only F(x) (left) init a new ComplexFunction with F(x) as ComplexFunction.left . 
	 *  *** 	Other case: Check validation (F(x), G(x) are not null and check if Divide is the op input check if G(x) is not '0').
	 *  					if pass create new ComplexFunction and set Left and Right to the F(x) ,G(x) from input.  
	 *  %%      . 
	 * 
	 * @param op   : Operation from the Enum class. 
	 * @param left : implementor obj. of function.   
	 * @param right: implementor obj. of function.
	 */
	public ComplexFunction(Operation op, function left_org, function right_org) {

		function left  = left_org.copy();
		function right = right_org.copy();

		if(op == Operation.None) { 

			if(right ==null && left==null) {
				throw new RuntimeException("No left function");
			}
			if(right == null && left != null) {
				this.left = left;
				return;
			}
			if(left == null && right != null) {
				throw new RuntimeException("No left function");
			}
			if(left != null && right != null) {
				throw new RuntimeException("Non op");
			}
		}
		else {
			if(right == null || left == null) {
				throw new RuntimeException("Null function");
			}

			if(op == Operation.Divid) {
				if(right.toString() == "0") {
					throw new RuntimeException("Div by 0");
				}
			}
			else if(op == Operation.Error) {
				throw new RuntimeException("Not a valid op");
			}

			this.left = left;
			this.right = right;
			this.op = op;
		}


	}

	//	@Override
	//	public double f(double x) {
	//		
	//		double ans =0;
	//		ans=op_func(x);
	//		return ans;
	//	}
	/**
			f(x) calculating: 

	 * Output the resualt of the Complexfunction by implementing a parameter (x);   
	 * 
	 * 		 * Valid inputs:	double type x. 
	 * 
	 *					 Way of action:  
	 *  *		Init a double type ans (will hold the result of the C.F function (left right). 
	 *  *		Using Switch case examine the op - Go to specific case.
	 *  **		Recursively making sum equal to the result of applying the specific operation on left and right (aka (F(x),G(x)).
	 *  		which left and right are resends to calculate there own x implementation result. 
	 *  ***     Returning ans. 
	 * 
	 * 
	 *@param x :	double input for implementing on the C.F 
	 */
	@Override
	public double f(double x) {


		double ans =0;
		switch (op) {
		case Plus:
			ans = left.f(x)+right.f(x);
			break;

		case Times:
			ans = left.f(x)*right.f(x);
			break;	

		case Divid:
			if ( right.f(x) == 0 ) { 
				throw new RuntimeException("Div by 0");
			}
			ans = left.f(x)/right.f(x);
			break;

		case Max:
			ans = Math.max(left.f(x),right.f(x));
			break;	

		case Min:
			ans = Math.min(left.f(x),right.f(x));
			break;

		case Comp:
			ans = left.f(right.f(x));
			break;

		case None:
			ans = left.f(x);
			break;

		default:
			break;
		}


		return ans;
	}



	/**
			Initialize from string: 

	 * 	Initializing C.F. from given string;   
	 * 
	 * 		* Valid inputs:	any valid Complex Function. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *		Go over the String (Using i index) from end-1 ( ignoring the first ')' char ) Until the first encounter of ',' char;
	 *  		this char represents the buffer between the left and right (F(x),G(x)) of the first op in the C.F. string given by user.
	 *  ** 		Go over the String (Using j index) from s_char[o] until the first encounter of '(' char.
	 *  		this char represents the buffer between the operation command and the functions that the command apply on.
	 *  *** 	Creating a new C.F that holds the operation and the left and right (F(x),G(x)) and submit them recursively into the C.F
	 *  		by calling the InitFromString function on left (Using substring j+1 until i) and on right (Using substring right_side);   
	 * 
	 * 
	 *@param s :	String contain C.F as a string. 
	 */
	@Override
	public function initFromString(String s) {

		if(!s.contains(",")) {
			function func;
			if(s.contains(" ")) {
				func = new Polynom(s.replaceAll(" ", ""));
			}else {
				func = new Polynom(s);
			}
			return func;
		}

		String temp ="";
		int i =0;
		i = s.length()-2;
		int j = 0;
		String right_side = "";
		String op_str = "";

		while(s.charAt(i) != ',') {
			right_side = s.charAt(i)+""+right_side;
			i--;
		}
		while(s.charAt(j) != '(') {
			op_str+=s.charAt(j);
			j++;
		}

		function cf = new ComplexFunction(op_str, initFromString(s.substring(j+1,i)),initFromString(right_side));
		return cf;

	}


	/**
				Deep Copy: 

	 * Initializing new Function OBJ. copy of the C.F that function copy apply on;   
	 * 
	 * 		* Valid inputs:-
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	creating a new 'function' that holds a complex_function which copy the fields of the C.F 
	 *  		which the function "copy" applied on.  
	 *  
	 */	
	@Override
	public function copy() {

		function copy_obj = new ComplexFunction(this.op,this.left,this.right);
		return copy_obj;
	}

	/**

			Plus function: 
	 *	Given a C.F and a function object sets a new C.F which will hold the old C.F on the
    	new function object as left and the new function object to the right.  
	 * 	
	 * 		* Valid inputs: function type obj. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	Creating a new function object which will contain a copy of the class C.F
	 *  ** 	Sets the left to the "old" C.F
	 *  *** 	Sets the right to the f1 (input function object)
	 *  **** Sets the operation between left and right to be Plus.  	
	 *  
	 *  @param f1: function object to add to the C.F.
	 */	
	@Override
	public void plus(function f1) {

		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Plus;

	}

	/**
			mult function: 
	 *	Given a C.F and a function object sets a new C.F which will hold the old C.F on the
		new function object as left and the new function object to the right.  
	 * 	
	 * 		* Valid inputs: function type obj. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	Creating a new function object which will contain a copy of the class C.F
	 *  ** 	Sets the left to the "old" C.F
	 *  *** 	Sets the right to the f1 (input function object)
	 *  **** Sets the operation between left and right to be mult/Times.  	
	 *  
	 *  @param f1: function object to multiply by.
	 */	
	@Override
	public void mul(function f) {
		function f1 = f.copy();

		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Times;
	}
	/**
			div function: 
	 *	Given a C.F and a function object sets a new C.F which will hold the old C.F on the
	new function object as left and the new function object to the right.  
	 * 	
	 * 		* Valid inputs: function type obj. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	Creating a new function object which will contain a copy of the class C.F
	 *  ** 	Sets the left to the "old" C.F
	 *  *** 	Sets the right to the f1 (input function object)
	 *  **** Sets the operation between left and right to be div.  	
	 *  
	 *  @param f1: function object to divide by.
	 */	
	@Override
	public void div(function f) {
		function f1 = f.copy();

		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Divid;

	}
	/**
		max function: 
	 *	Given a C.F and a function object sets a new C.F which will hold the old C.F on the
	new function object as left and the new function object to the right.  
	 * 	
	 * 		* Valid inputs: function type obj. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	Creating a new function object which will contain a copy of 'this' C.F
	 *  ** 	Sets the left to the "old" C.F
	 *  *** 	Sets the right to the f1 (input function object)
	 *  **** Sets the operation between left and right to be max.  	
	 *  
	 *  @param f1: function object to divide by.
	 */
	@Override
	public void max(function f) {
		function f1 = f.copy();

		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Max;

	}
	/**
		max function: 
	 *	Given a C.F and a function object sets a new C.F which will hold the old C.F on the
	    new function object as left and the new function object to the right.  
	 * 	
	 * 		* Valid inputs: function type obj. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	Creating a new function object which will contain a copy of 'this' C.F
	 *  ** 	Sets the left to the "old" C.F
	 *  *** 	Sets the right to the f1 (input function object)
	 *  **** Sets the operation between left and right to be min.  	
	 *  
	 *  @param f1: function object to divide by.
	 */
	@Override
	public void min(function f) {
		function f1 = f.copy();

		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Min;

	}
	/**
		comp function: 
	 *	Given a C.F and a function object sets a new C.F which will hold the old C.F on the
	    new function object as left and the new function object to the right.  
	 * 	
	 * 		* Valid inputs: function type obj. 
	 *  
	 * 
	 *					 Way of action:  
	 *
	 *  *	Creating a new function object which will contain a copy of 'this' C.F
	 *  ** 	Sets the left to the "old" C.F
	 *  *** 	Sets the right to the f1 (input function object)
	 *  **** Sets the operation between left and right to be comp.  	
	 *  
	 *  @param f1: function object to compute with.
	 */
	@Override
	public void comp(function f) {
		function f1 = f.copy();

		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Comp;

	}
	/**
		left function: 
	 *
	 *function return the left section of this Complex Function;
	 */
	@Override
	public function left() {	
		return this.left;
	}
	/**
		right function: 
	 *
	 *function return the right section of this Complex Function;
	 */
	@Override
	public function right() {
		return this.right;
	}
	/**
		get_op function: 
	 *
	 *function return the operation of this Complex Function left and right sections;
	 */
	@Override
	public Operation getOp() {
		return this.op;
	}
	/**
	 	toString function: 
	 *
	 *function return String of the Complex Function. 
	 */
	public String toString() { 

		if(op == Operation.None) {
			return ""+this.left;
		}
		if(right == null) {
			return op+"("+left.toString()+","+"0"+")";
		}
		return op+"("+left.toString()+","+right.toString()+")";
	}

	/**

		equals function: 
*	Given two Object (implementing to function) the function returns if the two mathematical object are logicly equal. 
*	The function is not 100 present 
* 	
* 		* Valid inputs: function type obj. 
*  
* 
*					 Way of action:  
*
*  *	Creating a new function object which will contain a copy of the class C.F
*  ** 	Sets the left to the "old" C.F
*  *** 	Sets the right to the f1 (input function object)
*  **** Sets the operation between left and right to be Plus.  	
*  
*  @param f1: function object to add to the C.F.
*/	
	@Override
	public boolean equals(Object obj) {

		function x = null;
		if(!(obj instanceof function)){
			throw new RuntimeException("Not a valid OBJ");
		}else if ( obj instanceof Monom) {
			x = new Monom(obj.toString());
		}else if (obj instanceof Polynom_able) {
			x = new Polynom(obj.toString());
		}else if (obj instanceof ComplexFunction) {
			x = this.initFromString(obj.toString());
		}else if(x == null) {
			throw new RuntimeException("Not a valid OBJ 2");
		}

		int Range = 2000; 
		int counter_Of_Match=0;

		for (double i = -2000; i < Range; i=i+0.1) {
			try {
				if(this.f(i) == x.f(i)) {
					counter_Of_Match ++;
				}		
			} 
			catch (Exception e) {}
		}
		if (Range-counter_Of_Match>10)
			return false;

		return true;
	}

}
