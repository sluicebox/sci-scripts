;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use Actor)
(use System)

(public
	rm52 0
)

(instance rm52 of EncRoom
	(properties
		picture 702
		style 8
		horizon 65
		encChance 15
	)

	(method (dispose)
		(SetFlag 42)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init: &rest)
		(SL enable:)
		(NormalEgo)
		(southBush addToPic:)
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

(instance southBush of View
	(properties
		x 111
		y 167
		noun 1
		view 700
		loop 3
		priority 15
	)
)

