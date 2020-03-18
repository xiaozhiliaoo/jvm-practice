package ch5.noclassgc;
import net.sf.cglib.asm.ClassVisitor;
import net.sf.cglib.asm.Type;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.ClassEmitter;
import net.sf.cglib.core.Constants;
import net.sf.cglib.core.EmitUtils;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class BeanGeneratorObj extends BeanGenerator{
    public BeanGeneratorObj() {  
        super();  
    }  
  
    private Map props = new HashMap();  
  
    public void addProperty(String name, Class type) {  
        super.addProperty(name, type);  
        if (props.containsKey(name)) {  
            throw new IllegalArgumentException("Duplicate property name \"" + name + "\"");  
        }  
        props.put(name, Type.getType(type));  
    }  
  
    public void generateClass(ClassVisitor v) throws Exception {  
        int size = props.size();  
        String[] names = (String[]) props.keySet().toArray(new String[size]);  
        Type[] types = new Type[size];  
        for (int i = 0; i < size; i++) {  
            types[i] = (Type) props.get(names[i]);  
        }  
        ClassEmitter ce = new ClassEmitter(v);  
        ce.begin_class(Constants.V1_2, Constants.ACC_PUBLIC, getClassName(),  
                getDefaultClassLoader() != null ? Type.getType(getDefaultClassLoader().getClass())  
                        : Constants.TYPE_OBJECT, null, null);  
        EmitUtils.null_constructor(ce);  
        add_properties(ce, names, types);  
        ce.end_class();  
    }  
      
    private void add_properties(ClassEmitter ce, String[] names, Type[] types) {  
        for (int i = 0; i < names.length; i++) {  
            String fieldName = names[i];  
            ce.declare_field(Constants.ACC_PRIVATE, fieldName, types[i], null);  
            EmitUtils.add_property(ce, names[i], types[i], fieldName);  
        }  
    }  
}
