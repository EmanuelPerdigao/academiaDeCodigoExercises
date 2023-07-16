package org.academiadecodigo.histogram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordHistogram extends HashMap<String , Integer> implements Iterable<String> {

    String string;
    String[] words;
    int counterWordRepeats;


    public WordHistogram(String string)
    {
        this.string = string;
        words = string.split(" ");
        counterWordRepeats = 0;
        add();
    }


    public void add()
    {
        for (String word : this.words)
        {
            if(containsKey(word))
            {
                counterWordRepeats = get(word);
                put(word, counterWordRepeats + 1);
            }
            else
            {
                put(word, 1);
            }
        }
    }

    @Override
    public Iterator iterator() {
        return keySet().iterator();
    }
}
