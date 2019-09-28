package liu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import static liu.FinalProject.Play;

/**
 * the GUI class
 *
 * @author 958022184
 */
public class Interface extends JFrame {

    private JToggleButton tbtnCreate;
    private JButton btnSave;
    private JButton btnDelete;
    private JButton btnPlay;
    private JTextField txtName;
    private JTextField txtSong;
    private JComboBox cmboNames;
    private JLabel lblCount;
    private JButton one, two, three, four, five, six, seven, eight, zero, backSpace;
    private SongCollection myThing;
    private boolean isCreating = false;

    public Interface(String title) {
        super(title);
        myThing = new SongCollection();
        addComponents();
        addEventHandlers();
        initializeDisplay();
    }

    private void initializeDisplay() {
        if (cmboNames.getItemCount() > 0) {
            cmboNames.setSelectedIndex(0);
        }
        txtSong.setFocusable(false);
    }

    public void addComponents() {

        //North Panel
        JPanel pnlNorth = new JPanel();
        cmboNames = new JComboBox(myThing.getSortedArray());
        pnlNorth.add(cmboNames);
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));

        //Name Panel
        JPanel pnlName = new JPanel();
        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField(25);
        pnlName.add(lblName);
        pnlName.add(txtName);
        pnlNorth.add(pnlName);

        //Song Panel
        JPanel pnlSong = new JPanel();
        JLabel lblSong = new JLabel("Song:");
        txtSong = new JTextField(25);
        pnlSong.add(lblSong);
        pnlSong.add(txtSong);
        pnlNorth.add(pnlSong);
        this.add(pnlNorth, BorderLayout.NORTH);

        //Center Panel
        JPanel pnlCenter = new JPanel();
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        zero = new JButton("0");
        backSpace = new JButton("←");
        pnlCenter.setLayout(new GridLayout(4, 3));
        pnlCenter.add(one);
        pnlCenter.add(two);
        pnlCenter.add(three);
        pnlCenter.add(four);
        pnlCenter.add(five);
        pnlCenter.add(six);
        pnlCenter.add(seven);
        pnlCenter.add(eight);
        pnlCenter.add(zero);
        pnlCenter.add(backSpace);
        pnlCenter.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(pnlCenter, BorderLayout.CENTER);
        lblCount = new JLabel("# of Songs: " + String.valueOf(myThing.songCount()));
        lblCount.setBorder(BorderFactory.createLineBorder(Color.black));
        lblCount.setOpaque(true);
        lblCount.setBackground(Color.lightGray);
        lblCount.setHorizontalAlignment(JLabel.CENTER);
        pnlCenter.add(lblCount);
//        JLabel lblCount2 = new JLabel(String.valueOf(myThing.songCount()));
//        lblCount2.setBorder(BorderFactory.createLineBorder(Color.black));
//        lblCount2.setOpaque(true);
//        lblCount2.setBackground(Color.lightGray);
//        pnlCenter.add(lblCount2);


        //South Panel
        JPanel pnlSouth = new JPanel();
        tbtnCreate = new JToggleButton("Create Mode");
        btnSave = new JButton("Save");
        btnDelete = new JButton("Delete");
        btnPlay = new JButton("Play ►");
        pnlSouth.add(tbtnCreate);
        pnlSouth.add(btnSave);
        pnlSouth.add(btnDelete);
        pnlSouth.add(btnPlay);
        this.add(pnlSouth, BorderLayout.SOUTH);

        JPanel pnlWest = new JPanel();
        pnlWest.add(Box.createRigidArea(new Dimension(50, 0)));
        this.add(pnlWest, BorderLayout.WEST);
        JPanel pnlEast = new JPanel();
        pnlEast.add(Box.createRigidArea(new Dimension(50, 0)));
        this.add(pnlEast, BorderLayout.EAST);
        
    }

    public void addEventHandlers() {

        tbtnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbtnCreate.isSelected()) {
                    txtName.setText("");
                    txtSong.setText("");
                    isCreating = true;
                }
                //Song c = (Song) cmboNames.getSelectedItem();

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myThing.songCount() > 1) {
                    Song c = (Song) cmboNames.getSelectedItem();
                    myThing.deleteSong(c);
                    cmboNames.setSelectedIndex(0);
                    c = (Song) myThing.songList.get(0);
                    txtName.setText(c.getName());
                    txtSong.setText(c.getContent());
                    cmboNames.setModel(new DefaultComboBoxModel(myThing.getSortedArray()));
                } else {
                    Song c = (Song) cmboNames.getSelectedItem();
                    myThing.deleteSong(c);
                    txtName.setText("");
                    txtSong.setText("");
                    cmboNames.setModel(new DefaultComboBoxModel(myThing.getSortedArray()));
                }
                lblCount.setText("# of Songs: " + myThing.songCount());
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(isCreating);
                if (!txtName.getText().isEmpty()) {
                    if (isCreating) {
                        myThing.addSong(new Song(txtName.getText(), txtSong.getText()));
                        cmboNames.setModel(new DefaultComboBoxModel(myThing.getSortedArray()));
                        cmboNames.setSelectedIndex(myThing.songCount()-1);                   
                    } else {
                        Song c = (Song) cmboNames.getSelectedItem();
                        c.setName(txtName.getText());
                        c.setContent(txtSong.getText());
                        cmboNames.setModel(new DefaultComboBoxModel(myThing.getSortedArray()));
                        cmboNames.setSelectedItem(c);
                    }
                }

                lblCount.setText("# of Songs: " + myThing.songCount());
                isCreating = false;
            }
        });
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Play(txtSong.getText());
            }
        });
        cmboNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmboNames.getItemCount() > 0) {
                    Song c = (Song) cmboNames.getSelectedItem();
                    txtName.setText(c.getName());
                    txtSong.setText(c.getContent());
                }
            }
        });
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("1");
                } else {
                    Play("1");
                    txtSong.setText(txtSong.getText() + "1");
                }
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("2");
                } else {
                    Play("2");
                    txtSong.setText(txtSong.getText() + "2");
                }
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("3");
                } else {
                    Play("3");
                    txtSong.setText(txtSong.getText() + "3");
                }
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("4");
                } else {
                    Play("4");
                    txtSong.setText(txtSong.getText() + "4");
                }
            }
        });
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("5");
                } else {
                    Play("5");
                    txtSong.setText(txtSong.getText() + "5");
                }
            }
        });
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("6");
                } else {
                    Play("6");
                    txtSong.setText(txtSong.getText() + "6");
                }
            }
        });
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("7");
                } else {
                    Play("7");
                    txtSong.setText(txtSong.getText() + "7");
                }
            }
        });
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("8");
                } else {
                    Play("8");
                    txtSong.setText(txtSong.getText() + "8");
                }
            }
        });
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tbtnCreate.isSelected()) {
                    Play("0");
                } else {
                    Play("0");
                    txtSong.setText(txtSong.getText() + "0");
                }
            }
        });
        backSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbtnCreate.isSelected() && !txtSong.getText().isEmpty()) {
                    txtSong.setText(txtSong.getText().substring(0, txtSong.getText().length() - 1));
                }
            }
        });

    }
}
