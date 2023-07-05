;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Actor)
(use System)

(public
	rm81 0
)

(instance rm81 of EncRoom
	(properties
		noun 2
		picture 703
		style 8
		horizon 61
		encChance 20
	)

	(method (dispose)
		(SetFlag 71)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(NormalEgo)
		(hollowLog init: stopUpd:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance hollowLog of View
	(properties
		x 228
		y 85
		noun 1
		view 181
		priority 3
		signal 16
	)
)

