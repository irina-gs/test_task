import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Visualization {
    public void windowCreate() {
        JFrame frameCreateCreature = new JFrame("Create");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frameCreateCreature.setBounds(300,100,200, 300);

        JPanel panel = new JPanel();
        frameCreateCreature.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel panelPlayer = new JPanel();
        panel.add(panelPlayer);
        panelPlayer.setLayout(new BoxLayout(panelPlayer, BoxLayout.Y_AXIS));

        JLabel player = new JLabel("PLAYER");
        panelPlayer.add(player);
        JLabel attackPlayer = new JLabel("Attack");
        panelPlayer.add(attackPlayer);
        JTextField attackPlayerT = new JTextField(10);
        panelPlayer.add(attackPlayerT);
        JLabel protectionPlayer = new JLabel("Protection");
        panelPlayer.add(protectionPlayer);
        JTextField protectionPlayerT = new JTextField(10);
        panelPlayer.add(protectionPlayerT);
        JLabel healthPlayer = new JLabel("Health");
        panelPlayer.add(healthPlayer);
        JTextField healthPlayerT = new JTextField(10);
        panelPlayer.add(healthPlayerT);
        JLabel damageMinPlayer = new JLabel("Damage (min)");
        panelPlayer.add(damageMinPlayer);
        JTextField damageMinPlayerT = new JTextField(10);
        panelPlayer.add(damageMinPlayerT);
        JLabel damageMaxPlayer = new JLabel("Damage (max)");
        panelPlayer.add(damageMaxPlayer);
        JTextField damageMaxPlayerT = new JTextField(10);
        panelPlayer.add(damageMaxPlayerT);

        JPanel panelMonster = new JPanel();
        panel.add(panelMonster);
        panelMonster.setLayout(new BoxLayout(panelMonster, BoxLayout.Y_AXIS));

        JLabel monster = new JLabel("MONSTER");
        panelMonster.add(monster);
        JLabel attackMonster = new JLabel("Attack");
        panelMonster.add(attackMonster);
        JTextField attackMonsterT = new JTextField(10);
        panelMonster.add(attackMonsterT);
        JLabel protectionMonster = new JLabel("Protection");
        panelMonster.add(protectionMonster);
        JTextField protectionMonsterT = new JTextField(10);
        panelMonster.add(protectionMonsterT);
        JLabel healthMonster = new JLabel("Health");
        panelMonster.add(healthMonster);
        JTextField healthMonsterT = new JTextField(10);
        panelMonster.add(healthMonsterT);
        JLabel damageMinMonster = new JLabel("Damage (min)");
        panelMonster.add(damageMinMonster);
        JTextField damageMinMonsterT = new JTextField(10);
        panelMonster.add(damageMinMonsterT);
        JLabel damageMaxMonster = new JLabel("Damage (max)");
        panelMonster.add(damageMaxMonster);
        JTextField damageMaxMonsterT = new JTextField(10);
        panelMonster.add(damageMaxMonsterT);

        JButton buttonPlay = new JButton("Play");
        frameCreateCreature.add(buttonPlay, BorderLayout.SOUTH);
        buttonPlayAction(buttonPlay, frameCreateCreature, attackPlayerT, protectionPlayerT, healthPlayerT, damageMinPlayerT, damageMaxPlayerT, attackMonsterT, protectionMonsterT, healthMonsterT, damageMinMonsterT, damageMaxMonsterT);

        frameCreateCreature.setVisible(true);
    }
    public void buttonPlayAction(JButton buttonPlay, JFrame frameCreateCreature, JTextField attackPlayerT, JTextField protectionPlayerT, JTextField healthPlayerT, JTextField damageMinPlayerT, JTextField damageMaxPlayerT, JTextField attackMonsterT, JTextField protectionMonsterT, JTextField healthMonsterT, JTextField damageMinMonsterT, JTextField damageMaxMonsterT) {
        buttonPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    int attackPlayer = Integer.parseInt(attackPlayerT.getText().trim());
                    int protectionPlayer = Integer.parseInt(protectionPlayerT.getText().trim());
                    int healthPlayer = Integer.parseInt(healthPlayerT.getText().trim());
                    int damageMinPlayer = Integer.parseInt(damageMinPlayerT.getText().trim());
                    int damageMaxPlayer = Integer.parseInt(damageMaxPlayerT.getText().trim());

                    int attackMonster = Integer.parseInt(attackMonsterT.getText().trim());
                    int protectionMonster = Integer.parseInt(protectionMonsterT.getText().trim());
                    int healthMonster = Integer.parseInt(healthMonsterT.getText().trim());
                    int damageMinMonster = Integer.parseInt(damageMinMonsterT.getText().trim());
                    int damageMaxMonster = Integer.parseInt(damageMaxMonsterT.getText().trim());

                    Player player = new Player();
                    Monster monster = new Monster();

                    player.create(attackPlayer, protectionPlayer, healthPlayer, damageMinPlayer, damageMaxPlayer);
                    monster.create(attackMonster, protectionMonster, healthMonster, damageMinMonster, damageMaxMonster);

                    if (player.checkParameters() && monster.checkParameters()) {
                        frameCreateCreature.setVisible(false);
                        frameCreateCreature.dispose();
                        try {
                            windowGame(player, monster);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! Set all parameters correctly.");
                    }
                }
                catch(NumberFormatException ee){
                    JOptionPane.showMessageDialog(null, "Error! Set all parameters correctly.");
                }
            }
        });
    }
    public void windowGame(Player player, Monster monster) throws IOException {
        JFrame frame = new JFrame("Fight with monsters");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200,100,800, 600);

        BufferedImage bufferedImagePlayer = ImageIO.read(new File("src/images/player.png"));
        Image imagePlayer = bufferedImagePlayer.getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon iconPlayer = new ImageIcon(imagePlayer);

        BufferedImage bufferedImageLightning = ImageIO.read(new File("src/images/lightning.png"));
        Image imageLightning = bufferedImageLightning.getScaledInstance(250, 500, Image.SCALE_DEFAULT);
        ImageIcon iconLightning = new ImageIcon(imageLightning);

        BufferedImage bufferedImageMonster = ImageIO.read(new File("src/images/monster.png"));
        Image imageMonster = bufferedImageMonster.getScaledInstance(250, 150, Image.SCALE_DEFAULT);
        ImageIcon iconMonster = new ImageIcon(imageMonster);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel jLabelPlayer = new JLabel();
        jLabelPlayer.setIcon(iconPlayer);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(jLabelPlayer);

        JLabel jLabelLightning = new JLabel();
        jLabelLightning.setIcon(iconLightning);
        panel.add(jLabelLightning);

        JLabel jLabelMonster = new JLabel();
        jLabelMonster.setIcon(iconMonster);
        panel.add(jLabelMonster);

        JPanel gridInfo = new JPanel(new GridLayout(4, 2, 450, 5));
        JLabel attackPlayer = new JLabel("attack: " + player.getAttack());
        gridInfo.add(attackPlayer);
        JLabel attackMonster = new JLabel("attack: " + monster.getAttack());
        gridInfo.add(attackMonster);
        JLabel protectionPlayer = new JLabel("protection: " + player.getProtection());
        gridInfo.add(protectionPlayer);
        JLabel protectionMonster = new JLabel("protection: " + monster.getProtection());
        gridInfo.add(protectionMonster);
        JLabel healthPlayer = new JLabel("health: " + player.getHealth());
        gridInfo.add(healthPlayer);
        JLabel healthMonster = new JLabel("health: " + monster.getHealth());
        gridInfo.add(healthMonster);

        int damageMinPlayer = 0, damageMaxPlayer = 0, damageMinMonster = 0, damageMaxMonster = 0;
        for (int i = 0; i < 2; i++) {
            damageMinPlayer = player.getDamage()[0];
            damageMaxPlayer = player.getDamage()[1];
            damageMinMonster = monster.getDamage()[0];
            damageMaxMonster = monster.getDamage()[1];
        }
        JLabel damagePlayer = new JLabel("damage: " + damageMinPlayer + " - " + damageMaxPlayer);
        gridInfo.add(damagePlayer);
        JLabel damageMonster = new JLabel("damage: " + damageMinMonster + " - " + damageMaxMonster);
        gridInfo.add(damageMonster);

        JPanel flowInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flowInfo.add(gridInfo);
        Container containerInfo = frame.getContentPane();
        containerInfo.add(flowInfo, BorderLayout.NORTH);

        JPanel gridButtons = new JPanel(new GridLayout(2, 2, 450, 5));

        JButton buttonHitPlayer = new JButton("Hit");
        buttonHitPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                healthMonster.setText("health: " + monster.getHealth());
            }
        });
        gridButtons.add(buttonHitPlayer);
        buttonHitPlayerAction(buttonHitPlayer, player, monster, frame);

        JButton buttonHitMonster = new JButton("Hit");
        buttonHitMonster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                healthPlayer.setText("health: " + player.getHealth());
            }
        });
        gridButtons.add(buttonHitMonster);
        buttonHitMonsterAction(buttonHitMonster, player, monster, frame);

        JButton buttonHealing = new JButton("Heal");
        buttonHealing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                healthPlayer.setText("health: " + player.getHealth());
            }
        });
        gridButtons.add(buttonHealing);
        buttonHealingAction(buttonHealing, player);

        JPanel flowButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flowButton.add(gridButtons);
        Container containerButton = frame.getContentPane();
        containerButton.add(flowButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    public void buttonHitPlayerAction(JButton buttonHitPlayer, Player player, Monster monster, JFrame frame) {
        buttonHitPlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                player.hit(monster);
                if (monster.getHealth() == 0) {
                    JOptionPane.showMessageDialog(null, "Game over. You've won.");
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
    }
    public void buttonHitMonsterAction(JButton buttonHitMonster, Player player, Monster monster, JFrame frame) {
        buttonHitMonster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monster.hit(player);
                if (player.getHealth() == 0) {
                    JOptionPane.showMessageDialog(null, "Game over. You've lost.");
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
    }
    public void buttonHealingAction(JButton buttonHealing, Player player) {
        buttonHealing.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                player.healing();
                if (player.countHealing > 4) {
                    JOptionPane.showMessageDialog(null, "You can't heal anymore.");
                }
            }
        });
    }
}
