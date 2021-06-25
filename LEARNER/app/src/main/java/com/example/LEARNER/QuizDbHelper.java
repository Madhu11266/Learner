package com.example.LEARNER;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.LEARNER.QuizContract.*;
import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private static QuizDbHelper instance;
    private SQLiteDatabase db;
    private QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";
        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }
    private void fillCategoriesTable() {
        Category c1 = new Category("Programmingusingc");
        addCategory(c1);
        Category c2 = new Category("python");
        addCategory(c2);
        Category c3 = new Category("oose");
        addCategory(c3);
    }
    private void addCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }
    private void fillQuestionsTable() {
        Question q10 = new Question("Who is the father of C Language?",
                "Bjarne Stroustrup", "Dennis Ritchie", "James A.Gosling", 2,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q10);
        Question q11 = new Question("The activity of removing an error in the program is called ______",
                "Entering", "Debugging", "Editing", 2,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q11);
        Question q12 = new Question("Which of the following is a clause in the for loop structure?",
                "Asign", "Alter", "Both 1&2", 3,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q12);
        Question q13 = new Question("The method of checking the pseudo codes is called _______",
                "Branching", "iteration", "walk through", 3,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q13);
        Question q14 = new Question("The function scanf is used to _____",
                "To take logical decisions", "Input a set of values", "Print a set of values", 2,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q14);
        Question q15 = new Question("Which of the following format infers that data is displayed is a string?",
                "d", "f", "s", 3,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q15);
        Question q16 = new Question("The flow charts are _____",
                "A.Representing our thoughts exactly", "precise", "both 1&2", 3,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q16);
        Question q17 = new Question("By using _____ the speed of the process can be increased.",
                "Long integer", "short integer", "unsigned integer", 2,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q17);
        Question q18 = new Question("A structure declaration without any variables describe _______",
                "wizard", "Template", "shape of structure", 2,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q18);
        Question q19 = new Question("Which of the following are fundamental control structure?",
                "Iteration", "Branching", "Both 1&2", 3,
                Question.DIFFICULTY_EASY, Category.PROGRAMMINGUSINGC);
        addQuestion(q19);



        Question q20 = new Question("C was developed in the year ____",
                "1970", "1972", "1976", 2,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q20);
        Question q21 = new Question("C is a ____ language.",
                "high level", "low level", "medium level", 3,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q21);
        Question q22 = new Question("Which of the following are tokens in C?",
                "keywords", "variables", "both 1&2", 3,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q22);
        Question q23 = new Question("Which of the following language is the predecessor to C Programming Language?",
                "A", "B", "BCPL", 3,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q23);
        Question q24 = new Question("C language is available for which of the following Operating Systems?",
                "DOS", "windows", "Both 1&2", 3,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q24);
        Question q25 = new Question("Which of the following symbol is used to denote a pre-processor statement?",
                "!", "#", ";", 2,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q25);
        Question q26 = new Question("Which of the following is a Scalar Data type",
                "float", "union", "array", 1,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q26);
        Question q27 = new Question("Which symbol is used as a statement terminator in C?",
                "!", ";", "#", 2,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q27);
        Question q28 = new Question("String constants should be enclosed between ______.",
                "single quotes", "double quotes", "both 1&2", 2,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q28);
        Question q29 = new Question("Character constants should be enclosed between ______.",
                "single quotes", "double quotes", "both 1&2", 1,
                Question.DIFFICULTY_MEDIUM, Category.PROGRAMMINGUSINGC);
        addQuestion(q29);


        Question q30 = new Question("The maximum length of a variable in C is ______.",
                "8", "16", "32", 1,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q30);
        Question q31 = new Question("What will be the maximum size of a double variable?",
                "1byte", "2byte", "8byte", 3,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q31);
        Question q32 = new Question("The operator & is used for ",
                "bitwise AND", "bitwise OR", "Logical AND", 1,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q32);
        Question q33 = new Question("The operator / is used for",
                "Integer values", "Float values", "double values", 2,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q33);
        Question q34 = new Question("1.The equality operator is represented by",
                ":=", "==", "=", 2,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q34);
        Question q35 = new Question("Which of the following operator has the highest precedence?",
                "+", "=>", "*", 1,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q35);
        Question q36 = new Question("Which operator has the lowest priority?",
                "++", "||", "%", 2,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q36);
        Question q37 = new Question("The type cast operator is",
                "(type)", "cast()", "(;;)", 1,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q37);
        Question q38 = new Question("Header files in C contains",
                "compiler commands", "library functions", "operators for files", 2,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q38);
        Question q39 = new Question("Character constants should be enclosed between ______.",
                "single quotes", "double quotes", "both 1&2", 1,
                Question.DIFFICULTY_HARD, Category.PROGRAMMINGUSINGC);
        addQuestion(q39);



        Question q40 = new Question("Who developed the python language?",
                "Zim Den", "Guido van Rossum", "Niene Stom", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        addQuestion(q40);
        Question q41 = new Question("In which year the Python language developed?",
                "1995", "1972", "1989", 3,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        addQuestion(q41);
        Question q42 = new Question("Which of the following is the correct extension of the Python file?",
                ".py", ".p", ".python", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        addQuestion(q42);
        Question q43 = new Question("In which year was the Python 3.0 version developed?",
                "2008", "2000", "2010", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        addQuestion(q43);
        Question q44 = new Question("What is the method inside the class in python language?",
                "Object", "Function", "Attribute", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        addQuestion(q44);

        Question q45 = new Question("Which of the following is not a keyword in Python language?",
                "val", "raise", "try", 1,
                Question.DIFFICULTY_MEDIUM, Category.PYTHON);
        addQuestion(q45);
        Question q46 = new Question("Which of the following has the highest precedence in the expression?",
                "division", "subtraction", "parenthesis", 3,
                Question.DIFFICULTY_MEDIUM, Category.PYTHON);
        addQuestion(q46);
        Question q47 = new Question("Which of the following functions is a built-in function in python language?",
                "val()", "print()", "Both 1&2", 3,
                Question.DIFFICULTY_MEDIUM, Category.PYTHON);
        addQuestion(q47);
        Question q48 = new Question("Study the following function:\n" +
                "any([5>8,6>3,3>1])\n" +
                "\n" +
                "What will be the output of this code?",
                "False", "True", "Invalid code", 2,
                Question.DIFFICULTY_MEDIUM, Category.PYTHON);
        addQuestion(q48);
        Question q49 = new Question("1.Study the following statement:\n" +
                ">>>”a”+”bc”\n" +
                "\n" +
                "What will be the output of this statement?",
                "A.a+bc", "A.abc", "a bc", 2,
                Question.DIFFICULTY_MEDIUM, Category.PYTHON);
        addQuestion(q49);


        Question q50 = new Question("What do we use to define a block of code in Python language?",
                "key", "brackets", "Indentation", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        addQuestion(q50);
        Question q51= new Question("1.Which character is used in Python to make a single line comment?",
                "/", "//", "#", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        addQuestion(q51);
        Question q52= new Question("Is Python case sensitive when dealing with identifiers?",
                "yes", "no", "C.Machine dependent", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        addQuestion(q52);
        Question q53 = new Question("Which of the following is not a keyword?",
                "Eval", "Assert", "Pass", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        addQuestion(q53);
        Question q54= new Question("1.All keywords in Python are in _____.",
                "A.Lowercase", "B.Uppercase", "C.None of the mentioned", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        addQuestion(q54);




        Question q55 = new Question("Object-oriented systems development centers on the _______",
                "Object", "Entities", "Function", 1,
                Question.DIFFICULTY_EASY, Category.OOSE);
        addQuestion(q55);
        Question q56= new Question(" In an object-oriented environment Software is a collection of discrete objects that encapsulate data and —————",
                "Programs", "class", "Functions", 3,
                Question.DIFFICULTY_EASY, Category.OOSE);
        addQuestion(q56);
        Question q57= new Question("Each object has attributes and ————",
                "Function", "Methods", "both 1&2", 3,
                Question.DIFFICULTY_EASY, Category.OOSE);
        addQuestion(q57);
        Question q58 = new Question("Which of the following is the main advantage of object-oriented software development?",
                "Higher level of abstraction", "The seamless transition among different levels of software development", "both 1&2", 3,
                Question.DIFFICULTY_EASY, Category.OOSE);
        addQuestion(q58);
        Question q59= new Question("Which of the following describes the state of an object?",
                "Methods", "Data", "Attributes", 3,
                Question.DIFFICULTY_EASY, Category.OOSE);
        addQuestion(q59);


        Question q60 = new Question("Which of the following describes the behavior of an object?",
                "Methods", "Data", "Attributes", 1,
                Question.DIFFICULTY_MEDIUM, Category.OOSE);
        addQuestion(q60);
        Question q61= new Question(" Which of the following represents the relationship between object and classes?",
                "Generalization", "Classification", "Association", 3,
                Question.DIFFICULTY_MEDIUM, Category.OOSE);
        addQuestion(q61);
        Question q62= new Question("Cardinality related to ————",
                " Generalization", " Abstraction", "Association", 3,
                Question.DIFFICULTY_MEDIUM, Category.OOSE);
        addQuestion(q62);
        Question q63 = new Question("Client-server relationship is also known as —————",
                "Consumer producer relationship", "Class object relationship", "One to one relationship", 1,
                Question.DIFFICULTY_MEDIUM, Category.OOSE);
        addQuestion(q63);
        Question q64= new Question("An object can be an aggregation of other ————",
                "Objects", "Attributes", " Methods", 1,
                Question.DIFFICULTY_MEDIUM, Category.OOSE);
        addQuestion(q64);


        Question q65 = new Question("SA/SD approach encourages the ————— design.",
                "Bottom-up approach", " Top-bottom approach", "Random approach", 2,
                Question.DIFFICULTY_HARD, Category.OOSE);
        addQuestion(q65);
        Question q66= new Question("The process of determining at run time which function to invoke is termed ————–",
                "Compile-time binding", "Static binding", " Dynamic binding", 3,
                Question.DIFFICULTY_HARD, Category.OOSE);
        addQuestion(q66);
        Question q67= new Question("The goal of the object-oriented analysis is to identify ——————-and ———– that support the problem domain and system requirement.",
                "classes, objects", "user problem", " Entities", 1,
                Question.DIFFICULTY_HARD, Category.OOSE);
        addQuestion(q67);
        Question q68 = new Question(" In an object-oriented system an object belongs to a ———–",
                "Metaclass", " Function", "Message", 1,
                Question.DIFFICULTY_HARD, Category.OOSE);
        addQuestion(q68);
        Question q69= new Question(" ———— is an object template.",
                "class", "function", "method", 1,
                Question.DIFFICULTY_HARD, Category.OOSE);
        addQuestion(q69);








        Question q70 = new Question("Non existing, Easy: A is correct",
                "A", "B", "C", 1,
                Question.DIFFICULTY_EASY, 4);
        addQuestion(q70);
        Question q71 = new Question("Non existing, Medium: B is correct",
                "A", "B", "C", 2,
                Question.DIFFICULTY_MEDIUM, 5);
        addQuestion(q71);
    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }
        c.close();
        return categoryList;
    }
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question> getQuestions(int categoryID, String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};
        Cursor c = db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}