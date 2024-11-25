;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	local0
	local1
	[local2 3]
)

(instance sewerEntranceMusic of Sound
	(properties)
)

(instance rm120 of Rm
	(properties
		picture 201
		style 8
	)

	(method (init)
		(self setRegions: 205) ; sewer
		(super init:)
		(HandsOn)
		(Load rsVIEW 295)
		(Load rsVIEW 301)
		(if (== gPrevRoomNum 81)
			(gEgo
				view: 295
				loop: 2
				cel: 0
				posn: 130 113
				illegalBits: $8000
				init:
			)
		else
			(gEgo
				view: (if (not global204) 0 else 6)
				x:
					(switch gPrevRoomNum
						(123
							(if (>= (gEgo x:) 235) 140 else 35)
						)
						(121 310)
						(else 130)
					)
				y:
					(switch gPrevRoomNum
						(123 180)
						(121
							(gEgo y:)
						)
						(else 120)
					)
				illegalBits: $8000
				init:
			)
		)
		((View new:)
			view: 295
			loop: 4
			cel: 0
			posn: 130 113
			ignoreActors: 1
			init:
			addToPic:
		)
		((View new:)
			view: 301
			loop: 0
			cel: 0
			posn: 211 90
			setPri: 1
			init:
			addToPic:
		)
		((= [local2 0] (Prop new:))
			view: 99
			loop: 1
			cel: 0
			posn: 260 128
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors: 1
			init:
		)
		((= [local2 1] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 176 141
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors: 1
			init:
		)
		((= [local2 2] (Prop new:))
			view: 99
			loop: 3
			cel: 1
			posn: 133 173
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors: 1
			init:
		)
		((Prop new:)
			view: 99
			loop: 1
			cel: 2
			posn: 317 130
			setPri: 1
			ignoreActors: 1
			init:
			addToPic:
		)
		(if (< global110 60)
			([local2 0] stopUpd:)
		)
		(if (< global110 30)
			([local2 1] stopUpd:)
			([local2 2] stopUpd:)
		)
		(= local1 (gRatObj new:))
		(gRatObj
			name: 2
			setLoop: 3
			illegalBits: 0
			posn: 380 65
			ignoreActors: 1
			init:
			setMotion: MoveTo 400 65 gRatObj
		)
		(local1
			name: 1
			setLoop: 5
			illegalBits: 0
			posn: 102 91
			ignoreActors: 1
			init:
			setMotion: MoveTo -100 172 local1
		)
		(gLightObj posn: 122 78 ignoreActors: 1 setPri: 14 stopUpd: init:)
		(global115 posn: 226 56 ignoreActors: 1 stopUpd: init:)
		(if (== gPrevRoomNum 81)
			(= global156 -1)
			(= global239 -1)
			(sewerEntranceMusic number: 11 loop: 1 priority: 3 play:)
			(gContinuousMusic number: 9 loop: -1 priority: 2 play:)
			(gEgo setScript: ladderScript)
			(ladderScript changeState: 1)
		)
	)

	(method (doit)
		(cond
			(global139 0)
			((>= (gEgo x:) 315)
				(gCurRoom newRoom: 121)
			)
			((>= (gEgo y:) 190)
				(gCurRoom newRoom: 123)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look[<at,around][/!*,chamber,sewer]')
						(Print 120 0) ; "You have entered the City of Steelton's underground sewer complex. The dampness and subdued light gives you an eerie feeling..."
					)
					((Said 'look/ladder')
						(Print 120 1) ; "It's an ordinary ladder."
					)
					((Said 'climb[/ladder]>')
						(cond
							((Said '<down')
								(if (not local0)
									(Print 120 2) ; "You aren't on the ladder."
								else
									(gEgo setScript: ladderScript)
									(ladderScript changeState: 5)
								)
							)
							((Said '<up')
								(cond
									((!= local0 0)
										(Print 120 3) ; "You can't go any further up."
									)
									((& (gEgo onControl: 1) $0080)
										(gEgo setScript: ladderScript)
										(ladderScript changeState: 3)
									)
									(else
										(proc0_7) ; "You're not close enough."
									)
								)
							)
							((Said '[<!*]')
								(cond
									(local0
										(gEgo setScript: ladderScript)
										(ladderScript changeState: 5)
									)
									((& (gEgo onControl: 1) $0080)
										(ladderScript changeState: 3)
									)
									(else
										(proc0_7) ; "You're not close enough."
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance ladderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= seconds 2)
			)
			(2
				(self changeState: 5)
			)
			(3
				(HandsOff)
				(= global204 1)
				(User canInput: 1)
				(= local0 1)
				(gEgo ignoreActors: 1)
				(gEgo view: 295 loop: 0 posn: 130 113 setCycle: CT 11 1 self)
			)
			(4
				(gContinuousMusic stop:)
				(gCurRoom newRoom: 81)
			)
			(5
				(gEgo loop: 2 setCycle: CT 7 1 self)
			)
			(6
				(gEgo
					view: (if (not global204) 0 else 6)
					posn: 154 108
					loop: 2
					cel: 0
					setCycle: Walk
					ignoreActors: 0
					illegalBits: $8000
				)
				(HandsOn)
				(= local0 0)
				(gEgo setScript: 0)
			)
		)
	)
)

