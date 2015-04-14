package imageProc;

import java.util.Scanner; // for debugging, get program to pause

public class RGBImage {

	// folder to look for image files
	private String defaultDirectory = "images";

	// The pixels are stored in three 2D arrays.
	// These are the data structures we will use to perform
	// the actual image manipulation.
	private int red[][];
	private int green[][];
	private int blue[][];

	// Helper will do the 'ugly' Java stuff (saving images to files, etc)
	private RGBImageViewer myViewer;

	// Constructor, use an open file dialog to specify image
	public RGBImage() {
		myViewer = new RGBImageViewer(this, defaultDirectory);
	}

	// Constructor, String argument specifies filename of image
	public RGBImage(String filename) {
		myViewer = new RGBImageViewer(this, defaultDirectory, filename);
	}

	// this is called from Helper, when a new image is loaded from a file.
	// You never need to call it.
	protected void updateArrays(int[][] red, int[][] green, int[][] blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	// Call this method to load a new image
	public void load() {
		myViewer.load(defaultDirectory);
	}

	// Call this method to save the image to the same file
	public void save() {
		myViewer.save();
	}

	// Call this method to save the image to a different file name
	public void saveAs(String filename) {
		myViewer.saveAs(filename);
	}

	// call this in case you closed the viewer, but want to see it again.
	// won't work with the default close action on the viewer, currently.
	public void show() {
		myViewer.show();
	}

	// This method should always be called after manipulating
	// the pixels via the 2D arrays.
	private void refresh() {
		myViewer.refresh(red, green, blue);
	}

	// /////////
	// ///////// Image manipulation methods
	// /////////
	// Your code goes here.
	// Don't forget to call refresh() after manipulating the red, green, and
	// blue pixel arrays

	// Example: flips the image vertically.
	public void flipVertical() {
		int width = red.length;
		int height = red[0].length;

		int[][] temp = new int[width][height];

		// Flip the red channel.
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				temp[w][h] = red[w][height - h - 1];
			}
		}
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				red[w][h] = temp[w][h];
			}
		}

		// Flip the green channel.
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				temp[w][h] = green[w][height - h - 1];
			}
		}
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				green[w][h] = temp[w][h];
			}
		}

		// Flip the blue channel.
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				temp[w][h] = blue[w][height - h - 1];
			}
		}
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				blue[w][h] = temp[w][h];
			}
		}

		// Always do this after manipulating pixels.
		refresh();
	}

	public void makeGreyscale() {
		int width = red.length;
		int height = red[0].length;

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int avg = (red[w][h] + green[w][h] + blue[w][h]) / 3;
				red[w][h] = avg;
				green[w][h] = avg;
				blue[w][h] = avg;
			}
		}
		refresh();

	}

	// mirror image from a file by modifying one half of the picture so that it
	// shows a 'reflection' of the other half. It will look as if half
	// the picture is being held up to a mirror. (you'll be throwing out
	// half the information in the picture, and won't see any effect if the
	// image
	// is already mirrored.
	public void mirrorHorizontal() {
		int width = red.length;
		int height = red[0].length;

		// Protection from division by zero
		if (width == 0) {
			return;
		}

		// Strategy: Copy from middle to first into middle to last
		for (int h = 0; h < height; h++) {
			for (int w = width / 2; w < width; w++) {
				int m = width - w;
				red[w][h] = red[m][h];
				green[w][h] = green[m][h];
				blue[w][h] = blue[m][h];
			}
		}
		refresh();
	}

	/*
	 * Images can often have low contrast because the values of their pixels
	 * only span part of the 0-255 range of possible values. This can make
	 * images "too dark" (if the values are all too low) or "washed out" (if the
	 * values are all too high). A simple way to increase the contrast in an
	 * image therefore is to scale the values so they fill this range.
	 */
	public void contrastStretch() {
		refresh();
	}

	public void threshHolding(int threshhold) {
		int width = red.length;
		int height = red[0].length;

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				int avg = (red[w][h] + green[w][h] + blue[w][h]) / 3;
				int newval;

				if (avg < threshhold) {
					newval = 0;
				} else {
					newval = 255;
				}
				red[w][h] = newval;
				green[w][h] = newval;
				blue[w][h] = newval;
			}
		}
		refresh();
	}

	// this adds a 5 pixel black border around the image, losing the
	// information in those pixels. If the picture has a width or height
	// less than 5 pixels, this method must not crash!
	public void addBorder() {
		refresh();
	}

	public void smoothingFilter() {
		// base filter
		double smooth = ((double) 1.0) / 9;
		double[][] myFilter = { 
				{ smooth, smooth, smooth },
				{ smooth, smooth, smooth }, 
				{ smooth, smooth, smooth } };
		// apply filter to image
		spatialFilter(myFilter);
	}

	public void sharpeningFilter() {
		// base filter
		double[][] myFilter = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
		// apply filter to image
		spatialFilter(myFilter);
		// redraw image
		refresh();
	}

	// this takes a Filter ( a 2D array of doubles, the sum of each element = 1
	// )
	// Apply the filter to each pixel
	// Iterate over the whole image
	//
	//
	public void spatialFilter(double[][] Filter) {
		System.out.println("apply filter");
		// Iterate over whole image:
		int width = red.length;
		int height = red[0].length;
		int fSize = Filter.length;
		int fMiddle = fSize / 2;
		/*
		 * Iterate over every pixle in the image
		 */
		for (int h = 0; h < height; h++) {
			/*
			 * When at the edges of an image, there won't be pixels to
			 * correspond to each cell in the filter. Two options: don't
			 * apply the filter to a pixel unless all cells correspond
			 * to a neighbor pixel, or apply the filter to only the
			 * relevant cells.
			 */
			if (  (h - fMiddle) < 0
					|| (h + fMiddle) >= height 
				){ continue; }
			
			for (int w = 0; w < width; w++) {
				if ( h == 1 && w == 571){
					System.out.println("Going out of bouns)");
				}

				/*
				 * When at the edges of an image, there won't be pixels to
				 * correspond to each cell in the filter. Two options: don't
				 * apply the filter to a pixel unless all cells correspond
				 * to a neighbor pixel, or apply the filter to only the
				 * relevant cells.
				 */
				if (  (w - fMiddle) < 0
						|| (w + fMiddle) >=  width
				){ 
					
					continue; 
				}
				/*
				 *  Print debug stuff (Supper slow!)
				 */
				//Debug( fMiddle,  w, h );
               /*
                * Apply filter to given pixel
                */
			    applyFilterToPixle( Filter, w, h  );
			    				
			} // End width
			
		} // End height
		
		// redraw image after each line of processing
		refresh();
	}
	public void applyFilterToPixle( double[][] filter, int w, int h ){
		// This holds the result of the filter
		double sumRed=0;
		double sumGreen=0;
		double sumBlue=0;
		int fMiddle = (filter.length/2);
		/*
		 * Iterate over the filter
		 */
		for (int fh = -fMiddle; fh <= fMiddle; fh++) {
			for (int fw = -fMiddle; fw <= fMiddle; fw++) {
				sumRed += (red[w + fw][h + fh] * filter[fMiddle + fw][fMiddle + fh]);
				sumGreen += (green[w + fw][h + fh] * filter[fMiddle + fw][fMiddle + fh]);
				sumBlue += (blue[w + fw][h + fh] * filter[fMiddle + fw][fMiddle + fh]);
			}
		}
		/*
		 * Set color of pixle
		 */
		red[w][h]=constrainValue(sumRed);
		green[w][h]=constrainValue(sumGreen);
		blue[w][h]=constrainValue(sumBlue);
	}
	
	public void Debug(int fMiddle, int w, int h ){
		/*
		 * Print the pixle we are acting on
		 */
		System.out.println("Pixel[" + w + "][" + h + "]");
		/*
		 * Print the filter next to the point
		 */
		for (int fh = -fMiddle; fh <= fMiddle; fh++) {
			// ----------------------------------------------------------------
			// DEBUG: PRINT THE FILTER
			for (int fw = -fMiddle; fw <= fMiddle; fw++) {
				System.out.print("f[" + fw + "][" + fh + "] ");
			} // end DEBUG: PRINT THE FILTER
			System.out.print("\t");
			// ----------------------------------------------------------------
			// DEBUG: PRINT PIXLES AROUND POINT
			for (int fw = -fMiddle; fw <= fMiddle; fw++) {
				// lets see the matrix
				System.out.print("p[" + (w + fw) + "][" + (h + fh) + "] ");
			} // end DEBUG: PRINT PIXLES AROUND POINT
			System.out.print("\n");
		}
	}
	// Constrain the value of x between 0 and 255
	public int constrainValue( double x){
		return (int)( 
				(x < 0 )
				? 0
				: ( x > 255)
				    ? 255
				    : x
		);
	}
}
