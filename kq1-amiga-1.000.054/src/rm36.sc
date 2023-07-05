;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use System)

(public
	rm36 0
)

(procedure (localproc_0)
	(Print 36 14) ; "You'll have to move closer."
)

(instance rm36 of Rm
	(properties
		picture 36
		horizon 57
		north 45
		east 35
		south 29
		west 37
	)

	(method (init)
		(LoadMany rsVIEW 31 30)
		(Load rsSOUND 21)
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
				(gEgo posn: 144 (+ horizon 2) init:)
				(proc0_1)
			)
			(south
				(gEgo y: 188 init:)
				(proc0_1)
			)
			(west
				(gEgo
					posn: 3 (proc0_17 188 (proc0_18 173 (gEgo y:) 167) 95)
					init:
				)
				(proc0_1)
			)
			(east
				(gEgo
					posn: 317 (proc0_17 188 (proc0_18 130 (gEgo y:) 124) 75)
					init:
				)
				(proc0_1)
			)
			(else
				(self setScript: egoFromHole)
			)
		)
		(tree init:)
		(tree1 init:)
		(tree6 init:)
		(tree5 init:)
		(tree4 init:)
		(tree3 init:)
		(tree2 init:)
		(tree10 init:)
		(tree9 init:)
		(tree8 init:)
		(tree7 init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'reach/hole')
				(if (gEgo inRect: 142 125 175 131)
					(Print 36 0) ; "There's nothing to be gained by reaching into the hole."
				else
					(localproc_0)
				)
			)
			((Said 'climb,climb,enter,go,(crawl[<in,in,through])/hole')
				(if (gEgo inRect: 142 125 175 131)
					(Print 36 1) ; "You would need to be much smaller to fit through that hole."
				else
					(localproc_0)
				)
			)
			((Said 'get,get/glow')
				(if (gEgo inRect: 134 125 219 138)
					(Print 36 2) ; "You might just as well try to hold a moonbeam in your hand!"
				else
					(localproc_0)
				)
			)
			((Said 'get,get/boulder')
				(if (gEgo inRect: 134 125 219 138)
					(Print 36 3) ; "This rock is firmly stuck in the ground."
				else
					(localproc_0)
				)
			)
			((Said 'move,pull/boulder')
				(if (gEgo inRect: 134 125 219 138)
					(Print 36 4) ; "Although you are very strong and healthy, this rock is too much even for you."
				else
					(localproc_0)
				)
			)
			(
				(or
					(Said 'look,look<in/hole')
					(Said 'look,look/hole')
					(proc0_14 event 151 113 166 126)
				)
				(cond
					((gEgo inRect: 142 125 175 131)
						(Print 36 5) ; "The hole appears to go deep down through the rock, into the ground below. You can barely make out a faint greenish glow somewhere far inside."
					)
					((gEgo inRect: 134 125 219 138)
						(Print 36 6) ; "There seems to be a small hole at the base of one of the boulders."
					)
					(else
						(localproc_0)
					)
				)
			)
			(
				(or
					(Said 'look,look/boulder')
					(proc0_14 event 133 113 215 126)
					(proc0_14 event 111 100 245 113)
					(proc0_14 event 134 91 200 99)
					(proc0_14 event 156 85 193 90)
				)
				(Print 36 7) ; "An extremely large jumble of boulders sits in the center of this heavily wooded area. At the base of one, you see a small hole."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 36 8) ; "You notice a small hole at the base of one of the craggy boulders in the center of the clearing."
					)
					((Said '/glow[<green]')
						(if (gEgo inRect: 142 125 175 131)
							(Print 36 9) ; "It seems to have a green tinge to it, but it's so faint you can't tell for sure."
						else
							(Print 36 10) ; "What glow?"
						)
					)
					((Said '/boulder')
						(if (gEgo inRect: 134 125 219 138)
							(Print 36 11) ; "The ancient, mossy rock has seen many winters. There is a small hole at its base."
						else
							(Print 36 12) ; "From where you're standing, it appears to be nothing more than a large rock."
						)
					)
					(else
						(super handleEvent: event)
					)
				)
			)
		)
	)
)

(instance egoFromHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					posn: 166 119
					view: 31
					setMotion: MoveTo 157 137 self
				)
			)
			(1
				((ScriptID 0 21) number: 21 init: play:) ; gameSound
				(gEgo
					view: 30
					cycleSpeed: 1
					cel: 6
					setMotion: 0
					setCycle: Beg self
				)
				(SetScore 105 1)
			)
			(2
				(proc0_1)
				(gEgo loop: 2)
				(if
					(and
						(gEgo has: 14) ; Magic_Mirror
						(gEgo has: 1) ; Chest
						(gEgo has: 16) ; Magic_Shield
						(< gCurRoomNum 70)
						(!= gCurRoomNum 53)
					)
					(Print 36 13) ; "Congratulations! You now have all three of Daventry's lost treasures! Now don't waste any time; bring the treasures straight back to King Edward before it's too late."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tree10 of NewFeature
	(properties
		x 130
		y 74
		noun '/ceder'
		nsTop 58
		nsLeft 104
		nsBottom 90
		nsRight 156
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree9 of NewFeature
	(properties
		x 95
		y 83
		noun '/ceder'
		nsTop 78
		nsLeft 88
		nsBottom 89
		nsRight 103
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree8 of NewFeature
	(properties
		x 257
		y 83
		noun '/ceder'
		nsTop 68
		nsLeft 201
		nsBottom 98
		nsRight 313
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 237
		y 33
		noun '/ceder'
		nsTop -1
		nsLeft 156
		nsBottom 68
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 65
		y 32
		noun '/ceder'
		nsTop -1
		nsLeft 11
		nsBottom 65
		nsRight 119
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 32
		y 78
		noun '/ceder'
		nsTop 65
		nsLeft 4
		nsBottom 92
		nsRight 61
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 265
		y 112
		noun '/ceder'
		nsTop 98
		nsLeft 252
		nsBottom 127
		nsRight 278
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 36
		y 138
		noun '/ceder'
		nsTop 118
		nsLeft 10
		nsBottom 158
		nsRight 63
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 84
		y 151
		noun '/ceder'
		nsTop 145
		nsLeft 62
		nsBottom 158
		nsRight 107
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 28
		y 164
		noun '/ceder'
		nsTop 158
		nsLeft 20
		nsBottom 171
		nsRight 37
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

(instance tree of NewFeature
	(properties
		x 5
		y 134
		noun '/ceder'
		nsTop 130
		nsBottom 139
		nsRight 10
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of trees are growing in this part of the forest.}
	)
)

