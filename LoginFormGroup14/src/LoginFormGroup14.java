import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormGroup14 extends JFrame {
    private JTextField user;
    private JPasswordField pass;
    private JLabel mgadetailsko;

    public LoginFormGroup14() {
        setTitle("LOGIN FORM --- FROM GROUP 14, Esay,Palma,Eso");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(72, 61, 139), 0, getHeight(), new Color(123, 104, 238));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(140, 20, 200, 30);
        mainPanel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(50, 70, 80, 25);
        mainPanel.add(usernameLabel);

        user = new JTextField();
        user.setBounds(140, 70, 200, 25);
        user.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(user);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(50, 110, 80, 25);
        mainPanel.add(passwordLabel);

        pass = new JPasswordField();
        pass.setBounds(140, 110, 200, 25);
        pass.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(pass);

        JButton loginButton = new JButton("Login") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(72, 61, 139));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 14));
                FontMetrics fm = g2d.getFontMetrics();
                String buttonText = getText();
                int x = (getWidth() - fm.stringWidth(buttonText)) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2d.drawString(buttonText, x, y);
            }
        };
        loginButton.setBounds(140, 160, 100, 30);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(new LoginAction());
        mainPanel.add(loginButton);

        mgadetailsko = new JLabel("");
        mgadetailsko.setFont(new Font("Arial", Font.PLAIN, 12));
        mgadetailsko.setForeground(Color.YELLOW);
        mgadetailsko.setBounds(50, 200, 300, 25);
        mainPanel.add(mgadetailsko);

        setContentPane(mainPanel);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = user.getText();
            String password = new String(pass.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                mgadetailsko.setForeground(Color.YELLOW);
                mgadetailsko.setText("Please fill in both fields.");
            } else if (username.equals("group14") && password.equals("esaypalmaeso")) {
                mgadetailsko.setForeground(Color.GREEN);
                mgadetailsko.setText("Login successful!");

                SwingUtilities.invokeLater(() -> showDashboard());
            } else {
                mgadetailsko.setForeground(Color.RED);
                mgadetailsko.setText("Invalid username or password.");
            }
        }
    }

    private void showDashboard() {
        JFrame dashboard = new JFrame("2nd Window");
        dashboard.setSize(400, 300);
        dashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dashboard.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("GROUP 14 SUCCESSFUL LOGIN PAGE", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        welcomeLabel.setForeground(new Color(72, 61, 139));
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Retry?");
        logoutButton.addActionListener(e -> dashboard.dispose());
        panel.add(logoutButton, BorderLayout.SOUTH);

        dashboard.add(panel);
        dashboard.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFormGroup14 loginForm = new LoginFormGroup14();
            loginForm.setVisible(true);
        });
    }
}
