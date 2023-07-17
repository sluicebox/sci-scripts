;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 665)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Feature)
(use System)

(public
	gabeNews 0
)

(instance gabeNews of GK2Room
	(properties
		picture 12091
	)

	(method (init)
		(proc11_12)
		(Palette 2 0 255 0) ; PalIntensity
		(super init: &rest)
		(gThePlane setRect: 0 0 640 480 priority: 202)
		(gGame sel_849:)
		((ScriptID 0 9) active: 0) ; logo
		((ScriptID 0 7) active: 0) ; movieButton
		((ScriptID 0 5) active: 0) ; recButton
		(UpdatePlane gThePlane)
		(southExit init:)
		(westExit init:)
		(eastExit init:)
		(proc11_13)
		(self setScript: sWaitAndMoveOn)
	)
)

(instance sWaitAndMoveOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 1200)
			)
			(2
				(UnLoad 129 (gCurRoom picture:))
				(gCurRoom drawPic: -1 newRoom: 666) ; uDie
				(self dispose:)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 440
		nsRight 640
		nsBottom 480
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb)
		(gCurRoom newRoom: 666) ; uDie
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 480
		x 2000
		y 250
		BAD_SELECTOR 2
	)

	(method (doVerb)
		(gCurRoom newRoom: 666) ; uDie
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 40
		nsBottom 480
		x 63536
		y 250
		BAD_SELECTOR 6
	)

	(method (doVerb)
		(gCurRoom newRoom: 666) ; uDie
	)
)

