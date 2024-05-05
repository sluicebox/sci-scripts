;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm14 0
)

(instance rm14 of Rm
	(properties
		picture 14
		horizon 65
		north 19
		east 15
		south 3
		west 13
	)

	(method (init)
		(LoadMany rsVIEW 19 18)
		(LoadMany rsSOUND 70 95 2)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(if (IsFlag 46)
			(ClearFlag 46)
			(gCurRoom setScript: skyDiver)
		else
			(if (!= ((ScriptID 0 23) number:) 98) ; backSound
				((ScriptID 0 23) number: 2 loop: -1 playBed:) ; backSound
			)
			(switch gPrevRoomNum
				(north
					(gEgo
						posn: (proc0_17 319 (gEgo x:) 159) (+ horizon 2)
					)
					(proc0_1)
				)
				(south
					(gEgo posn: (proc0_17 319 (gEgo x:) 151) 188)
					(proc0_1)
				)
				(west
					(gEgo posn: 3 (proc0_17 104 (gEgo y:) (+ horizon 2)))
					(proc0_1)
				)
				(east
					(gEgo x: 317)
					(proc0_1)
				)
				(else
					(gCurRoom setScript: downTree)
				)
			)
		)
		(gEgo init:)
		(farTree1 init:)
		(farTree2 init:)
		(farTree3 init:)
		(farTree init:)
		(tree5 init:)
		(tree4 init:)
		(tree3 init:)
		(tree2 init:)
		(tree1 init:)
		(tree init:)
		(rock init:)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
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
			((Said 'look,look>')
				(if (Said '[<at,around][/room,ceder]')
					(Print 14 0) ; "There is an enormous oak tree growing here, its branches reaching up to the sky."
				)
			)
			((Said 'climb,climb[/ceder,oak,branch]')
				(cond
					((IsFlag 1)
						(Print 14 1) ; "You can't do that when you're invisible."
					)
					((IsFlag 2)
						(Print 14 2) ; "The old goat is afraid of heights and refuses to climb the tree."
					)
					((gEgo inRect: 54 142 98 172)
						(Print 14 3) ; "Finding plenty of footholds in the coarse bark of the tree, you easily clamber up the trunk to the branches above."
						(if (gCurRoom script:)
							(Print 14 4) ; "You're too busy right now to climb a tree."
						else
							(gCurRoom setScript: climbTree)
						)
					)
					(else
						(Print 14 5) ; "You can't climb a tree from here!"
					)
				)
			)
		)
	)
)

(instance climbTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreHorizon:
					setMotion: MoveTo 88 162 self
				)
			)
			(1
				(gEgo
					view: 19
					setPri: 11
					setStep: 1 3
					loop: 0
					cel: 0
					setCycle: Fwd
					setPri: 12
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 100 133 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 149 57 self)
			)
			(3
				(gEgo setMotion: 0)
				(SetScore 101 2)
				(HandsOn)
				(gCurRoom newRoom: 63)
			)
		)
	)
)

(instance downTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 19
					setPri: 12
					setStep: 1 3
					loop: 0
					cel: 0
					setCycle: Fwd
					ignoreHorizon:
					illegalBits: 0
					cycleSpeed: 1
					moveSpeed: 1
					posn: 149 57
					setMotion: MoveTo 100 133 self
				)
			)
			(1
				(gEgo loop: 0 setCycle: Fwd setMotion: MoveTo 88 162 self)
			)
			(2
				(HandsOn)
				(proc0_1)
				(gEgo view: 0 loop: 3)
				(ClearFlag 1)
				(self dispose:)
			)
		)
	)
)

