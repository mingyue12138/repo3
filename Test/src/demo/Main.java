package demo;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application{
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("计算");

    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("年化利率"),0,0);
        gridPane.add(tfAnnualInterestRate,1,0);
        gridPane.add(new Label("借款年数"),0,1);
        gridPane.add(tfNumberOfYears,1,1);
        gridPane.add(new Label("借款金额"),0,2);
        gridPane.add(tfLoanAmount,1,2);
        gridPane.add(new Label("每月应还"),0,3);
        gridPane.add(tfMonthlyPayment,1,3);
        gridPane.add(new Label("总共应还"),0,4);
        gridPane.add(tfTotalPayment,1,4);
        gridPane.add(btCalculate,1,5);


        gridPane.setAlignment(Pos.CENTER);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_CENTER);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_CENTER);
        tfLoanAmount.setAlignment(Pos.BOTTOM_CENTER);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_CENTER);
        tfTotalPayment.setAlignment(Pos.BOTTOM_CENTER);
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        btCalculate.setOnAction(e -> calculateLoanPayment());

        Scene scene = new Scene(gridPane,400,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("贷款计算器");
        primaryStage.show();



    }

    private void calculateLoanPayment() {

        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmout = Double.parseDouble(tfLoanAmount.getText());

        Loan loan = new Loan(interest, year, loanAmout);


        tfMonthlyPayment.setText(String.format("¥%.2f",loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("¥%.2f",loan.getTotalPayment()));
    }

}