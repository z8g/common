package net.zhaoxuyang.common.pattern.memento;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class BeanUtils {
    public static HashMap<String, Object> backupProp(Object bean){
        HashMap<String, Object> result = new HashMap<>();
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor:descriptors){
                String name = descriptor.getName();
                Method getterMethod = descriptor.getReadMethod();
                Object fieldValue = getterMethod.invoke(bean, new Object[]{});
                if(name.equalsIgnoreCase("class")){
                    result.put(name, fieldValue);
                }
            }
        } catch(IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static void restoreProp(Object bean,HashMap <String,Object> propMap){
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor:descriptors){
                String name = descriptor.getName();
                System.err.println(name);
                if(propMap.containsKey(name)){
                    Method setterMethod = descriptor.getWriteMethod();
                    System.err.println(setterMethod);
                    setterMethod.invoke(bean, new Object[]{propMap.get(name)});
                }
            }
        }catch(IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
