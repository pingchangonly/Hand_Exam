package cn.hand.exam;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// 输入工资
		System.out.println("请输入你的工资：");
		Scanner sc = new Scanner(System.in);
		double salary = sc.nextDouble();
		

		double tax = salary - 3500;
		double taxRate = getTaxRate(tax);
		System.out.println("你需要交纳的税费为："+taxRate);

	}

	// 工资应交税
	public static double getTaxRate(double tax) {
		if (tax <= 0)
			tax = 0;
		else if (tax > 0 && tax <= 1500)
			tax = tax * 0.03;
		else if (tax <= 4500)
			tax = 1500 * 0.03 + (tax - 1500) * 0.1;
		else if (tax <= 9000)
			tax = 1500 * 0.03 + 3000 * 0.1 + (tax-4500) * 0.2;
		else if (tax <= 35000)
			tax = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2
					+ (tax - 9000) * 0.25;
		else if (tax <= 55000)
			tax = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2
					+ 26000 * 0.25 + (tax - 35000) * 0.3;
		else if (tax <= 8000)
			tax = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2
					+ 26000 * 0.25 + 20000 * 0.3 + (tax - 55000)
					* 0.35;
		else
			tax = 1500 * 0.03 + 3000 * 0.1 + 4500 * 0.2
					+ 26000 * 0.25 + 20000 * 0.3 + 25000
					* 0.35 + (tax - 80000) * 0.45;

		return tax;
	}
}
