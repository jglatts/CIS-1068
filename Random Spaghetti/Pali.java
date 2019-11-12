/*
 * The MIT License
 *
 * Copyright 2019 johng.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package glatts_john_assignment_7;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author johng
 */
public class Pali {

    private final String s;
    private static int tally = 0;
    
    public Pali(String s) {
        this.s = s;
    }
    
    /**
     * Check if a given string is a Palindrome or not
     * @param s, the string to check
     * @return recursive call or false
     */
    public static boolean isPali(String s) {
        int count = s.length()-1;
        if (s.length() < 2) 
            return true;
        else {
            for (int i = 0; i < s.length(); ++i, --count) {
                if (checkChars(s, i, count)) return isPali(s.substring(i+1, count));
                else return false;
            }
        }
        return false;
    }
    
    /**
     * Check if opposite chars are the same
     * @param s, the string to check
     * @param i, the starting index
     * @param count, the ending index
     * @return boolean
     */
    private static boolean checkChars(String s, int i, int count) {
        char first = s.charAt(0);
        char second = s.charAt(count);
        return first == second; 
    }    
    
    public static int getTally() { return tally; }
    
    public static void testPrep() {
        ArrayList test = new ArrayList();
        test.add("hey");
        test.add(2.0);
        test.add(420);
        System.out.println(test.toString());
        Object o = 123;
        Object e = 42.0;
        Object r = "sup";
        Object t = new Person(new File("john_fam.txt"));
        ArrayList<Object> z = new ArrayList<>();
        z.add(o);
        z.add(e);
        z.add(r);
        z.add(t);
        for (Object a : z)
            System.out.print(a.toString() + " ");
        System.out.println();
    }
    
    
}

