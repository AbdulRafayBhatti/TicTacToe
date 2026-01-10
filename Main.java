import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.Random;
import java.awt.Font;
public class Main {
    public static boolean arrayContains(String[] array, String target) {
        for (String i : array) {
            if (i != null && i.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public static String getRandomElement(String[] array) {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }
    public static void main(String[]args){
        // int nym1Win=0;
        // int nym2Win=0;
        // int compWin=0;
        // int draw = 0;
        String Y;
        Random random =new Random();
        //Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 18);
        UIManager.put("OptionPane.messageFont", font);
        //UIManager.put("OptionPane.buttonFont", font);
        String A = "1", B = "2", C = "3", D = "4", E = "5", F = "6", G = "7", H = "8", I = "9";
        String grid = String.format(
            "       |       |      \n" +
            "   "+A+"   |   "+B+"   |   "+C+"  \n" +
            "_______|_______|______\n" +
            "       |       |      \n" +
            "   "+D+"   |   "+E+"   |   "+F+"  \n" +
            "_______|_______|______\n" +
            "       |       |      \n" +
            "   "+G+"   |   "+H+"   |   "+I+"  \n" +
            "       |       |      ");
        JOptionPane.showMessageDialog(null,grid,"Welcome to Tic-Tac World...!",JOptionPane.INFORMATION_MESSAGE);
        String mnud= "1";
        while (mnud.equals("1")){
            String menu = JOptionPane.showInputDialog("For double player game press 1\nFor single player game press 2\nFor exit press 3");
            while (!menu.equals("1") && !menu.equals("2") && !menu.equals("3")){
            menu = JOptionPane.showInputDialog("Invalid Input.\nFor double player game press 1\nFor single player game press 2\nFor exit press 3");
            }
            String nym1;
            String nym2;
            String level = "3";
            if (menu.equals("1")){
                nym1 = JOptionPane.showInputDialog("Enter the name of first Player: ");
                nym2 = JOptionPane.showInputDialog("Enter the name of second player: ");
            }else if (menu.equals("2")){
                nym1 = JOptionPane.showInputDialog("Enter the name of Player: ");
                nym2 = "Computer";
                level = JOptionPane.showInputDialog("Press 1 for simple level.\nPress 2 for middle level.\nPress 3 for hard level");
                while (!level.equals("1") && !level.equals("2") && !level.equals("3")){
                    level = JOptionPane.showInputDialog("Invalid Input.\nPress 1 for simple level.\nPress 2 for middle level.\nPress 3 for hard level");
                }
            }else{
                break;
            }
            String play="1";
            while (play.equals("1")){
                A = "1";
                B = "2";
                C = "3";
                D = "4";
                E = "5";
                F = "6";
                G = "7";
                H = "8";
                I = "9";
                grid = String.format(
                                    "       |       |      \n" +
                                    "   "+A+"   |   "+B+"   |   "+C+"  \n" +
                                    "_______|_______|______\n" +
                                    "       |       |      \n" +
                                    "   "+D+"   |   "+E+"   |   "+F+"  \n" +
                                    "_______|_______|______\n" +
                                    "       |       |      \n" +
                                    "   "+G+"   |   "+H+"   |   "+I+"  \n" +
                                    "       |       |      ");
                
                
                String Toss = JOptionPane.showInputDialog(nym1+" Please enter head or tail: ");
                while (!Toss.toLowerCase().equals("head") && !Toss.toLowerCase().equals("tail")) {
                JOptionPane.showMessageDialog(null,"Invalid input.","Error...!",JOptionPane.ERROR_MESSAGE);
                    Toss = JOptionPane.showInputDialog("Invalid input.\nEnter head or tail: ");
                }
                Toss.toLowerCase();
                int toss_result=random.nextInt(2);
                String T_result = "";
                if (Toss.equalsIgnoreCase("head") && toss_result==1){
                    T_result = "Toss result: Head";
                }else if (Toss.equalsIgnoreCase("head") && toss_result==0){
                    T_result = "Toss result: Tail" ;
                }else if (Toss.equalsIgnoreCase("tail") && toss_result==1){
                    T_result = "Toss result: Tail" ;
                }else if (Toss.equalsIgnoreCase("tail") && toss_result==0){
                    T_result = "Toss result: Head" ;
                }
                String symbol_of_nym1 = "", symbol_of_nym2 = "";
                if (toss_result==1){
                    JOptionPane.showMessageDialog(null,T_result+"\n"+nym1+" you won the toss...!","Toss Result",JOptionPane.INFORMATION_MESSAGE);
                    symbol_of_nym1="X";
                    symbol_of_nym2="O";
                }else if(toss_result==0){
                    if (menu.equals("1")){
                        JOptionPane.showMessageDialog(null,T_result+"\n"+nym2+" you won the toss...!","Toss Result",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,T_result+"\n"+nym1+" you lose the toss...!","Toss Result",JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    Y = nym1;
                    nym1 = nym2 ;
                    nym2 = Y ;
                    symbol_of_nym1 = "O";
                    symbol_of_nym2 = "X";
                }
                if (menu.equals("1")){
                    JOptionPane.showMessageDialog(null,nym1+"\'s Symbol: "+symbol_of_nym1+"\n"+nym2+"\'s Symbol: "+symbol_of_nym2,"Symbols Declaration",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,nym1+"\'s Symbol: "+symbol_of_nym1+"\n"+nym2+"\'s Symbol: "+symbol_of_nym2,"Symbols Declaration",JOptionPane.INFORMATION_MESSAGE);
                }
                int count=0;
                String moves[]= new String[9];
                String player="";
                String symbol="";
                while (count<9) {
                    if (count%2==0){
                        player = nym1;
                        symbol = symbol_of_nym1;
                    }else{
                        player = nym2;
                        symbol = symbol_of_nym2;
                    }
                    String current_move = "0";
                    String[] cmove = {"1","2","3","4","5","6","7","8","9"} ;
                    if (menu.equals("1")){
                        current_move= JOptionPane.showInputDialog(grid+"\n\n"+player+" move your turn by entering respective Number: ");
                    }else if (player.equals("Computer")){
                            if (((E.equals("O") && G.equals("O")) || (A.equals("O") && B.equals("O")) || (I.equals("O") && F.equals("O"))) && C.equals("3") && (level.equals("2") || level.equals("3"))){
                                current_move="3";}
                            else if (((C.equals("O") && G.equals("O")) || (A.equals("O")  &&  I.equals("O")) || (D.equals("O")  &&  F.equals("O")) || (B.equals("O")  &&  H.equals("O"))) &&  E.equals("5") && (level.equals("2") || level.equals("3"))){
                                current_move="5";}
                            else if (((C.equals("O")   &&  E.equals("O")) || (H.equals("O")   &&   I.equals("O")) || (A.equals("O")   &&  D.equals("O")))  &&  G.equals("7") && (level.equals("2") || level.equals("3"))){
                                current_move="7";}
                            else if (((A.equals("O") && E.equals("O")) || (G.equals("O") && H.equals("O")) || (C.equals("O") && F.equals("O"))) && I.equals("9") && (level.equals("2") || level.equals("3"))){
                                current_move="9";}
                            else if (((E.equals("O") && I.equals("O")) || (B.equals("O") && C.equals("O")) || (G.equals("O") && D.equals("O"))) && A.equals("1") && (level.equals("2") || level.equals("3"))){
                                current_move="1";}
                            else if (((A.equals("O") && C.equals("O")) || (H.equals("O") && E.equals("O"))) && B.equals("2") && (level.equals("2") || level.equals("3"))){
                                current_move="2";}
                            else if (((D.equals("O") && E.equals("O")) || (C.equals("O") && I.equals("O"))) && F.equals("6") && (level.equals("2") || level.equals("3"))){
                                current_move="6";}
                            else if (((E.equals("O") && F.equals("O")) || (A.equals("O") && G.equals("O"))) && D.equals("4") && (level.equals("2") || level.equals("3"))){
                                current_move="4";}
                            else if (((G.equals("O") && I.equals("O")) || (B.equals("O") && E.equals("O"))) && H.equals("8") && (level.equals("2") || level.equals("3"))){
                                current_move="8";}
                            else if (((E.equals("X") && G.equals("X")) || (A.equals("X") && B.equals("X")) || (I.equals("X") && F.equals("X"))) && C.equals("3") && (level.equals("2") || level.equals("3"))){
                                current_move="3";}
                            else if (((C.equals("X") && G.equals("X")) || (A.equals("X") && I.equals("X")) || (D.equals("X") && F.equals("X")) || (B.equals("X") && H.equals("X"))) && E.equals("5") && (level.equals("2") || level.equals("3"))){
                                current_move="5";}
                            else if (((C.equals("X") && E.equals("X")) || (H.equals("X") && I.equals("X")) || (A.equals("X") && D.equals("X"))) && G.equals("7") && (level.equals("2") || level.equals("3"))){
                                current_move="7";}
                            else if (((A.equals("X")  && E.equals("X")) || (G.equals("X") && H.equals("X")) || (C.equals("X") && F.equals("X"))) && I.equals("9") && (level.equals("2") || level.equals("3"))){
                                current_move="9";}
                            else if (((E.equals("X") && I.equals("X")) || (B.equals("X") && C.equals("X")) || (G.equals("X") && D.equals("X"))) && A.equals("1") && (level.equals("2") || level.equals("3"))){
                                current_move="1";}
                            else if (((A.equals("X")  &&  C.equals("X")) || (H.equals("X") &&  E.equals("X"))) && B.equals("2") && (level.equals("2") || level.equals("3"))){
                                current_move="2";}
                            else if (((D.equals("X") && E.equals("X")) || (C.equals("X") && I.equals("X"))) && F.equals("6") && (level.equals("2") || level.equals("3"))){
                                current_move="6";}
                            else if (((E.equals("X") && F.equals("X")) || (A.equals("X") && G.equals("X"))) && D.equals("4") && (level.equals("2") || level.equals("3"))){
                                current_move="4";}
                            else if (((G.equals("X") && I.equals("X")) || (B.equals("X") && E.equals("X"))) && H.equals("8") && (level.equals("2") || level.equals("3"))){
                                current_move="8";}
                            else if (count==1 && E.equals("5") && level.equals("3")){
                                current_move="5";}
                            else if (count == 3 && level.equals("3")){
                                if (B.equals("3")){
                                    current_move = "3";}
                                else if (D.equals("4")){
                                    current_move = "4";}
                                else if (F.equals("6")){
                                    current_move = "6";}
                                else if (H.equals("8")){
                                    current_move = "8";}
                                }
                            else if (E.equals("5") && G.equals("7") && A.equals("1") && C.equals("3") && I.equals("9") && level.equals("3")){
                                // random.choice({"1","5","7","3","9"})
                                String[] n1arry = {"1","5","7","3","9"};
                                int n1indx = random.nextInt(5);
                                current_move = n1arry[n1indx];}
                            else if (E.equals("5") && level.equals("3")){
                                current_move="5";}
                            else if (C.equals("3") && I.equals("9") && level.equals("3")){
                                // Current_Move=random.choice(["9","3"])
                                String[] n2arry = {"9","3"};
                                int n2indx = random.nextInt(2);
                                current_move = n2arry[n2indx];}
                            else if (G.equals("7") && A.equals("1") && level.equals("3")){
                                // Current_Move=random.choice(["1","7"])
                                String[] n3arry = {"1","7"};
                                int n3indx = random.nextInt(2);
                                current_move = n3arry[n3indx];}
                            else if (G.equals("7") && level.equals("3")){
                                current_move="7";}
                            else if (A.equals("1") && level.equals("3")){
                                current_move="1";}
                            else if (I.equals("9") && level.equals("3")){
                                current_move="9";}
                            else if (C.equals("3") && level.equals("3")){
                                current_move="3";}
                            else{
                                current_move = getRandomElement(cmove);}
                        }else{
                            current_move= JOptionPane.showInputDialog(grid+"\n\n"+player+" move your turn by entering respective Number: ");
                        }
                    
                    while ((!current_move.equals("1") && !current_move.equals("2") && !current_move.equals("3") && !current_move.equals("4") && !current_move.equals("5") && !current_move.equals("6") && !current_move.equals("7") && !current_move.equals("8") && !current_move.equals("9")) || (arrayContains(moves,current_move))){
                        if (!current_move.equals("1") && !current_move.equals("2") && !current_move.equals("3") && !current_move.equals("4") && !current_move.equals("5") && !current_move.equals("6") && !current_move.equals("7") && !current_move.equals("8") && !current_move.equals("9")){
                            if (menu.equals("1")){
                                JOptionPane.showMessageDialog(null,"Invalid input.","Error...!",JOptionPane.ERROR_MESSAGE);
                                current_move=JOptionPane.showInputDialog(grid+"\n\n"+player+" try again: ") ;
                            }
                            else{
                                if (player.equals("Computer")){
                                        current_move = getRandomElement(cmove);
                                }else{
                                    JOptionPane.showMessageDialog(null,"Invalid input.","Error...!",JOptionPane.ERROR_MESSAGE);
                                    current_move=JOptionPane.showInputDialog(grid+"\n\n"+player+" try again: ") ;
                                }
                            }
                        }else if (arrayContains(moves,current_move)){
                            if (menu.equals("1")){
                                JOptionPane.showMessageDialog(null,"Already marked.","Error...!",JOptionPane.ERROR_MESSAGE);
                                current_move=JOptionPane.showInputDialog(grid+"\n\n"+ player+" try again: ");
                            }else{
                                if (player.equals("Computer")){
                                    current_move= getRandomElement(cmove);
                                }else{
                                    JOptionPane.showMessageDialog(null,"Already marked.","Error...!",JOptionPane.ERROR_MESSAGE);
                                    current_move=JOptionPane.showInputDialog(grid+"\n\n"+player+" try again: ") ;
                                }
                            }
                        }
                    }
                    moves[count]=current_move;
                    count++;
                    switch (current_move) {
                        case "1":
                            A=symbol;
                            break;
                        case "2":
                            B=symbol;
                            break;
                        case "3":
                            C=symbol;
                            break;
                        case "4":
                            D=symbol;
                            break;
                        case "5":
                            E=symbol;
                            break;
                        case "6":
                            F=symbol;
                            break;
                        case "7":
                            G=symbol;
                            break;
                        case "8":
                            H=symbol;
                            break;
                        case "9":
                            I=symbol;
                            break;
                        
                    }
                    grid = String.format(
                                            "       |       |      \n" +
                                            "   "+A+"   |   "+B+"   |   "+C+"  \n" +
                                            "_______|_______|______\n" +
                                            "       |       |      \n" +
                                            "   "+D+"   |   "+E+"   |   "+F+"  \n" +
                                            "_______|_______|______\n" +
                                            "       |       |      \n" +
                                            "   "+G+"   |   "+H+"   |   "+I+"  \n" +
                                            "       |       |      ");
                    if ((A.equals(B) && B.equals(C)) || (D.equals(E) && E.equals(F)) || (G.equals(H) && H.equals(I)) || (A.equals(D) && D.equals(G)) || (B.equals(E) && E.equals(H))  || (C.equals(F) && F.equals(I)) || (A.equals(E) && E.equals(I)) || (C.equals(E) && E.equals(G))){
                        break;}
                }
                if ((A.equals(B) && B.equals(C) && A.equals(symbol_of_nym1)) || (D.equals(E) && E.equals(F) && D.equals(symbol_of_nym1)) || (G.equals(H) && H.equals(I) && G.equals(symbol_of_nym1)) || (A.equals(D) && D.equals(G) && A.equals(symbol_of_nym1)) || (B.equals(E) && E.equals(H) && B.equals(symbol_of_nym1))  || (C.equals(F) && F.equals(I) && C.equals(symbol_of_nym1)) || (A.equals(E) && E.equals(I) && A.equals(symbol_of_nym1)) || (C.equals(E) && E.equals(G) && C.equals(symbol_of_nym1))){
                    if (menu.equals("1")){
                        JOptionPane.showMessageDialog(null,grid+"\n\n"+nym1+" you won the game.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                        // nym1Win++ ;
                    }else{
                        if (nym1.equals("Computer")){
                            JOptionPane.showMessageDialog(null,grid+"\n\n"+"You lose the game.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,grid+"\n\n"+nym1+" you won the game.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                            // nym1Win++ ;
                        }
                    }
                }else if ((A.equals(B) && B.equals(C) && A.equals(symbol_of_nym2)) || (D.equals(E) && E.equals(F) && D.equals(symbol_of_nym2)) || (G.equals(H) && H.equals(I) && G.equals(symbol_of_nym2)) || (A.equals(D) && D.equals(G) && A.equals(symbol_of_nym2)) || (B.equals(E) && E.equals(H) && B.equals(symbol_of_nym2))  || (C.equals(F) && F.equals(I) && C.equals(symbol_of_nym2)) || (A.equals(E) && E.equals(I) && A.equals(symbol_of_nym2)) || (C.equals(E) && E.equals(G) && C.equals(symbol_of_nym2))){
                    if(menu.equals("1")){
                        JOptionPane.showMessageDialog(null,grid+"\n\n"+nym2+" you won the game.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                        // nym2Win++;
                    }else{
                        if (nym2.equals("Computer")){
                            JOptionPane.showMessageDialog(null,grid+"\n\n"+"You lose the game.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,grid+"\n\n"+nym2+" you won the game.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                            // nym2Win++;
                        }
                    }
                }else if (count==9){
                    JOptionPane.showMessageDialog(null,grid+"\n\n"+"Game draw.","Game Result",JOptionPane.INFORMATION_MESSAGE);
                    // draw++;
                }
                if (toss_result==0){
                    Y = nym1;
                    nym1 = nym2 ;
                    nym2 = Y ;
                    symbol_of_nym1 = "X";
                    symbol_of_nym2 = "O";}
                play = JOptionPane.showInputDialog("Press 1 to play again\nPress anyother key to go back.");
            }
            mnud = JOptionPane.showInputDialog("Press 1 to return to menu.\nPress anyother key to exit.");
        }
        JOptionPane.showMessageDialog(null,"Game ended successfully.","Program End",JOptionPane.INFORMATION_MESSAGE);
}}