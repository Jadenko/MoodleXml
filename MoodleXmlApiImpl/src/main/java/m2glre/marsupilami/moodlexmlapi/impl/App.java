package m2glre.marsupilami.moodlexmlapi.impl;

import m2glre.marsupilami.moodlexmlapi.core.data.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        QuestionError questionError = new QuestionError("type not supported", "the question type is not supported");
        System.out.println(questionError.getDescription());
    }
}
