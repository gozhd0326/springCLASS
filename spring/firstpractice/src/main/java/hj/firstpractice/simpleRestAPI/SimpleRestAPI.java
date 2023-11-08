package hj.firstpractice.simpleRestAPI;

public class SimpleRestAPI {

//model
private int midNumber;
private int lastNumber;

//생성자
public SimpleRestAPI(int midNumber, int lastNumber) {
	super();
	this.midNumber = midNumber;
	this.lastNumber = lastNumber;
}

//getter & setter
public int getMidNumber() {
	return midNumber;
}

public void setMidNumber(int midNumber) {
	this.midNumber = midNumber;
}

public int getLastNumber() {
	return lastNumber;
}

public void setLastNumber(int lastNumber) {
	this.lastNumber = lastNumber;
}


}
