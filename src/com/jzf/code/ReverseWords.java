package com.jzf.code;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = reverseWords.reverseWords("  Life  doesn't  always    give     us  the       joys we want.");
        System.out.println(s);
    }
    public String reverseWords(String s){
        String[] s1 = s.split(" ");
        if(s1.length<2){
            return s;
        }
        String temps = null;
        for (int i = 0; i < s1.length/2; i++) {
            temps = s1[i];
            s1[i] = s1[s1.length-1-i];
            s1[s1.length-1-i] = temps;
        }
        StringBuilder sb = new StringBuilder();
        for (String s2 : s1) {
            if(s2.length()>0){
                sb.append(s2.trim());
                sb.append(" ");
            }

        }
        if (sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
