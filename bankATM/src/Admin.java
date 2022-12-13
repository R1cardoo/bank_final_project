import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/6
 */

//this class is responsible for csv access
// doneTODO: 2022/12/6 confirm customer info
public class Admin {

    private static Admin instance = null;

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    public static final String rootDir = "..";
    public static final String rootDir1="bankATM";
    public static final String rootDir2="src";
    public static final String rootDir3="csvfiles";
    public static final String fileType = ".csv";
    private HashMap<FilesName, String> fileMap;
    private HashMap<String, ArrayList<String>> userInfo;
    private List<Transaction> transactionsList;

    public Admin() {
        initFilePath();
        userInfo = new HashMap<>();
        updateUserMap();
        transactionsList = new ArrayList<>();
        updateTransList();

    }

    //check if the password and username is valid
    //if username does not exist or password is wrong, return false;
    public boolean login(String username, String passwords) {
        if (!userInfo.containsKey(username)) {//user not exist
            return false;
        } else if (!userInfo.get(username).get(0).equals(passwords)) {
            return false; //wrong pswd
        }
        return true;
    }

    //check if the username in the csv file is unique
    //if the username is valid, return true;
    public boolean register(String username) {
        return !userInfo.containsKey(username);
    }


    // doneTODO: 2022/12/7 waiting for Account Constructor
    public List<Account> getCustomerAccount(String username){
        List<Account> accounts=new ArrayList<>();
        if(getCheckingByName(FilesName.CHECKING,username)!=null){
            accounts.add(getCheckingByName(FilesName.CHECKING,username));
        }
        if(getSavingByName(FilesName.SAVING,username)!=null){
            accounts.add(getSavingByName(FilesName.SAVING,username));
        }
        if (getSecuritiesByName(FilesName.SECURITIES,username)!=null){
            accounts.add(getSecuritiesByName(FilesName.SECURITIES,username));
        }
        return accounts;
    }

    public List<Transaction> getTransByDate(long date) {
        //Returns all transactions for the date input
        //if date not exist, return null
        List<Transaction> dailyTransaction = new ArrayList<>();
        for (Transaction single : transactionsList) {
            if (single.getDate() == date) {
                dailyTransaction.add(single);
            }
        }
        if (dailyTransaction.size() == 0) {
            return null;
        }
        return dailyTransaction;

    }

    public List<Transaction> getTransByName(String name) {
        //Returns all transactions for the name input
        //if name not exist, return null
        List<Transaction> nameTransaction = new ArrayList<>();
        for (Transaction single : transactionsList) {
            if (single.getUserName().equals(name)) {
                nameTransaction.add(single);
            }
        }
        if (nameTransaction.size() == 0) {
            return null;
        }
        return nameTransaction;
    }


