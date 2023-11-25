package basic.lab3.task1;

/**
 * The {@code Hour} class performs hour with {@code ridership} and {@code comment}.
 */
public class Hour implements Comparable<Hour> {
    /** Ridership is the number of passengers visiting a tram station per hour. */
    private final int ridership;

    /** Comment on the {@code ridership} metric. */
    private final String comment;

    /**
     * The constructor initialises the hour object with the specified values.
     * @param ridership the ridership;
     * @param comment the comment.
     */
    public Hour(int ridership, String comment) throws IllegalArgumentException {
        if (ridership < 0) {
            throw new IllegalArgumentException("Count of ridership must be equal or greater than 0.");
        }

        if (comment == null) {
            throw new IllegalArgumentException("Comment cannot be null.");
        }

        this.ridership = ridership;
        this.comment = comment;
    }

    public int getRidership() {
        return this.ridership;
    }

    public String getComment() {
        return this.comment;
    }

    public int getCommentLength() {
        return this.getComment().length();
    }

    @Override
    public String toString() {
        return "Hour\t{ "
                + "ridership = " + this.getRidership()
                + ",\tcomment = '" + this.getComment() + "' }";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Hour hour)) {
            return false;
        }

        return hour.getRidership() == this.getRidership()
                && hour.getComment().equals(this.getComment());
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getRidership()) * getComment().hashCode();
    }

    @Override
    public int compareTo(Hour h) {
        return Integer.compare(this.getRidership(), h.getRidership());
    }
}
