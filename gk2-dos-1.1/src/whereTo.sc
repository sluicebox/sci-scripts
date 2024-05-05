;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use Str)
(use Array)
(use Print)
(use Game)
(use System)

(public
	whereTo 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 (Str newWith: 10 {}))
	(= temp1 (Str newWith: 3 {}))
	(gGame setCursor: gNormalCursor 1)
	(Text 0 (local0 data:) {A} gUserFont 320) ; TextSize
	(= local1 0)
	(= local1
		(Print
			y: 50
			font: 50
			back: 4
			fore: 14
			addTitle: {Gabriel Knight The Beast Within}
			addText: {Where to?} 0 5
			addEdit: temp0 5 74 2
			addText: {Chapter? (1-6)} 0 22
			addEdit: temp1 1 126 18
			addButton: -100 {Schloss Ritter} 0 45
			addButton: -200 {Munich Outskirts} 0 65
			addButton: -300 {Greater Munich} 0 85
			addButton: -400 {Munich Center} 0 105
			addButton: -500 {Hunting Lodge} 0 125
			addButton: 64936 {Woods and Cave} 0 145
			addButton: 64836 {Rittersburg} 160 45
			addButton: 64736 {Southern Bavaria} 160 65
			addButton: 64636 {Neuschwanstein} 160 85
			addButton: -1000 {Altotting} 160 105
			addButton: 64436 {Residence Theatre} 160 125
			addButton: -5 {Movie Player} 160 145
			addButton: -1 {Begin\n_________Chapter________} 160 2
			addButton: -999 {Restore Game} 160 175
			addButton: 64538 {Exit} 0 175
			init:
		)
	)
	(gTopMessage newText: 0)
	(cond
		((temp1 size:)
			(if (or (< (= gChapter (temp1 asInteger:)) 1) (> gChapter 6))
				(= gChapter 1)
			)
			(gGame updateFrames:)
		)
		((not gChapter)
			(= gChapter 1)
		)
	)
	(= gEgo (if (OneOf gChapter 1 3 5) GabeEgo else GraceEgo))
	(gUser alterEgo: gEgo curVerb: 62)
	(if (temp0 size:)
		(= local1 (temp0 asInteger:))
	else
		(switch local1
			(-1
				(InitChapter)
				(return)
			)
			(-5
				(= local1 5)
			)
			(-100
				(localproc_1)
			)
			(-200
				(localproc_2)
			)
			(-300
				(localproc_3)
			)
			(-400
				(localproc_4)
			)
			(-500
				(localproc_5)
			)
			(64936
				(localproc_6)
			)
			(64836
				(localproc_7)
			)
			(64736
				(localproc_8)
			)
			(64636
				(localproc_9)
			)
			(64538
				(= gQuit 1)
			)
			(-999
				(gGame restore:)
				(temp0 dispose:)
				(temp1 dispose:)
				(= temp1 (= temp0 0))
				(localproc_0)
				(return)
			)
			(-1000
				(localproc_10)
			)
			(64436
				(localproc_11)
			)
			(else
				(= local1 400)
			)
		)
	)
	(if temp0
		(temp0 dispose:)
	)
	(if temp1
		(temp1 dispose:)
	)
	(gCurRoom newRoom: local1)
)

