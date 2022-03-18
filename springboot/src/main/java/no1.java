import java.util.Arrays;

public class no1 {
    public static void main(String[] args) {
        StringBuilder n1 = new StringBuilder();
        String p1 = "abcdef";
        String p2 = "ghij";
        String p3 = "klmn";
        String p4 = "abc";
        String p5 = "defgh";
        String p6 = "ijklmn";
        String s = new String(p1 + p2 + p3 + p4 + p5 + p6);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder n=new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(i!=chars.length-1&&chars[i]!=chars[i+1]){
                n.append(chars[i]);
            }
        }
        n.append(chars[chars.length-1]);
        System.out.println(n.toString());
    }
}
