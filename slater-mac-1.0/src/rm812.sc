;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm812 0
)

(instance rm812 of Rm
	(properties
		picture 812
		style 10
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(sparkle init:)
		(gLongSong number: 100 flags: 1 loop: 1 prevSignal: 0 play:)
		(super init:)
		(self setScript: sLogoCartoon)
	)

	(method (handleEvent event)
		(if (event type:)
			(event claimed: 1)
			(sLogoCartoon changeState: 5)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance sLogoCartoon of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 112 223 -1)
		(gGame setCursor: 999)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(= seconds 6)
			)
			(2
				(if (== (gLongSong prevSignal:) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(if (== (gLongSong prevSignal:) 30)
					(sparkle x: 60 y: 155 loop: 1 setCel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(if
					(and
						(== (sparkle cel:) (sparkle lastCel:))
						(== (gLongSong prevSignal:) -1)
					)
					(= cycles 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(5
				(gLongSong fade: 0 10 30 1)
				(gGame handsOn:)
				(gCurRoom newRoom: 13)
				(self dispose:)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 131
		y 54
		view 10
		priority 14
		signal 16
	)
)

