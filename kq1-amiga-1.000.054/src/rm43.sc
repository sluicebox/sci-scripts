;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm43 0
)

(local
	local0
	[local1 6]
	[local7 5] = [174 212 170 148 26]
	[local12 5] = [162 130 134 110 150]
	[local17 5] = [2 3 3 3 0]
)

(instance rm43 of Rm
	(properties
		picture 43
		horizon 50
		north 6
		east 44
		south 38
		west 42
	)

	(method (init)
		(Load rsVIEW 243)
		(if (>= global101 1)
			(Load rsVIEW 302)
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
				(if (> (gEgo x:) 263)
					(gEgo posn: (+ 190 (- (gEgo x:) 264)) (+ horizon 2))
				else
					(gEgo posn: (/ (* (gEgo x:) 18) 25) (+ horizon 2))
				)
			)
			(south
				(gEgo y: 188)
			)
			(west
				(if (< (gEgo y:) 140)
					(gEgo posn: 3 (proc0_17 108 (gEgo y:) (+ horizon 2)))
				else
					(gEgo posn: 3 (proc0_17 188 (gEgo y:) 175))
				)
			)
			(east
				(gEgo
					posn: 317 (proc0_17 188 (proc0_18 78 (gEgo y:) 67) 61)
				)
			)
			(else
				(gEgo posn: 3 178)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		else
			(gEgo setCycle: Fwd)
		)
		(rock init:)
		(lake1 init:)
		(lake2 init:)
		(lake3 init:)
		(lake4 init:)
		(lake5 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(bush1 init:)
		(bush2 init:)
		(self setRegions: 612) ; water42Reg
		(for
			((= local0 (if (>= global101 1) 0 else 4)))
			(< local0 5)
			((++ local0))
			
			((= [local1 local0] (Clone Ripple))
				view: 243
				cycleSpeed: 1
				setPri: 0
				x: [local7 local0]
				y: [local12 local0]
				setLoop: [local17 local0]
				setCycle: Fwd
				ignoreActors: 1
				description: {ripple}
				init:
			)
		)
		(if (>= global101 1)
			(fish init:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and script (not global130))
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
			((and (== global130 4) (& (gEgo onControl: 1) $2000))
				(gEgo cycleSpeed: 1 moveSpeed: 1)
			)
			((and (== global130 4) (& (gEgo onControl: 1) $4000))
				(gEgo cycleSpeed: 2 moveSpeed: 2)
			)
			(
				(and
					(== global130 4)
					(not
						(or
							(& (gEgo onControl: 1) $2000)
							(& (gEgo onControl: 1) $4000)
						)
					)
				)
				(gEgo cycleSpeed: 0 moveSpeed: 0)
			)
		)
		(if (and script global130)
			(script doit:)
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
					(Said 'look,look/boulder')
					(proc0_14 event 232 131 263 148)
					(proc0_14 event 264 113 289 135)
				)
				(Print 43 0) ; "There are rocks and small boulders all along the lakeshore."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,lake,water,lake]')
						(Print 43 1) ; "You see a clear blue lake surrounded by a pretty meadow."
					)
					((Said '/clearing')
						(Print 43 2) ; "The pretty meadow surrounds a clear blue lake."
					)
					((Said '/brook')
						(Print 43 3) ; "The river, barely visible off to the west, empties into the lake."
					)
					((Said '/ceder')
						(Print 43 4) ; "A few trees sit near a clear blue lake."
					)
				)
			)
		)
	)
)

(instance fishJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fish
					posn: (Random 30 155) (Random 100 150)
					loop: (Random 0 1)
					setCycle: End self
				)
			)
			(1
				(fish stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fish of Prop
	(properties
		view 302
	)

	(method (init)
		(self cycleSpeed: (if (>= global101 1) 1 else 0) ignoreActors: stopUpd:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (< (Random 1 100) 3) (not (fish script:)) (not global130))
			(fish setScript: fishJump)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (fish script:)
					(Print 43 5) ; "This is a jumping fish. You'd jump, too, if you lived in such cold water!"
				else
					(Print 43 6) ; "At the moment, you'd only be able to see the fish from underwater!"
				)
			)
			(7
				(Print 43 7) ; "The fish would do you no good except to attract the attention of every cat in the kingdom!"
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
			((Said 'look,look/fish')
				(self doVerb: 1)
			)
			((Said 'get,get,capture/fish')
				(self doVerb: 7)
			)
		)
	)
)

(instance lake1 of NewFeature
	(properties
		x 74
		y 105
		noun '/lake,lake,water'
		nsTop 47
		nsBottom 163
		nsRight 148
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The clear blue lake is surrounded by a pretty meadow.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 169
		y 105
		noun '/lake,lake,water'
		nsTop 51
		nsLeft 148
		nsBottom 160
		nsRight 191
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The clear blue lake is surrounded by a pretty meadow.}
	)
)

(instance lake3 of NewFeature
	(properties
		x 202
		y 104
		noun '/lake,lake,water'
		nsTop 61
		nsLeft 191
		nsBottom 147
		nsRight 213
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The clear blue lake is surrounded by a pretty meadow.}
	)
)

(instance lake4 of NewFeature
	(properties
		x 221
		y 101
		noun '/lake,lake,water'
		nsTop 70
		nsLeft 212
		nsBottom 133
		nsRight 231
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The clear blue lake is surrounded by a pretty meadow.}
	)
)

(instance lake5 of NewFeature
	(properties
		x 241
		y 101
		noun '/lake,lake,water'
		nsTop 91
		nsLeft 231
		nsBottom 112
		nsRight 251
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The clear blue lake is surrounded by a pretty meadow.}
	)
)

(instance Ripple of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/lake,water')
				(Print 43 1) ; "You see a clear blue lake surrounded by a pretty meadow."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 43 1) ; "You see a clear blue lake surrounded by a pretty meadow."
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 281
		y 28
		noun '/ceder'
		nsLeft 256
		nsBottom 57
		nsRight 307
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Several pretty trees stand by the lakeside, offering shade and beauty to wandering adventurers.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 163
		y 27
		noun '/ceder'
		nsTop 12
		nsLeft 146
		nsBottom 43
		nsRight 180
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Several pretty trees stand by the lakeside, offering shade and beauty to wandering adventurers.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 161
		y 5
		noun '/ceder'
		nsTop -1
		nsLeft 84
		nsBottom 12
		nsRight 238
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Several pretty trees stand by the lakeside, offering shade and beauty to wandering adventurers.}
	)
)

(instance rock of NewFeature
	(properties
		x 19
		y 162
		noun '/boulder'
		nsTop 153
		nsBottom 172
		nsRight 38
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Rocks lie along the edge of the lake, adding to the quiet serenity of the area.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 297
		y 61
		noun '/bush'
		nsTop 46
		nsLeft 274
		nsBottom 76
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some pretty flowering bushes grow in a bunch near the lake's edge.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 276
		y 103
		noun '/bush'
		nsTop 91
		nsLeft 256
		nsBottom 115
		nsRight 296
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some pretty flowering bushes grow in a bunch near the lake's edge.}
	)
)

