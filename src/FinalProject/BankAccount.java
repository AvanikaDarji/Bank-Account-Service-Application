package FinalProject;

import java.util.ArrayList;


import java.util.Collections;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.geometry.*;
import javafx.scene.layout.BorderPane;

public class BankAccount extends Application {
	
	 public static void main(String[] args){
			launch(args);
		}
		 ArrayList<Account> accounts = new ArrayList<Account>();
		 ArrayList<Integer> accountsId = new ArrayList<Integer>();
		 ArrayList<Integer> CDaccountsId = new ArrayList<Integer>();
	     ArrayList<CDAccount> CDaccounts = new ArrayList<CDAccount>();

private TextField tfAccountNumber = new TextField();
private TextField tfAnnualInterestRate = new TextField();
private TextField tfIntialBalance = new TextField();
private TextField tfIntialdeposit = new TextField();
private TextField tfCDAccountNumber = new TextField();
private TextField tfCDDepositAmount = new TextField();
private TextField tfCDDuration = new TextField();
private TextField tfCDAnnualInterestRate = new TextField();
private TextField tfCDMaturationBalance = new TextField();
private TextField tfDAccountNumber = new TextField();
private TextField tfDDepositAmount = new TextField();
private TextField tfDAccountBalance = new TextField();
private TextField tfWAccountNumber = new TextField();
private TextField tfWithdrawAmount= new TextField();
private TextField tfWAccountBalance = new TextField();
private TextField tfChkAccountNumber = new TextField();
private TextField tfMAccountBalance = new TextField();
private TextField tfClAccountNumber = new TextField();
private TextField tfClAccountBalance = new TextField();

BorderPane pane = new BorderPane();

HBox hbox = new HBox();
HBox hbox1 = new HBox();
HBox hbox2 = new HBox();
HBox hbox3 = new HBox();
HBox hbox4 = new HBox();
HBox hbox5 = new HBox();

@Override
	public void start( Stage primaryStage){
	 	Scene scene = new Scene(pane,700,350);
		primaryStage.setTitle("Bank Account Services");
		
		// Place the scene in the stage
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		ComboBox <String> cbo = new ComboBox<String>();
		pane.setLeft(new Label("Select A Service: "));	
		pane.setRight(cbo);
		cbo.setPrefWidth(300);
		cbo.setStyle("-fx-color: lightgrey");
		ObservableList<String> items = FXCollections.observableArrayList("Open New Account", "Open CD Account", "Deposit",
			 "Withdraw", "Check Balance", "Close Account");
		cbo.getItems().addAll(items);
		
		cbo.setOnAction(e -> {
			if(cbo.getValue() == "Open New Account"){
				openAcFunction();
			}else if(cbo.getValue() =="Open CD Account"){
			    openCDAccountFunction();
			}else if(cbo.getValue() =="Deposit"){
				makeDeposit();
			}else if(cbo.getValue() =="Withdraw"){
				makewithdraw();
			}else if(cbo.getValue() =="Check Balance"){
				checkBalance();
			}else if (cbo.getValue() =="Close Account"){
				closeAccnt();
			}
			
		});
	}
	 public void openAcFunction(){
		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(100)); 
		gridpane.setHgap(5);
		gridpane.setVgap(5);                                                                                                               
		gridpane.add(new Label("Account Number:"), 0, 0); 
		gridpane.add( tfAccountNumber, 1, 0); 
		tfAccountNumber.setEditable(false);
	    gridpane.add(new Label("Initial Deposit:"), 0, 1); 
		gridpane.add(tfIntialdeposit, 1, 1);
		gridpane.add(new Label("Annual Interest Rate(%):"), 0, 2);
		gridpane.add(tfAnnualInterestRate, 1, 2);
		tfAnnualInterestRate.setEditable(false);
		gridpane.add(new Label("Account Balance:"), 0, 3);
		gridpane.add( tfIntialBalance, 1, 3);
		tfIntialBalance.setEditable(false);
        gridpane.add(hbox, 1, 4);
		pane.setBottom(gridpane);
		hbox.setSpacing(5);
		hbox.setAlignment(Pos.CENTER_LEFT);
		Button btOpenAccount = new Button("Open Account");
	    btOpenAccount.setPrefSize(130, 30);
	    Button btCancel = new Button("Cancel");
	    btCancel.setPrefSize(70, 30);
	    Text text = new Text();
        text.setText("Account Created");
      
      
	    hbox.getChildren().addAll(btOpenAccount,btCancel);
	    
