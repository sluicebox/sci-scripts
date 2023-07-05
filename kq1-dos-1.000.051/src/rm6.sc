;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Game)

(public
	rm6 0
)

(instance rm6 of Rm
	(properties
		picture 6
		horizon 68
		north 11
		east 5
		south 43
		west 7
	)

	(method (init)
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
					x:
						(if (> (gEgo x:) 181)
							(proc0_17 300 (gEgo x:) 247)
						else
							(proc0_17 122 (gEgo x:) 10)
						)
					y: (+ horizon 2)
				)
			)
			(south
				(if (> (gEgo x:) 189)
					(gEgo
						posn:
							(proc0_17 318 (+ 264 (- (gEgo x:) 190)) 264)
							188
					)
				else
					(gEgo
						posn: (proc0_17 263 (/ (* (gEgo x:) 25) 18) 5) 188
					)
				)
			)
			(west
				(gEgo
					posn: 5 (proc0_17 147 (proc0_18 102 (gEgo y:) 91) 70)
				)
			)
			(east
				(gEgo
					posn: 317 (proc0_17 187 (proc0_18 109 (gEgo y:) 100) 70)
				)
			)
			(else
				(gEgo posn: 315 142)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		)
		(large_tree init:)
		(large_tree1 init:)
		(large_tree2 init:)
		(large_tree3 init:)
		(large_tree4 init:)
		(large_tree5 init:)
		(tree init:)
		(tree1 init:)
		(tree2 init:)
		(farBush1 init:)
		(farBush init:)
		(lake init:)
		(rock init:)
		(self setRegions: 603) ; waterReg
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'find/bag')
				(cond
					((gEgo has: 11) ; Pouch
						(Print 6 0) ; "You already have the pouch."
					)
					((IsFlag 60)
						(Print 6 1) ; "You found it already."
					)
					((not (IsFlag 61))
						(Print 6 2) ; "Haven't you found it yet?"
					)
				)
			)
			((Said 'look,look<in/stump')
				(if (gEgo inRect: 30 143 100 175)
					(if (not (IsFlag 61))
						(Print 6 3) ; "Inside the rotting stump you notice a small leather pouch."
						(SetScore 60 1)
					else
						(Print 6 4) ; "Inside the decaying tree stump, you see nothing interesting."
					)
				else
					(Print 6 5) ; "Why don't you move closer to try that?"
				)
			)
			((or (Said 'look,look<in/branch,hole') (Said 'look,look/hole'))
				(if (gEgo inRect: 154 110 172 125)
					(Print 6 6) ; "You peer into the darkness inside the log, but there's nothing at all inside."
				else
					(Print 6 7) ; "You're not close enough to see into the log."
				)
			)
			(
				(or
					(Said 'look,look/stump')
					(proc0_14 event 38 124 89 139)
					(proc0_14 event 7 139 92 160)
				)
				(if (gEgo inRect: 20 129 125 189)
					(Print 6 8) ; "From here you can see the stump is very old and rotting away."
				else
					(Print 6 9) ; "You can only vaguely see the stump from this distance."
				)
			)
			(
				(or
					(Said 'look,look/branch')
					(proc0_14 event 182 94 193 101)
					(proc0_14 event 89 89 107 101)
					(proc0_14 event 76 102 198 119)
				)
				(if (gEgo inRect: 70 105 215 125)
					(Print 6 10) ; "Next to you is an old fallen tree trunk. It's crumbling and rotted, and holds no interest for you... unless you have a fascination with termites!"
				else
					(Print 6 11) ; "You can't see much of the log from over here."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,ceder]')
						(Print 6 12) ; "You're in a quiet part of the forest. There's an old rotted stump here."
					)
					((Said '/ant')
						(Print 6 13) ; "You can't see the termites unless you split open the log. But that would be a waste of time."
					)
				)
			)
			((Said 'eat,eat/ant')
				(Print 6 14) ; "You're not that hungry. You hope that you NEVER become that hungry!"
			)
			((Said 'get,get,get/ant')
				(Print 6 15) ; "They're obviously more afraid of you than you are of them. Leave them alone."
			)
			((Said 'get,get/branch')
				(Print 6 16) ; "There is no reason to take this old log with you."
			)
			((Said 'get,get/(bag[<leather]),diamond')
				(cond
					((and (gEgo has: 11) (IsFlag 62)) ; Pouch
						(Print 6 17) ; "You are already carrying them in your leather pouch."
					)
					((gEgo has: 11) ; Pouch
						(Print 6 18) ; "You already have the leather pouch."
					)
					((IsFlag 61)
						(Print 6 19) ; "There's no pouch here."
					)
					((not (IsFlag 60))
						(Print 6 20) ; "You have to find it first."
					)
					((gEgo inRect: 20 129 125 189)
						((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
						(Print 6 21) ; "As you lift the pouch from the stump, you feel its contents shifting inside."
						(gEgo get: 11) ; Pouch
						(SetScore 61 3)
					)
					(else
						(Print 6 22) ; "You should try getting closer."
					)
				)
			)
		)
	)
)

