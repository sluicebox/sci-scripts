;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 471)
(include sci.sh)
(use Main)
(use n013)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm471 0
)

(local
	local0
	local1
)

(instance rm471 of Room
	(properties
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(if (gGame keepBar:)
			(= local1 1)
		)
		(gGame keepBar: 0)
		(gTheIconBar erase: disable:)
		(SetFlag 11)
		(gGame handsOff:)
		(= local0 (gGame setCursor:))
		(gGame setCursor: myInvisCursor)
		(gGkMusic1
			number: 209
			flags: 1
			loop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(gCurRoom setScript: doTheCloseUp)
	)

	(method (dispose)
		(gGkMusic1 fade: 0 10 25 1)
		(if local1
			(gGame keepBar: 1)
		)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(gTheIconBar enable:)
		(gGame setCursor: local0)
		(super dispose:)
	)
)

(instance doTheCloseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gCurRoom drawPic: 600 12 1)
				(= cycles 1)
			)
			(2
				(blinker init:)
				(= seconds 2)
			)
			(3
				(windowPiece init:)
				(carWindow init: setPri: 23)
				(= seconds 1)
			)
			(4
				(gGkSound1 number: 474 play:)
				(carWindow cycleSpeed: 12 setCycle: End self)
			)
			(5
				(= seconds 2)
			)
			(6
				(smilePiece init:)
				(= seconds 3)
			)
			(7
				(maliaPiece init: setPri: 100)
				(= seconds 1)
			)
			(8
				(maliaFace init: setPri: 110)
				(= seconds 1)
			)
			(9
				(maliaFace cycleSpeed: 12 setCycle: End self)
			)
			(10
				(gabEyes init:)
				(raiseEyes init: setPri: 110)
				(= seconds 1)
			)
			(11
				(raiseEyes cycleSpeed: 12 setCycle: End self)
			)
			(12
				(= seconds 2)
			)
			(13
				(gCurRoom newRoom: 470)
				(self dispose:)
			)
		)
	)
)

(instance blinker of Prop
	(properties
		x 13
		y 86
		view 601
	)

	(method (init)
		(super init:)
		(self setPri: 14 cycleSpeed: 12 setCycle: Fwd)
	)
)

(instance carWindow of Prop
	(properties
		x 115
		y 22
		view 602
	)
)

(instance raiseEyes of Prop
	(properties
		x 236
		y 102
		view 603
	)
)

(instance maliaFace of Prop
	(properties
		x 227
		y 29
		view 604
		loop 3
	)
)

(instance windowPiece of View
	(properties
		x 84
		y 22
		view 600
	)
)

(instance smilePiece of View
	(properties
		x 112
		y 96
		view 600
		loop 1
	)
)

(instance maliaPiece of View
	(properties
		x 227
		y 29
		view 600
		loop 2
	)
)

(instance gabEyes of View
	(properties
		x 227
		y 102
		view 600
		loop 3
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

