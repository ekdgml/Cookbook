package printer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("htmlPrinter")
public class HTMLPrinter implements Printer{
	//
	@Override
	public void print(String msg) {
		//
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>");
		sb.append(msg);
		sb.append("</h1>");
		
		System.out.println(sb.toString());
	}

}
