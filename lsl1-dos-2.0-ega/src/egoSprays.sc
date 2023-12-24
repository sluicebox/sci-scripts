;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	egoSprays 0
)

(local
	sprayCount
)

(instance egoSprays of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(ClearFlag 5) ; fEgoUsingSpray
		(DisposeScript 812)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 5) ; fEgoUsingSpray
				(HandsOff)
				(if (!= (gEgo loop:) 1)
					(gEgo setHeading: 90)
				)
				(= cycles 3)
			)
			(1
				(gEgo
					egoSpeed:
					view: 804
					loop: (if (not (gEgo loop:)) 0 else 1)
					cel: 0
					x:
						(if (!= (gEgo loop:) 1)
							(gEgo x:)
						else
							(- (gEgo x:) 1)
						)
					setCycle: CT 3 1 self
				)
			)
			(2
				((ScriptID 0 23) play:) ; spraySound
				(gEgo setCycle: CT 1 -1 self)
			)
			(3
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				((ScriptID 0 23) play:) ; spraySound
				(= cycles 1)
			)
			(5
				(Print 812 0 #at -1 20) ; "Ahhhh."
				(gEgo setCycle: End self)
			)
			(6
				(= seconds 2)
			)
			(7
				(++ gSprayCounter)
				(= gSpraySeconds 600)
				(ClearFlag 20) ; fMouthSmellsBad
				(if (IsFlag 21) ; fNearPerson
					(ClearFlag 21) ; fNearPerson
					(Print 812 1) ; "It's about time!!"
				)
				(if (> gSprayCounter 9)
					(Print 812 2) ; "Since your breath spray is now empty, you toss it away."
					(gEgo put: 1 510) ; breathSpray
					(= gSprayCounter 0)
				)
				(gEgo
					x:
						(if (!= (gEgo loop:) 1)
							(gEgo x:)
						else
							(+ (gEgo x:) 1)
						)
				)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

