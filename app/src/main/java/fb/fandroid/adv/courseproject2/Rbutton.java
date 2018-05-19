package fb.fandroid.adv.courseproject2;



import java.io.Serializable;

public class Rbutton implements Serializable {

	private int rButtonId;
	private boolean rButtonChecked;

	public Rbutton(int buttonID,boolean buttonChecked ){

		rButtonId=buttonID;
		rButtonChecked=buttonChecked;

	}

	public void setRButtonId(int rButtonId){
		this.rButtonId = rButtonId;
	}

	public int getRButtonId(){
		return rButtonId;
	}

	public void setRButtonChecked(boolean rButtonChecked){
		this.rButtonChecked = rButtonChecked;
	}

	public boolean isRButtonChecked(){
		return rButtonChecked;
	}

	@Override
 	public String toString(){
		return 
			"Rbutton{" +
			"rButtonId = '" + rButtonId + '\'' + 
			",rButtonChecked = '" + rButtonChecked + '\'' + 
			"}";
		}
}