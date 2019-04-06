package Gui;

import Controller.UserService;
import com.mycompany.usernavigation.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UserTransactions extends BorderPane {

    protected final FlowPane flowPane;
    protected final Button New;
    protected final Button Update;
    protected final Button Delete;
    protected final Button First;
    protected final Button Previous;
    protected final Button Next;
    protected final Button Last;
    protected final FlowPane flowPane0;
    protected final Label IDLabel;
    protected final TextField TextfieldID;
    protected final Label labelFirstName;
    protected final TextField textFieldFirstName;
    protected final Label labelMiddleName;
    protected final TextField textFieldMiddleName;
    protected final Label labelLastName;
    protected final TextField textFieldLastName;
    protected final Label labelEmail;
    protected final TextField textFieldEmail;
    protected final Label labelPhone;
    protected final TextField textFieldPhone;
    protected final Label Title;
    protected boolean flag=false;
    
    protected List<User> userList;
    protected static int index=0;

    

    public UserTransactions(Stage stage) {
        //Controller controller=new Controller();
        UserService services=new UserService();
        flowPane = new FlowPane();
        New = new Button();
        Update = new Button();
        Delete = new Button();
        First = new Button();
        Previous = new Button();
        Next = new Button();
        Last = new Button();
        flowPane0 = new FlowPane();
        IDLabel = new Label();
        TextfieldID = new TextField();
        labelFirstName = new Label();
        textFieldFirstName = new TextField();
        labelMiddleName = new Label();
        textFieldMiddleName = new TextField();
        labelLastName = new Label();
        textFieldLastName = new TextField();
        labelEmail = new Label();
        textFieldEmail = new TextField();
        labelPhone = new Label();
        textFieldPhone = new TextField();
        Title = new Label();
        

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(64.0);
        flowPane.setPrefWidth(600.0);

        New.setMnemonicParsing(false);
        New.setPrefHeight(25.0);
        New.setPrefWidth(84.0);
        New.setText("New");
        New.setOnAction((event)->{
            TextfieldID.setText("");
            textFieldFirstName.setText("");
            textFieldMiddleName.setText("");
            textFieldLastName.setText("");
            textFieldEmail.setText("");
            textFieldPhone.setText("");  
               // Resultset.moveToInsertRow();
            flag=true;
             
        });

        Update.setMnemonicParsing(false);
        Update.setPrefHeight(25.0);
        Update.setPrefWidth(79.0);
        Update.setText("Update");
        Update.setOnAction(event->{
            if(TextfieldID.getText().equals("")|textFieldFirstName.getText().equals("")|textFieldMiddleName.getText().equals("")|textFieldLastName.getText().equals("")|textFieldEmail.getText().equals("")|textFieldPhone.getText().equals("") ){
                        JOptionPane.showMessageDialog(null, "Please insert values in all fields");
            }
            else{
                        
                    User user=new User();
                    user.setId(Integer.parseInt(TextfieldID.getText()));
                    user.setFirstName(textFieldFirstName.getText());
                    user.setLastName(textFieldLastName.getText());
                    user.setMiddleName(textFieldMiddleName.getText());
                    user.setPhone(textFieldPhone.getText());
   
                    if(flag==false){
                        services.update(user);
                       // Resultset.updateRow();   //to change value in DB

                    }else{
                       // Resultset.insertRow();
                       services.create(user);
                        flag=false;
                    }
                
            }
        });
        Delete.setLayoutX(94.0);
        Delete.setLayoutY(10.0);
        Delete.setMnemonicParsing(false);
        Delete.setPrefHeight(25.0);
        Delete.setPrefWidth(91.0);
        Delete.setText("Delete");
        Delete.setOnAction(event->{
            if(TextfieldID.getText().equals("")|textFieldFirstName.getText().equals("")|textFieldMiddleName.getText().equals("")|textFieldLastName.getText().equals("")|textFieldEmail.getText().equals("")|textFieldPhone.getText().equals("") ){
                        JOptionPane.showMessageDialog(null, "Please insert values in all fields");
            }else{
               
                    User user=new User();
                    user.setId(Integer.parseInt(TextfieldID.getText()));
                    user.setFirstName(textFieldFirstName.getText());
                    user.setLastName(textFieldLastName.getText());
                    user.setMiddleName(textFieldMiddleName.getText());
                    user.setPhone(textFieldPhone.getText());
                    services.delete(user);
                    //Resultset.deleteRow();                
                    TextfieldID.setText("");
                    textFieldFirstName.setText("");
                    textFieldMiddleName.setText("");
                    textFieldLastName.setText("");
                    textFieldEmail.setText("");
                    textFieldPhone.setText("");
                
            }
        
        });
        
        First.setLayoutX(149.0);
        First.setLayoutY(10.0);
        First.setMnemonicParsing(false);
        First.setPrefHeight(25.0);
        First.setPrefWidth(83.0);
        First.setText("First");
        First.setOnAction(event->{
                index=0;       
                userList=services.retreiveAllUsers();
                TextfieldID.setText(Integer.toString(userList.get(0).getId()));
                textFieldFirstName.setText(userList.get(0).getFirstName());
                textFieldMiddleName.setText(userList.get(0).getMiddleName());
                textFieldLastName.setText(userList.get(0).getLastName());
                textFieldEmail.setText(userList.get(0).getEmail());
                textFieldPhone.setText(userList.get(0).getPhone());

        });
        
        Previous.setLayoutX(200.0);
        Previous.setLayoutY(10.0);
        Previous.setMnemonicParsing(false);
        Previous.setPrefHeight(25.0);
        Previous.setPrefWidth(87.0);
        Previous.setText("Previous");
        Previous.setOnAction(event->{
           if(index==0){
               JOptionPane.showMessageDialog(null, "That was the First Employee");
           }else{ 
                userList=services.retreiveAllUsers();
                index--;
                TextfieldID.setText(Integer.toString(userList.get(index).getId()));
                textFieldFirstName.setText(userList.get(index).getFirstName());
                textFieldMiddleName.setText(userList.get(index).getMiddleName());
                textFieldLastName.setText(userList.get(index).getLastName());
                textFieldEmail.setText(userList.get(index).getEmail());
                textFieldPhone.setText(userList.get(index).getPhone());
            } 
        });
        
        Next.setLayoutX(239.0);
        Next.setLayoutY(10.0);
        Next.setMnemonicParsing(false);
        Next.setPrefHeight(25.0);
        Next.setPrefWidth(89.0);
        Next.setText("Next");
        Next.setOnAction(event->{
            userList=services.retreiveAllUsers();
             if(index==userList.size()-1){
                JOptionPane.showMessageDialog(null, "that was the last Employee");
           }else{ 
                index++;
                TextfieldID.setText(Integer.toString(userList.get(index).getId()));
                textFieldFirstName.setText(userList.get(index).getFirstName());
                textFieldMiddleName.setText(userList.get(index).getMiddleName());
                textFieldLastName.setText(userList.get(index).getLastName());
                textFieldEmail.setText(userList.get(index).getEmail());
                textFieldPhone.setText(userList.get(index).getPhone());
            } 
            
        
        });

        Last.setLayoutX(300.0);
        Last.setLayoutY(10.0);
        Last.setMnemonicParsing(false);
        Last.setPrefHeight(25.0);
        Last.setPrefWidth(85.0);
        Last.setText("Last");
        Last.setOnAction(event->{    
                userList=services.retreiveAllUsers();
                int len=userList.size()-1;
                index=len;
                TextfieldID.setText(Integer.toString(userList.get(len).getId()));
                textFieldFirstName.setText(userList.get(len).getFirstName());
                textFieldMiddleName.setText(userList.get(len).getMiddleName());
                textFieldLastName.setText(userList.get(len).getLastName());
                textFieldEmail.setText(userList.get(len).getEmail());
                textFieldPhone.setText(userList.get(len).getPhone());

           
        
        });
        setBottom(flowPane);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(200.0);

        IDLabel.setPrefHeight(17.0);
        IDLabel.setPrefWidth(128.0);
        IDLabel.setText("ID");

        TextfieldID.setPrefHeight(25.0);
        TextfieldID.setPrefWidth(406.0);
        

        labelFirstName.setLayoutX(10.0);
        labelFirstName.setLayoutY(14.0);
        labelFirstName.setPrefHeight(17.0);
        labelFirstName.setPrefWidth(128.0);
        labelFirstName.setText("FirstName");

        textFieldFirstName.setPrefHeight(25.0);
        textFieldFirstName.setPrefWidth(405.0);

        labelMiddleName.setLayoutX(10.0);
        labelMiddleName.setLayoutY(39.0);
        labelMiddleName.setPrefHeight(17.0);
        labelMiddleName.setPrefWidth(128.0);
        labelMiddleName.setText("MiddleName");

        textFieldMiddleName.setPrefHeight(25.0);
        textFieldMiddleName.setPrefWidth(404.0);

        labelLastName.setLayoutX(426.0);
        labelLastName.setLayoutY(64.0);
        labelLastName.setPrefHeight(17.0);
        labelLastName.setPrefWidth(127.0);
        labelLastName.setText("LastName");

        textFieldLastName.setPrefHeight(25.0);
        textFieldLastName.setPrefWidth(405.0);

        labelEmail.setLayoutX(507.0);
        labelEmail.setLayoutY(64.0);
        labelEmail.setPrefHeight(17.0);
        labelEmail.setPrefWidth(128.0);
        labelEmail.setText("Email");

        textFieldEmail.setLayoutX(10.0);
        textFieldEmail.setLayoutY(10.0);
        textFieldEmail.setPrefHeight(25.0);
        textFieldEmail.setPrefWidth(405.0);

        labelPhone.setLayoutX(10.0);
        labelPhone.setLayoutY(85.0);
        labelPhone.setPrefHeight(17.0);
        labelPhone.setPrefWidth(128.0);
        labelPhone.setText("Phone");

        textFieldPhone.setLayoutX(10.0);
        textFieldPhone.setLayoutY(10.0);
        textFieldPhone.setPrefHeight(25.0);
        textFieldPhone.setPrefWidth(406.0);
        setCenter(flowPane0);

        BorderPane.setAlignment(Title, javafx.geometry.Pos.CENTER);
        Title.setPrefHeight(42.0);
        Title.setPrefWidth(76.0);
        Title.setText("Person Details");
        setTop(Title);

        flowPane.getChildren().add(New);
        flowPane.getChildren().add(Update);
        flowPane.getChildren().add(Delete);
        flowPane.getChildren().add(First);
        flowPane.getChildren().add(Previous);
        flowPane.getChildren().add(Next);
        flowPane.getChildren().add(Last);
        flowPane0.getChildren().add(IDLabel);
        flowPane0.getChildren().add(TextfieldID);
        flowPane0.getChildren().add(labelFirstName);
        flowPane0.getChildren().add(textFieldFirstName);
        flowPane0.getChildren().add(labelMiddleName);
        flowPane0.getChildren().add(textFieldMiddleName);
        flowPane0.getChildren().add(labelLastName);
        flowPane0.getChildren().add(textFieldLastName);
        flowPane0.getChildren().add(labelEmail);
        flowPane0.getChildren().add(textFieldEmail);
        flowPane0.getChildren().add(labelPhone);
        flowPane0.getChildren().add(textFieldPhone);
    }
}
