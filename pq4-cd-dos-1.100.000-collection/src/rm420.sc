;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	local0
)

(instance rm420 of Room
	(properties
		noun 10
		picture 420
		style 0
	)

	(method (doRemap)
		(gGame doRemap: 2 253 70)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(proc0_4 0)
		(gGlobalSound0 number: 430 loop: -1 play:)
		(kids play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 83 241 81 184 83 140 92 81 100 52 105 0 105 0 153 319 154
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 235 109 260 112 237 117 180 118 102 118 90 115 92 112 130 111 173 109
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			setHeading: 90
			normalize: 0
			posn: 100 140 0
			setScaler: Scaler 90 16 145 78
			init:
		)
		(gGame handsOn:)
		(gTheIconBar show: 0)
		(if
			(or
				(and (== gDay 4) (not (gPqFlags test: 42)))
				(and
					(== gDay 5)
					(gPqFlags test: 101)
					(gEgo has: 7) ; glue
					(gEgo has: 30) ; rope
					(gEgo has: 28) ; lighter
					(or
						(and (gEgo has: 8) (gEgo has: 6)) ; mirror, stick
						(gEgo has: 35) ; stickMirror
					)
				)
			)
			(dog init: signal: (| (dog signal:) $4000))
		)
		(farMurder init:)
		(tree init:)
		(park init:)
		(sky0 init:)
		(sky1 init:)
		(treePoly init:)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (gCast contains: dog) (< (gEgo y:) 130))
			(gGame handsOff:)
			(self setScript: cantLeaveScr)
		)
		(if (and (not script) (or (< (gEgo x:) 5) (> (gEgo x:) 314)))
			(gGame handsOff:)
			(self setScript: noExitScr)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 430)
			(gGlobalSound0 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance kids of Sound
	(properties
		number 977
		loop -1
	)
)

(instance treePoly of Feature
	(properties
		x 188
		y 1
	)

	(method (init)
		(self
			createPoly: 146 110 162 105 183 102 193 102 224 110 227 115 208 123 187 128 168 124 146 118
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(self onMe: gEgo)
				(not (gCurRoom script:))
				(not (gCurRoom inset:))
			)
			(gCurRoom setInset: treeInset)
		)
	)
)

(instance farMurder of Feature
	(properties
		noun 9
		x 180
		y 20
	)

	(method (init)
		(self createPoly: 219 117 184 122 149 117 152 107 187 101 218 105)
		(super init: &rest)
	)
)

(instance tree of Feature
	(properties
		noun 8
		x 180
		y 25
	)

	(method (init)
		(self
			createPoly: 14 0 22 10 32 13 57 0 73 6 92 17 103 18 111 0 235 0 232 10 245 19 259 11 287 46 284 57 272 69 269 73 295 72 291 67 306 57 319 59 319 79 264 77 212 81 200 73 196 74 192 78 191 82 181 95 182 113 174 112 177 92 168 80 159 84 138 85 119 85 108 80 76 79 63 90 64 103 58 103 58 92 53 81 38 82 31 91 24 84 0 92 0 0
		)
		(super init: &rest)
	)
)

(instance park of Feature
	(properties
		noun 7
		sightAngle 180
		y 15
	)

	(method (init)
		(self createPoly: 0 10 319 10 319 153 0 154)
		(super init: &rest)
	)
)

(instance sky0 of Feature
	(properties
		noun 11
		sightAngle 180
		y 16
	)

	(method (init)
		(self createPoly: 111 1 105 18 91 17 58 0 34 13 21 9 16 0)
		(super init: &rest)
	)
)

(instance sky1 of Feature
	(properties
		noun 11
		sightAngle 180
		y 16
	)

	(method (init)
		(self
			createPoly: 319 0 319 60 306 57 290 66 294 71 269 73 285 57 287 47 260 11 245 20 233 11 237 0
		)
		(super init: &rest)
	)
)

