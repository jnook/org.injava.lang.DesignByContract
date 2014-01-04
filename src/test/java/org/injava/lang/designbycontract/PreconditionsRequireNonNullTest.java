package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireNonNullTest {

	private static final String REFERENCE = "";
	private static final String A_MESSAGE = "Custom message";

	@Test
	public void givenRequireNonNullWhenNonNullShouldSucceed() {
		Preconditions.requireNonNull(REFERENCE);
	}

	@Test
	public void givenRequireNonNullWhenFalseShouldFailWithException() {
		try {
			Preconditions.requireNonNull(null);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNonNullWithMessageWhenTrueShouldSucceed() {
		Preconditions.requireNonNull(REFERENCE, A_MESSAGE);
	}

	@Test
	public void givenRequireNonNullWithMessageWhenFalseShouldFailWithException() {
		try {
			Preconditions.requireNonNull(null, A_MESSAGE);
			fail();
		} catch (final IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));
		}
	}

}
