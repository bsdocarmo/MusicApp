package com.projectudacity.musicapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectudacity.musicapp.R;
import com.projectudacity.musicapp.adapter.PlaylistAdapter;
import com.projectudacity.musicapp.domain.PlaylistService;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_home);

        bindViews();
    }

    private void bindViews() {

        ImageView payment = findViewById(R.id.abh_iv_payment);
        payment.setOnClickListener(this);


        RecyclerView playlists = findViewById(R.id.ah_rv_playlists);
        playlists.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        PlaylistAdapter.PlaylistOnClickListener playlistOnClickListener = new PlaylistAdapter.PlaylistOnClickListener() {
            @Override
            public void onClickPlaylist(View view, int index) {
                startActivity(PlaylistActivity.class);
            }
        };

        playlists.setAdapter(
                new PlaylistAdapter(PlaylistService.getPlaylists(), this, playlistOnClickListener));

        TextView trends = findViewById(R.id.ah_tv_trends);
        trends.setOnClickListener(this);

        TextView news = findViewById(R.id.ah_tv_news);
        news.setOnClickListener(this);

        TextView songs = findViewById(R.id.ah_tv_songs);
        songs.setOnClickListener(this);

        TextView albums = findViewById(R.id.ah_tv_albums);
        albums.setOnClickListener(this);

        TextView artists = findViewById(R.id.ah_tv_artists);
        artists.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.abh_iv_payment:
                startActivity(PaymentActivity.class);
                break;
            case R.id.ah_tv_trends:
                startActivity(TrendsActivity.class);
                break;
            case R.id.ah_tv_news:
                startActivity(NewsActivity.class);
                break;
            case R.id.ah_tv_songs:
                startActivity(SongsActivity.class);
                break;
            case R.id.ah_tv_albums:
                startActivity(AlbumsActivity.class);
                break;
            case R.id.ah_tv_artists:
                startActivity(ArtistsActivity.class);
                break;
        }
    }

    private void startActivity(Class destiny) {
        Intent intent = new Intent(this, destiny);
        startActivity(intent);
    }
}
