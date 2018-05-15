package fb.fandroid.adv.courseproject2;



import java.io.Serializable;

public class Rbutton implements Serializable {

	private String rButtonId;
	private boolean rButtonChecked;

	public Rbutton(String buttonID,Boolean buttonChecked ){

		rButtonId=buttonID;
		rButtonChecked=buttonChecked;

	}

	public void setRButtonId(String rButtonId){
		this.rButtonId = rButtonId;
	}

	public String getRButtonId(){
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