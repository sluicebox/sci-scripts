;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Feature)
(use ScaleTo)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm800 0
)

(local
	[local0 131] = [2 1 0 3 4 4 0 0 0 5 1 0 1 10 1 1 -1 8 1 1 -1 8 1 1 1 8 1 1 1 14 1 1 -1 9 1 1 -6 5 1 2 -7 0 1 3 -12 -1 1 3 -10 1 1 3 -12 1 1 3 -7 -1 1 3 -5 -6 0 0 0 -7 3 1 1 -5 3 1 -1 -9 3 1 1 -11 3 1 -1 -10 3 1 1 -5 3 1 1 -5 3 1 -1 -4 3 1 -1 -5 3 1 5 -5 2 2 9 0 2 3 9 1 2 3 10 -1 2 3 15 1 2 3 5 -1 2 3 2 1 2 3 -99 -99 2]
	[local131 40]
	local171
	local172
	local173
	local174 = 1
	local175 = 1
	local176
	local177
	local178
)

(procedure (localproc_0 param1 param2 &tmp [temp0 2] temp2 temp3)
	(if (+ [local131 0] [local131 1])
		(Graph grDRAW_LINE [local131 0] [local131 1] [local131 0] [local131 1] 0 8 -1)
	)
	(for ((= temp2 2)) (< temp2 39) ((+= temp2 2))
		(= [local131 (- temp2 2)] [local131 temp2])
		(= [local131 (- temp2 1)] [local131 (+ temp2 1)])
		(if (+ [local131 (- temp2 2)] [local131 (- temp2 1)])
			(= temp3 (+ 8 (* (/ temp2 10) 2)))
			(Graph
				grDRAW_LINE
				[local131 (- temp2 2)]
				[local131 (- temp2 1)]
				[local131 (- temp2 2)]
				[local131 (- temp2 1)]
				temp3
				8
				-1
			)
		)
	)
	(= [local131 38] param2)
	(= [local131 39] param1)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4)
	(switch [local0 (+ (* local171 4) 3)]
		(0
			(= temp0 (- (LaserBeam x:) 3))
			(= temp2 (+ (LaserBeam x:) 3))
			(= temp1 (+ (LaserBeam y:) 3))
			(= temp3 (- (LaserBeam y:) 3))
		)
		(1
			(= temp1 (LaserBeam y:))
			(= temp3 (LaserBeam y:))
			(= temp0 (- (LaserBeam x:) 3))
			(= temp2 (+ (LaserBeam x:) 3))
		)
		(2
			(= temp0 (- (LaserBeam x:) 3))
			(= temp2 (+ (LaserBeam x:) 3))
			(= temp1 (- (LaserBeam y:) 3))
			(= temp3 (+ (LaserBeam y:) 3))
		)
		(3
			(= temp0 (LaserBeam x:))
			(= temp2 (LaserBeam x:))
			(= temp1 (- (LaserBeam y:) 3))
			(= temp3 (+ (LaserBeam y:) 3))
		)
	)
	(Graph grDRAW_LINE temp1 temp0 temp3 temp2 -1 8 -1)
	(= temp0 (LaserBeam x:))
	(= temp1 (LaserBeam y:))
	(= temp2 (LaserBeam x:))
	(= temp3 (LaserBeam y:))
	(Graph grDRAW_LINE temp1 temp0 temp3 temp2 -1 8 -1)
)

(procedure (localproc_2)
	(= local173 [local0 (* local171 4)])
	(= local172 [local0 (+ (* local171 4) 1)])
	(= local175 (if (< local173 0) -1 else 1))
	(= local174 (if (< local172 0) -1 else 1))
	(= local173 (Abs local173))
	(= local172 (Abs local172))
	(return (== (++ local171) 32))
)

(procedure (localproc_3)
	(if (and (not local172) (not local173))
		(return (localproc_2))
	else
		(if local172
			(-- local172)
			(LaserBeam y: (+ (LaserBeam y:) local174))
		)
		(if local173
			(-- local173)
			(LaserBeam x: (+ (LaserBeam x:) local175))
		)
		(localproc_0 (LaserBeam x:) (LaserBeam y:))
		(return 0)
	)
)