(instance insetMurderScene of Feature
	(properties
		noun 4
		y 20
	)

	(method (init)
		(self createPoly: 261 43 261 106 206 135 88 134 59 116 59 84 183 32)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; caseBaggies
			(if (gPqFlags test: 42)
				(gMessager say: noun theVerb 3) ; "Carey, there's no evidence to collect at this time."
			else
				(gMessager say: noun theVerb 4) ; "There's no evidence to place in the bag, Detective."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance insetTree of Feature
	(properties
		noun 5
		y 25
	)

	(method (init)
		(self
			createPoly: 189 0 188 15 189 38 192 45 200 50 195 52 176 54 167 50 174 44 178 0
		)
		(super init: &rest)
	)
)

(instance insetPark of Feature
	(properties
		noun 6
		y 15
	)

	(method (init)
		(self createPoly: 261 43 184 31 59 84 60 0 261 0)
		(super init: &rest)
	)
)

(instance treeInset of Inset
	(properties
		picture 425
		style 9
		y 0
		disposeNotOnMe 1
	)

	(method (init)
		(gTheIconBar disable: 3 7 6 show: 0)
		(kids stop:)
		(gEgo setMotion: 0)
		(gGame fade: 100 0 10)
		(super init: &rest)
		(dirt init:)
		(cond
			((not (gPqFlags test: 41))
				(dirt cel: 0)
			)
			((gPqFlags test: 42)
				(dirt cel: 2)
			)
			(else
				(dirt cel: 1)
			)
		)
		(insetMurderScene init:)
		(insetTree init:)
		(insetPark init:)
		(FrameOut)
		(gGame fade: 0 100 10)
		(gGlobalSound0 fade:)
		(gGlobalSound1 number: 425 loop: -1 play:)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 59 (param1 x:) 262) (<= 0 (param1 y:) 135)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 0 3 7 6)
		(super dispose:)
		(gEgo
			x: 126
			y: 120
			heading: 90
			loop: 0
			setScaler: Scaler 90 16 145 78
			normalize: 0
		)
		(UpdateScreenItem gEgo)
		(FrameOut)
		(gGame fade: 0 100 10)
		(kids play:)
		(gGlobalSound1 fade:)
		(gGlobalSound0 number: 430 loop: -1 play:)
	)
)

(instance dirt of Prop
	(properties
		noun 3
		x 143
		y 98
		priority 10
		fixPriority 1
		view 424
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					((gPqFlags test: 42)
						(gMessager say: noun theVerb 5) ; "Removing more dirt does not reveal more bones."
					)
					((gPqFlags test: 41)
						(gMessager say: noun theVerb 4) ; "It looks human. Handle it carefully, Detective."
					)
					(else
						(gMessager say: noun theVerb 0) ; "Removing the dirt reveals a bone."
						(= cel 1)
						(gGame points: 3)
						(gPqFlags set: 41)
					)
				)
			)
			((== theVerb 52) ; notebook
				(if (or (gPqFlags test: 42) (gPqFlags test: 41))
					(gGame points: 2 62)
				)
				(cond
					((and (not (gPqFlags test: 42)) (not (gPqFlags test: 41)))
						(super doVerb: theVerb)
					)
					((gPqFlags test: 42)
						(gMessager say: noun theVerb 5) ; "You record that a bone was found at this location."
					)
					(else
						(gMessager say: noun theVerb 4) ; "You record the location of this find."
					)
				)
			)
			((== theVerb 1) ; Look
				(cond
					((gPqFlags test: 42)
						(gMessager say: noun theVerb 5) ; "There is now a hole in the ground."
					)
					((gPqFlags test: 41)
						(gMessager say: noun theVerb 4) ; "It appears to be a human bone."
					)
					(else
						(gMessager say: noun theVerb 0) ; "The dirt looks freshly tilled."
					)
				)
			)
			((== theVerb 13) ; caseBaggies
				(cond
					((gPqFlags test: 42)
						(gMessager say: noun theVerb 5) ; "Detective, there is no evidence to collect at this time."
					)
					((gPqFlags test: 41)
						(gGame points: 3)
						(gMessager say: noun theVerb 4) ; "Placing the bone in the bag is essential to maintaining the integrity of this potentially valuable evidence."
						(gEgo get: 23) ; boneBaggie
						(= cel 2)
						(gPqFlags set: 42)
					)
					(else
						(gMessager say: noun theVerb 5) ; "Detective, there is no evidence to collect at this time."
					)
				)
			)
			((== theVerb 65) ; caseGlassJar
				(cond
					((gPqFlags test: 42)
						(gMessager say: 3 65 5) ; "Carey, there's no reason to sample the dirt."
						(return 1)
					)
					((gPqFlags test: 41)
						(gMessager say: 3 65 4) ; "Carey, the bone is too big to fit in this jar."
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cantLeaveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dog setScript: barkScr)
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noExitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 160)
					(gEgo
						setMotion:
							PolyPath
							(+ (gEgo x:) 10)
							(gEgo y:)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(- (gEgo x:) 10)
							(gEgo y:)
							self
					)
				)
			)
			(1
				(gMessager say: 0 76 0 0 self) ; "This is no time for a nature walk. You have a case to solve."
			)
			(2
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance dog of Actor
	(properties
		noun 1
		sightAngle 50
		x 192
		y 137
		view 4202
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gGame handsOff:)
				(gCurRoom setScript: touchDogScr)
			)
			((== theVerb 44) ; rope
				(gGame handsOff:)
				(gGame points: 5)
				(gCurRoom setScript: ropeDogScr)
			)
			((OneOf theVerb 31 36) ; shoe, tape
				(gGame handsOff:)
				(gCurRoom setScript: dogSmellScr 0 theVerb)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local0)
						(gMessager say: 1 22 1) ; "The dog is not rabid, Detective. Holster your gun!"
						(++ local0)
					)
					(((ScriptID 32 0) doit: 1 22 2 1 420) 0) ; ShootHandgun
				)
			)
			((== theVerb 32) ; pretzels
				(gGame handsOff:)
				(gCurRoom setScript: givePretzelScr)
			)
			((== theVerb 18) ; mirror
				(gGame handsOff:)
				(gCurRoom setScript: doMirrorScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (gCurRoom script:)) (< (self distanceTo: gEgo) 45))
			(gGame handsOff:)
			(gCurRoom setScript: backOffScr)
		)
	)
)

