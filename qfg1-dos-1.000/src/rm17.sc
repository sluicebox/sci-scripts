;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm17 0
)

(instance rm17 of EncRoom
	(properties
		picture 703
		style 8
		horizon 90
		north 11
		east 18
		south 25
		west 16
		encChance 30
	)

	(method (dispose)
		(SetFlag 7)
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
			(11
				(gEgo posn: 188 91 setMotion: MoveTo 190 190)
			)
			(16
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(18
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(25
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

