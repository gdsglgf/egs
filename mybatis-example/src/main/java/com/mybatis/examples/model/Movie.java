package com.mybatis.examples.model;

public class Movie {
	private int movieId;
	private String title;
	private String genres;
	public Movie() {
	}
	public Movie(int movieId, String title, String genres) {
		this.movieId = movieId;
		this.title = title;
		this.genres = genres;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	@Override
	public String toString() {
		return String.format("Movie:[id=%d, title=%s, genres=%s]", movieId, title, genres);
	}
}
