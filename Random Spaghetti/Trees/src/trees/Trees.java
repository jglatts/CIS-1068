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
package trees;

/**
 *
 * @author johng
 */
public class Trees {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(5);
        root.right.right = new Node(13);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        System.out.println("Searching a binary tree!! Is the value in the tree? " + ifNodeExists(root, 4));
        System.out.println("Searching a binary tree!! Is the value in the tree? " + ifNodeExists(root, 24));
    }
    
    public static boolean ifNodeExists(Node b, int val) {
        if (b == null) return false;  
        if (b.key == val) return true;  
        boolean res1 = ifNodeExists(b.left, val);  
        boolean res2 = ifNodeExists(b.right, val);  
        return res1 || res2;  
    }              
}
