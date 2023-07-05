;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Encounter)
(use LoadMany)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm85 0
)

(local
	local0
	local1
	local2
)

(instance rm85 of EncRoom
	(properties
		picture 701
		style 8
		horizon 90
		east 86
		west 84
		encChance 30
		entrances 10
		illBits -28672
	)

	(method (dispose)
		(SetFlag 75)
		(DisposeScript 970)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (> (gEgo x:) 140) (IsFlag 204))
			(ClearFlag 204)
			(gCurRoom setScript: antwerped)
		)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 700)
		(if (IsFlag 204)
			(Load rsSCRIPT 970)
			(gCurRoom encChance: 0)
			(LoadMany rsVIEW 590 85)
			(LoadMany rsSOUND (SoundFX 9) (SoundFX 10) (SoundFX 11))
			(antFalls number: (SoundFX 9) loop: 1 init:)
			(antSplats number: (SoundFX 10) loop: 1 init:)
			(babyBoing number: (SoundFX 11) loop: 1 init:)
		)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(84
				(gEgo posn: 1 140 setMotion: MoveTo 32 140)
			)
			(86
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
		)
		(gAddToPics add: northBush southBush eachElementDo: #init doit:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global105 (gEgo x:))
			(= global106 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look[/!*,forest,greenery,clearing]')
						(if (> (gCast size:) 2)
							(HighPrint 85 0) ; "You seem to have caused an Antwerp POPulation EXPLOSION!"
						else
							(event claimed: 0)
						)
					)
					((Said 'look/antwerp,baby')
						(if (> (gCast size:) 2)
							(HighPrint 85 0) ; "You seem to have caused an Antwerp POPulation EXPLOSION!"
						else
							(HighPrint 85 1) ; "You see no Antwerps here."
						)
					)
					(
						(Said
							'capture,kill,hit,get,attack,fight,play/antwerp,baby'
						)
						(if (> (gCast size:) 2)
							(HighPrint 85 2) ; "The bouncing baby Antwerps are all so cute, you can't bring yourself to interfere with their playing."
						else
							(HighPrint 85 1) ; "You see no Antwerps here."
						)
					)
				)
			)
		)
	)
)

(instance northBush of PV
	(properties
		y 82
		x 194
		view 700
		loop 2
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

(instance antwerp of Act
	(properties
		yStep 20
		view 590
		xStep 8
	)
)

(instance antwerped of Script
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,search/')
						(LowPrint 85 3) ; "Looking up, you can see a small, blue dot in the sky, getting bigger... and bigger... and BIGGER!"
					)
					((Said 'use,lift,draw/blade,dagger,weapon')
						(if (self state:)
							(LowPrint 85 4) ; "Too late!"
						else
							(= local0 1)
							(gCurRoom setScript: splat)
						)
					)
					((Said 'cast/')
						(LowPrint 85 5) ; "There's no time for that!"
					)
					((Said 'run,escape/')
						(LowPrint 85 6) ; "Where to? There is no escaping the hurtling blue blob."
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
				(EgoDead 85 7 80 {Trounced by a bounce!} 82 800 0 0) ; "You're obviously in no shape to continue the game."
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
		priority 10
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
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(antwerp
					setLoop: 5
					cel: 0
					setStep: 4 4
					posn: local1 local2
					setMotion: MoveTo local1 (+ local2 16)
					cycleSpeed: 1
					setCycle: End
				)
				(a1
					setLoop: 6
					posn: local1 local2
					ignoreActors:
					init:
					setCycle: Fwd
					illegalBits: 0
					setMotion: MoveTo (+ local1 16) (+ local2 22) self
				)
				(a2
					setLoop: 7
					posn: local1 local2
					ignoreActors:
					init:
					setCycle: Fwd
					illegalBits: 0
					setMotion: MoveTo (- local1 10) (- local2 10)
				)
				(a3
					setLoop: 6
					posn: local1 local2
					ignoreActors:
					init:
					setCycle: Fwd
					illegalBits: 0
					setMotion: MoveTo (+ local1 8) (+ local2 15)
				)
				(if (> gHowFast 0)
					(a4
						setLoop: 7
						posn: local1 local2
						ignoreActors:
						init:
						setCycle: Fwd
						illegalBits: 0
						setMotion: MoveTo (- local1 14) (- local2 5)
					)
					(a5
						setLoop: 6
						posn: local1 local2
						ignoreActors:
						init:
						setCycle: Fwd
						illegalBits: 0
						setMotion: MoveTo (+ local1 16) (- local2 10)
					)
				)
			)
			(4
				(a1 ignoreActors: 0 illegalBits: -32768 setMotion: Wander)
				(a2 ignoreActors: 0 illegalBits: -32768 setMotion: Wander)
				(a3 ignoreActors: 0 illegalBits: -32768 setMotion: Wander)
				(if (> gHowFast 0)
					(a4 ignoreActors: 0 illegalBits: -32768 setMotion: Wander)
					(a5 ignoreActors: 0 illegalBits: -32768 setMotion: Wander)
				)
				(NormalEgo)
				(User canControl: 1 canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

