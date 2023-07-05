;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm77 0
)

(local
	[local0 4]
	local4
	local5
	local6
	local7
)

(instance rm77 of Rm
	(properties
		picture 701
		style 8
		horizon 90
		west 76
	)

	(method (dispose)
		(SetFlag 67)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 700)
		(if (and gNight (== gPrevRoomNum 70))
			(Load rsSCRIPT 295)
		)
		(if (and (not gNight) (!= gPrevRoomNum 76) (IsFlag 202))
			(Load rsVIEW 78)
		)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(cond
			((and (not (IsFlag 197)) (not global332))
				(SetFlag 202)
				(= global332 0)
			)
			((and (IsFlag 198) (not global332) (not (IsFlag 202)))
				(switch (Random 0 1)
					(0
						(ClearFlag 202)
					)
					(1
						(SetFlag 202)
					)
				)
			)
		)
		(gEgo init:)
		(if (and (not gNight) (!= gPrevRoomNum 76) (IsFlag 202))
			(= [local0 0] (Random 90 116))
			(= [local0 1] (Random 132 154))
			(= [local0 2] (Random 0 1))
			(= [local0 3] (Random 1 30))
			(stag
				view: 78
				x: [local0 0]
				y: [local0 1]
				setScript: stagScript
				init:
			)
		else
			(ClearFlag 202)
		)
		(switch gPrevRoomNum
			(70
				(gEgo posn: 180 92 setMotion: MoveTo 180 110)
				(if (IsFlag 188)
					(User canControl: 0)
					(User canInput: 0)
					(ClearFlag 188)
					(self setScript: (ScriptID 295 0)) ; byebye
				)
			)
			(76
				(gEgo posn: 1 140 setMotion: MoveTo 40 140)
			)
			(78
				(gEgo posn: 318 140 setMotion: MoveTo 253 140)
			)
		)
		(= local6 0)
		(= local5 (IsFlag 202))
		(gAddToPics add: southBush eachElementDo: #init doit:)
	)

	(method (doit)
		(switch (gEgo edgeHit:)
			(2
				(ClearFlag 202)
				(gCurRoom newRoom: 78)
			)
			(1
				(ClearFlag 202)
				(gCurRoom newRoom: 70)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'cast>')
						(switch (= local7 (SaidSpell event))
							(18
								(if (CastSpell local7)
									(HighPrint 77 0) ; "You detect a strange, magical aura in this place."
								)
							)
							(20
								(if (CastSpell local7)
									(CastDazzle)
									(HighPrint 77 1) ; "Your spell has no effect."
								)
							)
							(23
								(cond
									((not (gCast contains: stag))
										(event claimed: 0)
									)
									((CastSpell local7)
										(SetFlag 203)
										(LookAt gEgo stag)
										(RedrawCast)
										(CastDart stag)
									)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(= temp0 (if (gCast contains: stag) stag else 0))
						(if (ThrowKnife temp0)
							(if (IsFlag 202)
								(SetFlag 203)
							)
							(if (gCast contains: stag)
								(LookAt gEgo stag)
								(RedrawCast)
							)
						)
					)
					((Said 'throw/boulder')
						(= temp0 (if (gCast contains: stag) stag else 0))
						(if (ThrowRock temp0)
							(if (IsFlag 202)
								(SetFlag 203)
							)
							(if (gCast contains: stag)
								(LookAt gEgo stag)
								(RedrawCast)
							)
						)
					)
					((Said 'japaneseclimbup,climb,climb,ride,ride/buck,buck')
						(if (IsFlag 202)
							(HighPrint 77 2) ; "He's beyond your reach."
						else
							(CantDo)
						)
					)
					((Said 'attack,kill,hit,cut,chop/buck,buck')
						(if (IsFlag 202)
							(SetFlag 203)
							(HighPrint 77 3) ; "The stag seems to be magically protected."
						else
							(CantDo)
						)
					)
					((Said 'look,look/buck,buck')
						(HighPrint 77 4) ; "You don't see a stag here."
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance stagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoGait 0 0) ; walking
				(User canControl: 0)
				(if [local0 3]
					(= local6 0)
					(if [local0 2]
						(stag loop: 6 cycleSpeed: 3 setCycle: Fwd)
					else
						(stag loop: 7 cycleSpeed: 3 setCycle: Fwd)
					)
					(= cycles [local0 3])
				else
					(self cue:)
				)
			)
			(1
				(if [local0 3]
					(stag setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if [local0 3]
					(= local6 2)
					(if [local0 2]
						(stag loop: 4 cel: 7 cycleSpeed: 1 setCycle: Beg self)
					else
						(stag loop: 5 cel: 7 cycleSpeed: 1 setCycle: Beg self)
					)
				else
					(self cue:)
				)
			)
			(3
				(if [local0 2]
					(= local6 4)
					(stag
						loop: 2
						cel: 0
						cycleSpeed: 1
						xStep: 5
						moveSpeed: 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(User canControl: 1)
				(= local6 6)
				(stag
					loop: 1
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo -30 (stag y:) self
				)
			)
			(5
				(User canControl: 1)
				(= local5 0)
				(stag dispose:)
			)
		)
	)
)

(instance stagBolts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(if (== local6 0)
					(= local6 1)
					(stag setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(cond
					((== local6 1)
						(= local6 3)
						(if [local0 2]
							(stag
								loop: 4
								cel: 7
								cycleSpeed: 1
								setCycle: Beg self
							)
						else
							(stag
								loop: 5
								cel: 7
								cycleSpeed: 1
								setCycle: Beg self
							)
						)
					)
					((== local6 2)
						(= local6 3)
						(if [local0 2]
							(stag setCycle: Beg self)
						else
							(stag setCycle: Beg self)
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(cond
					([local0 2]
						(cond
							((== local6 3)
								(= local6 5)
								(stag
									loop: 2
									cel: 0
									cycleSpeed: 1
									xStep: 5
									moveSpeed: 1
									setCycle: End self
								)
							)
							((== local6 4)
								(= local6 5)
								(stag setCycle: End self)
							)
							(else
								(self cue:)
							)
						)
					)
					((== local6 3)
						(= local6 5)
						(self cue:)
					)
				)
			)
			(3
				(if (== local6 5)
					(stag
						view: 80
						setLoop: 1
						illegalBits: 0
						cel: 0
						setStep: 2 2
						setCycle: CT 2 1 self
					)
				else
					(self cue:)
				)
			)
			(4
				(User canControl: 1)
				(if (== local6 5)
					(stag
						setStep: 10 9
						setCycle: Fwd
						setMotion: MoveTo -200 (stag y:) self
					)
				else
					(self cue:)
				)
			)
			(5
				(if (< (stag x:) -30)
					(self cue:)
				)
			)
			(6
				(stag dispose:)
			)
		)
	)
)

(instance stag of TargActor
	(properties
		view 78
	)

	(method (getHurt)
		(+= global271 global272)
		(= global272 0)
		(HighPrint 77 5) ; "The stag looks more surprised than hurt."
	)

	(method (doit)
		(= local4 (gEgo distanceTo: self))
		(if (!= script stagBolts)
			(cond
				([local0 2]
					(if (< local4 175)
						(self setScript: stagBolts)
					)
				)
				((< local4 120)
					(self setScript: stagBolts)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (MouseClaimed self event 3) (Said 'look,look/buck,buck'))
			(event claimed: 1)
			(switch local6
				(0
					(HighPrint 77 6) ; "The beautiful white stag is foraging for food."
				)
				(5
					(HighPrint 77 7) ; "The white stag takes a mighty leap."
				)
				(else
					(HighPrint 77 8) ; "You seem to have startled the white stag."
				)
			)
		)
	)
)

(instance southBush of PV
	(properties
		y 207
		x 158
		view 700
		loop 2
		cel 1
		priority 15
	)
)

