;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 505)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm505 0
	kristyTalker 1
)

(local
	local0 = 20
	local1
	local2
	local3
)

(instance rm505 of Room
	(properties
		picture 505
	)

	(method (init)
		(if (gPqFlags test: 29)
			(PalVary 8 505) ; PalVaryNewSource
		)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 56 134 75 154 156 164 152 140 199 140 215 158 319 157 167 125 138 129 115 123 106 117 100 109 94 109 92 118 76 121 76 129
					yourself:
				)
		)
		(soundScript init:)
		(if (not (gPqFlags test: 32))
			(gGlobalSound0 number: 1028 setLoop: -1 play:)
		)
		(if (== gPrevRoomNum 500)
			(gEgo
				x: 140
				y: 170
				setHeading: 0
				normalize: 0
				setScaler: Scaler 90 41 152 108
				init:
			)
			(self setScript: sEnter)
		else
			(gEgo
				x: 93
				y: 105
				setHeading: 180
				normalize: 0
				intensity: local0
				setScaler: Scaler 90 41 152 108
				init:
			)
			(if (not (gPqFlags test: 32))
				(kristy init: setCycle: Fwd)
				(barry init: setScript: doMusic)
			)
			(self setScript: fadeEnter)
		)
		(super init: &rest)
		(flowerPots init:)
		(grass init:)
		(building init:)
		(otherBuilding init:)
		(sidewalk init:)
		(sky init:)
		(banner init:)
		(moreFlowers init:)
	)

	(method (dispose)
		(PalVary 3) ; PalVaryKill
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((<= (gEgo y:) 112)
				(gGlobalSound0 fade: 0 4 2 1)
				(gCurRoom newRoom: 510)
			)
			((or (>= (gEgo y:) 152) (<= (gEgo x:) 5))
				(gCurRoom newRoom: 17) ; MapRoom
			)
		)
	)
)

(instance barry of Prop
	(properties
		noun 7
		x 156
		y 134
		view 505
		loop 1
		cycleSpeed 12
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)
)

(instance kristy of Prop
	(properties
		noun 1
		x 97
		y 140
		scaleX 108
		scaleY 108
		view 506
		scaleSignal 1
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)

	(method (doit)
		(= cycleSpeed (+ global112 2))
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame points: 4)
			(bildenEncounter cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance kristyTalker of Narrator
	(properties
		x 40
		y 15
		modeless 2
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 140 150 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (init)
		(gTheDoits add: self)
		(= state -1)
		(self cue:)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(switch (Random 1 3)
						(1 905)
						(2 906)
						(3 907)
					)
				)
				(sFx number: temp0 setLoop: 1 play: self)
			)
			(1
				0
				(= state -1)
				(= seconds (Random 5 60))
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
	)
)

(instance sFx of Sound
	(properties)
)

(instance doMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 number: 505 setLoop: 1 play: hold: 1)
			)
			(1
				(gGlobalSound0 number: 508 setLoop: 1 play: self)
			)
			(2
				(gGlobalSound0 number: 507 play: hold: 1)
			)
		)
	)
)

(instance moveRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: End self)
				(= cycles 6)
			)
			(1
				(kristy setCycle: End self)
				(barry setCycle: End self)
			)
			(2)
			(3)
			(4
				(kristyTalker x: 100)
				(if (<= local3 local2)
					(gMessager say: 1 0 3 local3 self)
					(++ local3)
				else
					(gMessager sayRandom: 1 0 3 self)
				)
			)
			(5
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 200 400))
			)
			(1
				(if (not (bildenEncounter script:))
					(if (<= local3 local2)
						(gMessager say: 1 0 3 local3 self)
						(++ local3)
					else
						(gMessager sayRandom: 1 0 3 self)
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance shoved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kristy setCycle: End self)
			)
			(1
				(kristy loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 100 165 self)
			)
			(1
				(gEgo setHeading: 45)
			)
		)
	)
)

