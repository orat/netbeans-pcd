package de.orat.math.netbeans.pcd;

/**
 * @author Oliver Rettig (Oliver.Rettig@orat.de)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

class PcdDataReader {
    
    private final FileObject fo;
    
    public PcdDataReader(FileObject fo) {
        this.fo = fo;
    }

    /**
     * Load points from pcd file.
     * 
     * @return null if loading is failed
     */
    public List<Point3d> loadPoints() {
        List<Point3d> points = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(FileUtil.toFile(fo)))) {
                int numOfPoints = 0;

                // read number of points and skip other unused header entries
                for (int i = 0; i < 12; i++) {
                    String[] temp = reader.readLine().split(" ");
                    if (temp[0].equals("POINTS")) {
                        numOfPoints = Integer.parseInt(temp[1]);
                    } else if (temp[0].equals("DATA")) {
                        break;
                    }
                }

                for (int i = 0; i < numOfPoints; i++) {
                    String[] coordinates = reader.readLine().split(" ");
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    double z = Double.parseDouble(coordinates[2]);

                    switch (coordinates.length) {
                        case 6:
                            double normal_x = Double.parseDouble(coordinates[3]);
                            double normal_y = Double.parseDouble(coordinates[4]);
                            double normal_z = Double.parseDouble(coordinates[5]);
                            points.add(new Point3d(x, y, z, normal_x, normal_y, normal_z));
                            break;
                        case 4:
                            int color = (int) Double.parseDouble(coordinates[3]);
                            points.add(new Point3d(x, y, z, color));
                            break;
                        default:
                            points.add(new Point3d(x, y, z));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            points = null;
        }
        return points;
    }
}
