package br.org.iredeam.utils;

import java.lang.reflect.Field;

public class MergeUtil<T> {

    public static <T> T merge(T db, T request) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = db.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Field[] fieldsSuper = clazz.getSuperclass().getDeclaredFields();
        Object returnValue = clazz.newInstance();
        for (Field field : fields) {
            merge(db, request, field, returnValue);
        }
        for (Field field : fieldsSuper) {
            merge(db, request, field, returnValue);
        }
        return (T) returnValue;
    }

    private static <T> void merge(T db, T request, Field field, Object returnValue) throws IllegalAccessException {
        if (!field.getName().contains("serialVersionUID")) {
            field.setAccessible(true);
            Object value1 = field.get(db);
            Object value2 = field.get(request);
            Object value = (value1 != null) ? value1 : value2;
            field.set(returnValue, value);
        }
    }
}
