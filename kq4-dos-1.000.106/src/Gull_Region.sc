;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 504)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Gull_Region 0
)

(local
	local0
	[local1 4]
	local5
)

(instance gullBlock1 of Cage
	(properties)
)

(instance Gull_Region of Rgn
	(properties
		name {Gull Region}
	)

	(method (init)
		(if (not gNight)
			(gullBlock1 top: -20 bottom: 55 left: -30 right: 349 init:)
			(Load rsVIEW 325)
			(Load rsVIEW 326)
			(= local0 2)
			(if (and (!= gCurRoomNum 7) (!= gCurRoomNum 40)) ; Room_40
				(for ((= local5 1)) (<= local5 local0) ((++ local5))
					(= [local1 local5]
						((Act new:)
							x: (Random 1 280)
							y: (Random 1 30)
							xStep: 1
							yStep: 1
							cycleSpeed: 1
							observeBlocks: gullBlock1
							setPri: 0
							setCycle: Fwd
							setMotion: Wander 15
							view:
								(if (== gCurRoomNum 32) ; Room_32
									325
								else
									(Random 325 326)
								)
							ignoreHorizon: 1
							illegalBits: $4000
							init:
							yourself:
						)
					)
				)
			)
		)
		(super init:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(if (not gNight)
				(cond
					((Said '/gull,gull,bird>')
						(cond
							((Said 'look')
								(Print 504 0) ; "You see many seagulls gliding through the air in their never-ending quest for food."
							)
							((Said 'talk')
								(Print 504 1) ; "Seagulls don't talk."
							)
							((Said 'get,capture')
								(Print 504 2) ; "You can't catch a seagull."
							)
							((Said 'kiss')
								(Print 504 3) ; "You can't kiss a seagull."
							)
							((Said 'feed')
								(Print 504 4) ; "The seagulls are not interested."
							)
						)
					)
					((Said 'give/*/gull,gull,bird')
						(cond
							((not (= temp0 (gInventory saidMe:)))
								(Print 504 5) ; "You can't give that."
							)
							((gEgo has: (gInventory indexOf: temp0))
								(Print 504 6) ; "The seagull has no interest in it."
							)
							(else
								(DontHave) ; "You don't have it."
							)
						)
					)
					((Said 'throw')
						(cond
							((not (= temp0 (gInventory saidMe:)))
								(Print 504 7) ; "You can't throw that."
							)
							((gEgo has: (gInventory indexOf: temp0))
								(Print 504 8) ; "That would accomplish nothing."
							)
							(else
								(DontHave) ; "You don't have it."
							)
						)
					)
				)
			else
				(Print 504 9) ; "You don't see one here."
			)
		)
	)
)

