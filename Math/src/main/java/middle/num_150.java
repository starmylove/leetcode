package middle;

import org.junit.Test;

import java.util.Stack;

public class num_150 {
    //150. 逆波兰表达式求值
    /*
    * 根据 逆波兰表示法，求表达式的值。有效的算符包括 +、-、*、/ 。
    * 每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    * 说明：    整数除法只保留整数部分。
    * 给定逆波兰表达式总是有效的。
    * 换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    * */
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1 ;
        for(String s :tokens){
            if("+".equals(s)){
                stack[top-1] += stack[top];
                top -- ;
            }else if("-".equals(s)){
                stack[top-1] -= stack[top];
                top -- ;
            }
            else if("*".equals(s)){
                stack[top-1] *= stack[top];
                top -- ;
            }else if("/".equals(s)){
                stack[top-1] /= stack[top];
                top -- ;
            }else {
                stack[++top] = Integer.valueOf(s);
            }
        }
        return stack[top];
    }
    @Test
    public void test(){
        evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
    }

}
