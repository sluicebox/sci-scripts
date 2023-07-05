;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use dartScript)
(use Encounter)
(use TargActor)
(use n814)
(use Print)
(use Motion)
(use Game)
(use User)
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
		(gEgo illegalBits: -28672)
		(northBush addToPic:)
		(southBush addToPic:)
		(cond
			(
				(not
					(OneOf
						gPrevRoomNum
						420 ; bearArena
						480 ; minotaurArena
						430 ; saurusArena
						435 ; mantrayArena
						440 ; cheetaurArena
						445 ; goblinArena
						455 ; ogreArena
						450 ; trollArena
						460 ; dragonArena
						465 ; brigandArena
						470
					)
				)
				(= global103 (gEgo x:))
				(= global104 (gEgo y:))
			)
			((and (not (IsFlag 107)) (not gNight))
				(unknown_18_3 init: setScript: unknown_18_5)
			)
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

(instance unknown_18_3 of Actor
	(properties
		x 105
		y 180
		view 701
		priority 11
		signal 18448
		cycleSpeed 12
		illegalBits 0
	)
)

(instance unknown_18_4 of TargActor
	(properties
		x 85
		y 175
		view 701
		loop 1
		priority 11
		signal 18448
		cycleSpeed 12
		illegalBits 0
	)

	(method (getHurt)
		(unknown_18_3 setScript: unknown_18_6)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(CastDart self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknown_18_5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(HandsOff)
				(gEgo setMotion: 0)
				(SetFlag 107)
				(unknown_18_3 setCycle: Walk setMotion: MoveTo 150 180 self)
			)
			(2
				(Face gEgo unknown_18_3)
				(unknown_18_3 setMotion: MoveTo 180 185 self)
			)
			(3
				(unknown_18_3 setMotion: MoveTo 250 185 self)
			)
			(4
				(unknown_18_3 setMotion: MoveTo 285 210 self)
				(unknown_18_4 init: setCycle: Walk setMotion: MoveTo 60 150)
			)
			(5
				(unknown_18_4 setMotion: MoveTo 80 175 self)
			)
			(6
				(User canInput: 1)
				(if (gEgo knows: 23)
					(gTheIconBar enable: 6)
				)
				(unknown_18_4 setMotion: MoveTo 205 173 self)
			)
			(7
				(unknown_18_4 cel: 1 y: 171)
				(= seconds 2)
			)
			(8
				(Prints
					{"Shhhh! Be vewy, vewy quiet. I am hunting wabbits. He eh eh eh."}
				)
				(= seconds 2)
			)
			(9
				(unknown_18_4 setMotion: MoveTo 258 207 self)
			)
			(10
				(unknown_18_4 dispose:)
				(HandsOn)
				(client dispose:)
			)
		)
	)
)

(instance unknown_18_6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(unknown_18_4
					setLoop: 2
					cel: 0
					setMotion: 0
					setSpeed: 14
					setCycle: End self
				)
			)
			(1
				(Prints {"Oooooo! I HATE that!!"})
				(unknown_18_4 setMotion: MoveTo (unknown_18_4 x:) 210 self)
			)
			(2
				(unknown_18_4 dispose:)
				(HandsOn)
				(client dispose:)
			)
		)
	)
)

