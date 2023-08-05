package main.java.employee;

public class Query {
	    private boolean selectAll;
	    private boolean selectID;
	    private boolean selectName;
	    private boolean selectSalary;
	    private String columnName;
	    private String operator;
	    private String literalValue;
	    private String orderByColumn;
	    
	    
	    
		public Query() {
			super();
			this.selectAll = selectAll;
			this.selectID = selectID;
			this.selectName = selectName;
			this.selectSalary = selectSalary;
			this.columnName = columnName;
			this.operator = operator;
			this.literalValue = literalValue;
			this.orderByColumn = orderByColumn;
		}
		
		public boolean isSelectAll() {
			return selectAll;
		}
		public void setSelectAll(boolean selectAll) {
			this.selectAll = selectAll;
		}
		public boolean isSelectID() {
			return selectID;
		}
		public void setSelectID(boolean selectID) {
			this.selectID = selectID;
		}
		public boolean isSelectName() {
			return selectName;
		}
		public void setSelectName(boolean selectName) {
			this.selectName = selectName;
		}
		public boolean isSelectSalary() {
			return selectSalary;
		}
		public void setSelectSalary(boolean selectSalary) {
			this.selectSalary = selectSalary;
		}
		public String getColumnName() {
			return columnName;
		}
		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
		public String getLiteralValue() {
			return literalValue;
		}
		public void setLiteralValue(String literalValue) {
			this.literalValue = literalValue;
		}
		public String getOrderByColumn() {
			return orderByColumn;
		}
		public void setOrderByColumn(String orderByColumn) {
			this.orderByColumn = orderByColumn;
		}


}
