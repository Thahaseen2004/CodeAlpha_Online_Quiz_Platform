import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingApplicationGUI extends JFrame {
    private double balance = 0.0;

    private JTextField amountField;
    private JLabel balanceLabel;

    public BankingApplicationGUI() {
        setTitle("Simple Banking Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 50, 80, 25);
        panel.add(amountLabel);
        
        amountField = new JTextField(20);
        amountField.setBounds(150, 50, 150, 25);
        panel.add(amountField);
        
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 100, 100, 25);
        depositButton.addActionListener(new DepositButtonListener());
        panel.add(depositButton);
        
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(200, 100, 100, 25);
        withdrawButton.addActionListener(new WithdrawButtonListener());
        panel.add(withdrawButton);
        
        balanceLabel = new JLabel("Balance: ₹" + balance);
        balanceLabel.setBounds(50, 150, 200, 25);
        panel.add(balanceLabel);
        
        add(panel);
    }

    private class DepositButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    balance += amount;
                    balanceLabel.setText("Balance: $" + balance);
                    amountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a valid amount.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter a valid number.");
            }
        }
    }

    private class WithdrawButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + balance);
                    amountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid amount or insufficient balance.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankingApplicationGUI().setVisible(true);
            }
        });
    }
}
