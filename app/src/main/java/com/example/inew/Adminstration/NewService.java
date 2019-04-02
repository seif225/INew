package com.example.inew.Adminstration;

import com.example.inew.Adminstration.NewsModel.Article;
import com.example.inew.Adminstration.NewsModel.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewService {

    @GET("/v2/top-headlines?sources=bbc-news&apiKey=803c950feec64958b66674fcaeeff457")
    Call<Root>getListOfArticle();
}
