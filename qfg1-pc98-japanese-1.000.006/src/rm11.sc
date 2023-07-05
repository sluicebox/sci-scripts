;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm11 0
)

(instance rm11 of EncRoom
	(properties
		picture 704
		style 8
		east 12
		south 17
		encChance 30
		entrances 6
	)

	(method (dispose)
		(SetFlag 1)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(NormalEgo)
		(self setLocales: 804)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(12
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(17
				(gEgo posn: 275 188 setMotion: MoveTo 275 0)
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

