package ingsw.composite.core;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Folder extends FileSystem {

	String fileName;
	Map<String, FileSystem> children;
	
	public Folder(String fileName) {
		this.fileName = fileName;
		this.children = new HashMap<>();
		this.path = "Files/" + this.fileName;
	}
	
	@Override
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public void addFile(FileSystem file) {
		file.path = this.path + "/" + file.getFileName();
		children.put(file.getFileName(), file);
		if(file.getChildren() != null)
			addPath(file);
		
	//	System.out.println("------------------------------------------------------------------------" + file.path);
	}
	
	private void addPath(FileSystem file) {

	//	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + file.path);
		
		for(FileSystem fileSystem : file.getChildren().values()) {
			if(fileSystem.getChildren() != null) {
				fileSystem.path = file.path + "/" + fileSystem.getFileName();
				addPath(fileSystem);
			}
			else  {
				fileSystem.path = file.path + "/" + fileSystem.getFileName();
			}
		}
	}
	
	@Override
	public void removeFile(String fileName) {
		children.remove(fileName);		
	}
	
	@Override
	public Map<String, FileSystem> getChildren() {
		return this.children;
	}
	
	@Override
	public void createFileSystem() {
		
		java.io.File file = new java.io.File(this.path);
		try {
			Files.createDirectory(file.toPath());
			System.out.println("Folder: " + this.path + " Created!");
			
			System.out.println("\\\\ START \\\\ " + this.fileName + " " + this.path + "\n\n");
			for(FileSystem fileSystem : children.values())
				fileSystem.createFileSystem();
			System.out.println("\\\\ END \\\\ " + this.fileName + "\n\n");
		} catch (IOException e) {
			throw new RuntimeException("Folder " + this.fileName + " was placed in another path");
		}
		
	}
}
