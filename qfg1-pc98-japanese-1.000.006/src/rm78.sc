;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use LoadMany)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm78 0
)

(local
	local0
	[local1 4]
	local5
	local6
	local7
	local8
)

(instance rm78 of Rm
	(properties
		picture 700
		style 8
		horizon 90
		north 71
		east 79
		south 84
		west 77
	)

	(method (dispose)
		(SetFlag 68)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (< (gEgo y:) 140) (IsFlag 204))
			(ClearFlag 204)
			(gCurRoom setScript: antwerped)
		)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(cond
			((and (not (IsFlag 197)) (not global332))
				(SetFlag 202)
				(= global332 0)
			)
			((and (IsFlag 198) (not global332))
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
		(if (IsFlag 204)
			(Load rsSCRIPT 970)
			(LoadMany rsVIEW 590 85)
			(LoadMany rsSOUND (SoundFX 9) (SoundFX 10) (SoundFX 11))
			(antFalls number: (SoundFX 9) loop: 1 init:)
			(antSplats number: (SoundFX 10) loop: 1 init:)
			(babyBoing number: (SoundFX 11) loop: 1 init:)
		)
		(if
			(and
				(not gNight)
				(not (IsFlag 204))
				(!= gPrevRoomNum 77)
				(IsFlag 202)
			)
			(Load rsVIEW 78)
			(= [local1 0] (Random 90 116))
			(= [local1 1] (Random 132 154))
			(= [local1 2] (Random 0 1))
			(= [local1 3] (Random 1 30))
			(stag
				view: 78
				x: [local1 0]
				y: [local1 1]
				setScript: stagScript
				init:
			)
		else
			(ClearFlag 202)
		)
		(switch gPrevRoomNum
			(71
				(gEgo posn: 140 92 setMotion: MoveTo 140 121)
			)
			(77
				(gEgo posn: 1 140 setMotion: MoveTo 40 140)
			)
			(84
				(gEgo posn: 160 188 setMotion: MoveTo 160 154)
			)
			(79
				(gEgo posn: 318 140 setMotion: MoveTo 234 140)
			)
		)
		(= local6 0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(HighPrint 78 0) ; "You detect a strange, magical aura in this place."
								)
							)
							(20
								(if (CastSpell temp0)
									(CastDazzle)
									(HighPrint 78 1) ; "Your spell has no effect."
								)
							)
							(23
								(cond
									((not (gCast contains: stag))
										(event claimed: 0)
									)
									((CastSpell temp0)
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
						(= temp1 (if (gCast contains: stag) stag else 0))
						(if (and (ThrowKnife temp1) (gCast contains: stag))
							(SetFlag 203)
							(LookAt gEgo stag)
							(RedrawCast)
						)
					)
					((Said 'throw/boulder')
						(= temp1 (if (gCast contains: stag) stag else 0))
						(if (and (ThrowRock temp1) (gCast contains: stag))
							(SetFlag 203)
							(LookAt gEgo stag)
							(RedrawCast)
						)
					)
					((Said 'japaneseclimbup,climb,climb,ride,ride/buck')
						(if (IsFlag 202)
							(HighPrint 78 2) ; "He's beyond your reach."
						else
							(HighPrint 78 3) ; "Huh?"
						)
					)
					((Said 'look,look/buck,buck')
						(HighPrint 78 4) ; "You don't see a stag here."
					)
					((Said 'attack,kill,hit,cut,chop/buck')
						(if (IsFlag 202)
							(SetFlag 203)
							(HighPrint 78 5) ; "The stag seems to be magically protected."
						else
							(CantDo)
						)
					)
					((Said 'look,look/antwerp,baby,baby')
						(if (> (gCast size:) 2)
							(HighPrint 78 6) ; "You seem to have caused an Antwerp POPulation EXPLOSION!"
						else
							(HighPrint 78 7) ; "You see no Antwerps here."
						)
					)
					(
						(Said
							'play,capture,kill,hit,get,get,attack,attack,attack/antwerp,baby,baby'
						)
						(if (> (gCast size:) 2)
							(HighPrint 78 8) ; "The bouncing baby Antwerps are all so cute, you can't bring yourself to interfere with their playing."
						else
							(HighPrint 78 7) ; "You see no Antwerps here."
						)
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
				(if [local1 3]
					(= local6 0)
					(if [local1 2]
						(stag loop: 6 cycleSpeed: 3 setCycle: Fwd)
					else
						(stag loop: 7 cycleSpeed: 3 setCycle: Fwd)
					)
					(= cycles [local1 3])
				else
					(self cue:)
				)
			)
			(1
				(if [local1 3]
					(stag setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if [local1 3]
					(= local6 2)
					(if [local1 2]
						(stag loop: 4 cel: 7 cycleSpeed: 1 setCycle: Beg self)
					else
						(stag loop: 5 cel: 7 cycleSpeed: 1 setCycle: Beg self)
					)
				else
					(self cue:)
				)
			)
			(3
				(if [local1 2]
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
					setMotion: MoveTo -40 (stag y:) self
				)
			)
			(5
				(User canControl: 1)
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
						(if [local1 2]
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
						(if [local1 2]
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
					([local1 2]
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
						setMotion: MoveTo -50 (stag y:) self
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
		(HighPrint 78 9) ; "The stag looks more surprised than hurt."
		(if (!= script stagBolts)
			(self setScript: stagBolts)
		)
	)

	(method (doit)
		(= local5 (gEgo distanceTo: self))
		(if (!= script stagBolts)
			(cond
				([local1 2]
					(if (< local5 175)
						(self setScript: stagBolts)
					)
				)
				((< local5 120)
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
					(HighPrint 78 10) ; "The beautiful white stag is foraging for food."
				)
				(5
					(HighPrint 78 11) ; "The white stag takes a mighty leap."
				)
				(else
					(HighPrint 78 12) ; "You seem to have startled the white stag."
				)
			)
		)
	)
)

(instance antwerp of Act
	(properties
		yStep 16
		view 590
		xStep 2
	)
)

(instance antwerped of Script
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said '[<at,around][/!*,forest,greenery,clearing]')
						(if (> (gCast size:) 2)
							(HighPrint 78 6) ; "You seem to have caused an Antwerp POPulation EXPLOSION!"
						else
							(event claimed: 0)
						)
					)
					((Said 'look,look,search/')
						(LowPrint 78 13) ; "Looking up, you can see a small, blue dot in the sky, getting bigger... and bigger... and BIGGER!"
					)
					((Said 'use,lift,lift,draw/blade,dagger,weapon')
						(if (self state:)
							(LowPrint 78 14) ; "Too late!"
						else
							(= local0 1)
							(gCurRoom setScript: splat)
						)
					)
					((Said 'cast/')
						(LowPrint 78 15) ; "There's no time for that!"
					)
					((or (Said 'escape/') (Said 'run[/!*]'))
						(LowPrint 78 16) ; "Where to? There is no escaping the hurtling blue blob."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 204)
				(antFalls play:)
				(User canControl: 0)
				(gEgo
					setMotion: 0
					view: 85
					setLoop: 1
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(User canControl: 0)
				(antwerp
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 2
					cel: 0
					setCycle: 0
					posn: 90 -30
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 4) self
				)
			)
			(2
				(antFalls stop:)
				(antSplats play:)
				(gEgo
					view: 85
					cel: 0
					setLoop: 2
					setCel: -1
					cycleSpeed: 1
					setCycle: Fwd
				)
				(antwerp setCycle: End self)
			)
			(3
				(antwerp setCycle: Beg setMotion: MoveTo 270 0)
				(= cycles 80)
			)
			(4
				(EgoDead ; "You're obviously in no shape to continue the game."
					78
					17
					80
					{Trounced by a bounce!}
					82
					800
					0
					0
				)
			)
		)
	)
)

(instance antFalls of Sound
	(properties
		priority 8
	)
)

(instance antSplats of Sound
	(properties
		priority 9
	)
)

(instance babyBoing of Sound
	(properties
		priority 12
	)
)

(instance a1 of Act
	(properties
		yStep 4
		view 590
		xStep 4
	)

	(method (doit)
		(if (== (self cel:) 0)
			(babyBoing loop: 1 play:)
		)
		(super doit:)
	)
)

(instance a2 of Act
	(properties
		yStep 4
		view 590
		xStep 4
	)
)

(instance a3 of Act
	(properties
		yStep 4
		view 590
		xStep 4
	)
)

(instance a4 of Act
	(properties
		yStep 4
		view 590
		xStep 4
	)
)

(instance a5 of Act
	(properties
		yStep 4
		view 590
		xStep 4
	)
)

(instance splat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo view: 85 setLoop: 0 cycleSpeed: 0 setCycle: End self)
			)
			(1
				(antwerp
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 2
					cel: 0
					setCycle: 0
					posn: 90 -30
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 12) self
				)
			)
			(2
				(antSplats play:)
				(gEgo setCycle: Beg self)
				(SetFlag 206)
				(antwerp setLoop: 5 setCycle: End)
			)
			(3
				(= local7 (gEgo x:))
				(= local8 (gEgo y:))
				(antwerp
					setLoop: 5
					cel: 0
					setStep: 4 4
					posn: local7 local8
					setMotion: MoveTo local7 (+ local8 16)
					cycleSpeed: 1
					setCycle: End
				)
				(a1
					setLoop: 6
					posn: local7 local8
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (+ local7 16) (+ local8 22) self
				)
				(a2
					setLoop: 7
					posn: local7 local8
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (- local7 10) (- local8 10)
				)
				(a3
					setLoop: 6
					posn: local7 local8
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (+ local7 8) (+ local8 15)
				)
				(if (> gHowFast 0)
					(a4
						setLoop: 7
						posn: local7 local8
						ignoreActors:
						init:
						setCycle: Fwd
						setMotion: MoveTo (- local7 14) (- local8 5)
					)
					(a5
						setLoop: 6
						posn: local7 local8
						ignoreActors:
						init:
						setCycle: Fwd
						setMotion: MoveTo (+ local7 16) (- local8 10)
					)
				)
			)
			(4
				(a1 ignoreActors: 0 setMotion: Wander)
				(a2 ignoreActors: 0 setMotion: Wander)
				(a3 ignoreActors: 0 setMotion: Wander)
				(if (> gHowFast 0)
					(a4 ignoreActors: 0 setMotion: Wander)
					(a5 ignoreActors: 0 setMotion: Wander)
				)
				(NormalEgo)
				(User canControl: 1 canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

