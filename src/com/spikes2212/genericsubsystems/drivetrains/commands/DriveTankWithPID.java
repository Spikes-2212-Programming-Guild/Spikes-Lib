package com.spikes2212.genericsubsystems.drivetrains.commands;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class DriveTankWithPID extends PIDCommand {

	private TankDrivetrain tankDrivetrain;
	private static double KP = 1;
	private static double KI = 1;
	private static double KD = 1;
	private static double tolerance = 1;
	private PIDController leftMovmentControl;
	private PIDController rightMovmentControl;

	public static void setP(double P) {
		KP = P;
	}

	public static double getP() {
		return KP;
	}

	public static void setI(double I) {
		KI = I;
	}

	public static double getI() {
		return KI;
	}

	public static void setD(double D) {
		KD = D;
	}

	public static double getD() {
		return KD;
	}

	public static double getTolarance() {
		return tolerance;
	}

	public static void setTolarance(double tolarance) {
		DriveTankWithPID.tolerance = tolarance;
	}

	public DriveTankWithPID(double leftSetPoint, double rightSetPoint, TankDrivetrain drivetrain) {
		super(KP, KI, KD);
		requires(drivetrain);
		leftMovmentControl = new PIDController(KP, KI, KD, tankDrivetrain.getLeftPIDSource(), tankDrivetrain::setLeft);
		leftMovmentControl.setAbsoluteTolerance(tolerance);
		leftMovmentControl.setSetpoint(leftSetPoint);
		leftMovmentControl.setOutputRange(-1, 1);
		rightMovmentControl = new PIDController(KP, KI, KD, tankDrivetrain.getRightPIDSource(),
				tankDrivetrain::setRight);
		rightMovmentControl.setAbsoluteTolerance(tolerance);
		rightMovmentControl.setSetpoint(rightSetPoint);
		rightMovmentControl.setOutputRange(-1, 1);
	}

	public DriveTankWithPID(double setPoint, TankDrivetrain drivetrain) {
		this(setPoint, setPoint, drivetrain);
	}

	// requires(drivetrain);
	// this.tankDrivetrain = drivetrain;
	// this.setpoint = setpoint;
	// movmentControl = new PIDController(KP, KI, KD, PIDSource, PIDOutput);

	// Called just before this Command runs the first time
	protected void initialize() {
		leftMovmentControl.enable();
		rightMovmentControl.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return leftMovmentControl.onTarget() && rightMovmentControl.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		leftMovmentControl.disable();
		rightMovmentControl.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub

	}

}
