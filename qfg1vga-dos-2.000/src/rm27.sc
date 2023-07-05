;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use Actor)
(use System)

(public
	rm27 0
)

(instance rm27 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		encChance 20
		entrances 10
		illBits -28672
	)

	(method (dispose)
		(SetFlag 17)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(Load rsVIEW 700)
		(Load rsVIEW 702)
		(SL enable:)
		(NormalEgo)
		(northBush addToPic:)
		(southBush addToPic:)
		(snow1 addToPic:)
		(snow2 addToPic:)
		(snow3 addToPic:)
		(snow4 addToPic:)
		(snow5 addToPic:)
		(snow6 addToPic:)
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

(instance snow1 of View
	(properties
		x 310
		y 8
		view 702
	)
)

(instance snow2 of View
	(properties
		x 310
		y 38
		view 702
		loop 1
		priority 15
		signal 16400
	)
)

(instance snow3 of View
	(properties
		x 240
		y 44
		view 702
		loop 2
		priority 15
		signal 16400
	)
)

(instance snow4 of View
	(properties
		x 239
		y 80
		view 702
		loop 3
		signal 16400
	)
)

(instance snow5 of View
	(properties
		x 253
		y 126
		view 702
		loop 4
		signal 16400
	)
)

(instance snow6 of View
	(properties
		x 313
		y 58
		view 702
		loop 4
		cel 1
		priority 15
		signal 16400
	)
)

