;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 139)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	hermitHits 0
)

(local
	local0
)

(procedure (localproc_0 &tmp [temp0 200])
	(Format @temp0 &rest)
	(Print @temp0 #at 160 10)
)

(instance hermitHits of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 139)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 275)
					(ClearFlag 275)
					(localproc_0 139 0)
					(User canControl: 1)
					(= cycles 15)
				else
					(self cue:)
				)
			)
			(1
				(if (not (gEgo script:))
					(HandsOff)
				)
				(SetFlag 352)
				(client
					view: 81
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: CT 4 1 self
				)
			)
			(2
				(cond
					((== (gEgo onControl: 1) 4096)
						((ScriptID 82 4) number: (SoundFX 84) loop: 1 play:) ; rm82Sound
						(SetFlag 274)
						(gEgo setScript: (ScriptID 138 0)) ; waHooHooHooey
					)
					((== (gEgo onControl: 1) 16384)
						(SetFlag 276)
						(gEgo setPri: 0)
					)
				)
				(client setCycle: End self)
			)
			(3
				(if (IsFlag 276)
					((ScriptID 82 4) number: (SoundFX 84) loop: 1 play:) ; rm82Sound
					(gEgo hide:)
				)
				((ScriptID 82 1) ; hermitHead
					posn: (- (client x:) 26) (- (client y:) 16)
					setCel: 0
					setPri: 15
					init:
				)
				(= cycles 5)
			)
			(4
				((ScriptID 82 1) setCel: 1) ; hermitHead
				(= cycles 5)
			)
			(5
				(if
					(and
						(IsFlag 272)
						(not (IsFlag 274))
						(not (IsFlag 276))
					)
					(ClearFlag 272)
					(localproc_0 139 1)
					(gEgo setScript: (ScriptID 82 2)) ; goOnIn
					(client setScript: 0)
				else
					(TimePrint 4 139 2 80 {the Hermit mutters...}) ; "Mpfph.. grumble.. nobody 'ere, I guess."
					(= cycles 1)
				)
			)
			(6
				(++ local0)
				((ScriptID 82 1) setCel: 0) ; hermitHead
				(= cycles 3)
			)
			(7
				((ScriptID 82 1) setCel: 1) ; hermitHead
				(= cycles 3)
			)
			(8
				(if (< local0 4)
					(self changeState: 6)
				else
					(self cue:)
				)
			)
			(9
				(if (IsFlag 276)
					(gEgo
						view: 538
						setLoop: 0
						cel: 0
						x: (- (gEgo x:) 5)
						y: (- (gEgo y:) 3)
						stopUpd:
						show:
					)
				)
				((ScriptID 82 1) dispose:) ; hermitHead
				(client setLoop: 3 cel: 0 setCycle: End self)
			)
			(10
				(ClearFlag 352)
				(if (IsFlag 276)
					(gEgo setScript: (ScriptID 82 3)) ; squashed
				)
				(client setScript: 0)
			)
		)
	)
)

