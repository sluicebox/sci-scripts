;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm860 0
)

(local
	[local0 9]
	local9
	local10
	local11
	local12
)

(class Island of Feature
	(properties
		northView 0
		northLoop 0
		northX 0
		northY 0
		northLandLoop 0
		northLandX 0
		northLandY 0
		southView 0
		southLoop 0
		southX 0
		southY 0
		southLandLoop 0
		southLandX 0
		southLandY 0
	)

	(method (init param1)
		(self setOnMeCheck: 2 param1)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(= local10 (event x:))
		(= local11 (event y:))
		(super handleEvent: event)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(for ((= temp0 0)) (< temp0 9) ((++ temp0))
				(if (== [local0 temp0] self)
					(break)
				)
			)
			(cond
				((== temp0 local9)
					(if (== theVerb 3) ; Walk
						(gEgo setMotion: PolyPath local10 local11)
					else
						(super doVerb: theVerb &rest)
					)
				)
				((and (< temp0 4) (OneOf local9 0 3))
					(gGame handsOff:)
					(gCurRoom setScript: jumpScript 0 (== local9 0))
				)
				((or (> temp0 (+ local9 1)) (< temp0 (- local9 1)))
					(gMessager say: 2 0 5 1) ; "Adam can't get there from here."
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: jumpScript 0 (> temp0 local9))
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(= onMeCheck 0)
		(super dispose:)
	)
)

(instance rm860 of Eco2Room
	(properties
		noun 10
		picture 860
		style 10
		south 840
	)

	(method (init)
		(if (== gPrevRoomNum 870)
			(gEgo
				init:
				setScale: Scaler 70 50 185 125
				view: 13
				setLoop: 9
				cel: 0
				setPri: 1
				posn: 79 136
				hide:
			)
			(self setScript: eagleScript)
		else
			(gGameSound1 number: 862 loop: -1 play:)
			(platform init: setOnMeCheck: 1 32)
			(beach init:)
			(island init: setOnMeCheck: 1 8)
			(foliage init: setOnMeCheck: 1 4096)
			(foliage2 init: setOnMeCheck: 1 4096)
			(mountain init: setOnMeCheck: 1 4)
			(sky init: setOnMeCheck: 1 2)
			(deepWater init:)
			(exitsouth init:)
			(gEgo
				posn: 160 220
				init:
				normalize:
				setScale: Scaler 70 50 185 125
				actions: egoActions
			)
			(self
				setScript: enterScript
				addObstacle:
					(poly0
						type: PContainedAccess
						init: 0 189 215 189 167 181 218 175 182 167 162 162 129 158 74 154 0 152
						yourself:
					)
					(poly1
						type: PContainedAccess
						init: 182 160 198 161 213 164 251 164 271 163 292 161 266 157 245 155 209 155 183 157 176 159
						yourself:
					)
					(poly2
						type: PContainedAccess
						init: 201 145 175 150 181 151 211 152 241 152 249 153 248 148 220 146 210 144
						yourself:
					)
					(poly3
						type: PContainedAccess
						init: 135 146 177 146 188 144 204 141 214 141 214 137 176 133 141 132 102 134 62 135 45 138 33 142 56 146 107 147
						yourself:
					)
					(poly4
						type: PContainedAccess
						init: 174 128 208 128 210 126 205 124 178 124 173 126
						yourself:
					)
					(poly5
						type: PContainedAccess
						init: 151 124 164 123 167 122 161 119 143 118 133 121 135 123
						yourself:
					)
					(poly6
						type: PContainedAccess
						init: 162 111 154 115 179 115 176 111
						yourself:
					)
					(poly7
						type: PContainedAccess
						init: 133 107 121 108 122 110 150 111 150 108 147 107
						yourself:
					)
					(poly8
						type: PContainedAccess
						init: 114 106 125 106 134 103 145 103 150 100 148 98 133 97 114 100 89 100 60 98 43 96 39 97 33 102 59 104 83 108 107 108
						yourself:
					)
					(poly9
						type: PContainedAccess
						init: 132 118 136 115 131 112 112 112 103 115 105 118
						yourself:
					)
			)
			(= [local0 0] (isle0 init: poly0 yourself:))
			(= [local0 1] (isle1 init: poly1 yourself:))
			(= [local0 2] (isle2 init: poly2 yourself:))
			(= [local0 3] (isle3 init: poly3 yourself:))
			(= [local0 4] (isle4 init: poly4 yourself:))
			(= [local0 5] (isle5 init: poly5 yourself:))
			(= [local0 6] (isle6 init: poly6 yourself:))
			(= [local0 7] (isle7 init: poly7 yourself:))
			(= [local0 8] (isle8 init: poly8 yourself:))
			(turtleFeat init:)
			(lake init:)
			(turtle init:)
		)
		(super init:)
		(if (gCurrentRegionFlags test: 2)
			(snake
				init:
				view: 866
				setLoop: 1
				posn: 160 93
				setPri: 5
				ignoreActors: 1
				cycleSpeed: 40
				setCycle: Fwd
				setScript: snoreScript
			)
			(gGameSound2 number: 868 loop: 1)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (> (gEgo y:) 187))
			(gGame handsOff:)
			(self setScript: exitScript)
		)
		(if (not (IsFlag 5))
			(Palette palANIMATE 73 77 -10 78 82 -10)
		)
	)

	(method (newRoom newRoomNumber)
		(gGameSound1 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 938)
		(gWalkHandler delete: lake)
		(super dispose:)
	)
)

