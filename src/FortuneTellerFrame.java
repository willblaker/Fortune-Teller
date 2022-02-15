import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel botPnl;

    JLabel topTxt;
    ImageIcon topImage;

    JTextArea midTxt;
    JScrollPane midScroll;

    JButton botButton;
    JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastInt = -1;
    private int index;

    public FortuneTellerFrame(){
        getFortunes();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMidPanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);

        createBotPanel();
        mainPnl.add(botPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createTopPanel(){
        topPnl = new JPanel();

        topTxt = new JLabel();

        topImage = new ImageIcon(this.getClass().getResource("image.jpg"));
        topImage = new ImageIcon(topImage.getImage().getScaledInstance(260,202,Image.SCALE_SMOOTH));
        topTxt.setIcon(topImage);

        topTxt.setText("Fortune Teller");
        topTxt.setFont(new Font("Serif", Font.PLAIN, 36));
        topTxt.setHorizontalTextPosition(JLabel.CENTER);
        topTxt.setVerticalTextPosition(JLabel.NORTH);

        topPnl.add(topTxt);
    }

    public void createMidPanel(){
        midPnl = new JPanel();

        midTxt = new JTextArea("", 8, 35);
        midTxt.setFont(new Font ("Comic Sans", Font.PLAIN, 18));
        midScroll = new JScrollPane(midTxt);

        midPnl.add(midScroll);
    }

    public void createBotPanel(){
        botPnl = new JPanel();

        botButton = new JButton();
        botButton.setText("Read My Fortune!");
        botButton.setFont(new Font("Arial", Font.PLAIN, 16));

        botButton.addActionListener((ActionEvent ae) ->
                {
                    midTxt.append("");
                    Random rnd = new Random();

                    do{
                         index = rnd.nextInt(11);
                    }while(index == lastInt);

                    String fortune = fortunes.get(index);
                    lastInt = index;
                    midTxt.append(fortune);
                }
        );

        quitButton = new JButton();
        quitButton.setText("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        botPnl.add(botButton);
        botPnl.add(quitButton);
    }

    public void getFortunes(){
    fortunes = new ArrayList<String>(12);
    fortunes.add("Be on the lookout for coming events; They cast their shadows beforehand." + "\n");
    fortunes.add("It is now, and in this world, that we must live."+ "\n");
    fortunes.add("Your shoes will make you happy today."+ "\n");
    fortunes.add("Enjoy the good luck a companion brings you."+ "\n");
    fortunes.add("You will live long enough to open many fortune cookies."+ "\n");
    fortunes.add("You already know the answer to the questions lingering inside your head."+ "\n");
    fortunes.add("The fortune you seek is in another cookie."+ "\n");
    fortunes.add("A fanatic is one who can't change his mind, and won't change the subject."+ "\n");
    fortunes.add("An alien of some sort will be appearing to you shortly."+ "\n");
    fortunes.add("Because of your melodic nature, the moonlight never misses an appointment."+ "\n");
    fortunes.add("If you refuse to accept anything but the best, you very often get it."+ "\n");
    fortunes.add("Never give up. You're not a failure if you don't give up."+ "\n");
    }
}
