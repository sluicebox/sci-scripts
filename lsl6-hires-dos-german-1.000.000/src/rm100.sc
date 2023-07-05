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
		style 14
		noControls 1
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar disable:)
		(gThePlane setRect: 0 0 319 199)
		(UpdatePlane gThePlane)
		(super init:)
		(SetCursor 98 0 0)
		(if (gGlobalSound2 handle:)
			(gGlobalSound2 number: 0 stop:)
		)
		(gGlobalSound1 number: 100 loop: 1 play: setVol: 127)
		(PalCycle 0 80 234 1) ; Start
		(sierra init: setPri: 200)
		(self setScript: sLogoCartoon 0 0)
	)

	(method (handleEvent event)
		(if (event type:)
			(event claimed: 1)
			(proc98_0)
		)
	)

	(method (dispose)
		(gThePlane setRect: 0 15 320 154)
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
			(PalCycle 1 80 1) ; DoCycle
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
				(gThePlane drawPic: -2)
				(gCurRoom newRoom: 110)
				(self dispose:)
			)
		)
	)
)

(instance sierra of Prop
	(properties
		x 163
		y 190
		view 108
	)
)

