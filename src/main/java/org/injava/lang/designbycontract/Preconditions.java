package org.injava.lang.designbycontract;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * A simple set of EIFFEL-inspired precondition checks for Java. 
 * <p>
 * <ul>
 * <li>
 * Design by Contract is described in
 * <em>Bertrand Meyer: "Object-Oriented Software Construction", 2nd edition, 1997.</em>
 * . Preconditions are only a small subset of the whole idea.</li>
 * <li>The {@link Preconditions#require(boolean)} methods have the same
 * signature as in the Scala base libraries.</li>
 * <li>{@link #requireNonNull(Object)} does not throw a
 * {@link NullPointerException} like {@link Objects#requireNonNull(Object)} in
 * Java 7 but an {@link IllegalArgumentException}.</li>
 * <li>{@link #requireState(boolean)} and the like are helpful when implementing
 * the Command-Query separation principle to indicate that a certain protocol is
 * expected. As example, querying the result of a command that was not executed
 * does not make sense and indicates a programmer error.</li>
 * </ul>
 * 
 * @author Jens Birger Hahn
 * @since 1
 */
public class Preconditions {

	private Preconditions() {
	}

	/**
	 * Require predicate is satisfied.
	 *
	 * @param predicate
	 *            the predicate that is required to be true.
	 * @throws IllegalArgumentException
	 *             if {@code predicate} is false
	 */
	public static void require(final boolean predicate)
			throws IllegalArgumentException {
		if (!predicate) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Require predicate is satisfied. If not, exception contains
	 * {@code message}
	 *
	 * @param predicate
	 *            the predicate that is required to be true.
	 * @param message
	 *            Message included in Exception if required condition is not
	 *            met.
	 * @throws IllegalArgumentException
	 *             if {@code predicate} is false
	 */
	public static void require(final boolean predicate, final String message)
			throws IllegalArgumentException {
		if (!predicate) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Object reference must be non {@code null}.
	 *
	 * @param reference
	 *            the reference expected to be not {@code null}
	 * @throws IllegalArgumentException
	 *             if {@code reference} is not {@code null}
	 */
	public static void requireNonNull(final Object reference)
			throws IllegalArgumentException {
		if (reference == null) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Object reference must be non {@code null}.
	 *
	 * @param reference
	 *            the reference expected to be not {@code null}.
	 * @param message
	 *            message if required condition is not met.
	 * @throws IllegalArgumentException
	 *             if {@code reference} is not {@code null}
	 */
	public static void requireNonNull(final Object reference,
			final String message) throws IllegalArgumentException {
		if (reference == null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * String must not be empty (implies {@link #requireNonNull(Object)}).
	 *
	 * @param reference
	 *            the {@code String} reference expected to be not {@code null}
	 *            or empty.
	 * @throws IllegalArgumentException
	 *             if {@code reference} is not {@code null}
	 */
	public static void requireNonEmptyString(final String reference)
			throws IllegalArgumentException {
		if (reference == null || reference.isEmpty()) {
			throw new IllegalArgumentException(reference);
		}
	}

	/**
	 * String must not be empty (implies {@link #requireNonNull(Object)}). If
	 * not, exception contains {@code message}.
	 *
	 * @param reference
	 *            the {@code String} reference expected to be not {@code null}
	 *            or empty.
	 * @param message
	 *            the message
	 * @throws IllegalArgumentException
	 */
	public static void requireNonEmptyString(final String reference,
			final String message) throws IllegalArgumentException {
		if (reference == null || reference.isEmpty()) {
			throw new IllegalArgumentException(message);
		}

	}

	/**
	 * No {@code null} elements in collection.
	 *
	 * @param collection
	 *            the collection that to check for undesired {@code null}
	 *            references.
	 */
	public static void requireNoNullElements(final Collection<?> collection) {
		requireNonNull(collection);
		final Iterator<?> it = collection.iterator();
		while (it.hasNext()) {
			final Object object = it.next();
			requireNonNull(object);
		}
	}

	/**
	 * Predicate (on object state) must be fulfilled.
	 *
	 * @param predicate
	 *            The predicate that is required to be true.
	 * @throws IllegalStateException
	 *             if {@code predicate} is false
	 */
	public static void requireState(final boolean predicate)
			throws IllegalStateException {
		if (!predicate) {
			throw new IllegalStateException();
		}
	}

	/**
	 * Predicate (on object state) must be fulfilled. If not, exception contains
	 * {@code message}.
	 *
	 * @param predicate
	 *            The predicate that is required to be true.
	 * @param message
	 *            Message included in Exception if required condition is not
	 *            met, must not be {@code null}.
	 * @throws IllegalStateException
	 *             if {@code predicate} is false
	 *
	 */
	public static void requireState(final boolean predicate,
			final String message) throws IllegalStateException {
		requireNonNull(message);
		if (!predicate) {
			throw new IllegalStateException(message);
		}
	}

	/**
	 * Object reference (usually a field in the object) must be non {@code null}
	 * .
	 *
	 * @param reference
	 *            the reference expected to be not {@code null}
	 * @throws IllegalStateException
	 *             if {@code predicate} is false
	 */
	public static void requireStateNonNull(final Object reference)
			throws IllegalStateException {
		if (reference == null) {
			throw new IllegalStateException();
		}
	}

	/**
	 * Object reference (usually a field in the object) must be non {@code null}
	 * . If not, exception contains {@code message}.
	 *
	 * @param reference
	 *            the reference expected to be not {@code null}
	 * @param message
	 *            Message included in Exception if required condition is not
	 *            met.
	 * @throws IllegalStateException
	 *             if {@code predicate} is false
	 */
	public static void requireStateNonNull(final Object reference,
			final String message) throws IllegalStateException {
		if (reference == null) {
			throw new IllegalStateException(message);
		}
	}

}
