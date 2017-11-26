package ingsw.visitor;

import ingsw.composite.core.File;
import ingsw.composite.core.Folder;

public class ItemCounter implements Visitor {

	private int files = 0;
	private int folders = 0;
	
	@Override
	public void visitFile(File file) {
		++files;
	}

	@Override
	public void visitFolder(Folder folder) {
		++folders;
	}
	
	public String getInfo() {
		return "This files structure contains:\n- " + folders + " folders\n" + "- " + files + " files";
	}
}
