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
		Preconditions.requireNonEmpty(NON_EMPTY);
	}

	@Test
	public void givenRequireNonEmptyWhenEmptyShouldFailWithException() {
		try {
			Preconditions.requireNonEmpty(EMPTY);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNonEmptyWhenNullShouldFailWithException() {
		try {
			Preconditions.requireNonEmpty(null);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNonEmptyWithMessageWhenNonEmptyShouldSucceed() {
		Preconditions.requireNonEmpty(NON_EMPTY, A_MESSAGE);
	}

	@Test
	public void givenRequireNonEmptyWithMessageWhenEmptyShouldFailWithException() {
		try {
			Preconditions.requireNonEmpty(EMPTY, A_MESSAGE);
			fail();
		} catch (final IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));		}
	}

	@Test
	public void givenRequireNonEmptyWithMessageWhenNullShouldFailWithException() {
		try {
			Preconditions.requireNonEmpty(null, A_MESSAGE);
			fail();
		} catch (final IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(A_MESSAGE));
		}
	}
}
