package com.nested.classes;

public class OuterClass {
	
	private int num = 27000;
	
	
	static class StaticNestedClass{
				
		int getNum() {
			return 1000;
		}
	}
	
	class InnerClass{
		int getNum() {
			return num;
		}
	}
	
		
	public static void main(String[] args) {
		OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
		System.err.println(nestedObject.getNum());
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
		System.out.println(inner.getNum());
		
		
	}

}
