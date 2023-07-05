;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm51 0
)

(instance rm51 of EncRoom
	(properties
		picture 703
		style 8
		horizon 90
		north 34
		east 52
		south 63
		west 45
		encChance 15
	)

	(method (dispose)
		(SetFlag 41)
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
			(34
				(gEgo posn: 190 92 setMotion: MoveTo 190 190)
			)
			(52
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(45
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(63
				(gEgo posn: 200 188 setMotion: MoveTo 200 0)
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

