;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm80 0
)

(instance rm80 of Rm
	(properties
		picture 80
	)

	(method (init)
		(LoadMany rsVIEW 160 33 117)
		(Load rsPIC 81)
		(self style: 3)
		(super init:)
		(if (IsFlag 2)
			(Print 80 0) ; "You see the goat far, far below you, wandering off to explore Daventry on his own."
			(ClearFlag 2)
		)
		(switch global123
			(1
				(carrier view: 160)
				(gEgo view: 33 loop: 0)
			)
			(2
				(carrier view: 117)
				(gEgo view: 117 loop: 2)
				((ScriptID 0 23) number: 57 loop: -1 playBed:) ; backSound
			)
		)
		(HandsOff)
		(gEgo
			posn: -42 142
			setCycle: Fwd
			cycleSpeed: 2
			setMotion: 0
			setPri: 15
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			setPri: 7
			init:
		)
		(carrier setCycle: Fwd cycleSpeed: 1 setPri: 6 init: setScript: fly)
	)

	(method (doit)
		(super doit: &rest)
		(switch global123
			(1
				(gEgo posn: (carrier x:) (+ (carrier y:) 61))
			)
			(2
				(gEgo posn: (+ (carrier x:) 9) (+ (carrier y:) 26))
			)
		)
	)
)

(instance carrier of Actor
	(properties
		x -42
		y 142
		description {condor}
	)
)

(instance fly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carrier setMotion: DPath 160 100 330 80 self)
			)
			(1
				(gCurRoom picture: 81 style: 3 drawPic: 81)
				(self cue:)
			)
			(2
				(carrier posn: -42 100 setMotion: DPath 160 100 350 150 self)
			)
			(3
				(HandsOn)
				((ScriptID 0 23) loop: 1 fade:) ; backSound
				(gCurRoom
					newRoom:
						(switch global123
							(1 48)
							(2 90)
						)
				)
			)
		)
	)
)

