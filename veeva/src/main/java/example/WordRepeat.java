package example;

public class WordRepeat {
    public static void main(String[] args) {
        StringBuilder s= new StringBuilder("mask");
        int n=7;
        int i=0;
        int cnt=0;
        StringBuilder str= new StringBuilder();

        while (str.length()-1!=n){
            str.append(s.charAt(i));

            i++;
            if(i==s.length()){
                i=0;

            }

        }

        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j)=='a'){
                cnt++;
            }
        }
        System.out.println(str);
        System.out.println(cnt);
    }
}
