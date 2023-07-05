;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Encounter)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm33 0
)

(instance tromp of Sound
	(properties
		number 66
		priority 1
	)
)

(instance rm33 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		north 22
		east 34
		south 45
		encChance 35
		entrances 7
		illBits -16384
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 23)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 700)
		(if (== gPrevRoomNum 22)
			(Load rsSOUND (SoundFX 66))
		)
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(22
				(if (IsFlag 172)
					(HandsOff)
				)
				(gEgo posn: 130 91 setMotion: MoveTo 130 190)
			)
			(34
				(gEgo posn: 319 140 setMotion: MoveTo 0 140)
			)
			(45
				(gEgo posn: 120 189 setMotion: MoveTo 120 0)
			)
		)
		(westBush setPri: 7 ignoreActors: init: addToPic:)
		(if (and (IsFlag 172) (not (IsFlag 173)))
			(ClearFlag 172)
			(self setScript: hutUp)
		)
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
				(HighPrint 33 0) ; "My feet are killing me."
			)
		)
	)
)

(instance westBush of View
	(properties
		y 176
		x 24
		view 700
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
				(tromp number: (SoundFX 66) init: play:)
				(ShakeScreen 3)
				(= cycles 5)
			)
			(2
				(HighPrint 33 1) ; "You feel the sound of dainty footsteps behind you."
				(self cue:)
			)
			(3
				(= cycles 5)
			)
			(4
				(tromp play:)
				(ShakeScreen 3)
				(ClearFlag 172)
				(HandsOn)
				(rm33 setScript: 0)
			)
		)
	)
)

