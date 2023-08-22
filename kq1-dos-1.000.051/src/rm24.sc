;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm24 0
)

(local
	local0
	local1
	local2
	[local3 5] = [0 9 20 31 40]
	[local8 51] = [4 88 149 101 152 114 144 128 145 5 207 147 194 146 180 145 166 145 149 144 5 180 165 167 165 152 162 141 158 128 157 4 34 164 47 162 61 158 70 155 5 8 147 25 144 40 140 58 143 71 144]
)

(instance rm24 of Rm
	(properties
		picture 24
		horizon 57
		north 25
		east 23
		south 9
		west 17
	)

	(method (init)
		(if (not (IsFlag 70))
			(Load rsVIEW 1)
		)
		(Load rsVIEW 224)
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
				(gEgo posn: (proc0_18 263 (gEgo x:) 48) (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 189 (gEgo y:) (+ horizon 2)))
			)
			(east
				(gEgo posn: 317 (proc0_17 189 (gEgo y:) (+ horizon 2)))
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (not (IsFlag 70))
			(clover init: setScript: flashClover)
		)
		(gAddToPics
			add: cloverPatch ((Clone cloverPatch) cel: 1 x: 25 y: 143)
			eachElementDo: #init
			doit:
		)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(clover2 init:)
		(clover1 init:)
		(clover0 init:)
		(clover3 init:)
		(bush init:)
		(tree5 init:)
		(if (and (IsFlag 109) (== global131 gCurRoomNum))
			(stalkIn24 init:)
			(stalk2In24 init:)
			(gFeatures delete: tree3)
		)
		(if (>= global101 1)
			(butterfly posn: 35 142 init:)
		)
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
			((super handleEvent: event))
			((Said 'bury/bean')
				(if (and (not (IsFlag 109)) (gEgo has: 20)) ; Beans
					(stalkIn24 init:)
					(stalk2In24 init:)
					(gFeatures delete: tree3)
					(event claimed: 0)
				else
					(event claimed: 0)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(if (== global131 gCurRoomNum)
							(Print 24 0) ; "There is a huge stalk growing here!"
						else
							(Print 24 1) ; "You see a fragrant patch of clover growing in this lush meadow."
						)
					)
					((or (Said '<down') (Said '/grass'))
						(cond
							(
								(and
									(< (gEgo distanceTo: clover) 30)
									(not (gEgo has: 6)) ; Four-leaf_Clover
								)
								(Print 24 2) ; "Upon close examination, you see a four-leaf clover in the clover patch."
								(if (== global131 gCurRoomNum)
									(Print 24 0) ; "There is a huge stalk growing here!"
								)
							)
							((< (gEgo distanceTo: cloverPatch) 20)
								(Print 24 3) ; "You see a clover patch."
								(if (== global131 gCurRoomNum)
									(Print 24 0) ; "There is a huge stalk growing here!"
								)
							)
							((== global131 gCurRoomNum)
								(Print 24 0) ; "There is a huge stalk growing here!"
							)
							(else
								(Print 24 4) ; "A patch of clover catches your attention."
							)
						)
					)
				)
			)
			((Said 'get,get,pick/blossom,blossom')
				(Print 24 5) ; "You won't need to pick any of those, but they're very pretty to look at."
			)
			(
				(or
					(Said 'get,get,pick/clover[<leaf<4,unusual]')
					(Said 'get,get,pick/clover[<fourleaf,unusual]')
				)
				(cond
					((IsFlag 70)
						(Print 24 6) ; "You've already picked the only four-leaf clover in the patch."
					)
					((> (gEgo distanceTo: clover) 20)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 1)
						(Print 24 7) ; "You can't pick any clover while you're invisible."
					)
					(else
						(gCurRoom setScript: getClover)
					)
				)
			)
			(
				(or
					(Said 'get,get,pick/clover[<leaf<3]')
					(Said 'get,get,pick/clover[<threeleaf]')
				)
				(cond
					((IsFlag 70)
						(Print 24 8) ; "You've already picked the best clover in the patch."
					)
					((> (gEgo distanceTo: clover) 20)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 1)
						(Print 24 7) ; "You can't pick any clover while you're invisible."
					)
					(else
						(Print 24 9) ; "The three-leaf clovers are neither interesting nor helpful to you."
					)
				)
			)
			((Said 'climb,climb/ceder')
				(Print 24 10) ; "You can't climb this tree."
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
			((Said 'get,get,capture,chase/butterfly')
				(Print 24 11) ; "Catching the butterfly will not get you any closer to your goal. And it might hurt the butterfly."
			)
			((Said 'eat,eat/butterfly')
				(Print 24 12) ; "Apparently the hot Daventry sun is getting to you."
			)
			((Said 'talk,talk/butterfly')
				(Print 24 13) ; "The butterfly doesn't talk."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 24 14) ; "This is a charming little yellow butterfly."
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
						(if (!= (= local2 (Random 0 4)) local0)
							(= local0 local2)
							(break)
						)
					)
				)
				(= local1 (Random 1 [local8 [local3 local0]]))
				(butterfly
					setMotion:
						MoveTo
						[local8 (+ [local3 local0] (- (* local1 2) 1))]
						[local8 (+ [local3 local0] (* local1 2))]
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

(instance clover of Prop
	(properties
		x 42
		y 137
		view 224
		loop 1
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if
			(or
				(Said 'look,look/garden[<clover]')
				(Said 'look,look/clover[<unusual]')
				(MousedOn self event 3)
			)
			(if (< (gEgo distanceTo: clover) 50)
				(Print 24 15) ; "An unusual clover glistens in the middle of the patch."
			else
				(Print 24 16) ; "You notice a patch of clover just a few short steps away."
			)
			(event claimed: 1)
		)
	)
)

