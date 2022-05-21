package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
  前缀表达式 —— 波兰表达式
  前缀表达式的运算符在操作数之前
  例：(3 + 4)* 5 - 6    ===>    - * + 3 4 5 6
 */

public class suffix {
    //判断是否是运算符
    public static boolean isOpear(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    //进行计算
    public static int operation(int nums1, int nums2, String op){
        int rnt = 0;
        if(op.equals("+")) rnt = nums1 + nums2;
        else if(op.equals("-")) rnt = nums2 - nums1;
        else if(op.equals("*")) rnt = nums1*nums2;
        else rnt = nums2 / nums1;
        return rnt;
    }
    //返回运算符的优先级
    public static int priority(char oper){
        if(oper == '*' || oper == '/')
            return 1;
        else if(oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }
    //后缀表达式求值
    public static int evaluate(List<String> tokens){
        Stack<Integer> Stack = new Stack<>();
        String s = "";
        int rst = 0;
        for(int i = 0; i < tokens.size(); i++){
            s = tokens.get(i);
            //如果是运算符
            if(isOpear(s)){
                rst = operation(Stack.pop(),Stack.pop(),s);
                Stack.push(rst);
            }
            else{
                Stack.push(Integer.parseInt(s));
            }
        }
        return Stack.pop();
    }

    //中缀转后缀表达式
     static List<String> infixToSuffix(String s){
        Stack<String> s1 = new Stack<>();
        List<String> s2  = new ArrayList<>();
         int i = 0;
         while(s.charAt(i) == ' '){
             i++;
         }
         if(s.charAt(i) == '-'){
             s2.add("0");
         }
        String str = "";
        char ch = ' ';
        for(; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch == ' ') continue;
            //如果是数字
            if(ch >= '0' && ch <='9'){
                //注意多位数的情况
                int j = i + 1;
                //str赋初值
                str = ch + "" ;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                    str += s.charAt(j);
                    j++;
                }
                s2 .add(str);
                i = j - 1;
            }
            else{
                //当ch == ')'时，将s1中的符号不断弹出s2，直到遇到了"("
                if(ch == ')'){
                    while(!s1.isEmpty() && !s1.peek().equals("(")){
                        s2 .add(s1.pop()) ;
                    }
                    //将"("弹出s1
                    s1.pop();
                }
                else if(ch == '('){
                    s1.push(ch+"");
                    if(s.charAt(i+1) == '-'){
                        s2.add("0");
                    }
                }
                //当ch == '('时直接入s1,当栈顶为'('时，ch直接入s1
                else if(s1.isEmpty() || s1.peek().equals("("))
                    s1.push(ch+"");
                //当ch优先级大于栈顶符号优先级时，ch直接入栈
                else if(priority(ch) > priority(s1.peek().charAt(0))){
                    s1.push(ch + "");
                }
                //将s1栈顶元素加入s2，直到s1栈顶元素优先级小于ch,再将ch入s1
                else{
                   do{
                       s2 .add(s1.pop());
                   }while(!s1.isEmpty() && priority(ch) <= priority(s1.peek().charAt(0)));
                   s1.push(ch + "");
                }
            }
        }
        //最后将s1中元素全部加入s2
        while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        return s2;
    }


    public static void main(String[] args) {
        //String[] tokens = {"2","1","+","3","*"};
        //System.out.println(evaluate(tokens));
        String s = "-(-1)";
        System.out.println(infixToSuffix(s));
        System.out.println(evaluate(infixToSuffix(s)));
    }
}
