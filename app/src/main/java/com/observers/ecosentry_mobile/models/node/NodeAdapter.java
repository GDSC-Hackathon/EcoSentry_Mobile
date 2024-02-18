package com.observers.ecosentry_mobile.models.node;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.observers.ecosentry_mobile.R;

import java.util.List;

public class NodeAdapter extends RecyclerView.Adapter<NodeAdapter.NodeViewHolder> {

    // =====================================
    // == Fields
    // =====================================
    private Context mContext;
    private List<Node> mListNode;

    public NodeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Node> list) {
        this.mListNode = list;
        notifyDataSetChanged(); // Notify if the DataSet data has changed
    }

    // =====================================
    // == Methods From RecyclerView.Adapter
    // =====================================

    /**
     * Convert cardview_item_node.xml into View class
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public NodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_node, parent, false);
        return new NodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NodeViewHolder holder, int position) {
        Node node = mListNode.get(position);
        if (node == null) {
            return;
        }

        holder.mTextViewName.setText(node.getName());
        holder.mTextViewHumidity.setText(String.format("%.1f", node.getHumidity()) + " %");
        holder.mTextViewSoilMoisture.setText(String.format("%.1f", node.getSoil_moisture()) + " %");
        holder.mTextViewTemperature.setText(String.format("%.1f", node.getTemperature()));
        holder.mTextViewCO.setText(String.format("%.1f", node.getCo()) + " PPM");
        holder.mTextViewRainFall.setText(String.format("%.1f", node.getRain()) + " in/h");
        holder.mTextViewDustParticle.setText(String.format("%.1f", node.getDust()) + "\u00B5g/m3");

        /**
         * TODO: Currently Setting Default Mode, Will implement algo later
         */
        holder.mTextViewDangerLevel.setText(mContext.getResources().getString(R.string.dashboard_node_label_on_safe));
    }

    @Override
    public int getItemCount() {
        if (mListNode != null) {
            return mListNode.size();
        }
        return 0;
    }


    // =====================================
    // == Node View Holder
    // =====================================

    /**
     * A class for converting cardview_item_node.xml to java class file
     */
    public class NodeViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView mTextViewName;
        private final AppCompatTextView mTextViewTemperature;
        private final AppCompatTextView mTextViewHumidity;
        private final AppCompatTextView mTextViewSoilMoisture;
        private final AppCompatTextView mTextViewCO;
        private final AppCompatTextView mTextViewRainFall;
        private final AppCompatTextView mTextViewDustParticle;
        private final AppCompatTextView mTextViewDangerLevel;

        public NodeViewHolder(@NonNull View itemView) {
            super(itemView);

            // Mapping .xml to java class
            mTextViewName = itemView.findViewById(R.id.textViewNodeName);
            mTextViewTemperature = itemView.findViewById(R.id.textViewNodeTemperature);
            mTextViewHumidity = itemView.findViewById(R.id.textViewNodeHumidity);
            mTextViewSoilMoisture = itemView.findViewById(R.id.textViewNodeSoilMoisture);
            mTextViewCO = itemView.findViewById(R.id.textViewNodeCO);
            mTextViewRainFall = itemView.findViewById(R.id.textViewNodeRainFall);
            mTextViewDustParticle = itemView.findViewById(R.id.textViewNodeDustParticle);
            mTextViewDangerLevel = itemView.findViewById(R.id.textViewNodeDangerLevel);
        }
    }
}
