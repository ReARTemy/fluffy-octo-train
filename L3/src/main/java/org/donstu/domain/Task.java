package org.donstu.domain;

public class Task {
    private int id;
    private String description;
    private Master master;

    private Client client;

    public Task(int id, String description, Master master, Client client) {
        this.id = id;
        this.description = description;
        this.master = master;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