(instance dogSmellScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo distanceTo: dog) 50)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 144 135 self)
				)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo
					view: 420
					setScaler: Scaler 98 16 145 78
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= cycles 10)
			)
			(4
				(gMessager say: 1 register 0)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 0 setScaler: Scaler 90 16 145 78)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noHeadingMover of Motion
	(properties)

	(method (init param1 param2 param3 param4 &tmp [temp0 3] temp3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(= yLast (= xLast (= completed 0)))
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= temp3 (client cycler:))
			(temp3 cycleCnt: b-moveCnt)
		)
		(InitBresen self)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

(instance backOffScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dog setScript: barkScr)
				(gEgo
					view: 0
					setLoop: 0
					setCycle: Rev
					setMotion:
						noHeadingMover
						(- (gEgo x:) 30)
						(gEgo y:)
						self
				)
			)
			(1
				(gEgo setHeading: 90 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchDogScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo distanceTo: dog) 50)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 144 135 self)
				)
			)
			(1
				(gMessager say: 1 4 0 1 self) ; "Hey, boy... how ya doin'..."
				(gEgo setHeading: 45 self)
			)
			(2)
			(3
				(gEgo
					view: 420
					setScaler: Scaler 98 16 145 78
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(4
				(dog setScript: barkScr)
				(gEgo view: 421 setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(gEgo normalize: 0 setScaler: Scaler 90 16 145 78)
				(gMessager say: 1 4 0 2 self) ; "Careful, Carey, this dog is unfriendly..."
			)
			(6
				(gGame handsOn:)
				(gEgo setScript: scratchScr)
				(self dispose:)
			)
		)
	)
)

(instance scratchScr of Script
	(properties)

	(method (init)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (User canControl:) (& (event type:) evMOUSEBUTTON))
			(self dispose:)
			(event claimed: 0)
			(return)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gGame handsOff:)
				(gEgo
					setScaler: Scaler 98 16 145 78
					view: 422
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo setScaler: Scaler 90 16 145 78 normalize: 0)
				(gGame handsOn:)
				(= seconds 4)
			)
			(4
				(gGame handsOff:)
				(gEgo
					setScaler: Scaler 98 16 145 78
					view: 423
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo setScaler: Scaler 90 16 145 78 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ropeDogScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 128 144 self)
			)
			(1
				(if register
					(gEgo posn: 128 144 0)
					(dog view: 4202 setLoop: 0 cel: 0 posn: 192 147 0)
				)
				(gEgo
					setScaler: Scaler 98 16 145 78
					view: 425
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) 22)
					setCycle: End self
				)
			)
			(2
				(gMessager say: 1 44 0 0) ; "Ya..hoo!"
				(gEgo view: 426 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 1 cel: 3 setPri: 190 setCycle: End self)
				(dog setPri: 200)
			)
			(4
				(dog setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(gEgo setLoop: 2)
				(dog setCycle: CT 6 1 self)
			)
			(6
				(gEgo
					view: 430
					setLoop: 0 1
					cel: 0
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 6)
					setCycle: Walk
					setSpeed: 6
					setStep: 10 2
				)
				(gEgo setMotion: MoveTo (+ (gEgo x:) 200) (gEgo y:))
				(dog setCycle: End self)
				(gGlobalSound0 number: 420 loop: 1 play:)
			)
			(7
				(dog
					view: 4201
					setLoop: 0
					cel: 0
					posn: (+ (dog x:) 79) (+ (dog y:) 5)
					setCycle: Walk
					setSpeed: 6
					setStep: 10 2
				)
				(dog setMotion: MoveTo (+ (dog x:) 200) (dog y:) self)
			)
			(8
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance barkSnd of Sound
	(properties
		number 1017
	)
)

