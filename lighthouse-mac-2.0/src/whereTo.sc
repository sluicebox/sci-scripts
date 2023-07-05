;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use Game)

(public
	whereTo 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0)
	(gGame normalizeCursor:)
	(= temp0 (Str newWith: 10 {}))
	(= local0
		((Print new:)
			y: 50
			fore: 255
			back: 255
			font: gUserFont
			addTitle: {Lighthouse}
			addText: {Where to?} 0 5
			addEdit: temp0 5 74 2
			addButton: -100 {Intro} 0 35
			addButton: -150 {Home} 0 55
			addButton: -200 {Lighthouse} 0 75
			addButton: -300 {Roost} 0 95
			addButton: -302 {Sub} 0 115
			addButton: -303 {Fortress} 0 135
			addButton: -301 {Dark Domain} 0 155
			addButton: -304 {Temple} 0 175
			addButton: -400 {Test Room} 0 200
			addButton: -500 {Movie Player} 0 220
			addButton: 64936 {Restore} 0 240
			addButton: -999 {Quit} 0 265
			init:
		)
	)
	(if (temp0 size:)
		(= local0 (temp0 asInteger:))
	else
		(switch local0
			(-100
				(= local0 5)
				(= global224 1)
			)
			(-150
				(= local0 20)
				(= global224 1)
			)
			(-200
				(localproc_2)
				(= global224 1)
			)
			(-300
				(localproc_3)
				(= global224 2)
			)
			(-301
				(localproc_5)
				(= global224 1)
			)
			(-302
				(localproc_4)
				(gInventory add: (ScriptID 9 32)) ; invThrottle
				(= global224 2)
			)
			(-303
				(localproc_6)
				(= global224 2)
			)
			(-304
				(localproc_7)
				(= global224 1)
			)
			(-400
				(= local0 111)
			)
			(-500
				(= local0 10)
			)
			(64936
				(gGame restore:)
				(localproc_0)
			)
			(-999
				(= gQuit 1)
			)
			(else
				(= local0 5)
				(= global224 1)
			)
		)
	)
	(if temp0
		(temp0 dispose:)
	)
	(if (!= local0 5)
		(if (not (gGame liteInterface:))
			((ScriptID 9 1) init:) ; PlInterface
		)
		(gUser curVerb: 5)
	)
	(= global225 local0)
	(gGame getDisc: global224)
	(gCurRoom newRoom: local0)
)

(procedure (localproc_1) ; UNUSED
	(if
		(==
			(= local0
				((Print new:)
					y: 50
					fore: 255
					back: 255
					font: gUserFont
					mode: 1
					addTitle: {Introduction}
					addButton: 20 {Home, facing right} -1 0
					addButton: 22 {Home, facing middle} -1 20
					addButton: 24 {Home, facing left} -1 40
					addButton: 999 {Previous Screen} -1 70
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
			(= local0
				((Print new:)
					y: 50
					fore: 255
					back: 255
					font: gUserFont
					mode: 1
					addTitle: {Lighthouse}
					addButton: 300 {Exterior of Lighthouse} -1 0
					addButton: 320 {Interior Hallway} -1 20
					addButton: 330 {Oil Room} -1 40
					addButton: 340 {Bedroom} -1 60
					addButton: 350 {Study} -1 80
					addButton: 360 {Lab} -1 100
					addButton: 999 {Previous Screen} -1 130
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
			(= local0
				((Print new:)
					y: 50
					fore: 255
					back: 255
					font: gUserFont
					mode: 1
					addTitle: {Roost}
					addButton: 400 {Beach and Pier} -1 0
					addButton: 440 {Drawbridge} -1 20
					addButton: 447 {Outside Stairway} -1 40
					addButton: 470 {Workshop} -1 60
					addButton: 480 {Submarine Chamber} -1 80
					addButton: 490 {Bedroom} -1 100
					addButton: 500 {Bat Hangar} -1 120
					addButton: 999 {Previous Screen} -1 140
					init:
				)
			)
			440
		)
		(gInventory add: (ScriptID 9 9)) ; invDrawbridgeKey
	)
	(if (== local0 999)
		(localproc_0)
	)
)

(procedure (localproc_4)
	(switch
		(= local0
			((Print new:)
				y: 50
				fore: 255
				back: 255
				font: gUserFont
				mode: 1
				addTitle: {Sub}
				addButton: 700 {Submarine pod} -1 0
				addButton: 220 {Submarine Control Room} -1 20
				addButton: 999 {Previous Screen} -1 50
				init:
			)
		)
		(220
			(localproc_8)
		)
		(700
			(= global226 4)
		)
		(999
			(localproc_0)
		)
	)
)

(procedure (localproc_5)
	(if
		(==
			(= local0
				((Print new:)
					y: 50
					fore: 255
					back: 255
					font: gUserFont
					mode: 1
					addTitle: {Dark Domain}
					addButton: 810 {Submarine Dock} -1 0
					addButton: 270 {Train Interior} -1 20
					addButton: 800 {Gate Device Chamber} -1 40
					addButton: 820 {The Machine Room} -1 60
					addButton: 870 {Thermal Power Chamber} -1 80
					addButton: 880 {Bathysphere} -1 100
					addButton: 999 {Previous Screen} -1 120
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
			(= local0
				((Print new:)
					y: 50
					fore: 255
					back: 255
					font: gUserFont
					mode: 1
					addTitle: {Fortress}
					addButton: 600 {Water Gate} -1 0
					addButton: 630 {Wind Power Chamber} -1 20
					addButton: 630 {Foundry} -1 40
					addButton: 680 {Watch Tower} -1 60
					addButton: 260 {Ornithopter Loft} -1 80
					addButton: 999 {Previous Screen} -1 110
					init:
				)
			)
			630
		)
		(gInventory add: (ScriptID 9 13)) ; invCompass
	)
	(if (== local0 999)
		(localproc_0)
	)
)

(procedure (localproc_7)
	(= local0 760)
	(if
		(==
			(= local0
				((Print new:)
					y: 50
					fore: 255
					back: 255
					font: gUserFont
					mode: 1
					addTitle: {Temple}
					addButton: 710 {Beach} -1 0
					addButton: 765 {Dome} -1 20
					addButton: 770 {Right Chamber} -1 40
					addButton: 780 {Ancient Machines} -1 60
					addButton: 720 {Entry Hall} -1 80
					addButton: 750 {Left Chamber} -1 100
					addButton: 740 {Central Chamber} -1 120
					addButton: 999 {Previous Screen} -1 150
					init:
				)
			)
			999
		)
		(localproc_0)
	)
)

(procedure (localproc_8)
	(switch
		(= local1
			((Print new:)
				y: 50
				fore: 255
				back: 255
				font: gUserFont
				mode: 1
				addTitle: {Sub Location}
				addButton: 1 {Dark Domain} -1 0
				addButton: 2 {Roost} -1 20
				addButton: 3 {Fortress} -1 40
				addButton: 4 {Wreck} -1 60
				addButton: 5 {Main Screen} -1 80
				init:
			)
		)
		(1
			(= global226 1)
		)
		(2
			(= global226 2)
		)
		(3
			(= global226 3)
		)
		(4
			(= global226 4)
		)
		(5
			(localproc_0)
		)
	)
)

(instance whereTo of Room
	(properties)

	(method (init &tmp temp0)
		(gGame setCursor: gNormalCursor 1 320 240)
		(super init:)
		(gCurRoom newRoom: 5)
	)
)

