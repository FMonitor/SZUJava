package LAB3;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.lang.StringBuffer;

public class A_StringProceed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str);
        System.out.println("Original string: "+str);
        
        String newStr = "";
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            StringBuilder sb = new StringBuilder(temp);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            newStr += sb.toString();
            if(st.hasMoreTokens()) {
                newStr += " ";
            }
        }
        System.out.println("Uppercase string: "+newStr);
        
        StringBuffer sb = new StringBuffer(newStr);
        sb.reverse();
        System.out.println("Reversed String"+sb);
        sc.close();
    }
}