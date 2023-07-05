;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 808)
(include sci.sh)
(use Main)
(use Interface)
(use PseudoMouse)
(use LoadMany)
(use User)
(use System)

(public
	initGame 0
	startUpRoom 1
)

(instance initGame of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 20] temp23)
		(Format @temp3 808 0 800) ; "%d.scr"
		(if (FileIO fiEXISTS @temp3)
			(= global102 1)
		)
		(Format @temp3 808 0 799) ; "%d.scr"
		(if (FileIO fiEXISTS @temp3)
			(= global226 1)
		)
		(param1 color: global187 back: global186 eraseOnly: 0)
		(= gSystemWindow param1)
		(= gOutlaws 31)
		(= gRansom 300)
		(= gPossibleScore 7325)
		(= gUseSortedFeatures 1)
		(if global102
			(StrCpy @gSysLogPath {})
		)
		(= gPMouse PseudoMouse)
		(= gEatMice 30)
		(User alterEgo: gEgo)
		(LoadMany rsVIEW 950 900 781)
		(gGame setCursor: gTheCursor 1 304 172)
		(= gUserFont 300)
		(= gVersion {x.yyy.zzz})
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp0)
		(FileIO fiCLOSE temp0)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= temp1 (Graph grGET_COLOURS))
		(if (<= 2 temp1 16)
			(ClearFlag 0)
			(= temp23 0)
		else
			(SetFlag 0)
			(= temp23 1)
		)
		(param2
			back: global187
			topBordColor: (if temp23 global184 else global180)
			lftBordColor: (if temp23 global187 else global182)
			rgtBordColor: (if temp23 global188 else global172)
			botBordColor: global189
		)
		(param3
			back: global190
			topBordColor: (if temp23 global184 else global185)
			lftBordColor: (if temp23 global187 else global178)
			rgtBordColor: (if temp23 global188 else global177)
			botBordColor: (if temp23 global189 else global177)
			insideColor: global170
			topBordColor2: global193
			lftBordColor2: global192
			botBordColor2: global194
			rgtBordColor2: global191
		)
		(= global123 (Random 0 11))
		(= global140 (Random 22 31))
		(= global144 (Random 0 9))
		(cond
			((GameIsRestarting)
				(= global147 140)
			)
			((and global102 global226)
				(= temp3 0)
				(= temp2 0)
				(while 1
					(= temp2
						(Print ; "Enter room number..."
							808
							1
							#button
							{Main Map}
							100
							#button
							{ Cave }
							140
							#button
							{ Intro }
							98
							#button
							{ Move Ahead }
							999
							#edit
							@temp3
							5
							#window
							gSystemWindow
						)
					)
					(if temp3
						(= temp2 (ReadNumber @temp3))
					)
					(cond
						((== temp2 999)
							((ScriptID 799) doit:) ; MISSING SCRIPT
							(break)
						)
						((> temp2 0)
							(= global147 temp2)
							(break)
						)
					)
				)
			)
			(else
				(= global147 98)
			)
		)
		(User canInput: 1 canControl: 1)
		(DisposeScript 940)
		(gGame newRoom: 803) ; speedTest
	)
)

(instance startUpRoom of Code
	(properties)

	(method (doit param1 &tmp [temp0 20])
		(if gPMouse
			(gPMouse stop:)
		)
		(= global104 (gEgo x:))
		(= global105 (gEgo y:))
		(= global111 (gEgo loop:))
		(= gEgoEdgeHit ((User alterEgo:) edgeHit:))
		(ClearFlag 110)
		(ClearFlag 148)
		(LoadMany
			0
			12
			5
			181
			940
			13
			490
			800
			812
			969
			951
			807
			973
			928
			941
			939
			930
			927
			955
			953
			971
			974
			11
			15
			16
			851
			970
			806
			964
			855
			892
			991
			860
			852
			603
			891
			890
		)
		(if
			(and
				global102
				global226
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(Print 808 2 #button {Who cares} 0 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(if (and (== gDay 11) (IsFlag 64))
			(++ gRoomCount)
		)
		(if (not (OneOf gDisguiseNum 0 4)) ; outlaw, yeoman
			(gTheIconBar disable: 4)
		)
		(if
			(and
				(OneOf
					gCurRoomNum
					180
					210
					150
					250
					580
					120
					390
					270
					310
					440
					350
					110
					120
					160
					220 ; forest
				)
				(OneOf gPrevRoomNum 100 260 630 450)
			)
			(gRgnMusic fade: 0 20 12 1)
		)
		(if
			(and
				(not (OneOf gCurRoomNum 690 590 600 610 700 580 620 701 702))
				(OneOf gPrevRoomNum 690 590 600 610 700 580 620 701 702)
			)
			(gSFX2 fade: 0 15 12 1)
		)
		(if
			(and
				(OneOf gCurRoomNum 690 590 600 610 700 580 620 701 702)
				(not (OneOf gPrevRoomNum 690 590 600 610 700 580 620 701 702))
			)
			(gSFX2 number: 580 vol: 127 loop: -1 play:)
		)
		(if
			(and
				(not (OneOf gCurRoomNum 250 590 600 610 620 690 700 680))
				(== (gSFX number:) 581)
			)
			(gSFX fade: 0 30 8 1)
		)
		(if (OneOf gCurRoomNum 100 260 630 450)
			(gTheIconBar disable: 2 3 4 6 7)
		)
		(if
			(not
				(OneOf
					gCurRoomNum
					260
					220 ; forest
					110
					120
					150
					180
					190
					210
					250
					590
					600
					580
					450
					440
					350
					390
					270
					280
					290
					300
					310
					455
					460
					470
					480
					45 ; hedge4
					640
					280
					290
					300
					310
				)
			)
			(gTheIconBar disable: 5)
		)
		(cond
			((OneOf param1 220 180 210 250)
				(if
					(or
						(and (== gDay 9) (not (IsFlag 36)))
						(and (== gDay 12) (not (IsFlag 38)))
					)
					(ScriptID 750) ; sweepRgn
					((ScriptID param1) setRegions: 750) ; sweepRgn
					(SetFlag 129)
				)
			)
			((OneOf param1 620 630 640 650 660 670 680 690 695)
				(ScriptID 625) ; Monastery
				((ScriptID param1) setRegions: 625) ; Monastery
			)
			((OneOf param1 110 120 100)
				(ScriptID 125) ; Wat
				((ScriptID param1) setRegions: 125) ; Wat
			)
			((OneOf param1 701 702 705)
				(ScriptID 720) ; theTower
				((ScriptID param1) setRegions: 720) ; theTower
			)
			((OneOf param1 470 480 450 460 455)
				(ScriptID 452) ; abbey
				((ScriptID param1) setRegions: 452) ; abbey
			)
			((OneOf param1 550 560 561 562 570)
				(ScriptID 564) ; TheDungeon
				((ScriptID param1) setRegions: 564) ; TheDungeon
			)
			((OneOf param1 590 600 610)
				(ScriptID 601) ; Fens
				(ScriptID 851)
				((ScriptID param1) setRegions: 601) ; Fens
			)
			((OneOf param1 280 290 300 310)
				(ScriptID 311) ; Fair
			)
		)
		(gGame setCursor: gWaitCursor 1)
	)
)

