;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Inventory)
(use System)

(public
	CarvingScript 0
)

(local
	oldIllegalBits
)

(instance CarvingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gEgoState 0)
					(= cycles 1)
				else
					(HandsOff)
					(= gOldGameSpeed (gGame setSpeed: 6))
					(= oldIllegalBits (gEgo illegalBits:))
					(gEgo view: 711 loop: 0 cel: 0 setCycle: End self)
				)
				(Print 43 0 #icon 3 0 0) ; "You use your razor sharp ginsu knife to carefully carve the precious granadilla wood into what you hope will be accepted as a primitive island native sculpture."
			)
			(1
				(if (!= gEgoState 0)
					(= cycles 1)
				else
					(gEgo loop: 1 cel: 0 setCycle: Fwd)
					(= cycles (* 10 (NumCels gEgo)))
				)
			)
			(2
				((Inv at: 3) view: (if (>= gFilthLevel 2) 22 else 34)) ; Granadilla_Wood
				(Format ((Inv at: 3) name:) 43 1) ; "Erotic Sculpture%", Granadilla_Wood
				(gGame changeScore: 50)
				(if (== gEgoState 0)
					(HandsOn)
					(NormalEgo 0)
					(gEgo illegalBits: oldIllegalBits)
					(gGame setSpeed: gOldGameSpeed)
				)
				(self dispose:)
			)
		)
	)
)

