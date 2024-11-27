package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("pravin" ,22,1000,"ase"));
        emp.add(new Employee("rahul" ,29,400,"dev"));
        emp.add(new Employee("kivin" ,82,100,"user"));
        emp.add(new Employee("balaji" ,39,10,"emp"));

        Map<List<Employee> , String> map= new HashMap<>();
        map.put(emp,"new emp object");

        for (Map.Entry<List<Employee>,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for(Employee employee:emp){
            if(employee.getName().equals("pravin")){
                System.out.println("present");
                break;
            }else {
                System.out.println("not present ");

            }
        }

        Stream<Employee> str= emp.stream();





    }
}