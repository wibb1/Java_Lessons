package com.sample;

import com.sample.model.Album;
import com.sample.model.Artist;
import com.sample.model.DataSource;
import com.sample.model.QueryStringBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView artistTable;

    @FXML
    private ProgressBar progressBar;

    @FXML
    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        progressBar.progressProperty().bind(task.progressProperty());

        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));

        new Thread(task).start();
    }

    @FXML
    public void listAlbumsForArtist() {
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null) {
            System.out.println("No Artist Selected");
            return;
        }
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(
                        DataSource.getInstance().queryAlbumsByArtistId(artist.getId()));
            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    class GetAllArtistsTask extends Task {
        @Override
        public ObservableList<Artist> call() {
            return FXCollections.observableArrayList(
                    DataSource.getInstance().queryAllArtists(QueryStringBuilder.SORT_ORDER.ASC));
        }

    }
}
