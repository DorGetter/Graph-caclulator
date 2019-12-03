package Ex1;

public class ComplexFunction implements complex_function {

	function left, right;
	Operation op;
	
	public ComplexFunction() {}
	
	public ComplexFunction(Operation op, function left, function right) {
			
		if(op == Operation.None) {
			
			if(right ==null && left==null) {
				return;
			}
			if(right == null && left != null) {
				this.left = left;
				return;
			}
			if(left == null && right != null) {
				this.left = right;
				return;
			}
			if(left != null && right != null) {
				throw new RuntimeException("Not a valid in put");
			}
		}
		else {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public function initFromString(String s) {

		
		return null;
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void plus(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return op+"("+left.toString()+","+right.toString()+")";
	}

}
