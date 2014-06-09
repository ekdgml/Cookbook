package cookbook.step5.printer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("consolePrinter")
public class ConsolePrinter implements Printer {

	@Override
	public String print(String[] msgs) {
		//
		StringBuffer sb = new StringBuffer();
		for (String msg : msgs) {
			//
			sb.append(msg);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		return sb.toString();
	}

}
