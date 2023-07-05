;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm18 0
)

(instance rm18 of EncRoom
	(properties
		picture 700
		style 8
		horizon 90
		east 19
		west 17
		encChance 30
		entrances 10
		illBits -28672
	)

	(method (dispose)
		(SetFlag 8)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 700)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(gEgo illegalBits: -28672)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(17
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(19
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
)

(instance northBush of PV
	(properties
		y 86
		x 133
		view 700
		loop 2
	)
)

(instance southBush of PV
	(properties
		y 207
		x 162
		view 700
		loop 2
		cel 1
		priority 15
	)
)

