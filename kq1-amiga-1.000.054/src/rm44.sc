;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Blk)
(use Game)
(use User)
(use Actor)

(public
	rm44 0
)

(instance rm44 of Rm
	(properties
		picture 44
		horizon 52
		north 5
		east 45
		south 37
		west 43
	)

	(method (init)
		(Load rsVIEW 244)
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
				(gEgo posn: (proc0_17 225 (gEgo x:) 41) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 318 (gEgo x:) 73) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) 78))
			)
			(east
				(if (< (gEgo y:) 148)
					(gEgo posn: 273 101)
				else
					(gEgo posn: 317 (proc0_17 188 (gEgo y:) 169))
				)
			)
			(else
				(gEgo posn: 251 157 loop: 1)
			)
		)
		(gEgo init: observeBlocks: pumpBlock)
		(proc0_1)
		(gAddToPics add: stump pump eachElementDo: #init doit:)
		(smallRock init:)
		(pinetree1 init:)
		(pinetree2 init:)
		(pinetree3 init:)
		(pinetree4 init:)
		(stump1 init:)
		(stump2 init:)
		(stump3 init:)
		(stump5 init:)
		(stump6 init:)
		(window1 init:)
		(porch1 init:)
		(porch2 init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 1) $4000)
				(self newRoom: 79)
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
			((Said 'hit,kick/building')
				(Print 44 0) ; "In the condition the cottage is in, that might be dangerous."
			)
			((or (Said 'open,open/door') (Said 'close,close/door'))
				(if (gEgo inRect: 233 149 264 160)
					(Print 44 1) ; "Upon closer inspection you realize this poor cabin doesn't even have a door."
				else
					(proc0_4) ; "It's not quite within reach, Sir Graham."
				)
			)
			((Said 'look,look/hole')
				(Print 44 2) ; "The roof is sadly in need of reshingling. It leaks in several dozen places."
			)
			((Said 'look,look/ceiling')
				(Print 44 3) ; "This is the saddest-looking roof you've ever seen. Made of thatched bark, it clearly won't keep the rain out. It's sagging slightly, too...it looks like it might fall in if it isn't repaired soon!"
			)
			((Said 'look,look/chimney')
				(Print 44 4) ; "The chimney seems to be the only part of the cottage that doesn't need repairing."
			)
			(
				(or
					(Said 'look,look[<in,in,through]/door,doorway')
					(and
						(gEgo inRect: 233 149 264 160)
						(Said 'look,look<in')
					)
					(proc0_14 event 249 106 264 159)
					(proc0_14 event 225 158 269 175)
				)
				(if (gEgo inRect: 233 149 264 160)
					(if (IsFlag 113)
						(Print 44 5) ; "Inside, you can see the woodcutter feeding stew to his wife. Somehow, the shaky little hut looks cheerier inside already!"
					else
						(Print 44 6) ; "When you look in the doorway, you see a poor starving woodcutter and his wife."
					)
				else
					(Print 44 7) ; "From where you're standing, you can see that the cottage doesn't even have a door."
				)
			)
			(
				(or
					(Said 'look,look/building')
					(proc0_14 event 229 135 320 170)
					(proc0_14 event 222 75 236 89)
					(proc0_14 event 237 58 320 89)
					(proc0_14 event 211 89 320 135)
				)
				(Print 44 8) ; "It was made from rough, hand-hewn logs long ago. Lately, the upkeep has faltered. There are even holes in the roof."
			)
			(
				(or
					(Said 'look,look<in,through,in/window')
					(and
						(<
							(GetDistance (gEgo x:) (gEgo y:) 228 139 60)
							60
						)
						(Said 'look,look<in')
					)
				)
				(cond
					((IsFlag 113)
						(Print 44 9) ; "Through the small paneless window, you see a very relieved woodcutter feeding hot stew to his wife."
					)
					((< (GetDistance (gEgo x:) (gEgo y:) 228 139 60) 60)
						(Print 44 10) ; "Through the small paneless window, you see a poor starving woodcutter and his bedridden wife."
					)
					(else
						(Print 44 11) ; "You are unable to see in the window from here."
					)
				)
			)
			((Said 'look,look<in')
				(Print 44 12) ; "You're standing too far away from the house to see inside."
			)
			((Said 'look,look/window')
				(Print 44 13) ; "There is a window on the front of the house."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(if (IsFlag 113)
							(Print 44 14) ; "You see the cottage of the poor woodcutter and his wife. You helped them both tremendously by giving them the magic bowl of hot stew."
						else
							(Print 44 15) ; "You see a cottage in shambles. It saddens you to think that somebody might still live there."
						)
					)
					((or (Said '/man') (Said '/woman'))
						(if (gEgo inRect: 233 149 264 160)
							(Print 44 16) ; "Perhaps you should go inside the cottage for a better look."
						else
							(Print 44 17) ; "You can't see inside the door from where you're standing. Perhaps if you moved a little closer."
						)
					)
				)
			)
		)
	)
)

