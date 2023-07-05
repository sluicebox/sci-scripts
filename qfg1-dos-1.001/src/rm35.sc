;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use System)

(public
	rm35 0
)

(instance rm35 of EncRoom
	(properties
		picture 703
		style 8
		horizon 90
		north 24
		east 36
		south 52
		west 34
		encChance 20
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 25)
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
			(24
				(gEgo posn: 190 92 setMotion: MoveTo 190 190)
			)
			(36
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(34
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(52
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed gEgo event 3)
				(HighPrint 35 0) ; "Our hero looks a little lost."
			)
		)
	)
)

