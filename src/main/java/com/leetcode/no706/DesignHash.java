package com.leetcode.no706;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/8
 * @description: https://leetcode-cn.com/problems/design-hashmap
 */
public class DesignHash {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}
class MyHashMap {
    ArrayList<Integer> key;
    ArrayList<Integer> value;
    public MyHashMap() {
        this.key = new ArrayList<>();
        this.value = new ArrayList<>();
    }

    public void put(int key, int value) {
        if(this.key.contains(key)){
            remove(key);
        }
        this.key.add(key);
        this.value.add(value);
    }

    public int get(int key) {
        int index = this.key.indexOf(key);
        if(index!=-1){
            return this.value.get(index);
        }else return -1;
    }

    public void remove(int key) {
        int index = this.key.indexOf(key);
        if(index!=-1){
            this.key.remove(index);
            this.value.remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */