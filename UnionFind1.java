package edu.neu.coe.info6205.union_find;


public class UnionFind1 {
	static UF_HWQUPC uf = null;
	static UF_HWQUPC_alternative1 uf_alter = null;
	
	public static void main(String[] args) {
		
		long start=0,end=0,time=0;
		int N = 100;
		System.out.println(("Lg("+N+") : "+ Math.floor(Math.log(N) / Math.log(2))) );
		
		
		/* Weighted Quick Union with size:[UF_HWQUPC.java from current INFO6205 repository] */
		System.out.println("While N = "+N);
		System.out.println("Weighted Quick Union with size:");
		int depth=0;
		start = System.nanoTime();		
		for(int i=0;i<10;i++) {	 /* I calculated 10 times and then calculate average time and average max depth*/
				uf = new UF_HWQUPC(N,false);
				count(N);
				depth+=uf.getMaxDepth();
		}
		end = System.nanoTime();
		time = (end-start);
		System.out.println("Average time:(with size) "+(time/10.0)/(1000000)+" ms");//nanosec to millisec
		System.out.println("Average max depth "+(depth/10.0)+" for size");

		/* Weighted Quick Union with rank/depth: [UF_HWQUPC_alternative1.java -> alternative code written ]*/
		System.out.println("Weighted Quick Union with rank/depth:");
		start = System.nanoTime();
		depth=0;
		for(int i=0;i<10;i++) {	
				uf_alter = new UF_HWQUPC_alternative1(N,false);
				count_alter(N);
				depth+= uf_alter.getMaxDepth();
			
		}
		end =	System.nanoTime();
		time = (end-start);
		
		System.out.println("Average time:(with depth) "+(time/10.0)/(1000000)+" ms");//nanosec to millisec
		System.out.println("Average max depth "+(depth/10.0)+" for depth");

	}

	public static int count(int N) {

		int random1 = 0;
		int random2 = 0;

		if (uf.components() == 1)
			return 1;
		int generation = 0;
		while (uf.components() != 1) {

			random1 = (int) (Math.random() * N);// 0 - (N-1)
			random2 = (int) (Math.random() * N);// 0 - (N-1)

			generation++;

			if (!uf.connected(random1, random2))
				uf.union(random1, random2);

		}
		return generation;
	}

	public static int count_alter(int N) {

		int random1 = 0;
		int random2 = 0;

		if (uf_alter.components() == 1)
			return 1;
		int generation = 0;
		while (uf_alter.components() != 1) {

			random1 = (int) (Math.random() * N);// 0 - (N-1)
			random2 = (int) (Math.random() * N);// 0 - (N-1)

			generation++;

			if (!uf_alter.connected(random1, random2))
				uf_alter.union(random1, random2);
		}
		return generation;
	}
}
