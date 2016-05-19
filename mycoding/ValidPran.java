/* package whatever; // don't place package name! */

import java.util.*;
import java.util.ArrayList;

/* Name of the class has to be "Main" only if the class is public. */
class ValidPran
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = ")k)))())()())))())";
         List<String> ans = new ArrayList<String>();
         ans = removeInvalidParentheses( s);
         
         System.out.println("ans: "+ans);
	}
	
	public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        helper(set, s);
        ans.addAll(set);
        return ans;
    }
    
    public static void helper(HashSet<String> set, String s){
        if(s == null || s.length()==0) return;
        int L = 0, R =  0;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i)=='(') L++;
            if(s.charAt(i)==')') R++;
            if(L>=R && i != s.length()-1) continue;
            if(R==1&&L==0) {
                if(s.length() ==1){
                    return;
                }else{
                    helper(set, s.substring(0,i)+s.substring(i+1));
                    break;
                }
                
            }
            if(i == s.length()-1 && R ==0 && L>R) return;
            if(R > L){
                for(int j = 0; j<i;j++){
                    if(s.charAt(j)==')'&&s.charAt(j-1) != ')'){
                        helper(set,s.substring(0,j)+s.substring(j+1));
                    }
                }
            }
            if(i==s.length()-1&&L==R){
                set.add(s);
            }
        }
    }
}