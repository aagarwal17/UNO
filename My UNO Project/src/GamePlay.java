package src;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
public class GamePlay extends Frame implements ActionListener{
    public GamePlay(){
        JFrame Start = new JFrame("Let's Play UNO!"); //Creates Game frame to hold all panels
        JTextArea t_1 = new JTextArea("How many plaers are there?");
        t_1.setEditable(false);
        JRadioButton players = new JRadioButton("2 Players");
        players.addActionListener((ActionEvent e) -> { //Creates 2 new players with empty hands
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>();
            Player player1 = new Player("Player 1", hand);
            Player player2 = new Player("Player 2", hand);
        });
        JButton start_game = new JButton("Click to Start!");
        //Action Listener to set new screen
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
