;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use Actor)
(use System)

(public
	rm160 0
)

(instance rm160 of GloryRm
	(properties)

	(method (init)
		(gGlory handsOff:)
		(ClearFlag 6)
		(gThePlane back: 112 top: 0 inTop: 0)
		(super init: &rest)
		(textStuff init:)
		(skeleton init:)
		(gMouseDownHandler addToFront: sDoCredits)
		(gKeyDownHandler addToFront: sDoCredits)
		(gTheIconBar disable:)
		(gCurRoom setScript: sDoCredits)
	)

	(method (dispose)
		(gMouseDownHandler delete: sDoCredits)
		(gKeyDownHandler delete: sDoCredits)
		(gThePlane back: 0 top: 10 inTop: 10)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance sDoCredits of Script
	(properties)

	(method (handleEvent event)
		(cond
			((OneOf (event type:) evMOUSEBUTTON evKEYBOARD $0020) ; joyUp
				(if (== gPrevRoomNum 52) ; CharSave
					(EgoDead 1 0 16 1)
					(event claimed: 1)
					(SetFlag 6)
					(self dispose:)
				else
					(gCurRoom newRoom: 100)
				)
			)
			((== (event type:) evVERB)
				(event claimed: 1)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(textStuff view: 950 setCel: 1 x: 91 y: 18)
				(skeleton view: 952 setCel: 1 x: 63 y: 186 show:)
				(= ticks 240)
			)
			(1
				(textStuff view: 950 setCel: 0 x: 84 y: 19)
				(skeleton view: 952 cel: 0 x: 77 y: 176 show:)
				(= ticks 240)
			)
			(2
				(textStuff view: 950 setCel: 2 x: 84 y: 19)
				(skeleton view: 952 setCel: 2 x: 68 y: 166)
				(= ticks 240)
			)
			(3
				(textStuff view: 950 setCel: 3 x: 84 y: 19)
				(skeleton view: 952 setCel: 3 x: 78 y: 171)
				(= ticks 240)
			)
			(4
				(textStuff view: 950 setCel: 4 x: 84 y: 19)
				(skeleton view: 952 setCel: 4 x: 78 y: 182)
				(= ticks 240)
			)
			(5
				(textStuff view: 950 setCel: 5 x: 84 y: 19)
				(skeleton view: 952 setCel: 5 x: 85 y: 168)
				(= ticks 240)
			)
			(6
				(textStuff view: 950 setCel: 6 x: 84 y: 19)
				(skeleton view: 953 setCel: 0 x: 70 y: 182)
				(= ticks 240)
			)
			(7
				(textStuff view: 950 setCel: 7 x: 84 y: 19)
				(skeleton view: 953 setCel: 1 x: 62 y: 153)
				(= ticks 480)
			)
			(8
				(textStuff view: 950 setCel: 8 x: 84 y: 19)
				(skeleton view: 953 setCel: 2 x: 61 y: 125)
				(= ticks 480)
			)
			(9
				(textStuff view: 951 setCel: 0 x: 84 y: 19)
				(skeleton view: 953 setCel: 3 x: 62 y: 164)
				(= ticks 240)
			)
			(10
				(textStuff view: 951 setCel: 1 x: 84 y: 19)
				(skeleton view: 953 setCel: 4 x: 71 y: 159)
				(= ticks 240)
			)
			(11
				(textStuff view: 951 setCel: 2 x: 84 y: 19)
				(skeleton view: 953 setCel: 5 x: 69 y: 180)
				(= ticks 800)
			)
			(12
				(textStuff view: 951 setCel: 3 x: 78 y: 42)
				(skeleton hide:)
				(= ticks 240)
			)
			(13
				(textStuff view: 951 setCel: 4 x: 78 y: 42)
				(skeleton hide:)
				(= ticks 240)
			)
			(14
				(textStuff view: 951 setCel: 5 x: 38 y: 43)
				(skeleton hide:)
				(= ticks 480)
			)
			(15
				(textStuff view: 951 setCel: 9 x: 38 y: 43)
				(skeleton hide:)
				(= ticks 480)
			)
			(16
				(textStuff view: 951 setCel: 6 x: 7 y: 43)
				(skeleton hide:)
				(= ticks 800)
			)
			(17
				(textStuff view: 951 setCel: 7 x: 88 y: 23)
				(skeleton view: 953 setCel: 6 x: 77 y: 147 show:)
				(= ticks 240)
			)
			(18
				(textStuff view: 951 setCel: 8 x: 52 y: 57)
				(skeleton hide:)
				(= ticks 240)
			)
			(19
				(self changeState: 0)
			)
		)
	)
)

(instance skeleton of View
	(properties
		x 77
		y 176
		view 952
	)
)

(instance textStuff of View
	(properties
		x 84
		y 19
		view 950
	)
)

