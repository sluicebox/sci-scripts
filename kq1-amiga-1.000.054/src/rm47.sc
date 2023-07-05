;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
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
	rm47 0
)

(instance rm47 of Rm
	(properties
		picture 47
		east 48
		south 34
		west 46
		picAngle 50
	)

	(method (init)
		(LoadMany rsVIEW 247 242 1 370)
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
		(switch gPrevRoomNum
			(north
				(gEgo posn: 142 (+ horizon 2))
			)
			(south
				(if (< (gEgo x:) 230)
					(gEgo posn: (proc0_17 83 (- (gEgo x:) 100) 3) 187)
				else
					(gEgo posn: 283 187)
				)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) 79))
			)
			(east
				(gEgo posn: 315 (proc0_17 188 (gEgo y:) 100))
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (not (IsFlag 69))
			(mushroom init:)
		)
		(gAddToPics add: castle eachElementDo: #init doit:)
		(self setRegions: 608) ; riverReg
		(rock init: stopUpd:)
		(water0 init: stopUpd:)
		(water1 init: stopUpd:)
		(if (>= global101 1)
			(water0 setCycle: Fwd)
			(water1 setCycle: Fwd)
			(water2 init: setCycle: Fwd)
			(water3 init: setCycle: Fwd)
			(water4 init: setCycle: Fwd)
		)
		(cliff1 init:)
		(cliff2 init:)
		(cliff3 init:)
		(cliff4 init:)
		(bush1 init:)
		(bush2 init:)
		(river1 init:)
		(river2 init:)
		(river3 init:)
		(bush3 init:)
		(bush4 init:)
		(tree1 init:)
		(tree2 init:)
		(stump init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
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
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(cond
							((IsFlag 69)
								(Print 47 0) ; "This lovely meadow is split by a wild, raging river."
							)
							((<= (gEgo x:) 140)
								(Print 47 1) ; "There is a mushroom in the meadow on the other side of the raging river."
							)
							(else
								(Print 47 2) ; "There is a large mushroom in the meadow next to the river."
							)
						)
					)
					((or (Said '/grass') (Said '<down'))
						(if
							(and
								(not (IsFlag 69))
								(<= (gEgo distanceTo: mushroom) 30)
							)
							(Print 47 3) ; "There is a large mushroom growing in the ground close by."
						else
							(Print 47 4) ; "There is nothing of interest around you."
						)
					)
					((Said '<across[/brook,water,brook]')
						(if (> (gEgo x:) 140)
							(Print 47 5) ; "You see the familiar side of the raging river."
						else
							(Print 47 6) ; "The land across the river looks enchanting. You wonder how you can get there."
						)
					)
					((Said '/boulder')
						(Print 47 7) ; "It would be too dangerous to try and jump from boulder to boulder."
					)
					((Said '/rapid')
						(Print 47 8) ; "The swiftly-moving water looks dangerous."
					)
				)
			)
			((Said 'smell,smell/mushroom,aroma')
				(cond
					((IsFlag 69)
						(if (gEgo has: 19) ; Mushroom
							(Print 47 9) ; "You hold the mushroom up to your nose and inhale the fragrance. It smells just like a fresh-picked mushroom should."
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					((> (gEgo distanceTo: mushroom) 30)
						(Print 47 10) ; "You can just detect the aroma of fresh mushroom."
					)
					(else
						(Print 47 11) ; "Yes, there's a definite mushroom tang in the air."
					)
				)
			)
			((Said 'get,get,pick/mushroom')
				(cond
					((IsFlag 69)
						(Print 47 12) ; "You've already picked it."
					)
					((<= (gEgo x:) 140)
						(Print 47 13) ; "The mushroom is on the far side of the river."
					)
					((> (gEgo distanceTo: mushroom) 20)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 1)
						(Print 47 14) ; "You can't pick the mushroom while you're invisible."
					)
					(else
						(gCurRoom setScript: getMush)
					)
				)
			)
		)
	)
)

(instance castle of PicView
	(properties
		x 121
		y 58
		description {castle}
		longRangeDist 500
		shiftClick -32767
		view 370
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/castle')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 15) ; "Far in the distance, you can see the spires and turrets of King Edward's castle."
			)
		)
	)
)

(instance mushroom of View
	(properties
		x 200
		y 127
		description {mushroom}
		view 247
		loop 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/mushroom')
				(if (and (IsFlag 69) (gEgo has: 19)) ; Mushroom
					(event claimed: 0)
				else
					(self doVerb: 1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((IsFlag 69)
						(Print 47 16) ; "You don't have the mushroom anymore."
					)
					((<= (gEgo x:) 140)
						(Print 47 13) ; "The mushroom is on the far side of the river."
					)
					((> (gEgo distanceTo: mushroom) 30)
						(Print 47 17) ; "A large bulbous mushroom grows in the distance."
					)
					(else
						(Print 47 18) ; "This is a small, aromatic mushroom."
					)
				)
			)
		)
	)
)

