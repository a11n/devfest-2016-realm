package gdg.devfest.passwordmanager.framework;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import gdg.devfest.passwordmanager.BR;
import java.util.List;

class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.BindingViewHolder> {
  private final List<?> data;
  private final int layoutId;

  public DataBindingAdapter(@Nullable List<?> data, @LayoutRes int layoutId) {
    this.data = data;
    this.layoutId = layoutId;
  }

  @Override public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);

    return new BindingViewHolder(binding);
  }

  @Override public void onBindViewHolder(final BindingViewHolder holder, int position) {
    Object data = this.data.get(position);

    holder.binding.setVariable(BR.viewModel, data);
  }

  @Override public int getItemCount() {
    return data != null ? data.size() : 0;
  }

  static class BindingViewHolder extends RecyclerView.ViewHolder {
    final ViewDataBinding binding;

    public BindingViewHolder(ViewDataBinding binding) {
      super(binding.getRoot());

      this.binding = binding;
    }
  }
}
