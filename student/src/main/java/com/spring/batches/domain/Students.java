package com.spring.batches.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************************************************************
 * Class to BBSession tables values
 * @author RSHANMUGAM2:Apr 3, 2020: 12:13:49 PM
 **************************************************************************/
@Entity
@Table(name = "Students")
public class Students extends DomainObjects {

	private static final long serialVersionUID = -1230067626981632863L;
	
	@Id
	private int id;

	private Date startDt = null;
	private String rowCreator = null;
	private Date rowCreatedTime = null;
	private String rowModifier = null;
	private Date rowModifiedTime = null;

	/**************************************************************************
	 * @return the startDt
	 **************************************************************************/
	public int getId() {
		return id;
	}

	/**************************************************************************
	 * @param startDt the startDt to set
	 **************************************************************************/
	public void setId(int id ) {
		this.id = id;
	}
	
	/**************************************************************************
	 * @return the startDt
	 **************************************************************************/
	public Date getStartDt() {
		return startDt;
	}

	/**************************************************************************
	 * @param startDt the startDt to set
	 **************************************************************************/
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}


	/**************************************************************************
	 * @return the rowCreator
	 **************************************************************************/
	public String getRowCreator() {
		return rowCreator;
	}

	/**************************************************************************
	 * @param rowCreator the rowCreator to set
	 **************************************************************************/
	public void setRowCreator(String rowCreator) {
		this.rowCreator = rowCreator;
	}

	/**************************************************************************
	 * @return the rowCreatedTime
	 **************************************************************************/
	public Date getRowCreatedTime() {
		return rowCreatedTime;
	}

	/**************************************************************************
	 * @param rowCreatedTime the rowCreatedTime to set
	 **************************************************************************/
	public void setRowCreatedTime(Date rowCreatedTime) {
		this.rowCreatedTime = rowCreatedTime;
	}

	/**************************************************************************
	 * @return the rowModifier
	 **************************************************************************/
	public String getRowModifier() {
		return rowModifier;
	}

	/**************************************************************************
	 * @param rowModifier the rowModifier to set
	 **************************************************************************/
	public void setRowModifier(String rowModifier) {
		this.rowModifier = rowModifier;
	}

	/**************************************************************************
	 * @return the rowModifiedTime
	 **************************************************************************/
	public Date getRowModifiedTime() {
		return rowModifiedTime;
	}

	/**************************************************************************
	 * @param rowModifiedTime the rowModifiedTime to set
	 **************************************************************************/
	public void setRowModifiedTime(Date rowModifiedTime) {
		this.rowModifiedTime = rowModifiedTime;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(512);
		str.append("StartDt" + this.startDt)
			.append("RowCreator" + this.rowCreator)
			.append("RowCreatedTime" + this.rowCreatedTime)
			.append("RowModifier" + this.rowModifier)
			.append("RowModifiedTime" + this.rowModifiedTime);

		return str.toString();
	}
}