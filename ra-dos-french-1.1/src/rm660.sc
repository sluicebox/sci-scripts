;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use PChase)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm660 0
)

(local
	local0
)

(instance rm660 of LBRoom
	(properties
		picture 660
		south 460
	)

	(method (doit)
		(cond
			(script)
			((StepOn gEgo 16)
				(gEgo edgeHit: EDGE_BOTTOM)
			)
		)
		(super doit:)
	)

	(method (init)
		(LoadMany rsVIEW 660 423 661 858 424)
		(LoadMany rsSOUND 662 661 660)
		(LoadMany rsSCRIPT 94 2660)
		(if (== gAct 5)
			(self setRegions: 94) ; PursuitRgn
			(gCurRoom obstacles: (List new:))
			((ScriptID 2660 0) doit: (gCurRoom obstacles:)) ; poly2660Code
		else
			(self setRegions: 90) ; MuseumRgn
			(MuseumRgn loadPolyList:)
		)
		(gEgo init: setScale: 125 normalize: 426)
		(super init:)
		(crank init: stopUpd:)
		(wall1 init: stopUpd:)
		(wall2 init: stopUpd:)
		(walls init:)
		(floor init:)
		(ceiling init:)
		(trash init:)
		(southExitFeature init:)
		(self setScript: sEnterElevator)
	)

	(method (notify)
		(if (== gAct 5)
			(if (gCurRoom script:)
				((gCurRoom script:) next: sDie)
			else
				(gCurRoom setScript: sDie)
			)
		)
	)

	(method (dispose)
		(DisposeScript 2660)
		(super dispose: &rest)
	)
)

(instance sDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
				(gEgo setMotion: MoveTo 160 120 self)
			)
			(1
				(oriley
					init:
					setScale: 125
					setCycle: Walk
					setMotion: PChase gEgo 22 self
				)
			)
			(2
				(oriley view: 424)
				(oriley cel: 0)
				(Face gEgo oriley)
				(Face oriley gEgo)
				(= cycles 4)
			)
			(3
				(oriley setCycle: End self)
			)
			(4
				(thudSound play:)
				(gEgo view: 858 setCycle: End self)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sGoingDown of Script
	(properties)

	(method (doit)
		(super doit:)
		(switch state
			(5
				(gEgo
					scaleY: (+ (gEgo scaleY:) 2)
					scaleX: (- (gEgo scaleX:) 2)
				)
			)
			(6
				(gEgo
					scaleY: (- (gEgo scaleY:) 2)
					scaleX: (+ (gEgo scaleX:) 2)
				)
			)
			(10
				(gEgo
					scaleY: (- (gEgo scaleY:) 3)
					scaleX: (+ (gEgo scaleX:) 4)
				)
			)
			(11
				(gEgo
					scaleY: (+ (gEgo scaleY:) 3)
					scaleX: (- (gEgo scaleX:) 4)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 94 1) dispose: delete:) ; pursuitTimer
				(gEgo setMotion: PolyPath 165 117 self)
			)
			(1
				(gEgo view: 661 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(crank setCycle: End self)
				(gGameMusic2 number: 661 flags: 1 loop: 1 play:)
			)
			(3
				(gGameMusic1 number: 660 flags: 1 loop: 1 play:)
			)
			(4
				(crank stopUpd:)
				(gEgo
					normalize: 426
					setHeading: 180
					scaleSignal: 1
					maxScale: 256
				)
				(gGameMusic2 number: 662 flags: 1 loop: -1 play:)
				(wall1 setCycle: Fwd)
				(wall2 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(= cycles 10)
			)
			(6
				(= cycles 10)
			)
			(7
				(= seconds 2)
			)
			(8
				(wall1 cycleSpeed: (+ (wall1 cycleSpeed:) 1))
				(wall2 cycleSpeed: (+ (wall1 cycleSpeed:) 1))
				(= seconds 1)
			)
			(9
				(if (< (wall1 cycleSpeed:) 8)
					(self changeState: 8)
				else
					(wall1 setCycle: End)
					(wall2 setCycle: End)
					(= cycles 1)
				)
			)
			(10
				(= cycles 10)
			)
			(11
				(= cycles 10)
			)
			(12
				(gGameMusic2 stop:)
				(gGame handsOn:)
				(wall1 stopUpd:)
				(wall2 stopUpd:)
				(gCurRoom south: 700)
				(self dispose:)
			)
		)
	)
)

(instance sEnterElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 160 200 setHeading: 0 setMotion: MoveFwd 80 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		x 160
		y 180
		view 423
	)
)

(instance crank of Prop
	(properties
		x 189
		y 80
		noun 1
		view 661
		loop 1
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(gMessager say: 1 4 4) ; "The rusty lever is stuck."
				else
					(gCurRoom setScript: sGoingDown)
					(= local0 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall1 of Prop
	(properties
		x 106
		y 125
		view 660
		cycleSpeed 0
	)
)

(instance wall2 of Prop
	(properties
		x 217
		y 125
		view 660
		cycleSpeed 0
	)
)

(instance walls of Feature
	(properties
		x 162
		y 8
		noun 2
		onMeCheck 8
	)
)

(instance floor of Feature
	(properties
		x 162
		y 8
		noun 5
		onMeCheck 32
	)
)

(instance ceiling of Feature
	(properties
		x 162
		y 8
		noun 4
		onMeCheck 4
	)
)

(instance trash of Feature
	(properties
		x 6
		y 60
		noun 3
		sightAngle 40
		onMeCheck 2
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 122
		nsLeft 125
		nsBottom 189
		nsRight 202
		cursor 11
		exitDir 3
		noun 6
	)
)

(instance thudSound of Sound
	(properties
		flags 5
		number 80
	)
)

