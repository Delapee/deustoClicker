package es.b04.game.adminTables;

import es.b04.game.log.User;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class UserInfoPanel extends JPanel {

	private static final long serialVersionUID = 1610152286982152009L;
	
	private JLabel nameInfo;
	private JLabel emailInfo;
	private JLabel genderInfo;
	private JLabel ageInfo;
	private JLabel levelInfo;
	private JLabel nChampionsInfo;
	private JLabel goldInfo;
	private JLabel autoClickInfo;
	private JLabel stageInfo;
	private JLabel raidLevelInfo;


	public UserInfoPanel() {
		super(new GridLayout(5, 1));
		
		Border border = BorderFactory.createTitledBorder("Informacion");
		setBorder(border);
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nameLabel = new JLabel("Nombre: ");
		nameInfo = new JLabel();

		namePanel.add(nameLabel);
		namePanel.add(nameInfo);
		
		add(namePanel);
		
		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabel = new JLabel("Email: ");
		emailInfo = new JLabel();

		emailPanel.add(emailLabel);
		emailPanel.add(emailInfo);
		
		add(emailPanel);
		
		JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel genderLabel = new JLabel("Genero: ");
		genderInfo = new JLabel();

		genderPanel.add(genderLabel);
		genderPanel.add(genderInfo);
		
		add(genderPanel);
		
		JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ageLabel = new JLabel("Edad: ");
		ageInfo = new JLabel();

		agePanel.add(ageLabel);
		agePanel.add(ageInfo);
		
		add(agePanel);
		
		JPanel levelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel levelLabel = new JLabel("Nivel: ");
		levelInfo = new JLabel();

		levelPanel.add(levelLabel);
		levelPanel.add(levelInfo);
		
		add(levelPanel);

		JPanel nChampionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nChampionsLabel = new JLabel("N. Champions: ");
		nChampionsInfo = new JLabel();

		nChampionsPanel.add(nChampionsLabel);
		nChampionsPanel.add(nChampionsInfo);

		add(nChampionsPanel);

		JPanel goldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel goldLabel = new JLabel("Gold: ");
		goldInfo = new JLabel();

		goldPanel.add(goldLabel);
		goldPanel.add(goldInfo);

		add(goldPanel);

		JPanel autoClickPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel autoClickLabel = new JLabel("AutoClick: ");
		autoClickInfo = new JLabel();

		autoClickPanel.add(autoClickLabel);
		autoClickPanel.add(autoClickInfo);

		add(autoClickPanel);

		JPanel stagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel stageLabel = new JLabel("Stage: ");
		stageInfo = new JLabel();

		stagePanel.add(stageLabel);
		stagePanel.add(stageInfo);

		add(stagePanel);

		JPanel raidLevelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel raidLevelLabel = new JLabel("Raid level: ");
		raidLevelInfo = new JLabel();

		raidLevelPanel.add(raidLevelLabel);
		raidLevelPanel.add(raidLevelInfo);

		add(raidLevelPanel);
		
		add(new JPanel());
	}
	
	public void setUser(User u) {
		nameInfo.setText(u.getName());
		emailInfo.setText(u.getEmail());
		genderInfo.setText(u.getGender());
		ageInfo.setText(String.valueOf(u.getAge()));
		levelInfo.setText(String.valueOf(u.getLevel()));
		nChampionsInfo.setText(String.valueOf(u.getInventory().size()));
		goldInfo.setText(String.valueOf(u.getGold()));
		autoClickInfo.setText(String.valueOf(u.getAutoClick()));
		stageInfo.setText(String.valueOf(u.getStage()));
		raidLevelInfo.setText(String.valueOf(u.getRaidLevel()));
	}
	
	public void clear() {
		nameInfo.setText("");
		emailInfo.setText("");
		genderInfo.setText("");
		ageInfo.setText("");
		levelInfo.setText("");
		nChampionsInfo.setText("");
		goldInfo.setText("");
		autoClickInfo.setText("");
		stageInfo.setText("");
		raidLevelInfo.setText("");
	}
}
