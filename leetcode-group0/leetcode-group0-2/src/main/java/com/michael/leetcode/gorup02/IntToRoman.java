package com.michael.leetcode.gorup02;

public class IntToRoman {


    public static String intToRoman(int num) {

        if (0 > num || num > 3999) return "";

        String result = "";

        int mod = 0;    // 余数
        int weishu = 0; // 位数

        while(num > 0) {
            mod = num % 10;
            num = num / 10;
            switch (weishu) {
                case 0: result = ge(mod)        + result; break;
                case 1: result = ten(mod)       + result; break;
                case 2: result = hundrad(mod)   + result; break;
                case 3: result = southsand(mod) + result; break;
                default: break;
            }
            weishu++;
        }
        return result;
    }


    public static String intToRoman2(int num) {

        StringBuilder sb = new StringBuilder();
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int n = value.length;

        for(int i = n - 1; i >= 0; i--) {
            if(num >= value[i]) {
                int count = num / value[i];
                num %= value[i];
                while(count-- > 0) {
                    sb.append(symbol[i]);
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

//        System.out.println(intToRoman(3999));
        System.out.println(intToRoman2(3999));

//        System.out.println(9%5);

    }


    public static String southsand(int count) {
        switch(count) {
            case 1: return "M";
            case 2: return "MM";
            case 3: return "MMM";
            default: return "";
        }
    }

    public static String hundrad(int count) {
        switch(count) {
            case 1: return "C";
            case 2: return "CC";
            case 3: return "CCC";
            case 4: return "CD";
            case 5: return "D";
            case 6: return "DC";
            case 7: return "DCC";
            case 8: return "DCCC";
            case 9: return "CM";
            default: return "";
        }
    }

    public static String ten(int count) {
        switch(count) {
            case 1: return "X";
            case 2: return "XX";
            case 3: return "XXX";
            case 4: return "XL";
            case 5: return "L";
            case 6: return "LX";
            case 7: return "LXX";
            case 8: return "LXXX";
            case 9: return "XC";
            default: return "";
        }
    }


    public static String ge(int count) {
        switch(count) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            default: return "";
        }
    }

}
