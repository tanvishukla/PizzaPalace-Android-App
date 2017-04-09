package com.example.hemil.papa_johns.state;

public class OnePinDigit implements IpinState{
  
	IPinStateMachine machine;
	
	 public OnePinDigit( IPinStateMachine m )
	    {
	        this.machine = m ;
	    }
	
	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		machine.setStateNoPinDigits();
		
	}

	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		machine.setStateTwoPinDigits(digit);
		
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
