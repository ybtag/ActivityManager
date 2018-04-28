package com.sdex.activityrunner;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdex.activityrunner.service.AppLoaderIntentService;
import com.sdex.activityrunner.util.RecyclerViewHelper;

public class AppsListFragment extends Fragment {

  public static final String TAG = "AppsListFragment";

  private ApplicationsListAdapter adapter;
  private SwipeRefreshLayout refreshLayout;
  private ContentLoadingProgressBar progressBar;
  private ApplicationListViewModel viewModel;
  private String searchText;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_apps_list, container, false);
    progressBar = view.findViewById(R.id.progress);
    progressBar.show();
    refreshLayout = view.findViewById(R.id.refresh);
    RecyclerView list = view.findViewById(R.id.list);
    RecyclerViewHelper.addDivider(list);
    adapter = new ApplicationsListAdapter(getActivity());
    list.setAdapter(adapter);
    refreshLayout.setOnRefreshListener(() -> {
      refreshLayout.setRefreshing(true);
      final Intent work = new Intent();
      work.putExtra(AppLoaderIntentService.ARG_REASON, AppLoaderIntentService.REFRESH_USER);
      AppLoaderIntentService.enqueueWork(getActivity(), work);
    });
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = ViewModelProviders.of(this).get(ApplicationListViewModel.class);
  }

  @Override
  public void onResume() {
    super.onResume();
    viewModel.getItems(searchText).observe(this, itemModels -> {
      if (itemModels != null) {
        adapter.submitList(itemModels);
        refreshLayout.setRefreshing(false);
        progressBar.hide();
      }
    });
  }

  public void filter(String text) {
    if (adapter != null) {
      this.searchText = text;
      viewModel.getItems(text).observe(this,
        itemModels -> {
          adapter.submitList(itemModels);
        });
    }
  }
}
