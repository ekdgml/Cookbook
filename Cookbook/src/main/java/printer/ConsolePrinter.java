package printer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("consolePrinter")
public class ConsolePrinter implements Printer{
	//
	@Override
	public void print(String msg) {
		//
		System.out.println(msg);
	}

}
