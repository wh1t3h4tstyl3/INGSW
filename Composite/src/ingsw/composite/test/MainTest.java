package ingsw.composite.test;

import ingsw.composite.core.File;
import ingsw.composite.core.FileSystem;
import ingsw.composite.core.Folder;
import ingsw.visitor.ItemCounter;

public class MainTest {

	private static void cleanDirectory(java.io.File file) {
		
		for(java.io.File childFile : file.listFiles()) {
			if(childFile.isDirectory())
				cleanDirectory(childFile);
			else
				childFile.delete();
		}
		
		if(!file.getName().equals("Files")) file.delete();
	}
	
	public static void main(String[] args) {
		
		java.io.File file = new java.io.File("Files");
		cleanDirectory(file);
			
		
		// ROOT FOLDER
		FileSystem folderRoot = new Folder("root");
		
		FileSystem fileLevel1_1 = new File("1.txt");
		fileLevel1_1.writeFile("I'm FILE ONE on FIRST level");
		FileSystem fileLevel1_2 = new File("2.txt");
		fileLevel1_2.writeFile("I'm FILE TWO on FIRST level");
		
		// FOLDER ON FIRST LEVEL
		FileSystem folderLevel1_1 = new Folder("Folder_L1_N1");
		
		FileSystem fileLevel2_1 = new File("3.txt");
		fileLevel2_1.writeFile("I'm FILE THREE on SECOND level");
		FileSystem fileLevel2_2 = new File("4.txt");
		fileLevel2_2.writeFile("I'm FILE FOUR on SECOND level");
		
		// FOLDER ON SECOND LEVEL
		FileSystem folderLevel2_1 = new Folder("Folder_L2_N1");
		
		FileSystem fileLevel3_1 = new File("5.txt");
		fileLevel3_1.writeFile("I'm FILE FIVE on THIRD level");
		FileSystem fileLevel3_2 = new File("6.txt");
		fileLevel3_2.writeFile("I'm FILE SIX on THIRD level");
		
		folderLevel2_1.addFile(fileLevel3_1);
		folderLevel2_1.addFile(fileLevel3_2);
		
		folderLevel1_1.addFile(fileLevel2_1);
		folderLevel1_1.addFile(fileLevel2_2);
		folderLevel1_1.addFile(folderLevel2_1);
		
		folderRoot.addFile(folderLevel1_1);
		folderRoot.addFile(fileLevel1_1);
		folderRoot.addFile(fileLevel1_2);
		
		FileSystem folderLevel1_2 = new Folder("Folder_L1_N2");
		FileSystem fileLevel2_3 = new File("7.txt");
		fileLevel2_3.writeFile("I'm FILE SEVEN on SECOND level");
		folderLevel1_2.addFile(fileLevel2_3);
		folderRoot.addFile(folderLevel1_2);
		
		//folderRoot.removeFile("Folder_L1_N1");
		folderRoot.createFileSystem();
		
		ItemCounter itemCounter  = new ItemCounter();
		folderRoot.accept(itemCounter);
		System.out.println(itemCounter.getInfo());
	}
}
