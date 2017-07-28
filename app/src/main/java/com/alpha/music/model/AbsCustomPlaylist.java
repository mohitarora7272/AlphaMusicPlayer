package com.alpha.music.model;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * @author Mohit Arora
 */

public abstract class AbsCustomPlaylist extends Playlist {
    public AbsCustomPlaylist(int id, String name) {
        super(id, name);
    }

    public AbsCustomPlaylist() {
    }

    public AbsCustomPlaylist(Parcel in) {
        super(in);
    }

    @NonNull
    public abstract ArrayList<Song> getSongs(Context context);
}
