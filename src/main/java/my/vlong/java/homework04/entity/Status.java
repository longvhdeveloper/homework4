package my.vlong.java.homework04.entity;

public enum Status {
    OPEN(1, "Open"), CANCEL(2, "Cancel"), COMPLETE(3, "Complete");
    private int code;
    private String name;

    private Status(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Status map(int code) {
        switch (code) {
            case 1:
                return OPEN;
            case 2:
                return CANCEL;
            case 3:
                return COMPLETE;
        }
        return null;
    }

    public static String getStatusName(Status status) {
        String statusName = "";

        switch (status) {
            case OPEN:
                return OPEN.name;
            case CANCEL:
                return CANCEL.name;
            case COMPLETE:
                return COMPLETE.name;
        }

        return statusName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