(instance moveLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: Beg self)
				(= cycles 6)
			)
			(1
				(kristy setCycle: Beg self)
				(barry setCycle: Beg self)
			)
			(2)
			(3)
			(4
				(kristyTalker x: 40)
				(if (<= local3 local2)
					(gMessager say: 1 0 3 local3 self)
					(++ local3)
				else
					(gMessager sayRandom: 1 0 3 self)
				)
			)
			(5
				(= local1 1)
				(if (not register)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance bildenEncounter of Script
	(properties)

	(method (init)
		(gWalkHandler addToFront: self)
		(= local1 1)
		(super init: &rest)
		(= local2 1)
		(while (and 1 (Message msgSIZE 505 1 0 3 local2))
			(++ local2)
		)
		(-- local2)
		(= local3 1)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo looper:) dispose:)
				(gEgo
					view: 9505
					looper: 0
					setLoop: 0 1
					cel: 0
					x: 109
					y: 131
					setCycle: 0
					setScaler: Scaler 96 41 152 108
				)
				(barry loop: 1 cel: 3 cycleSpeed: 12 setCycle: Beg self)
			)
			(1
				(kristy view: 507 loop: 0 cel: 0 x: 106 y: 140 setCycle: 0)
				(= cycles 1)
			)
			(2
				(gMessager say: 1 2 1 0 self) ; "Detective Carey, would you care to make a statement concerning the murder of Officer Hickman?"
			)
			(3
				(kristy setCycle: End self)
			)
			(4
				(kristy view: 507 loop: 1 cel: 0 setScript: nag)
				(gGame handsOn:)
			)
			(5
				(if local1
					(self cue:)
				else
					(self setScript: moveLeft self 1)
				)
			)
			(6
				(gGame handsOff:)
				(kristy setScript: 0 view: 507 loop: 0 cel: 5 x: 106 y: 140)
				(UpdateScreenItem kristy)
				(= cycles 2)
			)
			(7
				(kristy setCycle: Beg)
				(gEgo
					view: 0
					setLoop: 2
					x: 95
					y: 131
					setCycle: Walk
					setScaler: Scaler 90 41 152 108
					setMotion: MoveTo 70 137 self
				)
			)
			(8
				(kristy view: 508 loop: 1 cycleSpeed: 10 x: 72 y: 140)
				(kristy cel: (kristy lastCel:) setCycle: Beg)
				(gEgo
					view: 9506
					loop: 0
					cel: 0
					fixPriority: 1
					priority: (+ (kristy priority:) 1)
					setScaler: Scaler 96 41 152 108
					setCycle: CT 3 1 self
				)
			)
			(9
				(gMessager say: 1 4 0) ; "What do you think you're doing? Hey!"
				(kristy
					view: 508
					loop: 0
					cel: 0
					x: 117
					y: 140
					setScript: shoved
				)
				(barry loop: 2 cel: 0)
				(gEgo setCycle: End self)
				(doMusic cue:)
			)
			(10
				(barry setCycle: End self)
				(gEgo
					heading: 180
					normalize: 0
					setScaler: Scaler 135 41 192 108
					setScript: walkOut
				)
			)
			(11
				(kristyTalker x: 100)
				(gMessager say: 1 2 4 0 self) ; "The physical abuse I have just experienced at the hands of Detective Carey is consistent with the treatment I have received from the entire department in trying to report this story."
			)
			(12
				(proc0_4 0)
				(gCurRoom newRoom: 17) ; MapRoom
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(cond
				((< (event x:) (gEgo x:))
					(if (not local1)
						(self setScript: moveLeft)
					)
				)
				(local1
					(self setScript: moveRight)
				)
			)
			(event claimed: 1)
			(return)
		)
		(event claimed: 0)
	)
)

