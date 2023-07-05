;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm86 0
)

(instance rm86 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		south 92
		west 85
		encChance 100
		entrances 12
		illBits -24576
	)

	(method (dispose)
		(SetFlag 76)
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
			(92
				(gEgo posn: 120 188 setMotion: MoveTo 120 0)
			)
			(85
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
		)
		(northBush init:)
		(gAddToPics add: northBush doit:)
		(eastBush ignoreActors: setPri: 6 init: addToPic:)
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
		y 71
		x 136
		view 700
		loop 2
	)
)

(instance eastBush of View
	(properties
		y 147
		x 278
		view 700
		loop 1
	)
)

