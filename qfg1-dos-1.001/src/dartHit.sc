;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	dartHit 0
	koboldDies 1
)

(instance dartHit of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 117)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 15 1) ; kobold
					view: 178
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(if (IsFlag 346)
					(ClearFlag 346)
					(-= global343 global345)
				else
					(-= global343 global346)
				)
				(if (<= global343 0)
					(SetFlag 283)
					(self dispose:)
				else
					(SetFlag 344)
					(self dispose:)
				)
			)
		)
	)
)

(instance koboldDies of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 118)
		(DisposeScript 117)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 15 4) setCycle: 0 dispose:) ; ball
				(= global315 4)
				(= global319 4)
				((ScriptID 15 1) ; kobold
					view: 178
					setLoop: 5
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(if (== global321 0)
					((ScriptID 15 7) ; koboldKey
						illegalBits: 0
						ignoreActors:
						view: 178
						posn: ((ScriptID 15 1) x:) ((ScriptID 15 1) y:) ; kobold, kobold
						setLoop: 6
						setPri: (if (IsFlag 149) 5 else -1)
						cycleSpeed: 1
						setCycle: End
					)
					(= global321 1)
				)
			)
			(1
				(= global332 0)
				(= global333 0)
				(gContMusic number: 20 loop: -1 play:)
				((ScriptID 15 7) ; koboldKey
					setPri: (- ((ScriptID 15 7) priority:) 1) ; koboldKey
					stopUpd:
				)
				(if (or (== gHeroType 0) (== gHeroType 1)) ; Fighter, Magic User
					(SolvePuzzle 602 10)
				)
				(HandsOn)
				((ScriptID 15 1) dispose:) ; kobold
			)
		)
	)
)

