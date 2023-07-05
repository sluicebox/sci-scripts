;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm19 0
)

(instance rm19 of EncRoom
	(properties
		picture 705
		style 8
		south 26
		west 18
		encChance 30
		entrances 12
	)

	(method (dispose)
		(SetFlag 9)
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
			(18
				(gEgo posn: 0 140 setMotion: MoveTo 320 140)
			)
			(26
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

