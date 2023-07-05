;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Inventory)
(use Actor)

(public
	Room14 0
)

(local
	local0
)

(instance Room14 of Rm
	(properties
		picture 14
	)

	(method (init)
		(= north 8)
		(= south 20)
		(= east 15)
		(= west 13)
		(= horizon 68)
		(= gIndoors 0)
		(if (<= (gEgo y:) horizon)
			(gEgo posn: (gEgo x:) (- horizon 2))
		)
		(if (and (== gPrevRoomNum 20) (> (gEgo x:) 209))
			(gEgo x: 209)
		)
		(super init:)
		(if gNight
			(gCurRoom overlay: 114)
		)
		(= local0 (+ (* (- global160 global213) 60) (- global159 global214)))
		(if (and ((Inv at: 9) ownedBy: 203) (>= local0 3)) ; Lute
			(= gMinstrelRoom (/ (= gMinstrelRoom (Random 1 300)) 100))
		)
		(if (== gMinstrelRoom 2)
			(= gMinstrelActor (Act new:))
			(gMinstrelActor
				view: 174
				loop: 2
				setCel: 0
				illegalBits: 0
				posn: 168 129
				init:
			)
		)
		(self setRegions: 506 516) ; meadReg, regMinstrel
		(gEgo view: 2 init:)
		(if (== gPrevRoomNum 0)
			(gEgo posn: 149 188)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: gMinstrelActor)
			(= global213 global160)
			(= global214 global159)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'look/around')
						(Said 'look/room')
						(Said 'look[<around][/!*]')
						(Said 'smell/blossom')
					)
					(Print 14 0) ; "The scent of wildflowers fills the air in the lovely green meadow."
				)
				((Said 'look/stump')
					(Print 14 1) ; "Yes, there's a tree stump in the middle of the meadow."
				)
			)
		)
	)
)

