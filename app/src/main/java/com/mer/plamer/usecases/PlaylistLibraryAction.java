package com.mer.plamer.usecases;


import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;

import java.util.ArrayList;

public class PlaylistLibraryAction {

    public static PlaylistLibrary playlistLibrary = new PlaylistLibrary();

    /**
     * Delete the playlist in the playlist library.
     *
     * @param playlist_id the id of the playlist.
     * @return Whether the playlist is successfully removed or not.
     */
    public static boolean delete(String playlist_id) {
        return playlistLibrary.remove(playlist_id);
    }

    /**
     * Search the required playlists.
     *
     * @param keyword the provided keyword by the user
     * @return the required playlists.
     */
    public static ArrayList<Playlist> search(String keyword) {
        ArrayList<Playlist> searchPlaylist = new ArrayList<>();
        for (Playlist p : playlistLibrary.getPlaylists()) {
            if (p.getName().contains(keyword)) {
                searchPlaylist.add(p);
            }
            for (Track t : p.getTracks()) {
                if ((t.getArtist().contains(keyword) || t.getTitle().contains(keyword)
                        || t.getGenre().contains(keyword)) && !(searchPlaylist.contains(p))) {
                    searchPlaylist.add(p);
                } else
                    break;
            }
        }
        return searchPlaylist;
    }

    /**
     * add a playlist to the playlist library.
     *
     * @param name the playlist we want to add.
     */
    public static void add(String name) {
        playlistLibrary.add(playlistLibrary.create(name));


    }

    /**
     * Get a list of integers containing the size of every playlist.
     * @return the list of all playlist size.
     */
    public static ArrayList<Integer> getListofPlaylistSize() {
        return playlistLibrary.getListofPlaylistSize();
    }


    /**
     * Get a list of String containing the name of every playlist.
     * @return the list of all playlist name.
     */
    public static ArrayList<String> getListofPlaylistName() {
        return playlistLibrary.getListofPlaylistName();
    }

    /**
     * Assign a previously stored library as the new library.
     * @param library the stored library.
     */
    public static void assignLibrary(PlaylistLibrary library) {
        playlistLibrary = library;
    }
}