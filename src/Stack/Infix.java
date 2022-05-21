


/*
Infix —— 中缀表达式
 */
package Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Infix {
    //判断是否是运算符
    public static boolean isOper(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    //判断运算符优先级
    public static int priority(char oper){
        if(oper == '*' || oper == '/')
            return 1;
        else if(oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }

    //进行运算
    public static int operation(int num1 , int num2, char oper){
        switch (oper){
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return -1;

        }
    }
    public static int evaluate1(String s){
        //用来保存遍历到的字符
        char ch = ' ';
        //后面用来保存运算结果
        int rst = 0;
        //遍历字符串的下标
        int index = -1;
        //遇到多位数时，用来拼接字符的字符串
        String keepNum = "";
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> operStack = new LinkedList<>();
        while(true){
            index++;
            //字符串遍历结束，循环终止
            if(index >= s.length())
                break;
            //获得下标处的字符串
            ch = s.charAt(index);
            //遇到空格直接跳过
            if(ch == ' ')
                continue;
            //ch是数字，直接入栈
            if(!isOper(ch)){
                int i = index;
                while(i != s.length() && !isOper(s.charAt(i)) && s.charAt(i) != ' '){
                    keepNum += s.charAt(i);
                    i++;
                }
                index = i - 1;
                numStack.push(Integer.parseInt(keepNum));
                keepNum = "";
            }
            //ch不是数字
            else{
                //运算符栈为空,直接入栈
                if(operStack.isEmpty()){
                    operStack.push(ch);
                }
                //运算符栈不为空
                else{
                    //若运算符栈栈顶元素优先级大于或等于ch优先级，数栈出两个元素，
                    // 运算符栈出一个元素，进行运算，并将结果入栈,然后将当前运算符入栈
                    while(!operStack.isEmpty() && priority(operStack.peek()) >= priority(ch)){
                        rst = operation(numStack.pop() ,numStack.pop() ,operStack.pop());
                        numStack.push(rst);
                    }
                    //若栈顶运算符优先级小于ch，直接入栈
                    operStack.push(ch);
                }
            }
        }
        //当表达式遍历完之后，就顺序从字符栈和数栈弹出元素进行计算，
        // 并将结果存入数字栈，直到数字栈只有一个元素，该元素就是表达式的运算结果。
        while(!operStack.isEmpty()){
            rst = operation(numStack.pop(),numStack.pop(),operStack.pop());
            numStack.push(rst);
        }
        return numStack.pop();
    }

    static int evaluate2(String s){
        char ch = ' ';
        int rst = 0;
        int index = -1;
        //在判断多位数时，用于字符串的拼接
        String str = "";
        int flag = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch == ' ')
                continue;
            //ch是数字
            if(ch >= '0' && ch <= '9'){
                //判断多位数情况
                str = ch + "";
                int j = i + 1;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <='9'){
                    str += s.charAt(j);
                    j++;
                }
                i = j - 1;
                rst = Integer.parseInt(str);
                if(flag == 1){
                    rst *= st.pop();
                }
                else if(flag == 2){
                    rst  =st.pop() / rst;
                }
                else if(flag == 3){
                    rst *= -1;
                }
                st.push(rst);
                flag = 0;
            }
            //ch是运算符
            else{
                if(ch == '*') flag = 1;
                else if(ch == '/') flag = 2;
                else if(ch == '-') flag = 3;
                else flag = 0;
            }
        }
        //将栈里面的数字求和
        while(st.size() != 1){
            st.push(st.pop() + st.pop());
        }
        return st.pop();
    }

    /*public static int evaluate3(String s){

    }*/
    public static void main(String[] args) {
        System.out.println(evaluate1("20    -3  *4   /3+2"));
    }

}
