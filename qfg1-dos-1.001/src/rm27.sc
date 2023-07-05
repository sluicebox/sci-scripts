;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
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
		east 28
		west 26
		encChance 20
		entrances 10
		illBits -28672
	)

	(method (dispose)
		(SetFlag 17)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 700)
		(Load rsVIEW 702)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(28
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(26
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
		)
		(gAddToPics
			add: northBush southBush snow1 snow2 snow5 snow6 snow7
			eachElementDo: #init
			doit:
		)
		(snow3 setPri: 15 ignoreActors: init: addToPic:)
		(snow4 setPri: 1 ignoreActors: init: addToPic:)
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
		(switch (event type:)
			(evSAID
				(if (and (Said 'look>') (Said '/ice'))
					(HighPrint 27 0) ; "You see snow and feel a cold wind blowing from the east."
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance northBush of PV
	(properties
		y 71
		x 136
		view 700
		loop 2
	)
)

(instance southBush of PV
	(properties
		y 207
		x 153
		view 700
		loop 2
		cel 1
		priority 15
	)
)

(instance snow1 of PV
	(properties
		y 40
		x 263
		view 702
		priority 15
	)
)

(instance snow2 of PV
	(properties
		y 76
		x 256
		view 702
		loop 1
		priority 15
	)
)

(instance snow3 of View
	(properties
		y 134
		x 268
		view 702
		loop 2
	)
)

(instance snow4 of View
	(properties
		y 125
		x 284
		view 702
		loop 3
	)
)

(instance snow5 of PV
	(properties
		y 26
		x 185
		view 702
		loop 4
		priority 15
	)
)

(instance snow6 of PV
	(properties
		y 44
		x 179
		view 702
		loop 4
		cel 1
		priority 15
	)
)

(instance snow7 of PV
	(properties
		y 83
		x 194
		view 702
		loop 5
	)
)

