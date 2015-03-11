package it.redhat.quickstartlab.model;

@org.kie.api.definition.type.Label(value = "Invalid Request Marker")
public class InvalidProvisioningRequest implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label(value = "Validation Error Message")
    @org.kie.api.definition.type.Position(value = 0)
    private java.lang.String message;

    public InvalidProvisioningRequest() {
        this("Generic marker not valid. Cause unknown.");
    }

    public InvalidProvisioningRequest(java.lang.String message) {
        this.message = message;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return "InvalidProvisioningRequest due to " + message;
    }
}
