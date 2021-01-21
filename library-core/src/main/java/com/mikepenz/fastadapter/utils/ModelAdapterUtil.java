package com.mikepenz.fastadapter.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ModelAdapter;

import java.util.List;

import static java.util.Arrays.asList;

public abstract class ModelAdapterUtil {

    public static <Item extends IItem> List<Item> getAdapterOriginalItems(@NonNull ModelAdapter<Item, Item> adapter) {
        if (adapter.getItemFilter() != null) {
            if (adapter.getItemFilter().getOriginalItems() == null) {
                return adapter.getAdapterItems();
            } else {
                return adapter.getItemFilter().getOriginalItems();
            }
        } else {
            return adapter.getAdapterItems();
        }
    }

    public static <Item extends IItem> void add(@Nullable ModelAdapter<Item, Item> adapter, Item... items) {
        if (adapter == null || items.length == 0) {
            return;
        }

        add(adapter, asList(items));
    }

    public static <Item extends IItem> void add(@Nullable ModelAdapter<Item, Item> adapter, @Nullable List<Item> items) {
        if (adapter == null || items == null || items.size() == 0) {
            return;
        }

        ///[FastAdapter#Filter]用mItemAdapter.getItemFilter()的add/remove方法替代mItemAdapter的方法
        if (adapter.getItemFilter() == null) {
            adapter.add(items);
        } else {
            ///注意：FastAdapter必须升级为v0.10.7#[FIX#ItemFilter#Sort]以上！否则mOriginalItems无法排序
            adapter.getItemFilter().add(items);
        }
    }

    public static <Item extends IItem> void add(@Nullable ModelAdapter<Item, Item> adapter, int position, Item... items) {
        if (adapter == null || position == RecyclerView.NO_POSITION || items.length == 0) {
            return;
        }

        add(adapter, position, asList(items));
    }

    public static <Item extends IItem> void add(@Nullable ModelAdapter<Item, Item> adapter, int position, @Nullable List<Item> items) {
        if (adapter == null || position == RecyclerView.NO_POSITION || items == null || items.size() == 0) {
            return;
        }

        ///[FastAdapter#Filter]用mItemAdapter.getItemFilter()的add/remove方法替代mItemAdapter的方法
        if (adapter.getItemFilter() == null) {
            adapter.add(position, items);
        } else {
            ///注意：FastAdapter必须升级为v0.10.7#[FIX#ItemFilter#Sort]以上！否则mOriginalItems无法排序
            adapter.getItemFilter().add(position, items);
        }
    }

    public static <Item extends IItem> void addInOriginalItems(@Nullable ModelAdapter<Item, Item> adapter, int position, Item... items) {
        if (adapter == null || items.length == 0) {
            return;
        }

        addInOriginalItems(adapter, position, asList(items));
    }

    public static <Item extends IItem> void addInOriginalItems(@Nullable ModelAdapter<Item, Item> adapter, int position, @Nullable List<Item> items) {
        if (adapter == null || items == null || items.size() == 0) {
            return;
        }

        ///[FastAdapter#Filter]用mItemAdapter.getItemFilter()的add/remove方法替代mItemAdapter的方法
        if (adapter.getItemFilter() == null) {
            adapter.addInOriginalItems(position, items);
        } else {
            ///注意：FastAdapter必须升级为v0.10.7#[FIX#ItemFilter#Sort]以上！否则mOriginalItems无法排序
            adapter.getItemFilter().addInOriginalItems(position, items);
        }
    }

    public static <Item extends IItem> void set(@Nullable ModelAdapter<Item, Item> adapter, int position, @Nullable Item item) {
        if (adapter == null || position == RecyclerView.NO_POSITION) {
            return;
        }

        if (item == null) {
            remove(adapter, position);
            return;
        }

        ///[FastAdapter#Filter]用mItemAdapter.getItemFilter()的add/remove方法替代mItemAdapter的方法
        if (adapter.getItemFilter() == null) {
            adapter.set(position, item);
        } else {
            ///注意：FastAdapter必须升级为v0.10.7#[FIX#ItemFilter#Sort]以上！否则mOriginalItems无法排序
            adapter.getItemFilter().set(position, item);
        }
    }

