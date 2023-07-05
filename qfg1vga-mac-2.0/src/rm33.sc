;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm33 0
)

(instance rm33 of EncRoom
	(properties
		picture 702
		style 8
		horizon 56
		encChance 35
		entrances 7
		illBits -16384
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(SetFlag 23)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 700)
		(if (== gPrevRoomNum 22)
			(Load rsSOUND 2066)
		)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(gMouseDownHandler add: self)
		(SL enable:)
		(NormalEgo)
		(westBush setPri: 7 ignoreActors: init: addToPic:)
		(if (and (IsFlag 287) (not (IsFlag 173)))
			(ClearFlag 287)
			(self setScript: hutUp)
		)
		(if
			(not
				(OneOf gPrevRoomNum 420 480 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)

	(method (doit)
		(super doit:)
	)
)

(instance westBush of View
	(properties
		x 11
		y 92
		noun 2
		view 700
		loop 4
	)
)

(instance hutUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(tromp number: 2066 init: play:)
				(ShakeScreen 3)
				(= cycles 5)
			)
			(2
				(gMessager say: 1 0 0 1) ; "You hear the sound of dainty footsteps behind you."
				(self cue:)
			)
			(3
				(= cycles 5)
			)
			(4
				(tromp play:)
				(ClearFlag 287)
				(HandsOn)
				(rm33 setScript: 0)
			)
		)
	)
)

(instance tromp of Sound
	(properties
		number 2066
		priority 1
	)
)

