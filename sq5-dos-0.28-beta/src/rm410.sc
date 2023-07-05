;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use PAvoider)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm410 0
	sUseComm 20
)

(local
	local0
	[local1 3]
)

(instance theMusic3 of Sound
	(properties)
)

(instance rm410 of Rm
	(properties
		noun 12
		picture 80
	)

	(method (init)
		(LoadMany rsVIEW 450 0 2)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 291 101 290 98 264 98 236 104 211 113 232 127 260 139 219 142 142 141 124 144 124 141 124 138 165 134 177 128 154 125 146 119 161 114 173 112 191 113 200 106 169 106 157 109 155 112 98 119 78 119 78 127 39 131 0 133 0 137 115 137 114 144 62 149 3 160 61 162 222 152 262 174 319 176 319 132 265 132 240 124 239 117 241 112 258 105 290 102
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 130 121 132 128 104 128 111 121
					yourself:
				)
		)
		(theOffPath init:)
		(theGreenhouse init: setOnMeCheck: 1 32)
		(theBuilding1 init:)
		(theBuilding2 init:)
		(theBuilding3 init:)
		(theBuilding4 init:)
		(theLandingPad init:)
		(theMoon init:)
		(theTools init: setOnMeCheck: 1 128)
		(theRocks init: setOnMeCheck: 1 4096)
		(super init: &rest)
		(gWalkHandler addToFront: theGreenhouse)
		(gEgo view: 0)
		(switch gPrevRoomNum
			(400
				(gCurRoom style: 11 setScript: sRoomInit)
			)
			(420
				(gSq5Music2 setVol: 127)
				(gCurRoom style: 10 setScript: sRoomInit)
				(if (IsFlag 101)
					(NormalEgo 0 2)
					(gEgo init: setScale: Scaler 34 34 163 99 x: 92 y: 120)
				else
					(NormalEgo 0 2)
					(gEgo init: setScale: Scaler 34 34 163 99 x: 123 y: 115)
				)
			)
			(else
				(= local0 1)
				(LoadMany rsVIEW 500 30 0)
				(gCurRoom style: 10 setScript: sBeamIn)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (StepOn gEgo 4) (not (gCurRoom script:)))
			(= global131 2)
			(gCurRoom newRoom: 400)
		)
		(if (and (StepOn gEgo 2) (not (gCurRoom script:)))
			(gGame handsOff:)
			(gCurRoom newRoom: 400)
		)
		(if (and (StepOn gEgo 256) (not (gCurRoom script:)))
			(SetFlag 100)
			(gCurRoom newRoom: 400)
		)
		(if (and (StepOn gEgo 8) (not (gCurRoom script:)))
			(switch global131
				(0
					(gCurRoom setScript: sGotoTop)
				)
				(1
					(gCurRoom setScript: sGotoBottom)
				)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: theGreenhouse)
		(super dispose: &rest)
	)
)

(instance sRoomInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(heat init:)
				(heat2 init:)
				(heat3 init:)
				(metal init:)
				(plastic init:)
				(tumweed init: setScript: sTumbleweed)
				(if (== local0 0)
					(switch global131
						(0
							(NormalEgo 0 2)
							(gEgo
								init:
								setScale: Scaler 100 48 163 99
								x: 123
								y: 115
							)
							(= cycles 1)
						)
						(1
							(if (IsFlag 100)
								(NormalEgo 0 1)
								(gEgo
									init:
									setScale: Scaler 100 48 163 99
									x: 325
									y: 101
									setPri: -1
									setMotion: MoveTo 257 100 self
								)
								(ClearFlag 100)
							else
								(NormalEgo 0 1)
								(gEgo
									init:
									setScale: Scaler 100 48 163 99
									x: (+ (gEgo x:) 320)
									y: (gEgo y:)
									setPri: -1
									setMotion: MoveTo 278 150 self
								)
							)
						)
						(2
							(= global131 1)
							(NormalEgo 0 1)
							(gEgo
								init:
								setScale: Scaler 100 48 163 99
								x: 0
								y: 155
								setMotion: MoveTo 50 155 self
							)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 5)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(if (!= client sBeamIn)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sUseComm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 14 setLoop: 0 cel: 0 setCycle: End self)
				(theMusic3 number: 603 loop: 1 play:)
			)
			(1
				(gMessager say: 2 32 0 0 self 401) ; "This is Eureka, go ahead Captain Wilco."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo 0)
				(gEgo loop: 2)
				(= seconds 1)
			)
			(4
				(gEgo view: 6 setLoop: 0 cel: 15 setCycle: Beg self)
				(theMusic3 number: 260 loop: 1 play:)
			)
			(5
				(gSq5Music1 fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sGotoBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setLoop: 3 setPri: 8 setMotion: MoveTo 125 188 self)
			)
			(1
				(NormalEgo 0)
				(gEgo
					setPri: 8
					setScale: Scaler 34 34 163 99
					setMotion: MoveTo 105 136 self
				)
			)
			(2
				(gEgo setPri: -1)
				(= global131 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGotoTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 8 loop: 2 setMotion: MoveTo 125 170 self)
			)
			(1
				(gEgo
					hide:
					setPri: 8
					setScale: Scaler 100 48 163 99
					setCycle: 0
					setLoop: -1
				)
				(= seconds 2)
			)
			(2
				(gEgo
					show:
					view: 0
					x: 138
					y: 188
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 131 149 self
				)
			)
			(3
				(NormalEgo 0)
				(gEgo setPri: -1 setHeading: 180)
				(= cycles 2)
			)
			(4
				(= global131 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBeamIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 30 loop: -1 play: 0 fade: 127 25 10 0)
				(gSq5Music2 number: 450 loop: -1 play:)
				(= global131 1)
				(self setScript: sRoomInit self)
			)
			(1
				(SetScore 218 5)
				(gGame handsOff:)
				(if (not (IsFlag 76))
					(droole init: setScript: sDrooleBeamIn)
				)
				(gEgo
					init:
					view: 500
					setLoop: 0
					cel: 0
					x: 239
					y: 122
					setScale: Scaler 100 48 163 99
					setCycle: End self
				)
				(theMusic3 number: 260 setLoop: 1 play:)
			)
			(2
				(NormalEgo 0 1)
				(gEgo x: 239 y: 122 setPri: -1 setAvoider: PAvoider)
				(= seconds 3)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrooleBeamIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 76)
				(SetFlag 97)
				(= cycles 1)
			)
			(1
				(droole
					init:
					view: 500
					setLoop: 3
					cel: 0
					x: 225
					y: 112
					setScale: Scaler 100 48 163 99
					setCycle: End self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(gMessager say: 1 0 0 0 self) ; "This may be dangerous, Captain. Let's split up so we can cover more territory."
			)
			(4
				(droole
					view: 30
					x: 225
					y: 112
					setCycle: Walk
					setLoop: Grooper
					setHeading: 90
					loop: 0
					setMotion: MoveTo 250 110 self
				)
			)
			(5
				(droole setMotion: MoveTo 299 120 self)
			)
			(6
				(SetFlag 76)
				(SetFlag 97)
				(droole dispose:)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sGreenhouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== global131 1)
					(gEgo setMotion: PolyPath 124 141 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== global131 1)
					(self setScript: sGotoBottom self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 123 118 self)
			)
			(3
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance sTumbleweed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(tumweed init: setMotion: MoveTo 293 129 self)
			)
			(2
				(tumweed setMotion: MoveTo 266 126 self)
			)
			(3
				(tumweed setMotion: MoveTo 245 136 self)
			)
			(4
				(tumweed setMotion: MoveTo 222 144 self)
			)
			(5
				(tumweed setMotion: MoveTo 195 135 self)
			)
			(6
				(tumweed setMotion: MoveTo 168 130 self)
			)
			(7
				(tumweed setMotion: MoveTo 144 139 self)
			)
			(8
				(tumweed setMotion: MoveTo 121 145 self)
			)
			(9
				(tumweed setMotion: MoveTo 30 149 self)
			)
			(10
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance droole of Actor
	(properties
		x 225
		y 112
		view 30
		loop 8
		cel 1
	)
)

