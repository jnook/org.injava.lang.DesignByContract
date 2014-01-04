package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireStateNonNullTest {

	private static final String REFERENCE = "";
	private static final String A_MESSAGE = "Custom message";

	@Test
	public void givenRequireNonNullWhenNonNullShouldSucceed() {
		Preconditions.requireStateNonNull(REFERENCE);
	}

	@Test
	public void givenRequireNonNullWhenFalseShouldFailWithException() {
		try {
			Preconditions.requireStateNonNull(null);
			fail();
		} catch (final IllegalStateException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNonNullWithMessageWhenTrueShouldSucceed() {
		Preconditions.requireStateNonNull(REFERENCE, A_MESSAGE);
	}

	@Test
	public void givenRequireNonNullWithMessageWhenFalseShouldFailWithException() {
		try {
			Preconditions.requireStateNonNull(null, A_MESSAGE);
			fail();
		} catch (final IllegalStateException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));
		}
	}

}