    public static <Item extends IItem> void setInOriginalItems(@Nullable ModelAdapter<Item, Item> adapter, int position, @Nullable Item item) {
        if (adapter == null) {
            return;
        }

        if (item == null) {
            remove(adapter, position);
            return;
        }

        ///[FastAdapter#Filter]用mItemAdapter.getItemFilter()的add/remove方法替代mItemAdapter的方法
        if (adapter.getItemFilter() == null) {
            adapter.setInOriginalItems(position, item);
        } else {
            ///注意：FastAdapter必须升级为v0.10.7#[FIX#ItemFilter#Sort]以上！否则mOriginalItems无法排序
            adapter.getItemFilter().setInOriginalItems(position, item);
        }
    }

    public static <Item extends IItem> void move(@Nullable ModelAdapter<Item, Item> adapter, int fromPosition, int toPosition) {
        if (adapter == null
                || fromPosition == RecyclerView.NO_POSITION
                || toPosition == RecyclerView.NO_POSITION
                || fromPosition == toPosition) {
            return;
        }

        ///[FastAdapter#Filter]用mItemAdapter.getItemFilter()的add/remove方法替代mItemAdapter的方法
        if (adapter.getItemFilter() == null) {
            adapter.move(fromPosition, toPosition);
        } else {
            ///注意：FastAdapter必须升级为v0.10.7#[FIX#ItemFilter#Sort]以上！否则mOriginalItems无法排序
            adapter.getItemFilter().move(fromPosition, toPosition);
        }
    }

    public static <Item extends IItem> void clear(@Nullable ModelAdapter<Item, Item> adapter) {
        if (adapter == null) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.clear();
        } else {
            adapter.getItemFilter().clear();
        }
    }

    public static <Item extends IItem> void remove(@Nullable ModelAdapter<Item, Item> adapter, int position) {
        if (adapter == null || position == RecyclerView.NO_POSITION) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.remove(position);
        } else {
            adapter.getItemFilter().remove(position);
        }
    }

    public static <Item extends IItem> void removeInOriginalItems(@Nullable ModelAdapter<Item, Item> adapter, int position) {
        if (adapter == null) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.removeInOriginalItems(position);
        } else {
            adapter.getItemFilter().removeInOriginalItems(position);
        }
    }

    public static <Item extends IItem> void remove(@Nullable ModelAdapter<Item, Item> adapter, Item item) {
        if (adapter == null) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.remove(item);
        } else {
            adapter.getItemFilter().remove(item);
        }
    }

    public static <Item extends IItem> void removeByIdentifier(@Nullable ModelAdapter<Item, Item> adapter, final long identifier) {
        if (adapter == null || identifier == -1L) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.removeByIdentifier(identifier);
        } else {
            adapter.getItemFilter().removeByIdentifier(identifier);
        }
    }

    public static <Item extends IItem> void removeRange(@Nullable ModelAdapter<Item, Item> adapter, int position, int itemCount) {
        if (adapter == null || position == RecyclerView.NO_POSITION || itemCount <= 0) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.removeRange(position, itemCount);
        } else {
            adapter.getItemFilter().removeRange(position, itemCount);
        }
    }

    public static <Item extends IItem> void removeRangeInOriginalItems(@Nullable ModelAdapter<Item, Item> adapter, int position, int itemCount) {
        if (adapter == null || itemCount <= 0) {
            return;
        }

        if (adapter.getItemFilter() == null) {
            adapter.removeRangeInOriginalItems(position, itemCount);
        } else {
            adapter.getItemFilter().removeRangeInOriginalItems(position, itemCount);
        }
    }

}
