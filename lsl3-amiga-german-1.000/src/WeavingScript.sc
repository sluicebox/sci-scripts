;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Inventory)
(use System)

(public
	WeavingScript 0
)

(local
	oldIllegalBits
)

(instance WeavingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= gOldGameSpeed (gGame setSpeed: 6))
				(= oldIllegalBits (gEgo illegalBits:))
				(gEgo
					view: 717
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(Print 44 0 #icon 4 0 0) ; "You carefully weave the wild grass into what you hope will pass for a primitive, island native outfit."
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(gEgo loop: 2)
				(= seconds 2)
			)
			(3
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(4
				((Inv at: 4) view: 23) ; Native_Grass
				(Format ((Inv at: 4) name:) 44 1) ; "Grass Skirt", Native_Grass
				(gGame changeScore: 30)
				(NormalEgo 0)
				(gEgo illegalBits: oldIllegalBits)
				(gGame setSpeed: gOldGameSpeed)
				(self dispose:)
			)
		)
	)
)

