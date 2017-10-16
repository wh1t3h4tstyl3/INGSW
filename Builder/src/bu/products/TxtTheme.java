package bu.products;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxtTheme {

	private String title;
	private ArrayList<String> contentsNames;
	private ArrayList<Color> contentsColors;
	
	public TxtTheme() {
		title = "TITOLO";
		contentsNames = new ArrayList<>();
		contentsColors = new ArrayList<>();
	}
	
	public void setTitle(String title) {
		if(this.title.equals("TITOLO")) this.title = title;
		else this.title = title + " by " + this.title;
	}
	
	public void addContent(String content, String color) {
		contentsNames.add(content);
		contentsColors.add(Color.decode(color));
	}
	
	public void save(File file) throws IOException {
		String body = "";
		for (int i = 0; i < contentsNames.size(); i++) {
			body += contentsNames.get(i) + " -> R:" + contentsColors.get(i).getRed() + 
					" G:" + contentsColors.get(i).getGreen() + " B:" + contentsColors.get(i).getBlue() + "\n";
		}
		List<String> lines = Arrays.asList(title+"\n", body);
		Files.write(file.toPath(), lines, Charset.forName("UTF-8"), StandardOpenOption.CREATE);
	}
}
