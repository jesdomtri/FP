package util;

import java.util.*;
import java.io.*;

public class Utiles {

	public static List<String> leeFichero(String fileName) {
		List<String> listaleida = new LinkedList<String>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		while (sc.hasNextLine()) {
			listaleida.add(sc.nextLine());
		}
		sc.close();
		return listaleida;
	}

	public static List<String> separaElementos(String s, String del) {
		List<String> ls = new LinkedList<String>();
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(s).useDelimiter("\\s*" + del + "\\s*");
		while (sc1.hasNext()) {
			ls.add(sc1.next());
		}
		return ls;
	}

	public static <T> void escribeFichero(Collection<T> it, String filename) {
		File file = new File(filename);
		try {
			PrintWriter ps = new PrintWriter(file);
			for (T elem : it) {
				ps.println(elem);
			}
			ps.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado " + filename);
		}
	}

	public static <K, T> SortedMap<K, List<T>> invierteMap(Map<T, K> m) {
		SortedMap<K, List<T>> mapinv = new TreeMap<>();
		Set<T> conj = m.keySet();
		for (T ti : conj) {
			K ki = m.get(ti);
			List<T> lis;
			if (mapinv.containsKey(ki)) {
				lis = mapinv.get(ki);
			} else {
				lis = new ArrayList<T>();
			}
			lis.add(ti);
			mapinv.put(ki, lis);
		}
		return mapinv;
	}
}
