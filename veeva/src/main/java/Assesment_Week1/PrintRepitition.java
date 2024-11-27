package Assesment_Week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PrintRepitition {
    public static void main(String[] args) throws IOException {
        Path path= Paths.get("/Users/Pravin KumarPrajapat/IdeaProjects/veeva/src/main/java/Assesment_Week1/test.txt");
        BufferedReader br= new BufferedReader(new FileReader(String.valueOf(path)));
//        System.out.println(br.readLine());
        String line = null;
        Map<String,Integer> map= new HashMap<>();
        while((line=br.readLine())!=null){
            String[] arr= line.split(" ");
//            System.out.println(line);
            for(String s:arr){
                if(map.containsKey(s.trim())){
                    System.out.println(s);
                }else {
                    map.put(s.trim(),1);
                }
            }

        }
    }
}
