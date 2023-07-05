;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 372)
(include sci.sh)
(use Main)
(use n013)
(use Print)
(use Cursor)
(use Game)
(use System)

(public
	rm372 0
)

(local
	local0
	local1
)

(instance rm372 of Room
	(properties
		picture 99
		style 14
		exitStyle 0
	)

	(method (init)
		(gGame handsOff:)
		(ClearFlag 220)
		(= local0 gTheCursor)
		(gGame setCursor: myInvisCursor 1)
		(SetFlag 220)
		(super init:)
		(gGame handsOff:)
		(= gWaitCursor myInvisCursor)
		(gCurRoom setScript: egoTakesOff)
		(ClearFlag 220)
		(gTheIconBar erase: disable:)
		(SetCursor 0)
	)

	(method (dispose)
		(SetCursor 1)
		(ClearFlag 220)
		(= gWaitCursor local0)
		(gGame setCursor: gWaitCursor 1)
		(if (== (Platform) 1)
			(gGkMusic1 fade:)
		)
		(gTheIconBar enable:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose:)
	)
)

(instance egoTakesOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(= cycles 1)
			)
			(2
				(cond
					((IsFlag 470)
						(Prints {Movie Here})
					)
					((== (Platform) 1)
						(ShowMovie
							{MOTOR.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					)
					(else
						(gGkMusic1 stop:)
						(ShowMovie 0 {MOTOR.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
				)
				(= cycles 1)
			)
			(3
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(for ((= local1 100)) (>= local1 0) ((-= local1 5))
						(Palette 2 0 255 local1) ; PalIntensity
					)
					(SetVideoMode 0)
				)
				(= cycles 1)
			)
			(4
				(if (and (== gPrevRoomNum 370) (== gDay 5))
					(gCurRoom newRoom: 370)
				else
					(gCurRoom newRoom: global175)
				)
			)
		)
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

