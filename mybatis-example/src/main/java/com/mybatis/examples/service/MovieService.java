package com.mybatis.examples.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.examples.mapper.MovieMapper;
import com.mybatis.examples.model.Movie;

@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieMapper movieMapper;
	
	public Movie createMovie(Movie movie) {
		Movie history = getMovieById(movie.getMovieId());
		if (history == null) {
			movieMapper.createMovie(movie);
			history = movie;
		}
		return history;
	}
	public Movie getMovieById(@Param("movieId") int movieId) {
		return movieMapper.getMovieById(movieId);
	}
}
