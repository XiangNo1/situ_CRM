package com.situ.crm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerService {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.service_type
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String serviceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.overview
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String overview;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.customer
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String customer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.status
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.service_request
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String serviceRequest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.create_people
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String createPeople;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.create_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.assigner
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String assigner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.assign_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date assignTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.service_deal
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String serviceDeal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.service_deal_people
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String serviceDealPeople;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.service_deal_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date serviceDealTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.service_deal_result
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String serviceDealResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_service.satisfy
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String satisfy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.id
     *
     * @return the value of customer_service.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.id
     *
     * @param id the value for customer_service.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.service_type
     *
     * @return the value of customer_service.service_type
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.service_type
     *
     * @param serviceType the value for customer_service.service_type
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.overview
     *
     * @return the value of customer_service.overview
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getOverview() {
        return overview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.overview
     *
     * @param overview the value for customer_service.overview
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.customer
     *
     * @return the value of customer_service.customer
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.customer
     *
     * @param customer the value for customer_service.customer
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.status
     *
     * @return the value of customer_service.status
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.status
     *
     * @param status the value for customer_service.status
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.service_request
     *
     * @return the value of customer_service.service_request
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getServiceRequest() {
        return serviceRequest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.service_request
     *
     * @param serviceRequest the value for customer_service.service_request
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setServiceRequest(String serviceRequest) {
        this.serviceRequest = serviceRequest == null ? null : serviceRequest.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.create_people
     *
     * @return the value of customer_service.create_people
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getCreatePeople() {
        return createPeople;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.create_people
     *
     * @param createPeople the value for customer_service.create_people
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople == null ? null : createPeople.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.create_time
     *
     * @return the value of customer_service.create_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.create_time
     *
     * @param createTime the value for customer_service.create_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.assigner
     *
     * @return the value of customer_service.assigner
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getAssigner() {
        return assigner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.assigner
     *
     * @param assigner the value for customer_service.assigner
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setAssigner(String assigner) {
        this.assigner = assigner == null ? null : assigner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.assign_time
     *
     * @return the value of customer_service.assign_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Date getAssignTime() {
        return assignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.assign_time
     *
     * @param assignTime the value for customer_service.assign_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.service_deal
     *
     * @return the value of customer_service.service_deal
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getServiceDeal() {
        return serviceDeal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.service_deal
     *
     * @param serviceDeal the value for customer_service.service_deal
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setServiceDeal(String serviceDeal) {
        this.serviceDeal = serviceDeal == null ? null : serviceDeal.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.service_deal_people
     *
     * @return the value of customer_service.service_deal_people
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getServiceDealPeople() {
        return serviceDealPeople;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.service_deal_people
     *
     * @param serviceDealPeople the value for customer_service.service_deal_people
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setServiceDealPeople(String serviceDealPeople) {
        this.serviceDealPeople = serviceDealPeople == null ? null : serviceDealPeople.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.service_deal_time
     *
     * @return the value of customer_service.service_deal_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Date getServiceDealTime() {
        return serviceDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.service_deal_time
     *
     * @param serviceDealTime the value for customer_service.service_deal_time
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setServiceDealTime(Date serviceDealTime) {
        this.serviceDealTime = serviceDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.service_deal_result
     *
     * @return the value of customer_service.service_deal_result
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getServiceDealResult() {
        return serviceDealResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.service_deal_result
     *
     * @param serviceDealResult the value for customer_service.service_deal_result
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setServiceDealResult(String serviceDealResult) {
        this.serviceDealResult = serviceDealResult == null ? null : serviceDealResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_service.satisfy
     *
     * @return the value of customer_service.satisfy
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getSatisfy() {
        return satisfy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_service.satisfy
     *
     * @param satisfy the value for customer_service.satisfy
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setSatisfy(String satisfy) {
        this.satisfy = satisfy == null ? null : satisfy.trim();
    }
}