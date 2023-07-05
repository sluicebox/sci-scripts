;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm26 0
)

(instance rm26 of EncRoom
	(properties
		picture 700
		style 8
		horizon 90
		north 19
		east 27
		south 42
		encChance 20
		entrances 7
		illBits -16384
	)

	(method (dispose)
		(SetFlag 16)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 700)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(19
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(42
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
			(27
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
		)
		(westBush setPri: 7 ignoreActors: init: addToPic:)
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

(instance westBush of View
	(properties
		y 167
		x 32
		view 700
	)
)

