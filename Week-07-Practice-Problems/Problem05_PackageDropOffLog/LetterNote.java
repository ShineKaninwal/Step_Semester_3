public class LetterNote extends DeliveryNote {

    private String trackingId;

    public LetterNote(String trackingId) {
        super();
        this.trackingId = trackingId;
    }

    @Override
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}
