package com.example.hemil.papa_johns.state;
public class ThreePinDigit implements IpinState {
	
	IPinStateMachine machine;
	
	 public ThreePinDigit( IPinStateMachine m )
	    {
	        this.machine = m ;
	    }

	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		machine.setStateTwoPinDigits(null);
		
	}

	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		 machine.setStateFourPinDigits(digit);
		
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
