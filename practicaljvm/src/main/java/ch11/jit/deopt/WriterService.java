package ch11.jit.deopt;

public class WriterService {
	public void service(){
		DBWriter writer=new DBWriter();
		writer.write();
	}
}
