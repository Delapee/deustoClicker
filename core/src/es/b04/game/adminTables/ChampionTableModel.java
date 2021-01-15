package es.b04.game.adminTables;


import es.b04.game.character.Champion;
import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;

public class ChampionTableModel extends AbstractTableModel{

    private static final long serialVersionUID = 1610156386982152009L;

    List<Champion> champions;
    String[] columnNames = {"Name", "Level", "Level Max.", "Rare", "Dmg", "Accuracy", "Attack Speed",
            "Critic Prob.", "Dodge Prob.", "On Squad"};

    public void loadChampions(List<Champion> champions) {
        this.champions = champions;
        champions.sort(new Comparator<Champion>() {
            @Override
            public int compare(Champion o1, Champion o2) {
                return Boolean.compare(o2.isOnSquad(), o1.isOnSquad());
            }
        });
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (champions != null) return champions.size();
        else return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (champions == null) return null;
        switch (columnIndex) {
            case 0:
                return champions.get(rowIndex).getName();
            case 1:
                return champions.get(rowIndex).getLevel();
            case 2:
                return champions.get(rowIndex).getLevelMax();
            case 3:
                return rareToString(champions.get(rowIndex).getRare());
            case 4:
                return champions.get(rowIndex).getDmg();
            case 5:
                return champions.get(rowIndex).getAccuracy();
            case 6:
                return champions.get(rowIndex).getAttackSpeed();
            case 7:
                return champions.get(rowIndex).getCriticProb();
            case 8:
                return champions.get(rowIndex).getDodgeProb();
            case 9:
                return champions.get(rowIndex).isOnSquad();
            default:
                return null;
            
        }
    }

    private String rareToString(int rare){
        if (rare == 1) return "Comun";
        else if (rare == 2) return "Rara";
        else if (rare == 3) return "Épica";
        else if (rare == 4) return "Legendaria";
        else if (rare == 5) return "Primigéneo";
        return "";
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0 || columnIndex == 3 ) return String.class;
        else if (columnIndex == 7) return float.class;
        else if (columnIndex == 9) return Boolean.class;
        else return int.class;
    }
}
