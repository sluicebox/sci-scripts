;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use LarryRoom)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
	impressSoap 1
)

(instance rm270 of LarryRoom
	(properties
		noun 1
		picture 270
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 115 59 115 125 134 125 143 116 154 116 162 124 184 124 184 59
					yourself:
				)
		)
		(gGlobalSound1 number: 270 play: setLoop: -1)
		(gEgo
			normalize: 271
			setSpeed: 6
			setLoop: 0
			posn: 148 123
			setScale: Scaler 100 54 128 123
			init:
		)
		(super init: &rest)
		(ladderFtr init:)
		(poolFtr init:)
		(buildingFtr init:)
		(platform init:)
		(gWalkHandler addToFront: poolFtr)
		(self setScript: egoEnters)
	)

	(method (dispose)
		(gWalkHandler delete: poolFtr)
		(super dispose:)
	)
)

(instance impressSoap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(soapInset init:)
				(= seconds 2)
			)
			(1
				(gMessager say: 27 50 12 1 2 self 85) ; "Good idea. That lifeguard will never notice you making an impression of his key in your bar of soap from this height!"
			)
			(2
				(soapInset setLoop: 1)
				(= seconds 3)
			)
			(3
				(gGame changeScore: 10 173)
				(soapInset setLoop: 2)
				(= seconds 3)
			)
			(4
				(soapInset dispose:)
				(= cycles 2)
			)
			(5
				(gMessager say: 27 50 12 3 self 85) ; "(PUNCH LINE) It's a good thing something around here knows how to leave a good impression."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo
					setSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 148 128 self
				)
			)
			(2
				(gEgo
					setCycle: 0
					setScale: 0
					setLoop: -1
					loop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo
					normalize: 270
					setSpeed: 6
					setMotion: MoveTo 148 100 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeADive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 148 62 self)
			)
			(1
				(gEgo
					view: 271
					setSpeed: 12
					loop: 2
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo setCycle: CT 5 1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(sFx number: 271 loop: 1 play: self)
			)
			(7
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance soapInset of View
	(properties
		x 273
		y 99
		view 273
	)
)

(instance ladderFtr of Feature
	(properties
		x 149
		y 127
		noun 2
		approachX 149
		approachY 115
	)

	(method (init)
		(super init:)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 123 140 138 128 140 125 146 120 153 120 158 125 159 129 171 140
					yourself:
				)
			approachVerbs: 4 ; Do
		)
	)
)

(instance poolFtr of Feature
	(properties
		x 148
		y 48
		noun 4
		approachX 148
		approachY 57
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 132 33 173 32 172 53 128 53
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(gCurRoom setScript: takeADive)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance buildingFtr of Feature
	(properties
		noun 3
	)

	(method (onMe param1)
		(= x (param1 x:))
		(= y (param1 y:))
		(return (super onMe: param1))
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 0 40 33 60 51 94 98 112 93 135 124 135 173 134 209 136 203 80 234 55 247 51 262 21 292 0 319 0 319 144 0 144
					yourself:
				)
		)
	)
)

(instance platform of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 110 55 110 125 134 125 143 116 154 116 162 124 192 124 192 55
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sFx of Sound
	(properties)
)

