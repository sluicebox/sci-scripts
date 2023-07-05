;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm36 0
)

(instance rm36 of EncRoom
	(properties
		picture 701
		style 8
		horizon 90
		north 25
		south 53
		west 35
		encChance 20
		entrances 13
		illBits -16384
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 26)
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
			(25
				(gEgo posn: 180 91 setMotion: MoveTo 180 190)
			)
			(35
				(gEgo posn: 0 140 setMotion: MoveTo 320 140)
			)
			(53
				(gEgo posn: 160 189 setMotion: MoveTo 160 0)
			)
		)
		(eastBush ignoreActors: setPri: 6 init: addToPic:)
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
				(HighPrint 36 0) ; "Have I been here before?"
			)
		)
	)
)

(instance eastBush of View
	(properties
		y 160
		x 285
		view 700
		loop 1
	)
)

