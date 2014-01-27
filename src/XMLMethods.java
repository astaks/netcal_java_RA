// XmlRPC methods available to other hosts in network
public class XMLMethods {

    // return list of IP addresses of the hosts in network
    public String[] get_clients(String address) {
        String[] list = Main.form.getAddressList(address);        
        return list;
    }
    // returns all data from table, client calls this method when signing to the network
    public String[] getTableData(String address){
        String[] ret = null;
        ret = Main.form.getTableData();
        return ret;
    }    
    // add the address of the client to the list of hosts in network
    public int signin(String address) {
        int ret = Main.form.signInClient(address);        
        return ret;
    }
    // remove the address of the client from the list of hosts in network
    public int sign_off(String address) {
        Main.form.signOutClient(address);        
        return 0;
    }       
//    // add a row of data received from a host to the table
//    public int addRowClient(String date,String time, //String id,
//                    String duration,String header,String comment){
//        
////        Main.form.addRowClient( 10,date, time, duration, header, comment);//Integer.parseInt(id),
//        Main.form.addRow(date, time, duration, header, comment);//Integer.parseInt(id),
//        Main.form.updateTable(); // update the display
//        return 0;
//    }    
//    // edit a row in the table by id, only nonempty fields are updated
//    public int editRowClient(String strID, String date,String time,String duration,String header,String comment){
//        int id = Integer.parseInt(strID);
//        Main.form.editMyTable(id,date,time,duration,header,comment);
//        Main.form.updateTable(); 
//        return 0;
//    }
//    // delete a row from the table
//    public int delRowClient(String strID){
//        int id = Integer.parseInt(strID);
//        Main.form.delRowLocal(id);
//        Main.form.updateTable();
//        return 0;
//    }    
    //#### #### #### #### ####
    public int functionsToPerform(int function,int id, String date,String time,String duration,String header,String comment){
        Main.form.performFunction(function,id,date,time,duration,header,comment);
        return 0;
    }    
    public int requestClientSignIn(String address){       
        Main.form.requestClientSignIn(address);
        return 0;
    }
    public int signInApproved(String address){
        Main.form.signIn(false);
        return 0;
    }    
    public int startTokenPassing(String address){
        Main.form.startTokenPassing();
        return 0;
    }
    
    public int stopTokenPassing(String address){
        Main.form.stopTokenPassing();
        return 0;
    }    
    public int tokenReceived(String address){
        Main.form.tokenReceived();
        return 0;
    }      
    
    public int replyReceived(String address){
        Main.form.replyReceived(address);
        return 0;
    }    
    
    public int csRequestReceived(String resource_id,String remoteAddress,int remoteClock){
        Main.form.csRequestReceived(resource_id,remoteAddress,remoteClock);
        return 0;
    }         
    
    public int getAlgorithm(String address){
        int typ = 0;
        typ = Main.form.algorithm;
        return typ;
    }
}
