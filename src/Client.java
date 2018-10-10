public class Client {

    public static void main(String[] args) {
        Windows windows;
        String osName = System.getProperty( "os.name" ).toLowerCase();
        if(osName.contains( "windows" )){
            button button=windows.creatButton();

        }
        else{

        }
    }
}
