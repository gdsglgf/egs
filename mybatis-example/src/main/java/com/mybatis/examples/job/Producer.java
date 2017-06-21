package com.mybatis.examples.job;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mybatis.examples.model.Movie;

public class Producer implements Runnable {
	private static final Logger log = LogManager.getLogger(Producer.class);
	public static String csv = "doc/movies.csv";
	private BlockingQueue<Movie> queues;
	
	public Producer(BlockingQueue<Movie> queues) {
		this.queues = queues;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(csv));
			String line = reader.readLine();	// skip head line
			String[] item = null;
			Movie movie = null;
			while ((line = reader.readLine()) != null) {
				item = line.split(",");
				if (item.length == 3) {
					movie = new Movie(Integer.parseInt(item[0]), item[1], item[2]);
					boolean isSuccessful = queues.offer(movie, 5, TimeUnit.SECONDS);
					if (!isSuccessful) {
						log.debug(String.format("Put data time out(5 seconds):%s", movie));
					} else {
						log.debug(String.format("Put data succeed:%s", movie));
					}
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