	    btOpenAccount.setOnMouseClicked(new EventHandler<MouseEvent>(){
	     public void handle(MouseEvent button) {
	        double  AdepositAmnt = Double.parseDouble(tfIntialdeposit.getText());
			double bal = 0.0;
			double InterestRate = 3.00;
			     
				tfAnnualInterestRate.setText(String.format("%.2f", InterestRate));
					     
				accountsId.add(1005);
				accountsId.add(1004);
				accountsId.add(1003);
				accountsId.add(1002);
				accountsId.add(1001);
				Collections.shuffle(accountsId);
					     
				Account account2 = new CDAccount(accountsId.get(0),bal);
				Account account3 = new CDAccount(accountsId.get(1),bal);
				Account account4 = new CDAccount(accountsId.get(2),bal);
				Account account5 = new CDAccount(accountsId.get(3),bal);
				Account account6 = new CDAccount(accountsId.get(4),bal);
		
				accounts.add(account2);
				accounts.add(account3);
				accounts.add(account4);
				accounts.add(account5);
				accounts.add(account6);
		
		            for(int i = 0; i< accounts.size(); i++){
					          accounts.get(i).setId(accountsId.get(i));
					          accounts.get(i).deposit(AdepositAmnt);
					          tfIntialBalance.setEditable(false);
					          tfIntialBalance.setText(String.format("$%.2f", accounts.get(i).getBalance()));
					          tfAccountNumber.setText(String.format("%d", accounts.get(i).getId()));
					          }
		            text.setText("Account Created");
		               text.setFont(Font.font(java.awt.Font.SERIF, 15));
		               text.setFont(Font.font(java.awt.Font.BOLD));
		               text.setFont(Font.font(java.awt.Font.ITALIC));
		               text.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
		     		   gridpane.add(text, 0, 6);
       
            }
        });
	    
