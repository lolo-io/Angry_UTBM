package Model;

public class HighScore {
	
	private int _currentScore = 0;
	private int _currentCombo = 0;
	private int _highscore = 0;
	
	public HighScore() {
		
	}
	
	public void setHigh(int score) {
		_highscore = score;
	}
	
	public void setCurrent(int score) {
		_currentScore = score;
	}
	
	public void setCombo(int combo) {
		_currentCombo = combo;
	}
	
	public int getHigh() {
		return _highscore;
	}
	
	public int getCurrent() {
		return _currentScore;
	}
	
	public int getCombo() {
		return _currentCombo;
	}
}
