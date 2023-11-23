package FirstChallengesJava;

public class _03Challenge {

	public static void main(String[] args) {

		// I DECLARE AND INITIALIZE VARIABLES

		int mult2 = 1, mult3 = 1;

		
		System.out.println("THE MULTIPLES OF 2 UP TO 100 ARE:");
		
		
		// I INITIALIZE FOR AT 2 AND GO UP TO 100
		
		for (int a = 2; a < 100; a++) {

			if (a % 2 == 0) {

				System.out.print(a + " ");
				
				mult2++;
			}
			
		}
		
		System.out.println("\nTHE NUMBER OF MULTIPLES FROM 2 TO 100 ARE: " + mult2);
		
		
		System.out.println("\n------------------------------------------------------------\n");
		
		
		System.out.println("THE MULTIPLES OF 3 UP TO 100 ARE:");
		
		
		// I INITIALIZE FOR AT 3 AND GO UP TO 100
		
		for (int b = 3; b < 100; b++) {
		

			if (b % 3 == 0) {

				System.out.print(b + " ");
				
				mult3++;
			}		
		}

		System.out.println("\nTHE NUMBER OF MULTIPLES OF 3 UP TO 100 ARE: " + mult3);
		
	}

}