(instance tree of NewFeature
	(properties
		x 24
		y 66
		noun '/ceder'
		nsTop 36
		nsLeft 12
		nsBottom 96
		nsRight 37
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A totally typical example of the trees in this forest.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 64
		y 60
		noun '/ceder'
		nsTop 36
		nsLeft 49
		nsBottom 84
		nsRight 80
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A totally typical example of the trees in this forest.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 72
		y 18
		noun '/ceder'
		nsTop -1
		nsBottom 37
		nsRight 144
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A totally typical example of the trees in this forest.}
	)
)

(instance farBush of NewFeature
	(properties
		x 157
		y 55
		noun '/bush'
		nsTop 44
		nsLeft 130
		nsBottom 66
		nsRight 185
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {You've found a bush, but there isn't a quail in the game.}
	)
)

(instance farBush1 of NewFeature
	(properties
		x 202
		y 56
		noun '/bush'
		nsTop 49
		nsLeft 185
		nsBottom 64
		nsRight 220
		description {farBush1}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {You've found a bush, but there isn't a quail in the game.}
	)
)

(instance large_tree of NewFeature
	(properties
		x 257
		y 22
		nsLeft 195
		nsBottom 45
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A distinctively common tree sits near the shore of the lake.}
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/ceder')
				(if
					(<
						(GetDistance (gEgo x:) (gEgo y:) 51 89)
						(GetDistance (gEgo x:) (gEgo y:) 248 165)
					)
					(Print (tree lookStr:))
				else
					(Print lookStr)
				)
			)
		)
	)
)

(instance large_tree1 of NewFeature
	(properties
		x 268
		y 94
		noun '/ceder'
		nsTop 46
		nsLeft 252
		nsBottom 143
		nsRight 285
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A distinctively common tree sits near the shore of the lake.}
	)
)

(instance large_tree2 of NewFeature
	(properties
		x 238
		y 51
		noun '/ceder'
		nsTop 45
		nsLeft 225
		nsBottom 58
		nsRight 251
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A distinctively common tree sits near the shore of the lake.}
	)
)

(instance large_tree3 of NewFeature
	(properties
		x 247
		y 158
		noun '/ceder'
		nsTop 142
		nsLeft 215
		nsBottom 175
		nsRight 280
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A distinctively common tree sits near the shore of the lake.}
	)
)

(instance large_tree4 of NewFeature
	(properties
		x 184
		y 18
		noun '/ceder'
		nsLeft 174
		nsBottom 36
		nsRight 194
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A distinctively common tree sits near the shore of the lake.}
	)
)

(instance large_tree5 of NewFeature
	(properties
		x 303
		y 57
		noun '/ceder'
		nsTop 46
		nsLeft 286
		nsBottom 68
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A distinctively common tree sits near the shore of the lake.}
	)
)

(instance lake of NewFeature
	(properties
		x 139
		y 173
		noun '/water,lake,lake'
		nsTop 158
		nsLeft 16
		nsBottom 189
		nsRight 263
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {You can just see the northern edge of a nearby lake.}
	)
)

(instance rock of NewFeature
	(properties
		x 311
		y 88
		noun '/boulder'
		nsTop 72
		nsLeft 303
		nsBottom 104
		nsRight 320
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {There's a single large rock sitting off to the side.}
	)
)

