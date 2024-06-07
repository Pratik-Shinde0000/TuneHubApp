package com.tunehub.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Controller
public class PaymentController {
	@ResponseBody
	@PostMapping("/createOrder")
	public String createOrder() {
		Order order = null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_3dPJdbQAhQSrNq", "pJN7poiOJSSyFUiQbab1nNYX");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", 50000);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1", "Tea, Earl Grey, Hot");
			orderRequest.put("notes", notes);

			order = razorpay.orders.create(orderRequest);
		} catch (Exception e) {
			System.out.println("Exception while creting order");
		}
		return order.toString();
	}

}
