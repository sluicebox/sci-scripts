;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Garbage)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm800 0
)

(local
	local0
	local1
	local2 = 5
	local3
	local4
)

(instance rm800 of Rm
	(properties
		noun 16
		picture 800
		style 10
	)

	(method (init)
		(gGame handsOff:)
		(gGameSound1 number: 800 loop: -1 play:)
		(rock init: setPri: 8)
		(waterFall init: setCycle: Fwd)
		(garbage0 init:)
		(garbage1 init:)
		(garbage2 init:)
		(garbage3 init:)
		(garbage4 init:)
		(garbage6 init:)
		(slidingPanel
			init:
			cel:
				(if (== ((gInventory at: 10) owner:) 800)
					(slidingPanel lastCel:)
				else
					0
				)
			ignoreActors: 1
		)
		(maskPlace init: cel: (if (== ((gInventory at: 10) owner:) 800) 1 else 0))
		(if (not (gEgo has: 16))
			(magnifier
				init:
				setPri: (- (garbage0 priority:) 1)
				ignoreActors: 1
				stopUpd:
			)
		)
		(seat init:)
		(queenHole init: setOnMeCheck: 1 16)
		(kingHole init: setOnMeCheck: 1 8)
		(highledge init:)
		(lowledge init:)
		(maze init: setOnMeCheck: 1 2)
		(hole init:)
		(lake init: setOnMeCheck: 1 4)
		(island init:)
		(mountain init:)
		(stairway init:)
		(philo init:)
		(passion init:)
		(if (not (gCurrentRegionFlags test: 0))
			(gCurrentRegionFlags set: 0)
			(self setScript: eagleScript)
		else
			(exitFeat init:)
			(weight
				init:
				setLoop: 4
				cel: 0
				setPri: (+ (rock priority:) 1)
				posn: 168 120
				ignoreActors: 1
				addToPic:
			)
			(rock cel: (rock lastCel:) ignoreActors: 1 setPri: 8)
			(maskPlace cel: 1 ignoreActors: 1 addToPic:)
			(slidingPanel
				cel: (slidingPanel lastCel:)
				ignoreActors: 1
				addToPic:
			)
			(self setScript: fromMazeScript)
		)
		(super init:)
		(gTheDoits add: maze lake philo passion queenHole kingHole)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 105 0 120 43 120 67 129 88 129 105 133 132 132 151 138 129 146 116 145 99 145 90 145 77 144 59 144 49 150 71 158 98 158 110 153 144 150 158 140 182 139 198 144 228 144 249 154 199 161 176 154 153 160 99 166 68 166 44 157 44 146 6 146 6 152 53 168 117 180 131 173 178 173 210 179 307 179 307 170 281 153 266 153 221 137 201 137 178 123 171 119 158 116 144 116 100 107 89 107 78 96 16 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 48 108 48 112 7 112 7 108
					yourself:
				)
				(if (!= (rock cel:) 0)
					((Polygon new:)
						type: PBarredAccess
						init: 77 111 108 111 143 119 164 122 175 124 195 136 170 134 136 128 98 128 72 123 62 118 68 116 98 126 110 113 77 113
						yourself:
					)
				else
					((= local1 (Polygon new:))
						type: PBarredAccess
						init: 72 108 108 111 143 119 184 129 164 133 136 128 115 130 97 127 68 126 55 123 51 120 49 117
						yourself:
					)
				)
		)
	)

	(method (doit)
		(if (and (not (IsFlag 5)) (not (-- local2)))
			(= local2 5)
			(Palette palANIMATE 72 77 1)
		)
		(if
			(and
				(gEgo inRect: 85 117 91 125)
				(not script)
				(gEH contains: exitFeat)
			)
			(gGame handsOff:)
			(self setScript: toMazeScript)
		)
		(if
			(and
				(not (OneOf script toMazeScript fromMazeScript))
				(not (& (gEgo signal:) $0010))
				(gEgo inRect: 46 125 100 133)
			)
			(gEgo setPri: 9)
		)
		(if
			(and
				(not (OneOf script toMazeScript fromMazeScript))
				(& (gEgo signal:) $0010)
				(not (gEgo inRect: 46 125 100 133))
			)
			(gEgo setPri: -1)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (event type:))
		(if
			(and
				local0
				(OneOf ((gTheIconBar curIcon:) message:) 4 3)
				(or
					(& temp0 evMOUSEBUTTON)
					(& temp0 $0040) ; direction
					(and (& temp0 evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(gGame handsOff:)
			(self setScript: getOffRockScript)
		else
			(event claimed: 0)
			(super handleEvent: event)
		)
	)

	(method (newRoom newRoomNumber)
		(gGameSound1 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance flyGuy of Actor
	(properties
		view 105
		loop 7
		signal 26624
	)
)

(instance flyGuyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound1 number: 139 loop: -1 play:)
				(flyGuy
					init:
					scaleSignal: 1
					scaleX: 64
					scaleY: 64
					posn: -10 40
					setMotion: MoveTo 40 40 self
				)
			)
			(1
				(flyGuy setMotion: MoveTo (+ (flyGuy x:) 50) -20 self)
			)
			(2
				(flyGuy dispose:)
				(gGameSound1 fade: self)
			)
			(3
				(gGameSound1 number: 800 loop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rock of Prop
	(properties
		x 115
		y 128
		noun 6
		view 800
		signal 20480
	)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 77))
			(cond
				((OneOf theVerb 4 3) ; Do, Walk
					(gGame handsOff:)
					(gCurRoom setScript: getOnRockScript)
				)
				((== theVerb 57) ; goldDisc
					(gGame handsOff:)
					(gEgo put: 12 800)
					(gGame points: 3)
					(gCurRoom setScript: tiltRockScript 0 2)
				)
				((== theVerb 9) ; discPile
					(gGame handsOff:)
					(gEgo put: 15 800)
					(gGame points: 2)
					(gCurRoom setScript: tiltRockScript 0 4)
				)
				((== theVerb 1) ; Look
					(cond
						(
							(and
								(not (gCast contains: weight))
								(not (gAddToPics contains: weight))
							)
							(super doVerb: theVerb &rest)
						)
						((== (weight cel:) 1)
							(gMessager say: noun theVerb 6) ; "The golden weight has shifted the rock."
						)
						(
							(and
								(== (weight cel:) 0)
								(!= (rock cel:) (rock lastCel:))
							)
							(gMessager say: noun theVerb 14) ; "A heap of golden weights has shifted the rock."
						)
						(else
							(gMessager say: noun theVerb 13) ; "The weights have completely shifted the rock!"
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 77))
			(self perform: gCheckEcorderIcon self)
		)
		(if (== (getOnRockScript state:) 4)
			(switch cel
				(1
					(gEgo x: 157 y: 142)
				)
				(2
					(gEgo x: 159 y: 144)
				)
				(3
					(gEgo x: 159 y: 148)
				)
				(4
					(gEgo x: 162 y: 156)
				)
				(5
					(gEgo x: 165 y: 160 cel: 1)
				)
				(6
					(gEgo x: 165 y: 164 cel: 2)
				)
			)
		)
		(if
			(and
				(gCast contains: weight)
				(or
					(== (tiltRockScript state:) 2)
					(== (getOnRockScript state:) 4)
					(== (getOffRockScript state:) 1)
				)
			)
			(switch cel
				(0
					(weight x: 155 y: 99)
				)
				(1
					(weight x: 157 y: 101)
				)
				(2
					(weight x: 159 y: 103)
				)
				(3
					(weight x: 163 y: 107)
				)
				(4
					(weight x: 165 y: 113)
				)
				(5
					(weight x: 166 y: 116)
				)
				(6
					(weight x: 168 y: 120)
				)
			)
		)
	)
)

(instance slidingPanel of Prop
	(properties
		x 59
		y 147
		noun 3
		view 800
		loop 3
		priority 7
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 50) (not local4)) ; pipes
				(= local4 1)
				(gGame handsOff:)
				(gCurRoom setScript: flyGuyScript)
			)
			((!= theVerb 1) ; Look
				(super doVerb: theVerb &rest)
			)
			((== cel 0)
				(gMessager say: noun theVerb 1 1)
			)
			((gCast contains: goldDisks)
				(gMessager say: noun theVerb 2 1)
			)
			(else
				(gMessager say: noun theVerb 3 1)
			)
		)
	)
)

