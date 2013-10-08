package com.example.SubGameObj;

import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

public class GamePointer {
	private Position mPosition;
	private Ship Selected;
	
	public void setSelected(Ship O){
		Selected = O;
	}
	public void setPosition(Position p){
		mPosition = p;
	}
	public Position getPosition() {
		return mPosition;
	}

	public Ship getSelected() {
		return Selected;
	}
	

}
