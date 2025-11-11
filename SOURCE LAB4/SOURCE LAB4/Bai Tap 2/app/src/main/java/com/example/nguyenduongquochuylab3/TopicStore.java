package com.example.nguyenduongquochuylab3;

public final class TopicStore {
    public static final String[] TITLES = new String[]{
            "Essentials",
            "While Traveling",
            "Help / Medical",
            "At the Hotel",
            "At the Restaurant",
            "At the Bar",
            "At the Store",
            "At Work",
            "Time, Date, Numbers",
            "Education",
            "Entertainment"
    };

    public static final int[] ICONS = new int[]{
            R.drawable.ic_essentials,
            R.drawable.ic_travel,
            R.drawable.ic_medical,
            R.drawable.ic_hotel,
            R.drawable.ic_restaurant,
            R.drawable.ic_bar,
            R.drawable.ic_store,
            R.drawable.ic_work,
            R.drawable.ic_time,
            R.drawable.ic_education,
            R.drawable.ic_entertainment
    };

    private static final String[][] WORDS = new String[][]{
            {"hello", "please", "thank you", "sorry", "excuse me", "goodbye"},
            {"ticket", "platform", "luggage", "passport", "boarding pass"},
            {"doctor", "nurse", "medicine", "hospital", "first aid"},
            {"reception", "reservation", "key card", "lobby", "check-out"},
            {"menu", "waiter", "bill", "table", "spicy", "delicious"},
            {"beer", "wine", "cheers", "ice", "glass"},
            {"cashier", "discount", "receipt", "queue", "fitting room"},
            {"meeting", "deadline", "report", "salary", "colleague"},
            {"o'clock", "minute", "calendar", "yesterday", "hundred"},
            {"student", "teacher", "exam", "classroom", "homework"},
            {"movie", "music", "concert", "game", "theater"}
    };

    public static String[] getWords(int index) {
        if (index < 0 || index >= WORDS.length) return new String[0];
        return WORDS[index];
    }
}
