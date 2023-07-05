;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm22 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(if (== local1 local2)
		(condor dispose:)
		((ScriptID 0 23) fade:) ; backSound
	)
)

(instance rm22 of Rm
	(properties
		picture 22
		horizon 57
		north 27
		east 21
		south 11
		west 23
	)

	(method (init)
		(LoadMany rsSOUND 10 55)
		(LoadMany rsVIEW 160 33)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
					(else 7)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 278 (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 214 (gEgo x:) 0) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 189 (gEgo y:) 67))
			)
			(east
				(gEgo
					posn:
						317
						(proc0_17
							162
							(proc0_18 132 (gEgo y:) 124)
							(+ 2 horizon)
						)
				)
			)
			(else
				(gEgo posn: 121 91 loop: 1)
			)
		)
		(gEgo init:)
		(proc0_1)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(rock4 init:)
		(rock5 init:)
		(rock6 init:)
		(rock7 init:)
		(rock8 init:)
		(rock9 init:)
		(rock10 init:)
		(rock11 init:)
		(rock12 init:)
		(rock13 init:)
		(rock14 init:)
		(if
			(and
				(!= global131 22)
				(not (IsFlag 100))
				(= local2 (Random 0 4))
				(gEgo has: 14) ; Magic_Mirror
				(gEgo has: 1) ; Chest
			)
			(Load rsVIEW (if (IsFlag 0) 23 else 16))
			(Load rsVIEW (if (IsFlag 0) 17 else 15))
			(Load rsVIEW 33)
			(condor illegalBits: 0 ignoreActors: 1 ignoreHorizon: 1 init:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(gCast contains: condor)
					(!= global123 1)
					(< (- (gEgo y:) (condor y:)) 80)
					(< (Abs (- (gEgo x:) (condor x:))) 5)
					(== (gEgo view:) (if (IsFlag 0) 17 else 15))
					(>= (gEgo cel:) 5)
				)
				((ScriptID 0 23) number: 55 loop: 1 play:) ; backSound
				(gCurRoom setScript: birdRide)
			)
			((and (== script birdRide) (gEgo edgeHit:))
				(gEgo dispose:)
				(gCurRoom newRoom: 80)
			)
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 2)
				(FadeBackSound)
				(self newRoom: 50)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(FadeBackSound)
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
			(
				(or
					(Said 'look,look/cave,doorway,doorway')
					(proc0_14 event 112 40 130 59)
					(proc0_14 event 106 60 115 86)
				)
				(if (gEgo inRect: 82 83 145 94)
					(Print 22 0) ; "The opening to the cave is dark and ominous."
				else
					(Print 22 1) ; "You vaguely see the outline of a cave entrance."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(Print 22 2) ; "A large cave is at the edge of this meadow."
					)
					((Said '/bird,bird,bird')
						(if (<= 0 (condor x:) 319)
							(Print 22 3) ; "This is a large condor. Its graceful flight appears effortless. At times, it dives so low you can practically touch it!"
						else
							(Print 22 4) ; "There is no bird here."
						)
					)
				)
			)
			((Said 'get,get,get,capture/bird,bird,bird')
				(if (<= 0 (condor x:) 319)
					(Print 22 5) ; "You could try getting it, if you could only reach it."
				else
					(Print 22 6) ; "The condor is out of your reach."
				)
			)
			((Said 'climb,climb/hill,boulder,boulder')
				(Print 22 7) ; "These rocks are a little too treacherous to climb."
			)
			((Said 'kill/bird,bird,bird')
				(if (<= 0 (condor x:) 319)
					(Print 22 8) ; "The bird is too high to kill. Besides, why would you want to kill such a fine, friendly bird?"
				else
					(Print 22 4) ; "There is no bird here."
				)
			)
			((Said 'talk,talk/bird,bird,bird')
				(if (<= 0 (condor x:) 319)
					(Print 22 9) ; "The condor doesn't speak, but it's wiser than you probably suspect."
				else
					(Print 22 4) ; "There is no bird here."
				)
			)
			((or (Said 'hello') (Said 'say/hello'))
				(cond
					((<= 0 (condor x:) 319)
						(Print 22 9) ; "The condor doesn't speak, but it's wiser than you probably suspect."
					)
					((IsFlag 2)
						(Print 22 10) ; "The goat begins to reply, but then remembers that goats can't talk!"
					)
					(else
						(Print 22 11) ; "As there's nobody here to speak to, the conversation quickly grinds to a halt."
					)
				)
			)
		)
	)
)