(instance stump of PicView
	(properties
		x 152
		y 155
		view 244
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (MousedOn self event 3) (Said 'look,look/ax'))
				(Print 44 18) ; "An old axe is permanently wedged into the tree stump."
				(Print 44 19) ; "The handle has been broken and repaired. The head shows the signs of many sharpenings."
				(event claimed: 1)
			)
			((Said 'look,look/stump')
				(if (gEgo inRect: 115 140 187 160)
					(Print 44 20) ; "The trees were cut from these stumps years ago with this ax."
				else
					(Print 44 21) ; "The trees were cut from these stumps years ago."
				)
			)
			((Said 'get,get/ax')
				(if (gEgo inRect: 115 140 187 160)
					(Print 44 22) ; "The old axe is tightly wedged in the tree stump. You cannot remove it no matter what you do."
				else
					(proc0_4) ; "It's not quite within reach, Sir Graham."
				)
			)
			((Said 'use/ax')
				(if (gEgo inRect: 115 140 187 160)
					(Print 44 23) ; "How are you going to use the axe when you can't even get it out of the stump?"
				else
					(proc0_4) ; "It's not quite within reach, Sir Graham."
				)
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance pump of PicView
	(properties
		x 50
		y 177
		view 244
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(Said 'look,look/pump')
					(Said 'look,look/pump<water')
					(MousedOn self event 3)
				)
				(event claimed: 1)
				(Print 44 24) ; "It is an ancient, rusty water pump. It probably doesn't even work."
			)
			(
				(or
					(Said 'use/pump')
					(Said 'pump/water')
					(Said 'pump')
					(Said 'pump/pump')
					(Said 'work/pump')
				)
				(if (gEgo inRect: 30 167 70 187)
					(Print 44 25) ; "The rusty pump doesn't work."
				else
					(proc0_4) ; "It's not quite within reach, Sir Graham."
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance smallRock of View
	(properties
		x 204
		y 176
		description {rock}
		view 244
		loop 2
		signal 16384
	)
)

(instance pumpBlock of Blk
	(properties
		top 175
		left 45
		bottom 179
		right 55
	)
)

(instance pinetree1 of NewFeature
	(properties
		x 63
		y 110
		noun '/ceder[<pine]'
		nsTop 84
		nsLeft 25
		nsBottom 137
		nsRight 101
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are still a few graceful pines standing near the woodcutter's cottage.}
	)
)

(instance pinetree2 of NewFeature
	(properties
		x 60
		y 72
		noun '/ceder[<pine]'
		nsTop 61
		nsLeft 36
		nsBottom 84
		nsRight 84
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are still a few graceful pines standing near the woodcutter's cottage.}
	)
)

(instance pinetree3 of NewFeature
	(properties
		x 54
		y 53
		noun '/ceder[<pine]'
		nsTop 45
		nsLeft 40
		nsBottom 61
		nsRight 69
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are still a few graceful pines standing near the woodcutter's cottage.}
	)
)

(instance pinetree4 of NewFeature
	(properties
		x 282
		y 28
		noun '/ceder[<pine]'
		nsTop -1
		nsLeft 244
		nsBottom 57
		nsRight 320
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are still a few graceful pines standing near the woodcutter's cottage.}
	)
)

(instance stump1 of NewFeature
	(properties
		x 130
		y 102
		noun '/stump'
		nsTop 99
		nsLeft 125
		nsBottom 106
		nsRight 136
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These tree stumps sit where mighty trees once stood.}
	)
)

(instance stump2 of NewFeature
	(properties
		x 152
		y 116
		noun '/stump'
		nsTop 112
		nsLeft 147
		nsBottom 120
		nsRight 158
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These tree stumps sit where mighty trees once stood.}
	)
)

(instance stump3 of NewFeature
	(properties
		x 197
		y 101
		noun '/stump'
		nsTop 98
		nsLeft 193
		nsBottom 105
		nsRight 201
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These tree stumps sit where mighty trees once stood.}
	)
)

(instance porch1 of NewFeature
	(properties
		x 226
		y 150
		noun '/porch'
		nsTop 141
		nsLeft 207
		nsBottom 159
		nsRight 246
		description {porch}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This crude porch looks like it has seen better days.}
	)
)

(instance porch2 of NewFeature
	(properties
		x 246
		y 167
		noun '/porch'
		nsTop 159
		nsLeft 226
		nsBottom 175
		nsRight 267
		description {porch}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This crude porch looks like it has seen better days.}
	)
)

(instance stump5 of NewFeature
	(properties
		x 133
		y 67
		nsTop 60
		nsLeft 119
		nsBottom 74
		nsRight 148
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees were cut from these stumps years ago.}
	)
)

(instance stump6 of NewFeature
	(properties
		x 178
		y 68
		nsTop 61
		nsLeft 164
		nsBottom 76
		nsRight 192
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees were cut from these stumps years ago.}
	)
)

(instance window1 of NewFeature
	(properties
		x 229
		y 111
		z -27
		heading 235
		nsTop 98
		nsLeft 224
		nsBottom 125
		nsRight 234
		sightAngle 360
		getableDist 0
		seeableDist 60
		shiftClick 367
	)

	(method (doLook)
		(cond
			((> (GetDistance (gEgo x:) (gEgo y:) x y) seeableDist)
				(Print 44 26) ; "You need to get closer."
			)
			((IsFlag 113)
				(Print 44 9) ; "Through the small paneless window, you see a very relieved woodcutter feeding hot stew to his wife."
			)
			(else
				(Print 44 10) ; "Through the small paneless window, you see a poor starving woodcutter and his bedridden wife."
			)
		)
	)
)

(instance bush1 of NewFeature
	(properties
		x 17
		y 173
		noun '/bush'
		nsTop 157
		nsBottom 189
		nsRight 35
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Bushes grow here and there around the front of the woodcutter's house.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 49
		y 179
		noun '/bush'
		nsTop 169
		nsLeft 35
		nsBottom 189
		nsRight 64
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Bushes grow here and there around the front of the woodcutter's house.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 8
		y 58
		noun '/bush'
		nsTop 42
		nsBottom 74
		nsRight 16
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Bushes grow here and there around the front of the woodcutter's house.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 27
		y 63
		noun '/bush'
		nsTop 52
		nsLeft 16
		nsBottom 74
		nsRight 39
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Bushes grow here and there around the front of the woodcutter's house.}
	)
)

