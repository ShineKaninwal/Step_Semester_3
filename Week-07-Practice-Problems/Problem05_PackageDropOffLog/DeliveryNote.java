public abstract class DeliveryNote {

    public DeliveryNote() {
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }

    public static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
}
