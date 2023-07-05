;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use Inset)
(use Feature)
(use Actor)
(use System)

(public
	getPassword 0
)

(local
	[local0 26] = [0 85 43 43 43 64 85 107 149 128 149 171 128 107 171 192 0 64 21 85 128 64 21 21 107 0]
	[local26 26] = [42 61 61 42 23 42 42 42 23 42 42 42 61 61 23 23 23 23 42 23 23 61 23 61 23 61]
	[local52 26] = [19 105 62 62 62 83 105 126 169 147 169 190 147 126 190 211 19 83 41 105 147 83 41 41 126 19]
	[local78 26] = [59 78 78 59 41 59 59 59 41 59 59 59 78 78 41 41 41 41 59 41 41 78 41 78 41 78]
	[local104 26] = [0 85 43 43 43 64 85 107 149 128 149 171 128 107 171 192 0 64 21 85 128 64 21 21 107 0]
	[local130 26] = [42 61 61 42 23 42 42 42 23 42 42 42 61 61 23 23 23 23 42 23 23 61 23 61 23 61]
	[local156 20] = [80 90 100 110 120 130 140 150 160 170 180 190 200 210 220 230 240 250 260 270]
	local176
	[local177 15]
	local192
	[local193 26]
	local219
	local220
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

(instance getPassword of Script
	(properties)

	(method (init param1 param2 param3 param4)
		(if (Robot 6) ; Exists
			(Robot 10) ; Pause
		)
		(= local219 param3)
		(= local220 param4)
		(= lastTicks gGameTime)
		(if (and argc param1)
			(= caller param1)
		else
			(= caller 0)
		)
		(= state (- start 1))
		(self cue:)
		(gTheDoits add: self)
		((ScriptID 0 19) doit: 1) ; intHSCode
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
		((ScriptID 0 19) doit: 0) ; intHSCode
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheControlList eachElementDo: #enable 0)
				(gInventory eachElementDo: #enable 0)
				(gCurRoom setInset: passInset self)
			)
			(1
				(switch (PasswordFile hasPassword:)
					(3
						((ScriptID 0 18) doVerb: 32 2 self) ; helpIcon
					)
					(2
						((ScriptID 0 18) doVerb: 32 2 self) ; helpIcon
					)
					(else
						((ScriptID 0 18) doVerb: 31 2 self) ; helpIcon
					)
				)
			)
			(2
				(gGame setCursor: gNormalCursor 1)
				(gUser canInput: 1)
			)
			(3
				(FrameOut)
				(gGame handsOn:)
				(gUser input: local219 controls: local220)
				(gNormalCursor view: 9960)
				(if (and (Robot 6) (not (IsFlag 297))) ; Exists
					(Robot 4) ; Play
				)
				(self dispose:)
			)
		)
	)
)

(instance flashCel of View
	(properties)
)

(instance passInset of Inset
	(properties)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(super init: param1 param2 param3 param4)
		(= local176 0)
		(= local192 (Str newWith: 16 {}))
		(KString 5 (local192 data:) 0 16 0) ; StrFill
		(gUser canInput: 1)
		(gGame setCursor: gNormalCursor 1)
		(keyboard
			x: (if (OneOf gCurRoomNum 901 902) 58 else 44) ; selectGameRoom, nameGameRoom
			y: (if (OneOf gCurRoomNum 901 902) 47 else 20) ; selectGameRoom, nameGameRoom
		)
		(keyboard init:)
		(flashCel view: 9805 init: hide:)
		(for ((= temp0 0)) (< temp0 26) ((++ temp0))
			((= [local193 temp0] (KeyFeat new:))
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
					(= temp1 [local193 temp0])
					(temp1 doVerb: 0 1 keyFlash:)
				else
					(event claimed: 1)
					(switch temp0
						(JOY_UPLEFT
							(backspace doVerb: 0 1 keyFlash:)
						)
						(KEY_RETURN
							(doneFeat doVerb: 0 1 keyFlash:)
						)
						(KEY_ESCAPE
							(cancel doVerb: 0 1 keyFlash:)
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

	(method (dispose)
		((gUser curEvent:) globalize:)
		(if local192
			(local192 dispose:)
		)
		(gSounds pause: 0)
		(= local192 0)
		(super dispose:)
	)
)

(instance keyboard of View
	(properties
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

(class KeyFeat of Feature
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
		(if
			(and
				(< local176 15)
				(or (and (> argc 1) invItem) (localproc_0 self))
			)
			(local192 at: local176 (+ value 65))
			((= [local177 local176] (View new:))
				view: 9805
				setLoop: (+ 6 (/ value 16))
				setCel: (mod value 16)
				x: [local156 local176]
				y: (+ (keyboard y:) 12)
				fixPriority: 1
				priority: 10
				init:
			)
			(++ local176)
		)
	)
)

(instance doneFeat of KeyFeat
	(properties)

	(method (doVerb theVerb invItem)
		(if (or (and (> argc 1) invItem) (localproc_0 self))
			(cond
				((<= (local192 size:) 0)
					(Prints 0 0 0 2 -1 -1 93)
				)
				((OneOf (PasswordFile hasPassword:) 2 3)
					(if (PasswordFile checkPassword: local192)
						(passDispScr register: 1 init:)
						(SetFlag 63)
						(PasswordFile newPassword: local192)
					else
						(Prints 0 0 0 1 -1 -1 93)
					)
				)
				(else
					(if (IsFlag 63)
						(ClearFlag 63)
					else
						(SetFlag 63)
					)
					(PasswordFile newPassword: local192)
					(passDispScr register: 2 init:)
				)
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

(instance backspace of KeyFeat
	(properties)

	(method (doVerb theVerb invItem)
		(if (and (or (and (> argc 1) invItem) (localproc_0 self)) (> local176 0))
			(-- local176)
			([local177 local176] dispose:)
			(local192 at: local176 0)
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

(instance cancel of KeyFeat
	(properties)

	(method (doVerb theVerb invItem)
		(if (or (and (> argc 1) invItem) (localproc_0 self))
			(passDispScr init: register: 0)
		)
	)
)

(instance passDispScr of Script
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(passInset dispose:)
				(if (not (IsFlag 145))
					(switch register
						(1
							((ScriptID 0 18) doVerb: 32 3 0) ; helpIcon
						)
						(2
							((ScriptID 0 18) doVerb: 31 3 0) ; helpIcon
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance bsText of View
	(properties
		view 9805
		loop 4
	)

	(method (init)
		(= x (+ (keyboard x:) 22))
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
		(= x (+ (keyboard x:) 146))
		(= y (+ (keyboard y:) 87))
		(super init: &rest)
	)
)

(instance nameTitle of View
	(properties
		view 9805
	)

	(method (init)
		(= x (+ (keyboard x:) 14))
		(= y (- (keyboard y:) 12))
		(super init: &rest)
	)
)

