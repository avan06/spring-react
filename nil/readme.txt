NILScript (NULL Infecting Library + Script runtime environment)
http://lukewarm.s151.xrea.com/nilscript.html

●概要

NILScriptは、JavaScriptベースのスクリプトホストです。
機能のほとんどをスクリプトで実装しているのが特徴です。
現在の所、32ビット版のWindowsXP以降でのみ動作確認されています。

それ以外の環境で実行した場合、環境と動作の成否、
エラーが発生した場合はその内容を、下記BBSまでご連絡ください。
http://lukewarm.s151.xrea.com/test/read.cgi/b/1264431038/
(書き込むには、メール欄に「sage」と書く必要があります)
Twitterのhttp://twitter.com/NILScriptでも連絡を受け付けています。
更新情報も、これらのページに掲載します。


●特徴

・機能の大部分がスクリプトとして実装されている
・ミックスインなどに対応したオブジェクト指向ライブラリ
・アスペクト指向的機能
・イベント機構など多彩なミックスインクラスを用意
・DLLの関数呼び出しや、構造体を扱うためのクラス
・ネイティブなマルチスレッド対応


●使用方法

install.batを実行することで、拡張子「.ng」のスクリプトファイルに関連付けを行なえます。
関連付けせずに実行する場合は、ng.exeのコマンドラインの最初の引数にスクリプトファイルのパスを指定してください。

エラー出力を読むために、コマンドプロンプト上で実行することをおすすめします。
実行ファイルと同じディレクトリにある「test.ng」を実行する場合なら、実行ファイルのディレクトリをカレントディレクトリにして「ng test」というコマンドラインで実行できます。

ngw.exeでは、コンソール画面を表示せずにスクリプトを実行させられます。
コマンドライン引数にスクリプトファイルパスを指定したショートカットを作成しておくといいでしょう。

スクリプト中で使用できるクラスや関数の説明は、docディレクトリにあります。
また、sampleディレクトリ内のサンプルスクリプトや、
libディレクトリ内の標準ユニットスクリプトの内容なども参考にしてください。

「start_httpd.bat」を実行すると、sample/HTTPD.ngが実行されます。
「http://localhost/ScriptEvaluator/console」でスクリプトコンソールが、
「http://localhost/doc」でドキュメントの閲覧・検索機能が利用できます。


アップデートで追加された機能の説明やサンプルは、changelog.txtや各ファイルの更新日時を参考に見つけてください。
test.ngが存在する場合、それは開発・試験段階の機能のサンプルスクリプトです。
重大な不具合をもたらすかもしれないので、テスト用の環境でお試し下さい。

ユニットスクリプトのディレクトリにあるtest.ngは、tool\test.ngで実行するテストスクリプトです。





JavaScriptの標準機能については、下記のページなどを参照してください。
https://developer.mozilla.org/en/JavaScript
https://developer.mozilla.org/ja/JavaScript

Processクラスのallプロパティや、Fileオブジェクトのchildrenプロパティなどは、
JavaScript1.7で追加された「イテレータ」形式のオブジェクトになっています。
このようなイテレータは、通常、下記のようなfor inループで使用します。

for(let v in SOME_ITERATOR /* (Process.allなどのイテレータ) */ ){
	/* vに代入された値を使用して何らかの処理を行う */
}

ブラウザのJavaScriptでは互換性の問題などからあまり使われないgetterやsetterも、多くの部分で使われています。





●ライセンス

スクリプト部分のライセンスはNUL+NULLです。
詳細は同梱のlicence.txtを参照してください。
独特のライセンス形態となっていますので、十分に注意してください。
なお、現在の所、スクリプトの動作確認目的での利用や、無償で閲覧可能なコンテンツ中での紹介を行うことは、NULLとは別に全て許諾するものとします。


バイナリ部分のライセンスその他の詳細に関しては、下記URLを参照してください。
http://lukewarm.me.land.to/








●既知の不具合


/*
下記のコードを実行すると希にJobListのスレッド上で不正終了などが発生する。
下記のコードをfor(var i=0;i<1000;i++){}内でループさせても発生しないことから、
関数の初回実行時に行われる処理が誤って複数のスレッドで実行されてしまったことが
原因では無いかと思われるが、詳しい原因は不明。
SpiderMonkeyのGCが一度も発生していない時点でも発生するようである。
SpiderMonkey側の不具合かも。
*/
var dl=new (require('HTTPDownloadList').HTTPDownloadList)(4,{
	directory:new Directory('R:\\test\\out'),
});
dl.observe('begin',function(){
	println('begin');
});
dl.observe('start',function(o){
	println('start:'+o.job.src);
});
dl.observe('complete',function(o){
	println('done:'+o.job.src);
	
});
dl.add('http://localhost:8888/1[1-9].png'.expand().toArray(),0,true);
dl.wait('end');
dl.free();
println("end");





