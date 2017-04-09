package com.example.hemil.papa_johns.state;

import android.util.Log;

public class PinEntryMachine implements IPinStateMachine{
	
	
	private String pin = "1234" ;
    private boolean authenticated = false ;
	private int pinCount=0 ;
	// pin machine states
    private NoPinDigit pin0 ;
    private OnePinDigit pin1 ;
    private TwoPinDigit pin2 ;
    private ThreePinDigit pin3 ;
    private FourPinDigit pin4 ;
    
 // current state
    private IpinState current_state ;
 // pin captured so far
    private String d1, d2, d3, d4 ;
    
    public PinEntryMachine( )
    {
        pin0 = new NoPinDigit( this ) ;
        pin1 = new OnePinDigit( this ) ;
        pin2 = new TwoPinDigit( this ) ;
        pin3 = new ThreePinDigit( this ) ;
        pin4 = new FourPinDigit( this ) ;
        this.current_state = pin0 ;
    }
    
    
    
    public void backspace() {
        this.current_state.backspace() ;
    }

    public void number( String digit ) {
        this.current_state.number( digit ) ;
    }

    public void validPin() {
        this.current_state.validPin() ;
    }

    public void invalidPin() {
        this.current_state.invalidPin() ;
    }

	@Override
	public void setStateNoPinDigits() {
		// TODO Auto-generated method stub
		this.pinCount=0;
		this.current_state = pin0 ;
        this.d1 = "" ;
        this.d2 = "" ;
        this.d3 = "" ;
        this.d4 = "" ;
		
	}
	@Override
	public void setStateOnePinDigit(String digit) {
		// TODO Auto-generated method stub
        Log.d("State","1");
		this.pinCount = 1 ;
        this.current_state = pin1 ;
        if ( digit != null )
            this.d1 = digit ;
        else
            this.d2 = "" ;
		
	}
	@Override
	public void setStateTwoPinDigits(String digit) {
		// TODO Auto-generated method stub
        Log.d("State","2");
		this.pinCount = 2 ;
        this.current_state = pin2 ;
        if ( digit != null )
            this.d2 = digit ;
        else
            this.d3 = "" ;
		
	}
	@Override
	public void setStateThreePinDigits(String digit) {
		// TODO Auto-generated method stub
        Log.d("State","3");
		this.pinCount = 3 ;
        this.current_state = pin3 ;
        if ( digit != null )
            this.d3 = digit ;
        else
            this.d4 = "" ;
		
	}
	@Override
	public void setStateFourPinDigits(String digit) {
		// TODO Auto-generated method stub
        Log.d("State","4");
		 this.pinCount = 4 ;
	        this.current_state = pin4 ;
	        if ( digit != null )
	        {
	            this.d4 = digit ;
	            System.out.println( "Authenticating..." ) ;
	            if ( pin.equals( d1+d2+d3+d4 ) )
	            {

                    Log.d("Success "+d1+d2+d3+d4,"Logged!");
                    System.out.println( "Successful Login!" ) ;
	                this.authenticated = true ;
	               
	            }
	            else
	            {
                    Log.d("Try "+d1+d2+d3+d4,"Again");
	                System.out.println( "Login Failed!" ) ;
	                setStateNoPinDigits() ;
	            }
	        }
	}

    public boolean isAuthenticated(){
        return authenticated;
    }
}
