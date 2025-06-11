import tugas2.Server;

public class Tugas2 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }
        System.out.printf("Listening on port: %s...\n", port);
        new Server(port);
    }
}

// Cara menjalankan
// Download jar file jackson-annotations-2.13.3.jar, jackson-core-2.13.3.jar, jackson-databind-2.13.3.jar
// Letakkan ketiga library tersebut pada directory lib project kalian
// Lalu jalankan:
// javac -cp ".:../lib/jackson-annotations-2.13.3.jar:../lib/jackson-core-2.13.3.jar:../lib/jackson-databind-2.13.3.jar" Tugas2.java
// java -cp ".:../lib/jackson-annotations-2.13.3.jar:../lib/jackson-core-2.13.3.jar:../lib/jackson-databind-2.13.3.jar" -Djava.net.preferIPv4Stack=true Tugas2

// coba kalo ga bisa ke jacksonnya pake ini (compilenya pake ini, CMIIW)
// javac -d bin -cp "lib/*" src/Tugas2/*.java src/Tugas2.java


// javac -d bin -cp "lib/*" src/tugas2/*.java src/controller/*.java src/model/*.java src/Tugas2.java
// java --% -Djava.net.preferIPv4Stack=true -cp "bin;lib/*" Tugas2
// (compile semua file)


// langkah-langkah compile Fiks!!!:
// cd dulu ke tugas2APIVilla
// javac -d bin -cp "lib/*" src/tugas2/*.java src/controller/*.java src/model/*.java src/Tugas2.java
// java --% -Djava.net.preferIPv4Stack=true -cp "bin;lib/*" Tugas2