(instance ripple of Prop
	(properties
		x 157
		y 95
		view 867
		signal 16384
		cycleSpeed 10
	)
)

(instance sfx of Sound
	(properties)
)

(instance eagleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gEgo show: setCycle: End self)
			)
			(2
				(gEgo normalize: 0 2)
				(= cycles 3)
			)
			(3
				(sfx number: 723 loop: 1 play:)
				(eagle
					init:
					ignoreHorizon: 1
					scaleSignal: (+ (| (eagle scaleSignal:) $0004) 1)
					scaleX: 69
					scaleY: 69
					x: 79
					y: -5
					yStep: 10
					setMotion: MoveTo 79 49 self
				)
			)
			(4
				(eagle dispose:)
				(gEgo view: 862 setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gEgo
					scaleSignal: (+ (| (gEgo scaleSignal:) $0004) 1)
					yStep: 20
					setMotion: MoveTo (gEgo x:) -10 self
				)
			)
			(6
				(gCurRoom newRoom: 880)
			)
		)
	)
)

(instance eagle of Actor
	(properties
		yStep 10
		view 862
	)
)

(instance turtle of Actor
	(properties
		x 111
		y 117
		view 860
		priority 1
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb)
		(turtleFeat doVerb: theVerb)
	)

	(method (doit)
		(super doit:)
		(cond
			((!= (turtleScript state:) 5) 0)
			((turtleScript register:)
				(gEgo x: (+ (turtle x:) 8) y: (- (turtle y:) 1))
			)
			(else
				(gEgo x: (+ (turtle x:) 8) y: (- (turtle y:) 3))
			)
		)
	)
)

