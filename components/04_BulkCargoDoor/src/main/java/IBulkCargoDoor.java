public interface IBulkCargoDoor {

        String version();

        boolean close();

        boolean lock();

        boolean unlock();

        boolean open();
    }

