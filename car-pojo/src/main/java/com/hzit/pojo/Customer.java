package com.hzit.pojo;

import java.util.Date;

public class Customer {
    private Integer customerId;//客户编号
    private String customerSex;//客户性别
    private String customerName;//客户姓名
    private Integer companyId;//公司编号
    private String customerPhone;//客户电话
    private String customerType;//客户类型（1：个人、2：公司）
    private java.util.Date customerCreateTime;//创建时间
    private java.util.Date customerBirthday;//客户生日

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Date getCustomerCreateTime() {
        return customerCreateTime;
    }

    public void setCustomerCreateTime(Date customerCreateTime) {
        this.customerCreateTime = customerCreateTime;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }
}
