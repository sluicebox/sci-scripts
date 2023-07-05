;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use Chase)
(use Motion)
(use User)
(use System)

(public
	lightning 0
)

(instance lightning of Script
	(properties)

	(method (init)
		(if ((ScriptID 15 4) script:) ; ball
			((ScriptID 15 4) setScript: 0) ; ball
		)
		(super init: &rest)
		(SetFlag 314)
		(= global347 (- 80 (/ (gEgo distanceTo: (ScriptID 15 1)) 6))) ; kobold
	)

	(method (dispose)
		(if (and (not ((ScriptID 15 4) script:)) (== ((ScriptID 15 4) loop:) 5)) ; ball, ball
			(SetFlag 281)
		)
		(super dispose:)
		(ClearFlag 314)
		(DisposeScript 115)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				((ScriptID 15 1) ; kobold
					view: 177
					setMotion: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(1
				(if (IsFlag 307)
					(ClearFlag 307)
					(HighPrint 115 0) ; "Uh oh! The Kobold doesn't look very calm."
				)
				((ScriptID 15 1) stopUpd:) ; kobold
				((ScriptID 15 11) play:) ; koboldShoots
				(if (>= global347 (Random100))
					(SetFlag 339)
				)
				(if (and (IsFlag 339) (not (IsFlag 317)))
					((ScriptID 15 4) ; ball
						setLoop: 5
						posn:
							(switch ((ScriptID 15 1) loop:) ; kobold
								(0
									(- ((ScriptID 15 1) x:) 24) ; kobold
								)
								(1
									(+ ((ScriptID 15 1) x:) 24) ; kobold
								)
								(2
									(- ((ScriptID 15 1) x:) 17) ; kobold
								)
								(3
									(+ ((ScriptID 15 1) x:) 17) ; kobold
								)
								(4
									(- ((ScriptID 15 1) x:) 5) ; kobold
								)
							)
							(switch ((ScriptID 15 1) loop:) ; kobold
								(0
									(+ ((ScriptID 15 1) y:) 6) ; kobold
								)
								(1
									(+ ((ScriptID 15 1) y:) 6) ; kobold
								)
								(2
									(+ ((ScriptID 15 1) y:) 10) ; kobold
								)
								(3
									(+ ((ScriptID 15 1) y:) 10) ; kobold
								)
								(4
									(+ ((ScriptID 15 1) y:) 13) ; kobold
								)
							)
						show:
						forceUpd:
					)
					(self cue:)
				else
					(SetFlag 281)
					(SetFlag 344)
				)
			)
			(2
				(User canInput: 1)
				(if (not ((ScriptID 15 4) script:)) ; ball
					((ScriptID 15 4) ; ball
						setCycle: Fwd
						startUpd:
						setMotion: Chase gEgo 0 self
					)
				else
					(self cue:)
				)
			)
			(3
				(if (and (gEgo script:) (not (IsFlag 315)))
					(SetFlag 151)
					(SetFlag 281)
					((ScriptID 15 1) ; kobold
						view: 175
						cycleSpeed: 3
						setCycle: Fwd
						startUpd:
						setScript: 0
					)
				else
					((ScriptID 15 12) play:) ; magicHit
					(ClearFlag 151)
					((ScriptID 15 4) setLoop: 7 cel: 0 setCycle: End self) ; ball
					(if (or (not (gEgo script:)) (IsFlag 315))
						(SetFlag 290)
					)
				)
			)
			(4
				(SetFlag 344)
				(self dispose:)
			)
		)
	)
)