(instance skyDiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					ignoreHorizon: 1
					view: 18
					loop: 0
					cel: 0
					posn: 182 -40
					yStep: 14
					illegalBits: 0
					setCycle: 0
					setMotion: MoveTo 182 133 self
				)
			)
			(1
				((ScriptID 0 23) number: 2 loop: -1 playBed:) ; backSound
				((ScriptID 0 21) number: 95 loop: 1 play:) ; gameSound
				(gEgo
					setLoop: 1
					cycleSpeed: 1
					posn: 181 132
					setCycle: CT 2 1 self
				)
			)
			(2
				(ShakeScreen 6)
				(gEgo setCycle: End)
				(= seconds 3)
			)
			(3
				(gEgo setLoop: 2 setCel: 0 posn: 181 132)
				(= cycles 2)
			)
			(4
				((ScriptID 0 21) number: 70 loop: -1 play:) ; gameSound
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(5
				((ScriptID 0 21) stop:) ; gameSound
				(gEgo view: 0)
				(ClearFlag 1)
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tree of NewFeature
	(properties
		x 159
		y 19
		noun '/ceder,oak'
		nsTop -1
		nsBottom 40
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the largest oak tree you've ever seen.__Its trunk seems to be about ten feet around, and the thick, sturdy branches look like they could hold many times your weight.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 119
		y 50
		noun '/ceder,oak'
		nsTop 40
		nsLeft 79
		nsBottom 61
		nsRight 160
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the largest oak tree you've ever seen.__Its trunk seems to be about ten feet around, and the thick, sturdy branches look like they could hold many times your weight.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 110
		y 70
		noun '/ceder,oak'
		nsTop 61
		nsLeft 68
		nsBottom 79
		nsRight 153
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the largest oak tree you've ever seen.__Its trunk seems to be about ten feet around, and the thick, sturdy branches look like they could hold many times your weight.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 99
		y 86
		noun '/ceder,oak'
		nsTop 79
		nsLeft 59
		nsBottom 94
		nsRight 140
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the largest oak tree you've ever seen.__Its trunk seems to be about ten feet around, and the thick, sturdy branches look like they could hold many times your weight.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 80
		y 130
		noun '/ceder,oak'
		nsTop 95
		nsLeft 28
		nsBottom 145
		nsRight 133
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the largest oak tree you've ever seen.__Its trunk seems to be about ten feet around, and the thick, sturdy branches look like they could hold many times your weight.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 157
		y 154
		noun '/ceder,oak'
		nsTop 154
		nsLeft 117
		nsBottom 169
		nsRight 153
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the largest oak tree you've ever seen.__Its trunk seems to be about ten feet around, and the thick, sturdy branches look like they could hold many times your weight.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 14
		y 103
		noun '/boulder'
		nsTop 58
		nsBottom 149
		nsRight 28
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The roots of the colossal oak tree are entwined among the rocks.}
	)
)

(instance rock of NewFeature
	(properties
		x 43
		y 85
		noun '/boulder'
		nsTop 77
		nsLeft 28
		nsBottom 94
		nsRight 58
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The roots of the colossal oak tree are entwined among the rocks.}
	)
)

(instance farTree of NewFeature
	(properties
		x 259
		y 47
		noun '/ceder<birch'
		nsTop 41
		nsLeft 211
		nsBottom 54
		nsRight 308
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A small thicket of unimpressive white birch trees grows here.}
	)
)

(instance farTree1 of NewFeature
	(properties
		x 220
		y 69
		noun '/ceder<birch'
		nsTop 54
		nsLeft 215
		nsBottom 85
		nsRight 226
		description {farTree1}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A small thicket of unimpressive white birch trees grows here.}
	)
)

(instance farTree2 of NewFeature
	(properties
		x 261
		y 80
		noun '/ceder<birch'
		nsTop 54
		nsLeft 257
		nsBottom 107
		nsRight 266
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A small thicket of unimpressive white birch trees grows here.}
	)
)

(instance farTree3 of NewFeature
	(properties
		x 282
		y 85
		noun '/ceder<birch'
		nsTop 54
		nsLeft 277
		nsBottom 117
		nsRight 287
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A small thicket of unimpressive white birch trees grows here.}
	)
)

(instance rock2 of NewFeature
	(properties
		x 74
		y 158
		noun '/boulder'
		nsTop 149
		nsLeft 62
		nsBottom 167
		nsRight 87
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are plenty of rocks around the base of the enormous tree.}
	)
)

(instance rock3 of NewFeature
	(properties
		x 146
		y 151
		noun '/boulder'
		nsTop 148
		nsLeft 138
		nsBottom 155
		nsRight 154
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are plenty of rocks around the base of the enormous tree.}
	)
)

