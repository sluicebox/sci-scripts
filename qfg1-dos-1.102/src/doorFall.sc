;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	doorFall 0
	finalExit 1
)

(local
	local0
)

(instance doorFall of Script
	(properties)

	(method (dispose)
		(gEgo illegalBits: (& (gEgo illegalBits:) $ffff))
		(super dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: (| (gEgo illegalBits:) $0028))
				(++ local0)
				((ScriptID 96 8) ; door7
					posn: (- ((ScriptID 96 8) x:) 1) ((ScriptID 96 8) y:) ; door7, door7
				)
				(= cycles 1)
			)
			(1
				((ScriptID 96 8) ; door7
					posn: (+ ((ScriptID 96 8) x:) 1) ((ScriptID 96 8) y:) ; door7, door7
				)
				(= cycles 1)
			)
			(2
				(if (< local0 7)
					(self changeState: 0)
				else
					(= local0 0)
					(self cue:)
				)
			)
			(3
				((ScriptID 96 12) ignoreActors: setPri: 4 init: stopUpd:) ; behindDoor7
				(cond
					(
						(and
							(== (gEgo onControl: 1) 4096)
							(not (gEgo script:))
						)
						(HandsOff)
						(gEgo hide:)
						((ScriptID 96 8) setLoop: 7 setCel: 8) ; door7
						(= cycles 1)
					)
					(((ScriptID 96 1) script:) ; trap1
						((ScriptID 96 8) setCel: 0 stopUpd:) ; door7
						((ScriptID 96 12) delete:) ; behindDoor7
						(client setScript: 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				((ScriptID 96 8) ; door7
					setLoop: 1
					cel: (if (== (gEgo onControl: 1) 4096) 2 else 0)
					setCycle: End self
				)
			)
			(5
				((ScriptID 96 16) ; effect
					number: (SoundFX 84)
					loop: 1
					priority: 2
					play:
				)
				(if
					(and
						(== (gEgo onControl: 1) 4096)
						(not (gEgo script:))
					)
					(= cycles 15)
				else
					(self changeState: 12)
				)
			)
			(6
				(if (TakeDamage 10)
					(if (== (gEgo onControl: 1) 4096)
						((ScriptID 96 8) setCycle: CT 2 -1 self) ; door7
					else
						((ScriptID 96 8) setCycle: CT 1 -1 self) ; door7
					)
				else
					(EgoDead 232 0 82 516 5 8 80 {This way to the Egress}) ; "This time the joke fell flat. That was a truly dirty trick. Too bad you won't have a chance to get even...or will you?"
				)
			)
			(7
				(if (== (gEgo onControl: 1) 4096)
					((ScriptID 96 8) setLoop: 7 setCel: 8) ; door7
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(8
				((ScriptID 96 8) setLoop: 1 setCel: 0) ; door7
				(gEgo
					view: 538
					setLoop: 0
					cel: 0
					illegalBits: 0
					posn: 106 95
					show:
				)
				((ScriptID 96 12) dispose:) ; behindDoor7
				(= cycles 5)
			)
			(9
				(gEgo setCycle: End setMotion: MoveTo 97 (+ (gEgo y:) 6))
				(= cycles 15)
			)
			(10
				(gEgo
					view: 503
					setLoop: 4
					cel: 0
					x: (- (gEgo x:) 4)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(11
				(HighPrint 232 1) ; "What a miserable experience!"
				(self cue:)
			)
			(12
				(gEgo setLoop: 2)
				(if (not (gEgo script:))
					(NormalEgo)
				)
				(= cycles 3)
			)
			(13
				((ScriptID 96 8) stopUpd:) ; door7
				(if (!= ((ScriptID 96 8) cel:) 0) ; door7
					(SetFlag 264)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance finalExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 257)
				((ScriptID 96 12) setCel: 1) ; behindDoor7
				(= cycles 2)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 109 98 self)
			)
			(2
				(gEgo setPri: 3 setMotion: MoveTo 118 92 self)
			)
			(3
				(ClearFlag 257)
				(gCurRoom newRoom: 97)
			)
		)
	)
)