(procedure (localproc_1)
	(if
		(==
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Schloss Ritter}
					addButton: 100 {Exterior} -1 0
					addButton: 120 {Main Hall} -1 20
					addButton: 130 {Library} -1 40
					addButton: 140 {Gabe's Room} -1 60
					addButton: 150 {Gerde's Room} -1 80
					addButton: 160 {Secret Passage} -1 100
					addButton: 170 {Exterior Wall} -1 120
					addButton: 999 {Previous Screen} -1 150
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
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Munich Outskirts}
					addButton: 200 {Munich Map} -1 0
					addButton: 210 {Huber Farm Int} -1 20
					addButton: 220 {Huber Farm Field} -1 40
					addButton: 230 {Zoo Kennel} -1 60
					addButton: 240 {Zoo Office} -1 80
					addButton: 250 {Dorn Ext} -1 100
					addButton: 260 {Dorn Int} -1 120
					addButton: 999 {Previous Screen} -1 150
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
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Greater Munich}
					addButton: 300 {University Bio Lab} -1 0
					addButton: 310 {Police Lobby} -1 20
					addButton: 320 {Leber's Office} -1 40
					addButton: 330 {Von Glower's House} -1 60
					addButton: 340 {Von Glower's Spare Bedroom} -1 80
					addButton: 350 {Grossberg's Office Int} -1 100
					addButton: 360 {Grossberg's Office Ext} -1 120
					addButton: 999 {Previous Screen} -1 150
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
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Munich City Center}
					addButton: 400 {Marienplatz} -1 0
					addButton: 410 {Dienerstrasse} -1 20
					addButton: 420 {Ubergrau's Office} -1 40
					addButton: 430 {Hunt Club: Front Hall} -1 60
					addButton: 440 {Hunt Club: Main Hall} -1 80
					addButton: 450 {Hunt Club: Back Hall} -1 100
					addButton: 460 {Hunt Club: Ritual Room} -1 120
					addButton: 470 {Crime Scene} -1 140
					addButton: 999 {Previous Screen} -1 170
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
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Hunting Lodge}
					addButton: 500 {Exterior} -1 0
					addButton: 510 {Stable} -1 20
					addButton: 520 {Great Room} -1 40
					addButton: 530 {Upper Hall} -1 60
					addButton: 540 {Gabe's Room} -1 80
					addButton: 542 {Klingman's Room} -1 100
					addButton: 543 {Priess's Room} -1 120
					addButton: 544 {Von G's Room} -1 140
					addButton: 545 {Von A's Room} -1 160
					addButton: 546 {Von Z's Room} -1 180
					addButton: 999 {Previous Screen} -1 210
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
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Woods}
					addButton: 600 {Woods 1} -1 0
					addButton: 605 {Woods 2} -1 20
					addButton: 610 {Woods 3} -1 40
					addButton: 615 {Woods 4} -1 60
					addButton: 620 {Woods 5} -1 80
					addButton: 625 {Woods 6} -1 100
					addButton: 630 {Woods 7} -1 120
					addButton: 635 {Woods 8} -1 140
					addButton: 640 {Lair Exterior} -1 160
					addButton: 650 {Ravine} -1 180
					addButton: 660 {Cave Main} -1 200
					addButton: 670 {Cave Ext} -1 220
					addButton: 999 {Previous Screen} -1 250
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_7)
	(if
		(==
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Rittersburg}
					addButton: 700 {Town Square} -1 0
					addButton: 710 {Courtyard} -1 20
					addButton: 720 {Dungeon} -1 40
					addButton: 730 {St George Int} -1 60
					addButton: 740 {Gast Gold Lowe} -1 80
					addButton: 999 {Previous Screen} -1 110
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_8)
	(if
		(==
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					mode: 1
					addTitle: {Southern Bavaria}
					addButton: 800 {Map} -1 0
					addButton: 810 {Herrenchiemsee Entry Rm} -1 20
					addButton: 820 {Herrenchiemsee Disp Rm 1} -1 40
					addButton: 830 {Herrenchiemsee Disp Rm 2} -1 60
					addButton: 840 {Starnberger See: Cross} -1 80
					addButton: 850 {Wahnfried Entry Hall} -1 100
					addButton: 8601 {Wahnfried Display Rm 1} -1 120
					addButton: 8602 {Wahnfried Display Rm 2} -1 140
					addButton: 8603 {Wahnfried Display Rm 3} -1 160
					addButton: 8604 {Wahnfried Display Rm 4} -1 180
					addButton: 870 {Seeshaupt} -1 200
					addButton: 999 {Previous Screen} -1 230
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_9)
	(if
		(==
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					addTitle: {Neuschwanstein}
					addButton: 910 {Entry Hall} -1 0
					addButton: 920 {Bedroom} -1 20
					addButton: 930 {Study} -1 40
					addButton: 940 {Chapel} -1 60
					addButton: 950 {Living Rm} -1 80
					addButton: 960 {Grotto} -1 100
					addButton: 970 {Saangerhall} -1 120
					addButton: 999 {Previous Screen} -1 150
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_10)
	(if
		(==
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					addTitle: {Altotting}
					addButton: 1000 {Church Ext} -1 0
					addButton: 1010 {Chapel} -1 20
					addButton: 1020 {Priest's Office} -1 40
					addButton: 999 {Previous Screen} -1 70
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_11)
	(if
		(==
			(= local1
				(Print
					y: (+ (local0 at: 3) 14)
					font: 50
					addTitle: {Residence Theatre}
					addButton: 1100 {Foyer} -1 0
					addButton: 1110 {Auditorium} -1 20
					addButton: 1120 {Office} -1 40
					addButton: 1130 {Side Hallway} -1 60
					addButton: 1140 {Center Hall} -1 80
					addButton: 1150 {Backstage} -1 100
					addButton: 1160 {Dressing Room} -1 120
					addButton: 1170 {Splotlight Room} -1 140
					addButton: 1180 {Basement Hall} -1 160
					addButton: 1185 {Prop Room} -1 180
					addButton: 1190 {Furnace Room} -1 200
					addButton: 999 {Previous Screen} -1 230
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(instance whereTo of Room
	(properties)

	(method (init)
		(gTopMessage newText: {Where Do You Want To Go?})
		(= local0 (IntArray with: 0 0 0 0))
		(super init:)
		(localproc_0)
		(local0 dispose:)
	)
)

