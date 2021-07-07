package fivejuly;

import java.util.ArrayList;

public class Palindrome
{
    public static void main(String[] args)
    {
        ArrayList obj = new ArrayList();
        String s2 = "aabaa";
        String s1 = "123321";

        int i = 0;
        int j = s1.length() - 1;
        int count = 0;
        int ans = 1;
        while(i < j)
        {
            if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9' && s1.charAt(j) >= '0' && s1.charAt(j) <= '9')
            {
                count++;
            }

            if(s1.charAt(i) != s1.charAt(j))
            {
                ans = 0;
                break;
            }
            i++;
            j--;
        }


        if(ans == 0)
            System.out.println("not a palindrome");
        else
        {
            if(count == s1.length() / 2 && s1.charAt(i) >= '0' && s1.charAt(i) <= '9')
            {
                System.out.println("It is a numeric palindrome");
            }
            else
                System.out.println("It is character palindrome");
        }
    }
}
