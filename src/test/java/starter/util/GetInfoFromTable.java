package starter.util;

import io.cucumber.datatable.DataTable;
import starter.models.LoginModel;
import starter.models.TransactionModel;

import java.util.List;

public class GetInfoFromTable {
    public static LoginModel getLoginCredentials(DataTable userLogin){
        List<List<String>> rows = userLogin.asLists(String.class);
        String username = "";
        String password = "";

        for (List<String> columns: rows){
            username = columns.get(0);
            password = columns.get(1);
        }

        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(username);
        loginModel.setPassword(password);
        return loginModel;
    }

    public static TransactionModel getTransactionData(DataTable transactionInfo){
        List<List<String>> rows = transactionInfo.asLists(String.class);
        String date = "";
        String amount = "";
        String description = "";

        for (List<String> columns: rows){
            date = columns.get(0);
            amount = columns.get(1);
            description = columns.get(2);
        }

        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setDate(date);
        transactionModel.setAmount(amount);
        transactionModel.setDescription(description);
        return transactionModel;
    }
}
