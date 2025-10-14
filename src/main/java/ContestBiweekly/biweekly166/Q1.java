package ContestBiweekly.biweekly166;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Q1
 * @Description: 众数频率字符
 * Author: genny
 * Date: 2025/10/14 10:37
 **/
public class Q1 {

    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> characterToFrequency = new HashMap<Character, Integer>();
        Map<Integer, Set<Character>> frequencyToGroup = new HashMap<Integer, Set<Character>>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            characterToFrequency.put(c, characterToFrequency.getOrDefault(c, 0) + 1);
        }

        Set<Character> characters = characterToFrequency.keySet();
        for (char c : characters) {
            int frequency = characterToFrequency.get(c);
            frequencyToGroup.putIfAbsent(frequency, new HashSet<Character>());
            frequencyToGroup.get(frequency).add(c);
        }

        int majorityFrequency = 0, majoritySize = 0;
        Set<Integer> frequencies = frequencyToGroup.keySet();
        for (int frequency : frequencies) {
            Set<Character> group = frequencyToGroup.get(frequency);
            if (group.size() > majoritySize || (group.size() == majoritySize && frequency > majorityFrequency)) {
                majorityFrequency = frequency;
                majoritySize = group.size();
            }
        }

        StringBuffer sb = new StringBuffer();
        Set<Character> majorityGroup = frequencyToGroup.get(majorityFrequency);
        for (char c : majorityGroup) {
            sb.append(c);
        }
        return sb.toString();
    }
}
