package ru.academits.khudyakov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (this.from < range.from) {
            if (this.to <= range.from) {
                return null;
            }

            if (this.to <= range.to) {
                return new Range(range.from, this.to);
            }

            return range;
        }

        if (range.from < this.from) {
            if (range.to <= this.from) {
                return null;
            }

            if (range.to <= this.to) {
                return new Range(this.from, range.to);
            }

            return this;
        }

        if (this.to <= range.to) {
            return this;
        }

        return new Range(this.from, range.to);
    }

    public Range[] getUnion(Range range) {
        if (this.from < range.from) {
            if (this.to < range.from) {
                return new Range[]{this, range};
            }

            if (this.to < range.to) {
                return new Range[]{new Range(this.from, range.to)};
            }

            return new Range[]{this};
        }

        if (range.from < this.from) {
            if (range.to < this.from) {
                return new Range[]{this, range};
            }

            if (range.to < this.to) {
                return new Range[]{new Range(range.from, this.to)};
            }

            return new Range[]{range};
        }

        if (this.to < range.to) {
            return new Range[]{new Range(this.from, range.to)};
        }

        return new Range[]{this};
    }

    public Range[] getDefinition(Range range) {
        if (this.from < range.from) {
            if (this.to <= range.from) {
                return new Range[]{this};
            }

            if (this.to <= range.to) {
                return new Range[]{new Range(this.from, range.from)};
            }

            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }

        if (range.from < this.from) {
            if (range.to <= this.from) {
                return new Range[]{this};
            }

            if (range.to < this.to) {
                return new Range[]{new Range(range.to, this.to)};
            }

            return null;
        }

        if (range.to < this.to) {
            return new Range[]{new Range(range.to, this.to)};
        }

        return null;
    }
}
