package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireNonEmptyTest {

	private static final String EMPTY = "";
	private static final String NON_EMPTY = "ABC";
	private static final String A_MESSAGE = "Custom message";

	@Test
	public void givenRequireNonEmptyWhenNonEmptyShouldSucceed() {
		Preconditions.requireNonEmptyString(NON_EMPTY);
	}

	@Test
	public void givenRequireNonEmptyWhenEmptyShouldFailWithException() {
		try {
			Preconditions.requireNonEmptyString(EMPTY);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNonEmptyWhenNullShouldFailWithException() {
		try {
			Preconditions.requireNonEmptyString(null);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNonEmptyWithMessageWhenNonEmptyShouldSucceed() {
		Preconditions.requireNonEmptyString(NON_EMPTY, A_MESSAGE);
	}

	@Test
	public void givenRequireNonEmptyWithMessageWhenEmptyShouldFailWithException() {
		try {
			Preconditions.requireNonEmptyString(EMPTY, A_MESSAGE);
			fail();
		} catch (final IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));		}
	}

	@Test
	public void givenRequireNonEmptyWithMessageWhenNullShouldFailWithException() {
		try {
			Preconditions.requireNonEmptyString(null, A_MESSAGE);
			fail();
		} catch (final IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));
		}
	}
}
