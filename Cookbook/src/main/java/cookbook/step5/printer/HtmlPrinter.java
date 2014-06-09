package cookbook.step5.printer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("htmlPrinter")
public class HtmlPrinter implements Printer {

	@Override
	public String print(String[] msgs) {
		//
		StringBuffer sb = new StringBuffer();
		sb.append("<ul>");
		sb.append("\n");
		for (String msg : msgs) {
			//
			sb.append("<li>");
			sb.append(msg);
			sb.append("</li>");
			sb.append("\n");
		}
		sb.append("</ul>");
		System.out.println(sb.toString());
		
		return sb.toString();
	}

}
