package android.dienty.library_for_you.ReadingNews.SelectPage.models;

public class PageItem {
    private final String namePage;
    private final int thumnailPage;

    public PageItem(String namePage, int thumnailPage) {
        this.namePage = namePage;
        this.thumnailPage = thumnailPage;
    }

    public String getNamePage() {
        return namePage;
    }

    public int getThumnailPage() {
        return thumnailPage;
    }
}