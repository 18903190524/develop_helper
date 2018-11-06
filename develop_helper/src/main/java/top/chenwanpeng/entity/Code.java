package top.chenwanpeng.entity;

import java.io.Serializable;

/**
代码信息
 */
public class Code implements Serializable {
    /**
     * deletes+a+s=>必选c o r   可选s h v
     */
    
    
    private static final long serialVersionUID = 1L;
    private String id;//
    private String userName;//
    private String password;//
    private String databaseIP;//
    private String databaseName;//
    private String savePath;//
    private String projectName;//
    private String packageName;//
    private String projectNameCH;//
    private String writerName;//
    public Code() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getDatabaseIP() {
        return databaseIP;
    }
    public String getDatabaseName() {
        return databaseName;
    }
    public String getId() {
        return id;
    }
    public String getPackageName() {
        return packageName;
    }
    public String getPassword() {
        return password;
    }
    public String getProjectName() {
        return projectName;
    }
    public String getProjectNameCH() {
        return projectNameCH;
    }
    public String getSavePath() {
        return savePath;
    }
    public String getUserName() {
        return userName;
    }
    public String getWriterName() {
        return writerName;
    }
    public void setDatabaseIP(String databaseIP) {
        this.databaseIP = databaseIP;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setProjectNameCH(String projectNameCH) {
        this.projectNameCH = projectNameCH;
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
    @Override
    public String toString() {
        return "code [id=" + id + ", userName=" + userName + ", password=" + password + ", databaseName=" + databaseName
                + ", savePath=" + savePath + ", projectName=" + projectName + ", packageName=" + packageName
                + ", projectNameCH=" + projectNameCH + ", writerName=" + writerName + "]";
    }
    
    
}