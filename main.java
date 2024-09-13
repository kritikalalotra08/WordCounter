 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {

    // GUI Components
    private JTextArea textArea;
    private JButton countButton;
    private JLabel wordLabel, charLabel, paraLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Setting up the GUI layout
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        wordLabel = new JLabel("Words: 0");
        charLabel = new JLabel("Characters: 0");
        paraLabel = new JLabel("Paragraphs: 0");

        // Scroll Pane for Text Area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adding components to the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(countButton);
        panel.add(wordLabel);
        panel.add(charLabel);
        panel.add(paraLabel);

          // Adding components to frame
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Set up action listener for the button
        countButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();

        // Count words in the given text 
        String[] words = text.trim().split("\\s+");
        int wordCount = (text.trim().isEmpty()) ? 0 : words.length;

        // Count total characters
        int charCount = text.replaceAll("\\s", "").length();

        // Count paragraphs
        String[] paragraphs = text.split("\\n+");
        int paraCount = (text.trim().isEmpty()) ? 0 : paragraphs.length;

        // Update labels
        wordLabel.setText("Words: " + wordCount);
        charLabel.setText("Characters: " + charCount);
        paraLabel.setText("Paragraphs: " + paraCount);
    }
   
    public static void main(String[] args) {
        // Launch the Word Counter app
        SwingUtilities.invokeLater(() -> {
            WordCounter wc = new WordCounter();
            wc.setVisible(true);
        });
    }
}