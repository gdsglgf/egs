package com.mybatis.examples.job;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mybatis.examples.model.Movie;
import com.mybatis.examples.service.MovieService;

public class Consumer implements Runnable {
	private static final Logger log = LogManager.getLogger(Consumer.class);
	private BlockingQueue<Movie> queues;
	private MovieService movieService;

	public Consumer(BlockingQueue<Movie> queues, MovieService movieService) {
		this.queues = queues;
		this.movieService = movieService;
	}

	@Override
	public void run() {
		Movie movie = null;
		while (true) {
			try {
				movie = queues.poll(5, TimeUnit.SECONDS);
				if (movie == null) {
					log.debug("Get data time out(5 seconds). Stop thread.");
					break;
				} else {
					movieService.createMovie(movie);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
