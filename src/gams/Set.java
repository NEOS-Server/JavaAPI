/*
 * Copyright (c) 2017 NEOS-Server
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.neos.gams;

import java.util.ArrayList;
import java.util.List;

/**
 * Set data type. This structure does not check for duplicate insertion.
 * 
 * @author Thawan Kooburat
 * 
 */
public class Set extends BaseData {

	/*
	 * GAMS retain the order of element entered, so we have to retain this.
	 */
	List<String> values = new ArrayList<String>();

	public Set(String name, String description) {
		super(name, description);

	}

	public boolean addValue(String val) {
		return this.values.add(val);
	}

	public String getValue(int i) {
		return values.get(i);
	}

	public String toString() {
		if (values.size() == 0)
			return "";

		StringBuffer buff = new StringBuffer();
		buff.append(String.format("Set %s %s /", name, description));

		int i = 0;
		buff.append(values.get(0));

		for (i = 1; i < values.size(); i++) {
			buff.append(", " + values.get(i));
		}
		buff.append(" /;\n");
		return buff.toString();
	}
	public static void main(String[] args) {
		Set countryCode = new Set("cc", "Country Code");
		countryCode.addValue("UK");
		countryCode.addValue("US");
		countryCode.addValue("TH");
		System.out.println(countryCode);
		
		
	}

}
