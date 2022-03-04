package com.example.springbootdocker;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class flatmap_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		flatmap_practice _flatmap_practice = new flatmap_practice();

		flatmap_practice.Department depart_a = _flatmap_practice.new Department("A");
		depart_a.addEmployees(_flatmap_practice.new empolyee("john", 33));
		depart_a.addEmployees(_flatmap_practice.new empolyee("mary", 22));
		depart_a.addEmployees(_flatmap_practice.new empolyee("mark", 11));

		flatmap_practice.Department depart_b = _flatmap_practice.new Department("B");
		depart_a.addEmployees(_flatmap_practice.new empolyee("karma", 44));
		depart_a.addEmployees(_flatmap_practice.new empolyee("Eric", 55));

		Supplier<Stream<Department>> aaa = () -> Stream.of(depart_a, depart_b);

		Stream<List<empolyee>> mapres = aaa.get().map((depart) -> depart.getEmployees());

		Stream<empolyee> ans = mapres.flatMap(List::stream);

		ans.map(empolyee::getName).forEach(System.out::println);

		System.out.println("------------------------------------");

		Stream<empolyee> mapres22 = aaa.get().flatMap((depart) -> depart.getEmployees().stream());

		mapres22.map(empolyee::getName).forEach(System.out::println);

		List<Object> test1 = new LinkedList<>();

//		test1.get(0)    ;

//		if (test1.size() > 1) {
//			return test.get(0).get("");
//		} else {
//			return "";
//		}

		System.out.println(test1.isEmpty());

	}

	class Department {

		String depart_name;

		List<empolyee> employees;

		public Department() {
			super();
			this.employees = new LinkedList<>();
		}

		public Department(String depart_name) {
			super();
			this.depart_name = depart_name;
			this.employees = new LinkedList<>();
		}

		public String getName() {
			return depart_name;
		}

		public void setName(String name) {
			this.depart_name = name;
		}

		public List<empolyee> getEmployees() {
			return employees;
		}

		public void addEmployees(empolyee employee) {
			this.employees.add(employee);
		}
	}

	class empolyee {

		String name;

		int age;

		public empolyee(String name) {
			super();
			this.name = name;
			this.age = 999;
		}

		public empolyee(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

}
