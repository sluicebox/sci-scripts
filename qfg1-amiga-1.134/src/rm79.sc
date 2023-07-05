;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm79 0
)

(instance rm79 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		north 72
		east 80
		west 78
		encChance 20
		entrances 11
		illBits -28672
	)

	(method (dispose)
		(SetFlag 69)
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
			(80
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(78
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(72
				(gEgo posn: 130 92 setMotion: MoveTo 130 190)
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
		(self setRegions: 210) ; Encounter
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

