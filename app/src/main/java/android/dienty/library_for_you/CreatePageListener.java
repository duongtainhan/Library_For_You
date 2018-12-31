package android.dienty.library_for_you;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

public interface CreatePageListener {
    void OnPassingVnExpress(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
    void OnPassingDanTri(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
    void OnPassing24H(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
    void OnPassingKenh14(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
    void OnPassingVietNamNet(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
    void OnPassingNgoiSao(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
    void OnPassingGenk(ArrayList<Fragment> listPage, ArrayList<String> listTitle);
}
