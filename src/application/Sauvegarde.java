package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class Sauvegarde {

	private LocalDate date;
	private HashMap<String, String> map;
	private File file = new File ("historique.txt");
	private ChampSaisi champ;
	
	public Sauvegarde(ChampSaisi ch, LocalDate dt, HashMap<String, String> hmap) {
		super();
		this.date = dt;
		this.map = hmap;
		this.champ = ch;
	}
	
	
	
	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public HashMap<String, String> getMap() {
		return map;
	}



	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}


	public void initialMap() throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] tab = line.split(";");
			map.put(tab[0],tab[1]+';'+tab[2]+';'+tab[3]);
		}
		br.close();
	}
	
	public void Savecalcul() throws IOException {
		try {
		//fichier existant ou pas
		if(!file.exists()) {
			file.createNewFile();
		}
		
		//fichier non vide
		if (file.length() > 1) {
			this.initialMap();
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if (map.containsKey(this.date.toString())) {
			}else {
				bw.write(this.date + ";" + this.champ.toString());
				bw.close();
			}
		}// Fichier vide 
		else {
			FileWriter fw2 = new FileWriter(file,true);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write(this.date + ";" + this.champ.toString());
			bw2.close();
		}
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	

}
