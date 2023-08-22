;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
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
	rm17 0
)

(local
	[local0 3]
)

(instance rm17 of Rm
	(properties
		picture 17
		horizon 57
		north 32
		east 24
		south 16
		west 18
	)

	(method (init)
		(LoadMany rsVIEW 54 13 14)
		(LoadMany rsSOUND 17 14)
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
		(gEgo init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 309 (gEgo x:) 240) (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(if (not global130)
					(gEgo posn: 3 (proc0_17 188 (gEgo y:) 182))
				else
					(= global136 1000)
					(gEgo
						illegalBits: 128
						view: 13
						setStep: 3 1
						posn: 3 (proc0_17 186 (gEgo y:) 104)
						setCycle: Fwd
						setPri: 4
						cycleSpeed: 0
						moveSpeed: 0
					)
				)
			)
			(else
				(gEgo posn: 317 (proc0_17 189 (gEgo y:) (+ horizon 2)))
			)
		)
		(if (not global130)
			(proc0_1)
		)
		(cliff1 init:)
		(cliff2 init:)
		(cliff3 init:)
		(cliff4 init:)
		(lake1 init:)
		(lake2 init:)
		(lake3 init:)
		(lake4 init:)
		(lake5 init:)
		(rock1 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
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
			((== (gEgo view:) 13)
				(if (and global136 (not (-- global136)))
					(gCurRoom setScript: drowning)
				)
				(if (>= (gEgo y:) 159)
					(gEgo setPri: 1)
				else
					(gEgo setPri: -1)
				)
			)
			((and (& (gEgo onControl: 1) $0016) (not global130))
				(self setScript: offCliff)
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
			((Said 'swim/')
				(cond
					((== global130 6)
						(Print 17 0) ; "Unfortunately, drowning in the lake is occupying all of your attention."
					)
					(global130
						(Print 17 1) ; "You are already swimming."
					)
					(else
						(Print 17 2) ; "You have to be in the water to go swimming."
					)
				)
			)
			((Said 'dive')
				(if global130
					(Print 17 3) ; "There are strong currents under the calm surface of this lake. Diving here would be too dangerous."
				else
					(event claimed: 0)
				)
			)
			((Said 'fill/bucket')
				(cond
					((not global130)
						(Print 17 4) ; "That's a dangerous proposition from here."
					)
					((gEgo has: 8) ; Empty_Water_Bucket
						(if (IsFlag 9)
							(Print 17 5) ; "The bucket is already full of water."
						else
							(if (== global130 4)
								(Print 17 6) ; "With difficulty, you fill the bucket while swimming."
							else
								(Print 17 7) ; "You kneel down and fill the bucket with the cool water."
							)
							(UpdateWaterBucket 1)
						)
					)
					(else
						(Print 17 8) ; "You do not have a bucket to put the water in."
					)
				)
			)
			((Said 'drink,get,get/drink,water')
				(Print 17 9) ; "There is no safe place from which to get a drink of water."
			)
			((Said 'climb,climb,move,pull/boulder')
				(Print 17 10) ; "You can't do that."
			)
		)
	)
)

(instance offCliff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 0)
			(gEgo setStep: -1 (+ (gEgo yStep:) 4))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 17 loop: 1 init: play:) ; gameSound
				(gEgo
					view: 54
					illegalBits: 0
					setCycle: 0
					cel: 0
					ignoreActors:
					ignoreHorizon:
					setPri:
						(switch (gEgo onControl: 1)
							(4 2)
							(else 3)
						)
					setStep: 4 7
				)
				(switch (gEgo onControl: 1)
					(16
						(gEgo
							yStep: 1
							setLoop: 3
							setMotion: MoveTo (gEgo x:) 240 self
						)
					)
					(else
						(gEgo
							setLoop: 1
							setMotion:
								MoveTo
								(- (gEgo x:) 114)
								(+ (gEgo y:) 180)
								self
						)
					)
				)
				(if (gCast contains: gGoat)
					(proc0_15 gGoat gEgo)
					(gGoat setMotion: 0)
				)
			)
			(1
				((ScriptID 0 21) number: 14 loop: 1 play:) ; gameSound
				(= seconds 2)
			)
			(2
				(EgoDead {Your attempt at cliffdiving was a smashing failure.})
			)
		)
	)
)

