package ir.bourna.komeil.controllers.web.responses;

public class GetMobileResponse{
    private boolean isRegistered;
    private boolean isBlock;
    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void isBlock(boolean block) {
        isBlock = block;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }
}