(instance getMush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo mushroom)
				(= cycles 2)
			)
			(1
				(gEgo view: 1 setMotion: 0 setCycle: End self)
			)
			(2
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(SetScore 69 1)
				(gEgo get: 19) ; Mushroom
				(mushroom dispose:)
				(= cycles 4)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rock of View
	(properties
		x 159
		y 169
		view 242
		loop 6
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/boulder')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 19) ; "The rampaging river roils around the rough rocks."
			)
		)
	)
)

(instance water0 of Prop
	(properties
		x 162
		y 188
		description {rock in river}
		view 242
		loop 5
		priority 6
		signal 18448
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 20) ; "The water is swiftly flowing around the rock."
			)
		)
	)
)

(instance water1 of Prop
	(properties
		x 105
		y 109
		description {waterfall}
		view 247
		cel 1
		priority 6
		signal 16
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/waterfall')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 21) ; "The water cascades down a small waterfall here."
			)
		)
	)
)

(instance water2 of Prop
	(properties
		x 114
		y 79
		description {waterfall}
		view 247
		loop 1
		cel 2
		priority 6
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 21) ; "The water cascades down a small waterfall here."
			)
		)
	)
)

(instance water3 of Prop
	(properties
		x 116
		y 120
		description {waterfall}
		view 247
		loop 3
		cel 1
		priority 6
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 21) ; "The water cascades down a small waterfall here."
			)
		)
	)
)

(instance water4 of Prop
	(properties
		x 103
		y 128
		description {waterfall}
		view 247
		loop 4
		priority 6
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 47 21) ; "The water cascades down a small waterfall here."
			)
		)
	)
)

(instance cliff1 of NewFeature
	(properties
		x 191
		y 39
		noun '/cliff'
		nsTop 23
		nsLeft 164
		nsBottom 55
		nsRight 219
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There's an impressive cliff here, overlooking the castle and the small waterfall.}
	)
)

(instance cliff2 of NewFeature
	(properties
		x 234
		y 36
		noun '/cliff'
		nsTop 12
		nsLeft 217
		nsBottom 60
		nsRight 251
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There's an impressive cliff here, overlooking the castle and the small waterfall.}
	)
)

(instance cliff3 of NewFeature
	(properties
		x 264
		y 26
		noun '/cliff'
		nsTop 10
		nsLeft 251
		nsBottom 43
		nsRight 277
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There's an impressive cliff here, overlooking the castle and the small waterfall.}
	)
)

(instance cliff4 of NewFeature
	(properties
		x 155
		y 52
		noun '/cliff'
		nsTop 43
		nsLeft 146
		nsBottom 62
		nsRight 164
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There's an impressive cliff here, overlooking the castle and the small waterfall.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 14
		y 44
		noun '/bush,bury'
		nsTop 22
		nsBottom 67
		nsRight 28
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the many leafy bushes growing throughout the countryside.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 218
		y 84
		noun '/bush,bury'
		nsTop 58
		nsLeft 144
		nsBottom 110
		nsRight 292
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the many leafy bushes growing throughout the countryside.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 298
		y 62
		noun '/bush,bury'
		nsTop 27
		nsLeft 277
		nsBottom 97
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the many leafy bushes growing throughout the countryside.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 266
		y 51
		noun '/bush,bury'
		nsTop 45
		nsLeft 255
		nsBottom 58
		nsRight 277
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the many leafy bushes growing throughout the countryside.}
	)
)

(instance river1 of NewFeature
	(properties
		x 119
		y 137
		noun '/brook,water,brook'
		nsTop 121
		nsLeft 82
		nsBottom 154
		nsRight 156
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is a wild and perilous raging river, filled with jagged boulders and treacherous rapids.}
	)
)

(instance river2 of NewFeature
	(properties
		x 149
		y 171
		noun '/brook,water,brook'
		nsTop 154
		nsLeft 99
		nsBottom 189
		nsRight 199
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is a wild and perilous raging river, filled with jagged boulders and treacherous rapids.}
	)
)

(instance river3 of NewFeature
	(properties
		x 165
		y 147
		noun '/brook,water,brook'
		nsTop 140
		nsLeft 155
		nsBottom 154
		nsRight 175
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is a wild and perilous raging river, filled with jagged boulders and treacherous rapids.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 61
		y 14
		noun '/ceder'
		nsBottom 28
		nsRight 122
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {An old tree hangs over the river's rapids.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 33
		y 44
		noun '/ceder'
		nsTop 29
		nsLeft 21
		nsBottom 60
		nsRight 45
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {An old tree hangs over the river's rapids.}
	)
)

(instance stump of NewFeature
	(properties
		x 53
		y 76
		noun '/stump'
		nsTop 61
		nsLeft 26
		nsBottom 91
		nsRight 80
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This extremely old tree stump has nearly splintered completely away.}
	)
)

