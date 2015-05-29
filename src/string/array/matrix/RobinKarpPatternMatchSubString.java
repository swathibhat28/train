package string.array.matrix;

/*
 * Michael O. Rabin and Richard M. Karp came up with the idea of hashing the pattern and to check it against
 *  a hashed sub-string from the text in 1987. In general the idea seems quite simple, the only thing is 
 *  that we need a hash function that gives different hashes for different sub-strings. Said hash function, 
 *  for instance, may use the ASCII codes for every character, but we must be careful for multi-lingual 
 *  support.
The hash function may vary depending on many things, so it may consist of ASCII char to number converting
 but it can also be anything else. The only thing we need is to convert a string (pattern) into some hash
 that is faster to compare. Let’s say we have the string “hello world”, and let’s assume that its hash is
  hash('hello world') = 12345. So if hash('he') = 1 we can say that the pattern "he" is contained in the 
  text "hello world".  So in every step, we take from the text a sub-string with the length of m, where m 
  is the pattern length. Thus we hash this sub-string and we can directly compare it to the hashed pattern,
   as in the picture above.
 */

public class RobinKarpPatternMatchSubString {
//	function hash_string($str, $len)
//	{
//		$hash = '';
//	 
//		$hash_table = array(
//			'h' => 1,
//			'e' => 2,
//			'l' => 3,
//			'o' => 4,
//			'w' => 5,
//			'r' => 6,
//			'd' => 7,
//		);
//	 
//		for ($i = 0; $i < $len; $i++) {
//			$hash .= $hash_table[$str{$i}];
//		}
//	 
//		return (int)$hash;
//	}
//	 
//	function rabin_karp($text, $pattern)
//	{
//		$n = strlen($text);
//		$m = strlen($pattern);
//	 
//		$text_hash = hash_string(substr($text, 0, $m), $m);
//		$pattern_hash = hash_string($pattern, $m);
//	 
//		for ($i = 0; $i < $n-$m+1; $i++) {
//			if ($text_hash == $pattern_hash) {
//				return $i;
//			}
//	 
//			$text_hash = hash_string(substr($text, $i, $m), $m);
//		}
//	 
//		return -1;
//	}
//	 
//	// 2
//	echo rabin_karp('hello world', 'ello');
}
