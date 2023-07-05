;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	ricochet 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 11]
	[local17 11]
)

(procedure (localproc_0)
	(= local0 (- (gEgo x:) ((ScriptID 15 1) x:))) ; kobold
	(= local1 (- (gEgo y:) ((ScriptID 15 1) y:))) ; kobold
	(= local2 (+ ((ScriptID 15 1) x:) (* local0 10))) ; kobold
	(= local3 (+ ((ScriptID 15 1) y:) (* local1 10))) ; kobold
)

(instance ricochet of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 116)
	)

	(method (doit)
		(if (and local4 (not ((ScriptID 15 4) inRect: 10 35 310 205))) ; ball
			(= local4 0)
			(self cue:)
		)
		(if ((ScriptID 15 1) script:) ; kobold
			(self dispose:)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= [local6 0] 17)
		(= [local17 0] 47)
		(= [local6 1] 44)
		(= [local17 1] 155)
		(= [local6 2] 17)
		(= [local17 2] 134)
		(= [local6 3] 251)
		(= [local17 3] 186)
		(= [local6 4] 101)
		(= [local17 4] 47)
		(= [local6 5] 183)
		(= [local17 5] 145)
		(= [local6 6] 283)
		(= [local17 6] 124)
		(= [local6 7] 316)
		(= [local17 7] 212)
		(= [local6 8] 102)
		(= [local17 8] 161)
		(= [local6 9] 244)
		(= [local17 9] 51)
		(= [local6 10] 169)
		(= [local17 10] 55)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(ClearFlag 314)
				(= local5 (Random 0 2))
				(if (not (IsFlag 151))
					((ScriptID 15 4) ; ball
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
					)
				)
				(self cue:)
			)
			(1
				(if (not (IsFlag 151))
					(= local4 1)
					(localproc_0)
					((ScriptID 15 4) ; ball
						show:
						setLoop: 5
						setStep: 24 16
						setCycle: Fwd
						startUpd:
						setMotion: MoveTo local2 local3
					)
				else
					(self cue:)
				)
			)
			(2
				(if (not (IsFlag 151))
					(self cue:)
				else
					(localproc_0)
					(= local4 1)
					((ScriptID 15 4) setMotion: MoveTo local2 local3) ; ball
				)
			)
			(3
				((ScriptID 15 3) ; poof
					ignoreActors:
					cel: 0
					setPri: 12
					posn: ((ScriptID 15 4) x:) ((ScriptID 15 4) y:) ; ball, ball
					setCycle: End
				)
				(+= local5 (Random 1 4))
				((ScriptID 15 4) ; ball
					setMotion: MoveTo [local6 local5] [local17 local5] self
				)
			)
			(4
				(if (< local5 10)
					(self changeState: 3)
				else
					(self cue:)
				)
			)
			(5
				((ScriptID 15 4) ; ball
					setLoop: 6
					cel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(6
				((ScriptID 15 4) setScript: 0) ; ball
			)
		)
	)
)

