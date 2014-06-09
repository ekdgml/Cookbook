package printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Hello {
	//
	private String name;
	
	@Autowired
	@Qualifier("consolePrinter")
	private Printer printer;
	
	public Hello() {
		//
	}
	
	public void sayHello() {
		//
		printer.print("안녕 " + name + "~!!!!!!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