(instance turtleFeat of Feature
	(properties
		y 114
		noun 2
	)

	(method (init)
		(self setOnMeCheck: 2 poly9)
		(gWalkHandler addToFront: self)
		(super init:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(= onMeCheck 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(if (not (OneOf local9 5 7))
				(gMessager say: 2 0 5 1) ; "Adam can't get there from here."
			else
				(gGame handsOff:)
				(gCurRoom setScript: turtleScript 0 (== local9 5))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance jumpScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(cond
					((not (snake script:)) 0)
					((gCurrentRegionFlags test: 2) 0)
					((== (snakeScript state:) 0)
						(bumpEgoScript register: 0)
						(snakeScript start: 0)
						(snake dispose:)
					)
					(else
						(snake setScript: submergeSnakeScript)
					)
				)
				(if register
					(= temp0 ([local0 local9] northX:))
					(= temp1 ([local0 local9] northY:))
				else
					(= temp0 ([local0 local9] southX:))
					(= temp1 ([local0 local9] southY:))
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(if register
					(= temp0 ([local0 local9] northView:))
					(= temp1 ([local0 local9] northLoop:))
					(++ local9)
				else
					(= temp0 ([local0 local9] southView:))
					(= temp1 ([local0 local9] southLoop:))
					(-- local9)
				)
				(gEgo view: temp0 setLoop: temp1 cel: 0 setCycle: End self)
			)
			(2
				(if register
					(gEgo
						normalize: 0 ([local0 local9] northLandLoop:)
						posn:
							([local0 local9] northLandX:)
							([local0 local9] northLandY:)
					)
				else
					(gEgo
						normalize: 0 ([local0 local9] southLandLoop:)
						posn:
							([local0 local9] southLandX:)
							([local0 local9] southLandY:)
					)
				)
				(cond
					((gCurrentRegionFlags test: 2) 0)
					((== local9 8)
						(snake init: posn: 100 -100 setScript: snakeScript)
						(if (not (gCurrentRegionFlags test: 11))
							(gCurrentRegionFlags set: 11)
							(gGame points: 5)
						)
					)
					(else
						(snakeScript start: 0)
						(snake dispose:)
					)
				)
				(cond
					((not (OneOf local9 1 2))
						(= cycles 1)
					)
					(register
						([local0 (+ local9 1)] doVerb: 3)
					)
					(else
						([local0 (- local9 1)] doVerb: 3)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turtleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: PolyPath 145 120 self)
				else
					(gEgo setMotion: PolyPath 139 111 self)
				)
			)
			(1
				(gEgo
					view: 861
					setLoop: (if register 1 else 10)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(if register
					(gEgo normalize: 0 7 posn: 119 116)
				else
					(gEgo normalize: 0 2 posn: 119 114)
				)
				(= seconds 2)
			)
			(3
				(gGameSound1 pause: 1)
				(sfx number: 863 loop: 1 play:)
				(turtle setCycle: End self)
				(gEgo setHeading: 270 self)
			)
			(4 0)
			(5
				(turtle
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (- (turtle x:) 40) (turtle y:) self
				)
			)
			(6
				(turtle
					setLoop: 2
					cel: 0
					cycleSpeed: 10
					posn: (+ (turtle x:) 7) (- (turtle y:) 1)
					setCycle: CT 4 1 self
				)
			)
			(7
				(gEgo
					view: 860
					setLoop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(turtle setCycle: End)
			)
			(8
				(= seconds 4)
			)
			(9
				(gEgo
					view: 13
					setLoop: 9
					cel: 0
					setPri: 1
					posn: (gEgo x:) 136
					setCycle: End self
				)
			)
			(10
				(gGameSound1 pause: 0)
				(gEgo normalize: 0 2)
				(turtle
					posn: 118 116
					setLoop: 5
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(11
				(turtle setLoop: 0)
				(turtle cel: (turtle lastCel:) posn: 111 117 setCycle: Beg self)
			)
			(12
				(= local9 3)
				(turtle stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45)
				(snake
					view: 865
					setLoop: 1
					posn: 233 88
					cel: 0
					setCycle: End self
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(snake setLoop: 0 cel: 0 posn: 160 93 setCycle: End self)
				(sfx number: 860 loop: 1 play:)
			)
			(4
				(snake view: 864 setLoop: 0 cel: 0 setCycle: End self)
				(sfx number: 298 loop: 1 play:)
			)
			(5
				(ripple init: setCycle: Fwd)
				(snake
					view: 865
					setLoop: 0
					cycleSpeed: 15
					setCycle: ROsc -1 8 10
				)
				(gGame handsOn:)
				(= seconds 10)
			)
			(6
				(gGame handsOff:)
				(cond
					((not (gEgo inRect: 112 94 151 107))
						(self setScript: submergeSnakeScript self)
					)
					((and (== (gEgo view:) 861) (== (gEgo loop:) 7))
						(self setScript: examineEgoScript self)
					)
					(else
						(gCurRoom setScript: bumpEgoScript)
					)
				)
			)
			(7
				(snakeScript start: 0)
				(snake dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance submergeSnakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ripple dispose:)
				(snake view: 865 setLoop: 0 cycleSpeed: 6)
				(snake cel: (snake lastCel:) setCycle: Beg self)
			)
			(1
				(bumpEgoScript register: 0)
				(self dispose:)
			)
		)
	)
)

(instance snakeListenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound1 pause: 1)
				(charmSound play:)
				(gEgo view: 861 setLoop: 5 setSpeed: 10 setCycle: Fwd)
				(snake view: 864 setLoop: 0 setCycle: Fwd)
				(= seconds 10)
			)
			(1
				(gGameSound1 pause: 0)
				(charmSound stop:)
				(gEgo normalize: 0)
				(if (not (gEgo inRect: 112 94 151 107))
					(self setScript: submergeSnakeScript self)
				else
					(gCurRoom setScript: bumpEgoScript)
				)
			)
			(2
				(snakeScript start: 0)
				(snake dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance charmSound of Sound
	(properties
		number 866
	)
)

(instance snakeLikesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 861 setLoop: 3 setSpeed: 10 setCycle: Fwd)
				(gGameSound1 pause: 1)
				(charmSound play: self)
				(snake view: 864 setLoop: 1 setCycle: Fwd)
			)
			(1
				(gGameSound1 pause: 0)
				(if (!= (snake cel:) 0)
					(snake setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame points: 13)
				(gEgo setCycle: 0)
				(snake
					view: 866
					setLoop: 0
					cel: 0
					setPri: 5
					setCycle: CT 2 1 self
				)
			)
			(3
				(sfx number: 216 loop: 1 play:)
				(snake setCycle: End self)
			)
			(4
				(gGameSound1 pause: 0)
				(snake
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 60
					setScript: snoreScript
				)
				(gEgo view: 861 setCycle: 0 setLoop: 7)
				(gEgo cel: (gEgo lastCel:))
				(ripple dispose:)
				(gCurrentRegionFlags set: 2)
				(gWalkHandler add: lake)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snoreIn of Sound
	(properties
		number 867
	)
)

(instance snoreOut of Sound
	(properties
		number 868
	)
)

(instance snoreScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (snake cel:) 1)
			(snoreIn play:)
		)
		(if (== (snake cel:) 3)
			(snoreOut play:)
		)
	)
)

(instance examineEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 11 49 6 1 self) ; "The snake greeted Adam like an old friend but seemed to be waiting for something!"
			)
			(1
				(self setScript: submergeSnakeScript self)
			)
			(2
				(snakeScript start: 0)
				(snake dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bumpEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(= register 1)
					(gCurRoom setScript: smallFlingScript)
				else
					(= register 0)
					(gCurRoom setScript: bigFlingScript)
				)
			)
		)
	)
)

