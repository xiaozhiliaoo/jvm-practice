 Thread removeThread = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }
        }
    });

    Thread printThread = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (vector) {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println((vector.get(i)));
                }
            }
        }
    });

