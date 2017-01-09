import java.io.File;
import java.io.FilenameFilter;

public class FindCertainExtension {

	private static final String FILE_DIR = "D:\\archivosftp\\captacionesweb\\pdf\\";
	private static final String FILE_TEXT_EXT = ".expired";

	public static void main(String args[]) {
		new FindCertainExtension().listFile(FILE_DIR, FILE_TEXT_EXT);
	}

	public void listFile(String folder, String ext) {

		GenericExtFilter filter = new GenericExtFilter(ext);

		File dir = new File(folder);

		if(dir.isDirectory()==false){
			System.out.println("Directory does not exists : " + FILE_DIR);
			return;
		}

		// list out all the file name and filter by the extension
		String[] list = dir.list(filter);

		if (list.length == 0) {
			System.out.println("no files end with : " + ext);
			return;
		}

		for (String file : list) {
			String temp = new StringBuffer(FILE_DIR).append(File.separator)
					.append(file).toString();
			System.out.println("file : " + temp);
			System.out.println("fecha : " + extraerFecha(file));
			System.out.println("ip : " + extraerIP(file));
		}
	}

	// inner class, generic extension filter
	public class GenericExtFilter implements FilenameFilter {

		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		@Override
		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}
	
	private String extraerFecha(String nombreArchivo) {
		return nombreArchivo.substring(0, 8);
	}
	
	private String extraerIP(String nombreArchivo) {
		String[] ip = nombreArchivo.split("_");		
		return ip[1];
	}
}