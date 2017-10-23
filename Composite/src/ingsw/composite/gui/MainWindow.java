package ingsw.composite.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import ingsw.composite.core.File;
import ingsw.composite.core.FileSystem;
import ingsw.composite.core.Folder;

public class MainWindow extends JPanel implements ActionListener {
   
	private static final long serialVersionUID = 1L;
	private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
    private static String SAVE_COMMAND = "save";
    
    private DynamicTree treePanel;

    public MainWindow() {
        super(new BorderLayout());
        
        //Create the components.
        treePanel = new DynamicTree();

        JButton addButton = new JButton("Add");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);
        
        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);

        JButton saveButton = new JButton("Save");
        saveButton.setActionCommand(SAVE_COMMAND);
        saveButton.addActionListener(this);
        
        //Lay everything out.
        treePanel.setPreferredSize(new Dimension(500, 300));
        add(treePanel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0,4));
        panel.add(addButton);
        panel.add(removeButton); 
        panel.add(clearButton);
        panel.add(saveButton);
	add(panel, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            treePanel.addObject("New Node " + newNodeSuffix++);
        } else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            treePanel.removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            //Clear button clicked.
            treePanel.clear();
        }
        
        else if (SAVE_COMMAND.equals(command)) {
        	java.io.File file = new java.io.File("Files");
    		cleanDirectory(file);
        	FileSystem fs = new Folder(treePanel.rootNode.toString());
        	if(!treePanel.rootNode.isLeaf())
        		createAndSave(treePanel.rootNode, fs);
        	fs.createFileSystem();
        }
    }
    
    private void createAndSave(DefaultMutableTreeNode node, FileSystem fs) {
     	if(node.isLeaf()) {
 			FileSystem file = new File(node.toString() + ".txt");
 			file.writeFile(node.toString());
 			fs.addFile(file);
     	}
     	else {
     		FileSystem folder = null;
     		
     		if(node.toString().equals("root")) {
     			folder = fs;
     		}
     		else {
     			folder = new Folder(node.toString());
     			fs.addFile(folder);
     		}
   
     		for(int i = 0; i < node.getChildCount(); ++i) {
     			createAndSave((DefaultMutableTreeNode)node.getChildAt(i), folder);
     		}
     	}
    	
	}
    
	private static void cleanDirectory(java.io.File file) {

		for (java.io.File childFile : file.listFiles()) {
			if (childFile.isDirectory())
				cleanDirectory(childFile);
			else
				childFile.delete();
		}

		if (!file.getName().equals("Files"))
			file.delete();
	}

	
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Composite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainWindow newContentPane = new MainWindow();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
