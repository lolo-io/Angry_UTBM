package Threading;

import Model.Constantes;
import Model.Fenetre;
import Model.StateFen;

public class Print_aff implements Constantes, Runnable {
	
	public void run() {
		if (Fenetre._list_birds.size() != 0)
			Fenetre._fenster.changeBird(Fenetre._list_birds.get(0));
		while (Fenetre._state == StateFen.Level) {
			this.printObj();
			
			try {
				Thread.sleep(_REFRESH_AFF);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void printObj () {
		//Suppression des oiseaux qui ont touche quelque chose

			for(int i = 0; i < Fenetre._list_birds.size(); i++) {
				if (Fenetre._list_birds.get(i).isDestructed()) {
					Fenetre._list_birds.remove(i);
					if (Fenetre._list_birds.size() != 0)
						Fenetre._fenster.changeBird(Fenetre._list_birds.get(0));
				}
			}
		
		
		//Suppression des walkers qui ont touche quelque chose
			for(int i = 0; i < Fenetre._list_walkers.size(); i++) {
				if (Fenetre._list_walkers.get(i).isDestructed()) {
					Fenetre._list_walkers.remove(i);
				}
			}
		
		
		//Suppression des oeufs qui ont touche quelque chose
	
			for(int i = 0; i < Fenetre._list_egg.size(); i++) {
				if (Fenetre._list_egg.get(i).isDestructed()) {
					Fenetre._list_egg.remove(i);
				}
			}
	
		
		Fenetre._fenster.repaint();
	}
}
