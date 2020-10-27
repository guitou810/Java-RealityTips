package application;

import javafx.scene.control.Label;

public class SaisieErrorException extends Exception {

	private Label texte;
	
	public SaisieErrorException(Label s) {
		super();
		this.texte = s;
		
	}

	public Label getLabel() {
		return texte;
	}

	public void setLabel(Label texte) {
		this.texte = texte;
	}


}
