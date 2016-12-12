package fr.dao.specifique;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import fr.dao.PizzaDaoFactory;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class PizzaDaoFichier implements PizzaDaoFactory {
	private File file = new File("PizzaFiles");
	private List<Pizza> pizzas = new ArrayList<Pizza>();

	@Override
	public List<Pizza> findall() {
		List<String> codeList = listCodesPizza();
		Collection<String> t = new ArrayList<String>();
		codeList.stream().forEach(codeFile -> t.add(readFile(codeFile)));

		/* INSERTION de la liste dans un tableau mieux manipulable */
		String[] y = t.toArray(new String[0]);
		int i = 0;
		for (String string : y) {
			String str[] = string.split(";");
			Pizza pizza = new Pizza(codeList.get(i), str[0], CategoriePizza.valueOf(str[2]),
					Double.parseDouble(str[1]));
			pizzas.add(pizza);
			i++;
		}
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(file + "/" + newPizza.getCode() + ".txt");
			bw = new BufferedWriter(fw);
			bw.write(newPizza.getNom() + ";" + newPizza.getPrix() + ";" + newPizza.getCatPizza());
			bw.close();
		}
		catch (IOException e){
			throw new SavePizzaException(e);
		}

	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		List<String> codeList = listCodesPizza();
		if (codeList.stream().filter(p -> p.equals(pizzaToDelete)).findFirst().isPresent()) {
			try{
				File f = new File(file + "/" + pizzaToDelete + ".txt");
				f.delete();
			} catch (Exception e) {
				throw new DeletePizzaException(e);
			}
		}

	}

	@Override
	public void update(Pizza pizzaUpdate, String oldCode) throws UpdatesPizzaException{
		try {
			PizzaDaoFichier f = new PizzaDaoFichier();
			f.delete(oldCode);
			f.save(pizzaUpdate); 
		} catch (DeletePizzaException e) {
			throw new UpdatesPizzaException(e);
		} catch (SavePizzaException e) {
			throw new UpdatesPizzaException(e);
		}

	}

	// ********************************************************//
	/**
	 ** Liste la liste nom des fichiers <Pizza > au sein du dossier PizzaFiles **
	 * 
	 * @return Liste des fichiers
	 */
	private List<String> listCodesPizza() {
		String[] paths = file.list();
		List<String> stringList = new ArrayList<String>(Arrays.asList(paths));
		return stringList;
	}

	private String readFile(String codeFile) {
		String fileName = "PizzaFiles/" + codeFile;
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			ArrayList<String> t = new ArrayList<String>();
			stream.forEach(a -> t.add(a));
			return t.get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
