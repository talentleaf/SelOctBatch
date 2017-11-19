package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnStringBufferAndBuilder {

	public static void main(String[] args) {		
		//String text = "Hello";
		/*text=text.concat("World");
		System.out.println(text);*/
		/*StringBuffer buffer = new StringBuffer("Hello");
		buffer.append(" World");
		buffer.insert(2, 'l');
		System.out.println(buffer.reverse());*/
		/*StringBuilder builder = new StringBuilder("Hello");
		builder.append("World");
		System.out.println(builder);*/
		String name = "5RamKumar";
		String pattern = "[a-zA-Z]+";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(name);
		System.out.println(m.matches());
		
		
		
		
		

	}

}
