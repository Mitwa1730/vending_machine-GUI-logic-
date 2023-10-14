package Assignment5_000905034;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 * This class represents a vending machine GUI.
 * It allows users to interact with the vending machine by vending items, inserting coins, receiving available credit, and turning the machine on or off.
 * The class handles event handlers for different GUI components.
 * @author Mitwa Patel, 000905034
 */
public class Machine extends Application {

    // TODO: Instance Variables for View Components and Model
    private VendingMachineModel model;
    private VendingMachineLogic machine;
    private GraphicsContext gc;
    private Label titleLabel;
    private Label labelItemName;
    private Label resourceLabel;
    private Label reportLabel;
    private TextField insertMoney;
    private boolean isOn = false;

    // TODO: Private Event Handlers and Helper Methods
    /**
     * It refreshes the data
     */
    private void refreshData(){

        resourceLabel.setText(machine.toString());
        labelItemName.setText(machine.getMessage());
        drawVendingMachine();
    }

    /**
     * Event handler for the 'ON' button.
     * It turns ON the vending machine.
     * @param e
     */
    private void OnHandler(ActionEvent e){
        isOn=true;
         machine = new VendingMachineLogic("Drinks", 12, 1.99);
         refreshData();
    }

    /**
     * Event handler for the 'OFF' button.
     * It turns OFF the vending machine.
     * @param e
     */
    private void offHandler(ActionEvent e){
        resourceLabel.setText("Turned OFF");
    }

    /**
     * Event handler for the 'Insert Amount' button.
     * @param e
     */
    private void insertMoneyHandler(ActionEvent e){
        if(isOn){
        double money = Double.parseDouble(insertMoney.getText());
        machine.insertCoin(money);
        insertMoney.setText("0.00");
        insertMoney.requestFocus();
        refreshData();
        }
    }

    /**
     * Event handler for the 'Vend Item' button.
     * @param e
     */
    private void vendItemHandler(ActionEvent e){
        if(isOn){
            machine.vendItem();
            refreshData();
        }
    }

    /**
     * Event handler for the 'Get change' button.
     * @param e
     */
    private void getChangeHandler(ActionEvent e){
        if(isOn){
            machine.getAvailableCredit();
            refreshData();
        }
    }

    /**
     * draws the vending machine.
     */
    private void drawVendingMachine(){
        int quantity = 12;
        if(machine != null){
            quantity = machine.getQuantity();
        }
        model.draw(gc,quantity);
    }

    /**
     *
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root);

        stage.setTitle("Vending Machine");
        stage.setScene(scene);

        // TODO: Add your GUI-building code here

        // 1. Create the model
        model = new VendingMachineModel();

        // 2. Create the GUI components
        Canvas canvas = new Canvas(600, 700);
        gc = canvas.getGraphicsContext2D();

        Button on = new Button("ON");
        Button off = new Button("OFF");
        Button getChange = new Button("Get Change");

        titleLabel = new Label("Vending Machine");

        labelItemName = new Label("");

        insertMoney = new TextField("Insert Coins Only");
        resourceLabel = new Label("");
        Button insert = new Button("Insert Amount");

        reportLabel = new Label("");
        Button vendItem = new Button("Vend Item") ;

        // 3. Add components to the root
        root.getChildren().addAll(canvas, insertMoney, titleLabel, labelItemName, resourceLabel, reportLabel, insert, on, off, getChange,vendItem);

        // 4. Configure the components (colors, fonts, size, location)
        insertMoney.relocate(230,580);

        insert.relocate(200,615);
        insert.setFont(new Font("System", 13.5));

        titleLabel.relocate(190,32);
        titleLabel.setFont(new Font("System", 30));
        titleLabel.setStyle("-fx-text-fill: darkblue;");

        labelItemName.relocate(91, 86);
        labelItemName.setFont(new Font("System", 22));
        labelItemName.setStyle("-fx-text-fill: blue;");

        resourceLabel.relocate(365, 220);
        resourceLabel.prefWidth(100);
        resourceLabel.setFont(new Font("System", 16));

        vendItem.relocate(390,470);
        vendItem.prefWidth(300);
        vendItem.setFont(new Font("System",15));
        vendItem.setStyle("-fx-text-fill: darkblue;");

        on.setFont(new Font("System",15));
        on.relocate(380, 180);
        on.setStyle("-fx-text-fill: green;");

        off.setFont(new Font("System",15));
        off.relocate(450, 180);
        off.setStyle("-fx-text-fill: darkred;");

        getChange.relocate(315,615);
        getChange.prefWidth(300);
        getChange.setFont(new Font("System", 13.5));

        // 5. Add Event Handlers and do final setup
        drawVendingMachine();
        on.setOnAction(this::OnHandler);
        off.setOnAction(this::offHandler);
        insert.setOnAction(this::insertMoneyHandler);
        vendItem.setOnAction(this::vendItemHandler);
        getChange.setOnAction(this::getChangeHandler);

        // 6. Show the stage
        stage.show();
    }

    /**
     * the main method
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
