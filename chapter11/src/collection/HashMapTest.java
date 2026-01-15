package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class HashMapTest {

	public static void main(String[] args) {
		//키(Key)와 값(value)을 입력
		// 제네릭으로 지정한 타입에 맞는 일반 배열을 이용해 한번에 넣어줄 수 있음

		HashMap<String, String> list = new HashMap<String, String>();

		String[] key = { "a", "b", "c", "d", "e" };
		String[] value = { "apple", "banana", "candy", "dog", "enum" };

		for (int i = 0; i < key.length; i++)
		list.put(key[i], value[i]);

		// {a=apple, b=banana, c=candy, d=dog, e=enum}
		System.out.println(list); 

		//[ keySet() / values() ]
		// 키 / 값을 별도로 추출하여 컬렉션 형태로 반환 (Set 생성)
		// [a, b, c, d, e]
		System.out.println(list.keySet());
		// [apple, banana, candy, dog, enum]
		System.out.println(list.values());

		//[ get() ]
		// 키 값을 제공하면 해당 값을 반환
		System.out.println(list.get("c")); // candy

		//[ replace() ]
		//	키 값과 바꿀 값을 제공하면 해당 키의 값을 변경함
		list.replace("c", "coin");
		System.out.println(list.get("c")); // coin
		
		//[ put() ]
//		키 값과 추가할 값을 제공하면 새로운 "key : value"가 추가됨
//		만약 중복되는 키 값을 제공하면 기존 키가 가지고 있던 값을 제공된 값으로 변경함
		list.put("c", "coin");   // 기존값으로 대체
		System.out.println(list.get("c"));  // coin

		list.put("f", "float");  // 새로 추가됨
		System.out.println(list.get("f"));  // float

		//[ containsKey() / containsValue() ]
		// key / value가 존재하는지 여부 확인 후 true / false 반환
		System.out.println(list.containsKey("a"));  // true
		System.out.println(list.containsValue("dog"));  //true

		// [ remove() / clear() ]
//		remove() : 제공한 키 값의 항목을 제거
//		clear() : 모두 삭제
		list.remove("d"); // "d" 키/값 삭제
		System.out.println(list.get("d")); // null

		list.clear();  // 모두 삭제
		System.out.println(list.size()); // 남은 갯수 0

		for (int i = 0; i < key.length; i++)
			list.put(key[i], value[i]);

		//확장 for문을 이용한 출력
		for (String keys : list.keySet())
			System.out.println(keys + " : " + list.get(keys));
		System.out.println("---------------");

		// Iterator() 메서드는 하나의 Collection 객체만을 반환하므로 
		// pair로 이루어진 객체는 각각 순회 해야 함
		// Iterator을 이용한 출력
		Set<String> keySet = list.keySet();
		Iterator<String> ir =  keySet.iterator();
		while (ir.hasNext()) { // 다음 key가 있으면
		    String k = ir.next();          // key는 String
		    String v = list.get(k);        // value 꺼내기
		    System.out.println(k + " : " + v);
		}
	}

}
