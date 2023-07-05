;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm25 0
)

(instance rm25 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		north 17
		south 36
		west 24
		encChance 30
		entrances 13
		illBits -24576
	)

	(method (dispose)
		(SetFlag 15)
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
			(24
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(17
				(gEgo posn: 130 92 setMotion: MoveTo 130 190)
			)
			(36
				(gEgo posn: 120 188 setMotion: MoveTo 120 0)
			)
		)
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

(instance eastBush of View
	(properties
		y 147
		x 278
		view 700
		loop 1
	)
)

