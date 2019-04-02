package com.example.inew.Adminstration;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.inew.Adminstration.NewsModel.Article;
import com.example.inew.Adminstration.NewsModel.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateNewsPresenter {
    private List<Article>listOfArticle;


    void  getDataFromApi() {
        Call<Root> newsRoot = APIManager.getService().getListOfArticle();
        newsRoot.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(@NonNull Call<Root> call,@NonNull Response<Root> response) {
                if (response.body()!=null)
                     listOfArticle=response.body().getArticles();
                Log.e("UpdateNewsPresenter Res",""+listOfArticle.get(0).getDescription());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.e("UpdateNewsPresenter F",t.getMessage()+" ");

            }
        });
    }
}
