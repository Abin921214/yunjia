package com.jzhl.yunjia.utils;

import java.io.*;
import java.util.Random;

public class StringUtil {


    /**
     *  获取两位随机数
     */
    public static String getRandom2(){
        Random random = new Random();
        int ends = random.nextInt(99);
        String.format("%02d",ends);
        return String.valueOf(ends);
    }

    /**
     * 将String转成BCD码
     *
     * @param s
     * @return
     */
    public static byte [] StrToBCDBytes(String s)
    {

        if(s.length () % 2 != 0)
        {
            s = "0" + s;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        char [] cs = s.toCharArray ();
        for (int i = 0;i < cs.length;i += 2)
        {
            int high = cs [i] - 48;
            int low = cs [i + 1] - 48;
            baos.write (high << 4 | low);
        }
        return baos.toByteArray ();
    }
    /**
     * 将BCD码转成String
     *
     * @param b
     * @return
     */
    public static String bcdToString(byte [] b){
        StringBuffer sb = new StringBuffer ();
        for (int i = 0;i < b.length;i++ )
        {
            int h = ((b [i] & 0xff) >> 4) + 48;
            sb.append ((char) h);
            int l = (b [i] & 0x0f) + 48;
            sb.append ((char) l);
        }
        return sb.toString () ;
    }


    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    /**
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }


    /**
     * 将字节数组转换为16进制字符串
     * @param bytes
     * @return
     */
    public static String BinaryToHexString(byte[] bytes) {
        String hexStr = "0123456789ABCDEF";
        String result = "";
        String hex = "";
        for (byte b : bytes) {
            hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
            hex += String.valueOf(hexStr.charAt(b & 0x0F));
            result += hex + " ";
        }
        return result;
    }

    /**
     * @description 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * @description 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 10进制转16进制 高低转换 高前 低后   并且转2字节
     * @param var0
     * @return
     */
    public static String lowHigh(int var0) {
        int var1 = 1;
        int var2 = var0 >> 8;
        int var3 = var0 & 255;
        String var4 = Integer.toHexString(var2);
        String var5 = Integer.toHexString(var3);
        if(var4.length() > 2) {
            do {
                if(var1 > 1) {
                    var2 >>= 8;
                }
                var4 = Integer.toHexString(var2 >> 8);
                var5 = var5 + Integer.toHexString(var2 & 255);
                ++var1;
            } while(var4.length() > 2);
        }
        if(var4.length() < 2) {
            var4 = "0" + var4;
        }
        if(var5.length() < 2) {
            var5 = "0" + var5;
        }
        return var5 + var4;
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789abcdef".indexOf(c);
        return b;
    }


    /**
     * 实现异或
     * @param strHex_X
     * @param strHex_Y
     * @return
     */
    private static String xor(String strHex_X,String strHex_Y){
        //将x、y转成二进制形式
        String anotherBinary=Integer.toBinaryString(Integer.valueOf(strHex_X,16));
        String thisBinary=Integer.toBinaryString(Integer.valueOf(strHex_Y,16));
        String result = "";
        //判断是否为8位二进制，否则左补零
        if(anotherBinary.length() != 8){
            for (int i = anotherBinary.length(); i <8; i++) {
                anotherBinary = "0"+anotherBinary;
            }
        }
        if(thisBinary.length() != 8){
            for (int i = thisBinary.length(); i <8; i++) {
                thisBinary = "0"+thisBinary;
            }
        }
        //异或运算
        for(int i=0;i<anotherBinary.length();i++){
            //如果相同位置数相同，则补0，否则补1
            if(thisBinary.charAt(i)==anotherBinary.charAt(i))
                result+="0";
            else{
                result+="1";
            }
        }
//        System.out.println("code:" + result);
        return Integer.toHexString(Integer.parseInt(result, 2));
    }


    /**
     * 获取异或对应的编码
     * @param para
     * @return
     */
    public static String  checkcode(String para){
        int length = para.length()/2;
        String[] dateArr = new String[length];
        try {
            for (int i=0;i<length;i++){
                if(i==0){
                    dateArr[0] = para.substring(0, 2);
                }
                if(i==1){
                    dateArr[1] = para.substring(2, 4);
                }
                dateArr[i] = para.substring(i*2, i*2 + 2);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        String code = "";
        for (int i = 0; i < dateArr.length-1; i++) {
            if(i == 0){
                code = xor(dateArr[i], dateArr[i+1]);
            }else{
                code = xor(code, dateArr[i+1]);
            }
        }
        return code;
    }

    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }


    /**
     * 将byte数组转化为Object对象
     * @return
     */
    public static Object toObject(byte[] bytes){
        Object object = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);// 创建ByteArrayInputStream对象
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);// 创建ObjectInputStream对象
            object = objectInputStream.readObject();// 从objectInputStream流中读取一个对象
            byteArrayInputStream.close();// 关闭输入流
            objectInputStream.close();// 关闭输入流
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;// 返回对象
    }


    /**
     * 16 进制转 10 进制
     * @param hex
     * @return
     */
    public static int hexToDecimal(String hex)
    {
        int decimalValue=0;
        for(int i=0;i<hex.length();i++)
        {
            char hexChar=hex.charAt(i);
            decimalValue=decimalValue*16+hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char hexChar)
    {
        if(hexChar>='A'&&hexChar<='F')
            return 10+hexChar-'A';
        else
            return hexChar-'0';//切记不能写成int类型的0，因为字符'0'转换为int时值为48
    }


    /**
     * 这次算法用了StringBuffer效率更好
     *  10 进制转 16 进制
     */
    public static String intToHex(int n) {
        //StringBuffer s = new StringBuffer();
        StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        a = sb.reverse().toString();
        return a;
    }



    /**
     * java 字符串转16进制（包含汉字）
     * @param s
     * @return
     */
    public static String toChineseHex(String s)
    {
        String ss = s;
        byte[] bt = new byte[0];

        try {
            bt = ss.getBytes("GBK");
        }catch (Exception e){
            e.printStackTrace();
        }
        String s1 = "";
        for (int i = 0; i < bt.length; i++)
        {
            String tempStr = Integer.toHexString(bt[i]);
            if (tempStr.length() > 2)
                tempStr = tempStr.substring(tempStr.length() - 2);
            s1 = s1 + tempStr + "";
        }
        return s1.toUpperCase();
    }


    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append("0").append(str);// 左补0
            // sb.append(str).append("0");//右补0
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }


    public static void main(String[] args) {

//        System.out.println(intToHex(10));
//
//        System.out.println(toChineseHex("您好"));
////        String str = "020056ff008a 005ba000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
//        System.out.println(YunJiaUtil.getCardId10("7c4a6500"));
//
//
//        String ss  = "C0EEC7E5D5D5B3F6C3C5000000000000000000000000000000000000000000000000000000000000";
//        System.out.println(hexStr2Str(ss));
//        List<String> list = YunJiaUtil.getCardId10("00654a7c");
//        Collections.reverse(list);
//
//        StringBuffer stringBuffer = new StringBuffer();
//        for(String string:list){
//            stringBuffer.append(string);
//        }
//
//        System.out.println(stringBuffer.toString());

//        Random random = new Random();
//        int ends = random.nextInt(99);
//        String.format("%02d",ends);
//
//        System.out.println(ends);

        String data = "0200E700000032314E33313630314E333136300000000000000000000000130511091D2A060000000000000000007C4A6500363633383230348603";

        System.out.println(data.substring(100, data.length() - 4));

//        System.out.println(hexStr2Str(date.substring(56,68)));
//
//        System.out.println(hexStr2Str("36363338323034"));

    }

}
