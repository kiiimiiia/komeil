package ir.bourna.komeil.controllers.web.requests;

import ir.bourna.komeil.models.Address;

import java.util.Set;

public class AddAddressRequest {

String codeposti;
String des;

    public String getCodeposti() {
        return codeposti;
    }

    public void setCodeposti(String codeposti) {
        this.codeposti = codeposti;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
