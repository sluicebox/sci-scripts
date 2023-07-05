;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 902)
(include sci.sh)
(use Main)
(use scaryInvInit)
(use n1111)
(use n1112)
(use Str)
(use Print)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	nameGameRoom 0
)

(local
	[local0 26] = [0 85 43 43 43 64 85 107 149 128 149 171 128 107 171 192 0 64 21 85 128 64 21 21 107 0]
	[local26 26] = [42 61 61 42 23 42 42 42 23 42 42 42 61 61 23 23 23 23 42 23 23 61 23 61 23 61]
	[local52 26] = [19 105 62 62 62 83 105 126 169 147 169 190 147 126 190 211 19 83 41 105 147 83 41 41 126 19]
	[local78 26] = [59 78 78 59 41 59 59 59 41 59 59 59 78 78 41 41 41 41 59 41 41 78 41 78 41 78]
	[local104 26] = [0 85 43 43 43 64 85 107 149 128 149 171 128 107 171 192 0 64 21 85 128 64 21 21 107 0]
	[local130 26] = [42 61 61 42 23 42 42 42 23 42 42 42 61 61 23 23 23 23 42 23 23 61 23 61 23 61]
	[local156 8] = [46 61 76 91 106 121 136 151]
	local164
	[local165 8]
	local173
	[local174 26]
	local200
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(flashCel
		view: (param1 depView:)
		loop: (param1 depLoop:)
		cel: (param1 value:)
		x: (param1 depOffX:)
		y: (param1 depOffY:)
		show:
		z: 0
	)
	(UpdateScreenItem flashCel)
	(FrameOut)
	(= temp1 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: gThePlane)
		(cond
			((param1 onMe: temp0)
				(if (flashCel z:)
					(flashCel z: 0)
					(= temp1 1)
					(UpdateScreenItem flashCel)
					(FrameOut)
				)
			)
			((not (flashCel z:))
				(flashCel z: 1000)
				(= temp1 0)
				(UpdateScreenItem flashCel)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(flashCel z: 1000)
	(UpdateScreenItem flashCel)
	(return temp1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (param1 cel:))
	(param1 cel: param2)
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp2 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: gThePlane)
		(cond
			((param1 onMe: temp0)
				(if (== (param1 cel:) temp1)
					(param1 cel: param2)
					(= temp2 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp1)
				(param1 cel: temp1)
				(= temp2 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(param1 cel: temp1)
	(UpdateScreenItem param1)
	(return temp2)
)

(instance nameGameRoom of Room
	(properties
		picture 9800
		style 0
	)

	(method (init &tmp temp0)
		(gThePlane setRect: 0 0 319 199)
		(super init: &rest)
		(= global121 0)
		(= local173 (Str newWith: 9 {}))
		(gKeyDownHandler add: self)
		(gUser canInput: 1)
		(gGame setCursor: gNormalCursor 1)
		(= local200 0)
		(keyboard init:)
		(flashCel view: 9805 init: hide:)
		(for ((= temp0 0)) (< temp0 26) ((++ temp0))
			((= [local174 temp0] (KeyFeature new:))
				init:
					keyboard
					[local0 temp0]
					[local26 temp0]
					[local52 temp0]
					[local78 temp0]
				value: temp0
				depView: 9805
				depLoop: 8
				depOffX: (+ (keyboard x:) [local104 temp0])
				depOffY: (+ (keyboard y:) [local130 temp0])
				setHotspot: 4 3 ; Do, Move
				yourself:
			)
		)
		(doneFeat
			init: keyboard 192 42 211 78
			depView: 9805
			depLoop: 8
			value: 26
			depOffX: (+ (keyboard x:) 192)
			depOffY: (+ (keyboard y:) 42)
			setHotspot: 4 3 ; Do, Move
			createPoly:
				(+ (keyboard x:) 149)
				(+ (keyboard y:) 61)
				(+ (keyboard x:) 192)
				(+ (keyboard y:) 61)
				(+ (keyboard x:) 192)
				(+ (keyboard y:) 42)
				(+ (keyboard x:) 211)
				(+ (keyboard y:) 42)
				(+ (keyboard x:) 211)
				(+ (keyboard y:) 78)
				(+ (keyboard x:) 149)
				(+ (keyboard y:) 78)
		)
		(nameTitle init:)
		(backspace
			init: keyboard 0 82 21 99
			depView: 9805
			depLoop: 3
			value: 1
			depOffX: (keyboard x:)
			depOffY: (+ (keyboard y:) 82)
			setHotspot: 4 3 ; Do, Move
		)
		(cancel
			init: keyboard 191 82 211 99
			depView: 9805
			depLoop: 3
			value: 1
			depOffX: (+ (keyboard x:) 191)
			depOffY: (+ (keyboard y:) 82)
			setHotspot: 4 3 ; Do, Move
		)
		(backspaceView init:)
		(cancelView init:)
		(bsText init:)
		(cancelText init:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((event claimed:)
				(return)
			)
			((== (event type:) evKEYBOARD)
				(event claimed: 1)
				(if
					(or
						(and (>= (= temp0 (event message:)) KEY_a) (<= temp0 KEY_z))
						(and (>= temp0 KEY_A) (<= temp0 KEY_Z))
					)
					(if (and (>= temp0 KEY_a) (<= temp0 KEY_z))
						(-= temp0 97)
					else
						(-= temp0 65)
					)
					(if (> temp0 $0019)
						(= temp0 $0019)
					)
					(if (< temp0 JOY_NULL)
						(= temp0 JOY_NULL)
					)
					(= temp1 [local174 temp0])
					(temp1 doVerb: 0 1 keyFlash:)
				else
					(switch temp0
						(JOY_UPLEFT
							(backspace doVerb: 0 1 keyFlash:)
						)
						(KEY_ESCAPE
							(cancel doVerb: 0 1 keyFlash:)
						)
						(KEY_RETURN
							(doneFeat doVerb: 0 1 keyFlash:)
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
			(else
				(event claimed: 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(local173 dispose:)
		(gKeyDownHandler delete: self)
		(super newRoom: newRoomNumber)
	)
)

(instance flashCel of View
	(properties)
)

(instance keyboard of View
	(properties
		x 56
		y 61
		priority 5
		fixPriority 1
		view 9805
		loop 2
	)
)

(instance keyFlashCel of View
	(properties)

	(method (init)
		(super init: &rest)
		(= yStep 20)
	)

	(method (doit)
		(if (not (-- yStep))
			(self dispose:)
		)
	)
)

(class KeyFeature of Feature
	(properties
		value 0
		depView 0
		depLoop 0
		depOffX 0
		depOffY 0
	)

	(method (keyFlash)
		((keyFlashCel new:)
			view: depView
			loop: depLoop
			cel: value
			x: depOffX
			y: depOffY
			init:
		)
	)

	(method (init param1 param2 param3 param4 param5)
		(super init:)
		(= nsLeft (+ (param1 x:) param2))
		(= nsTop (+ (param1 y:) param3))
		(= nsRight (+ (param1 x:) param4))
		(= nsBottom (+ (param1 y:) param5))
		(= y (+ (param1 y:) 1))
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb theVerb invItem)
		(if (and (< local164 8) (or (and (> argc 1) invItem) (localproc_0 self)))
			(local173 at: local164 (+ value 65))
			((= [local165 local164] (View new:))
				view: 9805
				setLoop: (+ 6 (/ value 16))
				setCel: (mod value 16)
				x: (+ (keyboard x:) [local156 local164])
				y: (+ (keyboard y:) 11)
				fixPriority: 1
				priority: 10
				init:
			)
			(++ local164)
		)
	)
)

(instance doneFeat of KeyFeature
	(properties)

	(method (doVerb theVerb invItem)
		(if (or (and (> argc 1) invItem) (localproc_0 self))
			(cond
				((<= (local173 size:) 0)
					(Prints 0 0 0 1 -1 -1 902)
				)
				((not (gSaveManager uniqueSaveName: local173))
					(Prints 0 0 0 2 -1 -1 902)
				)
				(else
					(gKeyDownHandler delete: gCurRoom)
					(doneScr init:)
				)
			)
		)
	)
)

(instance chapTitle of View
	(properties
		x 99
		y 15
		view 9103
	)
)

(instance oneButt of View
	(properties
		x 104
		y 43
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(oneText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 1)
				(doneScr cue:)
			)
		)
	)
)

(instance twoButt of View
	(properties
		x 104
		y 68
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(twoText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 2)
				(doneScr cue:)
			)
		)
	)
)

(instance threeButt of View
	(properties
		x 104
		y 93
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(threeText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 3)
				(doneScr cue:)
			)
		)
	)
)

(instance fourButt of View
	(properties
		x 104
		y 118
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(fourText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 4)
				(doneScr cue:)
			)
		)
	)
)

(instance fiveButt of View
	(properties
		x 104
		y 143
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(fiveText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 5)
				(doneScr cue:)
			)
		)
	)
)

(instance sixButt of View
	(properties
		x 104
		y 168
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(sixText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 6)
				(doneScr cue:)
			)
		)
	)
)

