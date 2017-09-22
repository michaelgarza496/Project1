package com.revature.pojos;

import java.io.InputStream;
import java.sql.Blob;

public class Reimbursement {
	
	//STATE
	private int reimbursementId;
	private int statusId;
	private String status;
	private int typeId;
	private String type;
	private double amount;
	private String timeSubmitted;
	private String resolved;
	private int authorId;
	private String author;
	private int resolverId;
	private String resolver;
	private String description;
	private Blob receipt;
	private InputStream inputStream;
	private byte[] receiptData;
	



	public Reimbursement(int reimbursementId) {
		super();
		this.reimbursementId = reimbursementId;
	}

	public Reimbursement(byte[] receiptData) {
		super();
		this.receiptData = receiptData;
	}

	public byte[] getReceiptData() {
		return receiptData;
	}

	public void setReceiptData(byte[] receiptData) {
		this.receiptData = receiptData;
	}

	//CONSTRUCTORS
	public Reimbursement() {}
	
	public Reimbursement(int statusId, int typeId, double amount, int authorId, String description) {
		this.statusId = statusId;
		this.typeId = typeId;
		this.amount = amount;
		this.authorId = authorId;
		this.description = description;
	}
	public Reimbursement(int reimbursementId, int statusId, String status, int typeId, String type, double amount,
			String timeSubmitted, String resolved, int authorId, String author, int resolverId, String resolver,
			String description) {
		this.reimbursementId = reimbursementId;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.author = author;
		this.resolverId = resolverId;
		this.resolver = resolver;
		this.description = description;
	}
	
	
	//image constructor
	public Reimbursement(int reimbursementId, int statusId, String status, int typeId, String type, double amount,
			String timeSubmitted, String resolved, int authorId, String author, int resolverId, String resolver,
			String description, Blob receipt) {
		super();
		this.reimbursementId = reimbursementId;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.author = author;
		this.resolverId = resolverId;
		this.resolver = resolver;
		this.description = description;
		this.receipt = receipt;
	}
	
	public Reimbursement(int reimbursementId, int statusId, String status, int typeId, String type, double amount,
			String timeSubmitted, String resolved, int authorId, String author, int resolverId, String resolver,
			String description, Blob receipt, InputStream inputStream) {
		super();
		this.reimbursementId = reimbursementId;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.author = author;
		this.resolverId = resolverId;
		this.resolver = resolver;
		this.description = description;
		this.receipt = receipt;
		this.inputStream = inputStream;
	}
	
	
	
	
	//GETTERS AND SETTERS
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	//toString()
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", statusId=" + statusId + ", status=" + status
				+ ", typeId=" + typeId + ", type=" + type + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted
				+ ", resolved=" + resolved + ", authorId=" + authorId + ", author=" + author + ", resolverId="
				+ resolverId + ", resolver=" + resolver + ", description=" + description + ", receipt=" + receipt + "]";
	}


}
