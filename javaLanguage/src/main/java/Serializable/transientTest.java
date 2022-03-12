package Serializable;

import org.junit.Test;

import java.io.*;

public class transientTest implements Serializable {
    private static final long serialVersionUID = 233858934995755239L;
    private String name1;
    private transient String name2;
    public transientTest(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }
    public static void main(String[] args) {
        String name1 = "常规属性" ,name2 = "transient修饰的属性";
        transientTest test = new transientTest(name1,name2);
        System.out.println("序列化前"+test);
        ObjectOutputStream outputStream;
        ObjectInputStream inputStream;
        String filePath = "D:/TransientTest.obj";
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            outputStream.writeObject(test);

            inputStream = new ObjectInputStream(new FileInputStream(filePath));
            transientTest readObject = (transientTest)inputStream.readObject();
            System.out.println("序列化后："+readObject.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "transientTest{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}