(instance sevenButt of View
	(properties
		x 104
		y 193
		view 9103
		loop 8
		cel 1
	)

	(method (init)
		(super init:)
		(sevenText x: (+ x 23) y: (- y 6) init:)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(cond
			(local200 0)
			((not (localproc_1 self 0)) 0)
			(else
				(= gChapter 7)
				(doneScr cue:)
			)
		)
	)
)

(instance oneText of View
	(properties
		view 9103
		loop 1
	)
)

(instance twoText of View
	(properties
		view 9103
		loop 2
	)
)

(instance threeText of View
	(properties
		view 9103
		loop 3
	)
)

(instance fourText of View
	(properties
		view 9103
		loop 4
	)
)

(instance fiveText of View
	(properties
		view 9103
		loop 5
	)
)

(instance sixText of View
	(properties
		view 9103
		loop 6
	)
)

(instance sevenText of View
	(properties
		view 9103
		loop 7
	)
)

(instance doneScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (== (event type:) evKEYBOARD)
			(event claimed: 1)
			(switch (event message:)
				(KEY_1
					(= gChapter 1)
					(self cue:)
				)
				(KEY_2
					(= gChapter 2)
					(self cue:)
				)
				(KEY_3
					(= gChapter 3)
					(self cue:)
				)
				(KEY_4
					(= gChapter 4)
					(self cue:)
				)
				(KEY_5
					(= gChapter 5)
					(self cue:)
				)
				(KEY_6
					(= gChapter 6)
					(self cue:)
				)
				(KEY_7
					(= gChapter 7)
					(self cue:)
				)
				(KEY_ESCAPE
					(gCurRoom newRoom: 91) ; saveRest
				)
				(else
					(event claimed: 0)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(for ((= temp0 0)) (< temp0 26) ((++ temp0))
					([local174 temp0] dispose:)
				)
				(doneFeat dispose:)
				(cancel dispose:)
				(backspace dispose:)
				(gCast eachElementDo: #dispose)
				(= cycles 2)
			)
			(2
				(= cycles 2)
			)
			(3
				(= global111 0)
				(= global115 0)
				(= global118 0)
				(= global125 0)
				(= global159 0)
				(= global161 0)
				(= global162 0)
				(= global163 0)
				(= global164 0)
				(= global165 0)
				(= global167 0)
				(= global170 0)
				(= global171 0)
				(= global172 0)
				(= global173 0)
				(= global174 0)
				(= global175 0)
				(= global176 0)
				(= global177 0)
				(= global181 0)
				(= global182 0)
				(= global183 0)
				(= global184 0)
				(= global185 0)
				(= global186 0)
				(= global201 0)
				(= global205 0)
				(= global207 0)
				(= global225 0)
				(= global229 0)
				(= temp4 (IsFlag 63))
				(proc1111_15)
				(for ((= temp0 0)) (< temp0 446) ((++ temp0))
					(ClearFlag temp0)
				)
				(if temp4
					(SetFlag 63)
				)
				(proc1111_16)
				(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
					(= temp1 (gInventory at: temp0))
					(if (OneOf (temp1 owner:) -2 gEgo)
						(temp1 owner: -1)
						(proc28_3 temp1)
					)
				)
				(gKeyDownHandler addToFront: self)
				(chapTitle init:)
				(oneButt init:)
				(twoButt init:)
				(threeButt init:)
				(fourButt init:)
				(fiveButt init:)
				(sixButt init:)
				(sevenButt init:)
			)
			(4
				(= local200 1)
				(if (gGSound1 handle:)
					(gGSound1 fade: 0 1 40 1 self)
				else
					(= cycles 1)
				)
			)
			(5
				(= cycles 2)
			)
			(6
				(gKeyDownHandler delete: self)
				(switch gChapter
					(1
						(= global108 1100)
					)
					(2
						(= global108 17100)
						(proc1112_0)
					)
					(3
						(= global108 28860)
						(proc1112_0)
						(proc1112_1)
					)
					(4
						(SetFlag 411)
						(= global108 18200)
						(proc1112_0)
						(proc1112_1)
						(proc1112_2)
					)
					(5
						(= global108 17100)
						(proc1112_0)
						(proc1112_1)
						(proc1112_2)
						(proc1112_3)
					)
					(6
						(= global108 18200)
						(proc1112_0)
						(proc1112_1)
						(proc1112_2)
						(proc1112_3)
						(proc1112_4)
					)
					(7
						(= global108 17000)
						(proc1112_0)
						(proc1112_1)
						(proc1112_2)
						(proc1112_3)
						(proc1112_4)
						(proc1112_5)
					)
				)
				(= temp3 0)
				(switch gChapter
					(1
						(if (== (gGame getDisc: 1) 99)
							(= temp3 1)
						)
					)
					(2
						(if (== (gGame getDisc: 2) 99)
							(= temp3 1)
						)
					)
					(3
						(if (== (gGame getDisc: 3) 99)
							(= temp3 1)
						)
					)
					(4
						(if (== (gGame getDisc: 4) 99)
							(= temp3 1)
						)
					)
					(5
						(if (== (gGame getDisc: 5) 99)
							(= temp3 1)
						)
					)
					(6
						(if (== (gGame getDisc: 6) 99)
							(= temp3 1)
						)
					)
					(7
						(if (== (gGame getDisc: 6) 99)
							(= temp3 1)
						)
					)
				)
				(if (not temp3)
					(= cycles 2)
				)
			)
			(7
				(gCast eachElementDo: #dispose)
				(= cycles 2)
			)
			(8
				(= global124 (gSaveManager nextSaveSlot:))
				(= global169 (GetTime 1)) ; SysTime12
				(gEgo x: 0 y: 0)
				(gGame save: local173 setCursor: gWaitCursor 1)
				(gNormalCursor view: 9960)
				(SetFlag 226)
				(Lock rsVIEW 9805 0)
				(Lock rsVIEW 9103 0)
				(Lock rsVIEW 9808 0)
				(gCurRoom newRoom: 900)
			)
		)
	)
)

(instance backspaceView of View
	(properties
		view 9805
		loop 3
	)

	(method (init)
		(= x (keyboard x:))
		(= y (+ (keyboard y:) 82))
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance backspace of KeyFeature
	(properties)

	(method (doVerb theVerb invItem)
		(if (and (or (and (> argc 1) invItem) (localproc_0 self)) (> local164 0))
			(-- local164)
			([local165 local164] dispose:)
			(local173 at: local164 0)
		)
	)
)

(instance cancelView of View
	(properties
		view 9805
		loop 3
	)

	(method (init)
		(= x (+ (keyboard x:) 191))
		(= y (+ (keyboard y:) 82))
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance cancel of KeyFeature
	(properties)

	(method (doVerb theVerb invItem)
		(if (or (and (> argc 1) invItem) (localproc_0 self))
			(gCurRoom newRoom: 91) ; saveRest
		)
	)
)

(instance bsText of View
	(properties
		view 9805
		loop 4
	)

	(method (init)
		(= x (+ (keyboard x:) 23))
		(= y (+ (keyboard y:) 87))
		(super init: &rest)
	)
)

(instance cancelText of View
	(properties
		view 9805
		loop 5
	)

	(method (init)
		(= x (+ (keyboard x:) 144))
		(= y (+ (keyboard y:) 87))
		(super init: &rest)
	)
)

(instance nameTitle of View
	(properties
		x 53
		y 49
		view 9805
		loop 1
	)

	(method (init)
		(= x (+ (keyboard x:) 9))
		(= y (- (keyboard y:) 12))
		(super init: &rest)
	)
)

