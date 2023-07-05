;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use Chase)
(use Motion)
(use System)

(public
	flameDart 0
)

(local
	local0
	local1
)

(instance flameDart of Script
	(properties)

	(method (init &tmp [temp0 100])
		(if ((ScriptID 15 6) script:) ; dart
			((ScriptID 15 6) setScript: 0) ; dart
		)
		(super init: &rest)
		(= local0
			(TrySkill 12 0 (- 30 (/ (gEgo distanceTo: (ScriptID 15 1)) 5))) ; magic, kobold
		)
	)

	(method (dispose)
		(if (and (not ((ScriptID 15 6) script:)) (== ((ScriptID 15 6) loop:) 2)) ; dart, dart
			(SetFlag 287)
		)
		(super dispose:)
		(DisposeScript 119)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 522
					setLoop: (if (< (gEgo x:) ((ScriptID 15 1) x:)) 0 else 1) ; kobold
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				((ScriptID 15 10) play:) ; egoShoots
				(cond
					((IsFlag 153)
						(= local1 0)
					)
					((or (IsFlag 157) local0)
						(= local1 1)
					)
					(else
						(= local1 2)
					)
				)
				(switch local1
					(0
						(SetFlag 288)
						(self changeState: 3)
					)
					(1
						((ScriptID 15 6) ; dart
							setLoop: 2
							posn: (gEgo x:) (gEgo y:)
							show:
							setCycle: Fwd
							startUpd:
						)
						(if (< global315 2)
							((ScriptID 15 6) ; dart
								setMotion:
									MoveTo
									((ScriptID 15 2) x:) ; body
									(+ ((ScriptID 15 2) y:) 10) ; body
									self
							)
						else
							((ScriptID 15 6) ; dart
								setMotion: Chase (ScriptID 15 1) 0 self ; kobold
							)
						)
					)
					(2
						(SetFlag 287)
						(self changeState: 3)
					)
				)
			)
			(2
				(if
					(or
						(== ((ScriptID 15 1) script:) (ScriptID 123 1)) ; kobold, koboldDazzle
						(not ((ScriptID 15 1) script:)) ; kobold
					)
					(DisposeScript 123)
					(ClearFlag 216)
					(ClearFlag 152)
					((ScriptID 15 12) play:) ; magicHit
					((ScriptID 15 6) ; dart
						view: 532
						setLoop: 0
						cel: 0
						setCycle: End self
					)
					(if (IsFlag 157)
						(= global315 2)
						(SetFlag 297)
					else
						(SetFlag 282)
					)
				else
					(SetFlag 152)
					(SetFlag 287)
					(self cue:)
				)
			)
			(3
				(if (not (IsFlag 152))
					((ScriptID 15 6) view: 522 setLoop: 3 cel: 4) ; dart
				)
				(NormalEgo)
				(LookAt gEgo (ScriptID 15 1)) ; kobold
				(if local1
					(HandsOn)
				)
				(if
					(and
						(not ((ScriptID 15 1) script:)) ; kobold
						(not ((ScriptID 15 4) script:)) ; ball
						(IsFlag 157)
					)
					(= global315 2)
					(SetFlag 297)
				)
				(client setScript: 0)
			)
		)
	)
)

