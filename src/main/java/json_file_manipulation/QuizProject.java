package json_file_manipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuizProject {
    public static void main(String[] args) throws IOException, ParseException {

        Scanner i = new Scanner(System.in);

            System.out.println("1.Add Quiz\n" +
                    "2.Start Quiz");
            int bb = i.nextInt();
            switch(bb){
                case 1: addQuiz();
                break;
                case 2: startQuiz();
                break;

            }

    }

    private static void addQuiz() throws IOException, ParseException {
        char ch='y';
        String fileName = "./src/main/resources/quesionbank.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject quesionbankObj = new JSONObject();
            //creating questions
            Scanner input = new Scanner(System.in);
            System.out.println("please add a question here: ");
            quesionbankObj.put("Questions", input.nextLine());
            System.out.println("input options");
            System.out.println("option a: ");
            quesionbankObj.put("a", input.nextLine());

            System.out.println("option b: ");
            quesionbankObj.put("b", input.nextLine());

            System.out.println("option c: ");
            quesionbankObj.put("c", input.nextLine());

            System.out.println("option d: ");
            quesionbankObj.put("d", input.nextLine());

            System.out.println("please input  correct answer: ");
            quesionbankObj.put("correct ans", input.nextLine());

            JSONArray jsonQuestionBankArray = (JSONArray) obj;

            jsonQuestionBankArray.add(quesionbankObj);
            System.out.print(jsonQuestionBankArray);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonQuestionBankArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
//            System.out.print(jsonQuestionBankArray);
            System.out.println("\nDo you want to add more?[y/n]");

            ch = input.next().charAt(0);

        }while (ch!='n');

    }

    private static void startQuiz() throws IOException, ParseException {
        String fileName = "./src/main/resources/quesionbank.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        int points=0;
        for (int i=0;i<5;i++) {
            int rand1 = (int) (Math.random() * 20) + 1;
            JSONObject jsonObject = (JSONObject) jsonArray.get(rand1);

            String question = (String) jsonObject.get("Questions");
            String a = (String) jsonObject.get("a");
            String b = (String) jsonObject.get("b");
            String c = (String) jsonObject.get("c");
            String d = (String) jsonObject.get("d");
            String answer = (String) jsonObject.get("correct ans");

            System.out.println(question);
            System.out.println("a: "+ a);
            System.out.println("b: "+ b);
            System.out.println("c: "+c);
            System.out.println("d: "+d);

            Scanner input = new Scanner(System.in);
            char cc= input.next().charAt(0);

            if (answer.charAt(0) == cc){
                System.out.println("correct");
                points++;
            }else {
                System.out.println("not correct");
            }

        }
        System.out.println("you got " + points + " out of 5");


    }


}
