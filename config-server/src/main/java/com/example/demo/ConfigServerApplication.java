package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);

		String originalUrl = "https://www.facebook.com/chheanvannet";
		try {
			String redirectedUrl = getRedirectUrl(originalUrl);
			System.out.println("Redirected to: " + redirectedUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getRedirectUrl(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setInstanceFollowRedirects(false); // Do not follow automatically
		connection.setRequestMethod("GET");
		connection.connect();

		int status = connection.getResponseCode();
		if (status == HttpURLConnection.HTTP_MOVED_PERM ||
				status == HttpURLConnection.HTTP_MOVED_TEMP ||
				status == HttpURLConnection.HTTP_SEE_OTHER ||
				status == 307 || status == 308) {

			return connection.getHeaderField("Location");
		} else {
			return "No redirect found. Status: " + status;
		}
	}

}
