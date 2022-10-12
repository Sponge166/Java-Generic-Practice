package genericpractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MoreComparators {

	public static void main(String args[]) {
		List<Number> nums = Arrays.asList(1, 3.25, 3.14, 3, 1.5, 12);
		
		System.out.println("before sort: " + nums);
		
		Collections.sort(nums, comparatorFactory((Number x) -> x.doubleValue()));
		
		System.out.println("after sort: " + nums);
		
		ArrayList<List<Double>> list2d = new ArrayList<List<Double>>();
		
		list2d.add(Arrays.asList(1.2, 6.8, 4.6));
		list2d.add(Arrays.asList(4.8, 2.1, 8.9));
		list2d.add(Arrays.asList(2.5, -.1, 2.0));
		list2d.add(Arrays.asList(0.1, 9.8, 6.7));
		
		System.out.println("before sort: " + list2d);
		
		Collections.sort(list2d, comparatorFactory( (List<Double> x) -> Collections.max(x) ));
		
		System.out.println("after sort: " + list2d);
	}
	
	public static <T, U extends Comparable<? super U>> Comparator<T> comparatorFactory(Function<? super T, ? extends U> func){
		return new Comparator<T>() {
			public int compare(T t1, T t2) {
				return func.apply(t1).compareTo(func.apply(t2));
			}
		};
	}
	
}
