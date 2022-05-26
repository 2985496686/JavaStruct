package Algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
力扣：241. 为运算表达式设计优先级
思想：递归，分治，以运算符为界将表达式拆分
例：2-1+1
拆法如下：
（1）2 和1+1
     2不用继续拆，1-1继续拆，拆成1和1
（2）2-1 和 1
     2-1拆除2和1，1不用拆
拆分使用递归的方式
 */
public class DifferentWaystoAddParentheses {
    public List<Integer> calculation(String ex){
        List<Integer> list = new ArrayList<>();
        if(ex.length() == 1){
            list.add(ex.charAt(0) - '0');
            return list;
        }
        if(ex.length() == 2){
            list.add((ex.charAt(0) - '0')*10 + (ex.charAt(1) - '0'));
            return list;
        }
        for(int m = 0; m < ex.length(); m++){
            if(ex.charAt(m) >= '0' && ex.charAt(m) <= '9') continue;
            List<Integer> a = calculation(ex.substring(0,m));
            List<Integer> b = calculation(ex.substring(m + 1));
            if(ex.charAt(m) == '+') {
                for(int i = 0; i < a.size(); i++){
                    for(int j = 0; j < b.size(); j++){
                        list.add(a.get(i) + b.get(j));
                    }
                }
            }
            else if(ex.charAt(m) == '-'){
                for(int i = 0; i < a.size(); i++){
                    for(int j = 0; j < b.size(); j++){
                        list.add(a.get(i) - b.get(j));
                    }
                }
            }
            else{
                for(int i = 0; i < a.size(); i++){
                    for(int j = 0; j < b.size(); j++){
                        list.add(a.get(i) * b.get(j));
                    }
                }
            }
        }
        return list;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return calculation(expression);
    }
}
