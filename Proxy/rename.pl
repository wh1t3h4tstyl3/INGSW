my @listaFile = <*.jpg>;

my $i = 1;
foreach my $file (@listaFile) {
	if($i < 10) {
		rename("$file","wallPaper00$i.jpg");
	}
	elsif($i >= 10 && $i < 100) {
		rename("$file","wallPaper0$i.jpg");
	}
	else {
		rename("$file","wallPaper$i.jpg");	
	}
	$i++;
}

my @listaFile1 = <*.png>;

foreach my $file (@listaFile1) {
	rename("$file","wallPaper$i.png");	
	$i++;
}