package Login;

public interface Login {
     int Login(String userName,String password,String TableName);
     String getPass(String loginID);
     void changePass(String LoginID,String newPassword);
}
