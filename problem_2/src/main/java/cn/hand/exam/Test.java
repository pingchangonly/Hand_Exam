package cn.hand.Exam;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请按格式yyyy-MM-dd输入日期：");
		String strDate = sc.next();

		/*
		 * //日期格式验证 String regEx = \d{4}(\-|\/|.)\d{1,2}\1\d{1,2}; // 编译正则表达式
		 * Pattern pattern = Pattern.compile(regEx); // 忽略大小写的写法 Matcher matcher
		 * = pattern.matcher(strDate); // 字符串是否与正则表达式相匹配 boolean rs =
		 * matcher.matches();
		 */

		String nextDay = null;
		// 得到该日期的年月日
		int year = 0;
		int month = 0;
		int day = 0;
		try {
			String[] strs = strDate.split("-");
			year = Integer.parseInt(strs[0]);
			month = Integer.parseInt(strs[1]);
			day = Integer.parseInt(strs[2]);
		} catch (Exception e) {
			System.out.println("日期格式输入有误，请参照2018-08-04格式输入");
			return;
		}
		boolean flag = checkDate(strDate);
		if (flag) {

			// 处理闰年
			if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
				if ((month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)
						&& day == 31) {
					month = month + 1;
					nextDay = year + "-" + month + "-01";
				} else if ((month == 4 || month == 6 || month == 9 || month == 11)
						&& day == 30) {
					month = month + 1;
					nextDay = year + "-" + month + "-01";
				} else if (month == 2 && day == 29) {
					nextDay = year + "-03-01";
				} else {
					day = day + 1;
					nextDay = year + "-" + month + "-" + day;
				}

			} else {
				if ((month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)
						&& day == 31) {
					month = month + 1;
					nextDay = year + "-" + month + "-01";
				} else if ((month == 4 || month == 6 || month == 9 || month == 11)
						&& day == 30) {
					month = month + 1;
					nextDay = year + "-" + month + "-01";
				} else if (month == 2 && day == 28) {
					nextDay = year + "-03-01";
				} else {
					day = day + 1;
					nextDay = year + "-" + month + "-" + day;
				}
			}
			System.out.println("下一天为：" + nextDay);

		} else {
			System.out.println("您输入的日期不存在");
		}
	}

	// 判断输入日期是否合法
	static boolean checkDate(String str) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sd.setLenient(false);// 此处指定解析是否严格，false时为严格
			sd.parse(str);// 从给定字符串的开始解析文本，以生成一个日期
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