(instance weight of Prop
	(properties
		noun 22
		view 800
	)
)

(instance goldDisks of Prop
	(properties
		x 57
		y 160
		z 20
		view 800
		loop 4
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gGame handsOff:)
				(gCurRoom setScript: getDiskScript)
			)
			((== theVerb 1) ; Look
				(gMessager say: 3 theVerb 2 1) ; "Inside the panel is a heaping pile of golden disks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance maskPlace of Actor
	(properties
		x 82
		y 147
		noun 19
		view 800
		loop 5
		priority 9
		signal 16400
		detailLevel 3
	)

	(method (doit)
		(if (not (IsEcorderFlag 76))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 76))
			(cond
				((== theVerb 52) ; Princess__Mask
					(gGame handsOff:)
					(gCurRoom setScript: slidePanelScript)
				)
				((and (OneOf theVerb 1 4) (== ((gInventory at: 10) owner:) 800)) ; Look, Do
					(gMessager say: noun theVerb 5 0)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance magnifier of Prop
	(properties
		x 29
		y 149
		noun 4
		approachX 38
		approachY 154
		view 800
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: getMagScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance waterFall of Prop
	(properties
		x 261
		y 73
		noun 25
		view 800
		loop 6
		detailLevel 3
	)
)

(instance garbage0 of Garbage
	(properties
		x 25
		y 151
		noun 5
		modNum 800
		view 800
		loop 1
		cel 1
		flag 4
	)
)

(instance garbage1 of Garbage
	(properties
		x 133
		y 166
		noun 5
		modNum 800
		view 800
		loop 1
		flag 5
	)
)

(instance garbage2 of Garbage
	(properties
		x 205
		y 163
		noun 5
		modNum 800
		view 800
		loop 1
		cel 2
		flag 6
	)
)

(instance garbage3 of Garbage
	(properties
		x 217
		y 175
		noun 5
		modNum 800
		view 800
		loop 1
		cel 3
		flag 7
	)
)

(instance garbage4 of Garbage
	(properties
		x 110
		y 174
		noun 5
		modNum 800
		view 800
		loop 1
		cel 4
		flag 8
	)
)

(instance garbage6 of Garbage
	(properties
		x 236
		y 162
		noun 5
		modNum 800
		view 800
		loop 1
		cel 6
		flag 10
	)
)

(instance philo of Feature
	(properties
		x 176
		y 167
		noun 20
		nsTop 161
		nsLeft 158
		nsBottom 173
		nsRight 195
	)

	(method (doit)
		(if (not (IsEcorderFlag 18))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 18))
			(super doVerb: theVerb)
		)
	)
)

(instance passion of Feature
	(properties
		x 274
		y 164
		noun 21
		nsTop 154
		nsLeft 259
		nsBottom 175
		nsRight 290
	)

	(method (doit)
		(if (not (IsEcorderFlag 17))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 17))
			(super doVerb: theVerb)
		)
	)
)