    public List<Customer> loadAllCustomers() {
        // doneTODO: 2022/12/7 waiting for Customer constructor -->waiting for Account Constructor
        List<Customer> customers = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : userInfo.entrySet()) {
            ArrayList<String> person=entry.getValue();
            String passWord=person.get(0);
            Customer customer = new Customer(entry.getKey(),passWord);
            customers.add(customer);
        }
        for (Customer person: customers) {
            for (Transaction transaction: transactionsList) {
                if(transaction.getUserName().equals(person.getUserName())){
                    person.addTransaction(transaction);
                }
            }
            if(getCheckingByName(FilesName.CHECKING,person.getUserName())!=null){
                person.setCheckAccount(getCheckingByName(FilesName.CHECKING,person.getUserName()));
            }
            if(getSavingByName(FilesName.SAVING,person.getUserName())!=null){
                person.setSaveAccount(getSavingByName(FilesName.SAVING,person.getUserName()));
            }
            // doneTODO: 2022/12/10 security
            if(getSecuritiesByName(FilesName.SECURITIES,person.getUserName())!=null){
                person.setSecuritiesAccount(getSecuritiesByName(FilesName.SECURITIES,person.getUserName()));
            }

        }
        return customers;
    }


    //write data to csv file
    public boolean array2CSV(FilesName filesName, List<String> data) {
        if (!fileMap.containsKey(filesName)) {
            return false;
        }
        String path = fileMap.get(filesName);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8));
            for (int i = 0; i < data.size(); i++) {
                out.write(data.get(i));
                out.write(",");
            }
            out.newLine();
            out.flush();
            out.close();
            //doneTODO: 2022/12/7 update HashMap according to different type
            if (filesName.getFileName().equals("customer")) {
                updateUserMap();
            } else if (filesName.getFileName().equals("transaction")) {
                updateTransList();
            }

            return true;
        } catch (Exception e) {
            System.err.format("saveFile error: %s%n", e);
            return false;
        }
    }

    //read data from csv file
    public ArrayList<ArrayList<String>> csv2Array(FilesName filesName) {
        if (!fileMap.containsKey(filesName)) {
            return null;
        }
        String path = fileMap.get(filesName);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
            String line;
            String[] row;
            while ((line = in.readLine()) != null) {
                row = line.split(",");
                List<String> onerow = Arrays.asList(row);
                ArrayList<String> onerowArray = new ArrayList<>(onerow);
                all.add(onerowArray);
            }
            in.close();
            return all;
        } catch (Exception e) {
            System.err.format("readFile error: %s%n", e);
            return null;
        }
    }

    /*
    call this function to update or edit any information to any files
    e.g. balance reduce/ balance increase
    String keyName: whose information do you want to update
    ArrayList<String> newData: all values of the attributes (including new data and the original data)
    FilesName filesName: file type you want to edit
     */
    public boolean updateInfo(String keyName, ArrayList<String> newData, FilesName filesName){
        ArrayList<ArrayList<String>> oldData=csv2Array(filesName);
        int index=Integer.MAX_VALUE;
        if(oldData==null){  //file not exist or file is empty
            return false;
        }
        if(filesName.getFileName().equals("transaction")){
            for (int i=0;i<oldData.size();i++){
                if(oldData.get(i).get(1).equals(keyName)){
                    index=i;
                    break;
                }
            }
        }else {
            for (int i=0;i<oldData.size();i++){
                if(oldData.get(i).get(0).equals(keyName)){
                    index=i;
                    break;
                }
            }
        }
        if(index==Integer.MAX_VALUE){ //file doest not contain the record of this key value
            return false;
        }
        oldData.remove(index);
        oldData.add(newData);
        String path = fileMap.get(filesName);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
            for (int i = 0; i < oldData.size(); i++){
                for(int j=0;j< oldData.get(i).size();j++){
                    out.write(oldData.get(i).get(j));
                    out.write(",");
                }
                out.newLine();
            }
            out.flush();
            out.close();
            //doneTODO: 2022/12/7 update HashMap according to different type
            if (filesName.getFileName().equals("customer")) {
                updateUserMap();
            } else if (filesName.getFileName().equals("transaction")) {
                updateTransList();
            }

            return true;
        } catch (Exception e) {
            System.err.format("saveFile error: %s%n", e);
            return false;
        }

    }

    //initial 3 files path: transaction, customer, account
    //if file does not exist, create the file and add it into mapping
    public void initFilePath() {
        initFileMap();
        for (Map.Entry<FilesName, String> entry : fileMap.entrySet()) {
            //file path for running in intellij IDEA
            //cqin and Carson running path
            String dir = rootDir1+File.separator+rootDir2+ File.separator+ rootDir3+File.separator+ entry.getKey().getFileName() + fileType;
            //R Li running path
//          String dir =rootDir2+ File.separator+ rootDir3+File.separator+ entry.getKey().getFileName() + fileType;
            //file path for running in terminal
            // String dir = rootDir + File.separator +rootDir2+ File.separator+ rootDir3+File.separator+ entry.getKey() + fileType;
            File f = new File(dir);
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    System.err.format("createFile error: %s%n", e);
                }
            }
            fileMap.put(entry.getKey(), dir);
        }
    }
