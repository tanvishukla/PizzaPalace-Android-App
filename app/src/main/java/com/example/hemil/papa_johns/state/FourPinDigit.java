package com.example.hemil.papa_johns.state;


import android.util.Log;

public class FourPinDigit implements IpinState {
	
	IPinStateMachine machine;
	
	 public FourPinDigit( IPinStateMachine m )
	    {
	        this.machine = m ;
	    }

	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		Log.d("In State 4","BackSpace Called");
		machine.setStateThreePinDigits(null);
	}

	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validPin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invalidPin() {
		// TODO Auto-generated method stub
		machine.setStateNoPinDigits();
		
	}

}
