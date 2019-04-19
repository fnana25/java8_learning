package com.test.jvm.classloader;

import java.io.*;

/**
 * 自定义类加载器
 *
 * @author fengna
 * @date 2019/4/18
 */
public class Loader11 extends ClassLoader{

    private String classLoaderName;

    private final String classExtension = ".class";

    public Loader11(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public Loader11(ClassLoader parent,String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString(){
        return "classLoaderName = " + classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name){

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        this.classLoaderName = this.classLoaderName.replace('.','/');
        try {
            is = new FileInputStream(new File(name + this.classExtension));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())){
                byteArrayOutputStream.write(ch);
            }
            data = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.test.jvm.classloader.Loader11");
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Loader11 loader11 = new Loader11("loader11");
        test(loader11);
    }
}
