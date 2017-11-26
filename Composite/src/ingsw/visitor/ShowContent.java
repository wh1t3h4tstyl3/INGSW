package ingsw.visitor;

import ingsw.composite.core.File;
import ingsw.composite.core.Folder;

public class ShowContent implements Visitor {

	private String content;
	
	public ShowContent() {
		content = "";
	}
	
	@Override
	public void visitFile(File file) {
		content += "\n----------------------------\nfile named > " + file.getFileName() + "\nContent >\n" + 
				file.getFileContent() + "\n----------------------------\n";
	}

	@Override
	public void visitFolder(Folder folder) {
		content += "\n*****************************\nfolder named > " + folder.getFileName() + "\n****************************\n";
	}
	
	public String getContent() {
		return content;
	}

}
