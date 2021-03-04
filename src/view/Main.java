package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		RedesController redeController = new RedesController();
		String os = redeController.os();
		Scanner resp = new Scanner (System.in);
		int res = resp.nextInt();		
		
		do {		
			if (res == 1) {
			redeController.ip(os);
			}
			else if (res == 2) {
			redeController.ping(os);
			}
			res = resp.nextInt();
		}
		while (res != 0);
	}
}
