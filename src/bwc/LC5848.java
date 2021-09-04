package bwc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC5848 {
    class LockingTree {
        Set<Integer> lockedNodes;
        Map<Integer, Integer> userLock;
        int[] tree;

        public LockingTree(int[] parent) {
            tree = parent;
            lockedNodes = new HashSet<>();
            userLock = new HashMap<>();

        }

        public boolean lock(int num, int user) {
            num++;
            if (userLock.containsKey(num)) return false;
            userLock.put(num, user);
            return true;
        }

        public boolean unlock(int num, int user) {
            num++;
            if (userLock.getOrDefault(num, -1) == user) {
                userLock.remove(num);
                return true;
            } else return false;

        }

        public boolean upgrade(int num, int user) {
            num++;
            int ancestor = num;
            //if ancestor or self locked
            while (ancestor > 0) {
                if (userLock.containsKey(ancestor)) return false;
                if (ancestor % 2 == 1) ancestor--;
                ancestor /= 2;
            }
            boolean result = isDescendantLocked(2 * num) || isDescendantLocked(2 * num + 1);
            if (result) lock(num - 1, user);
            return result;

        }

        boolean isDescendantLocked(Integer descendant) {
            boolean isLocked = false;
            boolean result = false;
            if (descendant <= tree.length) {
                if (userLock.containsKey(descendant)) {
                    userLock.remove(descendant);
                    isLocked = true;
                }
                result = isDescendantLocked(2 * descendant) || isDescendantLocked(2 * descendant + 1);
            }
            return isLocked || result;

        }


    }
}
