package BankATM;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class transactionActivity {
	void transaction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of currency denominations");
		int numberOfDenomination = 0;
		boolean invalidInput = false;
		try {
			numberOfDenomination = sc.nextInt();
		} catch (Exception e1) {
			sc.close();
			System.out.println("Invalid input Start again");
			transaction();
		}
		if (numberOfDenomination != 0) {
			System.out.println("Enter the currency Denominations value");
			Integer[] denominations = new Integer[numberOfDenomination];
			for (int i = 0; i < numberOfDenomination; i++) {
				try {
					denominations[i] = sc.nextInt();
					if (denominations[i] == 0)
						invalidInput = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					invalidInput = true;
					break;
				}
			}
			if (invalidInput == false) {
				Arrays.sort(denominations, Collections.reverseOrder());
				System.out.println("Enter the amount :");
				int amount = 0;
				try {
					amount = sc.nextInt();
				} catch (Exception e) {
					sc.close();
					System.out.println("Invalid input Start again");
					transaction();
				}
				sc.close();
				int i = 0;
				int quotient = 0;
				int[] denominationCount = new int[numberOfDenomination];
				if (amount != 0) {
					for (i = 0; i < numberOfDenomination; i++) {
						if (amount >= 0) {
							quotient = amount / denominations[i];
							if (quotient >= 1.0f) {
								denominationCount[i] = quotient;
								amount = amount % denominations[i];
							}
						}
					}
					if (amount > 0) {
						System.out.println("THE AMOUNT ENTERED CANNOT BE LEGALLY TENDERED");

					} else {
						System.out.println("Your payment approach in order to give min no of notes will be");

						for (i = 0; i < numberOfDenomination; i++) {
							if (denominationCount[i] > 0) {
								System.out.println(denominations[i] + "  : " + denominationCount[i]);
							}
						}
					}
				}

			} else {
				System.out.println("Invalid input Start again");
				transaction();
			}
		} else {
			System.out.println("Invalid input Start again ");
			transaction();
		}

	}

}
