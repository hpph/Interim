package com.interim.gui.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JHTMLEditor;
import chrriis.dj.nativeswing.swtimpl.components.JHTMLEditor.HTMLEditorImplementation;

public class ContactSuperviseur extends JPanel {
	private JTextField fieldSujet;
	private JHTMLEditor htmlEditor;
	private JPanel panel_1;
	private JButton btnEnvoyer;
	
	public JTextField getFieldSujet() {
		return fieldSujet;
	}

	public JHTMLEditor getHtmlEditor() {
		return htmlEditor;
	}

	public JButton getBtnEnvoyer() {
		return btnEnvoyer;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	/**
	 * Create the panel.
	 */
	public ContactSuperviseur() {
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 33;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		setLayout(new BorderLayout(0, 0));
		add(panel,BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSujet = new JLabel("Sujet :");
		GridBagConstraints gbc_lblSujet = new GridBagConstraints();
		gbc_lblSujet.insets = new Insets(0, 0, 5, 5);
		gbc_lblSujet.gridx = 0;
		gbc_lblSujet.gridy = 0;
		panel.add(lblSujet, gbc_lblSujet);
		
		fieldSujet = new JTextField();
		GridBagConstraints gbc_fieldSujet = new GridBagConstraints();
		gbc_fieldSujet.gridwidth = 6;
		gbc_fieldSujet.insets = new Insets(0, 0, 5, 5);
		gbc_fieldSujet.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldSujet.gridx = 0;
		gbc_fieldSujet.gridy = 1;
		panel.add(fieldSujet, gbc_fieldSujet);
		fieldSujet.setColumns(10);
		
		btnEnvoyer = new JButton("Envoyer");
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnvoyer.gridx = 14;
		gbc_btnEnvoyer.gridy = 1;
		panel.add(btnEnvoyer, gbc_btnEnvoyer);
		
		 UIUtils.setPreferredLookAndFeel();
	   	    NativeInterface.open();
	   	    final String configurationScript =
	   	      "FCKConfig.ToolbarSets[\"Default\"] = [\n" +
	   	      "[&apos;Source&apos;,&apos;DocProps&apos;,&apos;-&apos;,&apos;Save&apos;,&apos;NewPage&apos;,&apos;Preview&apos;,&apos;-&apos;,&apos;Templates&apos;],\n" +
	   	      "[&apos;Cut&apos;,&apos;Copy&apos;,&apos;Paste&apos;,&apos;PasteText&apos;,&apos;PasteWord&apos;,&apos;-&apos;,&apos;Print&apos;,&apos;SpellCheck&apos;],\n" +
	   	      "[&apos;Undo&apos;,&apos;Redo&apos;,&apos;-&apos;,&apos;Find&apos;,&apos;Replace&apos;,&apos;-&apos;,&apos;SelectAll&apos;,&apos;RemoveFormat&apos;],\n" +
	   	      "[&apos;Form&apos;,&apos;Checkbox&apos;,&apos;Radio&apos;,&apos;TextField&apos;,&apos;Textarea&apos;,&apos;Select&apos;,&apos;Button&apos;,&apos;ImageButton&apos;,&apos;HiddenField&apos;],\n" +
	   	      "&apos;/&apos;,\n" +
	   	      "[&apos;Style&apos;,&apos;FontFormat&apos;,&apos;FontName&apos;,&apos;FontSize&apos;],\n" +
	   	      "[&apos;TextColor&apos;,&apos;BGColor&apos;],\n" +
	   	      "&apos;/&apos;,\n" +
	   	      "[&apos;Bold&apos;,&apos;Italic&apos;,&apos;Underline&apos;,&apos;StrikeThrough&apos;,&apos;-&apos;,&apos;Subscript&apos;,&apos;Superscript&apos;],\n" +
	   	      "[&apos;OrderedList&apos;,&apos;UnorderedList&apos;,&apos;-&apos;,&apos;Outdent&apos;,&apos;Indent&apos;,&apos;Blockquote&apos;],\n" +
	   	      "[&apos;JustifyLeft&apos;,&apos;JustifyCenter&apos;,&apos;JustifyRight&apos;,&apos;JustifyFull&apos;],\n" +
	   	      "[&apos;Link&apos;,&apos;Unlink&apos;,&apos;Anchor&apos;],\n" +
	   	      "[&apos;Image&apos;,&apos;Flash&apos;,&apos;Table&apos;,&apos;Rule&apos;,&apos;Smiley&apos;,&apos;SpecialChar&apos;,&apos;PageBreak&apos;, &apos;-&apos;, &apos;ShowBlocks&apos;],\n" +
	   	      "];\n" +
	   	      "FCKConfig.ToolbarCanCollapse = false;\n";
	   	    
	   	   
			htmlEditor = new JHTMLEditor(HTMLEditorImplementation.FCKEditor,
			JHTMLEditor.FCKEditorOptions.setCustomJavascriptConfiguration(configurationScript));

		       
         setSize(1100, 700);
         setLocation(200, 200);
         setVisible(true);
			add(htmlEditor,BorderLayout.CENTER);
		
	/*	JScrollPane scrollpane = new JScrollPane();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 18;
		gbc_textArea.gridwidth = 34;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 2;
		panel.add(scrollpane, gbc_textArea);
		
		JTextArea textArea = new JTextArea();
		scrollpane.setViewportView(textArea);
*/
		

	}
	
	public static void main(String[] args) {
		

		
	  /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          
        Contact app = new Contact();
		
    	
    	JFrame frame = new JFrame("Main Window");
            frame.getRootPane().setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

            frame.getContentPane().add(app);

            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.setLocation(200, 200);
            frame.setVisible(true);
			
		
            }});
        */
	
	}

}
