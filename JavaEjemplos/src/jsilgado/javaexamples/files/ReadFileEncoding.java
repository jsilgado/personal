package jsilgado.javaexamples.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class ReadFileEncoding {

	private static final String FILE = "ReadFileEncoding.txt";
	private static final String PATH = Paths.get("").toAbsolutePath().toString()
			+ "\\src\\jsilgado\\javaexamples\\files\\";
	private static final String UTF_8 = "UTF-8";
	private static final String ISO_8859_1 = "ISO-8859-1";

	public static void main(String args[]) {

		/* Obtenemos el fichero */
		Path file = Paths.get(PATH, FILE);

		try {
			/*
			 * Leemos todas las líneas del mismo en con encoding ISO_8859_1 y
			 * mostramos la información por pantalla
			 */
			Charset charsetISO88591 = Charset.forName(ISO_8859_1);

			System.out.println("\nLeyendo el fichero con encoding "
					+ ISO_8859_1 + "\n");
			List<String> linesISO88591 = Files.readAllLines(file,
					charsetISO88591);

			for (String lineISO88591 : linesISO88591) {
				System.out.println(lineISO88591);
			}

			/* Análogo al punto anterior, con encoding UTF_8 */
			Charset charsetUTF8 = Charset.forName(UTF_8);
			System.out.println("\nLeyendo el fichero con encoding " + UTF_8
					+ "....\n");

			List<String> linesUTF8 = Files.readAllLines(file, charsetUTF8);

			for (String lineUTF8 : linesUTF8) {
				System.out.println(lineUTF8);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
