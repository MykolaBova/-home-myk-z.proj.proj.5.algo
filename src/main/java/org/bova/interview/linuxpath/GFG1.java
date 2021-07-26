package org.bova.interview.linuxpath;

import java.util.Deque;
import java.util.LinkedList;

public class GFG1 {
        public static void main(String []args)
        {
                // absolute path which we have to simplify.
                String str = new String("/a/./b/../../c/");
                String res = simplifyPath(str);
                System.out.println(res);
        }

        public static String simplifyPath(String A) {

                if(A==null||A.length()==0)
                        return null;

                A = (String) A.subSequence(1, A.length());
                String[] arr = A.split("[/]+");
                Deque<String> stack = new LinkedList<String>();

                for (int i = 0; i < arr.length; i++) {
                        if (arr[i].equals("..")) {
                                if (!stack.isEmpty())
                                        stack.pop();
                        } else if(arr[i].matches("[a-zA-Z]+")){
                                stack.push("/" + arr[i]);
                        }
                }

                StringBuilder sb = new StringBuilder();
                if (stack.isEmpty())
                        return "/";

                while (!stack.isEmpty()) {
//                        sb.append(stack.removeLast());
                        sb.append(stack.pop());
                }

                return sb.toString();

        }
}
