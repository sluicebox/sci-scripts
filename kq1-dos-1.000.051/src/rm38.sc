;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm38 0
)

(local
	local0
	local1
	local2
	[local3 8] = [0 11 22 31 40 53 62 73]
	[local11 84] = [5 20 125 34 123 50 120 68 119 78 118 5 66 127 79 125 90 121 103 120 113 120 4 102 101 116 99 128 101 139 99 4 159 97 171 99 182 95 193 99 6 207 100 220 99 233 99 245 100 257 101 268 103 4 197 107 187 108 177 111 167 114 5 167 126 180 123 191 129 203 126 210 132 5 231 130 240 133 253 136 266 134 282 133]
)

(instance rm38 of Rm
	(properties
		picture 38
		north 43
		east 37
		south 27
		west 39
	)

	(method (init)
		(if (>= global101 1)
			(Load rsVIEW 304)
		)
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
				(gEgo
					posn: (proc0_17 261 (proc0_18 149 (gEgo x:) 80) 35) 59
				)
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) 59))
			)
			(east
				(gEgo posn: 317 (proc0_17 188 (gEgo y:) 59))
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (>= global101 1)
			(butterfly posn: 259 94 init:)
		)
		(flowers init:)
		(flowers1 init:)
		(flowers2 init:)
		(flowers3 init:)
		(flowers4 init:)
		(flowers5 init:)
		(tree init:)
		(bush init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(& (gEgo onControl: 1) $0200)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setScript: climbHill)
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
			(
				(and
					(& (gEgo onControl: 1) $0002)
					(!= (gEgo priority:) 1)
					(!= (gEgo script:) climbHill)
					(not (IsFlag 48))
				)
				(gEgo setPri: 1)
			)
			(
				(and
					(not (& (gEgo onControl: 1) $0002))
					(== (gEgo priority:) 1)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setPri: -1)
			)
			(
				(and
					(& (gGoat onControl: 1) $0002)
					(!= (gGoat priority:) 1)
				)
				(gGoat setPri: 1)
			)
			(
				(and
					(not (& (gGoat onControl: 1) $0002))
					(== (gGoat priority:) 1)
				)
				(gGoat setPri: -1)
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
			((or (Said 'look,look<down') (Said 'look,look/grass'))
				(Print 38 0) ; "Numerous flowers are growing in the fertile soil."
				(if (== global131 gCurRoomNum)
					(Print 38 1) ; "There is a huge stalk growing here!"
				)
			)
			((Said 'smell,smell/blossom')
				(if (gEgo inRect: 60 80 260 120)
					(Print 38 2) ; "The flowers' fragrance is enticing."
				else
					(Print 38 3) ; "You will have to move closer to do that."
				)
			)
			((Said 'get,get,pick/blossom')
				(Print 38 4) ; "It would be a shame to pick the lovely wildflowers."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(if (!= gCurRoomNum global131)
							(Print 38 5) ; "Lovely wildflowers grow profusely in this beautiful green meadow."
						else
							(Print 38 6) ; "A mighty beanstalk has sprouted from the magic beans you planted! Around the beanstalk, several varieties of wildflowers are growing."
						)
					)
					((Said '/blossom')
						(Print 38 7) ; "The wildflowers are very beautiful here."
					)
				)
			)
			((Said 'get,get,capture,chase/butterfly')
				(Print 38 8) ; "Catching the butterfly will not get you any closer to your goal. And it might hurt the butterfly."
			)
		)
	)
)

(instance butterfly of Actor
	(properties
		view 304
	)

	(method (init)
		(self
			ignoreControl:
			ignoreHorizon:
			ignoreActors:
			setCycle: Walk
			setAvoider: Avoid
			illegalBits: 0
		)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (< (Random 1 100) 25)
			(butterfly posn: (+ x (- 3 (Random 0 6))) (+ y (- 2 (Random 0 4))))
		)
		(if (== (butterfly script:) 0)
			(butterfly setScript: moveButterfly)
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
			((Said 'look,look/butterfly')
				(self doVerb: 1 event)
			)
			((Said 'talk,talk/butterfly')
				(Print 38 9) ; "The butterfly doesn't talk."
			)
			((Said 'eat,eat/butterfly')
				(Print 38 10) ; "Apparently the hot Daventry sun is getting to you."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 38 11) ; "This is a charming little yellow butterfly."
			)
		)
	)
)

(instance moveButterfly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (Random 1 100) 10)
					(repeat
						(if (!= (= local2 (Random 0 7)) local0)
							(= local0 local2)
							(break)
						)
					)
				)
				(= local1 (Random 1 [local11 [local3 local0]]))
				(butterfly
					setMotion:
						MoveTo
						[local11 (+ [local3 local0] (- (* local1 2) 1))]
						[local11 (+ [local3 local0] (* local1 2))]
						self
				)
			)
			(1
				(butterfly setCycle: Fwd)
				(= cycles (Random 5 20))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance climbHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setPri: 0
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) 55 self
				)
			)
			(1
				(proc0_1)
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom north:))
				(self dispose:)
			)
		)
	)
)

(instance flowers of NewFeature
	(properties
		x 71
		y 122
		noun '/blossom'
		nsTop 120
		nsLeft 10
		nsBottom 124
		nsRight 133
		description {flowers}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {What a pretty bed of wildflowers.}
	)
)

(instance flowers1 of NewFeature
	(properties
		x 82
		y 117
		noun '/blossom'
		nsTop 115
		nsLeft 37
		nsBottom 120
		nsRight 127
		description {flowers}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {What a pretty bed of wildflowers.}
	)
)

(instance flowers2 of NewFeature
	(properties
		x 61
		y 127
		noun '/blossom'
		nsTop 124
		nsLeft 30
		nsBottom 130
		nsRight 93
		description {flowers}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {What a pretty bed of wildflowers.}
	)
)

(instance tree of NewFeature
	(properties
		x 115
		y 21
		noun '/ceder'
		nsTop -1
		nsLeft 85
		nsBottom 43
		nsRight 145
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {An ordinary tree stands watch at the top of the hill.}
	)
)

(instance flowers3 of NewFeature
	(properties
		x 179
		y 100
		noun '/blossom'
		nsTop 94
		nsLeft 86
		nsBottom 106
		nsRight 272
		description {flowers}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {What a pretty bed of wildflowers.}
	)
)

(instance flowers4 of NewFeature
	(properties
		x 179
		y 120
		noun '/blossom'
		nsTop 106
		nsLeft 148
		nsBottom 135
		nsRight 211
		description {flowers}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {What a pretty bed of wildflowers.}
	)
)

(instance flowers5 of NewFeature
	(properties
		x 256
		y 130
		noun '/blossom'
		nsTop 123
		nsLeft 211
		nsBottom 137
		nsRight 301
		description {flowers}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {What a pretty bed of wildflowers.}
	)
)

(instance bush of NewFeature
	(properties
		x 104
		y 51
		noun '/bush'
		nsTop 44
		nsLeft 60
		nsBottom 59
		nsRight 149
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {There's a bit of undergrowth scattered around the base of the tree.}
	)
)

