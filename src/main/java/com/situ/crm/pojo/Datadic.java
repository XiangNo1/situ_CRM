package com.situ.crm.pojo;

public class DataDic {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_dic.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_dic.data_dic_name
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String dataDicName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_dic.data_dic_value
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    private String dataDicValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_dic.id
     *
     * @return the value of data_dic.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_dic.id
     *
     * @param id the value for data_dic.id
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_dic.data_dic_name
     *
     * @return the value of data_dic.data_dic_name
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getDataDicName() {
        return dataDicName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_dic.data_dic_name
     *
     * @param dataDicName the value for data_dic.data_dic_name
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setDataDicName(String dataDicName) {
        this.dataDicName = dataDicName == null ? null : dataDicName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_dic.data_dic_value
     *
     * @return the value of data_dic.data_dic_value
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public String getDataDicValue() {
        return dataDicValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_dic.data_dic_value
     *
     * @param dataDicValue the value for data_dic.data_dic_value
     *
     * @mbggenerated Mon Oct 30 18:56:18 CST 2017
     */
    public void setDataDicValue(String dataDicValue) {
        this.dataDicValue = dataDicValue == null ? null : dataDicValue.trim();
    }
}