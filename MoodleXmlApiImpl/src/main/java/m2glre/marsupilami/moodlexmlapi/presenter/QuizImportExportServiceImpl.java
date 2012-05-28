package m2glre.marsupilami.moodlexmlapi.presenter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
import m2glre.marsupilami.moodlexmlapi.core.QuizImportExportService;
import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionTextFormat;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Answer;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.AnswerNumbering;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.AnswerNumerical;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.EssayQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MatchingQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MultipleChoiceQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.NumericalQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ShortAnswerQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Subquestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.TrueFalseQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Unit;
import m2glre.marsupilami.moodlexmlapi.impl.ImportedQuizImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QuizImportExportServiceImpl implements QuizImportExportService {

	private static String QUESTION = "question";
	private static String SUB_QUESTION = "subquestion";
	private static String TYPE = "type";
	private static String DESCRIPTION = "description";
	private static String ESSAY = "essay";
	private static String CALCULATED = "calculated";
	private static String MATCHING = "matching";
	private static String CLOZE = "cloze";
	private static String MULTI_CHOICE = "multichoice";
	private static String NUMERICAL = "numerical";
	private static String SHORT_ANSWER = "shortanswer";
	private static String TRUE_FALSE = "truefalse";
	private static String CATEGORY = "category";
	private static String NAME = "name";
	private static String QUESTION_TEXT = "questiontext";
	private static String FORMAT = "format";
	private static String IMAGE_URL = "image";
	private static String IMAGE_BASE_64 = "image_base64";
	private static String GENERAL_FEEDBACK = "generalfeedback";
	private static String CORRECT_FEEDBACK = "correctfeedback";
	private static String INCORRECT_FEEDBACK = "incorrectfeedback";
	private static String PARTIALLY_CORRECT_FEEDBACK = "partiallycorrectfeedback";
	private static String DEFAULT_GRAD = "defaultgrade";
	private static String PENALTY = "penalty";
	private static String HIDDEN = "hidden";
	private static String SHUFFLE_ANSWERS = "shuffleanswers";
	private static String ANSWER_NUMBERING = "answernumbering";
	private static String ANSWER = "answer";
	private static String FEEDBACK = "feedback";
	private static String FRACTION = "fraction";
	private static String TOLERANCE = "tolerance";
	private static String UNITS = "units";
	private static String UNIT = "unit";
	private static String UNIT_MULTIPLIER = "multiplier";
	private static String UNIT_NAME = "unit_name";
	private static String USECASE = "usecase";

	public QuizImportExportServiceImpl() {
		super();
	}

	public IImportedQuiz importQuiz(InputStream is)
			throws InvalidQuizFormatException, InvalidStreamSizeException {

		ImportedQuizImpl importedQuiz = new ImportedQuizImpl();

		importedQuiz.setQuestionList(new ArrayList<QuestionImpl>());
		importedQuiz.setExtractedQuestionList(new ArrayList<IQuestion>());
		importedQuiz.setNonExtractedQuestionList(new ArrayList<IQuestion>());
		importedQuiz.setProcessedQuestionList(new ArrayList<IQuestion>());

		CategoryQuestion categoryQuestion;
		GenericQuestion genericQuestion;
		EssayQuestion essayQuestion;
		MatchingQuestion matchingQuestion;
		MultipleChoiceQuestion multipleChoiceQuestion;
		NumericalQuestion numericalQuestion;
		ShortAnswerQuestion shortAnswerQuestion;
		TrueFalseQuestion trueFalseQuestion;

		QuestionText questionText = null;
		QuestionTextFormat DEFAULT_QUESTION_TEXT_FORMAT = QuestionTextFormat.plain_text;
		Answer answer;
		AnswerNumerical answerNumerical;
		Unit unit;
		Subquestion subquestion;

		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(is);
			Element quiz = document.getDocumentElement();
			NodeList questionsList = quiz.getElementsByTagName(QUESTION);
			NodeList questionChildNodesList;
			NodeList answerChildNodesList;
			NodeList subquestionChildNodesList;
			NodeList unitsChildNodesList;
			NodeList unitChildNodesList;
			String questionName = null;
			String questionType = null;
			String generalFeedBack = null;
			float penalty = 0;
			float defaultGrade = 0;
			boolean isHidden = false;
			String imageUrl = null;
			String imageBase64 = null;
			List<QuestionError> errors;
			QuestionError questionError;

			for (int i = 0; i < questionsList.getLength(); i++) {
				genericQuestion = new GenericQuestion();
				errors = new ArrayList<QuestionError>();
				questionChildNodesList = questionsList.item(i).getChildNodes();
				errors = new ArrayList<QuestionError>();
				if (questionsList.item(i).getAttributes().getNamedItem(TYPE) != null) {
					questionType = questionsList.item(i).getAttributes()
							.getNamedItem(TYPE).getNodeValue();
					if (questionType.equalsIgnoreCase(CATEGORY)) {
						categoryQuestion = new CategoryQuestion();
						categoryQuestion.setCategory(CATEGORY);
						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(CATEGORY)) {
								categoryQuestion
										.setCourse(questionChildNodesList.item(
												j).getTextContent());
							}
						}
						importedQuiz.getExtractedQuestionList().add(
								categoryQuestion);
						importedQuiz.getQuestionList().add(categoryQuestion);
					} else if (questionType.equalsIgnoreCase(ESSAY)) {

						essayQuestion = new EssayQuestion();
						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(SHUFFLE_ANSWERS)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								essayQuestion
										.setShuffleanswers(Integer
												.getInteger(questionChildNodesList
														.item(j).getNodeValue()) == 1 ? true
												: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(ANSWER)) {
								answer = new Answer();
								answer.setText(questionChildNodesList.item(j)
										.getTextContent());
								answerChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								if (answerChildNodesList != null) {
									if (questionChildNodesList.item(j)
											.getAttributes() != null
											&& questionChildNodesList.item(j)
													.getAttributes()
													.getNamedItem(FRACTION) != null) {
										answer.setFraction(Float
												.valueOf(questionChildNodesList
														.item(j)
														.getAttributes()
														.getNamedItem(FRACTION)
														.getNodeValue()));
									}
									for (int k = 0; k < answerChildNodesList
											.getLength(); k++) {
										if (answerChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(FEEDBACK)) {
											answer.setFeedback(answerChildNodesList
													.item(k).getTextContent());
										}
									}
								}
								essayQuestion.setAnswer(answer);
							}
						}
						essayQuestion.setName(questionName);
						essayQuestion.setQuestionText(questionText);
						essayQuestion.setGeneralFeedBack(generalFeedBack);
						essayQuestion.setPenalty(penalty);
						essayQuestion.setDefaultGrade(defaultGrade);
						essayQuestion.setIsHidden(isHidden);
						essayQuestion.setImageUrl(imageUrl);
						essayQuestion.setImageBase64(imageBase64);
						essayQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(essayQuestion);
						importedQuiz.getExtractedQuestionList().add(
								essayQuestion);
					} else if (questionType.equalsIgnoreCase(MATCHING)) {

						matchingQuestion = new MatchingQuestion();
						matchingQuestion
								.setSubquestion(new ArrayList<Subquestion>());
						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(SHUFFLE_ANSWERS)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								matchingQuestion
										.setShuffleanswers(Integer
												.getInteger(questionChildNodesList
														.item(j).getNodeValue()) == 1 ? true
												: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(SUB_QUESTION)) {
								subquestion = new Subquestion();
								subquestion.setText(questionChildNodesList
										.item(j).getTextContent());
								subquestionChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								if (subquestionChildNodesList != null) {
									for (int k = 0; k < subquestionChildNodesList
											.getLength(); k++) {
										if (subquestionChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(ANSWER)) {
											answer = new Answer();
											answer.setText(subquestionChildNodesList
													.item(k).getTextContent());
											subquestion.setAnswer(answer);
										}
									}
								}
								matchingQuestion.getSubquestion().add(
										subquestion);
							}
						}
						matchingQuestion.setName(questionName);
						matchingQuestion.setQuestionText(questionText);
						matchingQuestion.setGeneralFeedBack(generalFeedBack);
						matchingQuestion.setPenalty(penalty);
						matchingQuestion.setDefaultGrade(defaultGrade);
						matchingQuestion.setIsHidden(isHidden);
						matchingQuestion.setImageUrl(imageUrl);
						matchingQuestion.setImageBase64(imageBase64);
						matchingQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(matchingQuestion);
						importedQuiz.getExtractedQuestionList().add(
								matchingQuestion);
					} else if (questionType.equalsIgnoreCase(MULTI_CHOICE)) {

						multipleChoiceQuestion = new MultipleChoiceQuestion();
						multipleChoiceQuestion
								.setAnswer(new ArrayList<Answer>());
						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(SHUFFLE_ANSWERS)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								multipleChoiceQuestion
										.setShuffleanswers(Integer
												.getInteger(questionChildNodesList
														.item(j).getNodeValue()) == 1 ? true
												: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(CORRECT_FEEDBACK)) {
								multipleChoiceQuestion
										.setCorrectfeedback(questionChildNodesList
												.item(j).getTextContent());
							} else if (questionChildNodesList
									.item(j)
									.getNodeName()
									.equalsIgnoreCase(
											PARTIALLY_CORRECT_FEEDBACK)) {
								multipleChoiceQuestion
										.setPartiallycorrectfeedback(questionChildNodesList
												.item(j).getTextContent());
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(INCORRECT_FEEDBACK)) {
								multipleChoiceQuestion
										.setIncorrectfeedback(questionChildNodesList
												.item(j).getTextContent());
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(ANSWER_NUMBERING)) {
								if (questionChildNodesList.item(j)
										.getNodeValue() != null) {
									multipleChoiceQuestion
											.setAnswernumbering(AnswerNumbering
													.valueOf(questionChildNodesList
															.item(j)
															.getTextContent()));
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(ANSWER)) {
								answer = new Answer();
								answer.setText(questionChildNodesList.item(j)
										.getTextContent());
								answerChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								if (answerChildNodesList != null) {
									if (questionChildNodesList.item(j)
											.getAttributes() != null
											&& questionChildNodesList.item(j)
													.getAttributes()
													.getNamedItem(FRACTION) != null) {
										answer.setFraction(Float
												.valueOf(questionChildNodesList
														.item(j)
														.getAttributes()
														.getNamedItem(FRACTION)
														.getNodeValue()));
									}
									for (int k = 0; k < answerChildNodesList
											.getLength(); k++) {
										if (answerChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(FEEDBACK)) {
											answer.setFeedback(answerChildNodesList
													.item(k).getTextContent());
										}
									}
								}
								multipleChoiceQuestion.getAnswer().add(answer);
							}
						}

						multipleChoiceQuestion.setName(questionName);
						multipleChoiceQuestion.setQuestionText(questionText);
						multipleChoiceQuestion
								.setGeneralFeedBack(generalFeedBack);
						multipleChoiceQuestion.setPenalty(penalty);
						multipleChoiceQuestion.setDefaultGrade(defaultGrade);
						multipleChoiceQuestion.setIsHidden(isHidden);
						multipleChoiceQuestion.setImageUrl(imageUrl);
						multipleChoiceQuestion.setImageBase64(imageBase64);
						multipleChoiceQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(
								multipleChoiceQuestion);
						importedQuiz.getExtractedQuestionList().add(
								multipleChoiceQuestion);
					} else if (questionType.equalsIgnoreCase(NUMERICAL)) {
						numericalQuestion = new NumericalQuestion();
						numericalQuestion.setUnit(new ArrayList<Unit>());
						numericalQuestion
								.setAnswer(new ArrayList<AnswerNumerical>());

						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(ANSWER)) {
								answerNumerical = new AnswerNumerical();
								answerNumerical.setText(questionChildNodesList
										.item(j).getTextContent());
								answerChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								if (answerChildNodesList != null) {
									if (questionChildNodesList.item(j)
											.getAttributes() != null
											&& questionChildNodesList.item(j)
													.getAttributes()
													.getNamedItem(FRACTION) != null) {
										answerNumerical.setFraction(Float
												.valueOf(questionChildNodesList
														.item(j)
														.getAttributes()
														.getNamedItem(FRACTION)
														.getNodeValue()));
									}
									for (int k = 0; k < answerChildNodesList
											.getLength(); k++) {
										if (answerChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(FEEDBACK)) {
											answerNumerical
													.setFeedback(answerChildNodesList
															.item(k)
															.getTextContent());
										}
										if (answerChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(TOLERANCE)
												&& answerChildNodesList.item(k)
														.getNodeValue() != null) {
											answerNumerical
													.setTolerance(Float
															.valueOf(answerChildNodesList
																	.item(k)
																	.getNodeValue()));
										}
									}
								}
								numericalQuestion.getAnswer().add(
										answerNumerical);
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(UNITS)) {
								unitsChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								for (int k = 0; k < unitsChildNodesList
										.getLength(); k++) {
									if (unitsChildNodesList.item(k)
											.getNodeName()
											.equalsIgnoreCase(UNIT)) {
										unit = new Unit();
										unitChildNodesList = unitsChildNodesList
												.item(k).getChildNodes();
										for (int l = 0; l < unitChildNodesList
												.getLength(); l++) {
											if (unitChildNodesList
													.item(l)
													.getNodeName()
													.equalsIgnoreCase(
															UNIT_MULTIPLIER)
													&& unitChildNodesList.item(
															l).getNodeValue() != null) {
												unit.setMultiplier(Integer
														.valueOf(unitChildNodesList
																.item(l)
																.getNodeValue()));
											} else if (unitChildNodesList
													.item(l)
													.getNodeName()
													.equalsIgnoreCase(UNIT_NAME)
													&& unitChildNodesList.item(
															l).getNodeValue() != null) {
												unit.setUnit_name(unitChildNodesList
														.item(l).getNodeValue());
											}
										}
										numericalQuestion.getUnit().add(unit);
									}
								}
							}
						}

						numericalQuestion.setName(questionName);
						numericalQuestion.setQuestionText(questionText);
						numericalQuestion.setGeneralFeedBack(generalFeedBack);
						numericalQuestion.setPenalty(penalty);
						numericalQuestion.setDefaultGrade(defaultGrade);
						numericalQuestion.setIsHidden(isHidden);
						numericalQuestion.setImageUrl(imageUrl);
						numericalQuestion.setImageBase64(imageBase64);

						numericalQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(numericalQuestion);
						importedQuiz.getExtractedQuestionList().add(
								numericalQuestion);
					} else if (questionType.equalsIgnoreCase(SHORT_ANSWER)) {

						shortAnswerQuestion = new ShortAnswerQuestion();
						shortAnswerQuestion.setAnswer(new ArrayList<Answer>());

						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(USECASE)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								shortAnswerQuestion
										.setUsecase(Integer
												.getInteger(questionChildNodesList
														.item(j).getNodeValue()) == 1 ? true
												: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(ANSWER)) {
								answer = new Answer();
								answer.setText(questionChildNodesList.item(j)
										.getTextContent());
								answerChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								if (answerChildNodesList != null) {
									if (questionChildNodesList.item(j)
											.getAttributes() != null
											&& questionChildNodesList.item(j)
													.getAttributes()
													.getNamedItem(FRACTION) != null) {
										answer.setFraction(Float
												.valueOf(questionChildNodesList
														.item(j)
														.getAttributes()
														.getNamedItem(FRACTION)
														.getNodeValue()));
									}
									for (int k = 0; k < answerChildNodesList
											.getLength(); k++) {
										if (answerChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(FEEDBACK)) {
											answer.setFeedback(answerChildNodesList
													.item(k).getTextContent());
										}
									}
								}
								shortAnswerQuestion.getAnswer().add(answer);
							}
						}

						shortAnswerQuestion.setName(questionName);
						shortAnswerQuestion.setQuestionText(questionText);
						shortAnswerQuestion.setGeneralFeedBack(generalFeedBack);
						shortAnswerQuestion.setPenalty(penalty);
						shortAnswerQuestion.setDefaultGrade(defaultGrade);
						shortAnswerQuestion.setIsHidden(isHidden);
						shortAnswerQuestion.setImageUrl(imageUrl);
						shortAnswerQuestion.setImageBase64(imageBase64);

						shortAnswerQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(shortAnswerQuestion);
						importedQuiz.getExtractedQuestionList().add(
								shortAnswerQuestion);
					} else if (questionType.equalsIgnoreCase(TRUE_FALSE)) {

						trueFalseQuestion = new TrueFalseQuestion();
						trueFalseQuestion.setAnswer(new ArrayList<Answer>());

						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(ANSWER)) {
								answer = new Answer();
								answer.setText(questionChildNodesList.item(j)
										.getTextContent());
								answerChildNodesList = questionChildNodesList
										.item(j).getChildNodes();
								if (answerChildNodesList != null) {
									if (questionChildNodesList.item(j)
											.getAttributes() != null
											&& questionChildNodesList.item(j)
													.getAttributes()
													.getNamedItem(FRACTION) != null) {
										answer.setFraction(Float
												.valueOf(questionChildNodesList
														.item(j)
														.getAttributes()
														.getNamedItem(FRACTION)
														.getNodeValue()));
									}
									for (int k = 0; k < answerChildNodesList
											.getLength(); k++) {
										if (answerChildNodesList.item(k)
												.getNodeName()
												.equalsIgnoreCase(FEEDBACK)) {
											answer.setFeedback(answerChildNodesList
													.item(k).getTextContent());
										}
									}
								}
								trueFalseQuestion.getAnswer().add(answer);
							}
						}

						trueFalseQuestion.setName(questionName);
						trueFalseQuestion.setQuestionText(questionText);
						trueFalseQuestion.setGeneralFeedBack(generalFeedBack);
						trueFalseQuestion.setPenalty(penalty);
						trueFalseQuestion.setDefaultGrade(defaultGrade);
						trueFalseQuestion.setIsHidden(isHidden);
						trueFalseQuestion.setImageUrl(imageUrl);
						trueFalseQuestion.setImageBase64(imageBase64);

						trueFalseQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(trueFalseQuestion);
						importedQuiz.getExtractedQuestionList().add(
								trueFalseQuestion);
					} else if (questionType.equalsIgnoreCase(CLOZE)
							|| questionType.equalsIgnoreCase(DESCRIPTION)
							|| questionType.equalsIgnoreCase(CALCULATED)) {

						for (int j = 0; j < questionChildNodesList.getLength(); j++) {
							if (questionChildNodesList.item(j).getNodeName()
									.equalsIgnoreCase(NAME)) {
								questionName = questionChildNodesList.item(j)
										.getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(QUESTION_TEXT)) {
								if (questionChildNodesList.item(j)
										.getAttributes().getNamedItem(FORMAT) != null) {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											QuestionTextFormat
													.valueOf(questionChildNodesList
															.item(j)
															.getAttributes()
															.getNamedItem(
																	FORMAT)
															.getNodeValue()));
								} else {
									questionText = new QuestionText(
											questionChildNodesList.item(j)
													.getTextContent(),
											DEFAULT_QUESTION_TEXT_FORMAT);
								}
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(IMAGE_URL)) {
								imageUrl = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(IMAGE_BASE_64)) {
								imageBase64 = questionChildNodesList.item(j)
										.getNodeValue();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(GENERAL_FEEDBACK)) {
								generalFeedBack = questionChildNodesList
										.item(j).getTextContent();
							} else if (questionChildNodesList.item(j)
									.getNodeName()
									.equalsIgnoreCase(DEFAULT_GRAD)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								defaultGrade = Float
										.valueOf(questionChildNodesList.item(j)
												.getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(PENALTY)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								penalty = Float.valueOf(questionChildNodesList
										.item(j).getNodeValue());
							} else if (questionChildNodesList.item(j)
									.getNodeName().equalsIgnoreCase(HIDDEN)
									&& questionChildNodesList.item(j)
											.getNodeValue() != null) {
								isHidden = (Integer
										.getInteger(questionChildNodesList
												.item(j).getNodeValue()) == 1 ? true
										: false);
							}
						}

						genericQuestion.setType(QuestionType
								.valueOf(questionType));
						genericQuestion.setName(questionName);
						genericQuestion.setQuestionText(questionText);
						genericQuestion.setGeneralFeedBack(generalFeedBack);
						genericQuestion.setPenalty(penalty);
						genericQuestion.setDefaultGrade(defaultGrade);
						genericQuestion.setIsHidden(isHidden);
						genericQuestion.setImageUrl(imageUrl);
						genericQuestion.setImageBase64(imageBase64);
						genericQuestion.setErrors(errors);
						importedQuiz.getQuestionList().add(genericQuestion);
						importedQuiz.getExtractedQuestionList().add(
								genericQuestion);
					} else {
						questionError = new QuestionError("0001",
								"Unknown question type");
						errors.add(questionError);
						genericQuestion.setErrors(errors);
						importedQuiz.getNonExtractedQuestionList().add(
								genericQuestion);
					}

				}
				importedQuiz.getProcessedQuestionList().add(genericQuestion);
			}

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importedQuiz;
	}

	public OutputStream exportQuiz(IQuiz quiz) {
		// TODO priorité 3 - externaliser le path
		final String PATH_FILE = "./quiz-jaxb.xml";

		// create JAXB context and instantiate marshaller

		JAXBContext context;
		OutputStream os = null;
		try {

			context = JAXBContext.newInstance(Quiz.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,"");
			os = new FileOutputStream(PATH_FILE);
			m.marshal(quiz, os);
			// ligne suivante à enlever
			m.marshal(quiz, System.out);

		} catch (JAXBException e1) {
			// TODO Priorité: 3 - externaliser les msgs
			System.err
					.println("Marsupilami's Project: Erreur JAXB - "
							+ "Survenue lors de la sérialisation (Objet Java -> Moodle Xml)");
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Marsupilami's Project:");
			e.printStackTrace();
		}

		return os;
	}

}