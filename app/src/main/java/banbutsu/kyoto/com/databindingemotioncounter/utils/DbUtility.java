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

    // 愛
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "好き好き大好き超愛してる"));
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "べ、べつにあんたのことなんか...   \uD83D\uDC97"));
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "やあ、また会ったねベイビー？"));
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "いいんだよ？"));
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "うれしいよ"));
    remarkEntries.add(new RemarkEntry(Utility.LOVE_E, "世界を革命する力を！"));

    // 性欲
    remarkEntries.add(new RemarkEntry(Utility.LIBIDO_E, "(ハァハァハァ)"));
    remarkEntries.add(new RemarkEntry(Utility.LIBIDO_E, "また会えたねベイベー"));
    remarkEntries.add(new RemarkEntry(Utility.LIBIDO_E, "（あなたから目が離せない...）"));

    // 楽観
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "心配しないで。最後にはうまくいくから！"));
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "大丈夫だよー！！"));
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "いけるいける！（根拠はない）"));
    remarkEntries.add(new RemarkEntry(Utility.OPTIMISM_E, "Yes! We! Can!! Yes! We! Can!! "));

    // 自尊心
    remarkEntries.add(new RemarkEntry(Utility.SELF_RESPECT_E, "でしょ？私そうなんだよね～"));
    remarkEntries.add(new RemarkEntry(Utility.SELF_RESPECT_E, "まーねー"));
    remarkEntries.add(new RemarkEntry(Utility.SELF_RESPECT_E, "いえいえそれほどでも"));

    // 予測
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(こ、これは...)"));
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(これから起こることがわかった)"));
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(おそらく、そうなるだろうな)"));
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(おまえの次のセリフは...)"));
    remarkEntries.add(new RemarkEntry(Utility.ANTICIPATION_E, "(おまえの次のセリフは...)"));

    // 驚き
    remarkEntries.add(new RemarkEntry(Utility.SURPRISE_E, "まじか！"));
    remarkEntries.add(new RemarkEntry(Utility.SURPRISE_E, "ええーっまさか？！"));

    // 嫌悪
    remarkEntries.add(new RemarkEntry(Utility.DISGUST_E, "ゲゲーッ"));
    remarkEntries.add(new RemarkEntry(Utility.DISGUST_E, "（まじキモイんですけど...）"));

    // 軽蔑
    remarkEntries.add(new RemarkEntry(Utility.CONTEMPT_E, "こういうやついるんだよな..."));
    remarkEntries.add(new RemarkEntry(Utility.CONTEMPT_E, "テメーはサイテーだ！"));
    remarkEntries.add(new RemarkEntry(Utility.CONTEMPT_E, "死ねばいいのに..."));

    // 怒り
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "ぶっ殺す！"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "許せない許せない許せないィィィィィィッッ!!"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "Grrrrrrrrrrrrrrruu!"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "なんだと？！"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "どういう意味だよ？！"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "テメーは俺を怒らせた！"));
    remarkEntries.add(new RemarkEntry(Utility.ANGER_E, "クリリンのことかーッッ!!"));

    // 攻撃性
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "今、殴りに行きます。"));
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "あー！やっぱそれ言っちゃう？じゃあぶっ殺すね？"));
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "テメーをいたぶる理由ができたぜ！"));
    remarkEntries.add(new RemarkEntry(Utility.AGGRESSIVENESS_E, "ヒャッハー！ヒャッハーって感じだよ！"));

    // 恐怖
    remarkEntries.add(new RemarkEntry(Utility.FEAR_E, "こわい！"));
    remarkEntries.add(new RemarkEntry(Utility.FEAR_E, "逃げてしまいたいです。"));
    remarkEntries.add(new RemarkEntry(Utility.FEAR_E, "どうなっちゃうんだろ..."));
    remarkEntries.add(new RemarkEntry(Utility.FEAR_E, "たすけて..."));

    // 悲しみ
    remarkEntries.add(new RemarkEntry(Utility.SADNESS_E, "私は悲しい"));
    remarkEntries.add(new RemarkEntry(Utility.SADNESS_E, "しくしく..."));
    remarkEntries.add(new RemarkEntry(Utility.SADNESS_E, "またひとり..."));

    // 失望
    remarkEntries.add(new RemarkEntry(Utility.DISAPPOINTMENT_E, "がっかりだよ..."));
    remarkEntries.add(new RemarkEntry(Utility.DISAPPOINTMENT_E, "そっか..."));
    remarkEntries.add(new RemarkEntry(Utility.DISAPPOINTMENT_E, "そうですか...それじゃまた別の機会に..."));

    // 羞恥心
    remarkEntries.add(new RemarkEntry(Utility.SHAME_E, "もうやだよー。"));
    remarkEntries.add(new RemarkEntry(Utility.SHAME_E, "（いや、もう、勘弁してください...）"));

    // 後悔
    remarkEntries.add(new RemarkEntry(Utility.REMORSE_E, "なんであんなことしちゃったかな..."));
    remarkEntries.add(new RemarkEntry(Utility.REMORSE_E, "私は馬鹿だ...大馬鹿者だ..."));
    remarkEntries.add(new RemarkEntry(Utility.REMORSE_E, "はぁ.................."));

    // 服従
    remarkEntries.add(new RemarkEntry(Utility.SUBMISSION_E, "ははーっ！御言葉のままに！"));
    remarkEntries.add(new RemarkEntry(Utility.SUBMISSION_E, "何でもしますから、それだけは..."));
    remarkEntries.add(new RemarkEntry(Utility.SUBMISSION_E, "後生です、後生ですから..."));

    // 畏怖
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "（おお....）"));
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "（ああ......）"));
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "（なんとまあ....ありがたや...）"));
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "アーメン..."));
    remarkEntries.add(new RemarkEntry(Utility.AWE_E, "なんまんだぶ..."));

    // 無
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "........"));
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "......................"));
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "zzz..."));
    remarkEntries.add(new RemarkEntry(Utility.NOTHING_E, "うとうと..."));
    return remarkEntries;
  }
}