(procedure (localproc_4)
	(gGame handsOn:)
	(gTheIconBar disable: 0 3 4)
)

(instance rm800 of Rm
	(properties
		noun 4
		picture 49
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Cutting_Torch
				(if (gCast contains: tDoor)
					(gMessager say: noun 30 2 0) ; "You might obtain better results if you opened the pod door, first."
				else
					(gCurRoom setScript: cutTheHole)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(doorSwitch init: stopUpd:)
		(light init: stopUpd:)
		(super init: &rest)
		(Load rsVIEW 699)
		(Load rsPIC 49)
		(RingThatHideBurn init:)
		(InsideWallPiece init: stopUpd:)
		(tDoor init:)
		(bDoor init:)
		(goliathHullF init: setOnMeCheck: 26505)
		(if (not (gEgo has: 7)) ; Cutting_Torch
			(gMessager say: 6 0 0 0) ; "You find yourself in quite a predicament. You have no means for cutting through the Goliath's hull and to return to your ship would require the Eureka to decloak insuring the death of your crew. DANG!"
			(EgoDead 51) ; "You are dead, someone else will have to carry the torch you left behind."
		else
			(localproc_4)
		)
	)
)

(instance cutTheHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local176 1)
				(SetScore 197 100)
				(localproc_2)
				(GunInHand init: setStep: 10 10 setMotion: MoveTo 129 76 self)
			)
			(1
				(gSq5Music2 number: 606 loop: -1 play:)
				(Load rsPIC 49)
				(LaserBeam init:)
				(= local176 0)
				(= cycles 1)
			)
			(2
				(if (not (localproc_3))
					(localproc_1)
					(-- state)
				)
				(= ticks 1)
			)
			(3
				(gSq5Music2 stop:)
				(= local176 1)
				(gCurRoom drawPic: (gCurRoom picture:) 100)
				(LaserBeam dispose:)
				(RingThatHideBurn dispose:)
				(GunInHand setMotion: MoveTo 60 86)
				(InsideWallPiece
					setScale: ScaleTo 125
					setStep: 10 10
					setMotion: MoveTo 159 82 self
				)
			)
			(4
				(InsideWallPiece setMotion: MoveTo 159 160 self)
			)
			(5
				(gSq5Music2 number: 517 loop: 1 play:)
				(GunInHand dispose:)
				(InsideWallPiece dispose:)
				(gEgo put: 7) ; Cutting_Torch
				(gMessager say: 5 0 0 0 self) ; "Having expended the laser torch's power pack cutting through the Goliath's super hard hull, you decide to leave the spent and bulky tool in the EVA pod."
			)
			(6
				(if (not (IsFlag 68))
					(gSq5Music1 number: 20 loop: -1 play:)
				)
				(= seconds 2)
			)
			(7
				(if (not (IsFlag 68))
					(= next youDie)
					(self dispose:)
				else
					(SetScore 196 50)
					(gCurRoom newRoom: 1000)
				)
			)
		)
	)
)

(instance youDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(goon1 init: setMotion: MoveTo 142 109 self)
			)
			(2
				(goon2 init: setMotion: MoveTo 137 79 self)
			)
			(3
				(goon3 init: setMotion: MoveTo 180 71 self)
			)
			(4
				(gSq5Music1 fade: 0 10 5 self)
			)
			(5
				(EgoDead 32) ; "Some space hero you are! Sheesh, you couldn't adventure yourself out of a damp cellulose container without third-party intervention!"
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(light setCycle: End)
				(doorSwitch setCycle: End)
				(gSq5Music2 number: 106 loop: 1 play:)
				(tDoor setMotion: MoveTo (tDoor x:) -50 self)
				(bDoor setMotion: MoveTo (bDoor x:) 153 self)
			)
			(1)
			(2
				(doorSwitch stopUpd:)
				(light stopUpd:)
				(tDoor dispose:)
				(bDoor dispose:)
				(localproc_4)
				(self dispose:)
			)
		)
	)
)

