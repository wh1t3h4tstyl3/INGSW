package ingsw.template;

public abstract class RecursiveBacktracking {
	
	public final boolean solve(int min_val, int max_val) {
		int x = min_val;
		while (x <= max_val) {
			if (canAdd(x)) {
				add(x);
				if (isComplete())
					return true;
				else if (solve(min_val, max_val))
					return true;
				remove();
				x = next(x);
			} 
			
			else
				x = next(x);
		}
		return false;
	}
	
	protected abstract boolean canAdd(int x);
	protected abstract void add(int x);
	protected abstract boolean isComplete();
	protected abstract void remove();
	protected int next(int x) {
		return ++x;
	}
}
