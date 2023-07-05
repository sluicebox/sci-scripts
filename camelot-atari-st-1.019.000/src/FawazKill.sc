;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 171)
(include sci.sh)
(use Main)
(use n128)
(use Motion)
(use Actor)
(use System)

(public
	FawazKill 0
)

(instance fawazShadow of Act
	(properties
		view 366
	)

	(method (doit &tmp temp0)
		(= temp0
			(+ (= temp0 (- (global185 y:) 55)) (* (- 260 (global185 x:)) 1))
		)
		(super doit:)
		(self posn: (global185 x:) temp0)
	)
)

(instance FawazKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(global186 hide:)
				(global185
					setLoop: 5
					setCel: 0
					setCycle: End
					setStep: 4 2
					illegalBits: 0
					setPri: 1
					setMotion: MoveTo 232 115 self
				)
				(fawazShadow
					setLoop: 8
					illegalBits: 0
					ignoreActors:
					setPri: 2
					init:
					doit:
				)
			)
			(1
				(global185
					setCel: 4
					setCycle: End
					setMotion: MoveTo 224 115 self
				)
			)
			(2
				(fawazShadow dispose:)
				(global185 hide:)
				(= seconds 3)
			)
			(3
				(global185
					view: 367
					setLoop: 0
					setCel: 0
					posn: 154 95
					setPri: 10
					cycleSpeed: 1
					show:
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo
					view: 367
					setLoop: 1
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(global185 setCycle: End)
			)
			(5
				(EgoDead 171 0) ; "Pretty women always did go to your head, though seldom with such an impact."
			)
		)
	)
)

