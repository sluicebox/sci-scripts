;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use GK2Room)
(use Feature)

(public
	northExit 0
	southExit 1
	eastExit 2
	westExit 3
)

(class ExitRoom of GK2Room
	(properties)

	(method (init)
		(super init: &rest)
		(if south
			(southExit init:)
		)
		(if north
			(northExit init:)
		)
		(if east
			(eastExit init:)
		)
		(if west
			(westExit init:)
		)
	)

	(method (dispose)
		(self restore:)
		(super dispose: &rest)
	)

	(method (restore)
		(southExit
			nsLeft: 0
			nsTop: 300
			nsRight: 613
			nsBottom: 334
			exitDir: 4
			x: 225
			y: 2000
			sightAngle: 40
		)
		(northExit
			nsLeft: 0
			nsTop: 15
			nsRight: 613
			nsBottom: 84
			exitDir: 0
			x: 225
			y: 63536
			sightAngle: 40
		)
		(eastExit
			nsLeft: 586
			nsTop: 15
			nsRight: 640
			nsBottom: 334
			exitDir: 2
			x: 2000
			y: 250
			sightAngle: 40
		)
		(westExit
			nsLeft: 0
			nsTop: 15
			nsRight: 52
			nsBottom: 334
			exitDir: 6
			x: 63536
			y: 250
			sightAngle: 40
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		exitDir 4
	)

	(method (doVerb)
		(gCurRoom newRoom: (gCurRoom south:))
	)
)

(instance northExit of ExitFeature
	(properties
		nsTop 15
		nsRight 613
		nsBottom 84
		x 225
		y 63536
		exitDir 0
	)

	(method (doVerb)
		(gCurRoom newRoom: (gCurRoom north:))
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 250
		exitDir 2
	)

	(method (doVerb)
		(gCurRoom newRoom: (gCurRoom east:))
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x 63536
		y 250
		exitDir 6
	)

	(method (doVerb)
		(gCurRoom newRoom: (gCurRoom west:))
	)
)

