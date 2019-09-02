/**
 * Author:Sophie
 * Created: 2019/9/2
 */

/**
 * try,catch，finally中有无return语句的执行顺序
 */
//我们知道有异常时会执行catch，finally块；无异常会执行try，catch块
//所以在这里我们从这两种大情况入手
public class Test {
    int a;
    public static void main(String[] args) {
        System.out.println("------无异常情况下---------");
        System.out.println("finally中无return语句，返回的是基本数据类型"+test1());//1
        System.out.println("finally中无return语句，返回的是同一个引用数据类型"+test2().a);//3
        System.out.println("finally中无return语句，返回的是不同的引用数据类型"+test3().a);//1
        System.out.println("try，finally中都有return语句,返回的是基本数据类型"+test4());//3
        System.out.println("try，finally中都有return语句，返回的是同一个引用数据类型"+test5().a);//3
        System.out.println("try，finally中都有return语句，返回的是不同的引用数据类型"+test6().a);//3

        System.out.println("------有异常情况下---------");
        System.out.println("finally中无return语句，返回的是基本数据类型"+test7());//2
        System.out.println("finally中无return语句，返回的是同一个引用数据类型"+test8().a);//3
        System.out.println("finally中无return语句，返回的是不同的引用数据类型"+test9().a);//2
        System.out.println("catch，finally中都有return语句,返回的是基本数据类型"+test10());//3
        System.out.println("catch，finally中都有return语句，返回的是同一个引用数据类型"+test11().a);//3
        System.out.println("catch，finally中都有return语句，返回的是不同的引用数据类型"+test12().a);//3


        /**
         * 总结：只要finally中有return语句，返回的就是finally中修改后的值；
         *      如果finally中没有的话，基本数据类型返回是try中的值（无异常时）或catch中的值（有异常时），
         *    同一个引用数据类型的变量返回的是执行完finally语句之后的引用数据变量的值，不同的引用类型数据的变量返回的是try或catch中的引用数据类型的变量
         */



    }
    //无异常：只有try，catch中有return语句
    //1、try，catch中返回的是基本数据类型的变量
    public static int test1(){
        int i=0;
        try{
            i=1;
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
        }
    }
    public static Test test2(){
        Test test=new Test();
        try{
            test.a=1;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test.a=3;
        }
    }
    public static Test test3(){
        Test test=new Test();
        try{
            test.a=1;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test=new Test();
            test.a=3;
        }
    }
    //无异常：try，finally中都有return语句
    //1、try，catch中返回的是基本数据类型的变量
    public static int test4(){
        int i=0;
        try{
            i=1;
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
            return i;
        }
    }

    //2、try，catch中返回是同一个引用数据类型的变量
    public static Test test5(){
        Test test=new Test();
        try{
            test.a=1;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test.a=3;
            return test;
        }
    }
    //3、try，catch中返回的是不同的引用数据类型的变量
    public static Test test6(){
        Test test=new Test();
        try{
            test.a=1;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test.a=3;
            return test;
        }
    }



    //1、try，catch中返回的是基本数据类型的变量
    public static int test7(){
        int i=0;
        int m=1;
        try{
            i=1;
            m/=0;
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
        }
    }
    public static Test test8(){
        Test test=new Test();
        int m=1;
        try{
            test.a=1;
            m/=0;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test.a=3;
        }
    }
    public static Test test9(){
        Test test=new Test();
        int m=1;
        try{
            test.a=1;
            m/=0;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test=new Test();
            test.a=3;
        }
    }
    public static int test10(){
        int i=0;
        int m=1;
        try{
            i=1;
            m/=0;
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
            return i;
        }
    }

    //2、try，catch中返回是同一个引用数据类型的变量
    public static Test test11(){
        int m=1;
        Test test=new Test();
        try{
            test.a=1;
            m/=0;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test.a=3;
            return test;
        }
    }
    public static Test test12(){
        int m=1;
        Test test=new Test();
        try{
            test.a=1;
            m/=0;
            return test;
        }catch (Exception e){
            test.a=2;
            return test;
        }finally {
            test.a=3;
            return test;
        }
    }
}
