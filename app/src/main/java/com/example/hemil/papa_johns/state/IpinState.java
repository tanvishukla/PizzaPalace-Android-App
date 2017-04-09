package com.example.hemil.papa_johns.state;


public interface IpinState {
	void backspace() ;
    void number( String digit ) ;
    void validPin() ;
    void invalidPin() ;

}
