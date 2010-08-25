/*
 * Encog(tm) Core v2.5 
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 * 
 * Copyright 2008-2010 by Heaton Research Inc.
 * 
 * Released under the LGPL.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 * 
 * Encog and Heaton Research are Trademarks of Heaton Research, Inc.
 * For information on Heaton Research trademarks, visit:
 * 
 * http://www.heatonresearch.com/copyright.html
 */

package org.encog.neural.activation;

import org.encog.engine.network.flat.ActivationFunctions;
import org.encog.engine.util.BoundMath;
import org.encog.persist.Persistor;

/**
 * The softmax activation function.
 * 
 * @author jheaton
 */
public class ActivationSoftMax extends BasicActivationFunction implements
		ActivationFunction {

	/**
	 * The serial id.
	 */
	private static final long serialVersionUID = -960489243250457611L;

	/**
	 * Implements the activation function. The array is modified according to
	 * the activation function being used. See the class description for more
	 * specific information on this type of activation function.
	 * 
	 * @param d
	 *            The input array to the activation function.
	 */
	public void activationFunction(final double[] d) {

		double sum = 0;
		for (int i = 0; i < d.length; i++) {
			d[i] = BoundMath.exp(d[i]);
			sum += d[i];
		}
		for (int i = 0; i < d.length; i++) {
			d[i] = d[i] / sum;
		}
	}

	/**
	 * @return The object cloned;
	 */
	@Override
	public Object clone() {
		return new ActivationSoftMax();
	}

	/**
	 * Implements the activation function derivative. The array is modified
	 * according derivative of the activation function being used. See the class
	 * description for more specific information on this type of activation
	 * function. Propagation training requires the derivative. Some activation
	 * functions do not support a derivative and will throw an error.
	 * 
	 * @param d
	 *            The input array to the activation function.
	 */
	public double derivativeFunction(final double d) {
		return 1;
	}

	/**
	 * @return Return false, softmax has no derivative.
	 */
	public boolean hasDerivative() {
		return true;
	}
	
	/**
	 * @return The paramater names for this activation function.
	 * This activation function type has no paramaters, so this method
	 * returns an empty string.
	 */
	@Override
	public String[] getParamNames() {
		return new String[0];
	}
	
	/**
	 * @return The Encog Engine ID for this activation type, or -1 if not
	 *         defined by the Encog engine.
	 */
	@Override
	public int getEngineID() {
		// TODO Auto-generated method stub
		return ActivationFunctions.ACTIVATION_SOFTMAX;
	}

}
