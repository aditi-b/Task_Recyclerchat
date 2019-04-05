package com.r.task_recyclerchat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MultiViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private ArrayList<Student> dataSet;

        public class LeftViewHolder extends RecyclerView.ViewHolder {

            TextView txtType1;

            private LeftViewHolder(View itemView) {
                super(itemView);
                this.txtType1 =  itemView.findViewById(R.id.text1);
            }
        }

        public class RightViewHolder extends RecyclerView.ViewHolder {

            TextView txtType2;

            private RightViewHolder(View itemView) {
                super(itemView);
                this.txtType2 =  itemView.findViewById(R.id.text2);
            }
        }


         MultiViewTypeAdapter(ArrayList<Student>data) {
            this.dataSet = data;
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view;
            switch (viewType) {
                case Student.chat_left:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_left, parent, false);
                    return new LeftViewHolder(view);
                case Student.chat_right:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_right, parent, false);
                    return new RightViewHolder(view);

            }
            return null;
        }

        @Override
        public int getItemViewType(int position) {

            switch (dataSet.get(position).type) {
                case Student.chat_left:
                    return Student.chat_left;
                case Student.chat_right:
                    return Student.chat_right;
                default:
                    return -1;
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int listPosition) {

            Student object = dataSet.get(listPosition);
            if (object != null) {
                switch (object.type) {
                    case Student.chat_left:
                        ((LeftViewHolder) holder).txtType1.setText(object.text);
                        break;
                    case Student.chat_right:

                        ((RightViewHolder) holder).txtType2.setText(object.text);
                        break;

                }
            }
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }
    }

