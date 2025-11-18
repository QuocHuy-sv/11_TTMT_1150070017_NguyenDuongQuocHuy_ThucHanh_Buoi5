package com.example.nguyenduongquochuylab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvFood;
    private FoodAdapter adapter;
    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Đồ ăn nhanh Quốc Huy");
        }

        lvFood = findViewById(R.id.lvFood);
        foodList = new ArrayList<>();

        foodList.add(new Food(
                "Hamburger",
                "Bánh mì kẹp thịt",
                "Giá: 25.000đ",
                R.drawable.img_hamburger));

        foodList.add(new Food(
                "Bánh mì",
                "Bánh mì thịt nguội đặc biệt",
                "Giá: 12.000đ",
                R.drawable.img_banh_mi));

        foodList.add(new Food(
                "Bánh bao",
                "Bánh bao nhân bò, trứng",
                "Giá: 20.000đ",
                R.drawable.img_banh_bao));

        foodList.add(new Food(
                "Bánh bột lọc",
                "Bánh bột lọc nhân tôm, thịt",
                "Giá: 18.000đ",
                R.drawable.img_banh_bot_loc));

        foodList.add(new Food(
                "Bánh giò chay",
                "Bánh giò chay ăn ngon nhẹ",
                "Giá: 15.000đ",
                R.drawable.img_banh_gio_chay));

        foodList.add(new Food(
                "Bánh giò nhân thịt",
                "Bánh giò nhân thịt nóng hổi",
                "Giá: 18.000đ",
                R.drawable.img_banh_gio_thit));

        adapter = new FoodAdapter(this, foodList,
                new FoodAdapter.OnFoodActionListener() {
                    @Override
                    public void onEdit(int position) {
                        showFoodDialog(position);
                    }

                    @Override
                    public void onDelete(int position) {
                        deleteFood(position);
                    }
                });

        lvFood.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            showFoodDialog(-1);
            return true;
        } else if (id == R.id.action_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showFoodDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(position == -1 ? "Thêm món" : "Sửa món");

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_food, null);
        builder.setView(view);

        EditText edtName = view.findViewById(R.id.edtName);
        EditText edtDesc = view.findViewById(R.id.edtDesc);
        EditText edtPrice = view.findViewById(R.id.edtPrice);

        if (position != -1) {
            Food f = foodList.get(position);
            edtName.setText(f.getName());
            edtDesc.setText(f.getDescription());
            edtPrice.setText(f.getPrice().replace("Giá: ", ""));
        }

        builder.setPositiveButton("Lưu", null);
        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(dlg -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {
                        String name = edtName.getText().toString().trim();
                        String desc = edtDesc.getText().toString().trim();
                        String price = edtPrice.getText().toString().trim();

                        if (name.isEmpty() || desc.isEmpty() || price.isEmpty()) {
                            Toast.makeText(MainActivity.this,
                                    "Vui lòng nhập đầy đủ thông tin",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        String priceText = "Giá: " + price;

                        if (position == -1) {
                            foodList.add(new Food(name, desc, priceText,
                                    R.drawable.img_hamburger));
                        } else {
                            Food f = foodList.get(position);
                            f.setName(name);
                            f.setDescription(desc);
                            f.setPrice(priceText);
                        }
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    });
        });

        dialog.show();
    }

    private void deleteFood(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Xóa món ăn")
                .setMessage("Bạn có chắc muốn xóa \"" + foodList.get(position).getName() + "\" không?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    foodList.remove(position);
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}
