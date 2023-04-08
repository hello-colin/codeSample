package hcl.example.publicpriveteprotected.test;

import hcl.example.publicpriveteprotected.HCL;

public class HCL2 extends HCL {
    public String getProtectedname(){
       return super.getProtectedName();
    }
}
