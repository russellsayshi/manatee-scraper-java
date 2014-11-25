package com.quickhac.common.data;

import com.quickhac.common.util.Numeric;

public class Assignment {
	
	public String id;
	public String title;
	public String dateAssigned;
	public String dateDue;
	public GradeValue ptsEarned; // this should always be represented using a double
	public double ptsPossible;
	public double weight;
	public String note;
	public boolean extraCredit;
	
	public String pointsString() {
		if ( ptsEarned == null || ptsEarned.value == -1)
			return "-";
		// letter grades + weighted/non-100 = ????
		// don't even bother handling that case
		if (ptsEarned.type == GradeValue.TYPE_LETTER)
			return ptsEarned.toString();
		
		final StringBuilder pts = new StringBuilder();
		//Account for when ptsPossible is not 100
		pts.append(Numeric.doubleToPrettyString(Math.round(ptsEarned.value_d*(ptsPossible/100))));
		if (ptsPossible != 100)
			pts.append("/" + Numeric.doubleToPrettyString(ptsPossible));
		
		if(weight != 1.0)
			pts.append("\u00D7" + Numeric.doubleToPrettyString(weight));
		
		return pts.toString();
	}

}
