package com.interim.gui.view;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.*;

import com.interim.model.Annonces;
import com.interim.model.Contacts;
import com.interim.model.ModelAnnonce;
import com.interim.model.ModelUsers;
import com.interim.model.Users;

public class TableUsers extends JPanel {
        RadioButtonUIU ui = new RadioButtonUIU();
        int pageSize = 5;

        ModelUsers model;
        TableRowSorter sorter;
        Box box = Box.createHorizontalBox();
        JTable table;

		public JTable getTable() {
			return table;
		}

		public TableUsers(List<Users> listUsers) {
                super(new BorderLayout());
                model = new ModelUsers(listUsers);
                sorter = new TableRowSorter(model);
                table = new JTable(model) {
                        public Component prepareRenderer(TableCellRenderer tcr, int row,
                                        int column) {
                                Component c = super.prepareRenderer(tcr, row, column);
                                ((DefaultTableCellRenderer)c).setHorizontalAlignment(SwingConstants.CENTER);
                                if (isRowSelected(row)) {
                                        c.setForeground(getSelectionForeground());
                                        c.setBackground(getSelectionBackground());
                                } else {
                                        c.setForeground(getForeground());
                                        c.setBackground((row % 2 == 0) ? Color.lightGray
                                                        : getBackground());
                                }
                                  
                                return c;
                        }
                };
                
                table.setIntercellSpacing(new Dimension());
                table.setShowGrid(false);
                table.setRowSorter(sorter);
                
                updateRowHeights();
                showPages(10, 1);

                add(new JScrollPane(table));
                add(box, BorderLayout.SOUTH);
                
                setPreferredSize(new Dimension(620, 440));
        }

        private void showPages(final int itemsPerPage, final int currentPageIndex) {
                sorter.setRowFilter(filter(itemsPerPage, currentPageIndex - 1));
                ArrayList<JRadioButton> l = new ArrayList<JRadioButton>();

                int startPageIndex = currentPageIndex - pageSize;
                if (startPageIndex <= 0)
                        startPageIndex = 1;
                int maxPageIndex = (model.getRowCount() / itemsPerPage) + 1;
                int endPageIndex = currentPageIndex + pageSize - 1;
                if (endPageIndex > maxPageIndex)
                        endPageIndex = maxPageIndex;

                if (currentPageIndex > 1)
                        l
                                        .add(createRadioButtons(itemsPerPage, currentPageIndex - 1,
                                                        "Prev"));
                for (int i = startPageIndex; i <= endPageIndex; i++)
                        l.add(createLinks(itemsPerPage, currentPageIndex, i - 1));
                if (currentPageIndex < maxPageIndex)
                        l
                                        .add(createRadioButtons(itemsPerPage, currentPageIndex + 1,
                                                        "Next"));

                box.removeAll();
                ButtonGroup bg = new ButtonGroup();
                box.add(Box.createHorizontalGlue());
                for (JRadioButton r : l) {
                        box.add(r);
                        bg.add(r);
                }
                box.add(Box.createHorizontalGlue());
                box.revalidate();
                box.repaint();
                l.clear();
        }

