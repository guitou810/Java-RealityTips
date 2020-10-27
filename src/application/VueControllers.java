package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VueControllers {
	
	private String bill;
	private String tip;
	private String nbPeople;
	private int intbill;
	private int intTip;
	private int intnbPeople;
	private LocalDate TextDate;
	private LocalDate dateNow;
	private HashMap<String, String> hmap = new HashMap<String, String>();
	private File file = new File ("historique.txt");
	private ChampSaisi Cs;
	private Sauvegarde Sv;
	
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
	
	@FXML
	private Label ErrorH;
	

	public void init() throws IOException {
		Cs = new ChampSaisi(intbill,intnbPeople,intTip);
		Sv =  new Sauvegarde(Cs,dateNow,hmap);
	}
	
	//Vérifier le format des champs Bill|Tip|NbPeople
	public void isNumeric(String str1,TextField txt, Label la)  throws SaisieErrorException{
		try {
			double d = Double.parseDouble(str1);
		}catch(NumberFormatException e3) {
			throw new SaisieErrorException(la);
		}
		la.setText("");
	}
	
	// Vérifier le format de la date
	public LocalDate isDate (LocalDate Ldt, DatePicker dt) throws NullPointerException {
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			formater.format(Ldt);
			return Ldt;
	}
	
	// Caluler les resultat total|Tip par personne
	public void calcul(ActionEvent e) throws IOException {
		init();
		bill = TextBill.getText();
		tip = TextTip.getText();
		nbPeople = TextNbPeople.getText();
		TextDate = Date.getValue();
		
		Cs.setTextbill(Integer.parseInt(bill));
		Cs.setTextTip(Integer.parseInt(tip));
		Cs.setTextnbPeople(Integer.parseInt(nbPeople));
		
		try {
			isNumeric(bill,TextBill,ErrorSaisiBill);
			isNumeric(tip,TextTip,ErrorSaisiTip);
			isNumeric(nbPeople,TextNbPeople,ErrorSaisiNb);
			Sv.setDate(isDate(TextDate,Date));
			TextTipPerson.setText(Cs.calcultip());
			TextTotalPerson.setText(Cs.calcultotal());
			Sv.Savecalcul();
		}catch (SaisieErrorException e2) {
			e2.getLabel().setText("Saisir un numéro");
		}catch (NullPointerException e3) {
			ErrorDate.setText("Date existant ou incorrecte");
		}
	}
	
	// Remplir les champs Bill|Tip|NbPeople si la date existe déjà
	public void initializeDate(ActionEvent e) throws IOException {
		init();
		TextDate = Date.getValue();
		String val = Sv.getMap().get(TextDate.toString());
		if (val != null) {
			String[] tabH = val.split(";");
			TextBill.setText(tabH[0]);
			TextTip.setText(tabH[1]);
			TextNbPeople.setText(tabH[2]);
			ErrorH.setText("Date présente dans l'historique");
		}else {
			TextBill.setText("");
			TextTip.setText("");
			TextNbPeople.setText("");
			ErrorH.setText("Date non présente dans l'historique");
		}
	}	
	
}
