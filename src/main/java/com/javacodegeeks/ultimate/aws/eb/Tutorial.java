package com.javacodegeeks.ultimate.aws.eb;

public class Tutorial {

    private String author;
    private String title;

    public Tutorial() {}

    public Tutorial(final String author, final String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Tutorial tutorial = (Tutorial) o;

        if (author != null ? !author.equals(tutorial.author) : tutorial.author != null) return false;
        if (title != null ? !title.equals(tutorial.title) : tutorial.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
