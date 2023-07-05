;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 137)
(include sci.sh)
(use Main)
(use Rev)
(use Motion)
(use System)

(public
	firstWarning 0
)

(local
	local0
	local1
)

(instance firstWarning of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 969)
		(DisposeScript 137)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (gEgo cycler:))
				(gEgo cycler: 0)
				(HandsOff)
				(Talk 137 0) ; "YOU MAY NOT PASS THIS WAY! Do not annoy us, infidel."
				(cond
					(
						(and
							(IsFlag 96)
							(or
								(< (gEgo distanceTo: (ScriptID 51 2)) 15) ; whiteThug
								(< (gEgo distanceTo: (ScriptID 51 4)) 15) ; magentaThug
							)
						)
						(= local0 1)
						((ScriptID 51 2) ; whiteThug
							view: 387
							setCycle: Walk
							setLoop: -1
							startUpd:
							setMotion: MoveTo 204 151
						)
						((ScriptID 51 4) ; magentaThug
							view: 388
							setCycle: Walk
							setLoop: -1
							startUpd:
							setMotion: MoveTo 178 159
						)
						(gEgo
							ignoreActors: 1
							setLoop: 1
							setCycle: Rev
							setMotion:
								MoveTo
								(+ (gEgo x:) 25)
								(gEgo y:)
								self
						)
					)
					(
						(and
							(IsFlag 96)
							(< (gEgo distanceTo: (ScriptID 51 3)) 25) ; blueThug
						)
						(= local0 2)
						((ScriptID 51 3) ; blueThug
							view: 386
							setCycle: Walk
							setLoop: -1
							startUpd:
							setMotion: MoveTo 278 161
						)
						(gEgo
							ignoreActors: 1
							setLoop: 0
							setCycle: Rev
							setMotion:
								MoveTo
								(- (gEgo x:) 35)
								(gEgo y:)
								self
						)
					)
					(else
						((ScriptID 51 3) ; blueThug
							view: 386
							setCycle: Walk
							setLoop: -1
							startUpd:
							setMotion: MoveTo 281 161
						)
						((ScriptID 51 2) ; whiteThug
							view: 387
							setCycle: Walk
							setLoop: -1
							startUpd:
							setMotion: MoveTo 201 151
						)
						((ScriptID 51 4) ; magentaThug
							view: 388
							setCycle: Walk
							setLoop: -1
							startUpd:
							setMotion: MoveTo 175 159
						)
						(gEgo
							ignoreActors: 1
							setLoop: 3
							setCycle: Rev
							setMotion:
								MoveTo
								(gEgo x:)
								(+ (gEgo y:) 10)
								self
						)
					)
				)
			)
			(1
				(gEgo ignoreActors: 0 setLoop: -1 setCycle: 0)
				(= cycles 8)
			)
			(2
				(cond
					((== local0 1)
						((ScriptID 51 2) ; whiteThug
							setCycle: Rev
							setLoop: 0
							setMotion: MoveTo 189 151
						)
						((ScriptID 51 4) ; magentaThug
							setCycle: Rev
							setLoop: 0
							setMotion: MoveTo 163 159
						)
						(= cycles 5)
					)
					((== local0 2)
						((ScriptID 51 3) ; blueThug
							setCycle: Rev
							setLoop: 1
							setMotion: MoveTo 293 161
						)
						(= cycles 5)
					)
					(else
						((ScriptID 51 2) ; whiteThug
							setCycle: Rev
							setLoop: 0
							setMotion: MoveTo 189 151
						)
						((ScriptID 51 4) ; magentaThug
							setCycle: Rev
							setLoop: 0
							setMotion: MoveTo 163 159
						)
						((ScriptID 51 3) ; blueThug
							setCycle: Rev
							setLoop: 1
							setMotion: MoveTo 293 161
						)
						(= cycles 4)
					)
				)
			)
			(3
				((ScriptID 51 4) ; magentaThug
					view: 344
					setCycle: 0
					setMotion: 0
					setLoop: 4
					cel: 0
					stopUpd:
				)
				((ScriptID 51 2) ; whiteThug
					view: 344
					setCycle: 0
					setMotion: 0
					setLoop: 3
					cel: 0
					stopUpd:
				)
				((ScriptID 51 3) ; blueThug
					view: 344
					setCycle: 0
					setMotion: 0
					setLoop: 6
					cel: 0
					stopUpd:
				)
				(= cycles 2)
			)
			(4
				(gEgo cycler: local1)
				(= local0 0)
				(gTObj endTalk:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