(instance barkScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (OneOf (dog cel:) 5 13)
			(barkSnd play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dog setCycle: End self)
			)
			(1
				(dog cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance givePretzelScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo distanceTo: dog) 50)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 144 135 self)
				)
			)
			(1
				(gEgo
					view: 420
					setScaler: Scaler 98 16 145 78
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gGame points: 2 18)
				(dog setCycle: CT 7 1 self)
			)
			(3
				(if (== gDay 5)
					(dog view: 4202 setLoop: 0 cel: 0)
					(self setScript: egoStandScr self)
				else
					(= cycles 1)
				)
			)
			(4
				(gMessager say: 1 32 0 1) ; "He's hungry!"
				(if (== gDay 5)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setCycle: Beg)
					(dog setLoop: 1 cel: 0 setCycle: End self)
				)
			)
			(5
				(dog
					view: 4201
					posn: (+ (dog x:) 79) (+ (gEgo y:) 4)
					setCycle: Walk
					setSpeed: 6
					setStep: 10 2
				)
				(dog setMotion: MoveTo 350 (dog y:) self)
			)
			(6
				(gEgo
					setScaler: Scaler 90 16 145 78
					heading: 45
					normalize: 0
					put: 21 ; pretzels
				)
				(gGame handsOn:)
				(self dispose:)
				(dog dispose:)
			)
		)
	)
)

(instance egoStandScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					setScaler: Scaler 90 16 145 78
					heading: 45
					normalize: 0
					put: 21 ; pretzels
				)
				(self dispose:)
			)
		)
	)
)

(instance glint of Prop
	(properties
		view 4202
		loop 3
	)
)

(instance doMirrorScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Face gEgo dog self)
			)
			(1
				(if (== (gEgo loop:) 6)
					(= temp0 9033)
					(= temp1 1)
				else
					(= temp0 9030)
					(= temp1 0)
				)
				(gEgo view: temp0 setLoop: temp1 cel: 0)
				(gEgo setCycle: CT 5 1 self)
			)
			(2
				(glint
					init:
					x: (+ (gEgo x:) 26)
					y: (- (gEgo y:) 37)
					setCycle: End self
				)
				(dog
					view: 4202
					setLoop: 2
					cel: 0
					setPri: (+ (dog priority:) 1)
					setCycle: End self
				)
			)
			(3 0)
			(4
				(= cycles 5)
			)
			(5
				(glint setCycle: End self)
				(dog setCycle: End self)
			)
			(6 0)
			(7
				(glint dispose:)
				(gEgo setCycle: Beg self)
			)
			(8
				(if (== gDay 5)
					(dog view: 4202 setLoop: 0 cel: 0)
					(gGame handsOn:)
					(self dispose:)
				else
					(gGame points: 4 19)
					(= cycles 1)
				)
				(gEgo normalize: 0)
			)
			(9
				(gMessager say: 1 18 0 1) ; "The sun reflected into the dogs eyes shoo's him away."
				(dog setLoop: 1 cel: 0 setCycle: End self)
			)
			(10
				(dog
					view: 4201
					posn: (+ (dog x:) 79) (+ (gEgo y:) 4)
					setCycle: Walk
					setSpeed: 6
					setStep: 10 2
				)
				(dog setMotion: MoveTo 350 (dog y:) self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
				(dog dispose:)
			)
		)
	)
)

