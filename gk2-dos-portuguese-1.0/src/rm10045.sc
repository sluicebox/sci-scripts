;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10045)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)
(use System)

(public
	rm10045 0
)

(instance rm10045 of ExitRoom ; "Alt\99tting: Church Exterior"
	(properties
		noun 1
		picture 10045
		south 800 ; bavMapRm
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 1000) ; altExtRm
			(gGk2Music fade: 0 25 10 1 0)
			(Lock 140 10045 0) ; WAVE
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(gCurRoom setScript: sndTrans)
		(super init: &rest)
		(gGame handsOn:)
		(church init:)
	)
)

(instance sndTrans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (gGk2Music handle:) (== 10045 (gGk2Music number:)))
						(self dispose:)
					)
					((gGk2Music handle:)
						(gGk2Music fade: 0 10 10 1 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(Lock 140 1000 0) ; WAVE
				(Lock 140 10045 1) ; WAVE
				(gGk2Music
					number: 10045
					setLoop: -1
					play: 0 0
					fade: 63 10 10 0 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sEnterChurchExterior of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 240)
			)
			(2
				(gCurRoom newRoom: 1000) ; altExtRm
			)
		)
	)
)

(instance church of GKFeature
	(properties
		sightAngle 40
		x 328
		y 160
		BAD_SELECTOR 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 312 298 300 70 300 86 268 124 249 130 194 182 110 196 153 296 136 310 9 342 175 502 165 500 81 512 98 512 55 540 134 548 139 554 163 566 165 564 177 586 300 540 300 538 309 402 309
					yourself:
				)
		)
		(super init: &rest)
	)
)