(instance hole of Feature
	(properties
		x 105
		y 117
		noun 11
		nsTop 110
		nsLeft 82
		nsBottom 124
		nsRight 128
		approachX 105
		approachY 117
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gCast contains: weight))
						(super doVerb: theVerb &rest)
					)
					((== (weight cel:) 1)
						(gMessager say: noun theVerb 6) ; "The opening is too narrow!"
					)
					((and (== (weight cel:) 0) (!= (rock cel:) (rock lastCel:)))
						(gMessager say: noun theVerb 14) ; "The opening is almost wide enough to admit a person."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(cond
					((not (gCast contains: weight))
						(super doVerb: theVerb &rest)
					)
					((== (weight cel:) 1)
						(gMessager say: noun theVerb 6) ; "The opening is narrow, so that only a small animal could fit!"
					)
					((and (== (weight cel:) 0) (!= (rock cel:) (rock lastCel:)))
						(gMessager say: noun theVerb 14) ; "The opening is almost wide enough to admit a person."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seat of Feature
	(properties
		x 37
		y 100
		noun 1
		nsTop 84
		nsLeft 9
		nsBottom 117
		nsRight 66
	)
)

(instance queenHole of Feature
	(properties
		x 122
		y 140
		noun 23
		onMeCheck 16
	)

	(method (doit)
		(if (not (IsEcorderFlag 76))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 76))
			(super doVerb: theVerb)
		)
	)
)

(instance kingHole of Feature
	(properties
		x 103
		y 139
		noun 24
		onMeCheck 8
	)

	(method (doit)
		(if (not (IsEcorderFlag 76))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 76))
			(super doVerb: theVerb)
		)
	)
)

