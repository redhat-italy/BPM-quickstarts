package it.redhat.quickstartlab.model;

public class ProvisioningRequest implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @org.kie.api.definition.type.Label(value = "Number of hosts")
    @org.kie.api.definition.type.Position(value = 1)
    private int quantity;

    @org.kie.api.definition.type.Label(value = "Size of the host")
    @org.kie.api.definition.type.Position(value = 0)
    private int size;

    @org.kie.api.definition.type.Label(value = "Status of the request")
    @org.kie.api.definition.type.Position(value = 4)
    private java.lang.String status;

    @org.kie.api.definition.type.Label(value = "Requestor name")
    @org.kie.api.definition.type.Position(value = 3)
    private java.lang.String user;

    public ProvisioningRequest(int size, int quantity, String user, String status) {
        this.size = size;
        this.quantity = quantity;
        this.user = user;
        this.status = status;
    }

    public ProvisioningRequest(String user) {
        this((int)(4 * Math.random()),(int)(20 * Math.random()),user,"new");
    }

    public ProvisioningRequest() {
        this("UNKNOWN");
    }

    @Override
    public String toString(){
        return "ProvisioningRequest from user " + this.user + ", size " + size + ", quantity " + quantity + ", status " + status;
    }
}