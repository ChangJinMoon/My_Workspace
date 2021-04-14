
public class Stack {
	
	int top;
	
	Value value[] = new Value[1000];
	
	Stack(){
		top = 0;
 		for(int i = 0; i<1000;i++) value[i] = new Value();
	}
	
	Value pop() {
		--top;
		Value previous = new Value();
		previous.row = value[top].row;
		previous.col = value[top].col;
		value[top].row = 0; value[top].col = 0;
		return previous;
	}
	
	void push(int r,int c) {
		value[top].row = r;
		value[top].col = c;
		top++;
	}
	

}
