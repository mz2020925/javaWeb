package pojo;

public class Brand {
    // 创建tb_brand表
    private Integer id;  // 主键
    private String brandName;// 品牌名称
    private String companyName;// 企业名称
    private Integer ordered;// 排序字段
    private String description;// 描述信息
    private Integer status; // 为什么使用这种基本包装类型呢，因为Integer定义自动初始化为null，但int定义自动初始化为0，
                            // 这个0就代表了一个实际状态，这样不好。因为如果我忘记把status修改为1时，就会出现错误

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
