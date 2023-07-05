;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Interface)
(use rgClouds)
(use NewFeature)
(use Motion)
(use System)

(public
	rm62 0
)

(procedure (localproc_0 param1 param2)
	(return
		(== ((gInventory at: param1) owner:) (if (== argc 1) gCurRoomNum else param2))
	)
)

(instance rm62 of cloudRoom
	(properties
		picture 62
		horizon 100
		north 59
		west 61
	)

	(method (init)
		(Load rsVIEW 67)
		(super init:)
		(proc610_1
			(proc0_18 96 (proc0_17 222 (gEgo x:) 3) 60)
			(+ horizon 4)
			0
			0
			0
			0
			3
			(proc0_17 148 (gEgo y:) (+ horizon 2))
			299
		)
		(gEgo init:)
		(proc0_1)
		(hole init:)
		(cave init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(cloud1 init:)
		(cloud2 init:)
		(cloud3 init:)
		(cloud4 init:)
		(cloud5 init:)
		(cloud6 init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event)
				(return 1)
			)
			((Said 'look,look/ceder')
				(Print 62 0) ; "There is a hole at the bottom of one of the trees."
			)
			((Said 'look,look/hole')
				(cond
					((not (gEgo inRect: 214 129 268 138))
						(Print 62 1) ; "You can't see inside the hole from here."
					)
					((localproc_0 10)
						(Print 62 2) ; "You see a slingshot in the hole."
					)
					(else
						(Print 62 3) ; "The hole is empty."
					)
				)
			)
			((Said 'get,get/shot')
				(cond
					((not (localproc_0 10))
						(Print 62 4) ; "What slingshot?"
					)
					((not (gEgo inRect: 214 129 268 138))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(else
						(gCurRoom setScript: getSlingshot)
					)
				)
			)
			((Said 'look,look/shot')
				(if (and (localproc_0 10) (gEgo inRect: 214 129 268 138))
					(Print 62 5) ; "This slingshot is made of very stretchy leather."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance getSlingshot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo 248 117)
				(self cue:)
			)
			(1
				(gEgo
					view: 67
					loop:
						(+
							(if (IsFlag 1) 2 else 0)
							(if (< (gEgo x:) 248) 0 else 1)
						)
					cel: 0
					setMotion: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 7)
			)
			(2
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(Print 62 6) ; "You reach into the hole and pull out the leather slingshot."
				(SetScore 85 2)
				(gEgo get: 10 setCycle: Beg self) ; Leather_Slingshot
			)
			(3
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 63
		y 132
		nsTop 103
		nsLeft 48
		nsBottom 162
		nsRight 78
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The immense, oddly-shaped trees loom over you.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 72
		y 80
		nsTop 56
		nsLeft 57
		nsBottom 104
		nsRight 88
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The immense, oddly-shaped trees loom over you.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 88
		y 29
		nsBottom 59
		nsRight 176
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The immense, oddly-shaped trees loom over you.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 231
		y 21
		nsTop -1
		nsLeft 208
		nsBottom 44
		nsRight 254
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The immense, oddly-shaped trees loom over you.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 250
		y 81
		nsTop 45
		nsLeft 223
		nsBottom 118
		nsRight 272
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The immense, oddly-shaped trees loom over you.}
	)
)

(instance hole of NewFeature
	(properties
		x 256
		y 114
		nsTop 104
		nsLeft 249
		nsBottom 124
		nsRight 264
		description {hole}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a small, dark hole in the base of this tree.}
	)
)

(instance cave of NewFeature
	(properties
		x 305
		y 22
		noun '/cave,boulder'
		nsTop -1
		nsLeft 291
		nsBottom 45
		nsRight 319
		description {rocks}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You can barely make out the cave opening to the north.}
	)
)

(instance cloud1 of NewFeature
	(properties
		x 22
		y 161
		noun '/cloud'
		nsTop 134
		nsBottom 189
		nsRight 45
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The dense clouds start to flow over the land here.  Somewhere just out in those clouds the land comes to an end; better be careful where you walk!}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 182
		y 174
		noun '/cloud'
		nsTop 159
		nsLeft 45
		nsBottom 189
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The dense clouds start to flow over the land here.  Somewhere just out in those clouds the land comes to an end; better be careful where you walk!}
	)
)

(instance cloud3 of NewFeature
	(properties
		x 302
		y 103
		noun '/cloud'
		nsTop 48
		nsLeft 285
		nsBottom 159
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The dense clouds start to flow over the land here.  Somewhere just out in those clouds the land comes to an end; better be careful where you walk!}
	)
)

(instance cloud4 of NewFeature
	(properties
		x 261
		y 149
		noun '/cloud'
		nsTop 140
		nsLeft 237
		nsBottom 159
		nsRight 285
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The dense clouds start to flow over the land here.  Somewhere just out in those clouds the land comes to an end; better be careful where you walk!}
	)
)

(instance cloud5 of NewFeature
	(properties
		x 234
		y 99
		noun '/cloud'
		nsTop 93
		nsLeft 184
		nsBottom 105
		nsRight 285
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The dense clouds start to flow over the land here.  Somewhere just out in those clouds the land comes to an end; better be careful where you walk!}
	)
)

(instance cloud6 of NewFeature
	(properties
		x 277
		y 84
		noun '/cloud'
		nsTop 76
		nsLeft 271
		nsBottom 92
		nsRight 284
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The dense clouds start to flow over the land here.  Somewhere just out in those clouds the land comes to an end; better be careful where you walk!}
	)
)

