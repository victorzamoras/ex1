package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		return os;

	}

	public void ip(String os) {
		if (os.equals("Windows 10")) {

			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String ip = "";
				while (linha != null) {
					linha = buffer.readLine();
					ip = ip + linha;

				}
				buffer.close();
				leitor.close();
				fluxo.close();
				String[] iper = ip.split(" ");
				for (int i = 0; i < iper.length; i++) {
					if (iper[i].equals("Adaptador") || iper[i].equals("WindowsAdaptador")) {
						for (int j = i + 1; j < iper.length; j++) {
							if (iper[j].equals("IPv4.")) {
								String r = "";
								for (int j2 = i; j2 < iper.length; j2++) {
									if (!iper[j2].contains(":")) {
										r = r + (iper[j2]) + " ";

									} else {
										r = r + (iper[j2]);
										System.out.println(r);
										break;
									}
								}
								break;
							} else if (iper[j].equals("Adaptador")) {
								break;
							}
						}
					}
					if (iper[i].equals("IPv4.")) {
						System.out.println(iper[i + 17]);
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (os.equals("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String ip = "";
				while (linha != null) {
					linha = buffer.readLine();
					ip = ip + linha;
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				String[] iper = ip.split(" ");
				for (int i = 0; i < iper.length; i++) {
					if (iper[i].equals("inet")) {
						System.out.println(iper[i] + " " + iper[i + 1]);
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void ping(String os) {

		if (os.equals("Windows 10")) {
			Process p;

			try {

				p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String ping = "";
				while (linha != null) {
					linha = buffer.readLine();
					ping = ping + linha;
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				String[] pingers = ping.split(" ");
				System.out.println(pingers[pingers.length - 1].replace("null", ""));

			} catch (IOException e) {

				e.printStackTrace();
			}

		} else if (os.equals("Linux")) {
			Process p;

			try {

				p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String ping = "";
				while (linha != null) {
					linha = buffer.readLine();
					ping = ping + linha;
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				String[] pingers = ping.split("/");
				System.out.println(pingers[pingers.length - 3].replace("null", ""));

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}
}