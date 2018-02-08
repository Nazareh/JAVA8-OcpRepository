public class A {
	private int x = 10;
	class B {
		private int x = 20;
		class C {
			private int x = 30;
			
			public void allTheX() {
				System.out.println(x); // 30
				System.out.println(this.x); // 30
				System.out.println(B.this.x); // 20
				System.out.println(A.this.x); // 10
				//System.out.println(A.x); // 10 does not compile
			} 
		} 
	}
	
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B(); 
		B b2 = a.new B();  //Works because it  is available at the member level of A.
		A.B.C c = b.new C();
		//C c2 = b.new C(); // too deep for Java to know where to look
		c.allTheX();
	}
}