	    btCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent button) {
            	tfIntialdeposit.clear();
            }
        });
	 }
	
		 
			     
	 public void openCDAccountFunction(){
		 GridPane gridpane1 = new GridPane();
		 gridpane1.setAlignment(Pos.CENTER_LEFT);
		 gridpane1.setPadding(new Insets(100)); 
		 gridpane1.setHgap(5);
		 gridpane1.setVgap(5);                                                                                                               
		 gridpane1.add(new Label("Account Number:"), 0, 0); 
		 gridpane1.add( tfCDAccountNumber, 1, 0); 
		 tfCDAccountNumber.setEditable(false);
		 gridpane1.add(new Label("Deposit Amount:"), 0, 1); 
		 gridpane1.add( tfCDDepositAmount, 1, 1); 
	     gridpane1.add(new Label("CD Duration(Months):"), 0, 2); 
		 gridpane1.add(tfCDDuration, 1, 2);
		 gridpane1.add(new Label("CD Annual Interest Rate(%):"), 0, 3);
		 gridpane1.add(tfCDAnnualInterestRate, 1, 3);
		 tfCDAnnualInterestRate.setEditable(false);
		 gridpane1.add(new Label("Account Maturation Balance"), 0, 4);
		 gridpane1.add( tfCDMaturationBalance, 1, 4);
		 tfCDMaturationBalance.setEditable(false);
         gridpane1.add(hbox1, 1, 5);
		 pane.setBottom(gridpane1);
	     hbox1.setSpacing(5);
		 hbox1.setAlignment(Pos.CENTER_LEFT);
		 Button btOpenAccount1 = new Button("Open Account");
	     btOpenAccount1.setPrefSize(130, 30);
		 Button btCancel1 = new Button("Cancel");
	     btCancel1.setPrefSize(70, 30);
	     Text text = new Text();
   
		 hbox1.getChildren().addAll(btOpenAccount1,btCancel1);
		 
		 btOpenAccount1.setOnMouseClicked(new EventHandler<MouseEvent>(){
	         public void handle(MouseEvent button) {
	                double  CDdepositAmnt = Double.parseDouble(tfCDDepositAmount.getText());
	     		    int CDduration = Integer.parseInt(tfCDDuration.getText());
	     		    double Balance = 0;
	     		    double InterestRate = 3.00;
	                
	                
	                CDaccountsId.add(1010);
	     		    CDaccountsId.add(1009);
	     		    CDaccountsId.add(1008);
	     		    CDaccountsId.add(1006);
	     		    CDaccountsId.add(1007);
	     		 	
	     		    CDAccount CDaccount2 = new CDAccount(CDaccountsId.get(0),Balance, CDduration);
	     		    CDAccount CDaccount3 = new CDAccount(CDaccountsId.get(1),Balance, CDduration);
	     		    CDAccount CDaccount4 = new CDAccount(CDaccountsId.get(2),Balance, CDduration);
	     		    CDAccount CDaccount5 = new CDAccount(CDaccountsId.get(3),Balance, CDduration);
	     		    CDAccount CDaccount6 = new CDAccount(CDaccountsId.get(4),Balance, CDduration);
	     		    
	     		    CDaccounts.add(CDaccount2);
	     		    CDaccounts.add(CDaccount3);
	     		    CDaccounts.add(CDaccount4);
	     		    CDaccounts.add(CDaccount5);
	     		    CDaccounts.add(CDaccount6);
	     	
	     		    Collections.shuffle(CDaccountsId);
	     		    for(int i = 0 ;i <  CDaccounts.size(); i++){
			     		    CDaccounts.get(i).setId(CDaccountsId.get(i));
			     		  	tfCDAccountNumber.setText(String.format("%d", CDaccounts.get(i).getId()));
			     		  	CDaccounts.get(i).deposit(CDdepositAmnt);
			     		  	CDaccounts.get(i).setDuration(CDduration);
			     		  	Balance = (CDdepositAmnt*CDaccounts.get(i).getCDAnnualInterestRate()*CDduration)/1200 +CDdepositAmnt;
			     		  	CDaccounts.get(i).setCDAnnualInterestRate(InterestRate);
			     		  	CDaccounts.get(i).setBalance(Balance);
			     		  	tfCDAnnualInterestRate.setText(String.format("%.2f", CDaccounts.get(i).getCDAnnualInterestRate()));
			     			tfCDDuration.setText(String.format("%d", CDaccounts.get(i).getDuration()));
			     			tfCDMaturationBalance.setText(String.format("%.2f", CDaccounts.get(i).getBalance()));
			     		 }
	     		    
	     		   text.setText("CD Account Created");
	               text.setFont(Font.font(java.awt.Font.SERIF, 15));
	               text.setFont(Font.font(java.awt.Font.BOLD));
	               text.setFont(Font.font(java.awt.Font.ITALIC));
	               text.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
	     		   gridpane1.add(text, 0, 6);
	     		   
	             
	     		 }
	        });
		 
		 btCancel1.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent button) {
	            	tfCDAccountNumber.clear();
	            	tfCDDepositAmount.clear();
	            	tfCDDuration.clear();
	            	tfCDAnnualInterestRate.clear();
	            	tfCDMaturationBalance.clear();
	            }
	        });
	 }
 
	public void makeDeposit(){
		 GridPane gridpane2 = new GridPane();
			gridpane2.setAlignment(Pos.CENTER);
			gridpane2.setPadding(new Insets(100)); 
			gridpane2.setHgap(5);
			gridpane2.setVgap(5);                                                                                                               
			gridpane2.add(new Label("Account Number:"), 0, 0); 
			gridpane2.add( tfDAccountNumber, 1, 0); 
			gridpane2.add(new Label("Deposit Amount:"), 0, 1); 
			gridpane2.add( tfDDepositAmount, 1, 1); 
		    gridpane2.add(new Label("Account Balance:"), 0, 2); 
			gridpane2.add(tfDAccountBalance, 1, 2);
			tfDAccountBalance.setEditable(false);
			pane.setBottom(gridpane2);
			hbox2.setSpacing(5);
			hbox2.setAlignment(Pos.CENTER_LEFT);
			Button btMakeDeposit = new Button("Make Deposit");
			btMakeDeposit.setPrefSize(130, 30);
	        Button btCancel2 = new Button("Cancel");
		    btCancel2.setPrefSize(70, 30);
			hbox2.getChildren().addAll(btMakeDeposit,btCancel2);
			gridpane2.add(hbox2, 1, 3);
			btMakeDeposit.setOnMouseClicked(new EventHandler<MouseEvent>(){
		            public void handle(MouseEvent button) {
		            	int userId = Integer.parseInt( tfDAccountNumber.getText());
		    			double userdeposit = Double.parseDouble(tfDDepositAmount.getText()); 
		    	
		    			for(int i = 0 ;i < accounts.size();i++){
					    			if(userId ==accounts.get(i).getId())
					    			{
					    				 
					    				 tfDAccountNumber.setText(String.format("%d", accounts.get(i).getId()));
					    				 accounts.get(i).setBalance(accounts.get(i).getBalance());
					    				 accounts.get(i).deposit(userdeposit);
					    				 tfDAccountBalance.setText(String.format("$%.2f", accounts.get(i).getBalance()));	
					    				 Text text = new Text();
					  	                 gridpane2.add(text,0,7);
					  	                 text.setText("Deposit Transaction Completed");
					  	                 text.setFont(Font.font(java.awt.Font.SERIF, 15));
					  	                 text.setFont(Font.font(java.awt.Font.BOLD));
					  	                 text.setFont(Font.font(java.awt.Font.ITALIC));
					  	                 text.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
					    				 }
						    	        
							    	 }
				    	    for(int i = 0 ;i < CDaccounts.size();i++){
						    	    	if(!(userId == CDaccounts.get(i).getId())) {
						    	    	   
						    				Text text = new Text();
						    				Text text1 = new Text();
						  	                 text.setText("You can not Make a Deposit to an Existing CDAccount.");
						  	                 text1.setText("Please try again");
						  	                 text.setFont(Font.font(java.awt.Font.SERIF, 15));
						  	                 text.setFont(Font.font(java.awt.Font.BOLD));
						  	                 text.setFont(Font.font(java.awt.Font.ITALIC));
						  	                 text.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
						  	                 text1.setFont(Font.font(java.awt.Font.SERIF, 15));
						  	                 text1.setFont(Font.font(java.awt.Font.BOLD));
						  	                 text1.setFont(Font.font(java.awt.Font.ITALIC));
						  	                 text1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
						  	                 gridpane2.add(text, 0, 5);
						  	                 gridpane2.add(text1, 0, 6);
						    				  
						    	    	}
				    	    }
		     	}
		        });
			btCancel2.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent button) {
	            	tfDAccountNumber.clear();
	            	tfDDepositAmount.clear();
	            	tfDAccountBalance.clear();
	            }
	        });
			
	} 
	
	 
	 public void makewithdraw(){
		 GridPane gridpane3 = new GridPane();
			gridpane3.setAlignment(Pos.CENTER_LEFT);
			gridpane3.setPadding(new Insets(100)); 
			gridpane3.setHgap(5);
			gridpane3.setVgap(5);                                                                                                               
			gridpane3.add(new Label("Account Number:"), 0, 0); 
			gridpane3.add( tfWAccountNumber, 1, 0); 
			gridpane3.add(new Label("Withdraw Amount:"), 0, 1); 
			gridpane3.add( tfWithdrawAmount, 1, 1); 
		    gridpane3.add(new Label("Account Balance:"), 0, 2); 
			gridpane3.add(tfWAccountBalance, 1, 2);
			tfWAccountBalance.setEditable(false);
			pane.setBottom(gridpane3);
			hbox3.setSpacing(5);
		    hbox3.setAlignment(Pos.CENTER_LEFT);
   	        Button btMakeWithdraw = new Button("Make Withdraw");
			btMakeWithdraw.setPrefSize(130, 30);
		    Button btCancel3 = new Button("Cancel");
			btCancel3.setPrefSize(70, 30);
			hbox3.getChildren().addAll(btMakeWithdraw,btCancel3);
			gridpane3.add(hbox3, 1, 3);
			     btMakeWithdraw.setOnMouseClicked(new EventHandler<MouseEvent>(){
			            public void handle(MouseEvent button) {
			            	int userId = Integer.parseInt( tfWAccountNumber.getText());
			       		 double userWithdraw = Double.parseDouble(tfWithdrawAmount.getText()); 

			       		
							       	    for(int i = 0 ;i < accounts.size();i++){
							       				
							       				
							       			if(userId == accounts.get(i).getId())
							       			{
							       			
							       			   accounts.get(i).setBalance(accounts.get(i).getBalance());
							       			   accounts.get(i).withdraw(userWithdraw);
							       			   tfWAccountBalance.setText(String.format("$%.2f", accounts.get(i).getBalance()));	
							       			   Text text1 = new Text();
							       			   text1.setText("Withdraw Transaction Completed.");
								               text1.setFont(Font.font(java.awt.Font.SERIF, 15));
								               text1.setFont(Font.font(java.awt.Font.BOLD));
								               text1.setFont(Font.font(java.awt.Font.ITALIC));
								               text1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
								     		   gridpane3.add(text1, 0, 5);
							       			}
							       		
							       	 }
							       	for(int i = 0 ;i < CDaccounts.size();i++){
							       	    	if(!(userId == CDaccounts.get(i).getId())) {
							       	    	    System.out.print("Test3");
							       	    		
							 
							    Text text2 = new Text();
							    text2.setText("Invalid Account Number!!.Please try again");
								text2.setFont(Font.font(java.awt.Font.SERIF, 15));
							    text2.setFont(Font.font(java.awt.Font.BOLD));
								text2.setFont(Font.font(java.awt.Font.ITALIC));
							    text2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
								gridpane3.add(text2, 0, 6);
							       	    	}
							       	 }
							     	}
			     			});
			     btCancel3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			            public void handle(MouseEvent button) {
			            	tfWAccountNumber.clear();
			            	tfWithdrawAmount.clear();
			            	tfWAccountBalance.clear();
			            }
			        });
	 }
	 
	
	 public void checkBalance(){
		    GridPane gridpane4 = new GridPane();
			gridpane4.setAlignment(Pos.CENTER_LEFT);
			gridpane4.setPadding(new Insets(100)); 
			gridpane4.setHgap(5);
			gridpane4.setVgap(5);                                                                                                               
			gridpane4.add(new Label("Account Number:"), 0, 0); 
			gridpane4.add( tfChkAccountNumber, 1, 0); 
			gridpane4.add(new Label("Account Balance:"), 0, 1); 
			gridpane4.add( tfMAccountBalance , 1, 1); 
			tfMAccountBalance.setEditable(false);
			pane.setBottom(gridpane4);  
			hbox4.setSpacing(5);
			hbox4.setAlignment(Pos.CENTER_LEFT);
			Button btCheckbal = new Button("Check Balance");
			btCheckbal.setPrefSize(130, 30);
		    Button btCancel4 = new Button("Cancel");
		    btCancel4.setPrefSize(70, 30);
			hbox4.getChildren().addAll(btCheckbal,btCancel4);
			gridpane4.add(hbox4, 1, 2);
			btCheckbal.setOnMouseClicked(new EventHandler<MouseEvent>(){
				    public void handle(MouseEvent button) {
				            	int userId = Integer.parseInt( tfChkAccountNumber.getText()); 
			                   
				        	    for(int i = 0 ;i < accounts.size();i++){
				        	   
				        			if(userId == accounts.get(i).getId())
				        			{
				        				 
				        				 tfMAccountBalance.setText(String.format("$%.2f", accounts.get(i).getBalance()));
				        				 break;
				        			}
				        			
				        			
				        	    }
				        	    for(int i = 0 ;i < CDaccounts.size();i++){
				        			
				        			 
				        		if(userId == CDaccounts.get(i).getId())
				        		{
				        			 
				        			 tfMAccountBalance.setText(String.format("$%.2f", CDaccounts.get(i).getBalance()));	
				        			}
				        		
				        		
				        	 }
				     	}
				        });
			btCancel4.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent button) {
	            	tfChkAccountNumber.clear();
	            	tfMAccountBalance.clear();
	            }
	        });	
	 }
	 
	
	 public void closeAccnt(){
		    GridPane gridpane5 = new GridPane();
		    
			gridpane5.setAlignment(Pos.CENTER_LEFT);
			gridpane5.setPadding(new Insets(100)); 
			gridpane5.setHgap(5);
			gridpane5.setVgap(5);                                                                                                               
			gridpane5.add(new Label("Account Number:"), 0, 0); 
			gridpane5.add( tfClAccountNumber, 1, 0); 
			gridpane5.add(new Label("Account Balance:"), 0, 1); 
			gridpane5.add( tfClAccountBalance , 1, 1); 
			tfClAccountBalance.setEditable(false);
			pane.setBottom(gridpane5);
			hbox5.setSpacing(5);
			hbox5.setAlignment(Pos.CENTER_LEFT);		     
			Button btClAccount = new Button("Close Account");
			btClAccount.setPrefSize(130, 30);
			Button btCancel5 = new Button("Cancel");
			btCancel5.setPrefSize(70, 30);
			hbox5.getChildren().addAll(btClAccount,btCancel5);
			pane.setBottom(gridpane5); 
			
			gridpane5.add(hbox5, 1, 2);
			btClAccount.setOnMouseClicked(new EventHandler<MouseEvent>(){
	            public void handle(MouseEvent button) {
			            	int userId = Integer.parseInt( tfClAccountNumber.getText()); 
			        		
			        	    for(int i = 0 ;i < accounts.size();i++){	
			        			if(userId == accounts.get(i).getId())
			        			{
			        				
			        				 tfClAccountBalance.setText(String.format("$%.2f", accounts.get(i).getBalance()));
			        				 Button confirm = new Button("Confirm");
			        				 confirm.setPrefSize(130, 30);
			        				 hbox5.getChildren().addAll(confirm);
			        				 Text text = new Text();
			        				 text.setText("Please Click the Confirm Button to Close Account");
										text.setFont(Font.font(java.awt.Font.SERIF, 15));
									    text.setFont(Font.font(java.awt.Font.BOLD));
										text.setFont(Font.font(java.awt.Font.ITALIC));
									    text.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
										gridpane5.add(text, 0, 9);
										 confirm.setOnMouseClicked(new EventHandler<MouseEvent>(){
				        			            public void handle(MouseEvent button) {
				        			            			text.setText("");
				        			            			for(int j=0; j < accounts.size(); j++){
				        			            			
				        			            	        if(userId == accounts.get(j).getId()){
				        			            	        	 accounts.remove(j); 
				        			            		            confirm.setVisible(false);
				        			            		            confirm.setDisable(true);
				        			            		            Text text1 = new Text();
				        			            		            text1.setText("Your Account is Closed");
				        			            		            text1.setFont(Font.font(java.awt.Font.SERIF, 15));
				        			            		            text1.setFont(Font.font(java.awt.Font.BOLD));
				        			            		            text1.setFont(Font.font(java.awt.Font.ITALIC));
				        			            		            text1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
				        			            		            gridpane5.add(text1,0,7);           
				        			            		           
				        			            		           
				        			            		           
				        			            	         }     
				        			                  }
				        			            }        			
				        					});
				        				 break;
				        			}
			        			
	        	    }
			        	    for(int n = 0 ;n < CDaccounts.size();n++){
			        	    			if(userId == CDaccounts.get(n).getId())
			        	    			{
			        	    				
					        				tfClAccountBalance.setText(String.format("$%.2f", CDaccounts.get(n).getBalance()));
					        				Button confirm1 = new Button("Confirm");
					        				confirm1.setPrefSize(130, 30);
					        				hbox5.getChildren().addAll(confirm1);
					        				Text text = new Text();
					        				Text text1 = new Text();
					        				 text.setText("You May Lost the Interest if Close" +"\n"+" a CD Account Before the Mature Date");
					        				 text1.setText("Please Click the Confirm Button to Close the CD Account");
						     	                text.setFont(Font.font(java.awt.Font.SERIF, 15));
						     	                text.setFont(Font.font(java.awt.Font.BOLD));
						     	                text.setFont(Font.font(java.awt.Font.ITALIC));
						     	                text.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
						     	               text1.setFont(Font.font(java.awt.Font.SERIF, 15));
						     	                text1.setFont(Font.font(java.awt.Font.BOLD));
						     	                text1.setFont(Font.font(java.awt.Font.ITALIC));
						     	                text1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
						     	                gridpane5.add(text,0,8);
						     	               gridpane5.add(text1,0,9);
					     	               
					     	                		
					     	               
					        				confirm1.setOnMouseClicked(new EventHandler<MouseEvent>(){
					        			            public void handle(MouseEvent button) {
					        			            		text.setText("");
					        			            			for(int k=0; k < CDaccounts.size(); k++){
					        			            					
					        			            						if(userId == CDaccounts.get(k).getId()){
					        			            							
					        			            							CDaccounts.remove(k);
									        			            		    confirm1.setVisible(false);
									        			            		    confirm1.setDisable(true);
										        			                    Text text = new Text();
										        		     	               
										        		     	                gridpane5.setAlignment(Pos.CENTER_LEFT);
										        		     	                text.setText("Your Account is Closed");
										        		     	                text.setFont(Font.font(java.awt.Font.SERIF, 25));
										        		     	                text.setFont(Font.font(java.awt.Font.BOLD));
										        		     	                text.setFont(Font.font(java.awt.Font.ITALIC));
										        		     	                text.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
						        			            	            	    gridpane5.add(text,0,7);
					        			            						}
						        			                }
					        			            }        			
					        					});
	        				 break;
	        	 }
	     	}
	       }
	        });	
			btCancel5.setOnMouseClicked(new EventHandler<MouseEvent>() {
		           public void handle(MouseEvent button) {
		        	   tfClAccountNumber.clear();
		        	   tfClAccountBalance.clear();
		            }
		        });
		     }
	 }
  
