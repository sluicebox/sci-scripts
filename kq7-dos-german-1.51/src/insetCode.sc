;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use ExitButton)
(use HotSpot)
(use DText)
(use Str)
(use Inset)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	insetCode 0
	invInset 1
)

(local
	local0
	local1
	local2
	local3
	local4 = -1
	[local5 16] = [4 10 -30 15 12 6 -2 -11 -24 -36 -39 -35 -30 -25 -8 1]
	[local21 16] = [-22 -20 -17 -15 -9 -1 3 3 0 -10 -17 -22 -25 -25 -25 -25]
	[local37 16] = [29 40 -7 41 34 14 8 4 -4 -9 -18 -22 -11 1 4 16]
	[local53 16] = [-2 -5 -3 1 -6 8 8 8 6 4 2 -1 -2 -5 -7 -6]
	local69
)

(instance insetCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 0)
		(invInset
			view: 24
			loop: 0
			cel: 0
			x: (+ (Abs (gThePlane left:)) 100)
			y: (+ (Abs (gThePlane top:)) 15)
			disposeNotOnMe: 0
		)
		(invInset init: temp0 gCurRoom 0 1 param1)
	)
)

(instance invInset of Inset
	(properties)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4)
		(= local69 0)
		(super init: param1 param2 0 param4)
		(gGame setCursor: gNormalCursor 1)
		(= local4 -1)
		(= local2 global124)
		((= global124 (Cast new:)) name: {inIntHotCast} add:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(closeBox init:)
		(= temp0 (- (CelHigh view loop cel) 10))
		(= temp1 (CelWide view loop cel))
		(= local0 param5)
		(= temp2 (gInventory indexOf: param5))
		(= local3 (local0 verb:))
		(itemProp view: (+ 200 temp2) baseView: (+ 200 temp2))
		(= temp4 (Str newWith: 100 {}))
		(if
			(or
				(and (== (local0 verb:) 72) (IsFlag 218))
				(and (== (local0 verb:) 87) (IsFlag 214))
			)
			(Message msgGET 800 5 (local0 verb:) 0 2 (temp4 data:))
		else
			(Message msgGET 800 5 (local0 verb:) 0 1 (temp4 data:))
		)
		((= local1 (DText new:))
			text: (temp4 data:)
			fore: 1
			back: 0
			font: 0
			setSize:
			setPri: 255
		)
		(local1
			x: (- (/ temp1 2) (/ (- (local1 textRight:) (local1 textLeft:)) 2))
			y: (- temp0 1)
			init:
		)
		(switch temp2
			(7
				(cond
					((or (IsFlag 43) (and (IsFlag 82) (not (IsFlag 84))))
						(if (IsFlag 43)
							(SetFlag 83)
						)
						(itemProp loop: 2)
					)
					((IsFlag 83)
						(itemProp loop: 1)
					)
					(else
						(itemProp loop: 0)
					)
				)
			)
			(24
				(if (IsFlag 68)
					(itemProp view: 20224 baseView: 20224)
					(local1 dispose:)
					(= temp4 (Str newWith: 100 {}))
					(Message msgGET 800 5 (local0 verb:) 0 2 (temp4 data:))
					((= local1 (DText new:))
						text: (temp4 data:)
						fore: 1
						back: 0
						font: 0
						setSize:
						setPri: 255
					)
					(local1
						x:
							(-
								(/ temp1 2)
								(/ (- (local1 textRight:) (local1 textLeft:)) 2)
							)
						y: (- temp0 1)
						init:
					)
				)
			)
			(26
				(itemProp loop: global319)
			)
			(29
				(itemProp loop: (IsFlag 79))
			)
			(33
				(if (IsFlag 68)
					(itemProp view: 20233 baseView: 20233)
					(local1 dispose:)
					(= temp4 (Str newWith: 100 {}))
					(Message msgGET 800 5 (local0 verb:) 0 2 (temp4 data:))
					((= local1 (DText new:))
						text: (temp4 data:)
						fore: 1
						back: 0
						font: 0
						setSize:
						setPri: 255
					)
					(local1
						x:
							(-
								(/ temp1 2)
								(/ (- (local1 textRight:) (local1 textLeft:)) 2)
							)
						y: (- temp0 1)
						init:
					)
				)
			)
			(45
				(itemProp loop: (IsFlag 66))
			)
			(46
				(itemProp loop: (IsFlag 115))
			)
			(74
				(itemProp loop: 1)
			)
			(48
				(if (IsFlag 249)
					(itemProp loop: 1)
				)
			)
			(65
				(if (IsFlag 218)
					(itemProp view: 279)
				)
			)
			(68
				(if (IsFlag 211)
					(itemProp view: 281)
				)
			)
			(71
				(if (IsFlag 214)
					(itemProp view: 271)
				else
					(itemProp view: 280)
				)
			)
		)
		(= temp3
			(cond
				((== temp2 23) 11)
				((and (== temp2 24) (IsFlag 196)) 9)
				((and (== temp2 33) (IsFlag 197)) 7)
				(else 0)
			)
		)
		(itemProp cel: temp3 init: 0 0 temp0 temp1)
		(self drawInset:)
	)

	(method (handleEvent event)
		(event localize: (invInset plane:))
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_ESCAPE
						(dispScr init:)
						(event claimed: 1)
					)
					(KEY_RETURN
						(event type: evMOUSEBUTTON)
						(self handleEvent: event)
					)
					(KEY_SPACE
						(event type: evMOUSEBUTTON)
						(self handleEvent: event)
					)
				)
			)
			(evMOUSEBUTTON
				(cond
					((closeBox onMe: event)
						(closeBox handleEvent: event)
					)
					((and (itemProp scratch:) (itemProp onMe: event))
						(event claimed: 1)
						(itemProp doVerb: (event message:))
					)
					((and (itemFeat scratch:) (itemFeat onMe: event))
						(itemFeat handleEvent: event)
					)
					(else
						(itemProp handleEvent: event)
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (dispose)
		(if (not local69)
			(= local69 1)
			(gMouseDownHandler delete: self)
			(gKeyDownHandler delete: self)
			(local1 dispose:)
			(global124 release: dispose:)
			(= global124 local2)
			(super dispose:)
			(gUser message: local3)
			(gNormalCursor setCycle: 0)
			(gGame setCursor: gTheInvCursor 1)
		)
	)
)

(instance dispScr of Script
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
				(= cycles 2)
			)
			(1
				(invInset dispose:)
			)
		)
	)
)

