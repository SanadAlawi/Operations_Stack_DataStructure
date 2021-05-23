package application;

public class Stack<T extends Comparable<T>> {
	private Node<T> top;
	private int length;
	
	public Stack(T data) { // Stack Constructor length
		Node<T> newNode = new Node<>(data);
		top = newNode;
		length++;
	}
	
	public Stack() { // Stack Constructor length
		
	}
	
	public void push(T data) { // Push method
		Node<T> newNode = new Node<>(data);
		if(isEmpty())
			top = newNode;
		else {
			newNode.setNext(top);
			top = newNode;
		}
		length++;
	} // end method
	
	public T pop() { // Pop method
		Node<T> de = null;
		if(isEmpty())
			System.out.println("The Satck is Empty!!!!");
		else {
		    de = top;
			top = top.getNext();
			length--;
		}
		return de != null ? de.getData() : null;
	} // end method
	
	public T peek() { // Peek method
		return top.getData();
	} // end method
	
	
	public void clean() { // Clean method
		top = null;
		length = 0;
	} // end method
	
	public boolean isEmpty() { // isEmpty method
		return top == null;
	} // end method
	
	public int lenght() {
		return this.length;
	}
	
}
