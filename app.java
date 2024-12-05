import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rendujava", "root", "");

            System.out.println("Connexion reussie");
            Scanner scanner = new Scanner(System.in);

            System.out.println(" créer un utilisateur ou un etudiant?");
            String choix = scanner.nextLine();

            if (choix.equals("etudiant") || choix.equals("utilisateur")) {


                System.out.println("donner ID  :");
                  int id = scanner.nextInt();
                         
                  scanner.nextLine();

                System.out.println("donner nom :");

                   String nom = scanner.nextLine();

                System.out.println("donner Prenom :");
                   
                String prenom = scanner.nextLine();

                System.out.println("donner l'email :");
                String email = scanner.nextLine();

                String sql = "INSERT INTO users (id_users, nom_user, prenom_user, email) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.setString(2, nom);
                pstmt.setString(3, prenom);
                pstmt.setString(4, email);

                pstmt.executeUpdate();

            }

           
               System.out.println("Creer un événement");

            System.out.println("Donner ID :");

            int id_event = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Donner le nom :");
            String nom_event = scanner.nextLine();

            System.out.println("Donner la date  :");
            String date_event = scanner.nextLine();

            System.out.println("Donner la description :");
            String description = scanner.nextLine();

            System.out.println("Donner id de l'utilisateur :");
            int id_user = scanner.nextInt();

            String sql2 = "INSERT INTO events (id_event, nom_event, date_event, description, id_user) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmtEvent = conn.prepareStatement(sql2);
            pstmtEvent.setInt(1, id_event);
            pstmtEvent.setString(2, nom_event);
            pstmtEvent.setString(3, date_event);
            pstmtEvent.setString(4, description);
            pstmtEvent.setInt(5, id_user);
            pstmtEvent.executeUpdate();


            
            System.out.println("Réserver une salle");
            System.out.println("Donner id :");
            int id_salle = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Donner nom :");
            String nom_salle = scanner.nextLine();

            System.out.println("Donner capacité :");
            int capacite = scanner.nextInt();

            String sqlSalle = "INSERT INTO salles (id_salle, nom_salle, capacite) VALUES (?, ?, ?)";
            PreparedStatement pstmtSalle = conn.prepareStatement(sqlSalle);
            pstmtSalle.setInt(1, id_salle);
            pstmtSalle.setString(2, nom_salle);
            pstmtSalle.setInt(3, capacite);
            pstmtSalle.executeUpdate();


         
            conn.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
