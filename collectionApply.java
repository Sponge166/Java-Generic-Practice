package genericpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class collectionApply {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,1);
//		Function<Integer, Integer> add1 = x -> x+1;

		ArrayList<Double> al = applyToAll(list, x -> x.doubleValue(), ArrayList::new);
		
		al.add(1.0);
		
		System.out.println(al);
	}
	
	public static <T, U, C extends Collection<U>> C applyToAll(Collection<? extends T> src, Function<? super T, ? extends U> func, Supplier<? extends C> s){
		
		return src.stream()
				.map(func::apply)
				.collect(Collectors.toCollection(s));
		
	}

}
