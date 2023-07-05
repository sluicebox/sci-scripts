;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use eRS)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(instance rm100 of FPRoom
	(properties
		picture 100
		style 10
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar disable:)
		(gGame setCursor: 996 1)
		(super init:)
		(sparkle init:)
		(gGameMusic1 number: 100 flags: 1 loop: 1 prevSignal: 0 play: self)
		(self setScript: sLogoCartoon)
	)

	(method (handleEvent event)
		(if (event type:)
			(event claimed: 1)
			(gCurRoom newRoom: 110)
		)
	)

	(method (dispose)
		(super dispose:)
		(gGameMusic1 stop:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)
)

(instance sLogoCartoon of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 95 224 1)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gGameMusic1 prevSignal:) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(1
				(if (== (gGameMusic1 prevSignal:) 30)
					(sparkle x: 60 y: 145 loop: 1 cel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(if
					(and
						(== (sparkle cel:) (sparkle lastCel:))
						(== (gGameMusic1 prevSignal:) -1)
					)
					(= cycles 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(gCurRoom newRoom: 110)
				(self dispose:)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 121
		y 54
		view 100
		priority 15
		signal 16
	)
)

