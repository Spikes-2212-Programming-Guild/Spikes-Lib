package com.spikes2212.dashboard;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ConstantHandler {
	public static Supplier<Double> addConstantDouble(String name, double value) {
		SmartDashboard.putNumber(name, value);
		return () -> SmartDashboard.getNumber(name,0);
	}

	public static Supplier<Integer> addConstantInt(String name, int value) {
		SmartDashboard.putNumber(name, value);
		return () -> (int) SmartDashboard.getNumber(name, 0);
	}
	public static Supplier<String> addConstantString(String name, String value) {
		SmartDashboard.putString(name, value);
		return () -> SmartDashboard.getString(name, "");
	}

}
