package gdg.devfest.passwordmanager.viewmodel;

import android.databinding.ObservableField;
import gdg.devfest.passwordmanager.model.CustomField;
import java.util.ArrayList;
import java.util.List;

public class CustomFieldViewModel implements ViewModel {
  public final ObservableField<String> name;
  public final ObservableField<String> value;

  private final OnUpdateListener updateListener;

  CustomFieldViewModel(String name, String value, OnUpdateListener updateListener) {
    this.name = new ObservableField<>(name);
    this.value = new ObservableField<>(value);
    this.updateListener = updateListener;
  }

  public void update() {
    if (updateListener != null) updateListener.update(this);
  }

  public static CustomFieldViewModel of(CustomField customField, OnUpdateListener updateListener) {
    return new CustomFieldViewModel(customField.getName(), customField.getValue(), updateListener);
  }

  static List<CustomFieldViewModel> toViewModels(List<CustomField> entities,
      OnUpdateListener updateListener) {
    List<CustomFieldViewModel> viewModels = new ArrayList<>(entities.size());

    for (CustomField entity : entities) {
      viewModels.add(CustomFieldViewModel.of(entity, updateListener));
    }

    return viewModels;
  }

  static List<CustomField> toEntities(List<CustomFieldViewModel> viewModels) {
    List<CustomField> entities = new ArrayList<>(viewModels.size());

    for (CustomFieldViewModel viewModel : viewModels) {
      entities.add(new CustomField(viewModel.name.get(), viewModel.value.get()));
    }

    return entities;
  }

  public interface OnUpdateListener {
    void update(CustomFieldViewModel customFieldViewModel);
  }
}
