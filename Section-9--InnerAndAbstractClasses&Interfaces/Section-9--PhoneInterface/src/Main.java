public class Main {
    public static void main(String[] args) {
        ITelephone timsPhone;
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(234567);
        timsPhone.powerOn(); // comment this out to check for phone powered off
        timsPhone.callPhone(234567);
        timsPhone.answer();
    }
}
