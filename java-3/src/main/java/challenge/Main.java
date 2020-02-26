package challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

import challenge.Jogador;
import challenge.CSVReader;

public class Main {
	
	CSVReader reader = new CSVReader("/home/juliana/codenation/java-3/src/main/resources/data.csv");
	List<Jogador> jogadores = reader.lerArquivo();	
	
	// Quantas nacionalidades (coluna `nationality`14) diferentes existem no arquivo?
	public int q1() {
		Set<String> nacionalidade = jogadores.stream()
				.map(x->x.getNationality())
				.collect(Collectors.toSet());

		return nacionalidade.size();

	}

	// Quantos clubes (coluna `club`3) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		Set<String> clubes = jogadores.stream()
				.map(x-> x.getClub())
				.collect(Collectors.toSet());
		return clubes.size();
	}

	// Liste o nome completo (coluna `full_name`2) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<String> top20 = jogadores.stream()
				.map(x-> x.getFullName())
				.collect(Collectors.toList());
		return top20.subList(0,20);
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name`2 e `eur_release_clause`18)
	public List<String> q4() {
		List<Jogador> jogOrdenados = jogadores.stream()
				.sorted(Comparator.comparing((Jogador jogador) -> jogador.getEur()).reversed())
				.collect(Collectors.toList());
		
		List<String> top10Rescisao = new ArrayList<String>();
		
		for (int i=0;i<10;i++) {
			top10Rescisao.add(jogOrdenados.get(i).getFullName());
		}
		return top10Rescisao;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`19)?
	// (utilize as colunas `full_name`2 e `birth_date`8)
	public List<String> q5() {
		List<Jogador> jogOrdenados = jogadores.stream()
				.sorted(Comparator.comparing((Jogador jogador) -> jogador.getBirthDate()))
				.collect(Collectors.toList());
		
		List<String> top10Idade = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			top10Idade.add(jogOrdenados.get(i).getFullName());
		}
		return top10Idade;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`6)
	public Map<Integer, Integer> q6() {
		List<Integer> jogadoresPorIdade = jogadores.stream()
				.map(x -> x.getAge())
				.collect(Collectors.toList());
		
		Map<Integer, Long> mapaIdades = jogadoresPorIdade.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Map<Integer, Integer> mapaIdadesAtual = mapaIdades.entrySet().stream()
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().intValue()));
		
		return mapaIdadesAtual;
	}

}
