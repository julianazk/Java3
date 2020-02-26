package challenge;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class CSVReader {

	private String CSVFile;
    public BufferedReader br = null;
	public String line = "";
    public String CVSSplitter = ",";    

	public CSVReader(String file) {
		this.CSVFile = file;
	}
	
	public List<String> lerArquivo(int col){
		List<String> coluna = new ArrayList<String>();
		
		try {
			br = new BufferedReader(new FileReader(CSVFile));
			while ((line = br.readLine()) != null) {
				String[] registro = line.split(CVSSplitter);
				coluna.add(registro[col]);
			}
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
        coluna.remove(0);
        return coluna;
	}
	
	public List<Jogador> lerArquivo() {
		int contador = 0;
		List<Jogador> jogadores = new ArrayList<Jogador>();
		
		try {
			br = new BufferedReader(new FileReader(CSVFile));
			while ((line = br.readLine()) != null) {
				if (contador > 0) {
	                String[] registro = line.split(CVSSplitter);

	                Jogador jogador = new Jogador();

	                jogador.setId(registro[0]);
	                jogador.setName(registro[1]);
	                jogador.setFullName(registro[2]);
	                jogador.setClub(registro[3]);
	                jogador.setNationality(registro[14]);

	                if(! registro[6].isEmpty()) {
	                	try {
		                	jogador.setAge(Integer.parseInt(registro[6]));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
	                }
                
	                if(! registro[18].isEmpty()) {
		                try {
		                	jogador.setEur(Float.parseFloat(registro[18]));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
	                }
	                
	                if(! registro[17].isEmpty()) {
		                try {
		                	jogador.setEurWage(Float.parseFloat(registro[17]));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
	                }               
	                if(! registro[8].isEmpty()) {
		                try {
							jogador.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(registro[8]));
						} catch (ParseException | java.text.ParseException e) {
							e.printStackTrace();
						}
	                }
	                jogadores.add(jogador);
	            }
            contador ++;
            }
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
        return jogadores;
    }

}
