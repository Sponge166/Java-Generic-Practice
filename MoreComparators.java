package genericpractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MoreComparators {

	public static void main(String args[]) {
		List<Number> nums = Arrays.asList(1, 3.25, 3.14, 3, 1.5, 12);
		
		Collections.sort(nums, comparatorFactory((Number x) -> x.doubleValue()));
		
		System.out.println(nums);
		
	}
	
	public static <T, U extends Comparable<? super U>> Comparator<T> comparatorFactory(Function<? super T, ? extends U> func){
		return new Comparator<T>() {
			public int compare(T t1, T t2) {
				return func.apply(t1).compareTo(func.apply(t2));
			}
		};
	}
	
}
