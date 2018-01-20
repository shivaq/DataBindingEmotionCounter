package banbutsu.kyoto.com.databindingemotioncounter.utils;

import android.support.annotation.StringDef;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;

/**
 * Created by Yasuaki on 2018/01/19.
 */

public class Utility {

  public static long getTomorrowMidnight() {
    Calendar calendar = Calendar.getInstance();

    // 明日の 0 時にセット
    calendar.add(Calendar.DAY_OF_YEAR, 1);
    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);

    return calendar.getTimeInMillis();
  }

  public static int getEmotionDrawable(String emotion) {
    int drawableId;
    switch (emotion) {
      case JOY_E:
        drawableId = R.drawable.ic_face_joy_selected;
        break;
      case TRUST_E:
        drawableId = R.drawable.ic_trust_to_left;
        break;
      case FEAR_E:
        drawableId = R.drawable.ic_fear_to_left;
        break;
      case ANTICIPATION_E:
        drawableId = R.drawable.ic_anticipation_to_left;
        break;
      case SADNESS_E:
        drawableId = R.drawable.ic_face_sadness_selected;
        break;
      case DISGUST_E:
        drawableId = R.drawable.ic_disgust_to_left;
        break;
      case ANGER_E:
        drawableId = R.drawable.ic_anger_to_left;
        break;
      case SURPRISE_E:
        drawableId = R.drawable.ic_surprise_to_left;
        break;
      case LIBIDO_E:
        drawableId = R.drawable.ic_libido_to_left;
        break;
      case SHAME_E:
        drawableId = R.drawable.ic_face_shame_selected;
        break;
      case SELF_RESPECT_E:
        drawableId = R.drawable.ic_face_self_respect_selected;
        break;
      case "nothing":
      default:
        drawableId = R.drawable.ic_normal_woman_bob_collar1;
        break;
    }
    return drawableId;
  }

  public static String getEmotionString(String emotion) {
    String emotionStr;
    switch (emotion) {
      case JOY_E:
        emotionStr = JOY;
        break;
      case TRUST_E:
        emotionStr = TRUST;
        break;
      case FEAR_E:
        emotionStr = FEAR;
        break;
      case ANTICIPATION_E:
        emotionStr = ANTICIPATION;
        break;
      case SADNESS_E:
        emotionStr = SADNESS;
        break;
      case DISGUST_E:
        emotionStr = DISGUST;
        break;
      case ANGER_E:
        emotionStr = ANGER;
        break;
      case SURPRISE_E:
        emotionStr = SURPRISE;
        break;
      case LIBIDO_E:
        emotionStr = LIBIDO;
        break;
      case SHAME_E:
        emotionStr = SHAME;
        break;
      case SELF_RESPECT_E:
        emotionStr = SELF_RESPECT;
        break;
      case "nothing":
      default:
        emotionStr = "無";
        break;
    }
    return emotionStr;
  }

  public static String getMixedEmotionString(String em1, String em2) {
    String mixedEmotion = "";
    switch (em1) {
      case JOY:
        if (em2.equals(TRUST)) {
          mixedEmotion = LOVE;
        }else if(em2.equals(ANTICIPATION)){
          mixedEmotion = OPTIMISM;
        }
        break;
      case TRUST:
        if (em2.equals(JOY)) {
          mixedEmotion = LOVE;
        }else if(em2.equals(FEAR)){
          mixedEmotion = SUBMISSION;
        }
        break;
      case FEAR:
        if (em2.equals(TRUST)) {
          mixedEmotion = SUBMISSION;
        }else if(em2.equals(SURPRISE)){
          mixedEmotion = AWE;
        }
        break;
      case ANTICIPATION:
        if (em2.equals(JOY)) {
          mixedEmotion = OPTIMISM;
        }else if(em2.equals(ANGER)){
          mixedEmotion = AGGRESSIVENESS;
        }
        break;
      case SADNESS:
        if (em2.equals(DISGUST)) {
          mixedEmotion = REMORSE;
        }else if(em2.equals(SURPRISE)){
          mixedEmotion = DISAPPOINTMENT;
        }
        break;
      case DISGUST:
        if (em2.equals(SADNESS)) {
          mixedEmotion = REMORSE;
        }else if(em2.equals(ANGER)){
          mixedEmotion = CONTEMPT;
        }
        break;
      case ANGER:
        if (em2.equals(ANTICIPATION)) {
          mixedEmotion = AGGRESSIVENESS;
        }else if(em2.equals(DISGUST)){
          mixedEmotion = CONTEMPT;
        }
        break;
      case SURPRISE:
        if (em2.equals(FEAR)) {
          mixedEmotion = AWE;
        }else if(em2.equals(SADNESS)){
          mixedEmotion = DISAPPOINTMENT;
        }
        break;
    }
    return mixedEmotion;
  }

  @Retention(RetentionPolicy.SOURCE)
  @StringDef({JOY, TRUST, FEAR, ANTICIPATION, SADNESS, DISGUST, ANGER, SURPRISE, OPTIMISM,
      DISAPPOINTMENT, LOVE, REMORSE, SUBMISSION, CONTEMPT, AGGRESSIVENESS, AWE, LIBIDO, SHAME,
      SELF_RESPECT})
  public @interface AllEmotionDef {

  }

  public static final String JOY = "喜び";
  public static final String TRUST = "信頼";
  public static final String FEAR = "恐怖";
  public static final String ANTICIPATION = "予測";
  public static final String SADNESS = "悲しみ";
  public static final String DISGUST = "嫌悪";
  public static final String ANGER = "怒り";
  public static final String SURPRISE = "驚き";
  public static final String OPTIMISM = "楽観";
  public static final String DISAPPOINTMENT = "失望";
  public static final String LOVE = "愛";
  public static final String REMORSE = "後悔";
  public static final String SUBMISSION = "服従";
  public static final String CONTEMPT = "軽蔑";
  public static final String AGGRESSIVENESS = "攻撃性";
  public static final String AWE = "畏怖";
  public static final String LIBIDO = "性欲";
  public static final String SHAME = "恥";
  public static final String SELF_RESPECT = "自尊心";

  public static final String JOY_E = "JOY";
  public static final String TRUST_E = "TRUST";
  public static final String FEAR_E = "FEAR";
  public static final String ANTICIPATION_E = "ANTICIPATION";
  public static final String SADNESS_E = "SADNESS";
  public static final String DISGUST_E = "DISGUST";
  public static final String ANGER_E = "ANGER";
  public static final String SURPRISE_E = "SURPRISE";
  public static final String OPTIMISM_E = "OPTIMISM";
  public static final String DISAPPOINTMENT_E = "DISAPPOINTMENT";
  public static final String LOVE_E = "LOVE";
  public static final String REMORSE_E = "REMORSE";
  public static final String SUBMISSION_E = "SUBMISSION";
  public static final String CONTEMPT_E = "CONTEMPT";
  public static final String AGGRESSIVENESS_E = "AGGRESSIVENESS";
  public static final String AWE_E = "AWE";
  public static final String LIBIDO_E = "LIBIDO";
  public static final String SHAME_E = "SHAME";
  public static final String SELF_RESPECT_E = "SELF_RESPECT";
}
