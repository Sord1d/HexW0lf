import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class userinterface {

    public String InputText;
    public int TextLength;
    public int CurrentPosition;
    public int OldPosition;
    public int color;
    List<String> colors = Arrays.asList("#ff0000" , "#ff1200" , "#ff2400" , "#ff3700" , "#ff4900" , "#ff5b00" , "#ff6d00" , "#ff8000" , "#ff9200" , "#ffa400" , "#ffb600" , "#ffc800" , "#ffdb00" , "#ffed00" , "#ffff00" , "#f5ff00" , "#ecff00" , "#e2ff00" , "#d8ff00" , "#ceff00" , "#c5ff00" , "#bbff00" , "#b1ff00" , "#a8ff00" , "#9eff00" , "#94ff00" , "#8aff00" , "#81ff00" , "#77ff00" , "#6fff12" , "#66ff24" , "#5eff37" , "#55ff49" , "#4dff5b" , "#44ff6d" , "#3cff80" , "#33ff92" , "#2bffa4" , "#22ffb6" , "#1affc8" , "#11ffdb" , "#09ffed" , "#00ffff" , "#00f5ff" , "#00ecff" , "#00e2ff" , "#00d8ff" , "#00ceff" , "#00c5ff" , "#00bbff" , "#00b1ff" , "#00a8ff" , "#009eff" , "#0094ff" , "#008aff" , "#0081ff" , "#0077ff" , "#126fed" , "#2466db" , "#375ec8" , "#4955b6" , "#5b4da4" , "#6d4492" , "#803c80" , "#92336d" , "#a42b5b" , "#b62249" , "#c81a37" , "#db1124" , "#ed0912" , "#ff0000");

    public static void main(String[] args) {
        JFrame frame = new JFrame("HexW0lf - Color Gradient Generator");
        frame.setContentPane(new userinterface().interfacepanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel interfacepanel;
    public JTextPane InputTextTextPane;
    public JTextPane OutputText;
    private JButton generateButton;
    public JRadioButton OptionRed;
    public JRadioButton OptionGreen;
    public JRadioButton OptionBlue;
    public JRadioButton OptionYellow;
    private JButton testButton;

    public userinterface() {

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StringSetup();

            }

        });

        OptionRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OptionRed.isSelected()) {
                    OptionBlue.setSelected(false);
                    OptionYellow.setSelected(false);
                    OptionGreen.setSelected(false);
                } else {
                    OptionRed.setSelected(true);
                }
            }

        });

        OptionGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OptionGreen.isSelected()) {
                    OptionBlue.setSelected(false);
                    OptionYellow.setSelected(false);
                    OptionRed.setSelected(false);
                } else {
                    OptionGreen.setSelected(true);
                }
            }

        });

        OptionBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OptionBlue.isSelected()) {
                    OptionRed.setSelected(false);
                    OptionYellow.setSelected(false);
                    OptionGreen.setSelected(false);
                } else {
                    OptionBlue.setSelected(true);
                }
            }
        });

        OptionYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OptionYellow.isSelected()) {
                    OptionBlue.setSelected(false);
                    OptionRed.setSelected(false);
                    OptionGreen.setSelected(false);
                } else {
                    OptionYellow.setSelected(true);
                }
            }
        });
    }

    public void generation() {
        var hex =  colors.get(color);
        if ( CurrentPosition < TextLength ) {
            var text = OutputText.getText();
            var CurrentLetter = InputText.charAt(CurrentPosition);
            OutputText.setText(text + hex + CurrentLetter);
            CurrentPosition = CurrentPosition +1 ;

            if (color<70) {
                color = color +1;
            } else {
                color =1;
            }

            generation();
        }else {
            EndGeneration();
        }
    }

    public void EndGeneration(){
        generateButton.setEnabled(true);
        OutputText.setEnabled(true);
    }

    public void StringSetup(){
        OutputText.setEnabled(false);
        generateButton.setEnabled(false);

        if (OptionRed.isSelected()){
            color = 1;
        } else if (OptionBlue.isSelected()){
            color = 45;
        } else if (OptionGreen.isSelected()){
            color = 30;
        } else if (OptionYellow.isSelected()) {
            color = 15;
        }

        OutputText.setText("");
        InputText = InputTextTextPane.getText();
        TextLength = InputText.length();
        CurrentPosition = 0;
        generation();
    }


}

