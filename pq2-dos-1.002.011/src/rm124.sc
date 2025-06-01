;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 124)
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
	rm124 0
)

(local
	local0
	local1
	local2
	local3
	[local4 3]
)

(instance bainsMusic of Sound
	(properties
		number 10
		priority 8
	)
)

(instance bainsGunFire of Sound
	(properties
		number 41
		priority 9
	)
)

(instance rm124 of Rm
	(properties
		picture 203
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(Load rsVIEW 295)
		(Load rsVIEW 15)
		(Load rsVIEW 298)
		(gEgo
			x:
				(cond
					((== gPrevRoomNum 122)
						(if (<= (gEgo x:) 220) 60 else 133)
					)
					((<= (gEgo x:) 120) 163)
					(else 292)
				)
			y: (if (== gPrevRoomNum 122) 87 else 180)
			view: (if (not global204) 0 else 6)
			init:
		)
		(HandsOn)
		((View new:)
			view: 295
			loop: 5
			cel: 0
			posn: 175 104
			ignoreActors: 1
			init:
			addToPic:
		)
		((Prop new:)
			view: 260
			loop: 8
			cel: 1
			posn: 294 173
			setPri: 0
			ignoreActors: 1
			init:
			addToPic:
		)
		((= [local4 0] (Prop new:))
			view: 99
			loop: 2
			cel: 0
			posn: 205 189
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= [local4 1] (Prop new:))
			view: 99
			loop: 2
			cel: 2
			posn: 96 113
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= [local4 2] (Prop new:))
			view: 99
			loop: 2
			cel: 1
			posn: 175 177
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local4 0] stopUpd:)
			([local4 1] stopUpd:)
		)
		(if (< global110 30)
			([local4 2] stopUpd:)
		)
		(gRatObj
			name: 6
			setLoop: 4
			illegalBits: 0
			posn: 232 93
			ignoreActors: 1
			init:
			setMotion: MoveTo 400 149 gRatObj
		)
		(gLightObj posn: 75 29 ignoreActors: 1 setPri: 14 init: stopUpd:)
		(global115 posn: 155 59 ignoreActors: 1 init: stopUpd:)
	)

	(method (doit)
		(cond
			(global139 0)
			((<= (gEgo y:) 85)
				(gCurRoom newRoom: 122)
			)
			((>= (gEgo y:) 190)
				(gCurRoom newRoom: 127)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look/ladder')
						(Print 124 0) ; "It is an ordinary ladder."
					)
					((Said 'open,remove,press,move/cover')
						(if (not local0)
							(Print 124 1) ; "You don't see that here."
						else
							(Print 124 2) ; "You strain to open the heavy cover, but you only succeed in making a lot of noise."
							(= local1 1)
						)
					)
					((Said 'climb[/ladder]>')
						(cond
							((Said '<down')
								(if (not local0)
									(Print 124 3) ; "You aren't on the ladder."
								else
									(gEgo setScript: ladderScript)
									(ladderScript changeState: 3)
								)
							)
							((Said '<up')
								(cond
									((!= local0 0)
										(Print 124 4) ; "You can't go up any farther."
									)
									((& (gEgo onControl: 1) $0080)
										(gEgo setScript: ladderScript)
										(ladderScript changeState: 1)
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
										(ladderScript changeState: 3)
									)
									((& (gEgo onControl: 1) $0080)
										(ladderScript changeState: 1)
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
				(= local0 1)
				(= global204 0)
				(gEgo
					view: 295
					loop: 1
					cel: 0
					ignoreActors: 1
					illegalBits: 0
					posn: 176 104
					setCycle: CT 11 1 self
					setMotion: 0
				)
			)
			(2
				(Print 124 5) ; "Climbing the ladder, you come to a heavy steel manhole cover."
				(User canInput: 1)
			)
			(3
				(gEgo loop: 3 setCycle: CT 7 1 self)
				(User canInput: 0)
			)
			(4
				(HandsOn)
				(gEgo
					view: (if (not global204) 0 else 6)
					posn: 152 100
					loop: 2
					cel: 0
					setCycle: Walk
					illegalBits: $8000
					ignoreActors: 0
				)
				(= local0 0)
				(self changeState: 0)
				(if (and (not local2) local1)
					(= local1 0)
					(= local2 1)
					(bainsMusic play:)
					((= local3 (Act new:))
						view: 14
						setLoop: 1
						cel: 0
						illegalBits: 0
						ignoreActors:
						posn: 330 230
						setStep: 6 3
						init:
						setCycle: Walk
						setScript: ambushScript
					)
				)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance ambushScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 20 30))
			)
			(1
				(if global106
					(= cycles 4)
					(-- state)
				else
					(HandsOff)
					(local3 setMotion: MoveTo 290 190 self)
					(gEgo setCycle: 0)
				)
			)
			(2
				(local3 view: 15 cel: 0 setCycle: End self)
				(bainsGunFire play:)
			)
			(3
				(if (or global204 (>= (Random 0 10) 5))
					(self changeState: 10)
				else
					(self changeState: 4)
				)
			)
			(4
				(gEgo
					illegalBits: 0
					view: 298
					loop: 1
					posn: (- (gEgo x:) 5) (gEgo y:)
				)
				(local3 view: 13)
				(RedrawCast)
				(EgoDead 124 6) ; "Unfortunately the noise alerted Bains, and you were caught by his ambush."
			)
			(10
				(local3
					view: 14
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 320 215 self
				)
			)
			(11
				(bainsMusic stop:)
				(= cycles 4)
			)
			(12
				(HandsOn)
				(gEgo setMotion: 0 setCycle: Walk)
				(Print 124 7) ; "The noise you made alerted Bains, but fortunately he missed and fled."
				(local3 dispose:)
			)
		)
	)
)