(instance closeBox of View
	(properties
		x 8
		y 7
		view 24
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 9998)
	)

	(method (setHotspot param1)
		(cond
			((and (== argc 1) (not [param1 0]))
				(if scratch
					(self deleteHotspot:)
				)
			)
			((and (== argc 1) (!= [param1 0] 9998))
				(scratch setProps: [param1 0])
			)
			(else
				(if scratch
					(self deleteHotspot:)
				)
				(= scratch (closeHotSpot new:))
				(global123 add: self)
				(scratch setProps: [param1 0] &rest)
			)
		)
	)

	(method (doVerb)
		(invInset dispose:)
	)
)

(instance closeHotSpot of HotSpot
	(properties)

	(method (doit)
		(if (gUser useHotspots:)
			(gTheCursor view: 999 loop: 0 setCycle: Fwd cycleSpeed: 6)
		)
		(= global331 gTheCursor)
		(gUser message: theVerb)
	)
)

(class RotProp of Prop
	(properties
		baseView -1
		oldCursorX 0
		oldCursorY 0
		done 0
		prevDir 0
		rotating 0
		tmpEvent 0
		lastTime 0
		howManyV 0
		howManyL 0
	)

	(method (init param1 param2 param3 param4)
		(= x (+ param2 (/ (- param4 param2) 2)))
		(= y (+ param1 (/ (- param3 param1) 2)))
		(super init:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evMOUSEBUTTON
				(= oldCursorX gMouseX)
				(= oldCursorY gMouseY)
				(gGame setCursor: gTheCursor 0)
				(= done (= rotating 0))
				(while (not done)
					(= tmpEvent ((User curEvent:) new:))
					(if (== (tmpEvent type:) evKEYBOARD)
						(MapKeyToDir tmpEvent)
					)
					(= temp0 (tmpEvent type:))
					(= temp1 (tmpEvent message:))
					(= gMouseX (tmpEvent x:))
					(= gMouseY (tmpEvent y:))
					(cond
						((& temp0 $0002)
							(= done 1)
						)
						((& temp0 $0008)
							(if (OneOf temp1 13 32)
								(= done 1)
							)
						)
						((& temp0 $0040)
							(= done 1)
						)
						((& temp0 $0010)
							(if temp1
								(= prevDir temp1)
								(if (not (& temp0 $0004))
									(= rotating 1)
								)
								(self rotate: temp1)
							else
								(= rotating 0)
							)
						)
						((== temp0 0)
							(cond
								(rotating
									(if (> (- (GetTime) lastTime) 5)
										(self rotate: prevDir)
									)
								)
								((and (> gMouseX 160) (!= gMouseX oldCursorX))
									(= oldCursorX gMouseX)
									(self rotate: 3)
									(gTheCursor posn: 160 gMouseY)
								)
								((and (< gMouseX 160) (!= gMouseX oldCursorX))
									(= oldCursorX gMouseX)
									(self rotate: 7)
									(gTheCursor posn: 160 gMouseY)
								)
							)
						)
					)
					(FrameOut)
				)
				(event claimed: 1)
				(gGame setCursor: gTheCursor 1)
				(for
					((= tmpEvent (Event new:)))
					(tmpEvent type:)
					((= tmpEvent (Event new:)))
					
					(tmpEvent dispose:)
				)
				(tmpEvent dispose:)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (rotate param1)
		(= lastTime (GetTime))
		(switch param1
			(3
				(++ cel)
				(if (> cel 15)
					(= cel 0)
				)
			)
			(7
				(-- cel)
				(if (< cel 0)
					(= cel 15)
				)
			)
		)
		(UpdateScreenItem self)
		(self doit:)
	)
)

(instance itemFeat of Feature
	(properties)

	(method (init param1 param2 param3 param4)
		(self
			nsLeft: param1
			nsTop: param2
			nsRight: param3
			nsBottom: param4
			setHotspot: 9998
		)
		(super init:)
	)

	(method (setHotspot param1)
		(cond
			((and (== argc 1) (not [param1 0]))
				(if scratch
					(self deleteHotspot:)
				)
			)
			((and (== argc 1) (!= [param1 0] 9998))
				(scratch setProps: [param1 0])
			)
			(else
				(if scratch
					(self deleteHotspot:)
				)
				(= scratch (closeHotSpot new:))
				(global123 add: self)
				(scratch setProps: [param1 0] &rest)
			)
		)
	)

	(method (doVerb)
		(itemProp doVerb:)
		(self dispose:)
	)
)

(instance itemProp of RotProp
	(properties
		howManyV 1
		howManyL 1
	)

	(method (init)
		(super init: &rest)
		(cond
			((== view 204)
				(self setHotspot: 9998)
			)
			((and (== view 207) (== loop 0))
				(self setHotspot: 9998)
			)
			((and (== view 245) (not (IsFlag 66)))
				(self setHotspot: 9998)
			)
			((== view 253)
				(= loop (IsFlag 283))
			)
		)
	)

	(method (setHotspot param1)
		(cond
			((and (== argc 1) (not [param1 0]))
				(if scratch
					(self deleteHotspot:)
				)
			)
			((and (== argc 1) (!= [param1 0] 9998))
				(scratch setProps: [param1 0])
			)
			(else
				(if scratch
					(self deleteHotspot:)
				)
				(= scratch (closeHotSpot new:))
				(global123 add: self)
				(scratch setProps: [param1 0] &rest)
			)
		)
	)

	(method (doVerb &tmp temp0 temp1 temp2 temp3)
		(switch view
			(204
				(= global308 (= temp0 (gInventory at: 3))) ; Stick
				(= local3 11)
				(self view: 203 baseView: 203 setHotspot: 0)
				(= temp1
					(-
						(CelHigh
							(invInset view:)
							(invInset loop:)
							(invInset cel:)
						)
						10
					)
				)
				(= temp2
					(CelWide (invInset view:) (invInset loop:) (invInset cel:))
				)
				(= temp3 (Str newWith: 100 {}))
				(Message msgGET 800 5 11 0 1 (temp3 data:)) ; "Stick"
				(local1 dispose:)
				((= local1 (DText new:))
					text: (temp3 data:)
					fore: 1
					back: 0
					font: 0
					setSize:
					setPri: 255
				)
				(local1
					x:
						(-
							(/ temp2 2)
							(/ (- (local1 textRight:) (local1 textLeft:)) 2)
						)
					y: (- temp1 1)
					init:
				)
				((gInventory at: 4) owner: -1 hide:) ; Flag
				(gEgo get: 1 get: 3) ; Ripped_Petticoat, Stick
				(global124 delete: (gInventory at: 1)) ; Ripped_Petticoat
				(global124 delete: temp0)
				(local2 add: (gInventory at: 1)) ; Ripped_Petticoat
				(local2 add: temp0)
				((ScriptID 18 2) doit:) ; reposition
				(temp0 hide:)
				(gNormalCursor setCycle: 0 setCel: 0)
				(gTheInvCursor
					view: (temp0 cView:)
					loop: (temp0 cLoop:)
					cel: (temp0 cCel:)
				)
			)
			(207
				(if (not (IsFlag 83))
					(SetFlag 83)
					(self loop: 1 setHotspot: 0)
				else
					(SetFlag 82)
					(ClearFlag 84)
					(gEgo get: 14) ; Corn_Kernel
					(global124 delete: (gInventory at: 14)) ; Corn_Kernel
					(local2 add: (gInventory at: 14)) ; Corn_Kernel
					(self loop: 2)
					(gNormalCursor setCycle: 0 setCel: 0)
				)
			)
			(229
				(SetFlag 79)
				(gEgo get: 30) ; Shield_Spike
				(global124 delete: (gInventory at: 30)) ; Shield_Spike
				(local2 add: (gInventory at: 30)) ; Shield_Spike
				(self loop: 1 setHotspot: 0)
				(gNormalCursor setCycle: 0 setCel: 0)
				(local0 view: 329 loop: 1 cel: 0 cView: 991 cLoop: 4 cCel: 7)
				(gTheInvCursor
					view: (local0 cView:)
					loop: (local0 cLoop:)
					cel: (local0 cCel:)
				)
			)
			(245
				(SetFlag 66)
				(self loop: 1 setHotspot: 0)
				(gNormalCursor setCycle: 0 setCel: 0)
				(local0 view: 345 loop: 0 cel: 1 cView: 991 cLoop: 4 cCel: 9)
				(gTheInvCursor
					view: (local0 cView:)
					loop: (local0 cLoop:)
					cel: (local0 cCel:)
				)
			)
			(246
				(SetFlag 115)
				(gEgo get: 41) ; Feather
				(global124 delete: (gInventory at: 41)) ; Feather
				(local2 add: (gInventory at: 41)) ; Feather
				(self loop: 1 setHotspot: 0)
				(gNormalCursor setCycle: 0 setCel: 0)
				(local0 view: 346 loop: 0 cel: 1 cView: 991 cLoop: 3 cCel: 1)
				(gTheInvCursor
					view: (local0 cView:)
					loop: (local0 cLoop:)
					cel: (local0 cCel:)
				)
			)
			(253
				(if (IsFlag 283)
					(ClearFlag 283)
					(if (and (gEgo has: 55) (not (IsFlag 338))) ; Scarab
						((gInventory at: 55) setHotspot: 0 69) ; Scarab, Magic_Wand
						((gInventory at: 53) setHotspot: 0 74) ; Magic_Wand, Scarab
					)
				else
					(SetFlag 283)
					(if (gEgo has: 55) ; Scarab
						((gInventory at: 55) deleteHotVerb: 69) ; Scarab, Magic_Wand
						((gInventory at: 53) deleteHotVerb: 74) ; Magic_Wand, Scarab
					)
				)
				(UpdateScreenItem (self setLoop: (^ loop $0001) yourself:))
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit:)
		(cond
			((and (not (IsFlag 196)) (== view 224) (>= cel 9))
				(SetFlag 196)
				(local0 cView: 991 cLoop: 4 cCel: 3)
				(gTheInvCursor
					view: (local0 cView:)
					loop: (local0 cLoop:)
					cel: (local0 cCel:)
				)
			)
			((and (not (IsFlag 197)) (== view 233) (>= cel 7))
				(SetFlag 197)
				(local0 cView: 991 cLoop: 4 cCel: 5)
				(gTheInvCursor
					view: (local0 cView:)
					loop: (local0 cLoop:)
					cel: (local0 cCel:)
				)
			)
			((and (== view 229) (== loop 0))
				(cond
					((OneOf cel 0 1 9 10 11 12 13 14 15)
						(if (!= cel local4)
							(= local4 cel)
							(itemFeat dispose:)
							(switch cel
								(0
									(= temp0 -20)
									(= temp1 -4)
									(= temp2 4)
									(= temp3 14)
								)
								(1
									(= temp0 -20)
									(= temp1 -2)
									(= temp2 0)
									(= temp3 12)
								)
								(9
									(= temp0 -2)
									(= temp1 -2)
									(= temp2 15)
									(= temp3 11)
								)
								(10
									(= temp0 -4)
									(= temp1 -3)
									(= temp2 18)
									(= temp3 12)
								)
								(11
									(= temp0 -5)
									(= temp1 -2)
									(= temp2 16)
									(= temp3 11)
								)
								(12
									(= temp0 -7)
									(= temp1 -2)
									(= temp2 7)
									(= temp3 13)
								)
								(13
									(= temp0 -10)
									(= temp1 -3)
									(= temp2 8)
									(= temp3 9)
								)
								(14
									(= temp0 -10)
									(= temp1 -2)
									(= temp2 5)
									(= temp3 12)
								)
								(15
									(= temp0 -16)
									(= temp1 -2)
									(= temp2 2)
									(= temp3 12)
								)
							)
							(itemFeat
								init:
									(+ (self x:) temp0)
									(+ (self y:) temp1)
									(+ (self x:) temp2)
									(+ (self y:) temp3)
							)
						)
					)
					((itemFeat scratch:)
						(= local4 -1)
						(itemFeat dispose:)
					)
				)
			)
			((and (== view 207) (== loop 1))
				(cond
					((OneOf cel 3 4 5)
						(if (!= cel local4)
							(= local4 cel)
							(itemFeat dispose:)
							(switch cel
								(3
									(= temp0 -13)
									(= temp1 -8)
									(= temp2 1)
									(= temp3 10)
								)
								(4
									(= temp0 -14)
									(= temp1 -9)
									(= temp2 7)
									(= temp3 10)
								)
								(5
									(= temp0 -7)
									(= temp1 -7)
									(= temp2 11)
									(= temp3 7)
								)
							)
							(itemFeat
								init:
									(+ (self x:) temp0)
									(+ (self y:) temp1)
									(+ (self x:) temp2)
									(+ (self y:) temp3)
							)
						)
					)
					((itemFeat scratch:)
						(= local4 -1)
						(itemFeat dispose:)
					)
				)
			)
			((and (== view 246) (== loop 0))
				(if (!= cel local4)
					(= local4 cel)
					(itemFeat dispose:)
					(itemFeat
						init:
							(+ x [local5 cel])
							(+ y [local21 cel])
							(+ x [local37 cel])
							(+ y [local53 cel])
					)
				)
			)
			((and (== view 253) (!= cel local4))
				(= local4 cel)
				(switch cel
					(3
						(itemFeat
							dispose:
							init: (+ x 10) (+ y 13) (+ x 26) (+ y 22)
						)
					)
					(4
						(itemFeat
							dispose:
							init: (+ x 7) (+ y 16) (+ x 21) (+ y 27)
						)
					)
					(5
						(itemFeat
							dispose:
							init: (+ x 2) (+ y 16) (+ x 14) (+ y 32)
						)
					)
					(6
						(itemFeat
							dispose:
							init: (- x 4) (+ y 17) (+ x 3) (+ y 34)
						)
					)
					(7
						(itemFeat
							dispose:
							init: (- x 10) (+ y 15) (- x 3) (+ y 31)
						)
					)
					(8
						(itemFeat
							dispose:
							init: (- x 14) (+ y 12) (- x 10) (+ y 28)
						)
					)
				)
			)
		)
	)
)

