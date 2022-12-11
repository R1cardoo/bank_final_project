/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/10
 */

//class to define all the files name
public enum FilesName {
    STOCK("stock"),
    SAVING("savingAccount"),
    CHECKING("checkingAccount"),
    SECURITIES("securitiesAccount"),
    TRANSACTION("transaction"),
    CUSTOMER("customer");

    private String fileName;

    FilesName(String fileName) {
        this.setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
