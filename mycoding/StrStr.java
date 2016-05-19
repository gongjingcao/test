package leetcode;

import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;

public class StrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();

		String haystack = "mississippi";
		String needle = "sippi";
		
		int re = strStr(haystack, needle);
		long t2 = System.currentTimeMillis();
		System.out.println(re+ " time: "+(t2-t1));

	}
	public static int strStr(String haystack, String needle) {
	    if(haystack==null || needle==null)    
	        return 0;
	 
	    if(needle.length() == 0)
	        return 0;
	        
	    Queue<Integer> q = new LinkedList<Integer>();
	 
	    int i = 0;
	    while( i<haystack.length()){
	        if(i + needle.length() > haystack.length())
	            return -1;
	 
	        int m = i;
	        
	        for(int j=0; j<needle.length(); j++){
	            if( m>i && haystack.charAt(m) == needle.charAt(0)) 
	            	q.offer(m);
	            
	            if(needle.charAt(j)==haystack.charAt(m)){
	                if(j==needle.length()-1) return i;
	                m++;
	            }else{
	                break;
	            }
	 
	        }
	        
	        if(q.isEmpty()){
	            i=m+1;
	        }else{
	            i = q.poll();
	        }
	    }   
	 
	    return -1;
	}

}
