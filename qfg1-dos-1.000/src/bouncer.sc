;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Chase)
(use Motion)
(use System)

(public
	bouncer 0
	bounceBack 1
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
	(= local0 (- ((ScriptID 15 1) x:) (gEgo x:))) ; kobold
	(= local1 (- ((ScriptID 15 1) y:) (gEgo y:))) ; kobold
	(= local2 (+ (gEgo x:) (* local0 10)))
	(= local3 (+ (gEgo y:) (* local1 10)))
)

(instance bouncer of Script
	(properties)

	(method (dispose)
		((ScriptID 15 6) setCycle: 0 posn: 0 1000) ; dart
		(super dispose:)
		(DisposeScript 120)
	)

	(method (doit)
		(if (and local4 (not ((ScriptID 15 6) inRect: 10 35 310 205))) ; dart
			(= local4 0)
			(self cue:)
		)
		(if (gEgo script:)
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
		(= [local6 3] 244)
		(= [local17 3] 51)
		(= [local6 4] 283)
		(= [local17 4] 124)
		(= [local6 5] 316)
		(= [local17 5] 212)
		(= [local6 6] 101)
		(= [local17 6] 47)
		(= [local6 7] 183)
		(= [local17 7] 145)
		(= [local6 8] 102)
		(= [local17 8] 161)
		(= [local6 9] 251)
		(= [local17 9] 186)
		(= [local6 10] 169)
		(= [local17 10] 55)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (Random 3 5))
				(if (not (IsFlag 152))
					((ScriptID 15 6) posn: (gEgo x:) (gEgo y:)) ; dart
				)
				(self cue:)
			)
			(1
				(if (not (IsFlag 152))
					(= local4 1)
					(localproc_0)
					((ScriptID 15 6) ; dart
						show:
						setLoop: 2
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
				(if (not (IsFlag 152))
					(self cue:)
				else
					(localproc_0)
					(= local4 1)
					((ScriptID 15 6) setMotion: MoveTo local2 local3) ; dart
				)
			)
			(3
				((ScriptID 15 5) ; puff
					ignoreActors:
					cel: 0
					setPri: 12
					posn: ((ScriptID 15 6) x:) ((ScriptID 15 6) y:) ; dart, dart
					setCycle: End
				)
				(+= local5 (Random 1 3))
				((ScriptID 15 6) ; dart
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
				((ScriptID 15 6) ; dart
					setLoop: 3
					cel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(6
				((ScriptID 15 6) setScript: 0) ; dart
			)
		)
	)
)

(instance bounceBack of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 120)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 15 6) ; dart
					posn: (gEgo x:) (gEgo y:)
					show:
					setLoop: 2
					setStep: 24 16
					setCycle: Fwd
					startUpd:
					setMotion: Chase (ScriptID 15 1) 0 self ; kobold
				)
			)
			(1
				((ScriptID 15 6) setMotion: Chase gEgo 0 self) ; dart
			)
			(2
				((ScriptID 15 6) ; dart
					view: 532
					setLoop: 4
					cel: 0
					setMotion: 0
					setCycle: End self
				)
				((ScriptID 15 12) play:) ; magicHit
			)
			(3
				((ScriptID 15 6) view: 522 setLoop: 3 cel: 4) ; dart
				(if (not (gEgo script:))
					(SetFlag 290)
				)
				(client setScript: 0)
			)
		)
	)
)

