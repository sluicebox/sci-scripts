;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use LarryRoom)
(use n098)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(instance rm100 of LarryRoom
	(properties
		picture 100
		style 10
		autoLoad 0
		noControls 1
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar disable:)
		(super init:)
		(gGame setCursor: 98 1)
		(UnLoad 128 900)
		(gGlobalSound1 number: 100 loop: 1 play: 127)
		(sierra init:)
		(self setScript: sLogoCartoon 0 0)
	)

	(method (handleEvent event)
		(if (event type:)
			(event claimed: 1)
			(proc98_0)
		)
	)

	(method (dispose)
		(gGlobalSound1 fade:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance sLogoCartoon of Script
	(properties)

	(method (doit)
		(if (not register)
			(Palette palANIMATE 80 234 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (gGlobalSound1 prevSignal:) 50)
						(-- state)
						(gGlobalSound1 prevSignal: 0)
						(sierra setCycle: End self)
					)
					((== (gGlobalSound1 prevSignal:) -1)
						(gGlobalSound1 prevSignal: 0)
						(= seconds 4)
					)
					(else
						(-- state)
						(= cycles 1)
					)
				)
			)
			(1
				(DrawPic 98)
				(gCurRoom newRoom: 110)
				(self dispose:)
			)
		)
	)
)

(instance sierra of Prop
	(properties
		x 160
		y 188
		view 108
		signal 26640
	)
)

