package Ex1;

public class ComplexFunction implements complex_function {

	private function left, right;
	private Operation op=Operation.None;
	
	private ComplexFunction() {}
	
	public ComplexFunction(function p1) {
		this.op = Operation.None;
		this.left = p1;
	}
	
	public ComplexFunction(String op, function left, function right) {
		
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
	
	public ComplexFunction(Operation op, function left, function right) {
			
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
	
	@Override
	public double f(double x) {
		double ans =0;
	/*	
		if(this.right == null) {
			ans=left.f(x);
		}
		else
	*/	
		ans=op_func(x);
		return ans;
	}

	private double op_func(double x) {
		
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

	@Override
	public function copy() {
		
		function copy_obj = new ComplexFunction(this.op,this.left,this.right);
		return copy_obj;
	}

	@Override
	public void plus(function f1) {
		
		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Plus;
		
	}

	@Override
	public void mul(function f1) {
		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Times;
	}

	@Override
	public void div(function f1) {
		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Divid;
		
	}

	@Override
	public void max(function f1) {
		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Max;
		
	}

	@Override
	public void min(function f1) {
		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Min;
		
	}

	@Override
	public void comp(function f1) {
		function new_left = this.copy();
		this.left = new_left;
		this.right = f1;
		this.op = Operation.Comp;
		
	}

	@Override
	public function left() {	
		return this.left;
	}

	@Override
	public function right() {
		return this.right;
	}

	@Override
	public Operation getOp() {
		return this.op;
	}
	
	public String toString() { 
		
		if(op == Operation.None) {
			return ""+this.left;
		}
		if(right == null) {
			return op+"("+left.toString()+","+"0"+")";
		}
		return op+"("+left.toString()+","+right.toString()+")";
	}

}