(instance skyline of Prop ; UNUSED
	(properties
		x 194
		y 61
		view 450
		detailLevel 2
	)

	(method (init)
		(self setLoop: 0 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance heat of Prop
	(properties
		x 129
		y 81
		view 450
		loop 1
		detailLevel 2
	)

	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance heat2 of Prop
	(properties
		x 156
		y 81
		view 450
		loop 2
		detailLevel 2
	)

	(method (init)
		(self setLoop: 2 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance heat3 of Prop
	(properties
		x 206
		y 81
		view 450
		loop 3
		detailLevel 2
	)

	(method (init)
		(self setLoop: 3 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance metal of Prop
	(properties
		x 89
		y 55
		view 450
		loop 5
		detailLevel 2
	)

	(method (init)
		(self setLoop: 5 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance plastic of Prop
	(properties
		x 111
		y 101
		view 450
		loop 6
		detailLevel 2
	)

	(method (init)
		(self setLoop: 6 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance tumweed of Actor
	(properties
		x 330
		y 115
		noun 15
		view 450
		loop 4
		priority 14
		signal 16384
	)

	(method (init)
		(self x: 330 y: 115 setPri: 10 setLoop: 4 setCycle: Fwd cycleSpeed: 8)
		(super init: &rest)
	)
)

(instance theGreenhouse of Feature
	(properties
		x 123
		y 113
		noun 7
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sGreenhouse)
			)
			(4 ; Do
				(gCurRoom setScript: sGreenhouse)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theOffPath of Feature
	(properties
		x 100
		y 25
		nsBottom 109
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== global131 0)
					(gMessager say: 10 1 0 0) ; "You see nothing of interest."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theBuilding1 of Feature
	(properties
		x 24
		y 100
		noun 2
		nsTop 101
		nsLeft 24
		nsBottom 121
		nsRight 63
	)
)

(instance theBuilding2 of Feature
	(properties
		y 28
		noun 3
		nsTop 78
		nsLeft 187
		nsBottom 104
		nsRight 210
	)
)

(instance theBuilding3 of Feature
	(properties
		y 28
		noun 4
		nsTop 84
		nsLeft 148
		nsBottom 105
		nsRight 166
	)
)

(instance theBuilding4 of Feature
	(properties
		y 28
		noun 5
		nsTop 64
		nsLeft 13
		nsBottom 84
		nsRight 32
	)
)

(instance theLandingPad of Feature
	(properties
		y 28
		noun 8
		nsTop 108
		nsLeft 155
		nsBottom 123
		nsRight 190
	)
)

(instance theMoon of Feature
	(properties
		y 28
		noun 9
		nsTop 12
		nsLeft 167
		nsBottom 79
		nsRight 245
	)
)

(instance theTools of Feature
	(properties
		y 28
		noun 14
		onMeCheck 128
	)
)

(instance theRocks of Feature
	(properties
		x 160
		y 200
		noun 16
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 16 1 0 (Random 1 3) 0)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

