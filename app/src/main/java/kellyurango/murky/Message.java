package kellyurango.murky;

import java.io.Serializable;

public class Message implements Serializable {
    public String msm;

    public Message(String msm) {
        super();
        this.msm = msm;
    }

    public String getMsm() {
        return msm;
    }

    public void setMsm(String msm) {
        this.msm = msm;
    }
}
