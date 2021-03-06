package com.alpha.music.loader;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import com.alpha.music.model.Song;
import com.alpha.music.util.PreferenceUtil;

import java.util.ArrayList;
/**
 * @author Mohit Arora
 */
public class LastAddedLoader {

    @NonNull
    public static ArrayList<Song> getLastAddedSongs(@NonNull Context context) {
        return SongLoader.getSongs(makeLastAddedCursor(context));
    }

    public static Cursor makeLastAddedCursor(@NonNull final Context context) {
        long cutoff = PreferenceUtil.getInstance(context).getLastAddedCutoff();

        return SongLoader.makeSongCursor(
                context,
                MediaStore.Audio.Media.DATE_ADDED + ">?",
                new String[]{String.valueOf(cutoff)},
                MediaStore.Audio.Media.DATE_ADDED + " DESC");
    }
}
