package ingsw.composite.core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ingsw.visitor.Visitor;

public class File extends FileSystem {

	private String fileName;
	private String fileContent;
	
	public File(String fileName) {
		this.fileName = fileName;
		this.path = "Files/" + this.fileName;
	}
	
	public String getFileContent() {
		return fileContent;
	}
	
	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public void writeFile(String fileContent) {
		this.fileContent = fileContent;
	}
	
	@Override
	public Map<String, FileSystem> getChildren() {
		return null;
	}
	
	@Override
	public void createFileSystem() {
		System.out.println("\\\\ START \\\\ " + fileName + " " + this.path + "\n\n" + fileContent);
		java.io.File file = new java.io.File(this.path);
		
		List<String> lines = Arrays.asList(this.fileContent);
		
		try {
			Files.write(file.toPath(), lines, Charset.forName("UTF-8"), StandardOpenOption.CREATE);
			System.out.println("File: " + this.fileName + " Created" + "\n\n\\\\ END \\\\ "+ fileName + "\n\n");
		} catch (IOException e) {
			throw new RuntimeException("File " + this.fileName + " was placed in another path");
		}
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitFile(this);
	}
}
