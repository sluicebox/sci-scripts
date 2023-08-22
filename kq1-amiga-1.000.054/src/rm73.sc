;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Extra)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm73 0
)

(instance rm73 of Rm
	(properties
		picture 73
		north 48
		south 74
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 7)
					(south 4)
				)
		)
		(LoadMany rsSOUND 17 70 31 95)
		(LoadMany rsVIEW 18 274)
		(super init:)
		(proc0_1)
		(switch gPrevRoomNum
			(south
				(gEgo
					posn:
						(cond
							((>= (gEgo x:) 267) 250)
							((<= (gEgo x:) 240) 157)
							(else 199)
						)
						188
					init:
				)
			)
			(else
				(gEgo
					view: 18
					setLoop: 0
					posn: 182 -42
					ignoreControl: -32768
					init:
				)
				(self setScript: fallScript)
			)
		)
		(if (>= global101 1)
			(d1 setPri: 14 init:)
			(d2 setPri: 15 init:)
			(d3 setPri: 14 init:)
			(d4 setPri: 13 init:)
			(d5 setPri: 14 init:)
			(d6 setPri: 13 init:)
		)
		(light1 init:)
		(sunbeam1 init:)
		(sunbeam2 init:)
		(sunbeam3 init:)
		(sunbeam4 init:)
		(sunbeam5 init:)
		(wall init:)
		(wall2 init:)
		(stalactite1 init:)
		(stalactite2 init:)
		(stalactite3 init:)
		(stalactite4 init:)
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
			((Said 'listen')
				(Print 73 0) ; "All you can hear is the quiet drip of water from the roof of the cave."
			)
			((Said 'smell,smell/cave')
				(Print 73 1) ; "This cave smells musty and damp."
			)
			((Said 'drink,get,get/drink,water')
				(Print 73 2) ; "You catch a few falling drops of water in your hand, barely enough to moisten your lips."
			)
			((Said 'light/torch,match')
				(Print 73 3) ; "You don't have that! But there is enough light in this cave for you to see clearly."
			)
			((or (Said '/wall[<cave]>') (and (Said '/cave>') (Said '/side>')))
				(cond
					((Said 'look,look')
						(Print 73 4) ; "The walls of this cave are damp and moldy."
					)
					((Said 'climb,climb,ascend')
						(Print 73 5) ; "The walls of this shadowy cave are too damp and steep for you to climb."
					)
				)
			)
			((Said 'get,get,turn,switch,light/light,flashlight')
				(Print 73 6) ; "Apparently you're getting a little lightheaded."
			)
			((Said '/boulder,mold>')
				(cond
					((Said 'eat,eat')
						(Print 73 7) ; "You're not that hungry."
					)
					((Said 'get')
						(Print 73 8) ; "You're not going to need that, Sir Graham."
					)
					((Said 'look,look')
						(Print 73 9) ; "When you look closely, you can see that the mold on the cave walls is glowing faintly."
					)
				)
			)
			((Said '/stalactite,stalactite>')
				(cond
					((Said 'get,bend')
						(Print 73 10) ; "These are of no use to you, Sir Graham."
					)
					((Said 'look,look')
						(Print 73 11) ; "These rock formations were slowly created over thousands of years."
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/drip')
						(Print 73 12) ; "Brackish water drips slowly from the stalactites on the ceiling."
					)
					((Said '/tunnel')
						(Print 73 13) ; "You can see the vague, shadowy outline of a tunnel leading to the south."
					)
					((or (Said '/hole') (Said '<up'))
						(Print 73 14) ; "You can see the hole that you fell through in the roof of the cave, far above you."
					)
					((or (Said '/floor') (Said '<down'))
						(Print 73 15) ; "The rocky floor of the cave is covered with rotting leaves and mold."
					)
					((Said '[<at,around][/room,cave]')
						(Print 73 16) ; "You are standing in a shadowy cavern. This cave is murky and damp, and smells of mold and rotted leaves."
					)
				)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(== (OnControl PRIORITY (event x:) (event y:)) -32768)
				)
				(Print 73 11) ; "These rock formations were slowly created over thousands of years."
			)
		)
	)
)

