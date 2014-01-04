package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireNoNullEntriesTest {

	private static final String NON_NULL = "ABC";

	@Test
	public void givenRequireNoNullEntriesWhenEmptyShouldSucceed() {
		Preconditions.requireNoNullEntries(new HashMap());
	}

	@Test
	public void givenRequireNoNullElementsWhenNoNullEntriesShouldSucceed() {
		final HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put(NON_NULL, NON_NULL);
		Preconditions.requireNoNullEntries(map);
	}

	@Test
	public void givenRequireNoNullEntriesWhenNullKeyExistsShouldFailWithException() {
		try {
			final HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(null, NON_NULL);

			Preconditions.requireNoNullEntries(map);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}

	@Test
	public void givenRequireNoNullEntriesWhenNullValueExistsShouldFailWithException() {
		try {
			final HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put(NON_NULL, null);

			Preconditions.requireNoNullEntries(map);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}
}