(instance fadeEnter of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and register state)
			(if (<= register 112)
				(if (!= register (gEgo y:))
					(+= local0 10)
					(= register (gEgo y:))
					(gEgo setIntensity: local0 1)
				)
			else
				(= register 0)
				(gEgo setIntensity: 100 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(if (gPqFlags test: 32)
					(= state 3)
					(self cue:)
				else
					(gEgo setIntensity: local0 1)
					(= cycles 1)
				)
			)
			(1
				1
				(gMessager say: 1 2 2 0 self) ; "Last night the LAPD was shaken to its roots as Officer Robert Hickman, Police Officer of the Year, 1992, was found brutally slain in a South Central neighborhood."
			)
			(2
				2
				(barry setCycle: End self)
			)
			(3
				3
				(barry loop: 0 cel: 0 setCycle: End self)
			)
			(4
				4
				(= register (gEgo y:))
				(if (gPqFlags test: 32)
					(gEgo setMotion: MoveTo 101 118 self)
				else
					(barry cycleSpeed: 25 setCycle: Beg)
					(gEgo setMotion: MoveTo 95 131 self)
				)
			)
			(5
				5
				(if (not (gPqFlags test: 32))
					(gPqFlags set: 32)
					(client setScript: bildenEncounter)
				else
					(gGame handsOn:)
					(proc0_4 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance flowerPots of Feature
	(properties
		noun 4
		x 77
		y 130
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 42 107 43 100 53 94 60 92 65 94 69 101 69 105 67 106 70 110 70 127 59 128 51 127 49 118 42 118 42 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 77 94 82 92 86 95 88 99 90 101 88 106 88 108 86 116 72 116 73 99 75 95
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 106 103 107 92 113 92 118 95 122 103 123 114 123 115 108 115 107 113 106 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 126 106 126 100 131 96 136 92 141 97 143 100 143 105 144 115 143 124 136 126 128 125 126 123 125 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 157 109 162 98 167 94 177 94 183 95 179 91 187 95 187 103 192 101 194 107 194 110 189 115 193 116 191 147 184 149 166 148 160 146 161 121 161 114 168 114 161 111
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2) ; Do, Look, Talk
			(super doVerb: theVerb)
		else
			(gMessager say: noun 6 0 0) ; "This is not a garbage can."
		)
	)
)

(instance grass of Feature
	(properties
		noun 5
		x 139
		y 110
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 116 37 116 70 152 0 152
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 139 110 319 112 319 151 141 117
					yourself:
				)
		)
	)
)

(instance building of Feature
	(properties
		noun 2
		x 100
		y 25
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 270 0 273 44 270 47 269 57 215 112 18 116 19 0
					yourself:
				)
		)
	)
)

(instance otherBuilding of Feature
	(properties
		noun 9
		x 278
		y 90
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 278 25 301 18 309 18 319 21 319 95 281 94
					yourself:
				)
		)
	)
)

(instance sidewalk of Feature
	(properties
		noun 8
		x 150
		y 125
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 38 116 121 115 319 151 319 154 72 152
					yourself:
				)
		)
	)
)

(instance sky of Feature
	(properties
		noun 6
		x 150
		y 50
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 18 0 18 52 8 51 8 49 8 46 6 45 0 45
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 177 68 273 44 271 0 319 0 319 21 305 18 302 17 278 24 279 53 277 57 271 64 260 60 252 51 239 55 235 71 230 69 228 65 221 65 208 65 194 68
					yourself:
				)
		)
	)
)

(instance moreFlowers of Feature
	(properties
		noun 4
		x 259
		y 113
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 232 110 242 108 248 102 253 101 259 106 262 108 270 109 274 110 281 108 285 107 290 106 294 104 298 102 303 105 307 107 310 107 314 106 319 106 319 113 266 112 230 113
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2) ; Do, Look, Talk
			(super doVerb: theVerb)
		else
			(gMessager say: noun 6 0 0) ; "This is not a garbage can."
		)
	)
)

(instance banner of Feature
	(properties
		noun 3
		nsLeft 39
		nsTop 48
		nsRight 115
		nsBottom 60
		x 39
		y 60
	)
)

