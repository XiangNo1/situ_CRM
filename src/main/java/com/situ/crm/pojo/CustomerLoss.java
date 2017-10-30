package com.situ.crm.pojo;

import java.util.Date;

public class CustomerLoss {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.customer_no
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String customerNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.customer_name
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String customerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.customer_manager
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String customerManager;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.last_order_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private Date lastOrderTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.confirm_loss_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private Date confirmLossTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.status
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_loss.loss_reason
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String lossReason;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.id
     *
     * @return the value of customer_loss.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.id
     *
     * @param id the value for customer_loss.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.customer_no
     *
     * @return the value of customer_loss.customer_no
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.customer_no
     *
     * @param customerNo the value for customer_loss.customer_no
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.customer_name
     *
     * @return the value of customer_loss.customer_name
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.customer_name
     *
     * @param customerName the value for customer_loss.customer_name
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.customer_manager
     *
     * @return the value of customer_loss.customer_manager
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getCustomerManager() {
        return customerManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.customer_manager
     *
     * @param customerManager the value for customer_loss.customer_manager
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager == null ? null : customerManager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.last_order_time
     *
     * @return the value of customer_loss.last_order_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.last_order_time
     *
     * @param lastOrderTime the value for customer_loss.last_order_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.confirm_loss_time
     *
     * @return the value of customer_loss.confirm_loss_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Date getConfirmLossTime() {
        return confirmLossTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.confirm_loss_time
     *
     * @param confirmLossTime the value for customer_loss.confirm_loss_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setConfirmLossTime(Date confirmLossTime) {
        this.confirmLossTime = confirmLossTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.status
     *
     * @return the value of customer_loss.status
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.status
     *
     * @param status the value for customer_loss.status
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_loss.loss_reason
     *
     * @return the value of customer_loss.loss_reason
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getLossReason() {
        return lossReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_loss.loss_reason
     *
     * @param lossReason the value for customer_loss.loss_reason
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setLossReason(String lossReason) {
        this.lossReason = lossReason == null ? null : lossReason.trim();
    }
}