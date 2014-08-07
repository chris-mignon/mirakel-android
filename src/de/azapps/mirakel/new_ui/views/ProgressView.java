package de.azapps.mirakel.new_ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import de.azapps.mirakel.new_ui.R;
import de.azapps.tools.OptionalUtils;

public class ProgressView extends LinearLayout {
    private int progress;

    private SeekBar progressBar;

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_progress, this);
        progressBar = (SeekBar) findViewById(R.id.progress_bar);
    }

    public void setOnProgressChangeListener(final OptionalUtils.Procedure<Integer>
                                            onProgressChangeListener) {
        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Do nothing
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                onProgressChangeListener.apply(seekBar.getProgress());
            }
        });
    }

    private void rebuildLayout() {
        progressBar.setProgress(progress);
        invalidate();
        requestLayout();
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        rebuildLayout();
    }
}