(instance highledge of Feature
	(properties
		x 160
		y 150
		noun 8
		nsTop 157
		nsLeft 7
		nsBottom 184
		nsRight 314
	)
)

(instance lowledge of Feature
	(properties
		x 233
		y 118
		noun 9
		nsTop 104
		nsLeft 153
		nsBottom 132
		nsRight 314
	)
)

(instance maze of Feature
	(properties
		x 220
		y 81
		noun 10
		onMeCheck 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 75))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 75))
			(super doVerb: theVerb)
		)
	)
)

(instance stairway of Feature
	(properties
		x 252
		y 101
		noun 15
		nsTop 94
		nsLeft 239
		nsBottom 109
		nsRight 265
	)
)

(instance lake of Feature
	(properties
		x 127
		y 40
		noun 12
		onMeCheck 4
	)
)

(instance island of Feature
	(properties
		x 145
		y 41
		noun 13
		nsTop 44
		nsLeft 132
		nsBottom 50
		nsRight 157
	)
)

(instance mountain of Feature
	(properties
		x 161
		y 11
		noun 14
		nsTop 2
		nsLeft 6
		nsBottom 21
		nsRight 316
	)
)

(instance discSound of Sound
	(properties
		number 634
	)
)

(instance tiltRockScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 157 137 self)
			)
			(1
				(gEgo
					view: 801
					setLoop: 5
					cel: 0
					posn: 158 138
					setCycle: End self
				)
			)
			(2
				(discSound play:)
				(gEgo setCycle: Beg)
				(cond
					((gCast contains: weight)
						(= temp0 4)
						(= temp1 0)
					)
					((== register 2)
						(= temp0 4)
						(= temp1 1)
					)
					(else
						(= temp0 4)
						(= temp1 0)
					)
				)
				(weight
					init:
					setLoop: temp0
					cel: temp1
					setPri: (+ (rock priority:) 1)
				)
				(sfx number: 840 loop: 1 play:)
				(rock setCycle: CT (+ (rock cel:) register) 1 self)
			)
			(3
				(switch (rock cel:)
					(2
						(gMessager say: 6 57 9 1 self) ; "The rock tilts slightly."
					)
					(4
						(gMessager say: 6 9 10 1 self) ; "The rock moves aside, but the opening is still narrow."
					)
					(6
						(gGame points: 5)
						(rock setCycle: End self)
					)
				)
			)
			(4
				(if (== (rock cel:) 8)
					(gMessager say: 6 0 13 1 self) ; "The rock tilts so that the passage is clear."
				else
					(= cycles 1)
				)
			)
			(5
				(if (== (rock cel:) 8)
					(rock ignoreActors: 1 setPri: 8)
					(weight
						ignoreActors: 1
						y: (+ (weight y:) 10)
						z: 10
						setPri: 9
						addToPic:
					)
					((gCurRoom obstacles:) delete: local1)
					(local1 dispose:)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 77 111 108 111 143 119 164 122 175 124 195 136 170 134 136 128 98 128 72 123 62 118 68 116 98 126 110 113 77 113
								yourself:
							)
					)
					(exitFeat init:)
				)
				(gEgo normalize: 0 3 posn: 156 137)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getOnRockScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(switch (rock cel:)
					(0
						(= temp0 155)
						(= temp1 135)
					)
					(2
						(= temp0 159)
						(= temp1 144)
					)
					(4
						(= temp0 171)
						(= temp1 140)
					)
					(else
						(= temp0 179)
						(= temp1 140)
					)
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(switch (rock cel:)
					(0
						(= temp0 155)
						(= temp1 138)
						(= temp2 0)
					)
					(2
						(= temp0 159)
						(= temp1 144)
						(= temp2 0)
					)
					(4
						(= temp0 163)
						(= temp1 155)
						(= temp2 5)
					)
					(else
						(= temp0 165)
						(= temp1 163)
						(= temp2 6)
					)
				)
				(gEgo
					view: 801
					setLoop: 0
					cel: temp2
					posn: temp0 temp1
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 1 cel: 0)
				(= cycles 2)
			)
			(4
				(getOffRockScript register: (rock cel:))
				(if (!= (rock cel:) (rock lastCel:))
					(sfx number: 840 loop: 1 play:)
					(rock setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(5
				(if (not local3)
					(= local3 1)
					(gMessager say: 16 0 4 1 self) ; "Yikes!"
				else
					(= cycles 1)
				)
			)
			(6
				(= local0 1)
				(gDirectionHandler add: gCurRoom)
				(gMouseDownHandler add: gCurRoom)
				(gKeyDownHandler add: gCurRoom)
				(gWalkHandler add: gCurRoom)
				(gGame handsOn:)
				(gTheIconBar disable: 2 3 4 5 6 7)
				(self dispose:)
			)
		)
	)
)

