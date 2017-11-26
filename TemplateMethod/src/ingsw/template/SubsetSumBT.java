package ingsw.template;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetSumBT extends RecursiveBacktracking {

	private LinkedList<Integer> solutionSpace;
	private List<Integer> numbers;
	private int sum;
	private int total;
	
	public SubsetSumBT(List<Integer> numbers, int total) {		
		this.numbers = numbers;
		this.total = total;
		solutionSpace = new LinkedList<>();
		sum = 0;
		solve(0, numbers.size()-1);
	}
	
	public void printSolution() {
		System.out.println(this);
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
		List<Integer> numbers = Arrays.asList(3, 34, 4, 12, 5, 2);
		SubsetSumBT subsetSum = new SubsetSumBT(numbers, 9);
		subsetSum.printSolution();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < solutionSpace.size()-1; i++)
			builder.append((numbers.get(solutionSpace.get(i))) + ",");
		builder.append(numbers.get(solutionSpace.getLast()) + "]");
		return builder.toString();
	}
}
