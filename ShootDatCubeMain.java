import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ShootDatCubeMain extends GLCanvas implements GLEventListener {

    private float r_speed1;

    public static ArrayList<Integer> listeCube;
    public ShootDatCubeMain() {
        this.addGLEventListener(this);
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        // vider les valeurs du z-buffer
        gl.glClearDepth(1.0f);
        // activer le test de profondeur
        gl.glEnable(GL2.GL_DEPTH_TEST);
        // choisir le type de test de profondeur
        gl.glDepthFunc(GL2.GL_LEQUAL);
        // choix de la meilleur correction de perspective
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

        listeCube = new ArrayList<>();

        for(int i = 0 ; i < 8 ; i++){
            listeCube.add(i);
        }

        // blend
        gl.glColor4f(1f, 1f, 1f, 0.5f);//50% Alpha
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE);

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        // Initialisation des Ã©tats
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);     // Clear The Screen And The Depth Buffer
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glLoadIdentity();

        for(int i = 0 ; i < listeCube.size() ; i++) {
            createCube(gl, (float) i);
        }

        gl.glFlush();
        r_speed1 += 0.2f;
    }

    public void drawCube(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        // Front
        gl.glColor3d(0.184314, 0.184314, 0.309804);
        gl.glVertex3d(-1, -1, 1);
        gl.glVertex3d(1, -1, 1);
        gl.glVertex3d(1, 1, 1);
        gl.glVertex3d(-1, 1, 1);
        // Back
        gl.glColor3d(0.137255, 0.137255, 0.556863);
        gl.glVertex3d(-1, -1, -1);
        gl.glVertex3d(1, -1, -1);
        gl.glVertex3d(1, 1, -1);
        gl.glVertex3d(-1, 1, -1);
        // Left
        gl.glColor3d(0.258824, 0.258824, 0.435294);
        gl.glVertex3d(-1, -1, -1);
        gl.glVertex3d(-1, -1, 1);
        gl.glVertex3d(-1, 1,  1);
        gl.glVertex3d(-1, 1, -1);
        // Right
        gl.glColor3d(0.196078, 0.8, 0.6);
        gl.glVertex3d(1, -1, -1);
        gl.glVertex3d(1, -1, 1);
        gl.glVertex3d(1, 1,  1);
        gl.glVertex3d(1, 1, -1);
        // Bottom
        gl.glColor3d(0.22, 0.69, 0.87);
        gl.glVertex3d(-1, -1, 1);
        gl.glVertex3d(1, -1, 1);
        gl.glVertex3d(1, -1, -1);
        gl.glVertex3d(-1, -1, -1);
        // Up
        gl.glColor3d(0.372549, 0.623529, 0.623529);
        gl.glVertex3d(-1, 1, 1);
        gl.glVertex3d(1, 1, 1);
        gl.glVertex3d(1, 1, -1);
        gl.glVertex3d(-1, 1, -1);
        gl.glEnd();

    }

    public void createCube(GL2 gl, float x){

        gl.glPushMatrix();
        gl.glTranslatef(-15.0f+(4*x), 10.0f-(3*x), -35.0f);
        gl.glRotatef(r_speed1, 0.0f, 1.0f, 0.0f);
        gl.glScaled(2.0f, 2.0f, 2.0f);
        drawCube(gl);
        gl.glPopMatrix();
    }

    public static void destoryCube(){
        if (listeCube.size() > 1)
            listeCube.remove(listeCube.size()-1);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        GLU glu = GLU.createGLU(gl);

        float aspect = (float)width / height;
        // Set the view port (display area)
        gl.glViewport(0, 0, width, height);
        // Setup perspective projection,
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0, aspect, 0.1, 100.0);
        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset

    }

    public static void main(String[] args) {
        GLCanvas canvas = new ShootDatCubeMain();
        canvas.setPreferredSize(new Dimension(800, 600));

        // add animator to set the frame rate
        final FPSAnimator animator = new FPSAnimator(canvas, 300,true );

        final JFrame frame = new JFrame();
        frame.getContentPane().add(canvas);
        frame.setTitle("ShootDatCube");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // add control buttons to JPanel
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(0, 0));
        frame.add(p, BorderLayout.SOUTH);

        keyBindings(p, (ShootDatCubeMain) canvas);

        animator.start();
    }

    private static void keyBindings(JPanel p, final ShootDatCubeMain r) {

        ActionMap actionMap = p.getActionMap();
        InputMap inputMap = p.getInputMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");
        actionMap.put("space", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent drawable) {
                destoryCube();
            }});
    }

}