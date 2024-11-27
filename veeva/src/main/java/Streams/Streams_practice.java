package Streams;

import java.util.Optional;
import java.util.stream.Stream;

@FunctionalInterface
interface MyFun{
    void print();
}

@FunctionalInterface
interface Add{
    int add(int a,int b);
}

public class Streams_practice {
    public static void main(String[] args) {
//
//        MyFun f=() -> System.out.println("pravin");
//        f.print();
//
//        Add d=(a, b) -> a+b;
//        System.out.println(d.add(4,5));



        //creating streams
//        Stream<String> stream=Stream.of("pravin","navin","raju");
//
//        List<String> list = Arrays.asList("a","b","c");
//        Stream<String> stream1=list.stream();
//
//        String[] fruits = {"Apple", "Banana", "Cherry"};
//        Stream<String> stream2 = Arrays.stream(fruits);
//
//        stream2.forEach(name-> System.out.println(name));


//        q1
        Stream<Integer> num= Stream.of(1,2,3,4,5);
//        num.map(number->number*number).forEach(n-> System.out.println(n));

//        q2
//        Stream<Integer> num= Stream.of(1,2,3,4,5);
//        num.filter(n->n%2==0).forEach(System.out::println);

//        q3
        //int answer= num.reduce(0,(a,b)->a+b);

//        q4
        Optional<Integer> maxint=num.max((x, y)->x.compareTo(y));

//        StringBuilder s= new StringBuilder("aba");
//        int n=7;
//        int i=0;
//        int cnt=0;
//        while (s.length()!=7){
//
//            s.append(s.charAt(i));
//            i++;
//        }
//
//        for (int j = 0; j < s.length(); j++) {
//            if(s.charAt(j)=='a'){
//                cnt++;
//            }
//        }
//        System.out.println(s);


    }
}
