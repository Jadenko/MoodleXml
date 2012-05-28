package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

public class CalculatedQuestionDataSetDefinition {
	
	private String status;
	private String name;
	private String type;
	private String distribution;
	private float min;
	private float max;
	private float decimals;
	private List<CalculatedQuestionDataSetItem> calculatedQuestionDataSetItemList;
	private int itemcount;
	private int numberOfItems;
	
	public CalculatedQuestionDataSetDefinition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	public float getDecimals() {
		return decimals;
	}
	public void setDecimals(float decimals) {
		this.decimals = decimals;
	}
	public List<CalculatedQuestionDataSetItem> getCalculatedQuestionDataSetItemList() {
		return calculatedQuestionDataSetItemList;
	}
	public void setCalculatedQuestionDataSetItemList(
			List<CalculatedQuestionDataSetItem> calculatedQuestionDataSetItemList) {
		this.calculatedQuestionDataSetItemList = calculatedQuestionDataSetItemList;
	}
	public int getItemcount() {
		return itemcount;
	}
	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
	
}
