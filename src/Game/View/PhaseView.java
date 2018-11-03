/**
 * 
 */
package Game.View;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 * This class represent the Phase View for the Main game.
 * 
 * @author Jay
 */
public class PhaseView implements Observer {

	private JButton btnPhases;
    private JPanel Phases_panel;
    private JLabel labelPhases;
    private JComboBox<String> Neibhour_country_combo;
    private JComboBox<Integer> Number_armies_Combo;
    private JComboBox<String> Country_combo;
    
	/**
	 * Constructor for the phase view interface.
	 */
	public PhaseView() {
		// TODO Auto-generated constructor stub
		labelPhases = new JLabel();
        btnPhases = new JButton();
        Phases_panel = new JPanel();
        Number_armies_Combo = new JComboBox<>();
        Country_combo = new JComboBox<>();
        Neibhour_country_combo = new JComboBox<>();
        
		labelPhases.setText("Phases :");
        btnPhases.setText("Phases :");

        GroupLayout Phases_panelLayout = new GroupLayout(Phases_panel);
        Phases_panel.setLayout(Phases_panelLayout);
        Phases_panelLayout.setHorizontalGroup(
            Phases_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Phases_panelLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(labelPhases, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(Phases_panelLayout.createSequentialGroup()
                    .addComponent(btnPhases)
                    .addGap(18, 18, 18)
                    .addComponent(Number_armies_Combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(Phases_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(Neibhour_country_combo, 0, 47, Short.MAX_VALUE)
                    .addComponent(Country_combo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Phases_panelLayout.setVerticalGroup(
            Phases_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Phases_panelLayout.createSequentialGroup()
                    .addComponent(labelPhases)
                    .addGap(26, 26, 26)
                    .addGroup(Phases_panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPhases)
                        .addComponent(Number_armies_Combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Neibhour_country_combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Country_combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE))
        );
	}

	/**
	 * Return Phases Panel for main risk view.
	 * 
	 * @return Phases_panel Panel for Phases View.
	 */
	public JPanel getPanel() {
		 return this.Phases_panel;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}