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
 * Parameter data type. To use this for more than 1 dimension parameter, concatenate key using "."
 * Use method toString() to create string for including into the model.
 * @author Thawan Kooburat
 *
 */
public class Parameter extends BaseData {

	int dimension;
	List<Entry> values = new ArrayList<Entry>();

	public Parameter(String name, String description) {
		super(name, description);

	}

	public boolean add(String key, String value) {
		return values.add(new Entry(key, value));
	}
		
	public String toString() {
		if (values.size() == 0)
			return "";

		StringBuffer buff = new StringBuffer();
		buff.append(String.format("Parameter %s %s /\n", name, description));

		for (int i = 0; i < values.size(); i++) {
			buff.append(String.format("%s %s\n", values.get(i).key,
					values.get(i).value));
		}
		buff.append(" /;\n");
		return buff.toString();
	}

	class Entry {
		String key;
		String value;

		Entry(String key, String val) {
			this.key = key;
			this.value = val;
		}
	}
	
	
	public static void main(String[] args) {
		Parameter capital = new Parameter("cap(c)", "Capital of");
		capital.add("TH", "Bangkok");
		capital.add("US", "Washington D.C");
		capital.add("UK", "London");
		System.out.println(capital);
	}

}
