package cn.gori.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ma
 * @since 2018-12-26
 */
public class MonitorData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 保税局名称
     */
    private String orgName;

    /**
     * 监测日期
     */
    private String monitorDate;

    /**
     * 产品全名称
     */
    private String procductName;

    /**
     * 产品公共名称
     */
    private String productCommName;

    /**
     * 产品类别
     */
    private String productCategory;

    /**
     * 产品品牌
     */
    private String productBrand;

    /**
     * 产品规格
     */
    private String productSpecfication;

    /**
     * 生产国
     */
    private String producingCountry;

    /**
     * 贸易国
     */
    private String tradeCountry;

    /**
     * 采样渠道
     */
    private String samplingChannel;

    /**
     * 线下采样地
     */
    private String offlineSamplingPlace;

    /**
     * 线下销售公司
     */
    private String offlineSaleBody;

    /**
     * 线上销售平台
     */
    private String onlineEcPlatform;

    /**
     * 线上商店名称
     */
    private String onlineStoreName;

    /**
     * 线上投递类型
     */
    private String onlineDeliverMode;

    /**
     * 监测条目数量
     */
    private String monitorItemCount;

    /**
     * 检测结果
     */
    private String testingResult;

    /**
     * 取消原因1
     */
    private String disqualReason1;

    /**
     * 取消原因2
     */
    private String disqualReason2;

    /**
     * 取消条目
     */
    private String disqualItem;

    /**
     * 取消明细
     */
    private String disqualDetail;

    /**
     * 执行标准
     */
    private String disqualJudgeBasis;

    /**
     * 反馈原因
     */
    private String disqualHandleMeasure;

    /**
     * 检测单位
     */
    private String testingOrg;

    private String remark;

    private String disqualItem1;

    private String disqualItem2;

    private String disqualItem3;

    private String disqualItem4;

    private String disqualItem5;

    /**
     * 一带一路沿线国 1 是，0 不是
     */
    private String starCountry;

    /**
     * 导入数据的标识  第 x 次导入 以便有脏数据时清除本次导入
     */
    private Integer dataSign;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(String monitorDate) {
        this.monitorDate = monitorDate;
    }

    public String getProcductName() {
        return procductName;
    }

    public void setProcductName(String procductName) {
        this.procductName = procductName;
    }

    public String getProductCommName() {
        return productCommName;
    }

    public void setProductCommName(String productCommName) {
        this.productCommName = productCommName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductSpecfication() {
        return productSpecfication;
    }

    public void setProductSpecfication(String productSpecfication) {
        this.productSpecfication = productSpecfication;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public String getTradeCountry() {
        return tradeCountry;
    }

    public void setTradeCountry(String tradeCountry) {
        this.tradeCountry = tradeCountry;
    }

    public String getSamplingChannel() {
        return samplingChannel;
    }

    public void setSamplingChannel(String samplingChannel) {
        this.samplingChannel = samplingChannel;
    }

    public String getOfflineSamplingPlace() {
        return offlineSamplingPlace;
    }

    public void setOfflineSamplingPlace(String offlineSamplingPlace) {
        this.offlineSamplingPlace = offlineSamplingPlace;
    }

    public String getOfflineSaleBody() {
        return offlineSaleBody;
    }

    public void setOfflineSaleBody(String offlineSaleBody) {
        this.offlineSaleBody = offlineSaleBody;
    }

    public String getOnlineEcPlatform() {
        return onlineEcPlatform;
    }

    public void setOnlineEcPlatform(String onlineEcPlatform) {
        this.onlineEcPlatform = onlineEcPlatform;
    }

    public String getOnlineStoreName() {
        return onlineStoreName;
    }

    public void setOnlineStoreName(String onlineStoreName) {
        this.onlineStoreName = onlineStoreName;
    }

    public String getOnlineDeliverMode() {
        return onlineDeliverMode;
    }

    public void setOnlineDeliverMode(String onlineDeliverMode) {
        this.onlineDeliverMode = onlineDeliverMode;
    }

    public String getMonitorItemCount() {
        return monitorItemCount;
    }

    public void setMonitorItemCount(String monitorItemCount) {
        this.monitorItemCount = monitorItemCount;
    }

    public String getTestingResult() {
        return testingResult;
    }

    public void setTestingResult(String testingResult) {
        this.testingResult = testingResult;
    }

    public String getDisqualReason1() {
        return disqualReason1;
    }

    public void setDisqualReason1(String disqualReason1) {
        this.disqualReason1 = disqualReason1;
    }

    public String getDisqualReason2() {
        return disqualReason2;
    }

    public void setDisqualReason2(String disqualReason2) {
        this.disqualReason2 = disqualReason2;
    }

    public String getDisqualItem() {
        return disqualItem;
    }

    public void setDisqualItem(String disqualItem) {
        this.disqualItem = disqualItem;
    }

    public String getDisqualDetail() {
        return disqualDetail;
    }

    public void setDisqualDetail(String disqualDetail) {
        this.disqualDetail = disqualDetail;
    }

    public String getDisqualJudgeBasis() {
        return disqualJudgeBasis;
    }

    public void setDisqualJudgeBasis(String disqualJudgeBasis) {
        this.disqualJudgeBasis = disqualJudgeBasis;
    }

    public String getDisqualHandleMeasure() {
        return disqualHandleMeasure;
    }

    public void setDisqualHandleMeasure(String disqualHandleMeasure) {
        this.disqualHandleMeasure = disqualHandleMeasure;
    }

    public String getTestingOrg() {
        return testingOrg;
    }

    public void setTestingOrg(String testingOrg) {
        this.testingOrg = testingOrg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDisqualItem1() {
        return disqualItem1;
    }

    public void setDisqualItem1(String disqualItem1) {
        this.disqualItem1 = disqualItem1;
    }

    public String getDisqualItem2() {
        return disqualItem2;
    }

    public void setDisqualItem2(String disqualItem2) {
        this.disqualItem2 = disqualItem2;
    }

    public String getDisqualItem3() {
        return disqualItem3;
    }

    public void setDisqualItem3(String disqualItem3) {
        this.disqualItem3 = disqualItem3;
    }

    public String getDisqualItem4() {
        return disqualItem4;
    }

    public void setDisqualItem4(String disqualItem4) {
        this.disqualItem4 = disqualItem4;
    }

    public String getDisqualItem5() {
        return disqualItem5;
    }

    public void setDisqualItem5(String disqualItem5) {
        this.disqualItem5 = disqualItem5;
    }

    public String getStarCountry() {
        return starCountry;
    }

    public void setStarCountry(String starCountry) {
        this.starCountry = starCountry;
    }

    public Integer getDataSign() {
        return dataSign;
    }

    public void setDataSign(Integer dataSign) {
        this.dataSign = dataSign;
    }

    @Override
    public String toString() {
        return "MonitorData{" +
        "id=" + id +
        ", orgName=" + orgName +
        ", monitorDate=" + monitorDate +
        ", procductName=" + procductName +
        ", productCommName=" + productCommName +
        ", productCategory=" + productCategory +
        ", productBrand=" + productBrand +
        ", productSpecfication=" + productSpecfication +
        ", producingCountry=" + producingCountry +
        ", tradeCountry=" + tradeCountry +
        ", samplingChannel=" + samplingChannel +
        ", offlineSamplingPlace=" + offlineSamplingPlace +
        ", offlineSaleBody=" + offlineSaleBody +
        ", onlineEcPlatform=" + onlineEcPlatform +
        ", onlineStoreName=" + onlineStoreName +
        ", onlineDeliverMode=" + onlineDeliverMode +
        ", monitorItemCount=" + monitorItemCount +
        ", testingResult=" + testingResult +
        ", disqualReason1=" + disqualReason1 +
        ", disqualReason2=" + disqualReason2 +
        ", disqualItem=" + disqualItem +
        ", disqualDetail=" + disqualDetail +
        ", disqualJudgeBasis=" + disqualJudgeBasis +
        ", disqualHandleMeasure=" + disqualHandleMeasure +
        ", testingOrg=" + testingOrg +
        ", remark=" + remark +
        ", disqualItem1=" + disqualItem1 +
        ", disqualItem2=" + disqualItem2 +
        ", disqualItem3=" + disqualItem3 +
        ", disqualItem4=" + disqualItem4 +
        ", disqualItem5=" + disqualItem5 +
        ", starCountry=" + starCountry +
        ", dataSign=" + dataSign +
        "}";
    }
}
