package com.example.game2048;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BestScore {
    public static long BestScore(long score){
        long bestScore=0;
        try {
            File myObj = new File("bestScore.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //read from file
        try {
            File myObj = new File("bestScore.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                bestScore= Long.parseLong(data)  ;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//write to  file
        if(bestScore<score) {
            try {
                FileWriter myWriter = new FileWriter("bestScore.txt");
                myWriter.write(score+"");
                myWriter.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return score;
        }
        else
            return bestScore;
    }
}