(instance d1 of Extra
	(properties
		x 128
		y 34
		description {drip}
		view 274
		loop 2
		cel 3
		cycleType 1
		minPause 30
		maxPause 40
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 73 12) ; "Brackish water drips slowly from the stalactites on the ceiling."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance d2 of Extra
	(properties
		x 227
		y 40
		description {drip}
		view 274
		loop 2
		cel 1
		cycleType 1
		minPause 40
		maxPause 50
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance d3 of Extra
	(properties
		x 254
		y 40
		description {drip}
		view 274
		loop 2
		cel 5
		cycleType 1
		minPause 50
		maxPause 60
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance d4 of Extra
	(properties
		x 210
		y 53
		description {drip}
		view 274
		loop 2
		cel 4
		cycleType 1
		minPause 36
		maxPause 40
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance d5 of Extra
	(properties
		x 289
		y 57
		description {drip}
		view 274
		loop 2
		cel 6
		cycleType 1
		minPause 40
		maxPause 48
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance d6 of Extra
	(properties
		x 266
		y 53
		description {drip}
		view 274
		loop 2
		cel 1
		cycleType 1
		minPause 20
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 17 loop: 1 init: play:) ; gameSound
				(gEgo yStep: 11 setMotion: MoveTo 182 133 self)
			)
			(1
				((ScriptID 0 21) number: 95 play:) ; gameSound
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
				(= seconds 5)
			)
			(3
				(gEgo setLoop: 2 setCel: 0 posn: 181 132)
				(= cycles 2)
			)
			(4
				((ScriptID 0 21) number: 70 play:) ; gameSound
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(5
				(gEgo observeControl: -32768)
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance light1 of NewFeature
	(properties
		x 181
		y 134
		noun '/circle,light,sunlight'
		nsTop 131
		nsLeft 152
		nsBottom 138
		nsRight 211
		description {light}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {You can see a circle of light on the floor of the cave, shining down from the hole above.}
	)
)

(instance sunbeam1 of NewFeature
	(properties
		x 182
		y 72
		noun '/beam,sunbeam'
		nsTop 14
		nsLeft 166
		nsBottom 131
		nsRight 198
		description {sunbeam}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A shaft of sunlight from above pierces the gloom of the cave.}
	)
)

(instance sunbeam2 of NewFeature
	(properties
		x 201
		y 93
		noun '/beam,sunbeam'
		nsTop 55
		nsLeft 197
		nsBottom 131
		nsRight 205
		description {sunbeam}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A shaft of sunlight from above pierces the gloom of the cave.}
	)
)

(instance sunbeam3 of NewFeature
	(properties
		x 161
		y 93
		noun '/beam,sunbeam'
		nsTop 55
		nsLeft 158
		nsBottom 131
		nsRight 165
		description {sunbeam}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A shaft of sunlight from above pierces the gloom of the cave.}
	)
)

(instance sunbeam4 of NewFeature
	(properties
		x 208
		y 117
		noun '/beam,sunbeam'
		nsTop 104
		nsLeft 205
		nsBottom 131
		nsRight 211
		description {sunbeam}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A shaft of sunlight from above pierces the gloom of the cave.}
	)
)

(instance sunbeam5 of NewFeature
	(properties
		x 154
		y 122
		noun '/beam,sunbeam'
		nsTop 113
		nsLeft 152
		nsBottom 131
		nsRight 157
		description {sunbeam}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A shaft of sunlight from above pierces the gloom of the cave.}
	)
)

(instance wall of NewFeature
	(properties
		x 265
		y 107
		noun '/wall'
		nsTop 62
		nsLeft 211
		nsBottom 153
		nsRight 320
		description {wall}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The walls of this cave are damp and moldy.}
	)
)

(instance wall2 of NewFeature
	(properties
		x 128
		y 86
		noun '/wall'
		nsTop 59
		nsLeft 105
		nsBottom 114
		nsRight 152
		description {wall2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The walls of this cave are damp and moldy.}
	)
)

(instance stalactite1 of NewFeature
	(properties
		x 131
		y 23
		noun '/stalactite'
		nsTop 16
		nsLeft 120
		nsBottom 31
		nsRight 143
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite2 of NewFeature
	(properties
		x 138
		y 42
		noun '/stalactite'
		nsTop 32
		nsLeft 135
		nsBottom 52
		nsRight 141
		description {stalactite2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite3 of NewFeature
	(properties
		x 254
		y 31
		noun '/stalactite'
		nsTop 22
		nsLeft 249
		nsBottom 41
		nsRight 259
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite4 of NewFeature
	(properties
		x 289
		y 40
		noun '/stalactite'
		nsTop 23
		nsLeft 284
		nsBottom 57
		nsRight 294
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

