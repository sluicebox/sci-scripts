;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm34 0
)

(instance rm34 of EncRoom
	(properties
		picture 700
		style 8
		horizon 90
		north 23
		east 35
		south 51
		west 33
		encChance 20
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 24)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(23
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(33
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(51
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
			(35
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed gEgo event 3)
				(HighPrint 34 0) ; "Our hero looks really lost."
			)
		)
	)
)

