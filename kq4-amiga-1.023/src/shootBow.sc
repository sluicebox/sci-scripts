;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Inventory)
(use System)

(public
	shootBow 0
)

(local
	local0
)

(instance shootBow of Script
	(properties)

	(method (init)
		(= global204 1)
		(Load rsVIEW 31)
		(Load rsVIEW 68)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global181 (gEgo view:))
				(= global185 (gEgo baseSetter:))
				(= local0 (gEgo viewer:))
				(gEgo
					viewer: 0
					baseSetter: (ScriptID 0 1) ; smallBase
					view: (if (== global181 2) 31 else 68)
					setMotion: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo view: global181 setCycle: Walk)
				(= global204 0)
				((Inv at: 14) loop: (+ ((Inv at: 14) loop:) 1)) ; Cupid_s_Bow, Cupid_s_Bow
				(= global120 (Print 305 0 #at -1 10 #dispose)) ; "You shoot an arrow into the air..."
				(Timer setReal: self 4)
			)
			(2
				(cls)
				(Print 305 1) ; "Oops!...you missed!"
				(gEgo viewer: local0 baseSetter: global185 script: global164)
				(HandsOn)
				(DisposeScript 305)
			)
		)
	)
)