        private JRadioButton createLinks(final int itemsPerPage, final int current,
                        final int target) {
                JRadioButton radio = new JRadioButton("" + (target + 1)) {
                        protected void fireStateChanged() {
                                ButtonModel model = getModel();
                                if (!model.isEnabled()) {
                                        setForeground(Color.GRAY);
                                } else if (model.isPressed() && model.isArmed()) {
                                        setForeground(Color.GREEN);
                                } else if (model.isSelected()) {
                                        setForeground(Color.RED);
                                }
                                super.fireStateChanged();
                        }
                };
                radio.setForeground(Color.BLUE);
                radio.setUI(ui);
                if (target + 1 == current) {
                        radio.setSelected(true);
                }
                radio.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                showPages(itemsPerPage, target + 1);
                        }
                });
                return radio;
        }

        private JRadioButton createRadioButtons(final int itemsPerPage,
                        final int target, String title) {
                JRadioButton radio = new JRadioButton(title);
                radio.setForeground(Color.BLUE);
                radio.setUI(ui);
                radio.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                showPages(itemsPerPage, target);
                        }
                });
                return radio;
        }

        private RowFilter filter(final int itemsPerPage,
                        final int target) {
                return new RowFilter() {
                        public boolean include(
                                        Entry entry) {
                                int ei = (int) entry.getIdentifier();
                                return (target * itemsPerPage <= ei && ei < target
                                                * itemsPerPage + itemsPerPage);
                        }
                };
        }

     /*   public static void main(String[] args) {
                JFrame frame = new JFrame("Table");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                Contacts contact = new Contacts();
                contact.setAdresse("place du truc 12");
                contact.setCommune("7012 jemappes");
                contact.setContact("Monsieur bobo");
                contact.setEmail("toto@toto.com");
                contact.setEntreprise("entreprise b");
                contact.setTel("0652123689");
                Annonces annonce = new Annonces();
                annonce.setContacts(contact);
                annonce.setDate("25/05/2014");
                annonce.setDescription("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb<br>bbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbb");
                annonce.setFonction("aide menager");
                annonce.setSecteur("menage");
                List<Annonces> annonces = new ArrayList<Annonces>();
                annonces.add(annonce);
                Contacts contact1 = new Contacts();
                contact1.setAdresse("place du truc 12");
                contact1.setCommune("7012 jemappes");
                contact1.setContact("Monsieur bobo");
                contact1.setEmail("toto@toto.com");
                contact1.setEntreprise("entreprise b");
                contact1.setTel("0652123689");
                Annonces annonce1 = new Annonces();
                annonce1.setContacts(contact1);
                annonce1.setDate("24/05/2014");
                annonce1.setDescription("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb<br>bbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmbb");
                annonce1.setFonction("aide menager");
                annonce1.setSecteur("menage");
                annonces.add(annonce1);
                frame.getContentPane().add(new TableAnnonce(annonces));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
        }*/
        
        private void updateRowHeights()
        {
            try
            {
                for (int row = 0; row < table.getRowCount(); row++)
                {
                    int rowHeight = table.getRowHeight();

                    for (int column = 0; column < table.getColumnCount(); column++)
                    {
                        Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                        rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                    }

                    table.setRowHeight(row, rowHeight);
                }
            }
            catch(ClassCastException e) {}
        }
}

class RadioButtonUIU extends BasicRadioButtonUI {
        public Icon getDefaultIcon() {
                return null;
        }

        private static Dimension size = new Dimension();
        private static Rectangle rec1 = new Rectangle();
        private static Rectangle rec2 = new Rectangle();
        private static Rectangle rec3 = new Rectangle();

        public synchronized void paint(Graphics g, JComponent c) {
                AbstractButton b = (AbstractButton) c;
                ButtonModel model = b.getModel();
                Font f = c.getFont();
                g.setFont(f);
                FontMetrics fm = c.getFontMetrics(f);

                Insets i = c.getInsets();
                size = b.getSize(size);
                rec1.x = i.left;
                rec1.y = i.top;
                rec1.width = size.width - (i.right + rec1.x);
                rec1.height = size.height - (i.bottom + rec1.y);
                rec2.x = rec2.y = rec2.width = rec2.height = 0;
                rec3.x = rec3.y = rec3.width = rec3.height = 0;

                String text = SwingUtilities.layoutCompoundLabel(c, fm, b.getText(),
                                null, b.getVerticalAlignment(), b.getHorizontalAlignment(), b
                                                .getVerticalTextPosition(), b
                                                .getHorizontalTextPosition(), rec1, rec2, rec3, 0);

                if (c.isOpaque()) {
                        g.setColor(b.getBackground());
                        g.fillRect(0, 0, size.width, size.height);
                }
                if (text == null)
                        return;
                g.setColor(b.getForeground());
                if (!model.isSelected() && !model.isPressed() && !model.isArmed()
                                && b.isRolloverEnabled() && model.isRollover()) {
                        g.drawLine(rec1.x, rec1.y + rec1.height, rec1.x + rec1.width,
                                        rec1.y + rec1.height);
                }
                View v = (View) c.getClientProperty(BasicHTML.propertyKey);
                if (v != null) {
                        v.paint(g, rec3);
                } else {
                        paintText(g, b, rec3, text);
                }
        }
}

