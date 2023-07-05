;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm43 0
)

(instance rm43 of EncRoom
	(properties
		picture 705
		style 8
		south 57
		west 42
		encChance 20
		entrances 12
	)

	(method (dispose)
		(SetFlag 33)
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
			(42
				(gEgo posn: 0 140 setMotion: MoveTo 320 140)
			)
			(57
				(gEgo posn: 45 189 setMotion: MoveTo 45 0)
			)
		)
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

