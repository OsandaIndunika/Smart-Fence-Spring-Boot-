package com.smartfence.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin(origins = "http://localhost:5173")
public class SOSController {

        @Value("${twilio.account.sid}")
        private String accountSid;

        @Value("${twilio.auth.token}")
        private String authToken;       

    private static final String TWILIO_PHONE =
            "+16364283827";

    private static final String RECEIVER_PHONE =
            "+94704056332";

    @PostMapping
    public String sendSOS(
            @RequestBody Map<String, String> body
    ) {

        String latitude = body.get("latitude");

        String longitude = body.get("longitude");

        String time = body.get("time");

        String message =
                "🚨 SOS ALERT!\n\n" +
                "Elephant detected near village.\n\n" +

                "📍 Location:\n" +

                "https://maps.google.com/?q="
                + latitude + "," + longitude +

                "\n\n🕒 Time: " + time;

        // ✅ SEND SMS
        sendSMS(message);

        return "SOS SENT";
    }

    // ✅ TWILIO SMS FUNCTION
    private void sendSMS(String text) {

        Twilio.init(
                accountSid,
                authToken
            );

        Message.creator(

                new PhoneNumber(RECEIVER_PHONE),

                new PhoneNumber(TWILIO_PHONE),

                text

        ).create();

        System.out.println("✅ SMS SENT");
    }
}