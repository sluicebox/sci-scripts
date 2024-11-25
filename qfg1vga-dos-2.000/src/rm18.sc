;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use Actor)
(use System)

(public
	rm18 0
)

(instance rm18 of EncRoom
	(properties
		picture 702
		style 8
		encChance 30
		entrances 10
		illBits -28672
	)

	(method (dispose)
		(SetFlag 8)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(Load rsVIEW 700)
		(SL enable:)
		(NormalEgo)
		(gEgo illegalBits: $9000)
		(northBush addToPic:)
		(southBush addToPic:)
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

(instance northBush of View
	(properties
		x 85
		y 35
		noun 1
		view 700
		loop 2
	)
)

(instance southBush of View
	(properties
		x 111
		y 167
		noun 2
		view 700
		loop 3
		priority 15
	)
)

