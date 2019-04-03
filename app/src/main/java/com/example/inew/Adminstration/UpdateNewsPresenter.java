package com.example.inew.Adminstration;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.inew.Adminstration.NewsModel.Article;
import com.example.inew.Adminstration.NewsModel.Root;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateNewsPresenter {
    private List<Article>listOfArticle;
    private DatabaseReference databaseReference;

    public UpdateNewsPresenter() {

        databaseReference=FirebaseDatabase.getInstance().getReference();
    }

    void  getDataFromApi(final String category ) {

        Call<Root> newsRoot = APIManager.getService().getListOfArticle(category);
        newsRoot.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(@NonNull Call<Root> call,@NonNull Response<Root> response) {

                if (response.body()!=null){
                    if(listOfArticle!=null)
                        listOfArticle.clear();
                     listOfArticle=response.body().getArticles();
                     int size=listOfArticle.size();
                     for (int i=0;i<size;i++){
                         pushToFireBase(category,listOfArticle.get(i).getAuthor(),listOfArticle.get(i).getUrlToImage()
                                 , listOfArticle.get(i).getTitle() ,listOfArticle.get(i).getContent() ,listOfArticle.get(i).getDescription());
                     }
                }
                Log.e("UpdateNewsPresenter Res",""+listOfArticle.get(0).getDescription());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.e("UpdateNewsPresenter F",t.getMessage()+" ");

            }
        });
    }

    void pushToFireBase(String category, String author, String urlToImage, String title, String content,String description){
        DatabaseReference databaseReference=this.databaseReference.child(category).push();
        databaseReference.child("author").setValue(author);
        databaseReference.child("urlToImage").setValue(urlToImage);
        databaseReference.child("title").setValue(title);
        databaseReference.child("content").setValue(content);
        databaseReference.child("description").setValue(description);
    }
}
