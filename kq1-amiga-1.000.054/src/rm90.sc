;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm90 0
)

(instance rm90 of Rm
	(properties
		picture 65
	)

	(method (init)
		(LoadMany rsVIEW 18 265 115)
		(LoadMany rsSOUND 17 88 70 95)
		(self style: 5)
		(super init:)
		(gCurRoom setScript: dropIn)
		((ScriptID 0 23) number: 88 loop: -1 playBed:) ; backSound
		(stool init:)
		(door init: cel: (if (IsFlag 15) 3 else 0) setPri: 2 stopUpd:)
		(if (not (IsFlag 77))
			(note setPri: 7 init:)
		)
		(fire init: setCycle: Fwd)
		(bubble init: setCycle: Fwd)
		(smoke setPri: 4 init: setScript: smokeFace)
	)
)

(instance witch of Actor
	(properties
		x 94
		y 85
		view 115
		loop 1
	)
)

(instance fire of Prop
	(properties
		x 43
		y 82
		view 265
	)
)

(instance bubble of Prop
	(properties
		x 62
		y 67
		view 265
		loop 1
	)
)

(instance smoke of Prop
	(properties
		x 62
		y 62
		view 265
		loop 2
		cycleSpeed 1
	)
)

(instance door of Prop
	(properties
		x 119
		y 33
		view 265
		loop 3
		cycleSpeed 2
	)
)

(instance stool of View
	(properties
		x 92
		y 94
		view 265
		loop 5
		cel 2
	)
)

(instance rmCheese of View ; UNUSED
	(properties
		x 112
		y 44
		description {cheese}
		view 265
		loop 5
	)
)

(instance note of View
	(properties
		x 240
		y 98
		view 265
		loop 5
		cel 1
	)
)

(instance smokeFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke loop: 2 setCycle: Fwd)
				(= cycles (Random 50 100))
			)
			(1
				(smoke loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance dropIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 17 init: play:) ; gameSound
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					ignoreHorizon: 1
					view: 18
					init:
					setLoop: 1
					setCycle: 0
					cel: 0
					posn: 161 -3
					setCycle: 0
					setStep: 2 8
					setPri: 2
					setMotion: MoveTo 163 56 self
				)
			)
			(1
				((ScriptID 0 21) number: 95 play:) ; gameSound
				(gEgo cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(2
				(ShakeScreen 6)
				(gEgo setCycle: End)
				(= seconds 3)
			)
			(3
				(Print 90 0) ; "OUCH!"
				((ScriptID 0 21) number: 70 play:) ; gameSound
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(Print 90 1) ; "As the wicked witch flew over her cottage, she dropped you straight through the roof and into her cage. Who knows what sinister plans she has in store for you?"
				(proc0_1)
				(gEgo loop: 2)
				(witch
					init:
					illegalBits: $8000
					setCycle: Walk
					posn: 36 126
					loop: 0
					setMotion: MoveTo 68 122 self
				)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: 95)
			)
		)
	)
)

