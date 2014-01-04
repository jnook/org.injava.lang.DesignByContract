package org.injava.lang.designbycontract;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * Some tests for {@link Preconditions}.
 */
public class PreconditionsRequireNoNullElementsTest {

	private static final String NON_NULL = "ABC";

	@Test
	public void givenRequireNoNullElementsWhenEmptyShouldSucceed() {
		Preconditions.requireNoNullElements(new ArrayList<Object>());
	}

	@Test
	public void givenRequireNoNullElementsWhenNoNullElementsShouldSucceed() {
		Preconditions.requireNoNullElements(Arrays.asList(NON_NULL));
	}

	@Test
	public void givenRequireNoNullElementsWhenNullElementInCollectionShouldFailWithException() {
		try {
			final ArrayList<Object> list = new ArrayList<Object>();
			list.add(null);

			Preconditions.requireNoNullElements(list);
			fail();
		} catch (final IllegalArgumentException e) {
			assert true;
		}
	}
}
