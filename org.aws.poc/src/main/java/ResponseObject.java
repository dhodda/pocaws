import io.restassured.response.Response;

import javax.xml.bind.annotation.XmlTransient;

public class ResponseObject  {
    @XmlTransient
    Response response;

    @XmlTransient
    public Response getResponse(){
        return this.response;
    }
    @XmlTransient
    public int getStatusCode(){
        return getResponse().getStatusCode();
    }
}
