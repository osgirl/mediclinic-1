package com.mediapp.web.common;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomTimeEditor extends CustomDateEditor {
	public CustomTimeEditor(DateFormat dateFormat, boolean allowEmpty) {
		super(dateFormat, allowEmpty);
		}

		public Object getValue() {
			if(super.getValue() != null){
				return new Time(((Date)super.getValue()).getTime());
			}else{
				return null;
			}
		}

}
