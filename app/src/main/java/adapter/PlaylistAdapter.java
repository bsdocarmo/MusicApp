package adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectudacity.musicapp.R;

import java.util.List;

import domain.Playlist;

/**
 * Created by brunodocarmo on 30/12/17.
 */

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

    private final List<Playlist> playlists;
    private final Context context;
    private final PlaylistOnClickListener playlistOnClickListener;

    public PlaylistAdapter(List<Playlist> playlists, Context context, PlaylistOnClickListener playlistOnClickListener) {
        this.playlists = playlists;
        this.context = context;
        this.playlistOnClickListener = playlistOnClickListener;
    }


    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_playlist, parent, false);

        return new PlaylistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PlaylistViewHolder holder, final int position) {
        // Update view
        final Playlist playlist = playlists.get(position);
        holder.name.setText(playlist.name);
        holder.name.setCompoundDrawablesWithIntrinsicBounds(0, playlist.image, 0, 0);

        // Click
        if (playlistOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playlistOnClickListener.onClickPlaylist(holder.itemView, holder.getAdapterPosition());
                }
            }
            );
        }
    }

    public interface PlaylistOnClickListener {
        void onClickPlaylist(View view, int index);
    }

    @Override
    public int getItemCount() {
        return this.playlists != null ? this.playlists.size() : 0;
    }


    // ViewHolder with the views
    protected static class PlaylistViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public TextView name;

        PlaylistViewHolder(View itemView) {
            super(itemView);

            // Create the views to save the viewHolder
            cardView = itemView.findViewById(R.id.ap_cv_playlist_item);
            name = itemView.findViewById(R.id.ap_tv_playlist_item);
        }
    }
}
