;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use DButton)
(use DText)
(use Str)
(use Print)
(use Dialog)
(use User)
(use System)

(public
	dCastD 0
	showFeatureCode 1
)

(local
	local0
)

(class JustifyText of Obj
	(properties
		lastX 0
		lastY 0
		font 0
		color 0
	)

	(method (init)
		(super init:)
		(= local0 (Str newWith: 50 {}))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gTheDoits addToFront: self)
		(GetInput @local0 50 {Enter text (after this, get help with '?')})
		(self doit: 1)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (event x:))
		(= temp2 (event y:))
		(= temp3 (event type:))
		(= temp4 (event message:))
		(= temp5 (event modifiers:))
		(cond
			((== temp3 evKEYBOARD)
				(switch temp4
					(KEY_ESCAPE
						(self dispose:)
					)
					(KEY_RETURN
						(self showCoord: event)
					)
					(JOY_DOWNLEFT
						(switch font
							(1207
								(= font 2107)
							)
							(2107
								(= font 2108)
							)
							(2108
								(= font 2407)
							)
							(2407
								(= font 2510)
							)
							(2510
								(= font 4115)
							)
							(4115
								(= font 999)
							)
							(999
								(= font 0)
							)
							(else
								(= font (GetNumber {Font Number:}))
							)
						)
						(gGame setCursor: gTheCursor 0 temp1 temp2)
						(self doit: 1)
					)
					($000e
						(= temp6 (Str newWith: 25))
						(GetInput
							@temp6
							50
							{Enter text (then get help with `?')}
						)
						(if (temp6 data:)
							(local0 copy: temp6)
							(= lastX (= lastY 0))
							(self doit: 1)
						)
					)
					(JOY_RIGHT
						(if (> (++ color) 15)
							(= color 0)
						)
						(self doit: 1)
					)
					(KEY_QUESTION
						(Prints
							{Move text with mouse or direction keys\nSHIFT + arrows for fine adjustment\n\nENTER or click shows text position\n\nCtrl-F (shift click) changes font\nCtrl-N to enter new text\nCtrl-C (control click) changes color\nESC aborts}
						)
					)
				)
				(event claimed: 1)
			)
			((== temp3 evMOUSEBUTTON)
				(cond
					((& temp5 emSHIFT)
						(event type: evKEYBOARD message: JOY_DOWNLEFT)
						(self handleEvent: event)
					)
					((& temp5 emCTRL)
						(event type: evKEYBOARD message: JOY_RIGHT)
						(self handleEvent: event)
					)
					(else
						(self showCoord: event)
						(event claimed: 1)
					)
				)
			)
			((& temp3 $0010) ; direction
				(= temp0 (if (& temp5 emSHIFT) 1 else 10))
				(if (OneOf temp4 JOY_RIGHT JOY_UPRIGHT JOY_DOWNRIGHT)
					(+= temp1 temp0)
				)
				(if (OneOf temp4 JOY_LEFT JOY_UPLEFT JOY_DOWNLEFT)
					(-= temp1 temp0)
				)
				(if (OneOf temp4 JOY_UPLEFT JOY_UP JOY_UPRIGHT)
					(-= temp2 temp0)
				)
				(if (OneOf temp4 JOY_DOWNLEFT JOY_DOWN JOY_DOWNRIGHT)
					(+= temp2 temp0)
				)
				(event claimed: 1)
				(self doit:)
			)
		)
	)

	(method (showCoord param1)
		(Printf {Position: %d, %d} (param1 x:) (param1 y:))
		(self dispose:)
	)

	(method (doit param1 &tmp temp0 temp1)
		(if (and argc param1)
			(= lastX (= lastY 0))
		)
		(= temp0 ((User curEvent:) x:))
		(= temp1 ((User curEvent:) y:))
		(if (or (!= temp0 lastX) (!= temp1 lastY))
			(= lastX temp0)
			(= lastY temp1)
		)
	)
)

(class NameFeatureCode of Code
	(properties)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gTheDoits delete: self)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event claimed: 1)
			(self dispose:)
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (Str newWith: 40))
		(OnMeAndLowY init:)
		(gFeatures eachElementDo: #perform OnMeAndLowY (User curEvent:))
	)
)

(instance showFeatureCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if param2
			(= temp0 (param1 brTop:))
			(= temp1 (param1 brLeft:))
			(= temp3 (param1 brBottom:))
			(= temp2 (param1 brRight:))
			(Graph 3 temp0 temp1 temp0 temp2 40)
			(Graph 3 temp3 temp1 temp3 temp2 40)
			(Graph 3 temp0 temp1 temp3 temp1 40)
			(Graph 3 temp0 temp2 temp3 temp2 40)
		else
			(= temp0 (param1 nsTop:))
			(= temp1 (param1 nsLeft:))
			(= temp3 (param1 nsBottom:))
			(= temp2 (param1 nsRight:))
			(Graph 3 temp0 temp1 temp0 temp2 0)
			(Graph 3 temp3 temp1 temp3 temp2 0)
			(Graph 3 temp0 temp1 temp3 temp1 0)
			(Graph 3 temp0 temp2 temp3 temp2 0)
		)
		(= temp4 (- (param1 y:) 1))
		(= temp5 (- (param1 x:) 1))
		(= temp7 (+ (param1 y:) 1))
		(= temp6 (+ (param1 x:) 1))
		(Graph 3 temp4 temp5 temp4 temp6 44)
		(Graph 3 (+ temp4 1) temp5 (+ temp4 1) temp6 44)
		(Graph 3 temp7 temp5 temp7 temp6 44)
		(= temp8 (Min temp0 temp4))
		(= temp9 (Min temp1 temp5))
		(= temp11 (Max temp3 temp7))
		(= temp10 (Max temp2 temp6))
	)
)

(instance dCastD of Dialog
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (gCast first:)))
			temp5
			((= temp5 (gCast next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(++ temp3)
			(self
				add:
					((= temp4 (DText new:))
						value: temp6
						text: (temp6 name:)
						nsLeft: temp0
						nsTop: temp1
						state: 3
						font: gSmallFont
						setSize:
						yourself:
					)
			)
			(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
			)
			(if (> (+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1)) 100)
				(= temp1 4)
				(+= temp0 (+ temp2 10))
				(= temp2 0)
			)
		)
		(self setSize:)
		(= gDButton (DButton new:))
		(gDButton
			text: {exit}
			setSize:
			moveTo: (- nsRight (+ 4 (gDButton nsRight:))) nsBottom
		)
		(gDButton move: (- (gDButton nsLeft:) (gDButton nsRight:)) 0)
		(self add: gDButton setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0 temp1)
		(self init:)
		(self open: 4 15)
		(= temp0 gDButton)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 gDButton)
				)
				(break)
			)
			(= global106 (temp0 value:))
		)
		(self eachElementDo: #dispose 1 dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event message:))
		(switch (= temp1 (event type:))
			(evKEYBOARD
				(switch temp0
					(KEY_UP
						(= temp0 KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= temp0 KEY_TAB)
					)
				)
			)
			($0010 ; direction
				(switch temp0
					(JOY_UP
						(= temp0 KEY_SHIFTTAB)
						(= temp1 evKEYBOARD)
					)
					(JOY_DOWN
						(= temp0 KEY_TAB)
						(= temp1 evKEYBOARD)
					)
				)
			)
		)
		(event type: temp1 message: temp0)
		(super handleEvent: event)
	)
)

