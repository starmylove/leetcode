package middle;

import java.util.HashMap;
import java.util.Map;

public class Offer_20 {
    //剑指 Offer 20. 表示数值的字符串
    /*
    * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    *   数值（按顺序）可以分成以下几个部分：
            若干空格
            一个 小数 或者 整数
            （可选）一个 'e' 或 'E' ，后面跟着一个 整数
            若干空格
        小数（按顺序）可以分成以下几个部分：
            （可选）一个符号字符（'+' 或 '-'）
            下述格式之一：
                至少一位数字，后面跟着一个点 '.'
                至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
                一个点 '.' ，后面跟着至少一位数字
        整数（按顺序）可以分成以下几个部分：
            （可选）一个符号字符（'+' 或 '-'）
            至少一位数字
        部分数值列举如下：
            ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
        部分非数值列举如下：
            ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
    * */
    public boolean isNumber(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int index = 0 ;
        //第一部分，若干空格（可选）
        while (chars[index]==' ') {
            index++;
        }
        if(index==length) {
            return false;//默认是正数，如果遇到'-'再改为负数
        }

        //第二部分 一个小数或整数
        boolean neg = false;
        if(index < length && (chars[index] == '-'||chars[index] == '+')){
            neg = chars[index] == '-' ? true : false;
            index++;
        }
        //判断完数字的符号了，接下来判断数字

        //如果数字部分除符号位第一位不是数字或小数点，则返回false
        if(index==length||(chars[index]<48||chars[index]>57)&&chars[index]!='.') {
            return false;
        }

        double first = 0.0;
        //如果是首位是小数点
        if(chars[index]=='.'){
            index++;
            if(index==length) {
                return false;
            }
            double r = 0.1;
            while (index<length&&chars[index]<=57&&chars[index]>=48){
                first += (((int)chars[index])-48)*r;
                r *= 0.1;
            }
            if(index==length) {
                return true;
            }

        }
        //如果是首位不是小数点
        return true;
    }

    //官方题解
    public boolean isNumber2(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }


}
