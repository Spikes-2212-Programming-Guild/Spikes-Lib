package com.spikes2212.genericsubsystems.drivetrains;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public abstract class OmniDrivetrain extends HolonomicDrivetrain {
	
	public abstract void setFront(double speedFront); //right is positive
	 
	public abstract void setRear(double speedRear); //right is positive
	
	public void driveSideways(double speedSideways){
		setFront(speedSideways);
		setRear(speedSideways);
	}
	
	public void turn(double speed){ //right is positive
		setRight(speed);
		setFront(-speed);
		setLeft(-speed);
		setRear(speed);
	}
    
	@Override
	public void holonomicDrive(double speedY, double speedX){
		tankDrive(speedY, speedY);
		driveSideways(speedX);
	}
	
	@Override
	public void stop(){
		super.stop();
		driveSideways(0);
	}
}

