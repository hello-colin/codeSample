package hcl.example.publicpriveteprotected;

public class HCL {
    protected String getProtectedName(){
        return "protected";
    }

    private String getPrivatedName(){
        return  "private";
    }

    public String getPublicName(){
        return "public";
    }
}
