package com.example.hemil.papa_johns.state;

public class NoPinDigit implements IpinState{
	IPinStateMachine machine;
	
	 public NoPinDigit( IPinStateMachine m )
	    {
	        this.machine = m ;
	    }

	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		machine.setStateOnePinDigit(digit);
		
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
