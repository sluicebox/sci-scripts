;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm61 0
)

(instance rm61 of EncRoom
	(properties
		picture 700
		style 8
		horizon 90
		north 44
		east 62
		south 69
		west 60
		encChance 15
	)

	(method (dispose)
		(SetFlag 51)
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
			(44
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(60
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(69
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
			(62
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

