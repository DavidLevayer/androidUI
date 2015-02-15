package cafe.com.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import cafe.com.cafejeunesse.News;

public class HomeFragment extends SampleFragment {

    private ViewGroup mContainerView;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = super.onCreateView(inflater,container, savedInstanceState);

        // Chargement spécifique au fragment
        mContainerView = (ViewGroup) mView.findViewById(R.id.news_container);

        Date d1 = new Date();

        d1.setDate(2);
        d1.setMonth(0);
        addNews(new News("Création de l'application", d1,
                "Une application Android pour découvrir les services"));

        d1.setDate(12);
        d1.setMonth(0);
        addNews(new News("Ouverture du Café", d1,
                "Consultez les nouveaux horaires d'ouverture"));

        d1.setDate(23);
        d1.setMonth(0);
        addNews(new News("Projet d'habitation du comité des jeunes", d1,
                "Venez découvrir les nouveaux outils mis à disposition"));

        addNews(new News("Sécurité alimentaire - nouveau site", new Date(),
                "Toutes les informations utiles sur ce nouveau lieu"));

        return mView;
    }

    private void addNews(News n){

        ViewGroup newView = (ViewGroup) LayoutInflater.from(mView.getContext()).inflate(
                R.layout.home_list_item, mContainerView, false);

        ((TextView) newView.findViewById(R.id.home_title)).setText(n.getTitle());
        ((TextView) newView.findViewById(R.id.home_description)).setText(n.getArticle());
        ((TextView) newView.findViewById(R.id.home_date_day)).setText(n.getPublishingDay());
        ((TextView) newView.findViewById(R.id.home_date_month)).setText(n.getPublishingMonth());

        mContainerView.addView(newView, 0);
    }
}
