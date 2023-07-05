;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm24 0
)

(instance rm24 of EncRoom
	(properties
		picture 700
		style 8
		horizon 90
		north 16
		east 25
		south 35
		west 23
		encChance 30
	)

	(method (dispose)
		(SetFlag 14)
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
			(16
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(23
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(35
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
			(25
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
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

