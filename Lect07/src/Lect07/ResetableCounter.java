package Lect07;

public class ResetableCounter extends Counter {
	public void reset(){
		myCounter = 0;
		myCounter += 1;
	}
}
