package ingsw.visitor;

import ingsw.composite.core.File;
import ingsw.composite.core.Folder;

public interface Visitor {
	public void visitFile(File file);
	public void visitFolder(Folder folder);
}
