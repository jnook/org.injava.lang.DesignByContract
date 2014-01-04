package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireTest {

	private static final String A_MESSAGE = "Custom message";

	@Test
	public void givenRequireWhenTrueShouldSucceed() {
		Preconditions.require(true);
	}

	@Test
	public void givenRequireWhenFalseShouldFailWithException() {
		try {
			Preconditions.require(false);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireWithMessageWhenTrueShouldSucceed() {
		Preconditions.require(true, A_MESSAGE);
	}

	@Test
	public void givenRequireWithMessageWhenFalseShouldFailWithException() {
		try {
			Preconditions.require(false, A_MESSAGE);
			fail();
		} catch (final IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));
		}
	}

}
