/**
 * @author verphen
 * @date 2015年6月6日  上午11:24:44
 */

package cn.effine;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ForeachTest {
	enum face {
		one, two, three, foure, five, six
	};

	public static void main(String[] args) {

		Collection<face> faces = Arrays.asList(face.values());
		for (Iterator<face> i = faces.iterator(); i.hasNext();) {
			for (Iterator<face> j = faces.iterator(); j.hasNext();) {
				System.err.println(i.next() + "-----"+j.next());
			}
		}

	}
}
