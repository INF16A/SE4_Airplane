package base;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.util.ArrayList;

public class PrimaryFlightDisplayGUI extends Application {
    private PrimaryFlightDisplayEntry weatherRadarIsOnEntry;
    private PrimaryFlightDisplayEntry cameraIsOnEntry;
    private PrimaryFlightDisplayEntry radarIsOnEntry;
    private PrimaryFlightDisplayEntry satComConnectedEntry;
    private PrimaryFlightDisplayEntry gpsOnEntry;
    private PrimaryFlightDisplayEntry isVhfOnEntry;
    private PrimaryFlightDisplayEntry cameraFactorEntry;
    private PrimaryFlightDisplayEntry radarScanEntry;

    private ArrayList<PrimaryFlightDisplayEntry> dataList;
    private ObservableList data;
    private TableView tableView;

    public static void main(String... args) {
        LogEngine.instance.init();

        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        Application.launch(args);

        FlightRecorder.instance.shutdown();

        LogEngine.instance.close();
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("A380 - Primary Flight Display");

        Airplane airplane = new Airplane();
        airplane.build();

        Cockpit cockpit = new Cockpit(airplane);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color: #336699;");

        Button startupButton = new Button("Startup");
        startupButton.setPrefSize(75, 20);

        startupButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.startup();
                update();
            }
        });

        Button taxiButton = new Button("Taxi");
        taxiButton.setPrefSize(75, 20);

        taxiButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.taxi();
                update();
            }
        });

        Button takeoffButton = new Button("TakeOff");
        takeoffButton.setPrefSize(75, 20);

        takeoffButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.takeoff();
                update();
            }
        });

        Button climbingButton = new Button("Climbing");
        climbingButton.setPrefSize(75, 20);

        climbingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.climbing();
                update();
            }
        });

        Button rightTurnButton = new Button("R-Turn");
        rightTurnButton.setPrefSize(75, 20);

        rightTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.rightTurn();
                update();
            }
        });

        Button leftTurnButton = new Button("L-Turn");
        leftTurnButton.setPrefSize(75, 20);

        leftTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.leftTurn();
                update();
            }
        });

        Button descentButton = new Button("Descent");
        descentButton.setPrefSize(75, 20);

        descentButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.descent();
                update();
            }
        });

        Button landingButton = new Button("Landing");
        landingButton.setPrefSize(75, 20);

        landingButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.landing();
                update();
            }
        });

        Button shutdownButton = new Button("Shutdown");
        shutdownButton.setPrefSize(75, 20);

        shutdownButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cockpit.shutdown();
                update();
            }
        });

        hBox.getChildren().addAll(startupButton, taxiButton, takeoffButton, climbingButton, rightTurnButton, leftTurnButton,
                descentButton, landingButton, shutdownButton);

        tableView = new TableView();
        data = getInitialTableData();
        tableView.setItems(data);

        TableColumn attributeColumn = new TableColumn("attribute");
        attributeColumn.setCellValueFactory(new PropertyValueFactory("attribute"));

        TableColumn valueColumn = new TableColumn("value");
        valueColumn.setCellValueFactory(new PropertyValueFactory("value"));

        tableView.getColumns().setAll(attributeColumn, valueColumn);
        tableView.setPrefWidth(450);
        tableView.setPrefHeight(450);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(hBox, tableView);

        Scene scene = new Scene(vbox, 850, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initData() {
        dataList = new ArrayList<>();

        // please add value(s)
        dataList.add(weatherRadarIsOnEntry);

        // sensor04
        cameraIsOnEntry = new PrimaryFlightDisplayEntry("camera (isOn)", Boolean.toString(PrimaryFlightDisplay.instance.isCameraOn));
        dataList.add(cameraIsOnEntry);
        cameraFactorEntry = new PrimaryFlightDisplayEntry("camera (ZoomFactor)", Double.toString(PrimaryFlightDisplay.instance.cameraFactor));
        dataList.add(cameraFactorEntry);
        radarIsOnEntry = new PrimaryFlightDisplayEntry("Radar (isOn", Boolean.toString(PrimaryFlightDisplay.instance.isRadarOn));
        dataList.add(radarIsOnEntry);
        radarScanEntry = new PrimaryFlightDisplayEntry("Radar (scan)", Boolean.toString(PrimaryFlightDisplay.instance.isAirspaceFree));
        dataList.add(radarScanEntry);
        radarIsOnEntry = new PrimaryFlightDisplayEntry("Radar (isOn)", Boolean.toString(PrimaryFlightDisplay.instance.isRadarOn));
        dataList.add(radarIsOnEntry);
        satComConnectedEntry = new PrimaryFlightDisplayEntry("SatCom (isConnected)", Boolean.toString(PrimaryFlightDisplay.instance.isSatComConnected));
        dataList.add(satComConnectedEntry);
        gpsOnEntry = new PrimaryFlightDisplayEntry("GPS (isOn)", Boolean.toString(PrimaryFlightDisplay.instance.isGPSOn));
        dataList.add(gpsOnEntry);
        isVhfOnEntry = new PrimaryFlightDisplayEntry("VHF (isOn)", Boolean.toString(PrimaryFlightDisplay.instance.isVHFOn));
        dataList.add(isVhfOnEntry);
    }

    private ObservableList getInitialTableData() {
        initData();
        data = FXCollections.observableList(dataList);
        return data;
    }

    public void update() {
        // please add value(s)
        cameraIsOnEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isCameraOn));
        cameraFactorEntry.setValue(Double.toString(PrimaryFlightDisplay.instance.cameraFactor));
        radarIsOnEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isRadarOn));
        radarScanEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isAirspaceFree));
        radarIsOnEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isRadarOn));
        satComConnectedEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isSatComConnected));
        gpsOnEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isGPSOn));
        isVhfOnEntry.setValue(Boolean.toString(PrimaryFlightDisplay.instance.isVHFOn));
        tableView.refresh();
    }
}