package ingsw.composite.core;

import java.util.Map;

public abstract class FileSystem {
	
	protected String path;
	
	public abstract String getFileName();
	
	public void writeFile(String fileContent) {
		throw new UnsupportedOperationException("Operation is not supported by this class");
	}
	
	public void addFile(FileSystem file) {
		throw new UnsupportedOperationException("Operation is not supported by this class");
	}
	
	public void removeFile(String fileName) {
		throw new UnsupportedOperationException("Operation is not supported by this class");
	}
	
	public abstract Map<String, FileSystem> getChildren();
	
	public abstract void createFileSystem();
}