(instance smallFlingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(snake
					view: 863
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: CT 6 1 self
				)
			)
			(1
				(gEgo view: 861 setLoop: 2 cel: 0 setCycle: End self)
				(snake setCycle: End self)
			)
			(2 0)
			(3
				(snake setLoop: 0)
				(snake cel: (- (snake lastCel:) 1))
				(= seconds 3)
			)
			(4
				(snake view: 865 setLoop: 0)
				(snake cel: (snake lastCel:))
				(gEgo view: 11 setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(gEgo normalize: 0 0)
				(snakeScript start: 4)
				(snake setScript: snakeScript)
			)
		)
	)
)

(instance bigFlingScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (not state)
			(switch (snake cel:)
				(0
					(gEgo x: 141 y: 93)
				)
				(1
					(gEgo cel: 1 x: 139 y: 83)
				)
				(2
					(gEgo cel: 2 x: 138 y: 85)
				)
				(3
					(gEgo cel: 3 x: 138 y: 78)
				)
				(4
					(gEgo cel: 4 x: 162 y: 23)
				)
				(else
					(gEgo x: 165 y: -10)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 861
					setCycle: 0
					setLoop: 6
					setPri: (+ (snake priority:) 1)
					cel: 0
				)
				(snake
					view: 861
					setLoop: 8
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 11
					setLoop: 0
					cel: 0
					setCycle: 0
					cycleSpeed: 30
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setScale: Scaler 70 70 189 0
					setStep: -1 15 1
					posn: 125 -10
					setPri: 15
					setMotion: MoveTo 125 180 self
				)
			)
			(3
				(gEgo cycleSpeed: register setCycle: End self)
				(sfx number: 542 loop: 1 play:)
			)
			(4
				(gEgo
					setLoop: 2
					cel: 0
					x: (+ (gEgo x:) 22)
					y: (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(5
				(gEgo
					normalize: 0 0
					scaleSignal: (& (gEgo scaleSignal:) $fffb)
					setScale: Scaler 70 50 185 125
				)
				(self setScript: submergeSnakeScript self)
			)
			(6
				(snakeScript start: 0)
				(snake dispose:)
				(= local9 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkToSnakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 118 100 self)
			)
			(1
				(bumpEgoScript register: 1)
				(gCurRoom setScript: bumpEgoScript)
			)
		)
	)
)

(instance adamSwimScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 5)
				(gEgo setMotion: PolyPath 143 100 self)
			)
			(1
				(gMessager say: 4 4 3 1 self) ; "Adam dives into the water and swims toward the island."
			)
			(2
				(gEgo view: 861 setLoop: 4 cel: 0 setCycle: CT 8 1 self)
			)
			(3
				(gEgo setCycle: End self)
				(sfx number: 869 loop: 1 play:)
			)
			(4
				(gEgo put: 18 put: 17 dispose:)
				(= cycles 10)
			)
			(5
				(gCurRoom newRoom: 870)
			)
		)
	)
)

