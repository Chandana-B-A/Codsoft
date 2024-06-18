import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Atm {
	private Bank account;
	private JLabel balanceLabel;

    public Atm(Bank account) {
        this.account = account;
        balanceLabel = new JLabel("Balance: ₹" + account.getBalance());
    }

    public void start() {
        JFrame frame = new JFrame("ATM System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel balanceLabel = new JLabel("Balance: ₹" + account.getBalance());
        panel.add(balanceLabel);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new FlowLayout());

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new CheckBalanceListener());
        optionPanel.add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositListener());
        optionPanel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawListener());
        optionPanel.add(withdrawButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());
        optionPanel.add(exitButton);

        panel.add(optionPanel);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private class CheckBalanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Your balance is: ₹" + account.getBalance());
        }
    }

    private class DepositListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to deposit:"));
            account.deposit(amount);
            balanceLabel.setText("Balance: ₹" + account.getBalance());
        }
    }

    private class WithdrawListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to withdraw:"));
            if (account.withdraw(amount)) {
                balanceLabel.setText("Balance: ₹" + account.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient balance. Withdrawal failed.");
            }
        }
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
public class Bank {
	private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
public class Main {
	public static void main(String[] args) {
        Bank account = new Bank(1000.0);
        Atm atm = new Atm(account);
        atm.start();
    }
}