(instance RingThatHideBurn of View
	(properties
		x 121
		y 48
		noun 2
		view 699
		loop 4
		priority 7
		signal 16400
	)

	(method (doVerb)
		(if (gCast contains: tDoor)
			(tDoor doVerb: &rest)
		else
			(goliathHullF doVerb: &rest)
		)
	)
)

(instance LaserBeam of Actor
	(properties
		x 181
		y 50
		yStep 3
		view 699
		cel 1
		priority 13
		signal 26640
		moveSpeed 5
	)

	(method (init)
		(super init: &rest)
		(FireBall init: setCycle: Fwd)
	)

	(method (dispose)
		(FireBall dispose:)
		(super dispose: &rest)
	)
)

(instance FireBall of Prop
	(properties
		x 190
		y 55
		view 699
		loop 2
		cel 1
		priority 15
		signal 26640
		cycleSpeed 4
	)

	(method (doit)
		(self x: (LaserBeam x:) y: (LaserBeam y:))
		(super doit: &rest)
	)
)

(instance InsideWallPiece of Actor
	(properties
		x 159
		y 85
		noun 2
		yStep 40
		view 699
		loop 6
		priority 6
		signal 26640
		xStep 10
		moveSpeed 0
	)

	(method (doVerb theVerb)
		(if (gCast contains: tDoor)
			(tDoor doVerb: theVerb &rest)
		else
			(goliathHullF doVerb: theVerb &rest)
		)
	)
)

(instance GunInHand of Actor
	(properties
		x 61
		y 96
		yStep 10
		view 699
		priority 14
		signal 26640
		xStep 10
		moveSpeed 0
	)

	(method (doit)
		(if (not local176)
			(self x: (- (LaserBeam x:) 52) y: (+ (LaserBeam y:) 26))
		)
		(super doit: &rest)
	)
)

(instance tDoor of Actor
	(properties
		x 98
		y 23
		noun 3
		yStep 5
		view 699
		loop 5
		cel 1
		priority 8
		signal 26640
		xStep 10
		moveSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Cutting_Torch
				(gMessager say: noun theVerb 2 0) ; "You might obtain better results if you opened the pod door, first."
			)
			(4 ; Do
				(gMessager say: noun theVerb 0 0) ; "That's not the way to go about opening the door."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bDoor of Actor
	(properties
		x 98
		y 92
		noun 3
		yStep 5
		view 699
		loop 5
		priority 8
		signal 26640
		xStep 10
		moveSpeed 0
	)

	(method (doVerb)
		(tDoor doVerb: &rest)
	)
)

(instance goon1 of Actor
	(properties
		x 117
		y 130
		view 699
		loop 1
		priority 6
		signal 26640
		moveSpeed 12
	)
)

(instance goon2 of Actor
	(properties
		x 115
		y 79
		view 699
		loop 1
		cel 1
		signal 26640
		moveSpeed 12
	)
)

(instance goon3 of Actor
	(properties
		x 203
		y 71
		view 699
		loop 1
		cel 2
		signal 26640
		moveSpeed 12
	)
)

(instance doorSwitch of Prop
	(properties
		x 234
		y 77
		noun 1
		view 699
		loop 7
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Cutting_Torch
				(gMessager say: noun theVerb 0 0) ; "Burning the door controls to a crisp will not accomplish anything useful."
			)
			(4 ; Do
				(if (not local178)
					(= local178 1)
					(gCurRoom setScript: openDoor)
				else
					(gMessager say: noun theVerb 1 0) ; "The door is already open."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light of Prop
	(properties
		x 132
		y 7
		view 699
		loop 8
		priority 15
		signal 16
	)
)

(instance goliathHullF of Feature
	(properties
		x 158
		y 2
		noun 2
		nsTop 42
		nsLeft 112
		nsBottom 143
		nsRight 204
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Cutting_Torch
				(if (gCast contains: tDoor)
					(gMessager say: noun 30 2 0) ; MISSING MESSAGE
				else
					(gCurRoom setScript: cutTheHole)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

