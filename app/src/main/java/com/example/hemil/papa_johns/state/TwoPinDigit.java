package com.example.hemil.papa_johns.state;

public class TwoPinDigit implements IpinState{

	IPinStateMachine machine;
	
	 public TwoPinDigit( IPinStateMachine m )
	    {
	        this.machine = m ;
	    }
	
	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		machine.setStateOnePinDigit(null);
		
	}

	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		machine.setStateThreePinDigits(digit);
		
	}

	@Override
	public void validPin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invalidPin() {
		// TODO Auto-generated method stub
		
	}
	

}
