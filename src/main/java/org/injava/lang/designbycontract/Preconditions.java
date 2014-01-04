package org.injava.lang.designbycontract;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * EIFFEL-inspired Precondition checks for Java.
 * <p>
 * Notes:
 * <ul>
 * <li>{@link #requireNonNull(Object)} does not throw a
 * {@link NullPointerException} like {@link Objects#requireNonNull(Object)} in
 * Java 7 but an {@link IllegalArgumentException}. Just using
 * {@link IllegalArgumentException} for all illegal arguments was most rewarding
 * in the past, especially during unit-testing. I leave NPEs for undetected
 * {@code null}s in the runtime or system libraries.</li>
 * <li>{@link #requireState(boolean)} is helpful when implementing the
 * Command-Query separation principle to convey meaning.</li>
 * </ul>
 * <p>
 * I rewrote the code to be Java SE 1.2 compatible for the following reasons:
 * <ul>
 * <li>I may use some older tools like GCJ for little Unix tools which produces
 * nice little tools with native-like ramp-up time, but is not quite up-to-date.
 * </li>
 * <li>Features of newer Java versions are (currently) not required.</li>
 * <li>It is an example where production code is for a different JVM than
 * unit-test code (which uses annotations and JUnit 4).
 * </ul>
 * <p>
 * <h1>Background</h1>
 * <p>
 * Although we cannot implement Design by Contract as elegant as in EIFFEL,
 * these little statements helped me a lot to implement components and systems
 * based on the ideas of Bertrand Meyer, especially using design by contract and
 * the principles of class design.
 * <p>
 * In practice, lots of preconditions might really be invariants. Invariants are
 * both pre- and postconditions but it would require the help of the language
 * implementors to use invariants in a really useful way (I know about
 * approaches using aspects or annotations with runtime checks but this
 *
 * <p>
 *
 * @author Jens Birger Hahn
 * @version 1.0
 *
 */
public class Preconditions {
	private static final String NULL_REFERENCE_NOT_ALLOWED = "Precondition violation: Null reference not allowed.";
	private static final String PREDICATE_EVALUATED_TO_FALSE = "Precondition violation: Predicate evaluated to false.";
	private static final String STRING_MUST_NOT_BE_EMPTY = "Precondition violation: String must not be empty.";

	private static final String STATE_NULL_REFERENCE_NOT_ALLOWED = "State precondition violation: Reference must not be null.";
	private static final String STATE_PREDICATE_EVALUATED_TO_FALSE = "State precondition violation: Predicate evaluated to false.";

	/**
	 * Object reference must be non {@code null}.
	 *
	 * @param reference
	 *            the reference
	 * @throws IllegalArgumentException
	 */
	public static void requireNonNull(final Object reference) throws IllegalArgumentException {
		if (reference == null) {
			throw new IllegalArgumentException(NULL_REFERENCE_NOT_ALLOWED);
		}
	}

	/**
	 * Object reference must be non {@code null}.
	 *
	 * @param reference
	 *            the reference to be checked
	 * @param message
	 *            Message included in Exception if required condition is not met.
	 * @throws IllegalArgumentException
	 */
	public static void requireNonNull(final Object reference, final String message) throws IllegalArgumentException {
		if (reference == null) {
			throw new IllegalArgumentException(NULL_REFERENCE_NOT_ALLOWED + withMessage(message));
		}
	}

	/**
	 * Require predicate is satisfied.
	 *
	 * @param predicate
	 *            The predicate that is required to be true.
	 * @throws IllegalArgumentException
	 */
	public static void require(final boolean predicate) throws IllegalArgumentException {
		if (!predicate) {
			throw new IllegalArgumentException(PREDICATE_EVALUATED_TO_FALSE);
		}
	}

	/**
	 * Require predicate is satisfied. If not, exception contains
	 * {@code message}
	 *
	 * @param predicate
	 *            The predicate that is required to be true.
	 * @param message
	 *            Message included in Exception if required condition is not met.
	 * @throws IllegalArgumentException
	 */
	public static void require(final boolean predicate, final String message) throws IllegalArgumentException {
		if (!predicate) {
			throw new IllegalArgumentException(PREDICATE_EVALUATED_TO_FALSE + withMessage(message));
		}
	}

	/**
	 * String must not be empty (implies {@link #requireNonNull(Object)}).
	 *
	 * @param anObject
	 *            the an object
	 * @throws IllegalStateException
	 */
	public static void requireNonEmpty(final String anObject) throws IllegalArgumentException {
		requireNonNull(anObject);
		if (anObject.isEmpty()) {
			throw new IllegalArgumentException(STRING_MUST_NOT_BE_EMPTY);
		}
	}

	/**
	 * String must not be empty (implies {@link #requireNonNull(Object)}). If
	 * not, exception contains {@code message}
	 *
	 * @param aString
	 *            the string reference
	 * @param message
	 *            the message
	 * @throws IllegalArgumentException
	 */
	public static void requireNonEmpty(final String aString, final String message) throws IllegalArgumentException {
		requireNonNull(aString, message);
		if (aString.isEmpty()) {
			throw new IllegalArgumentException(STRING_MUST_NOT_BE_EMPTY + withMessage(message));
		}
	}

	/**
	 * Predicate (on object state) must be fulfilled.
	 *
	 * @param predicate
	 *            The predicate that is required to be true.
	 * @throws IllegalStateException
	 *             the illegal state exception
	 */
	public static void requireState(final boolean predicate) throws IllegalStateException {
		if (!predicate) {
			throw new IllegalStateException(STATE_PREDICATE_EVALUATED_TO_FALSE);
		}
	}

	/**
	 * Predicate (on object state) must be fulfilled. If not, exception contains
	 * {@code message}.
	 *
	 * @param predicate
	 *            The predicate that is required to be true.
	 * @param message
	 *            Message included in Exception if required condition is not met.
	 * @throws IllegalStateException
	 *
	 */
	public static void requireState(final boolean predicate, final String message) throws IllegalStateException {
		if (!predicate) {
			throw new IllegalStateException(STATE_PREDICATE_EVALUATED_TO_FALSE + withMessage(message));
		}
	}

	/**
	 * Object reference (usually a field in the object) must be non {@code null}
	 * .
	 *
	 * @param reference
	 *            The reference to be checked.
	 * @throws IllegalStateException
	 */
	public static void requireStateNonNull(final Object reference) throws IllegalStateException {
		if (reference == null) {
			throw new IllegalStateException(STATE_NULL_REFERENCE_NOT_ALLOWED);
		}
	}

	/**
	 * Object reference (usually a field in the object) must be non {@code null}
	 * . If not, exception contains {@code message}
	 *
	 * @param reference
	 *            The reference to be checked.
	 * @param message
	 *            Message included in Exception if required condition is not met.
	 * @throws IllegalStateException
	 */
	public static void requireStateNonNull(final Object reference, final String message) throws IllegalStateException {
		if (reference == null) {
			throw new IllegalStateException(STATE_NULL_REFERENCE_NOT_ALLOWED + withMessage(message));
		}
	}

	/**
	 * Precondition: No {@code null} elements in collection.
	 *
	 * @param collection
	 *            the collection that to check for undesired {@code null}
	 *            references.
	 */
	public static void requireNoNullElements(final Collection collection) {
		requireNonNull(collection);
		final Iterator it = collection.iterator();
		while (it.hasNext()) {
			final Object object = it.next();
			requireNonNull(object);
		}
	}

	/**
	 * Require: No {@code null} entries in map.
	 * <p>
	 * <ul>
	 * <li>Special null key is rejected.</li>
	 * <li>Null values are rejected</li>
	 * </ul>
	 * <p>
	 * <h1>Implementation details</h1>
	 * <p>
	 * This method iterates over the key set and requests each value. Some
	 * people insist on using {@code Map.Entry} but to me this is an
	 * optimization rarely required.
	 *
	 * @param map
	 *            the map that to check for undesired {@code null} references.
	 */
	public static void requireNoNullEntries(final Map map) {
		requireNonNull(map);

		final Set keySet = map.keySet();
		final Iterator it = keySet.iterator();

		while (it.hasNext()) {
			Object key = it.next();
			requireNonNull(key);
			requireNonNull(map.get(key));
		}
	}

	/**
	 * Format user-provided message - simply wrap message in braces. Note
	 * StringBuilder is not used because it was only introduced with Java SE 1.5
	 * . Possible performance loss is tolerated.
	 */
	private static String withMessage(final String message) {
		return " (" + message + ")";
	}
}
