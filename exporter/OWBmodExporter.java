package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.Scanner;

public class OWBmodExporter {
	private static String CURRENT_DIR = "..";
	private static String MOD_DIR = CURRENT_DIR + "\\OWB";
	private static String EXPORT_DIR = CURRENT_DIR + "\\OWBFrenchTranslation";

	public static void main(String[] args) throws IOException {
		String exportDir = (args.length > 0) ? args[0] : EXPORT_DIR;
		// Delete export directory
		Path path = new File(exportDir).toPath();
		try {
			Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		} catch (Exception e) {
		}

		// Create export directory
		createDir(exportDir);

		// Read files to export
		FileInputStream f = null;
		try {
			f = new FileInputStream(CURRENT_DIR + "\\files_to_export.txt");
			@SuppressWarnings("resource")
			Scanner line = new Scanner(f);
			line.useDelimiter("[\n\r]");
			while (line.hasNext()) {
				String sLine = line.next();
				if ("".equals(sLine)) {
					continue;
				}
				if (sLine.endsWith("\\")) {
					copyDirectory(sLine, exportDir);
				} else {
					copyFile(sLine, exportDir);
				}
			}

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (f != null)
					f.close();
			} catch (IOException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}
	}

	private static void createDir(String dir)
	{
		if (!new File(dir).exists()) {
			if (!new File(dir).mkdir()) {
				throw new RuntimeException("directory not created!");
			}
		}
	}
	
	private static void copyFile(String fileName, String exportDir) throws IOException {
		String[] dirs = fileName.split("\\\\");
		if (dirs.length > 1)
		{
			String dirName = "";
			for (int i = 0; i < dirs.length - 1; i++ )
			{
				dirName += dirs[i];
				createDir(exportDir + "\\" + dirName);
				dirName += "\\";
			}			
		}
		Files.copy(new File(MOD_DIR + "\\" + fileName).toPath(), new File(exportDir + "\\" + fileName).toPath(),
				StandardCopyOption.REPLACE_EXISTING);
	}

	private static void copyDirectory(String directoryName, String exportDir) throws IOException {
		File dir = new File(MOD_DIR + "\\" + directoryName);
		createDir(exportDir + "\\" + directoryName);
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				copyDirectory(directoryName + "\\" + file.getName() + "\\", exportDir);
			} else {
				copyFile(directoryName + file.getName(), exportDir);
			}
		}
	}
}
