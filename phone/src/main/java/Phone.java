public class Phone {


    private  String number;
    private  String model;
    private  float weight;

    public Phone(String number, String model, float weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }
    public Phone(){

    }

    public String getNumber () {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void receiveCall(String nameOfCaller){
        System.out.println("Звонит " + nameOfCaller);
    }

    public void sendMessage (String...numbers){
        System.out.println("Отправка сообщения на номер: ");
        for (String number: numbers) {
            System.out.println(number + " ");
        }
    }

    public static void main(String[] args){
            Phone phoneIgor = new Phone("8927154663", "iphone", 345.4f);
            Phone phoneRinat = new Phone("8925412564", "iphone", 344);
            Phone phoneDiman = new Phone("89375896125", "xiaomi", 452);

        System.out.println("Phone 1: Номер-" + phoneIgor.getNumber() + ", Модель-" + phoneIgor.getModel() + ", Вес-" + phoneIgor.getWeight() + "kg");
        System.out.println("Phone 2: Номер-" + phoneRinat.getNumber() + ", Модель-" + phoneRinat.getModel() + ",Вес-" + phoneRinat.getWeight() + "kg");
        System.out.println("Phone 3: Номер -" + phoneDiman.getNumber() + ", Модель-" + phoneDiman.getModel() + ", Вес-" + phoneDiman.getWeight() + "kg");

        phoneRinat.receiveCall("Rinat");
        phoneIgor.sendMessage("89375896125", "8925412564" );
        }

    }