(instance putOnCrownScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCurrentRegionFlags test: 8))
					(gCurrentRegionFlags set: 8)
					(gGame points: 2)
				)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo view: 861 setLoop: 7 cel: 0 setCycle: End self)
			)
			(2
				(gNarrator y: 20)
				(gMessager say: 11 49 0 1 self) ; "Adam puts the golden crown on his head. It is surprisingly light."
			)
			(3
				(gNarrator y: -1)
				(gEgo setScript: crownOnScript)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crownOnScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not state) (IsObject (gEgo mover:)))
			(= register (gEgo mover:))
			(gEgo mover: 0)
			(= local12 (not (gUser controls:)))
			(gGame handsOff:)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize: 0 6)
				(gMessager say: 11 49 7 1 self) ; "Adam removes the golden crown."
			)
			(3
				(if (not local12)
					(gGame handsOn:)
				)
				(gEgo mover: register)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance snake of Prop
	(properties
		noun 13
		view 865
		loop 1
		priority 1
		signal 28688
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 50) ; pipes
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: noun 4 8 1) ; "Let sleeping snakes lie."
				else
					(gGame handsOff:)
					(snake setScript: 0)
					(if (and (== (gEgo view:) 861) (== (gEgo loop:) 7))
						(gCurRoom setScript: snakeLikesScript)
					else
						(gCurRoom setScript: snakeListenScript)
					)
				)
			)
			((== theVerb 4) ; Do
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: noun theVerb 8 1) ; "Let sleeping snakes lie."
				else
					(gGame handsOff:)
					(snake setScript: 0)
					(gCurRoom setScript: walkToSnakeScript)
				)
			)
			((== theVerb 1) ; Look
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: noun theVerb 8 1) ; "Is it possible for a snake to snore?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(cond
			((== theVerb 49) ; diadem
				(if (and (== (gEgo view:) 861) (== (gEgo loop:) 7))
					(return 0)
				else
					(gGame handsOff:)
					(gCurRoom setScript: putOnCrownScript)
					(return 1)
				)
			)
			((== theVerb 50) ; pipes
				(cond
					((gCurrentRegionFlags test: 2)
						(gMessager say: 13 4 8 1) ; "Let sleeping snakes lie."
						(return 1)
					)
					((and (gCast contains: snake) (snakeScript state:))
						(gGame handsOff:)
						(snake setScript: 0)
						(if
							(and
								(== (gEgo view:) 861)
								(== (gEgo loop:) 7)
							)
							(gCurRoom setScript: snakeLikesScript)
						else
							(gCurRoom setScript: snakeListenScript)
						)
						(return 1)
					)
					(else
						(return 0)
					)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance poly0 of Polygon
	(properties)
)

(instance poly1 of Polygon
	(properties)
)

(instance poly2 of Polygon
	(properties)
)

(instance poly3 of Polygon
	(properties)
)

(instance poly4 of Polygon
	(properties)
)

(instance poly5 of Polygon
	(properties)
)

(instance poly6 of Polygon
	(properties)
)

(instance poly7 of Polygon
	(properties)
)

(instance poly8 of Polygon
	(properties)
)

(instance poly9 of Polygon
	(properties
		type PContainedAccess
	)
)

(instance isle0 of Island
	(properties
		y 173
		noun 2
		northView 861
		northX 156
		northY 165
		southLandLoop 5
		southLandX 167
		southLandY 164
	)
)

(instance isle1 of Island
	(properties
		y 157
		noun 2
		northView 861
		northLoop 1
		northX 227
		northY 155
		northLandLoop 6
		northLandX 187
		northLandY 160
		southView 861
		southLoop 10
		southX 192
		southY 161
		southLandLoop 4
		southLandX 220
		southLandY 154
	)
)

(instance isle2 of Island
	(properties
		y 146
		noun 2
		northView 861
		northLoop 1
		northX 206
		northY 147
		northLandLoop 7
		northLandX 198
		northLandY 150
		southView 861
		southLoop 11
		southX 196
		southY 151
		southLandLoop 4
		southLandX 207
		southLandY 145
	)
)

(instance isle3 of Island
	(properties
		y 139
		noun 2
		northView 861
		northX 164
		northY 133
		northLandLoop 7
		northLandX 177
		northLandY 144
		southView 861
		southLoop 11
		southX 185
		southY 142
		southLandLoop 5
		southLandX 172
		southLandY 133
	)
)

(instance isle4 of Island
	(properties
		y 126
		noun 2
		northView 861
		northLoop 1
		northX 182
		northY 125
		northLandLoop 6
		northLandX 190
		northLandY 128
		southView 861
		southLoop 10
		southX 193
		southY 130
		southLandLoop 4
		southLandX 180
		southLandY 125
	)
)

(instance isle5 of Island
	(properties
		y 121
		noun 2
		northView 861
		northX 152
		northY 119
		northLandLoop 7
		northLandX 157
		northLandY 122
		southView 861
		southLoop 11
		southX 160
		southY 122
		southLandLoop 5
		southLandX 154
		southLandY 119
	)
)

(instance isle6 of Island
	(properties
		y 114
		noun 2
		northView 861
		northLoop 1
		northX 170
		northY 113
		northLandLoop 6
		northLandX 175
		northLandY 115
		southView 861
		southLoop 10
		southX 174
		southY 116
		southLandLoop 4
		southLandX 160
		southLandY 113
	)
)

(instance isle7 of Island
	(properties
		y 108
		noun 2
		northView 861
		northLoop 1
		northX 137
		northY 108
		northLandLoop 7
		northLandX 145
		northLandY 109
		southView 861
		southLoop 11
		southX 140
		southY 110
		southLandLoop 4
		southLandX 134
		southLandY 107
	)
)

(instance isle8 of Island
	(properties
		y 97
		noun 2
		northLandLoop 7
		northLandX 113
		northLandY 105
		southView 861
		southLoop 11
		southX 114
		southY 104
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 185 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance exitsouth of ExitFeature
	(properties
		nsTop 188
		nsLeft 115
		nsBottom 189
		nsRight 225
		cursor 10
		exitDir 3
	)
)

(instance beach of Feature
	(properties
		x 159
		y 182
		noun 3
		sightAngle 180
	)

	(method (init)
		(self setOnMeCheck: 2 poly0)
		(super init:)
	)

	(method (dispose)
		(= onMeCheck 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== local9 0)
			(super doVerb: theVerb &rest)
		else
			(isle0 doVerb: theVerb &rest)
		)
	)
)

(instance lake of Feature
	(properties
		x 160
		y 10
		noun 4
		nsTop 60
		nsBottom 189
		nsRight 319
		sightAngle 180
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					((!= local9 8)
						(gMessager say: noun theVerb 2 1) ; "The water is too shallow to dive here."
					)
					((and (snake script:) (not (snakeScript state:)))
						(snakeScript seconds: 0 cue:)
					)
					((not (gCast contains: snake))
						(gGame handsOff:)
						(snake init:)
						(snakeScript start: 1)
						(snake setScript: snakeScript)
					)
					((not (gCurrentRegionFlags test: 2))
						(snake setScript: 0)
						(gGame handsOff:)
						(gCurRoom setScript: bumpEgoScript)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: adamSwimScript)
					)
				)
			)
			((== theVerb 3) ; Walk
				(if (gCurrentRegionFlags test: 2)
					(gGame handsOff:)
					(gCurRoom setScript: adamSwimScript)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deepWater of Feature
	(properties
		x 183
		y 91
		noun 14
		nsTop 79
		nsLeft 151
		nsBottom 103
		nsRight 216
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((!= local9 8)
						(gMessager say: noun theVerb 5 0) ; "Adam can't dive into the water from here."
					)
					((and (snake script:) (not (snakeScript state:)))
						(snakeScript seconds: 0 cue:)
					)
					((not (gCast contains: snake))
						(gGame handsOff:)
						(snake init:)
						(snakeScript start: 1)
						(snake setScript: snakeScript)
					)
					((not (gCurrentRegionFlags test: 2))
						(snake setScript: 0)
						(gGame handsOff:)
						(gCurRoom setScript: bumpEgoScript)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: adamSwimScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foliage of Feature
	(properties
		x 18
		y 110
		noun 7
		sightAngle 40
		onMeCheck 4096
	)
)

(instance platform of Feature
	(properties
		x 81
		y 90
		noun 1
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4) ; Walk, Do
			(isle8 doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance island of Feature
	(properties
		x 184
		y 74
		noun 5
		sightAngle 40
		onMeCheck 8
	)
)

(instance foliage2 of Feature
	(properties
		x 18
		y 110
		noun 7
		sightAngle 40
		onMeCheck 4096
	)
)

(instance mountain of Feature
	(properties
		x 158
		y 45
		noun 8
		sightAngle 40
		onMeCheck 4
	)
)

(instance sky of Feature
	(properties
		x 158
		y 19
		noun 9
		sightAngle 40
		onMeCheck 2
	)
)

