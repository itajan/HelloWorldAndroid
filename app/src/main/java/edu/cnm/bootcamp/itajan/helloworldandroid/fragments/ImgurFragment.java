package edu.cnm.bootcamp.itajan.helloworldandroid.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import edu.cnm.bootcamp.itajan.helloworldandroid.R;
import edu.cnm.bootcamp.itajan.helloworldandroid.adapters.ImageListAdapter;
import edu.cnm.bootcamp.itajan.helloworldandroid.api.API;
import edu.cnm.bootcamp.itajan.helloworldandroid.api.models.GalleryResponse;
import edu.cnm.bootcamp.itajan.helloworldandroid.api.models.Image;
import java.util.List;
import rx.Scheduler;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link ImgurFragment.OnFragmentInteractionListener} interface to handle interaction events. Use
 * the {@link ImgurFragment#newInstance} factory method to create an instance of this fragment.
 */
public class ImgurFragment extends Fragment {

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;
  private ListView listImages;

  private OnFragmentInteractionListener mListener;

  public ImgurFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment ImgurFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static ImgurFragment newInstance(String param1, String param2) {
    ImgurFragment fragment = new ImgurFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_imgur, container, false);

    listImages = (ListView)view.findViewById(R.id.listImages);
    return view;
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    Single<GalleryResponse> response = API.subredditGallery("pics");
    response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<GalleryResponse>() {
              @Override
              public void call(GalleryResponse galleryResponse) {
                  if (galleryResponse != null && listImages != null && galleryResponse.isSuccess()) {
                    List<Image> images = galleryResponse.getData();
                    ImageListAdapter adapter = new ImageListAdapter(getContext(), images);
                    if (listImages != null) {
                      listImages.setAdapter(adapter);
                    }
                  }
              }
            }, new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                    throwable.printStackTrace();
              }
            });
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this fragment to allow an
   * interaction in this fragment to be communicated to the activity and potentially other fragments
   * contained in that activity. <p> See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html" >Communicating with
   * Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {

    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