(instance cloverPatch of RPicView
	(properties
		x 49
		y 147
		description {clover patch}
		view 224
		signal 16384
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (MousedOn self event 3)
			(Print 24 17) ; "A jumble of clover grows in this patch of the forest."
			(event claimed: 1)
		)
	)
)

(instance flashClover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 50 400))
			)
			(1
				(clover setCycle: End self)
			)
			(2
				(clover setCycle: Beg self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance getClover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo clover)
				(= cycles 2)
			)
			(1
				(gEgo view: 1 setMotion: 0 setCycle: End self)
			)
			(2
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(gEgo get: 6) ; Four-leaf_Clover
				(clover setScript: 0 startUpd: dispose:)
				(SetScore 70 2)
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

(instance tree1 of NewFeature
	(properties
		x 192
		y 34
		noun '/ceder'
		nsTop -1
		nsLeft 135
		nsBottom 69
		nsRight 250
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Lovely fruit trees have blossomed early this year.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 163
		y 81
		noun '/ceder'
		nsTop 70
		nsLeft 157
		nsBottom 93
		nsRight 169
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Lovely fruit trees have blossomed early this year.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 207
		y 88
		noun '/ceder'
		nsTop 70
		nsLeft 200
		nsBottom 107
		nsRight 214
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Lovely fruit trees have blossomed early this year.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 124
		y 41
		noun '/ceder'
		nsTop 21
		nsLeft 115
		nsBottom 62
		nsRight 134
		description {three-leaf clover}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Lovely fruit trees have blossomed early this year.}
	)
)

(instance clover0 of NewFeature
	(properties
		x 50
		y 145
		noun '/garden[/clover]'
		nsTop 124
		nsBottom 166
		nsRight 100
		description {three-leaf clover}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A jumble of clover grows in this patch of the forest.}
	)
)

(instance clover1 of NewFeature
	(properties
		x 144
		y 160
		noun '/garden[/clover]'
		nsTop 152
		nsLeft 100
		nsBottom 169
		nsRight 188
		description {three-leaf clover}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The clover patch is thick with small three-leaf clovers.}
	)
)

(instance clover2 of NewFeature
	(properties
		x 160
		y 144
		noun '/garden[/clover]'
		nsTop 136
		nsLeft 100
		nsBottom 153
		nsRight 221
		description {three-leaf clover}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The clover patch is thick with small three-leaf clovers.}
	)
)

(instance clover3 of NewFeature
	(properties
		x 114
		y 132
		noun '/garden[/clover]'
		nsTop 129
		nsLeft 100
		nsBottom 135
		nsRight 128
		description {three-leaf clover}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The clover patch is thick with small three-leaf clovers.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 107
		y 18
		noun '/ceder'
		nsTop -1
		nsLeft 85
		nsBottom 38
		nsRight 129
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Graceful trees grow in profusion all throughout Daventry.}
	)
)

(instance bush of NewFeature
	(properties
		x 86
		y 48
		noun '/bush'
		nsTop 39
		nsLeft 56
		nsBottom 58
		nsRight 117
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A small ordinary bush flourishes in the shade of the trees.}
	)
)

(instance stalkIn24 of NewFeature
	(properties
		x 192
		y 34
		nsTop -1
		nsLeft 120
		nsBottom 64
		nsRight 177
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This mighty beanstalk stretches up so high, it vanishes into the clouds above.}
	)

	(method (init)
		(gFeatures addToFront: self)
	)
)

(instance stalk2In24 of NewFeature
	(properties
		x 192
		y 34
		nsTop 65
		nsLeft 122
		nsBottom 144
		nsRight 196
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This mighty beanstalk stretches up so high, it vanishes into the clouds above.}
	)

	(method (init)
		(gFeatures addToFront: self)
	)
)

