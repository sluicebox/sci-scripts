;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm56 0
)

(instance rm56 of EncRoom
	(properties
		picture 701
		style 8
		horizon 90
		north 42
		east 57
		south 66
		west 54
		encChance 15
		entrances 7
	)

	(method (dispose)
		(SetFlag 46)
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
				(gEgo posn: 180 92 setMotion: MoveTo 180 190)
			)
			(54
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(57
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(66
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
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

