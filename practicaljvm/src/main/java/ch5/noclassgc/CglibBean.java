package ch5.noclassgc;

import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CglibBean {
    /**
     * 实体Object
     */
    public Object object = null;


    public CglibBean() {
        super();
    }


    public CglibBean(String className,Map propertyMap) {
        this.object = generateBean(className,propertyMap);
    }


    /**
     * 得到该实体bean对象
     *
     * @return
     */
    public Object getObject() {
        return this.object;
    }

    private Object generateBean(final String className,Map propertyMap) {
        BeanGeneratorObj generator = new BeanGeneratorObj();
        generator.setUseCache(false);
        generator.setClassLoader(new ClassLoader(){

        });
        generator.setNamingPolicy(new NamingPolicy() {

            public String getClassName(String prefix, String source, Object key, Predicate names) {
                return className;
            }
        });

        Set keySet = propertyMap.keySet();
        for (Iterator i = keySet.iterator(); i.hasNext();) {
            String key = (String) i.next();
            generator.addProperty(key, (Class) propertyMap.get(key));
        }
        return generator.create();
    }
}
