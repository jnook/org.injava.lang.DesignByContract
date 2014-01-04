package org.injava.lang.designbycontract;

import org.junit.Test;

/**
 * I really hate writing tests for tools, but Emma does not exclude unused empty
 * (even private) constructors. I really want those 100% coverage today :).
 */
public class __PreconditionsFixCoverageTest {

	@Test
	public void creatingAPreconditionsObjectMakesNoSenseButDoesNoHarm() {
		new Preconditions();
	}

}
