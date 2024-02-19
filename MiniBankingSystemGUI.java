import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            JOptionPane.showMessageDialog(null, " Sorry..Insufficient Amount in your Account ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

public class MiniBankingSystemGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JTextField amountField;
    private JLabel balanceLabel;
    private boolean balanceChecked;

    public MiniBankingSystemGUI(double initialBalance) {
        super("Mini Banking System");
        account = new BankAccount(initialBalance);
        balanceChecked = false;
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 0));

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton exitButton = new JButton("Exit");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        exitButton.addActionListener(this);

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        balanceLabel = new JLabel(""); // Initially empty

        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(checkBalanceButton);
        panel.add(exitButton);
        panel.add(balanceLabel);

        add(panel, BorderLayout.CENTER);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            if (balanceChecked) {
                updateBalanceLabel();
            }
        } else if (e.getActionCommand().equals("Withdraw")) {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdraw(amount)) {
                if (balanceChecked) {
                    updateBalanceLabel();
                }
            }
        } else if (e.getActionCommand().equals("Check Balance")) {
            updateBalanceLabel(); // Update balance label
            balanceChecked = true;
        } else if (e.getActionCommand().equals("Exit")) {
            JOptionPane.showMessageDialog(null, "Exiting the system. Thank you!");
            dispose();
        }
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Current Balance: $" + account.checkBalance());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniBankingSystemGUI(0.0));
    }
}
