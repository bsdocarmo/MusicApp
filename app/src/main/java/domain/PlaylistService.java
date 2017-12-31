package domain;

import android.content.Context;

import com.projectudacity.musicapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodocarmo on 30/12/17.
 */

public class PlaylistService {


    public static List<Playlist> getPlaylists(Context context) {
        List<Playlist> playlists = new ArrayList<>();

        playlists.add(addItem("Brazilian Funk", R.drawable.ic_brazilian_funk));

        playlists.add(addItem("Rap", R.drawable.ic_rap));

        playlists.add(addItem("Rock n' Roll", R.drawable.ic_rock));

        playlists.add(addItem("SoundTrack", R.drawable.ic_sound_track));

        return playlists;
    }

    private static Playlist addItem(String name, int image) {
        Playlist playlist = new Playlist();
        playlist.name = name;
        playlist.image = image;
        return playlist;
    }
}
