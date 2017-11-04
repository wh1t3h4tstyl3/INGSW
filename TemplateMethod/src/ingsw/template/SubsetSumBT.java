package ingsw.template;

import java.util.LinkedList;

public class SubsetSumBT extends RecursiveBacktracking {

	private LinkedList<Integer> solutionSpace;
	private LinkedList<Integer> numbers;
	private int sum;
	private int total;
	
	public SubsetSumBT() {		
		init();
		solve(0, numbers.size()-1);
		printSolution();
	}
	
	private void init() {
		
		solutionSpace = new LinkedList<>();
		numbers = new LinkedList<>();
		sum = 0;
		total = 100;
		
		numbers.add(144);
		numbers.add(10);
		numbers.add(10);
		numbers.add(30);
		numbers.add(9);
		numbers.add(8);
		numbers.add(50);
		numbers.add(1);
		numbers.add(30);
	}
	
	private void printSolution() {
		for (int i = 0; i < solutionSpace.size(); i++) {
			System.out.println(numbers.get(solutionSpace.get(i)));
		}
	}
	
	private boolean contain(int x) {
		for (int i = 0; i < solutionSpace.size(); i++)
			if(solutionSpace.get(i).equals(x))
				return true;
		return false;
	}
	
	@Override
	protected boolean canAdd(int x) {
		if(contain(x))
			return false;
		if((sum + numbers.get(x)) > total) 
			return false;
		return true;
	}

	@Override
	protected void add(int x) {
		sum += numbers.get(x);
		solutionSpace.add(x);
	}

	@Override
	protected boolean isComplete() {
		return sum == total;
	}

	@Override
	protected void remove() {
		sum -= numbers.get(solutionSpace.removeLast());
	}
	
	public static void main(String[] args) {
		new SubsetSumBT();
	}
}
