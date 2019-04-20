package org.vin.apiTest;

public class RowBean {

	public String rowKey;

	public String columnFamily;

	public String column;

	public String value;


	public RowBean(String rowKey, String columnFamily, String column, String value) {
		this.rowKey = rowKey;
		this.columnFamily = columnFamily;
		this.column = column;
		this.value = value;
	}


	public RowBean() {
	}

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RowBean{" +
				       "rowKey='" + rowKey + '\'' +
				       ", columnFamily='" + columnFamily + '\'' +
				       ", column='" + column + '\'' +
				       ", value='" + value + '\'' +
				       '}';
	}
}
