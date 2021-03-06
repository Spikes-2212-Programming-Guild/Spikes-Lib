package com.spikes2212.command.genericsubsystem.utils.limitationFunctions;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.spikes2212.command.genericsubsystem.GenericSubsystem;

/**
 * This is a {@link Predicate<Double>}. An instance of this class can be used as
 * the canMove condition in the constructor of a {@link GenericSubsystem} that can
 * move forward endlessly and backwards until reaching a limit.
 * 
 * @author Tuval
 *
 * @see Predicate
 */
public class MinLimit implements Predicate<Double> {

	private final Supplier<Boolean> limit;

	/**
	 * Constructs a min limit Predicate using a boolean suppliers.
	 * 
	 * @param limit
	 *            The limit, negative speed makes the {@link GenericSubsystem} move
	 *            towards this limit.
	 */
	public MinLimit(Supplier<Boolean> limit) {
		this.limit = limit;
	}

	/**
	 * This method checks if the genericSubsystem can move.<br>
	 * When a negative speed is given - it checks if the min limit is reached.
	 * 
	 * @param speed
	 *            The speed the {@link GenericSubsystem} tries to move at.
	 * @return True if the subsystem does not try to move out of the limit.
	 * 
	 */
	@Override
	public boolean test(Double speed) {
		if (limit.get() && speed < 0)
			return false;
		return true;
	}
}
