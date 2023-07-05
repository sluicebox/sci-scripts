;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 124)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	egoFetch 0
)

(instance lasso of Act
	(properties
		view 520
		illegalBits 0
	)
)

(instance egoFetch of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 124)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 520 setLoop: 1 cel: 0)
				(= cycles 5)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(lasso
					ignoreActors:
					illegalBits: 0
					posn: (+ (gEgo x:) 2) (- (gEgo y:) 36)
					setLoop: 5
					setPri: 7
					setStep: 20 10
					setCycle: Fwd
					init:
					setMotion:
						MoveTo
						((ScriptID 15 2) x:) ; body
						(- ((ScriptID 15 2) y:) 10) ; body
						self
				)
			)
			(3
				(lasso
					setPri: 11
					setStep: 6 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 2)
						(- (gEgo y:) 36)
						self
				)
				((ScriptID 15 7) ; koboldKey
					ignoreActors:
					illegalBits: 0
					posn: ((ScriptID 15 2) x:) (- ((ScriptID 15 2) y:) 10) ; body, body
					init:
					setLoop: 7
					setCel: 0
					setPri: 11
					setStep: 6 4
					setMotion: MoveTo (+ (gEgo x:) 2) (- (gEgo y:) 36)
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(lasso hide:)
				((ScriptID 15 7) hide:) ; koboldKey
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(HighPrint 124 0) ; "You now have the Kobold's key. Nice work!"
				(SetFlag 165)
				(NormalEgo)
				(gEgo get: 5 loop: 1) ; key
				(= global321 2)
				(SolvePuzzle 649 7)
				(= cycles 2)
			)
			(7
				(lasso dispose:)
				((ScriptID 15 7) hide:) ; koboldKey
				(= cycles 2)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

