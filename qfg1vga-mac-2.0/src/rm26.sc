;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
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
		horizon 60
		encChance 20
		entrances 7
		illBits -16384
	)

	(method (dispose)
		(SetFlag 16)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(Load rsVIEW 700)
		(SL enable:)
		(NormalEgo)
		(westBush setPri: 7 ignoreActors: init: addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 480 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance westBush of View
	(properties
		y 59
		noun 1
		view 700
		loop 4
	)
)

