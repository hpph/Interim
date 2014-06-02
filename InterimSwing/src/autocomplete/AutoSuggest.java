package autocomplete;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class AutoSuggest extends JComboBox{
    private final JTextField tf;
    public JTextField getTf() {
		return tf;
	}
	private ArrayList<String> v;
    public AutoSuggest(ArrayList<String> list) {
    	v = list;
        this.setEditable(true);
        tf = (JTextField) getEditor().getEditorComponent();
        tf.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
         EventQueue.invokeLater(new Runnable() {
            public void run() {
                String text = tf.getText();
                if(text.length()>0) 
                text = text.substring(0, 1).toUpperCase() + text.substring(1);
                if(text.length()==0) {
                    hidePopup();
                    setModel(new DefaultComboBoxModel(v.toArray(new String[v.size()])), "");
                }else{
                    DefaultComboBoxModel m = getSuggestedModel(v, text);
                    if(m.getSize()==0 || hide_flag) {
                          hidePopup();
                        hide_flag = false;
                    }else{
                        setModel(m, text);
                        showPopup();
                    }
                }
            }
        });
     }
     public void keyPressed(KeyEvent e) {
         String text = tf.getText();
         int code = e.getKeyCode();
         if(code==KeyEvent.VK_ENTER) {
         if(!v.contains(text)) {
                v.add(text);
                Collections.sort(v);
                setModel(getSuggestedModel(v, text), text);
            }
            hide_flag = true; 
        }else if(code==KeyEvent.VK_ESCAPE) {
            hide_flag = true; 
        }else if(code==KeyEvent.VK_RIGHT) {
            for(int i=0;i<v.size();i++) {
                String str = v.get(i);
                if(str.startsWith(text)) {
                    setSelectedIndex(-1);
                    tf.setText(str);
                    return;
                }
            }
        }
     }
      });
          
        setModel(new DefaultComboBoxModel<>(v.toArray(new String[v.size()])), "");
        setPreferredSize(new Dimension(100,25));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
    private boolean hide_flag = false;
       private void setModel(DefaultComboBoxModel mdl, String str) {
        setModel(mdl);
        setSelectedIndex(-1);
        tf.setText(str);
    }
private static DefaultComboBoxModel getSuggestedModel(java.util.List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String s: list) {
            if(s.startsWith(text)) m.addElement(s);
        }
        return m;
    }
    public static void main(String[] args) {
    	/*ArrayList<String> list = new ArrayList<String>(Arrays.asList("Afghanistan", "Albania", "Algeria", "Andorra", "Angola","Argentina"
		,"Armenia","Austria","Bahamas","Bahrain", "Bangladesh","Barbados", "Belarus","Belgium",
		"Benin","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","Bulgaria",
		"Burkina Faso","Burma","Burundi","Cambodia","Cameroon","Canada", "China","Colombia",
		"Comoros","Congo","Croatia","Cuba","Cyprus","Czech Republic","Denmark", "Georgia",
		"Germany","Ghana","Great Britain","Greece","Hungary","Holland","India","Iran","Iraq",
		"Italy","Somalia", "Spain", "Sri Lanka", "Sudan","Suriname", "Swaziland","Sweden",
		"Switzerland", "Syria","Uganda","Ukraine","United Arab Emirates","United Kingdom",
		"United States","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam",
		"Yemen","Zaire","Zambia","Zimbabwe"));
        JPanel p = new JPanel(new BorderLayout());
        p.add(new AutoSuggest(list), BorderLayout.NORTH);
        
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(p);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
    }
    }