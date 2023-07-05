;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	throwDagger 0
)

(local
	local0
	local1
	local2
)

(instance dagger of Act
	(properties
		z 25
		view 524
		illegalBits 0
	)
)

(instance throwDagger of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 130)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global273 gCurRoomNum)
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(HandsOff)
				(TrySkill 10 0 5) ; throwing
				(TrySkill 5 0 5) ; weapon-use
				(TrySkill 2 0 5) ; agility
				(TrySkill 0 0 5) ; strength
				(gEgo
					view: 524
					setLoop: (if (> (gEgo x:) ((ScriptID 15 1) x:)) 1 else 0) ; kobold
					cel: 0
					setCycle: CT 9 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(dagger
					posn: (gEgo x:) (gEgo y:)
					ignoreActors:
					illegalBits: 0
					init:
					setLoop: 2
					setCel: 0
					setStep: 15 10
				)
				(if
					(TrySkill
						10 ; throwing
						0
						(- 50 (/ (gEgo distanceTo: (ScriptID 15 1)) 5)) ; kobold
					)
					(SetFlag 346)
				)
				(if (IsFlag 346)
					(dagger
						setMotion:
							MoveTo
							((ScriptID 15 1) x:) ; kobold
							((ScriptID 15 1) y:) ; kobold
							self
					)
				else
					(dagger
						setMotion:
							MoveTo
							(if (< (gEgo x:) ((ScriptID 15 1) x:)) ; kobold
								(+ ((ScriptID 15 1) x:) 50) ; kobold
							else
								(- ((ScriptID 15 1) x:) 50) ; kobold
							)
							(- ((ScriptID 15 1) y:) 20) ; kobold
							self
					)
				)
			)
			(2
				(gEgo drop: 7 1) ; dagger
				(dagger hide:)
				(= cycles 2)
			)
			(3
				(dagger dispose: delete:)
				(NormalEgo)
				(EgoGait 0 0) ; walking
				(gEgo priority: local1 illegalBits: local2 signal: local0)
				(if (< global315 2)
					(SetFlag 297)
					(SetFlag 147)
				)
				(if
					(and
						(IsFlag 346)
						(not ((ScriptID 15 1) script:)) ; kobold
						(not (IsFlag 297))
					)
					(SetFlag 282)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

