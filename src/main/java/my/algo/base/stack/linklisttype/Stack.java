package my.algo.base.stack.linklisttype;

public class Stack<Item> {
  
	private Node first = null;
	
	private class Node{
		Node next;
		Item item;
	}
	
	public void push(Item item) {
		Node oldNode = first;
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = oldNode;
		this.first = newNode;
	}
	
    public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
    }

    public boolean isEmpty() {
    	  return first == null;
    }
    
   
}

