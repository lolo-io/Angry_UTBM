package Model;

import View.MenuFail;
import View.MenuHigh;
import View.MenuPause;
import View.MenuPrinc;
import View.MenuLevel;
import View.MenuVict;
import View.ZoneAff;

public class MenuSelector {
	private MenuPrinc _menuPrinc;
	private MenuPause _menuPause;
	private MenuHigh _menuHigh;
	private MenuLevel _menuLevel;
	private MenuVict _menuVict;
	private MenuFail _menuFail;
	
	public MenuSelector () {
		_menuPrinc = new MenuPrinc();
		_menuPause = new MenuPause();
		_menuHigh = new MenuHigh();
		_menuLevel = new MenuLevel();
		_menuVict = new MenuVict();
		_menuFail = new MenuFail();
	}

	public ZoneAff selectMenu() {
		ZoneAff curMenu;
		
		switch (Fenetre._state) {
			case MenuPause :
				curMenu = _menuPause;
				_menuPause.updateScore();
			break;
		
			case MenuHigh :
				curMenu = _menuHigh;
			break;
			
			case LevelLoad :
				_menuLevel = new MenuLevel();
				curMenu = _menuLevel;
			break;
			
			case Victory :
				curMenu = _menuVict;
				Fenetre._level.saveHighScore();
				_menuVict.updateMenu();
			break;
			
			case Fail :
				curMenu = _menuFail;
				_menuFail.updateScore();
			break;
			
			default :
				curMenu = _menuPrinc;
			break;
		}
		
		return curMenu;
	}
}
