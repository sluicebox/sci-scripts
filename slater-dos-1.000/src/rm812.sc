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
		(super init:)
		(sparkle init:)
		(gLongSong2
			number: (if (> global113 11) 100 else 1200)
			flags: 1
			loop: 1
			play:
		)
		(self setScript: sLogoCartoon)
	)

	(method (dispose)
		(gMouseDownHandler delete: sLogoCartoon)
		(gKeyDownHandler delete: sLogoCartoon)
		(gLongSong2 fade: 0 10 30 1)
		(super dispose:)
	)
)

(instance sLogoCartoon of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 112 223 -1)
		(gGame setCursor: 996)
		(super doit: &rest)
	)

	(method (handleEvent)
		(gGame handsOn:)
		(gCurRoom newRoom: 13)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Palette palSET_INTENSITY 0 254 0)
				(gMouseDownHandler addToFront: sLogoCartoon)
				(gKeyDownHandler addToFront: sLogoCartoon)
				(= seconds 6)
			)
			(1
				(if (== (gLongSong2 prevSignal:) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(if (== (gLongSong2 prevSignal:) 30)
					(sparkle x: 60 y: 155 loop: 1 setCel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(== (sparkle cel:) (sparkle lastCel:))
						(== (gLongSong2 prevSignal:) -1)
					)
					(= cycles 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 131
		y 54
		view 10
		priority 15
		signal 16
	)
)

