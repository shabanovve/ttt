package com.ttt.cliapp;

import lombok.RequiredArgsConstructor;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOError;
import java.io.IOException;

@SpringBootApplication
@RequiredArgsConstructor
public class CliappApplication {

	private final LogMessageHandler logMessageHandler;

	public static void main(String[] args) {
		SpringApplication.run(CliappApplication.class, args);
	}

	@PostConstruct
	private void init() {
		// set log message handler to handle only fatal errors (0) and plain log messages (-1)
		Client.setLogMessageHandler(0, logMessageHandler);

		// disable TDLib log and redirect fatal errors and plain log messages to a file
		Client.execute(new TdApi.SetLogVerbosityLevel(0));
		if (Client.execute(new TdApi.SetLogStream(new TdApi.LogStreamFile("tdlib.log", 1 << 27, false))) instanceof TdApi.Error) {
			throw new IOError(new IOException("Write access to the current directory is required"));
		}

	}


}
