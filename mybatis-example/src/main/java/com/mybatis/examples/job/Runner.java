package com.mybatis.examples.job;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.examples.model.Movie;
import com.mybatis.examples.service.MovieService;

@Service
@Transactional
public class Runner {
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private MovieService movieService;
	
	public void exec() {
		BlockingQueue<Movie> queues = new LinkedBlockingQueue<Movie>(1024);
		taskExecutor.execute(new Producer(queues));
		int nconsumer = 16;
		for (int i = 0; i < nconsumer; i++) {
			taskExecutor.execute(new Consumer(queues, movieService));
		}
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Runner runner = ctx.getBean(Runner.class);
		runner.exec();
//		ctx.close();	// close too quickly, occur error(close dataSource)
		ctx.registerShutdownHook();
	}
}
