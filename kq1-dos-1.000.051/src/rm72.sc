;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use rgClouds)
(use NewFeature)
(use LoadMany)
(use Motion)
(use System)

(public
	rm72 0
)

(instance rm72 of cloudRoom
	(properties
		picture 72
		east 56
	)

	(method (init)
		(Load rsVIEW 8)
		(LoadMany rsSOUND 7 6)
		(self
			style:
				(switch gPrevRoomNum
					(east 2)
					(else 43)
				)
		)
		(super init:)
		(SetFlag 0)
		(switch gPrevRoomNum
			(east
				(proc0_1)
				(gEgo posn: 317 168 init:)
			)
			(else
				(gCurRoom setScript: climbUpStalk)
			)
		)
		(stalk1 init:)
		(stalk2 init:)
		(stalk3 init:)
		(stalk4 init:)
		(stalk5 init:)
		(cloud1 init:)
		(cloud2 init:)
		(cloud3 init:)
		(cloud4 init:)
		(cloud5 init:)
		(cloud6 init:)
		(cloud7 init:)
		(cloud8 init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look[<at,around][/beanstalk,room]')
				(Print 72 0) ; "It is a mighty beanstalk which descends to the ground far below."
			)
			((Said 'look,look[<down][/grass,goat]')
				(Print 72 1) ; "You are much too high to see anything below you in any detail."
			)
			((Said 'climb,climb')
				(cond
					((not (gEgo inRect: 40 150 274 188))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 1)
						(Print 72 2) ; "You can't do that when you are invisible!"
					)
					((gCurRoom script:)
						(Print 72 3) ; "You're too busy"
					)
					(else
						(gCurRoom setScript: climbDownStalk)
					)
				)
			)
		)
	)
)

(instance climbDownStalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 48)
				(gEgo looper: 0 setCycle: Walk ignoreActors: illegalBits: 0)
				(cond
					((> (gEgo y:) 167)
						(self changeState: 3)
					)
					((< (gEgo x:) 66)
						(self changeState: 2)
					)
					((> (gEgo x:) 160)
						(self changeState: 2)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 65 (gEgo y:) self)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 171 self)
			)
			(3
				(gEgo setMotion: MoveTo 140 171 self)
			)
			(4
				(gEgo
					posn: 140 136
					view: 8
					setPri: 14
					setStep: 2 2
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 139 199 self
				)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: 71)
			)
		)
	)
)

(instance climbUpStalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					posn: 139 199
					view: 8
					init:
					setPri: 14
					setStep: 2 2
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 139 136 self
				)
			)
			(1
				(ClearFlag 48)
				(proc0_1)
				(gEgo posn: 142 171)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stalk1 of NewFeature
	(properties
		x 94
		y 76
		noun '/beanstalk'
		nsTop 23
		nsLeft 61
		nsBottom 130
		nsRight 127
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {At long last, you see the tip of the beanstalk, thinning and curling as it emerges from the cloud layer below.}
	)
)

(instance stalk2 of NewFeature
	(properties
		x 129
		y 148
		noun '/beanstalk'
		nsTop 130
		nsLeft 96
		nsBottom 166
		nsRight 162
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {At long last, you see the tip of the beanstalk, thinning and curling as it emerges from the cloud layer below.}
	)
)

(instance stalk3 of NewFeature
	(properties
		x 134
		y 123
		noun '/beanstalk'
		nsTop 117
		nsLeft 127
		nsBottom 130
		nsRight 141
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {At long last, you see the tip of the beanstalk, thinning and curling as it emerges from the cloud layer below.}
	)
)

(instance stalk4 of NewFeature
	(properties
		x 141
		y 59
		noun '/beanstalk'
		nsTop 21
		nsLeft 128
		nsBottom 98
		nsRight 154
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {At long last, you see the tip of the beanstalk, thinning and curling as it emerges from the cloud layer below.}
	)
)

(instance stalk5 of NewFeature
	(properties
		x 49
		y 105
		noun '/beanstalk'
		nsTop 87
		nsLeft 38
		nsBottom 124
		nsRight 60
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {At long last, you see the tip of the beanstalk, thinning and curling as it emerges from the cloud layer below.}
	)
)

(instance cloud1 of NewFeature
	(properties
		x 94
		y 54
		noun '/cloud'
		nsTop 34
		nsBottom 74
		nsRight 188
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 240
		y 59
		noun '/cloud'
		nsTop 48
		nsLeft 188
		nsBottom 71
		nsRight 292
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud3 of NewFeature
	(properties
		x 223
		y 17
		noun '/cloud'
		nsTop 13
		nsLeft 184
		nsBottom 22
		nsRight 262
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud4 of NewFeature
	(properties
		x 249
		y 88
		noun '/cloud'
		nsTop 82
		nsLeft 178
		nsBottom 94
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud5 of NewFeature
	(properties
		x 306
		y 77
		noun '/cloud'
		nsTop 72
		nsLeft 293
		nsBottom 82
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud6 of NewFeature
	(properties
		x 160
		y 167
		noun '/cloud'
		nsTop 145
		nsBottom 189
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud7 of NewFeature
	(properties
		x 246
		y 135
		noun '/cloud'
		nsTop 125
		nsLeft 173
		nsBottom 145
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

(instance cloud8 of NewFeature
	(properties
		x 300
		y 116
		noun '/cloud'
		nsTop 107
		nsLeft 280
		nsBottom 125
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {What a beautiful sight!  The clouds stretch out in every direction beyond you; near the beanstalk, they even seem thick enough to stand on!}
	)
)