/*
interface to save and modify files
 */

    public boolean saveNameAndPSWD(Customer customer){
        //call this function to save a new customer's username and password
        ArrayList<String> data = new ArrayList<>();
        data.add(customer.getUserName());
        data.add(customer.getPassWord());
        return array2CSV(FilesName.CUSTOMER,data);
    }

    public boolean saveTransaction(Transaction transaction){
        //when a new transaction created, call this function
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(transaction.getDate()));
        data.add(transaction.getUserName());
        data.add(transaction.getAccountType());
        data.add(String.valueOf(transaction.getFeeCharged()));
        data.add(String.valueOf(transaction.getAmount()));
        data.add(transaction.getCurrency());
        data.add(transaction.getTransactionType());
        return array2CSV(FilesName.TRANSACTION,data);
    }

    public boolean saveSecurities(SecuritiesAccount securitiesAccount){
        //when a new security account is created, call this function
        ArrayList<String> data = new ArrayList<>();
        data.add(securitiesAccount.getUsername());
        data.add(TypeOfAccount.Securities.getTypeOfAccount());
        for (Currency currency: securitiesAccount.getCurrencies()) {
            data.add(String.valueOf(currency.getType()));
            data.add(String.valueOf(currency.getValue()));
        }
        data.add(String.valueOf(securitiesAccount.getRealizedProfit()));
        data.add(String.valueOf(securitiesAccount.getUnrealizedProfit()));
        for (Map.Entry<Stock,ArrayList<Double>> entry:securitiesAccount.getStockOwned().entrySet()) {
            data.add(entry.getKey().getStockName());
            data.add(String.valueOf(entry.getValue().get(0)));
            data.add(String.valueOf(entry.getValue().get(1)));
        }
        return array2CSV(FilesName.SECURITIES,data);
    }

    public boolean saveSaving(SavingsAccount savingsAccount){
        //when a new saving account is created, call this function
        ArrayList<String> data = new ArrayList<>();
        data.add(savingsAccount.getUsername());
        data.add(TypeOfAccount.Savings.getTypeOfAccount());
        for (Currency currency: savingsAccount.getCurrencies()) {
            data.add(String.valueOf(currency.getType()));
            data.add(String.valueOf(currency.getValue()));
        }
        return array2CSV(FilesName.SAVING,data);
    }

    public boolean saveChecking(CheckingAccount checkingAccount){
        //when a new saving account is created, call this function
        ArrayList<String> data = new ArrayList<>();
        data.add(checkingAccount.getUsername());
        data.add(TypeOfAccount.Checking.getTypeOfAccount());
        for (Currency currency: checkingAccount.getCurrencies()) {
            data.add(String.valueOf(currency.getType()));
            data.add(String.valueOf(currency.getValue()));
        }
        data.add(String.valueOf(checkingAccount.getLoanAmount()));
        return array2CSV(FilesName.CHECKING,data);

    }

    public boolean saveStock(Stock stock){
        //when a new stock is added, call this function
        ArrayList<String> data = new ArrayList<>();
        data.add(stock.getStockName());
        data.add(String.valueOf(stock.getStockId()));
        data.add(String.valueOf(stock.getStockPrice()));
        return array2CSV(FilesName.STOCK,data);
    }


    // TODO: 2022/12/12 updateInfo wrap up
    public boolean updatePSWD(Customer customer){
        //call this function when customer want to update their password
        ArrayList<String> data = new ArrayList<>();
        data.add(customer.getUserName());
        data.add(customer.getPassWord());
        return updateInfo(customer.getUserName(),data,FilesName.CUSTOMER);
    }

    public boolean updateTransaction(Transaction transaction){
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(transaction.getDate()));
        data.add(transaction.getUserName());
        data.add(transaction.getAccountType());
        data.add(String.valueOf(transaction.getFeeCharged()));
        data.add(String.valueOf(transaction.getAmount()));
        data.add(transaction.getCurrency());
        data.add(transaction.getTransactionType());
        return updateInfo(transaction.getUserName(),data,FilesName.TRANSACTION);
    }

    public boolean updateSecurities(SecuritiesAccount securitiesAccount){
        ArrayList<String> data = new ArrayList<>();
        data.add(securitiesAccount.getUsername());
        data.add(TypeOfAccount.Securities.getTypeOfAccount());
        for (Currency currency: securitiesAccount.getCurrencies()) {
            data.add(String.valueOf(currency.getType()));
            data.add(String.valueOf(currency.getValue()));
        }
        data.add(String.valueOf(securitiesAccount.getRealizedProfit()));
        data.add(String.valueOf(securitiesAccount.getUnrealizedProfit()));
        for (Map.Entry<Stock,ArrayList<Double>> entry:securitiesAccount.getStockOwned().entrySet()) {
            data.add(entry.getKey().getStockName());
            data.add(String.valueOf(entry.getValue().get(0)));
            data.add(String.valueOf(entry.getValue().get(1)));
        }
        return updateInfo(securitiesAccount.getUsername(),data,FilesName.SECURITIES);
    }

    public boolean updateSaving(SavingsAccount savingsAccount){
        ArrayList<String> data = new ArrayList<>();
        data.add(savingsAccount.getUsername());
        data.add(TypeOfAccount.Savings.getTypeOfAccount());
        for (Currency currency: savingsAccount.getCurrencies()) {
            data.add(String.valueOf(currency.getType()));
            data.add(String.valueOf(currency.getValue()));
        }
        return updateInfo(savingsAccount.getUsername(),data,FilesName.SAVING);
    }

    public boolean updateChecking(CheckingAccount checkingAccount){
        ArrayList<String> data = new ArrayList<>();
        data.add(checkingAccount.getUsername());
        data.add(TypeOfAccount.Checking.getTypeOfAccount());
        for (Currency currency: checkingAccount.getCurrencies()) {
            data.add(String.valueOf(currency.getType()));
            data.add(String.valueOf(currency.getValue()));
        }
        data.add(String.valueOf(checkingAccount.getLoanAmount()));
        return updateInfo(checkingAccount.getUsername(),data,FilesName.CHECKING);
    }

    public boolean updateStock(Stock stock){
        ArrayList<String> data = new ArrayList<>();
        data.add(stock.getStockName());
        data.add(String.valueOf(stock.getStockId()));
        data.add(String.valueOf(stock.getStockPrice()));
        return updateInfo(stock.getStockName(),data,FilesName.STOCK);
    }

    public CheckingAccount getCheckingByName(FilesName filesName,String name){
        ArrayList<String> personInfo=getPersonInfo(filesName,name);
        if(personInfo.size()==0){
            return null;
        }
        String username=personInfo.get(0);
        //account type--> TypeOfAccount.Checking

        ArrayList<Currency> currencies=getCurrencyList(personInfo,2,2);
        int afterIndex=1+2*CurrencyType.values().length;
        int loanAmount= Integer.parseInt(personInfo.get(++afterIndex));  //currency.type+1
        return  new CheckingAccount(username, TypeOfAccount.Checking, currencies,loanAmount);

    }

    public SavingsAccount getSavingByName(FilesName filesName, String username){
        ArrayList<String> personInfo=getPersonInfo(filesName,username);
        if(personInfo.size()==0) {
            return null;
        }

        //account type-->set enum

        ArrayList<Currency> currencies=getCurrencyList(personInfo,2,2);
        return new SavingsAccount(username,TypeOfAccount.Savings,currencies);
    }


    public SecuritiesAccount getSecuritiesByName(FilesName filesName,String name){
        ArrayList<String> personInfo;
        personInfo=getPersonInfo(filesName,name);
        if(personInfo.size()==0){
            return null;
        }
        String username=personInfo.get(0);

        //account type-->set enum

        ArrayList<Currency> currencies=getCurrencyList(personInfo,2,2);
        int afterIndex=1+2*CurrencyType.values().length;
        double realizedProfit= Double.parseDouble(personInfo.get(++afterIndex));//currency type+1
        double unrealizedProfit= Double.parseDouble(personInfo.get(++afterIndex));
        //csv file stores stock name
        // TODO: 2022/12/12 need check
        HashMap<Stock,ArrayList<Double>> stockOwned=new HashMap<>();
        for (int i = ++afterIndex; i+2 <personInfo.size() ;) {
            ArrayList<Double> stockData=new ArrayList<>();
            Stock stock=getStockByName(personInfo.get(i));
            double buyPrice=Double.parseDouble(personInfo.get(i+1));
            double count=Double.parseDouble(personInfo.get(i+2));
            stockData.add(buyPrice);
            stockData.add(count);
            stockOwned.put(stock,stockData);
            i+=3;
        }
        return new SecuritiesAccount(username, TypeOfAccount.Securities,currencies,realizedProfit,unrealizedProfit,stockOwned);

    }

    public ArrayList<Currency> getCurrencyList( ArrayList<String> personInfo,int startIndex, int gap){
        ArrayList<Currency> currencies=new ArrayList<>();
        double value=0.0;
        for(int i=startIndex;i+1<startIndex+2*CurrencyType.values().length;){
            String kind=personInfo.get(i);
            if(!personInfo.get(i+1).equals(" ")){
               value= Double.parseDouble(personInfo.get(i+1));
            }else{
                value=0.0;
            }
            // checkedTODO: 2022/12/10 Check  CurrencyType.valueOf
            Currency currency=new Currency(CurrencyType.valueOf(kind),value);
            currencies.add(currency);
            i+=gap;
        }
        return currencies;

    }

    public ArrayList<String> getPersonInfo(FilesName filesName,String name){
        ArrayList<ArrayList<String>> AccountList=csv2Array(filesName);
        ArrayList<String> personInfo=new ArrayList<>();
        for (ArrayList<String> row:AccountList) {
            if(row.get(0).equals(name)){
                personInfo=row;
                break;
            }
        }
        return personInfo;
    }

    public List<Stock> loadStockInfo(){
        ArrayList<ArrayList<String>> stockList= csv2Array(FilesName.STOCK);
        List<Stock> stocksArray=new ArrayList<>();
        for (ArrayList<String> row:stockList) {
            String stockName=row.get(0);
            int stockId=Integer.parseInt(row.get(1));
            double stockPrice=Double.parseDouble(row.get(2));
            Stock stock=new Stock(stockName,stockId,stockPrice);
            stocksArray.add(stock);
        }
        return stocksArray;
    }

    public Stock getStockByName(String stockName){
        List<Stock> allStock=loadStockInfo();
        Stock get=null;
        for (Stock stock:allStock) {
            if(stock.getStockName().equals(stockName)){
                get=stock;
                break;
            }
        }
        //stock doest not exist return null;
        return get;
    }


    public void initFileMap() {
        fileMap = new HashMap<>();
        for (FilesName name: FilesName.values()) {
            fileMap.put(name,"");
        }
    }


    //when the data of customer.csv is changed, call this func to update userInfo hashmap.
    public void updateUserMap() {
        userInfo.clear();
        ArrayList<ArrayList<String>> users = csv2Array(FilesName.CUSTOMER);
        for (ArrayList<String> single : users) {
            String name = single.get(0);
            single.remove(0);
            userInfo.put(name, single);
        }
    }

    //when the data of transaction.csv is changed, call this func to update transaction list.
    public void updateTransList() {
        transactionsList.clear();
        ArrayList<ArrayList<String>> transactions = csv2Array(FilesName.TRANSACTION);
        for (List<String> row : transactions) {
            // done: 2022/12/7 check data type
            // done: 2022/12/7 waiting for transaction constructor
            long date = Long.parseLong(row.get(0));
            String username = row.get(1);
            String accountType = row.get(2);
            double feeCharged = Double.parseDouble(row.get(3));
            double amount = Double.parseDouble(row.get(4));
            String currency = row.get(5);
            String transactionType = row.get(6);
            Transaction transaction = new Transaction(username, accountType, date, feeCharged, amount, currency, transactionType);
            transactionsList.add(transaction);
        }

    }

    public HashMap<FilesName, String> getFileMap() {
        return fileMap;
    }

    public HashMap<String, ArrayList<String>> getUserInfo() {
        return userInfo;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }
}

