package com.buygo.suning.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Cookie_Persistence", "rd1069o00000000000000000000ffffac101410o8080");
		map.put("ORIGINAL_IP_ADDRESS", "183.240.25.156");
		map.put("incap_ses_571_699488", "lzWQITVlyXpdEHS2wZnsB16PYVkAAAAA6Lva7b2gXSsa3cp30QwnNg==");
		map.put("visid_incap_699488", "jtROJAuGSlScvIPRmoqfvF6PYVkAAAAAQUIPAAAAAADGGYSlI1Ay4JI1QzXNQP0O");

		String url = "http://pxiagme1.lot1068.net/member/48co06itf6vk4urfuo6714edal/Home/Index.action";

		Document document = Jsoup.connect(url).cookies(map).get();
		System.out.println(document.toString());

		// url =
		// "http://pxiagme1.lot1068.net/member/48co06itf6vk4urfuo6714edal/GameResult/Index.action";
		// Map<String, String> data = new HashMap<String, String>();
		// data.put("eventDisplayDate", "2017-07-09");
		// data.put("eventNo", "");
		// data.put("gameTypeId", "201");
		// document = Jsoup.connect(url).data(data).cookies(map).get();
		// System.out.println(document.toString());
		//
		// Elements script = document.select("script");
		// for (Element element : script) {
		// boolean flag = element.toString().contains("pageData");
		// if (flag) {
		// String str = element.toString();
		// String string = StringUtils.substringBetween(str, "pageData");
		// System.out.println(string);
		// }
		// }


	}

}
