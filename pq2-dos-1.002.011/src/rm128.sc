;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 128)
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
	rm128 0
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

(instance rm128 of Rm
	(properties
		picture 204
		style 0
	)

	(method (init)
		(Load rsVIEW 295)
		(Load rsVIEW 15)
		(Load rsVIEW 298)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			x:
				(cond
					((== gPrevRoomNum 125)
						(if (<= (gEgo x:) 50) 197 else 270)
					)
					((<= (gEgo x:) 200) 26)
					(else 158)
				)
			y: (if (== gPrevRoomNum 125) 87 else 185)
			view: (if (not global204) 0 else 6)
			init:
		)
		(HandsOn)
		((View new:)
			view: 295
			loop: 4
			cel: 0
			posn: 143 105
			ignoreActors: 1
			init:
			addToPic:
		)
		((= [local4 0] (Prop new:))
			view: 99
			loop: 3
			cel: 2
			posn: 121 188
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local4 1] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 185 144
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local4 2] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 225 113
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local4 0] stopUpd:)
			([local4 2] stopUpd:)
		)
		(if (< global110 30)
			([local4 1] stopUpd:)
		)
		(gRatObj
			name: 3
			setLoop: 5
			illegalBits: 0
			posn: 72 95
			ignoreActors: 1
			init:
			setMotion: MoveTo -100 167 gRatObj
		)
		(gLightObj posn: 164 60 ignoreActors: 1 setPri: 14 init: stopUpd:)
		(global115 posn: 245 28 ignoreActors: 1 init: stopUpd:)
	)

	(method (doit)
		(cond
			(global139 0)
			((<= (gEgo y:) 85)
				(gCurRoom newRoom: 125)
			)
			((>= (gEgo y:) 190)
				(gCurRoom newRoom: 130)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look/ladder')
						(Print 128 0) ; "It's an ordinary ladder."
					)
					((Said 'open,remove,press,move/cover[<manhole]')
						(if (not local0)
							(Print 128 1) ; "You don't see that here."
						else
							(Print 128 2) ; "You strain to open the heavy cover, but you only succeed in making a lot of noise."
							(= local1 1)
						)
					)
					((Said 'climb[/ladder]>')
						(cond
							((Said '<down')
								(if (not local0)
									(Print 128 3) ; "You aren't on the ladder."
								else
									(gEgo setScript: ladderScript)
									(ladderScript changeState: 3)
								)
							)
							((Said '<up')
								(cond
									((!= local0 0)
										(Print 128 4) ; "You can't go any further up."
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
					loop: 0
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					posn: 143 105
					setCycle: CT 11 1 self
					setMotion: 0
				)
			)
			(2
				(Print 128 5) ; "Climbing the ladder, you come to a heavy steel manhole cover."
				(User canInput: 1)
			)
			(3
				(gEgo loop: 2 cel: 0 setCycle: CT 7 1 self)
				(User canInput: 0)
			)
			(4
				(HandsOn)
				(gEgo
					view: (if (not global204) 0 else 6)
					posn: 171 102
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
					(Load rsSOUND 41)
					(bainsMusic play:)
					((= local3 (Act new:))
						view: 14
						setLoop: 0
						cel: 0
						illegalBits: 0
						ignoreActors:
						posn: -20 222
						setStep: 6 3
						init:
						setCycle: Walk
						setScript: ambushScript
					)
					(gEgo setScript: 0)
				)
			)
		)
	)
)

(instance ambushScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 30))
			)
			(1
				(if global106
					(= cycles 4)
					(-- state)
				else
					(HandsOff)
					(local3 setMotion: MoveTo 20 205 self)
					(gEgo setCycle: 0)
				)
			)
			(2
				(local3 view: 15 cel: 0 setCycle: End self)
				(bainsGunFire play:)
			)
			(3
				(if (or global204 (>= (Random 0 10) 5))
					(self changeState: 4)
				else
					(self changeState: 10)
				)
			)
			(4
				(gEgo
					illegalBits: 0
					view: 298
					loop: 0
					posn: (- (gEgo x:) 5) (gEgo y:)
				)
				(local3 view: 13)
				(RedrawCast)
				(EgoDead 128 6) ; "Unfortunately the noise alerted Bains, and you were caught by his ambush."
			)
			(10
				(local3
					view: 14
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -20 222 self
				)
			)
			(11
				(bainsMusic stop:)
				(= cycles 4)
			)
			(12
				(HandsOn)
				(gEgo setMotion: 0 setCycle: Walk)
				(Print 128 7) ; "The noise you made alerted Bains, but fortunately he missed and fled."
				(local3 dispose:)
			)
		)
	)
)

