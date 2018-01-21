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

    // 喜び
    remarkEntries.add(new RemarkEntry(Utility.JOY_E, "チョー嬉しい！"));
    remarkEntries.add(new RemarkEntry(Utility.JOY_E, "やったーーーー！！！！！"));

    // 信頼
    remarkEntries.add(new RemarkEntry(Utility.TRUST_E, "任せるよ"));
    remarkEntries.add(new RemarkEntry(Utility.TRUST_E, "もちろん！"));

    // 恐怖
    remarkEntries.add(new RemarkEntry(Utility.FEAR_E, "こわい！"));
    remarkEntries.add(new RemarkEntry(Utility.FEAR_E, "逃げてしまいたいです。"));

    // 予測
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(こ、これは...)"));
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(これから起こることがわかった)"));

    // 悲しみ
    remarkEntries.add(new RemarkEntry(Utility.SADNESS_E, "私は悲しい"));
    remarkEntries.add(new RemarkEntry(Utility.SADNESS_E, "しくしく..."));

    // 嫌悪
    remarkEntries.add(new RemarkEntry(Utility.DISGUST_E, "ゲゲーッ"));
    remarkEntries.add(new RemarkEntry(Utility.DISGUST_E, "（まじキモイんですけど...）"));

    // 怒り
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "ぶっ殺す！"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "許せない許せない許せないィィィィィィッッ!!"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "Grrrrrrrrrrrrrrruu!"));

    // 驚き
    remarkEntries.add(new RemarkEntry(Utility.SURPRISE_E, "まじか！"));
    remarkEntries.add(new RemarkEntry(Utility.SURPRISE_E, "ええーっまさか？！"));

    // 楽観
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "心配しないで。最後にはうまくいくから！"));
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "大丈夫だよー！！"));
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "いけるいける！（根拠はない）"));

    // 失望
    remarkEntries.add(new RemarkEntry(Utility.DISAPPOINTMENT_E, "がっかりだよ..."));
    remarkEntries.add(new RemarkEntry(Utility.DISAPPOINTMENT_E, "そっか..."));
    remarkEntries.add(new RemarkEntry(Utility.DISAPPOINTMENT_E, "そうですか...それじゃまた別の機会に..."));

    // 愛
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "好き好き大好き超愛してる"));
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "べ、べつにあんたのことなんか...   \uD83D\uDC97"));

    // 後悔
    remarkEntries.add(new RemarkEntry(Utility.REMORSE_E, "なんであんなことしちゃったかな..."));
    remarkEntries.add(new RemarkEntry(Utility.REMORSE_E, "私は馬鹿だ...大馬鹿者だよくそったれ..."));

    // 服従
    remarkEntries.add(new RemarkEntry(Utility.SUBMISSION_E, "ははーっ！御言葉のままに！"));
    remarkEntries.add(new RemarkEntry(Utility.SUBMISSION_E, "何でもしますから、それだけは..."));
    remarkEntries.add(new RemarkEntry(Utility.SUBMISSION_E, "後生です、後生ですから..."));

    // 軽蔑
    remarkEntries.add(new RemarkEntry(Utility.CONTEMPT_E, "こういうやついるんだよな..."));
    remarkEntries.add(new RemarkEntry(Utility.CONTEMPT_E, "テメーはサイテーだ！"));

    // 攻撃性
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "今、殴りに行きます。"));
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "あー！やっぱそれ言っちゃう？それ...ぶっ殺す"));
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "テメーをいたぶる理由ができたぜ！"));
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "ヒャッハー！ヒャッハーって感じだよ！"));

    // 畏怖
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "（もう、心が震えて言葉も出ない）"));
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "（もう、どうしようもないよ）"));
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "（母上様、あの日の朝食、おいしゅうございました...）"));

    // 性欲
    remarkEntries.add(new RemarkEntry(Utility.LIBIDO_E, "(ハァハァハァ)"));
    remarkEntries.add(new RemarkEntry(Utility.LIBIDO_E, "また会えたねベイベー"));
    remarkEntries.add(new RemarkEntry(Utility.LIBIDO_E, "（あなたから目が離せない...）"));

    // 羞恥心
    remarkEntries.add(new RemarkEntry(Utility.SHAME_E, "もうやだよー。"));
    remarkEntries.add(new RemarkEntry(Utility.SHAME_E, "（いや、もう、勘弁してください...）"));

    // 自尊心
    remarkEntries.add(new RemarkEntry(Utility.SELF_RESPECT_E, "でしょ？私そうなんだよね～"));
    remarkEntries.add(new RemarkEntry(Utility.SELF_RESPECT_E, "まーねー"));
    remarkEntries.add(new RemarkEntry(Utility.SELF_RESPECT_E, "いえいえそれほどでも"));

    // 無
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "........"));
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "......................"));
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "zzz..."));
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "うとうと..."));
    return remarkEntries;
  }
}
