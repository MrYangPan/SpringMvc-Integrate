package com.spring.mvc.controller;

/**
 * Created by Mr.PanYang on 2018/7/4.
 *
 * java  数据类型   （8bit = 1 byte）  8个比特位等于一个字节
 *
 *      基本数据类型：
 *
 *          数值类型：
 *
 *              整数类型：byte（8）、short（16）、int（32）、long（64）
 *
 *              浮点类型：float（32）、double（64）
 *
 *          字符类型：char（16）
 *
 *          布尔类型：boolean
 *
 *      引用数据类型：
 *
 *          类：class
 *
 *          接口：interface
 *
 *          数组
 *
 */
public class BaseDataTypeController {

    /**     基本数据类型占字节数：   byte（1）  short（2） int（4）  long（8）  float（4）  double（8）  char（2）
     *
     *      1 bit（比特位） =  00000000（8个元器件组成）
     *      1个元器件 ： 只能描述 0 或者 1  两种状态
     *
     *      1个      2       种状态
     *      2个      4       种状态
     *      3个      8       种状态
     *      8个      256     种状态
     *      ..................n 个元器件有 2 的 n 次方种状态
     *
    * */

    public void main(){

        byte b = 127;   //  一个字节的范围：256/2 = 128,  那么一个字节能容纳的范围是  [-128, 127]

        short s = 123; //  2^16 = 65536     65536/2= 32768      [-32768,    32767]

        int i =1;   //  2^32 = 4294967296   4294967296/2 = 2147483648     [-2147483648, 2147483647]

    }


}