(instance getOffRockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo normalize: 0 4 posn: 178 134)
				(if (!= register (rock lastCel:))
					(sfx number: 840 loop: 1 play:)
					(rock setCycle: CT register -1 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= local0 0)
				(gDirectionHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gWalkHandler delete: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slidePanelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 87 145 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 801 setLoop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(if
					(and
						(not (gEgo has: 12))
						(!= ((gInventory at: 12) owner:) 800)
					)
					(gMessager say: 18 52 12 1) ; "Something seems to be stuck in the mask."
					(gEgo setLoop: 3 cel: 0 setCycle: End self)
				else
					(sfx number: 510 loop: 1 play:)
					(maskPlace setCel: 1 ignoreActors: 1 stopUpd:)
					(gEgo put: 10 800 setLoop: 6 cel: 0 setCycle: End self)
				)
			)
			(4
				(if
					(and
						(not (gEgo has: 12))
						(!= ((gInventory at: 12) owner:) 800)
					)
					(= cycles 1)
				else
					(goldDisks init: setPri: 6 ignoreActors: 1)
					(sfx2 number: 802 loop: 1 play:)
					(slidingPanel setCycle: End self)
					(gGame points: 5)
				)
				(gEgo normalize: 0 7 posn: 87 145)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getDiskScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 44 144 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo
					view: 801
					setLoop: 4
					cel: 0
					posn: 47 145
					setCycle: CT 4 1 self
				)
			)
			(3
				(gGame points: 3)
				(goldDisks dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo get: 15 normalize: 0 6 setLoop: 6 posn: 44 144)
				(gEgo
					setCycle: Rev
					setMotion: MoveTo (- (gEgo x:) 3) (+ (gEgo y:) 3) self
				)
			)
			(5
				(gEgo normalize: 0 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getMagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(magnifier approachX:)
						(magnifier approachY:)
						self
				)
			)
			(1
				(gEgo view: 5 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(magnifier dispose:)
				(gEgo get: 16 setCycle: End self)
				(gGame points: 10)
			)
			(3
				(gEgo normalize: 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eagle of Actor
	(properties
		x -87
		y 15
		view 18
		signal 24576
	)
)

(instance eagleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rock stopUpd:)
				(eagle
					init:
					scaleSignal: (+ (| (eagle scaleSignal:) $0004) 1)
					scaleX: 107
					scaleY: 107
					setPri: 14
					setStep: 10 10
					setCycle: Fwd
					setMotion: MoveTo 170 86 self
				)
				(gEgo
					init:
					view: 802
					setLoop: 3
					cel: 0
					setPri: 14
					posn: -100 100
					setScale: Scaler 90 60 185 20
				)
			)
			(1
				(eagle view: 802 setLoop: 0 setMotion: MoveTo 270 -30 self)
				(gEgo posn: 215 162 setCycle: End self)
			)
			(2 0)
			(3
				(gEgo normalize: 0 6 posn: 217 162)
				(eagle dispose:)
				(rock startUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromMazeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					init:
					edgeHit: EDGE_NONE
					x: 125
					y: 143
					normalize: 0
					setPri: (- (rock priority:) 1)
					setScale: Scaler 90 60 185 20
					setMotion: MoveTo 70 113 self
				)
			)
			(1
				(gEgo setPri: -1 setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toMazeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: (- (rock priority:) 1)
					setMotion: MoveTo 128 140 self
				)
			)
			(1
				(gCurRoom newRoom: 820)
				(self dispose:)
			)
		)
	)
)

(instance exitFeat of ExitFeature
	(properties
		nsTop 112
		nsLeft 80
		nsBottom 124
		nsRight 93
		cursor 11
		exitDir 2
		toX 88
		toY 121
	)

	(method (handleEvent event)
		(if (not local0)
			(super handleEvent: event)
		)
	)
)

