package collectionsPrac;

import java.util.Arrays;

public class SortCompanies {

	public static void main(String[] args) {
		
		String[] companies =
			{"HCL", "TCS", "INFOSYS"};
		
		Arrays.sort(companies);
		for (int i = companies.length - 1; i >=0 ; i--) {
			System.out.println(companies[i]);
		}
	}
}
