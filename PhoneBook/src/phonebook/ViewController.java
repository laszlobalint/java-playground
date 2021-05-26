package phonebook;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class ViewController implements Initializable {
    
    @FXML
    TableView table;
    @FXML
    TextField inputLastname;
    @FXML
    TextField inputFirstname;
    @FXML
    TextField inputEmail;
    @FXML
    Button addNewContactButton;
    @FXML
    StackPane menuPane;
    @FXML
    Pane contactPane;
    @FXML
    Pane exportPane;
    @FXML
    TextField inputExportName;
    @FXML
    Button exportButton;
    @FXML
    AnchorPane anchor;
    @FXML
    SplitPane mainSplit;        
    
    DB db = new DB();
    
    private final String MENU_CONTACTS = "Contacts";
    private final String MENU_LIST = "List";
    private final String MENU_EXPORT = "Export";
    private final String MENU_EXIT = "Exit";
    
    private final ObservableList<Person> data = FXCollections.observableArrayList();
    
    @FXML
    public void addContact(ActionEvent event) {
        String email = inputEmail.getText();
        if (email.length() > 3 && email.contains("@") && email.contains(".")) {
        Person newPerson = new Person(inputLastname.getText(), inputFirstname.getText(), email) ;   
        data.add(newPerson);
        db.addContact(newPerson);
        inputLastname.clear();
        inputFirstname.clear();
        inputEmail.clear();
        } else {
            alert ("Give a real e-mail address!");
        }
    }
    
    @FXML
    public void exportList(ActionEvent event) {
        String fileName = inputExportName.getText();
        fileName = fileName.replace("\\s+", "");
        if (fileName != null && !fileName.equals("")) {
            PdfGenerator pdfCreator = new PdfGenerator();
            pdfCreator.pdfGenerator(fileName, data);
        } else {
            alert("Give a filename!");
        }
    }    
    
    public void setTableData() {
        TableColumn lastNameCol = new TableColumn("Lastname");
        lastNameCol.setMinWidth(130);
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        
        lastNameCol.setOnEditCommit(
          new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
              @Override
              public void handle(TableColumn.CellEditEvent<Person, String> t) {
                  Person actualPerson = (Person) t.getTableView().getItems().get(t.getTablePosition().getRow());
                  actualPerson.setLastName(t.getNewValue());
                  db.updateContact(actualPerson);
              }
          }
        );
        
        TableColumn firstNameCol = new TableColumn("Firstname");
        firstNameCol.setMinWidth(130);
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        
        firstNameCol.setOnEditCommit(
          new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
              @Override
              public void handle(TableColumn.CellEditEvent<Person, String> t) {
                  Person actualPerson = (Person) t.getTableView().getItems().get(t.getTablePosition().getRow());
                  actualPerson.setFirstName(t.getNewValue());
                  db.updateContact(actualPerson);
              }
          }
        );
        
        TableColumn emailCol = new TableColumn("E-mail");
        emailCol.setMinWidth(250);
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        
        emailCol.setOnEditCommit(
          new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
              @Override
              public void handle(TableColumn.CellEditEvent<Person, String> t) {
                  Person actualPerson = (Person) t.getTableView().getItems().get(t.getTablePosition().getRow());
                  actualPerson.setEmail(t.getNewValue());
                  db.updateContact(actualPerson);
              }
          }
        );
        
        TableColumn removeCol = new TableColumn("Delete");
        emailCol.setMinWidth(100);
        
        Callback<TableColumn<Person, String>, TableCell<Person, String>> cellFactory = new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
            @Override
            public TableCell call(final TableColumn<Person, String> param) {
                final TableCell<Person, String> cell = new TableCell<Person, String>() {
                    final Button btn = new Button("Delete");
                    
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction((ActionEvent event) -> 
                            {
                            Person person = getTableView().getItems().get(getIndex());
                            data.remove(person);
                            db.removeContact(person);
                        } );
                        setGraphic(btn);
                        setText(null);
                        }
                    }
                };
            return cell;
            }
        };
        
        removeCol.setCellFactory(cellFactory);
        
        table.getColumns().addAll(lastNameCol, firstNameCol, emailCol);
        data.addAll(db.getAllContacts());
        table.setItems(data);
    }
    
    public void setMenuData() {
        TreeItem<String> treeItemRoot1 = new TreeItem<>("Menu");
        TreeView<String> treeView = new TreeView<>(treeItemRoot1);
        treeView.setShowRoot(false);
        
        TreeItem<String> nodeItemA = new TreeItem<>(MENU_CONTACTS);
        TreeItem<String> nodeItemB = new TreeItem<>(MENU_EXIT);
        
        nodeItemA.setExpanded(true);
        
        Node contactsNode = new ImageView(new Image(getClass().getResourceAsStream("/contacts.png")));
        Node exportNode = new ImageView(new Image(getClass().getResourceAsStream("/export.png")));
        
        TreeItem<String> nodeItemA1 = new TreeItem<>(MENU_LIST, contactsNode);
        TreeItem<String> nodeItemA2 = new TreeItem<>(MENU_EXPORT, exportNode);
        
        nodeItemA.getChildren().addAll(nodeItemA1, nodeItemA2);
        treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB);
        
        menuPane.getChildren().add(treeView);
        
        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TreeItem<String> selectedItem = (TreeItem<String>) newValue;
                String selectedMenu = selectedItem.getValue();
                
                if (null != selectedMenu) {
                    switch (selectedMenu) {
                        case MENU_CONTACTS:
                            try {
                                selectedItem.setExpanded(true);
                            } catch (Exception ex) {}
                            break;
                        case MENU_LIST:
                            contactPane.setVisible(true);
                            exportPane.setVisible(false);
                            break;
                        case MENU_EXPORT:
                            contactPane.setVisible(false);
                            exportPane.setVisible(true);
                            break;    
                        case MENU_EXIT:
                            System.exit(0);
                            break;
                    }
                }
            }
        });
    }
    
    private void alert(String text) {
        mainSplit.setDisable(true);
        mainSplit.setOpacity(0.4);
        
        Label label = new Label(text);
        Button alertButton = new Button ("OK");
        VBox vbox = new VBox(label, alertButton);
        vbox.setAlignment(Pos.CENTER);
        
        alertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                mainSplit.setDisable(false);
                mainSplit.setOpacity(1);
                vbox.setVisible(false);
            }
        });
        
        anchor.getChildren().add(vbox);
        anchor.setTopAnchor(vbox, 300.0);
        anchor.setLeftAnchor(vbox, 300.0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTableData();
        setMenuData();
    }    
}
