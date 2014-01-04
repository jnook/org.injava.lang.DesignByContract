package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireStateTest {

	private static final String A_MESSAGE = "Custom message";

	@Test
	public void givenRequireStateWhenTrueShouldSucceed() {
		Preconditions.requireState(true);
	}

	@Test
	public void givenRequireStateWhenFalseShouldFailWithException() {
		try {
			Preconditions.requireState(false);
			fail();
		} catch (final IllegalStateException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireStateWithMessageWhenTrueShouldSucceed() {
		Preconditions.requireState(true, A_MESSAGE);
	}

	@Test
	public void givenRequireStateWithMessageWhenFalseShouldFailWithException() {
		try {
			Preconditions.requireState(false, A_MESSAGE);
			fail();
		} catch (final IllegalStateException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));
		}
	}

}