(instance cliff1 of NewFeature
	(properties
		x 203
		y 51
		noun '/cliff'
		nsTop 39
		nsLeft 194
		nsBottom 63
		nsRight 213
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Treacherous cliffs surround a picturesque mountain lake.}
	)
)

(instance cliff2 of NewFeature
	(properties
		x 205
		y 76
		noun '/cliff'
		nsTop 63
		nsLeft 199
		nsBottom 89
		nsRight 212
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Treacherous cliffs surround a picturesque mountain lake.}
	)
)

(instance cliff3 of NewFeature
	(properties
		x 224
		y 84
		noun '/cliff'
		nsTop 70
		nsLeft 212
		nsBottom 99
		nsRight 236
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Treacherous cliffs surround a picturesque mountain lake.}
	)
)

(instance cliff4 of NewFeature
	(properties
		x 218
		y 136
		noun '/cliff'
		nsTop 122
		nsLeft 198
		nsBottom 151
		nsRight 239
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Treacherous cliffs surround a picturesque mountain lake.}
	)
)

(instance lake1 of NewFeature
	(properties
		x 156
		y 52
		noun '[<at,around][/room,lake,water,cliff]'
		nsTop 39
		nsLeft 118
		nsBottom 66
		nsRight 194
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The clear mountain lake is surrounded by steep cliffs.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 121
		y 74
		noun '[<at,around][/room,lake,water,cliff]'
		nsTop 65
		nsLeft 46
		nsBottom 83
		nsRight 197
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The clear mountain lake is surrounded by steep cliffs.}
	)
)

(instance lake3 of NewFeature
	(properties
		x 115
		y 121
		noun '[<at,around][/room,lake,water,cliff]'
		nsTop 83
		nsLeft 32
		nsBottom 159
		nsRight 198
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The clear mountain lake is surrounded by steep cliffs.}
	)
)

(instance lake4 of NewFeature
	(properties
		x 15
		y 135
		noun '[<at,around][/room,lake,water,cliff]'
		nsTop 95
		nsBottom 176
		nsRight 31
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The clear mountain lake is surrounded by steep cliffs.}
	)
)

(instance lake5 of NewFeature
	(properties
		x 94
		y 167
		noun '[<at,around][/room,lake,water,cliff]'
		nsTop 159
		nsLeft 31
		nsBottom 176
		nsRight 157
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The clear mountain lake is surrounded by steep cliffs.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 264
		y 32
		noun '/boulder'
		nsTop 20
		nsLeft 234
		nsBottom 45
		nsRight 295
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A large, jagged boulder sits at the top of the cliff.}
	)
)

(instance drowning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo
					setMotion: 0
					setLoop: 0
					view: 14
					cel: 5
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 5 setCycle: End self)
			)
			(2
				(gEgo cel: 5 setCycle: End self)
			)
			(3
				(gEgo hide:)
				(= seconds 4)
			)
			(4
				(if (not global136)
					(EgoDead
						{After swimming for a long time, your strength ebbs and your arms and legs grow weary.  As your life swims before your eyes, you decide to...}
					)
				else
					(EgoDead
						{You splash around for awhile, but unfortunately that won't keep your head above water.  As you go down for the third time, a sense of peace washes over you...}
					)
				)
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 50
		y 13
		noun '/ceder'
		nsTop -1
		nsBottom 28
		nsRight 101
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A spreading tree is silhouetted against the sun.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 230
		y 8
		noun '/ceder'
		nsTop -1
		nsLeft 179
		nsBottom 17
		nsRight 281
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A spreading tree is silhouetted against the sun.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 171
		y 20
		noun '/ceder'
		nsTop 14
		nsLeft 164
		nsBottom 26
		nsRight 179
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A spreading tree is silhouetted against the sun.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 224
		y 27
		noun '/ceder'
		nsTop 17
		nsLeft 214
		nsBottom 37
		nsRight 234
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A spreading tree is silhouetted against the sun.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 310
		y 14
		noun '/ceder'
		nsTop -1
		nsLeft 300
		nsBottom 30
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A spreading tree is silhouetted against the sun.}
	)
)

