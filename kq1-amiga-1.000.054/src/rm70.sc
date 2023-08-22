;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	rm70 0
)

(local
	local0
	[local1 12]
	[local13 11] = [81 205 219 118 135 185 179 95 193 159 133]
	[local24 11] = [46 83 117 108 110 43 34 146 151 48 136]
	[local35 11] = [0 0 0 0 0 0 1 2 2 2 3]
	[local46 11] = [0 2 3 4 5 6 0 0 1 2 0]
	[local57 11] = [1 4 8 8 7 1 0 10 11 1 9]
)

(instance rm70 of Rm
	(properties
		picture 70
		horizon 4
		north 71
	)

	(method (init)
		(LoadMany rsVIEW 271 8)
		(Load rsSOUND 6)
		(self south: global131)
		(self
			style:
				(switch gPrevRoomNum
					(north 42)
					(south 4)
				)
		)
		(super init:)
		((ScriptID 0 23) number: 6 loop: -1 playBed:) ; backSound
		(switch gPrevRoomNum
			(north
				(gEgo posn: 137 8)
			)
			(else
				(gEgo posn: 142 178)
			)
		)
		(self setRegions: 609) ; climbRg
		(SetFlag 0)
		(gEgo init:)
		(proc0_1)
		(gEgo looper: 0 setCycle: Walk view: 8 setStep: 2 2 setPri: 11)
		(for ((= local0 0)) (< local0 11) ((++ local0))
			(= [local1 local0] (Clone PicView))
			([local1 local0]
				view: 271
				x: [local13 local0]
				y: [local24 local0]
				loop: [local35 local0]
				cel: [local46 local0]
				priority: [local57 local0]
				description: {leaf}
			)
			(gAddToPics
				add: [local1 local0]
				eachElementDo: #signal 16384 102
				doit:
			)
		)
		(if (IsFlag 2)
			(Print 70 0) ; "You see the goat below you, wandering off to explore Daventry on his own."
			(ClearFlag 2)
		)
		(stalk1 init:)
		(stalk2 init:)
		(cloud1 init:)
		(cloud2 init:)
		(cloud3 init:)
		(cloud4 init:)
		(cloud5 init:)
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
				(Print 70 1) ; "The view of Daventry from up here is stunning. There are gently rolling hills and valleys as far as the eye can see. Off in the distance, clouds float far above the land."
			)
			((Said 'look,look[<down][/grass]')
				(if (IsFlag 80)
					(if (IsFlag 2)
						(Print 70 2) ; "The goat wasn't about to risk his life climbing that huge beanstalk! You see him wandering away."
					else
						(Print 70 3) ; "There is no goat anywhere in sight."
					)
				else
					(Print 70 4) ; "Nervously, you look down. You can see the beautiful Daventry countryside spread out beneath you. However, looking down makes you a little dizzy, so you turn your attention back to the task at hand."
				)
			)
		)
	)
)

(instance stalk1 of NewFeature
	(properties
		x 134
		y 94
		noun '/beanstalk'
		nsTop -1
		nsLeft 101
		nsBottom 189
		nsRight 167
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The beanstalk must be ten feet around!  It's incredibly tall...so tall that it vanishes in the clouds far, far above you.  There are plenty of footholds among the vines and offshoots of the beanstalk's stem.}
	)
)

(instance stalk2 of NewFeature
	(properties
		x 191
		y 90
		noun '/beanstalk'
		nsTop 43
		nsLeft 168
		nsBottom 137
		nsRight 214
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The beanstalk must be ten feet around!  It's incredibly tall...so tall that it vanishes in the clouds far, far above you.  There are plenty of footholds among the vines and offshoots of the beanstalk's stem.}
	)
)

(instance cloud1 of NewFeature
	(properties
		x 45
		y 104
		noun '/cloud'
		nsTop 95
		nsBottom 114
		nsRight 91
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In the distance, and far above you, you can see heavy, dense clouds in streaks across the sky.  You think they're cumulus clouds, but it's been a long time since you went to Daventry High School.}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 120
		y 75
		noun '/cloud'
		nsTop 66
		nsBottom 85
		nsRight 241
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In the distance, and far above you, you can see heavy, dense clouds in streaks across the sky.  You think they're cumulus clouds, but it's been a long time since you went to Daventry High School.}
	)
)

(instance cloud3 of NewFeature
	(properties
		x 95
		y 55
		noun '/cloud'
		nsTop 44
		nsLeft 38
		nsBottom 66
		nsRight 153
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In the distance, and far above you, you can see heavy, dense clouds in streaks across the sky.  You think they're cumulus clouds, but it's been a long time since you went to Daventry High School.}
	)
)

(instance cloud4 of NewFeature
	(properties
		x 259
		y 69
		noun '/cloud'
		nsTop 67
		nsLeft 225
		nsBottom 71
		nsRight 294
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {In the distance, and far above you, you can see heavy, dense clouds in streaks across the sky.  You think they're cumulus clouds, but it's been a long time since you went to Daventry High School.}
	)
)

(instance cloud5 of NewFeature
	(properties
		x 288
		y 91
		noun '/cloud'
		nsTop 87
		nsLeft 256
		nsBottom 96
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In the distance, and far above you, you can see heavy, dense clouds in streaks across the sky.  You think they're cumulus clouds, but it's been a long time since you went to Daventry High School.}
	)
)

