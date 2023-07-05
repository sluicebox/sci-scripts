;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Inventory)
(use System)

(public
	LeiingScript 0
)

(local
	oldIllegalBits
)

(instance LeiingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= gOldGameSpeed (gGame setSpeed: 6))
				(= oldIllegalBits (gEgo illegalBits:))
				(gEgo
					view: 710
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(Print 42 0 #icon 11 0 0) ; "You weave the wild orchids into a beautiful lei."
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
				((Inv at: 11) view: 26) ; some_Orchids
				(Format ((Inv at: 11) name:) 42 1) ; "A Quick Lei", some_Orchids
				(if (not (TestFlag 55))
					(SetFlag 55)
					(gGame changeScore: 50)
					(Print 42 2 #at -1 144) ; "(Welcome to the islands, Meester Laffer!)"
				else
					(Print 42 3 #at -1 144) ; "(Welcome BACK to the islands, Meester Laffer!)"
				)
				(NormalEgo 0)
				(gEgo illegalBits: oldIllegalBits)
				(gGame setScript: 0 setSpeed: gOldGameSpeed)
				(DisposeScript 42)
			)
		)
	)
)

