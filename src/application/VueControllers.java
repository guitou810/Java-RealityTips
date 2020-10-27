package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class VueControllers {
	
	private String bill;
	private String tip;
	private String nbPeople;
	private int rel;
	private int rel2;
	private boolean BoolBill;
	private boolean BoolTip;
	private boolean BoolNb;
	private LocalDate TextDate;
	
	@FXML
	private Button BtnCalcul;
	
	@FXML
	private Label Bill;
	
	@FXML
	private Label Tip;
	
	@FXML
	private Label NbPeople;
	
	@FXML
	private Label TipPerson;
	
	@FXML
	private Label TotalPerson;
	
	@FXML
	private Label ErrorSaisiBill;
	
	@FXML
	private Label ErrorSaisiTip;
	
	@FXML
	private Label ErrorSaisiNb;
	
	@FXML
	private TextField TextTip;
	
	@FXML
	private TextField TextBill;

	@FXML
	private TextField TextNbPeople;
	
	@FXML
	private TextField TextTipPerson;
	
	@FXML
	private TextField TextTotalPerson;
	
	@FXML
	private DatePicker Date;
	
	@FXML
	private Label ErrorDate;
	
	public void isNumeric(String str1,TextField txt, Label la)  throws SaisieErrorException{
		try {
			double d = Double.parseDouble(str1);
		}catch(NumberFormatException e3) {
			throw new SaisieErrorException(la);
		}
		la.setText("");
	}
	
	public void isDate (LocalDate Ldt, DatePicker dt) throws NullPointerException {
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			formater.format(Ldt);
	}
	
	public void calcul(ActionEvent e) {
		
		bill = TextBill.getText();
		tip = TextTip.getText();
		nbPeople = TextNbPeople.getText();
		TextDate = Date.getValue();
		
		try {
			isNumeric(bill,TextBill,ErrorSaisiBill);
			isNumeric(tip,TextTip,ErrorSaisiTip);
			isNumeric(nbPeople,TextNbPeople,ErrorSaisiNb);
			isDate(TextDate,Date);
			rel = Integer.parseInt(bill)/Integer.parseInt(nbPeople);
			rel2 = (rel*Integer.parseInt(tip))/100;	
			TextTipPerson.setText(String.valueOf(rel2));
			TextTotalPerson.setText(String.valueOf(rel));
			
		}catch (SaisieErrorException e2) {
			e2.getLabel().setText("Saisir un numéro");
		}catch (NullPointerException e3) {
			ErrorDate.setText("Champ date vide");
		}
	}
	public void Savecalcul() {
		// enregistrer dans un fichier texte
	}
	
	
	
}
