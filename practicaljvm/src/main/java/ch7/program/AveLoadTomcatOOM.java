package ch7.program;

/*
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.netbeans.lib.profiler.heap.HeapFactory;
import org.netbeans.modules.profiler.oql.engine.api.OQLEngine;

public class AveLoadTomcatOOM {
    public static final String dumpFilePath="d:/tmp/tomcat_oom/tomcat.hprof";

    public static void main(String args[]) throws Exception{
        OQLEngine engine;
        final List<Long> creationTimes=new ArrayList<Long>(10000);
        engine=new OQLEngine(HeapFactory.createHeap(new File(dumpFilePath)));
        String query="select s.creationTime from org.apache.catalina.session.StandardSession s";
        engine.executeQuery(query, new OQLEngine.ObjectVisitor(){
            public boolean visit(Object obj){
                creationTimes.add((Long)obj);
                return false;
            }
        });

        Collections.sort(creationTimes);

        double min=creationTimes.get(0)/1000;
        double max=creationTimes.get(creationTimes.size()-1)/1000;
        System.out.println("平均压力："+creationTimes.size()*1.0/(max-min)+"次/秒");
    }
}*/
