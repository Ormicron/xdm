package xdman.ui.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import xdman.downloaders.http.HttpChannel;
import xdman.ui.res.ColorResource;
import xdman.ui.res.FontResource;
import xdman.ui.res.StringResource;
import xdman.util.FormatUtilities;

import static java.awt.Cursor.HAND_CURSOR;
import static xdman.util.XDMUtils.getScaledInt;
public class PropertiesPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9192969191740177178L;
	private static PropertiesPage propPage;
	private JTextField txtDefFile, txtDefFolder, txtUrl, lblReferer;
	private JLabel lblSize, lblDate, lblType;
	JTextArea txtCookie;
	JTextArea txtUserAgent;

	JButton submitBottom;


	public void setDetails(String file, String folder, long size, String url, String referer, String date,
						   String cookies, String userAgent, String type) {
		this.txtDefFile.setText(file);
		this.txtDefFolder.setText(folder);
		this.txtUrl.setText(url);
		this.lblSize.setText(FormatUtilities.formatSize(size));
		this.lblDate.setText(date);
		this.txtCookie.setText(cookies);
		this.txtUserAgent.setText(userAgent);
		this.lblType.setText(type);
		this.lblReferer.setText(referer);
	}

	private PropertiesPage(XDMFrame xframe) {
		super(StringResource.get("TITLE_PROP"), getScaledInt(350), xframe);
		initUI();
	}


	public void setRequestHeader(){
		System.out.println("Set User-Agent:" + txtUserAgent.getText());
		HttpChannel.userAgent = txtUserAgent.getText();
	}

	public static PropertiesPage getPage(XDMFrame xframe) {
		if (propPage == null) {
			propPage = new PropertiesPage(xframe);
		}
		return propPage;
	}

	private void initUI() {
		int y = 0;
		int h = 0;
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		y += getScaledInt(10);
		h = getScaledInt(30);
		JLabel lblFileTitle = new JLabel(StringResource.get("ND_FILE"));
		lblFileTitle.setForeground(Color.WHITE);
		lblFileTitle.setFont(FontResource.getNormalFont());
		lblFileTitle.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(30), h);
		panel.add(lblFileTitle);
		y += h;
		h = getScaledInt(25);
		txtDefFile = new JTextField();
		txtDefFile.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		txtDefFile.setBorder(new LineBorder(ColorResource.getDarkBtnColor()));
		txtDefFile.setEditable(false);
		txtDefFile.setForeground(Color.WHITE);
		txtDefFile.setOpaque(false);
		panel.add(txtDefFile);
		y += h;

		h = getScaledInt(30);
		JLabel lblFolderTitle = new JLabel(StringResource.get("CD_LOC"));
		lblFolderTitle.setForeground(Color.WHITE);
		lblFolderTitle.setFont(FontResource.getNormalFont());
		lblFolderTitle.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		panel.add(lblFolderTitle);
		y += h;
		h = getScaledInt(25);
		txtDefFolder = new JTextField();
		txtDefFolder.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		txtDefFolder.setBorder(new LineBorder(ColorResource.getDarkBtnColor()));
		txtDefFolder.setEditable(false);
		txtDefFolder.setForeground(Color.WHITE);
		txtDefFolder.setOpaque(false);
		panel.add(txtDefFolder);
		y += h;

		h = getScaledInt(30);
		JLabel lblUrlTitle = new JLabel(StringResource.get("ND_ADDRESS"));
		lblUrlTitle.setForeground(Color.WHITE);
		lblUrlTitle.setFont(FontResource.getNormalFont());
		lblUrlTitle.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		panel.add(lblUrlTitle);
		y += h;
		h = getScaledInt(25);
		txtUrl = new JTextField();
		txtUrl.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		txtUrl.setBorder(new LineBorder(ColorResource.getDarkBtnColor()));
		txtUrl.setEditable(false);
		txtUrl.setForeground(Color.WHITE);
		txtUrl.setOpaque(false);
		panel.add(txtUrl);
		y += h;

		h = getScaledInt(30);
		JLabel lblSizeLabel = new JLabel(StringResource.get("PROP_SIZE"));
		lblSizeLabel.setForeground(Color.WHITE);
		lblSizeLabel.setFont(FontResource.getNormalFont());
		lblSizeLabel.setBounds(getScaledInt(15), y, getScaledInt(100), h);
		panel.add(lblSizeLabel);

		lblSize = new JLabel();
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(FontResource.getNormalFont());
		lblSize.setBounds(getScaledInt(115), y, getScaledInt(200), h);
		panel.add(lblSize);
		y += h;

		h = getScaledInt(30);
		JLabel lblDateLabel = new JLabel(StringResource.get("PROP_DATE"));
		lblDateLabel.setForeground(Color.WHITE);
		lblDateLabel.setFont(FontResource.getNormalFont());
		lblDateLabel.setBounds(getScaledInt(15), y, getScaledInt(100), h);
		panel.add(lblDateLabel);

		lblDate = new JLabel();
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(FontResource.getNormalFont());
		lblDate.setBounds(getScaledInt(115), y, getScaledInt(200), h);
		panel.add(lblDate);
		y += h;

		h = getScaledInt(30);
		JLabel lblTypeLabel = new JLabel(StringResource.get("PROP_TYPE"));
		lblTypeLabel.setForeground(Color.WHITE);
		lblTypeLabel.setFont(FontResource.getNormalFont());
		lblTypeLabel.setBounds(getScaledInt(15), y, getScaledInt(100), h);
		panel.add(lblTypeLabel);

		lblType = new JLabel();
		lblType.setForeground(Color.WHITE);
		lblType.setFont(FontResource.getNormalFont());
		lblType.setBounds(getScaledInt(115), y, getScaledInt(200), h);
		panel.add(lblType);
		y += h;

		h = getScaledInt(30);
		JLabel lblRefererLabel = new JLabel(StringResource.get("PROP_REFERER"));
		lblRefererLabel.setForeground(Color.WHITE);
		lblRefererLabel.setFont(FontResource.getNormalFont());
		lblRefererLabel.setBounds(getScaledInt(15), y, getScaledInt(100), h);
		panel.add(lblRefererLabel);

		lblReferer = new JTextField();
		lblReferer.setForeground(Color.WHITE);
		lblReferer.setFont(FontResource.getNormalFont());
		lblReferer.setEditable(false);
		lblReferer.setBorder(null);
		lblReferer.setOpaque(false);
		lblReferer.setBounds(getScaledInt(115), y, getScaledInt(200), h);
		panel.add(lblReferer);
		y += h;

		h = getScaledInt(30);
		JLabel lblCookieTitle = new JLabel(StringResource.get("PROP_COOKIE"));
		lblCookieTitle.setForeground(Color.WHITE);
		lblCookieTitle.setFont(FontResource.getNormalFont());
		lblCookieTitle.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(30), h);
		panel.add(lblCookieTitle);
		y += h;
		y += getScaledInt(10);
		h = getScaledInt(120);


		txtCookie = new JTextArea();
		txtCookie.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		txtCookie.setBorder(new LineBorder(ColorResource.getDarkBtnColor()));
		txtCookie.setEditable(false);
		txtCookie.setForeground(Color.WHITE);
		txtCookie.setOpaque(false);
		panel.add(txtCookie);
		y += h;
		y += getScaledInt(10);


		/* Http Header */
		h = getScaledInt(30);
		JLabel lblHttpHeadrTitle = new JLabel("User-Agent");
		lblHttpHeadrTitle.setForeground(Color.WHITE);
		lblHttpHeadrTitle.setFont(FontResource.getNormalFont());
		lblHttpHeadrTitle.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(30), h);
		panel.add(lblHttpHeadrTitle);
		y += h;
		y += getScaledInt(10);
		h = getScaledInt(120);
		/* Http Header Textarea */
		txtUserAgent = new JTextArea();
		txtUserAgent.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(50), h);
		txtUserAgent.setBorder(new LineBorder(ColorResource.getDarkBtnColor()));
		txtUserAgent.setEditable(true);
		txtUserAgent.setForeground(Color.WHITE);
		txtUserAgent.setOpaque(false);
		panel.add(txtUserAgent);
		y += h;
		y += getScaledInt(10);

		submitBottom = new JButton("Save");
		submitBottom.setForeground(Color.WHITE);
		submitBottom.setFont(FontResource.getNormalFont());
		submitBottom.setBounds(getScaledInt(15), y, getScaledInt(100) - getScaledInt(10), 20);
		submitBottom.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
		submitBottom.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				setRequestHeader();
			}
		});
		panel.add(submitBottom);
		y += h;
		y += getScaledInt(10);



		panel.setPreferredSize(new Dimension(getScaledInt(350), y));
		panel.setBounds(getScaledInt(0), 0, getScaledInt(350), y);

		jsp.setViewportView(panel);
	}
}
