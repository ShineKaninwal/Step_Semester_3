public class ParcelNote extends DeliveryNote {

    private String trackingId;

    public ParcelNote(String trackingId) {
        super();
        this.trackingId = trackingId;
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}