(instance condor of Actor
	(properties
		x -10
		y -40
		yStep 5
		view 160
		xStep 8
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(gEgo inRect: 88 108 187 144)
				(not script)
				(!= global131 22)
				(< local1 local2)
			)
			(if (== local1 0)
				(++ local1)
				(++ local2)
				((ScriptID 0 23) number: 10 loop: -1 play:) ; backSound
			)
			(self
				setScript:
					(if local0
						(switch (Random 0 1)
							(0
								(++ local1)
								swoopWest
							)
							(else fakeWest)
						)
					else
						(switch (Random 0 1)
							(0
								(++ local1)
								swoopEast
							)
							(else fakeEast)
						)
					)
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
			((Said 'look,look/bird,bird,bird')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (<= 0 (condor x:) 319)
					(Print 22 3) ; "This is a large condor. Its graceful flight appears effortless. At times, it dives so low you can practically touch it!"
				else
					(Print 22 4) ; "There is no bird here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swoopEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(condor
					posn: (- (gEgo x:) 140) -10
					setPri: 8
					loop: 0
					cel: 1
					setCycle: 0
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 72) self
				)
			)
			(1
				(condor
					setCycle: Fwd
					cycleSpeed: 2
					setMotion:
						MoveTo
						(+ (gEgo x:) 19)
						(- (gEgo y:) 74)
						self
				)
			)
			(2
				(condor
					cycleSpeed: 1
					setMotion:
						MoveTo
						(+ (gEgo x:) 115)
						(- (gEgo y:) 82)
						self
				)
				(User canControl: 1)
			)
			(3
				(condor setMotion: MoveTo 348 (- (gEgo y:) 137) self)
			)
			(4
				(= local0 1)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance swoopWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(condor
					posn: (+ (gEgo x:) 140) 6
					setPri: 8
					loop: 1
					cel: 1
					setCycle: 0
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 72) self
				)
			)
			(1
				(condor
					setCycle: Fwd
					cycleSpeed: 2
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(- (gEgo y:) 74)
						self
				)
			)
			(2
				(condor
					cycleSpeed: 1
					setMotion:
						MoveTo
						(- (gEgo x:) 115)
						(- (gEgo y:) 82)
						self
				)
				(User canControl: 1)
			)
			(3
				(condor setMotion: MoveTo -44 (- (gEgo y:) 137) self)
			)
			(4
				(= local0 0)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance fakeWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(condor
					posn: 302 -10
					setPri: 8
					loop: 0
					cel: 1
					setCycle: 0
					setMotion: MoveTo 177 39 self
				)
			)
			(1
				(condor setCycle: Fwd setMotion: MoveTo -40 -21 self)
			)
			(2
				(= local0 0)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance fakeEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(condor
					posn: 52 -10
					setPri: 8
					loop: 0
					cel: 1
					setCycle: 0
					setMotion: MoveTo 141 53 self
				)
			)
			(1
				(condor setCycle: Fwd setMotion: MoveTo 348 -10 self)
			)
			(2
				(= local0 1)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance birdRide of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(gEgo posn: (condor x:) (+ (condor y:) 60))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 100 3)
				(= global123 1)
				(HandsOff)
				(gEgo
					view: 33
					loop: (if local0 1 else 0)
					setCycle: Fwd
					setMotion: 0
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					setPri: 7
				)
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 271
		y 125
		noun '/ceder<little'
		nsTop 116
		nsLeft 242
		nsBottom 135
		nsRight 301
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This is one of the many small trees scattered around the lovely Daventry countryside.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 249
		y 148
		noun '/ceder<little'
		nsTop 143
		nsLeft 226
		nsBottom 154
		nsRight 273
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This is one of the many small trees scattered around the lovely Daventry countryside.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 37
		y 51
		noun '/ceder'
		nsTop 34
		nsLeft 23
		nsBottom 69
		nsRight 52
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees are somewhat sparse here at the foot of the rocky mountain.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 156
		y 14
		noun '/ceder'
		nsLeft 132
		nsBottom 30
		nsRight 180
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees are somewhat sparse here at the foot of the rocky mountain.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 308
		y 62
		noun '/ceder'
		nsLeft 297
		nsBottom 124
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees are somewhat sparse here at the foot of the rocky mountain.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 251
		y 9
		noun '/ceder'
		nsLeft 212
		nsBottom 20
		nsRight 296
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees are somewhat sparse here at the foot of the rocky mountain.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 266
		y 136
		noun '/ceder'
		nsTop 121
		nsLeft 224
		nsBottom 152
		nsRight 308
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees are somewhat sparse here at the foot of the rocky mountain.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 56
		y 19
		noun '/hill'
		nsTop -1
		nsBottom 40
		nsRight 112
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock2 of NewFeature
	(properties
		x 55
		y 50
		noun '/hill'
		nsTop 40
		nsBottom 60
		nsRight 111
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock3 of NewFeature
	(properties
		x 72
		y 73
		noun '/hill'
		nsTop 61
		nsLeft 40
		nsBottom 86
		nsRight 104
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock4 of NewFeature
	(properties
		x 125
		y 25
		noun '/hill'
		nsTop 12
		nsLeft 112
		nsBottom 39
		nsRight 138
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock5 of NewFeature
	(properties
		x 152
		y 82
		noun '/hill'
		nsTop 60
		nsLeft 115
		nsBottom 104
		nsRight 189
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock6 of NewFeature
	(properties
		x 162
		y 43
		noun '/hill'
		nsTop 28
		nsLeft 138
		nsBottom 59
		nsRight 187
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock7 of NewFeature
	(properties
		x 214
		y 66
		noun '/hill'
		nsTop 57
		nsLeft 188
		nsBottom 76
		nsRight 240
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock8 of NewFeature
	(properties
		x 196
		y 50
		noun '/hill'
		nsTop 44
		nsLeft 187
		nsBottom 57
		nsRight 206
		description {rocky hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This jagged rocky hill reveals the entrance to a cave.}
	)
)

(instance rock9 of NewFeature
	(properties
		x 114
		y 137
		noun '/boulder'
		nsTop 125
		nsLeft 78
		nsBottom 150
		nsRight 150
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many large rocks and boulders are strewn about the area.}
	)
)

(instance rock10 of NewFeature
	(properties
		x 95
		y 163
		noun '/boulder'
		nsTop 150
		nsLeft 51
		nsBottom 177
		nsRight 140
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many large rocks and boulders are strewn about the area.}
	)
)

(instance rock11 of NewFeature
	(properties
		x 72
		y 144
		noun '/boulder'
		nsTop 139
		nsLeft 66
		nsBottom 150
		nsRight 78
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many large rocks and boulders are strewn about the area.}
	)
)

(instance rock12 of NewFeature
	(properties
		x 270
		y 181
		noun '/boulder'
		nsTop 174
		nsLeft 223
		nsBottom 189
		nsRight 318
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many large rocks and boulders are strewn about the area.}
	)
)

(instance rock13 of NewFeature
	(properties
		x 298
		y 162
		noun '/boulder'
		nsTop 150
		nsLeft 277
		nsBottom 174
		nsRight 320
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many large rocks and boulders are strewn about the area.}
	)
)

(instance rock14 of NewFeature
	(properties
		x 264
		y 170
		noun '/boulder'
		nsTop 166
		nsLeft 252
		nsBottom 174
		nsRight 277
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many large rocks and boulders are strewn about the area.}
	)
)

