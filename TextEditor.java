package texteditor;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
/**
 *
 * @author Harnoor
 */
public class TextEditor extends JFrame {
    /* Choosing the appropriate size of our window */
private JTextArea area = new JTextArea(100,200);
private JFileChooser chooser = new JFileChooser();
private String currentfile = "Untitled";
private boolean changed = false;


/* The below constructor implements the manu bar and the scroll bar */
public TextEditor(){
    area.setFont(new Font("TimesRoman", Font.BOLD,12));
    JScrollPane scrollPanel = new JScrollPane(area);
    add(scrollPanel,BorderLayout.CENTER);
    JMenuBar mybar = new JMenuBar();
    setJMenuBar(mybar);
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    mybar.add(file);
    mybar.add(edit);
    file.add(New);
    file.add("Open");
    file.add("Save");
    file.add("SaveAs");
    file.add("Quit");
    file.addSeparator();
    for(int i=0; i<4; i++)
	file.getItem(i).setIcon(null);
    edit.add(Cut);edit.add(Copy);edit.add(Paste);
    edit.getItem(0).setText("Cut");
    edit.getItem(1).setText("Copy");
    edit.getItem(2).setText("Paste");
    JToolBar tool = new JToolBar();
		add(tool,BorderLayout.NORTH);
		tool.add(New);
                tool.add(Open);
                tool.add(Save);
		tool.addSeparator();
		
		JButton cut = tool.add(Cut), cop = tool.add(Copy),pas = tool.add(Paste);
		
		cut.setText(null); cut.setIcon(new ImageIcon("cut.gif"));
		cop.setText(null); cop.setIcon(new ImageIcon("copy.gif"));
		pas.setText(null); pas.setIcon(new ImageIcon("paste.gif"));
		
		Save.setEnabled(false);
		SaveAs.setEnabled(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		area.addKeyListener(k1);
		setTitle(currentfile);
		setVisible(true);
	}
private KeyListener k1 = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			changed = true;
			Save.setEnabled(true);
			SaveAs.setEnabled(true);
		}
	};
Action Open = new AbstractAction("Open", new ImageIcon("open.gif")) {
		public void actionPerformed(ActionEvent e) {
			saveOld();
			if(dialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				readInFile(dialog.getSelectedFile().getAbsolutePath());
			}
			SaveAs.setEnabled(true);
		}
	};
Action Save = new AbstractAction("Save", new ImageIcon("save.gif")) {
		public void actionPerformed(ActionEvent e) {
			if(!currentFile.equals("Untitled"))
				saveFile(currentFile);
			else
				saveFileAs();
		}
	};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TextEditor texteditor = new TextEditor();
    }
    
}
