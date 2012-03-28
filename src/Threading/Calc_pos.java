package Threading;

import Model.Birds;
import Model.Constantes;
import Model.Eggs;
import Model.Fenetre;
import Model.StateFen;

public class Calc_pos implements Constantes, Runnable {
	public void run() {
		while (Fenetre._state == StateFen.Level) {
			calc_pos();
			
			try {
				Thread.sleep(_REFRESH_POS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void calc_pos() {
		Birds curBirds;
		Eggs curEgg;
		
		if(Fenetre._list_walkers.size() == 0) {
			Fenetre.setState(StateFen.Victory);
		} else if (Fenetre._list_birds.size() == 0 && Fenetre._list_egg.size() == 0) {
			Fenetre.setState(StateFen.Fail);
		} else {
			
				for (int i = 0; i < Fenetre._list_walkers.size(); i++) {
					if (Fenetre._list_walkers.get(i).collide_static() || Fenetre._fenster.outScreen(Fenetre._list_walkers.get(i))) {
						Fenetre._list_walkers.get(i).switchArriereState();
					}
					
					Fenetre._list_walkers.get(i).move();
				}
			
						
			//Deplacement des oiseaux
			
				for(int i = 0; i < Fenetre._list_birds.size(); i++){
					curBirds = Fenetre._list_birds.get(i);
					
					if (curBirds.collide_static() || curBirds.collide_dynamic() || curBirds.isDestructing()){
						curBirds.demol();
					} else {
						curBirds.move();
					}
				}
			
			
			//Deplacement des oeufs
			
				for(int i = 0; i < Fenetre._list_egg.size(); i++){
					curEgg = Fenetre._list_egg.get(i);
					
					if (!curEgg.isDestructing()) {
						if (curEgg.collide_static()) {
							if (Fenetre._score.getCurrent() > 0) {
								Fenetre._score.setCurrent(Fenetre._score.getCurrent() - _MALUS);
							}
							Fenetre._score.setCombo(0);
						}
						
						if (curEgg.collide_dynamic()) {
							Fenetre._score.setCombo(Fenetre._score.getCombo() + _COMBO);
							Fenetre._score.setCurrent(Fenetre._score.getCurrent() + Fenetre._score.getCombo());
						}
					}
					
					if (curEgg.collide_static() || curEgg.collide_dynamic() || curEgg.isDestructing()){
						curEgg.demol();
					} else {
						curEgg.move();
					}
				
			}
		}
	}
	
}
