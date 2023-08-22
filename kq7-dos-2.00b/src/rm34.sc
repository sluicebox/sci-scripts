;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use ExitButton)
(use WalkieTalkie)
(use Game)
(use Actor)
(use System)

(public
	rm34 0
)

(local
	local0
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
		((gUser alterEgo:) edgeHit: EDGE_NONE)
		(gGame handsOff:)
		(gUser canInput: 1)
	)

	(method (handleEvent)
		(if local0
			(WalkieTalkie killRobot:)
			((gCurRoom script:) cue:)
		)
	)
)

(instance doOpenMovie of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(FrameOut)
				(= cycles 2)
			)
			(1
				(if (== (Platform) 2)
					(ShowMovie 1 0 {INT08X11.AVI}) ; Put
					(ShowMovie 1 11 0) ; Put
					(if (IsFlag 538)
						(ShowMovie 1 15 0 22) ; Put
					else
						(ShowMovie 1 1 80 56) ; Put
					)
					(ShowMovie 1 7) ; Put
					(ShowMovie 1 8) ; Put
					(ShowMovie 1 2 0 0 2 1) ; Put
					(ShowMovie 1 14 7) ; Put
					(ShowMovie 1 6) ; Put
					(= cycles 3)
				else
					(= local0 1)
					(WalkieTalkie doRobot: 91 80 56 self 0)
				)
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
				(if (== (Platform) 2)
					(if (IsFlag 254)
						(ShowMovie 1 0 {E208X11.AVI}) ; Put
					else
						(ShowMovie 1 0 {E108X11.AVI}) ; Put
					)
					(ShowMovie 1 11 0) ; Put
					(if (IsFlag 538)
						(ShowMovie 1 15 0 22) ; Put
					else
						(ShowMovie 1 1 80 56) ; Put
					)
					(ShowMovie 1 7) ; Put
					(ShowMovie 1 8) ; Put
					(ShowMovie 1 2 0 0 2 1) ; Put
					(ShowMovie 1 14 7) ; Put
					(ShowMovie 1 6) ; Put
					(= cycles 3)
				else
					(= local0 1)
					(if (IsFlag 254)
						(WalkieTalkie doRobot: 912 80 56 self 0)
					else
						(WalkieTalkie doRobot: 911 80 56 self 0)
					)
				)
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

