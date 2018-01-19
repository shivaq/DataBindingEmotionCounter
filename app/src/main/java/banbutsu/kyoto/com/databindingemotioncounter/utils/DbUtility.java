package banbutsu.kyoto.com.databindingemotioncounter.utils;

import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasuaki on 2018/01/19.
 */

public class DbUtility {

  public static List<RemarkEntry> getDefaultRemarks() {

    List<RemarkEntry> remarkEntries = new ArrayList<>();
    remarkEntries.add(new RemarkEntry("joy", "チョー嬉しい！"));

    remarkEntries.add(new RemarkEntry("trust", "任せるよ"));

    remarkEntries.add(new RemarkEntry("fear", "こわい！"));

    remarkEntries.add(new RemarkEntry("anticipation", "(こ、これは。。。)"));

    remarkEntries.add(new RemarkEntry("sadness", "私は悲しい"));

    remarkEntries.add(new RemarkEntry("disgust", "ゲゲーッ"));

    remarkEntries.add(new RemarkEntry("anger", "ぶっ殺す！"));

    remarkEntries.add(new RemarkEntry("surprise", "まじか！"));

    remarkEntries.add(new RemarkEntry("optimism", "心配しないで。最後にはうまくいくから！"));

    remarkEntries.add(new RemarkEntry("disappointment", "がっかりだよ。。。"));

    remarkEntries.add(new RemarkEntry("love", "好き好き大好き超愛してる"));

    remarkEntries.add(new RemarkEntry("remorse", "なんであんなことしちゃったかな。。。"));

    remarkEntries.add(new RemarkEntry("submission", "ははーっ！御言葉のままに！"));

    remarkEntries.add(new RemarkEntry("contempt", "こういうやついるんだよな。。。"));

    remarkEntries.add(new RemarkEntry("aggressiveness", "今、殴りに行きます。"));

    remarkEntries.add(new RemarkEntry("awe", "もう、心が震えて言葉も出ないです。"));

    remarkEntries.add(new RemarkEntry("libido", "(ハァハァハァ)"));

    remarkEntries.add(new RemarkEntry("shame", "もうやだよー。"));

    remarkEntries.add(new RemarkEntry("self_respect", "でしょ？私そうなんだよね～"));
    return remarkEntries;
  }
}
