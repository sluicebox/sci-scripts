;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Print)
(use Dialog)
(use Talker)
(use System)

(public
	initCode 0
)

(instance initCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= global170 (== (Platform 4) 2))
		(Lock rsVIEW 989)
		(Lock rsVIEW 991)
		(Lock rsVIEW 992)
		(Lock rsVIEW 993)
		(Lock rsVIEW 994)
		(Lock rsVIEW 997)
		(Lock rsVIEW 999)
		(= temp1 (Str newWith: 8 {}))
		(= temp2 (Str newWith: 10 {}))
		(= temp3 (Str newWith: 10 {}))
		(= gUserFont 4)
		(Print font: 4)
		(Dialog font: gUserFont)
		(DText font: gUserFont)
		(Narrator font: gUserFont)
		(= gUseSortedFeatures 1)
		(= gEatMice 6)
		(= global116 0)
		(= gTheArrowCursor (ScriptID 25 2)) ; theArrowCursor
		(= gTheInvisCursor (ScriptID 25 3)) ; theInvisCursor
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp0)
		(FileIO fiCLOSE temp0)
		(Message msgGET 0 1 0 0 1 (temp2 data:)) ; "%d.scr"
		(temp3 format: (temp2 data:) 1)
		(if (FileIO fiEXISTS (temp3 data:))
			(= global105 0)
			(= gSysLogPath (Str new:))
			(gGame setCursor: (gNormalCursor view: 999 yourself:) 1 304 172)
			(while 1
				(= global111
					(Print
						font: gUserFont
						y: 5
						addText: {Where to?}
						addEdit: temp1 5 50 0
						addButton: 3 {Intro} 0 20
						addButton: 100 {South Central} 70 20
						addButton: 200 {Academy} 154 20
						addButton: 240 {Morgue} 0 34
						addButton: 300 {Bitty Kitty} 70 34
						addButton: 300 {Ragin' Records} 154 34
						addButton: 350 {Impound} 0 48
						addButton: 380 {City Hall} 70 48
						addButton: 400 {County Serv.} 154 48
						addButton: 420 {Griffith Park} 0 62
						addButton: 500 {Parker Ctr.} 70 62
						addButton: 600 {Theater} 154 62
						addButton: 700 {Thurman's} 0 76
						addButton: 780 {Hickman's} 70 76
						addButton: 800 {Yo Money's} 154 76
						addButton: 880 {Metzler's} 0 90
						addButton: 900 {Shortstop Bar} 70 90
						addButton: -100 {< Restore >} 0 106
						init:
					)
				)
				(if (temp1 size:)
					(= global111 (temp1 asInteger:))
				)
				(cond
					((== global111 111)
						(break)
					)
					((== global111 -100)
						(gGame restore:)
					)
					(else
						(if (== global111 3)
						else
							(= gDay
								(Print
									addText: {Which day?}
									addButton: 1 {Day 1} 0 12
									addButton: 2 {Day 2} 0 26
									addButton: 3 {Day 3} 0 40
									addButton: 4 {Day 4} 0 54
									addButton: 5 {Day 5} 0 68
									addButton: 6 {Day 6} 0 82
									init:
								)
							)
							(gTheIconBar enable:)
							(gThePlane setRect: 0 0 319 152)
						)
						(break)
					)
				)
			)
		else
			(= global105 0)
			(= global111 3)
		)
		(Message msgGET 0 13 0 0 1 (temp2 data:)) ; "cd.dat"
		(= gMsgType 3)
		(gGame setCursor: gWaitCursor 1 304 172 detailLevel: 5)
		(= global110 (DoSound sndGET_POLYPHONY))
		(temp1 dispose:)
		(temp2 dispose:)
		(temp3 dispose:)
	)
)

