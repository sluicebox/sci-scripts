;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use Feature)
(use Game)
(use System)

(public
	rm680 0
)

(instance rm680 of Room
	(properties
		picture 680
	)

	(method (init)
		(super init: &rest)
		(gGlobalSound0 number: 150 loop: -1 play:)
		(if (and (== gDay 6) (not (gPqFlags test: 135)))
			(self setScript: rmScript)
		else
			(gGame handsOn:)
			(screen init:)
			(pic init:)
			(stairs init:)
			(door init:)
			(curtain init:)
			(rightCurtain init:)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 5)
			)
			(1
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance screen of Feature
	(properties
		nsRight 319
		nsBottom 151
		sightAngle 40
		x 159
		y 1
		z 45
	)

	(method (doVerb)
		(gCurRoom newRoom: 670)
	)
)

(instance pic of Feature
	(properties
		nsLeft 89
		nsTop 1
		nsRight 231
		nsBottom 148
		sightAngle 40
		x 160
		y 2
	)
)

(instance stairs of Feature
	(properties
		noun 3
		nsLeft 140
		nsTop 103
		nsRight 177
		nsBottom 148
		sightAngle 40
		x 158
		y 125
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 136
		nsTop 33
		nsRight 171
		nsBottom 102
		sightAngle 40
		x 153
		y 66
	)
)

(instance curtain of Feature
	(properties
		noun 2
		nsLeft 130
		nsTop 28
		nsRight 140
		nsBottom 148
		sightAngle 40
		x 135
		y 88
	)
)

(instance rightCurtain of Feature
	(properties
		noun 2
		nsLeft 172
		nsTop 45
		nsRight 204
		nsBottom 147
		sightAngle 40
		x 188
		y 96
	)
)

