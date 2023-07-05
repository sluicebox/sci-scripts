;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use ExitButton)
(use Game)
(use Actor)
(use System)

(public
	rm34 0
)

(instance rm34 of Room
	(properties
		picture 110
	)

	(method (init)
		(gGame handsOff:)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
		(switch gPrevRoomNum
			(30
				(self drawPic: 16)
				(self setScript: doOpenMovie)
			)
			(2208
				(gThePlane setRect: 0 0 319 199 priority: 4)
				(self drawPic: 216)
				(self setScript: doEndMovie)
			)
			(2210
				(gThePlane setRect: 0 0 319 199 priority: 4)
				(self drawPic: 116)
				(self setScript: doEndMovie)
			)
		)
		(self reflectPosn: (gUser alterEgo:) ((gUser alterEgo:) edgeHit:))
		((gUser alterEgo:) edgeHit: 0)
		(gGame handsOff:)
	)
)

(instance doOpenMovie of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(FrameOut)
				(= cycles 2)
			)
			(1
				(ShowMovie {King's Quest VII Intro} 1 0 0)
				(= cycles 3)
			)
			(2
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance doEndMovie of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(FrameOut)
				(= cycles 2)
			)
			(1
				(gKqMusic1 fade:)
				(gKqSound1 stop:)
				(if (IsFlag 254)
					(ShowMovie {King's Quest VII End2} 1 0 0)
				else
					(ShowMovie {King's Quest VII End1} 1 0 0)
				)
				(= cycles 3)
			)
			(2
				(gCurRoom newRoom: 960) ; endRoom
			)
		)
	)
)

(instance inter1 of View ; UNUSED
	(properties
		y 138
		view 950
	)
)

