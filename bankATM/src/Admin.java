import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author cqin
 * @project_name bank_final_project
 * @date 2022/12/6
 */

//this class is responsible for csv access
// TODO: 2022/12/6 confirm customer info
    /*
    transaction:
    customer:username, password, id, balance, account
    account:
     */
public class Admin {
    public static final String rootDir1 = "bankATM";
    public static final String rootDir2 = "csvfiles";
    public static final String fileType = ".csv";
    private HashMap<String, String> fileMap;
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


    // TODO: 2022/12/7 waiting for Account Constructor 
//    public List<Account> getCustomerAccount(String username){
//
//    }

    public List<Transaction> getTransByDate(long date) {
        //Returns all transactions for the date input
        //if date not exist, return null
        List<Transaction> dailyTransaction=new ArrayList<>();
        for (Transaction single: transactionsList) {
            if(single.getDate()==date){
                dailyTransaction.add(single);
            }
        }
        if(dailyTransaction.size()==0){
            return null;
        }
        return dailyTransaction;

    }

    public List<Transaction> getTransByName(String name){
        //Returns all transactions for the name input
        //if name not exist, return null
        List<Transaction> nameTransaction=new ArrayList<>();
        for (Transaction single: transactionsList) {
            if(single.getUserName().equals(name)){
                nameTransaction.add(single);
            }
        }
        if(nameTransaction.size()==0){
            return null;
        }
        return nameTransaction;
    }


    public List<Customer> loadAllCustomers() {
        // TODO: 2022/12/7 waiting for Customer constructor -->waiting for Account Constructor
        List<Customer> customers = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : userInfo.entrySet()) {
//            Customer customer = new Customer();
//            customers.add(customer);
        }
        return customers;
    }



    //write data to csv file
    public boolean array2CSV(String type, List<String> data) {
        if (!fileMap.containsKey(type)) {
            return false;
        }
        String path = fileMap.get(type);
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
            //TODO: 2022/12/7 update HashMap according to different type
            if (type.equals("customer")) {
                updateUserMap();
            } else if (type.equals("transaction")) {
                updateTransList();
            }

            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    //read data from csv file
    public ArrayList<ArrayList<String>> csv2Array(String type) {
        if (!fileMap.containsKey(type)) {
            return null;
        }
        String path = fileMap.get(type);
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
            return null;
        }
    }

    //initial 3 files path: transaction, customer, account
    //if file does not exist, create the file and add it into mapping
    public void initFilePath() {
        try {
            initFileMap();
            for (Map.Entry<String, String> entry : fileMap.entrySet()) {
                String dir = rootDir1 + File.separator + rootDir2 + File.separator + entry.getKey() + fileType;
                File f = new File(dir);
                if (!f.exists()) {
                    f.createNewFile();
                }
                fileMap.put(entry.getKey(), dir);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initFileMap() {
        fileMap = new HashMap<>();
        fileMap.put("customer", "");
        fileMap.put("transaction", "");
        fileMap.put("account", "");
    }


    //when the data of user.csv is changed, call this func to update userInfo hashmap.
    public void updateUserMap() {
        userInfo.clear();
        ArrayList<ArrayList<String>> users = csv2Array("customer");
        for (ArrayList<String> single : users) {
            String name = single.get(0);
            single.remove(0);
            userInfo.put(name, single);
        }
    }

    //when the data of transaction.csv is changed, call this func to update transaction list.
    public void updateTransList() {
        transactionsList.clear();
        ArrayList<ArrayList<String>> transactions = csv2Array("transaction");
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

    public HashMap<String, String> getFileMap() {
        return fileMap;
    }

    public HashMap<String, ArrayList<String>> getUserInfo() {
        return userInfo;
    }
    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

}

