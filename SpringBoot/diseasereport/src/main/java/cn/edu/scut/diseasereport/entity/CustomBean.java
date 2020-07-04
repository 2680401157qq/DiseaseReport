package cn.edu.scut.diseasereport.entity;

import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 20:36
 * @description:
 */
public class CustomBean {
    //动态生成的类
    private Object mObject = null;
    //存放属性名称以及属性的类型
    private BeanMap mBeanMap = null;

    public CustomBean() {
        super();
    }

    public CustomBean(Map propertyMap) {
        this.mObject = generateBean(propertyMap);
        this.mBeanMap = BeanMap.create(this.mObject);
    }

    /**
     * @param propertyMap
     * @return
     */
    private Object generateBean(Map propertyMap) {
        BeanGenerator beanGenerator = new BeanGenerator();
        Set keySet = propertyMap.keySet();
        for (Iterator i = keySet.iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            beanGenerator.addProperty(key, (Class) propertyMap.get(key));
        }
        return beanGenerator.create();
    }

    /**
     * 给Bean属性赋值
     *
     * @param property 属性名
     * @param value    值
     */
    public void setValue(String property, Object value) {
        mBeanMap.put(property, value);
    }

    /**
     * 通过属性名得到属性值
     *
     * @param property
     * @return
     */
    public Object getValue(String property) {
        return mBeanMap.get(property);
    }

    /**
     * 得到该实体Bean对象
     *
     * @return
     */
    public Object getObject() {
        return this.mObject;
    }
}
