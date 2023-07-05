;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 456)
(include sci.sh)
(use Main)
(use Feature)
(use Game)

(public
	magRosetta 0
)

(instance magRosetta of Rm
	(properties
		picture 780
	)

	(method (init)
		(if (gTimers contains: (ScriptID 90 15)) ; meetingTimer
			((ScriptID 90 15) client: self) ; meetingTimer
		)
		(self setRegions: 90) ; MuseumRgn
		(super init:)
		(bigRosetta init:)
	)

	(method (newRoom)
		(if (gTimers contains: (ScriptID 90 15)) ; meetingTimer
			(= timer 0)
			((ScriptID 90 15) client: (ScriptID 90 15)) ; meetingTimer, meetingTimer
		)
		(gGameMusic2 fade: 127 20 20 0)
		(super newRoom: &rest)
	)

	(method (cue)
		((ScriptID 90 15) setReal: self 10 0 0 gClockTimeMustDos) ; meetingTimer
	)
)

(instance bigRosetta of Feature
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
		(gGameMusic2 fade: 80 20 20 0)
		(gTheIconBar disable: 7)
		(super init: &rest)
		(gTheIconBar curIcon: (gTheIconBar at: 1) disable:)
		(if (== gPrevRoomNum 454)
			(DrawPic 455 100)
		else
			(DrawPic 521 100)
		)
		(gGame setCursor: 996)
		(if (== gPrevRoomNum 454)
			(SetCursor 2 79 55 239 144 86 0 0 456 53)
		else
			(SetCursor 2 79 55 239 144 86 0 0 527 53)
		)
		(Animate (gCast elements:) 0)
	)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			(SetCursor -1)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			(event claimed: 1)
			(self dispose:)
			(gTheIconBar enable:)
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

