;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm42 0
)

(instance rm42 of EncRoom
	(properties
		picture 703
		style 8
		horizon 90
		north 26
		east 43
		south 56
		encChance 20
		entrances 7
		illBits -24576
	)

	(method (dispose)
		(SetFlag 32)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 700)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(26
				(gEgo posn: 190 92 setMotion: MoveTo 190 190)
			)
			(43
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(56
				(gEgo posn: 200 188 setMotion: MoveTo 200 0)
			)
		)
		(westBush setPri: 6 ignoreActors: init: addToPic:)
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

(instance westBush of View
	(properties
		y 150
		x 35
		view 700
	)
)

