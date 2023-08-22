;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm71 0
)

(instance rm71 of Rm
	(properties
		picture 71
		horizon 4
		north 72
		south 70
	)

	(method (init)
		(Load rsVIEW 8)
		(Load rsSOUND 7)
		(self
			style:
				(switch gPrevRoomNum
					(north 42)
					(south 43)
				)
		)
		(super init:)
		((ScriptID 0 23) number: 7 loop: -1 play:) ; backSound
		(switch gPrevRoomNum
			(south
				(gEgo y: 193)
			)
			(else
				(gEgo posn: 159 8)
			)
		)
		(self setRegions: 609) ; climbRg
		(gEgo init:)
		(proc0_1)
		(gEgo looper: 0 setCycle: Walk view: 8 setStep: 2 2 setPri: 11)
		(if (== gPrevRoomNum south)
			(self setScript: climbIntoView)
		)
		(stalk1 init:)
		(stalk2 init:)
		(stalk3 init:)
		(cloud1 init:)
		(cloud2 init:)
		(cloud3 init:)
		(cloud4 init:)
	)

	(method (doit &tmp temp0)
		(if (== script (ScriptID 609 1)) ; climbing
			(script doit:)
		)
		(cond
			((and script (!= script (ScriptID 609 1))) ; climbing
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(if (== temp0 north)
					(SetScore 110 2)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look[<at,around][/room,beanstalk]')
				(Print 71 0) ; "The beanstalk disappears up into the clouds."
			)
			((Said 'look,look[<down][/grass,goat]')
				(Print 71 1) ; "You are too high to see anything below you in detail."
			)
		)
	)
)

(instance climbIntoView of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 137 178 self)
			)
			(1
				(HandsOn)
				(gCurRoom setScript: (ScriptID 609 1)) ; climbing
				(self dispose:)
			)
		)
	)
)

(instance stalk1 of NewFeature
	(properties
		x 135
		y 94
		noun '/beanstalk'
		nsLeft 112
		nsBottom 189
		nsRight 158
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You can see neither the top nor the bottom of the gigantic beanstalk you're clinging to.  The ropey green vines easily hold your weight, and the massive main stem winds gently upward.}
	)
)

(instance stalk2 of NewFeature
	(properties
		x 94
		y 68
		noun '/beanstalk'
		nsTop 23
		nsLeft 77
		nsBottom 114
		nsRight 111
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You can see neither the top nor the bottom of the gigantic beanstalk you're clinging to.  The ropey green vines easily hold your weight, and the massive main stem winds gently upward.}
	)
)

(instance stalk3 of NewFeature
	(properties
		x 167
		y 22
		noun '/beanstalk'
		nsLeft 160
		nsBottom 45
		nsRight 175
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You can see neither the top nor the bottom of the gigantic beanstalk you're clinging to.  The ropey green vines easily hold your weight, and the massive main stem winds gently upward.}
	)
)

(instance cloud1 of NewFeature
	(properties
		x 160
		y 127
		noun '/cloud'
		nsTop 91
		nsBottom 164
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are clouds all around you.  You can see neither the land below you nor the top of the beanstalk above you.  In fact, there's little to see up here but clouds and the occasional bird.}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 244
		y 46
		noun '/cloud'
		nsTop 33
		nsLeft 169
		nsBottom 60
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are clouds all around you.  You can see neither the land below you nor the top of the beanstalk above you.  In fact, there's little to see up here but clouds and the occasional bird.}
	)
)

(instance cloud3 of NewFeature
	(properties
		x 35
		y 24
		noun '/cloud'
		nsTop 17
		nsBottom 32
		nsRight 70
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are clouds all around you.  You can see neither the land below you nor the top of the beanstalk above you.  In fact, there's little to see up here but clouds and the occasional bird.}
	)
)

(instance cloud4 of NewFeature
	(properties
		x 160
		y 6
		noun '/cloud'
		nsBottom 13
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are clouds all around you.  You can see neither the land below you nor the top of the beanstalk above you.  In fact, there's little to see up here but clouds and the occasional bird.}
	)
)

