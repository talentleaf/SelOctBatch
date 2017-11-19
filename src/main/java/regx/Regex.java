package regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Regex {
	
	public static void main (String args[]){
		
		String pattern = "[a-zA-Z.]+@[a-zA-Z]+.[a-z]{3,5}";
		
		Pattern p = Pattern.compile(pattern);
			
		Matcher match = p.matcher("babu.123@testleaf.com");
		System.out.println(match.matches());
		
		
		
		
		
		
	}
	}


