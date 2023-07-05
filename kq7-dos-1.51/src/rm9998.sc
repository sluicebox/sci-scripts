;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9998)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm9998 0
)

(local
	local0
	local1
	[local2 76] = [152 98 152 18 162 35 68 70 213 43 108 107 124 21 71 89 83 82 203 68 189 93 198 85 111 109 201 81 250 80 227 128 115 128 168 66 292 117 307 78 304 101 530 43 404 55 441 48 394 80 370 93 457 20 481 28 614 63 628 74 341 56 596 116 436 78 503 52 541 52 523 34 545 62 494 68]
)

(instance rm9998 of KQRoom
	(properties
		picture 2600
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(spark1 init:)
		(spark2 init:)
		(spark3 init:)
		(spark4 init:)
		(spark5 init:)
		(spark6 init:)
		(spark7 init:)
		(spark8 init:)
		(self setScript: scroll)
	)
)

(instance scroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom setRect: 0 0 639 136)
				(UpdatePlane gThePlane)
				(= seconds 4)
			)
			(1
				(= local0 0)
				(= local1 639)
				(while (>= (gThePlane left:) -315)
					(= gGameTime (+ gTickOffset (GetTime)))
					(gCast doit:)
					(if gDoMotionCue
						(= gDoMotionCue 0)
						(gCast eachElementDo: #motionCue)
					)
					(if (gGame script:)
						((gGame script:) doit:)
					)
					(if gCuees
						(gCuees eachElementDo: #doit)
						(if (gCuees isEmpty:)
							(gCuees dispose:)
							(= gCuees 0)
						)
					)
					(gRegions eachElementDo: #doit)
					(gThePlane setRect: local0 0 local1 136)
					(-= local0 3)
					(-= local1 3)
					(UpdatePlane gThePlane)
					(FrameOut)
				)
				(= seconds 8)
			)
			(2
				(gCurRoom newRoom: 1400)
			)
		)
	)
)

(instance spark1 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark2 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark3 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark4 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark5 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark6 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark7 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance spark8 of Prop
	(properties
		view 2601
		cel 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (* (Random 0 36) 2))
		(self
			cel: 0
			posn: [local2 temp0] [local2 (+ temp0 1)]
			setCycle: End self
		)
	)

	(method (cue)
		(self init:)
	)
)

