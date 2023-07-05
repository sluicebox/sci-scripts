;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm80 0
)

(local
	local0
)

(instance bruno of Act
	(properties
		y 140
		x 240
		view 65
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look/bruno') (MouseClaimed self event 3))
				(HighPrint 80 0) ; "This man looks very tough. From his clothing, you guess him to be a member of the Thieves' Guild."
			)
		)
	)
)

(instance knife1 of Act
	(properties
		view 65
	)
)

(instance knife2 of Act
	(properties
		view 65
	)
)

(instance rm80 of EncRoom
	(properties
		picture 701
		style 8
		horizon 90
		north 73
		east 81
		south 86
		west 79
		encChance 20
		entrances 11
		illBits -28672
	)

	(method (dispose)
		(SetFlag 70)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(73
				(gEgo posn: 180 92 setMotion: MoveTo 180 190)
				(= local0 -1)
			)
			(79
				(gEgo posn: 3 140 setMotion: MoveTo 320 140)
				(= local0 -1)
			)
			(81
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
				(= local0 1)
			)
		)
		(gAddToPics add: southBush eachElementDo: #init doit:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global105 (gEgo x:))
			(= global106 (gEgo y:))
		)
		(if (> global334 260)
			(User canInput: 0)
			(self setScript: egoLoses)
		else
			(self setRegions: 210) ; Encounter
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

(instance egoLoses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 1)
					(bruno posn: 90 140)
				)
				(bruno
					init:
					setCycle: Walk
					setMotion: MoveTo (+ (bruno x:) 28) 140 self
				)
			)
			(1
				(HandsOff)
				(bruno
					setLoop: (if (== local0 1) 5 else 6)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(2
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setCycle: Fwd
					posn: (+ (bruno x:) (* local0 41)) (- (bruno y:) 24)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22)
				)
				(bruno setCycle: CT 5 1 self)
			)
			(3
				(bruno setCycle: End)
				(knife2
					illegalBits: 0
					setLoop: 8
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setCycle: Fwd
					posn: (+ (bruno x:) (* 41 local0)) (- (bruno y:) 27)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
				)
				(gEgo setLoop: 1)
			)
			(4
				(knife1 dispose:)
				(knife2 dispose:)
				(gEgo
					view: 516
					setLoop: 3
					cycleSpeed: 1
					setMotion: 0
					setCycle: End
				)
				(= seconds 4)
			)
			(5
				(EgoDead 80 1 82 516 2 5 80 {Timing is everything.}) ; "Done in by poisoned daggers and desperate desperadoes! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

