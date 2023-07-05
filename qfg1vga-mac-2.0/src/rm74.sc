;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm74 0
)

(instance rm74 of EncRoom
	(properties
		picture 700
		style 8
		horizon 65
		encChance 15
		ambushX 100
		ambushY 120
	)

	(method (dispose)
		(SetFlag 64)
		(super dispose:)
	)

	(method (doVerb)
		(return 0)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(Load rsVIEW 67)
		(SL enable:)
		(NormalEgo)
		(theEyes setPri: 5 init: stopUpd: setScript: peekABooScript)
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

(instance peekABooScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 6 25))
			)
			(1
				(theEyes setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance theEyes of Prop
	(properties
		x 305
		y 67
		view 67
		loop 6
		cycleSpeed 3
	)
)

