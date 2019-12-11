package com.mogila;


import com.mogila.hobby.Fishing;
import com.mogila.hobby.Hobby;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class.forName("com.mogila.hobby.Hobby");

        System.out.println(Arrays.toString(Class.forName("com.mogila.hobby.Hobby").getDeclaredMethods()));
        System.out.println(Arrays.toString(Class.forName("com.mogila.hobby.Hobby").getDeclaredFields()));
        System.out.println(Arrays.toString(Class.forName("com.mogila.hobby.Hobby").getConstructors()));


        Hobby hobby = new Fishing("name1",12,'S',"name2");
        Class clazz = hobby.getClass();

        Method method =  clazz.getMethod("test", int.class, String.class, double.class);
        method.invoke(hobby,10,"test",20.5);

       Field field = hobby.getClass().getDeclaredField("favoriteFish");
       field.setAccessible(true);
       field.set(hobby,"ModifyFavoriteFish");
        System.out.println(field.get(hobby));





    }
}
