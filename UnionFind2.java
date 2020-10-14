package edu.neu.coe.info6205.union_find;

public class UnionFind2 {
	static WQUPC uf = null;
	static WQUPC_alternative2 uf_alter = null;
	
	public static void main(String[] args) {
		int N = 500000;
		System.out.println("While N = "+N);
		/*Weighted Quick Union with all intermediate node fix[WQUPC.java -> from INFO6205 repository ]*/
		System.out.println("Weighted Quick Union with all intermediate node fix:");
		double averDepthAtTheEnd=0;
		double averDepthDuring=0;
		
		long start = System.nanoTime();
		for(int i=0;i<10;i++) {
				uf = new WQUPC(N);
				count(N);
				averDepthDuring+=uf.getMaxDepth();
				averDepthAtTheEnd+= uf.calMaxDepth();
		}
		
		long end = System.nanoTime();
		long time = (end-start);
		System.out.println("Average time:(all intermediate node fix) "+(time/10.0)/(1000000)+" ms");//nanosec to millisec
		System.out.println("Average depth during construction: "+averDepthDuring/10.0);
		System.out.println("Average depth at the end of operation: "+averDepthAtTheEnd/10.0);

		
		
		/*Weighted Quick Union with grandparent node fix [WQUPC_alternative2.java -> alternative code written  */
		System.out.println("Weighted Quick Union with grandparent node fix:");
		averDepthAtTheEnd=0;
		averDepthDuring=0;
		start = System.nanoTime();
		for(int i=0;i<10;i++) {	
				uf_alter = new WQUPC_alternative2(N);
				count_alter(N);
				averDepthDuring+=uf_alter.getMaxDepth();
				averDepthAtTheEnd+= uf_alter.calMaxDepth();

		}
		end = System.nanoTime();
		time = (end-start);
		System.out.println("Average time:(with grandparent node fix) "+(time/10.0)/(1000000)+" ms");//nanosec to millisec
		System.out.println("Average depth during construction: "+ (averDepthDuring/10.0));
		System.out.println("Average depth at the end of operation: "+(averDepthAtTheEnd/10.0));
	}

	public static int count(int N) {

		int random1 = 0;
		int random2 = 0;

		if (uf.count() == 1)
			return 1;
		int generation = 0;
		while (uf.count() != 1) {

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

		if (uf_alter.count() == 1)
			return 1;
		int generation = 0;
		while (uf_alter.count() != 1) {

			random1 = (int) (Math.random() * N);// 0 - (N-1)
			random2 = (int) (Math.random() * N);// 0 - (N-1)

			generation++;

			if (!uf_alter.connected(random1, random2))
				uf_alter.union(random1, random2);
		}
		return generation;
	}
}
