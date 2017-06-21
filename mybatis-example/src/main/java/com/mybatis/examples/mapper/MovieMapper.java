package com.mybatis.examples.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import com.mybatis.examples.model.Movie;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface MovieMapper {
	public void createMovie(Movie movie);
	public Movie getMovieById(@Param("movieId") int movieId);
	public int countAll();
}
