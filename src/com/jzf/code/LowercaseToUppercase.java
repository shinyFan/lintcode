package com.jzf.code;

public class LowercaseToUppercase {
    public static void main(String[] args) {
        LowercaseToUppercase lowercaseToUppercase = new  LowercaseToUppercase();
        char a = lowercaseToUppercase.lowercaseToUppercase('A');
        System.out.println(a);
    }
    public char lowercaseToUppercase(char character) {
        // write your code here
        if(character<='z'&&character>='a'){
            character= (char) (character-32);
        }else {
            character= (char) (character+32);
        }
        return character;
    }
}
