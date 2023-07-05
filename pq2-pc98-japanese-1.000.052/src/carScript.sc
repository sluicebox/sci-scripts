;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 227)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	carScript 0
)

(local
	local0
	local1
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(if (== global131 13)
					(= local0 (Prop new:))
					(local0
						view: 51
						loop: 3
						cel: 0
						ignoreActors:
						posn: 197 184
						setPri: 14
						setCycle: End self
						init:
					)
				else
					(self cue:)
				)
			)
			(2
				((ScriptID 25) notify: 0) ; rm25
				(= local1 (if (== global131 13) 165 else 175))
				(gEgo
					illegalBits: -32768
					posn: local1 175
					loop: 0
					cel: 0
					setCycle: Walk
					setPri: 13
				)
				(if global112
					(= global133 0)
					(local0 dispose:)
					(global112
						ignoreActors: 0
						illegalBits: -32768
						posn: 193 197
						setCycle: Walk
						setStep: 3 2
						setPri: 15
						setMotion: MoveTo 190 200 self
					)
				else
					(= global136 0)
					(self cue:)
				)
			)
			(3
				(if global112
					(global112 setPri: -1)
					(if (< global110 30)
						(global112 stopUpd:)
					else
						((ScriptID 25) notify: 1) ; rm25
					)
				)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 227)
			)
			(4
				(HandsOff)
				(if (== global131 13)
					(gEgo stopUpd:)
					(Print 227 0) ; "Keith yells: "Geez, Sonny! Hold on a second, will ya?""
					(cond
						((> (global112 y:) 189)
							(global112
								ignoreActors:
								illegalBits: -32768
								setMotion: MoveTo 185 (global112 y:) self
							)
						)
						((< (global112 x:) 110)
							(global112
								ignoreActors:
								illegalBits: -32768
								setMotion: MoveTo 110 (global112 y:) self
							)
						)
						(else
							(global112
								ignoreActors:
								illegalBits: -32768
								setMotion: MoveTo 105 (global112 y:) self
							)
						)
					)
				else
					(self changeState: 7)
				)
			)
			(5
				(cond
					((== (global112 x:) 110)
						(global112
							ignoreActors:
							illegalBits: -32768
							setMotion: MoveTo 110 195 self
						)
					)
					((== (global112 x:) 105)
						(global112
							ignoreActors:
							illegalBits: -32768
							setMotion: MoveTo 105 195 self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(global112 setMotion: MoveTo 190 195 self)
			)
			(7
				(gEgo setPri: 12)
				(if (== global131 13)
					((= local0 (Prop new:))
						view: 51
						loop: (if (== global131 13) 3 else 0)
						cel: 0
						posn: 197 184
						setPri: 15
						init:
						setCycle: End self
					)
					(global112
						ignoreActors: 1
						illegalBits: 0
						setLoop: 0
						setStep: 1 2
						setPri: 15
						setMotion: MoveTo 190 195
					)
				else
					(self cue:)
				)
			)
			(8
				(= gNewRoomNum global131)
				(client setScript: 0)
				(DisposeScript 227)
			)
		)
	)
)

