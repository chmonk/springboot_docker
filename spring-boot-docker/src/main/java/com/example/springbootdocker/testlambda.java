package com.example.springbootdocker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import com.example.model.ancient;
import com.example.model.mainer;
import com.fasterxml.jackson.core.JsonProcessingException;

public class testlambda {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		Integer[] arr = new Integer[] { 3, 9, 87, 64, 5, 32 };

		Supplier<List<Integer>> list_supply = () -> Arrays.asList(arr);

		List<Integer> arr_list = Arrays.asList(arr);

		Collections.sort(arr_list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? 1 : -1;
			}
		});

		Collections.sort(arr_list, (o1, o2) -> o1 > o2 ? 1 : -1);

		System.out.println(arr_list);

//		LinkedList<Integer> o = new LinkedList<Integer>() {
//			{
//				addAll(list_supply.get());
//			}
//		};
//		System.out.println(o);

//		Integer ele = o.remove(3);
//		System.out.println(ele);
//		
//		o.indexOf(o);
//		
//		o.add(3, 8);
//		System.out.println(o);

//		ObjectMapper om = new ObjectMapper();
//
//		mainer<minerclass1> m = new mainer<>();
//		m.setMclass(new minerclass1());
//		System.out.println(om.writeValueAsString(m));
//
//		mainer<ancient> s = new mainer<>();
//		s.setMclass(new minerclass2());
//		System.out.println(om.writeValueAsString(s));
//
//		mainer<minerclass2> m2 = new mainer<>();
//
//		m2.setMclass(new minerclass2());
//
//		addmain(m2);
//
//		System.out.println(om.writeValueAsString(m2));

	}

	public static void addmain(mainer<? extends ancient> t) {
//
//		System.out.println("souot");
//
//		if (minerclass2.class.isInstance(t.getMclass())) {
//			((mainer<minerclass2>) t).setMclass(new minerclass2());
//		}
	}

}
