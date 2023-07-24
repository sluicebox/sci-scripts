;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQIconbar)
(use Str)
(use Array)
(use Print)

(public
	whereTo 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0 temp1)
	(gGame setCursor: gNormalCursor 1 307 190)
	(= temp0 (Str newWith: 10 {}))
	(= temp1 (Str newWith: 3 {}))
	(gGame setCursor: gNormalCursor 1)
	(Text 0 (local0 data:) {A} gUserFont 320) ; TextSize
	(= global300 0)
	(= global300
		(Print
			y: (+ (local0 at: 3) 6)
			font: gUserFont
			addTitle: {Space Quest 6}
			addText: {Where to?} 0 2
			addText: {Chapter (0-4)} 0 12
			addEdit: temp0 3 54 0
			addEdit: temp1 2 61 9
			addButton: -340 {Prologue} 0 21
			addButton: -345 {Chapter 1} 0 34
			addButton: -360 {Chapter 2} 0 47
			addButton: -360 {Chapter 3} 0 60
			addButton: -360 {Epilogue} 0 73
			addButton: 64538 {Exit} 0 86
			addButton: -480 {Shuttle} 55 21
			addButton: -111 {Polysorbate LX} 55 34
			addButton: -222 {Deepship 86} 55 47
			addButton: -333 {Delta Burksilon} 55 60
			addButton: -444 {Santiago's Body} 55 73
			addButton: 64981 {Santiago's Brain} 55 86
			addButton: -999 { Restore \nGame} 83 1
			init:
		)
	)
	(if (temp1 size:)
		(if (or (< (= gAct (temp1 asInteger:)) 0) (> gAct 4))
			(= gAct 1)
		)
	else
		(= gAct 1)
	)
	(if (temp0 size:)
		(= global300 (temp0 asInteger:))
	else
		(switch global300
			(-111
				(localproc_2)
			)
			(-222
				(localproc_1)
			)
			(-333
				(localproc_3)
			)
			(-340
				(= global300 100)
			)
			(-345
				(SetFlag 0)
				(= global300 340)
			)
			(-360
				(= global300 960)
			)
			(-444
				(localproc_4)
			)
			(64981
				(localproc_5)
			)
			(-480
				(localproc_6)
			)
			(64538
				(= gQuit 1)
			)
			(-999
				(gGame restore:)
				(localproc_0)
			)
			(else
				(= global300 100)
			)
		)
	)
	(gGame setCursor: gWaitCursor 1)
	(temp0 dispose:)
	(temp1 dispose:)
	(if (and (!= global300 100) (not gTheIconBar))
		(SQIconbar init: show:)
	)
	(gCurRoom newRoom: global300)
)

(procedure (localproc_1)
	(if
		(==
			(= global300
				(Print
					y: (+ (local0 at: 3) 6)
					font: gUserFont
					addTitle: {Deepship 86}
					addButton: 360 {Bridge} -1 0
					addButton: 370 {Brig} -1 13
					addButton: 380 {Sickbay} -1 26
					addButton: 390 {Roger's Quarters} -1 39
					addButton: 400 {HoloJoint} -1 52
					addButton: 420 {Transporter Room} -1 65
					addButton: 430 {8-Rear} -1 78
					addButton: 440 {Shuttle Bay Entrance} -1 91
					addButton: 450 {Shuttle Bay Interior} -1 104
					addButton: 999 {Previous Screen} -1 122
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_2)
	(if
		(==
			(= global300
				(Print
					y: (+ (local0 at: 3) 6)
					font: gUserFont
					addTitle: {Polysorbate LX}
					addButton: 200 {Arcade} -1 0
					addButton: 210 {Stooge Fighter} -1 13
					addButton: 220 {Hotel Hallway} -1 26
					addButton: 240 {Hotel Lobby} -1 39
					addButton: 250 {Implants N' Stuff} -1 52
					addButton: 260 {Thug's Room 1} -1 65
					addButton: 270 {Thug's Room 2} -1 78
					addButton: 280 {Liquor Store} 90 0
					addButton: 290 {Nightclub Basement} 90 13
					addButton: 300 {Nightclub Main Floor} 90 26
					addButton: 310 {Nightclub 2nd Floor} 90 39
					addButton: 320 {Street #1} 90 52
					addButton: 330 {Street #2} 90 65
					addButton: 340 {Street #3} 90 78
					addButton: 999 {Previous Screen} 45 96
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_3)
	(if
		(==
			(= global300
				(Print
					y: (+ (local0 at: 3) 6)
					font: gUserFont
					addTitle: {Delta Burksilon}
					addButton: 500 {TurboShaft} -1 0
					addButton: 510 {Lab A} -1 13
					addButton: 520 {Hospital Room} -1 26
					addButton: 550 {Fog} -1 39
					addButton: 560 {Storefront} -1 52
					addButton: 570 {Lobby} -1 65
					addButton: 580 {Fileroom} -1 78
					addButton: 999 {Previous Screen} -1 96
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_4)
	(if
		(==
			(= global300
				(Print
					font: gUserFont
					y: (+ (local0 at: 3) 6)
					addTitle: {Santiago's Body}
					addButton: 610 {Ulcer} -1 0
					addButton: 620 {Stomach} -1 13
					addButton: 640 {Esophagus} -1 26
					addButton: 650 {Deudenum Entrance} -1 39
					addButton: 660 {Deudenum Middle} -1 52
					addButton: 670 {Deudenum End} -1 65
					addButton: 680 {Pancreas} 98 0
					addButton: 690 {Islands of Langerhans} 98 13
					addButton: 700 {Bile Duct} 98 26
					addButton: 720 {Gallbadder} 98 39
					addButton: 730 {Large Intestine} 98 52
					addButton: 735 {Appendix} 98 65
					addButton: 999 {Previous Screen} 65 83
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_5)
	(if
		(==
			(= global300
				(Print
					font: gUserFont
					y: (+ (local0 at: 3) 6)
					addTitle: {Santiago's Brain}
					addButton: 740 {Brain Surface} -1 0
					addButton: 750 {Brain Shaft} -1 13
					addButton: 760 {Brain Foyer} -1 26
					addButton: 770 {Brain Core} -1 39
					addButton: 600 {Zit room} -1 52
					addButton: 999 {Previous Screen} -1 70
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_6)
	(if
		(==
			(= global300
				(Print
					y: (+ (local0 at: 3) 6)
					font: gUserFont
					addTitle: {Shuttle Location}
					addButton: 450 {ShuttleBay} -1 0
					addButton: 610 {Stomach} -1 13
					addButton: 740 {Brain} -1 26
					addButton: 999 {Previous Screen} -1 44
					init:
				)
			)
			999
		)
		(localproc_0)
	else
		(= gShuttleRoomNum global300)
		(= global300 480)
	)
)

(instance whereTo of SQRoom
	(properties)

	(method (init)
		(if gDebugging
			(= local0 (IntArray with: 0 0 0 0))
			(super init:)
			(localproc_0)
			(local0 dispose:)
		else
			(super init:)
			(gTheIconBar hide: 1)
			(gGame setCursor: gNormalCursor 1)
		)
	)
)

