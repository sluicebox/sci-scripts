;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use eRS)
(use Feature)

(public
	rm680 0
)

(instance rm680 of FPRoom
	(properties
		picture 680
	)

	(method (init)
		(super init:)
		(magnifiedRX init:)
	)

	(method (cue)
		(magnifiedRX dispose:)
		(gTheIconBar enable:)
	)
)

(instance magnifiedRX of Feature
	(properties
		y 190
		nsTop 50
		nsLeft 50
		nsBottom 145
		nsRight 210
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gTheIconBar disable: 7)
		(super init: &rest)
		(gTheIconBar curIcon: (gTheIconBar at: 1) disable:)
		(gGame setCursor: 996)
		(SetCursor 2 86 53 238 157 685 0 0 680 77)
		(Animate (gCast elements:) 0)
	)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			(SetCursor -1)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			(event claimed: 1)
			(gEgo put: 50 put: 32) ; Shot_Glass, Madame_s_Rx
			(gEgo get: -1 58) ; Under_Glass
			(if (not (IsFlag 51))
				(gMessager say: 23 0 7 0 gCurRoom 0) ; "Ahh! Now you can see this prescription the way Doc wrote it."
				(gGame points: 10)
				(SetFlag 51)
			else
				(self dispose:)
				(gTheIconBar enable:)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
		(gTheIconBar enable: 7)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

