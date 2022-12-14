import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Baseball{
	
	private String name;
	private int[] number;
	//private ArrayList<History> history = new ArrayList<History>();
	
	public Player() {
		this.number = new int[3];
	};
	public Player(String name) throws Exception {
		if(name != null) {
			this.name = name;
			this.number = new int[3];
		}
		else {
			throw new Exception("Invalid name");
		}
	}
	//setter
	
	public void setName(String name) throws Exception{
		if(name != null) {
			this.name = name;
		}
		else {
			throw new Exception("Invalid name");
		}
	}
	public void setNumber(int number, int index) throws Exception{
		if(number > 0 && number < 10) {
			for(int element : this.number) {
				if(element == number) {
					throw new Exception("Try different number");
				}
			}
			this.number[index] = number;
		}
		else{
			throw new Exception("Invalid number, please enter 1-9, only 1 digit");
		}
	}
	
	//getter
	public String getName() {
		return name;
	}

	public int[] getNumber() {
		return number;
	}
	
	public boolean isCorrect(int number[]) {
		if(Arrays.equals(this.number, number)) {
			return true;
		}
		else {
			super.ball = calculateBall(this.number, number);
			super.strike = calculateStrike(this.number, number);
			super.out = calculateOut(this.number, number);
		}
		return false;
	}
	
	public void setHistory(int[] num, int[] original) {
		//History h = new History();

		int b = calculateBall(original, num);
		int s = calculateStrike(original, num);
		boolean o = calculateOut(original, num);
		
		int out = 0;
		if(o) {
			out = 1;
		}
		
		int[] bsk = {b,s,out};
		this.addHistory(num, bsk);

	}
}
