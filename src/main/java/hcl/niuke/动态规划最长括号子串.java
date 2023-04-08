package hcl.niuke;

import java.util.Stack;

/*
给出一个长度为 n 的，仅包含字符 '(' 和 ')' 的字符串，计算最长的格式正确的括号子串的长度。

例1: 对于字符串 "(()" 来说，最长的格式正确的子串是 "()" ，长度为 2 .
例2：对于字符串 ")()())" , 来说, 最长的格式正确的子串是 "()()" ，长度为 4 .

字符串长度：0≤n≤5∗10要求时间复杂度
O(n) ,空间复杂度O(n).
 */
public class 动态规划最长括号子串 {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses (String s) {
        // write code here.
        int max=0;
        int count=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else {
                st.pop();
                if(!st.empty()){
                    max=Math.max(max,i-st.peek());
                }else{
                    st.push(i);
                }
            }
        }
        return max;
    }

    public int longestValidParentheses2 (String s) {
        // write code here.
        int[]dp=new int [s.length()];
        int max=0;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if((i-dp[i-1]-1)>=0 &&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+2;

                    if(i-dp[i-1]-2>=0){
                        dp[i]+=dp[i-dp[i-1]-2];
                    }
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        String test=")()(()()((((((())(";
        动态规划最长括号子串 function=new 动态规划最长括号子串();
        System.out.println(function.longestValidParentheses2(test));
    }
}
