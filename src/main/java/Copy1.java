import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;

import java.io.*;

/**
 * Author:Sophie
 * Created: 2019/8/19
 */

/**
 * 深浅拷贝的两种实现方式：Cloneable，Serializable
 */
public class Copy1 implements Serializable,Cloneable{
    //浅拷贝
    public static void code1() {
        Student student=new Student();
        student.setName("学生1");
        Course course=new Course("语文","语文老师");
        student.setCourse(course);
        try {
            Student student1=student.clone();
            student1.setName("学生2");
            student1.getCourse().setCourseName("数学");
            student1.getCourse().setTeacher("数学老师");
            System.out.println(student);
            System.out.println(student1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    //深拷贝(实现Cloneable接口)
    //深拷贝(实现对象序列化)
    public static void code2() {
        Student student=new Student();
        student.setName("学生1");
        Course course=new Course("语文","语文老师");
        student.setCourse(course);
        Student student1=student.clone1();
        student1.setName("学生3");
        student1.getCourse().setCourseName("高数");
        student1.getCourse().setTeacher("高数老师");
        System.out.println(student);
        System.out.println(student1);

    }

    public static void code3() {
        Student student=new Student();
        student.setName("学生1");
        Course course=new Course("语文","语文老师");
        student.setCourse(course);
        Student student1=student.clone2();
        student1.setName("学生4");
        student1.getCourse().setCourseName("英语");
        student1.getCourse().setTeacher("英语老师");
        System.out.println(student);
        System.out.println(student1);
    }


    public static void main(String[] args) {
        code1();
        code2();
        code3();
    }
}
@Data
class Student implements Serializable,Cloneable {
    private  String name;
    private  Course course;

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public Student clone1() {
        Student student = new Student();
        student.setName(this.name);
        try {
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this.course);
            objectOutputStream.close();
            ByteArrayInputStream inputStream=new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            student.setCourse((Course) objectInputStream.readObject());
            objectInputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student clone2(){
        Student student=new Student();
        student.setName(this.name);
        Course course=new Course(this.course.getCourseName(),this.course.getTeacher());
        student.setCourse(course);
        return student;
    }
}
@Data
class Course implements Serializable,Cloneable{
    private String courseName;
    private String teacher;

    public Course(String courseName, String teacher) {
        this.courseName=courseName;
        this.teacher=teacher;
    }

}


