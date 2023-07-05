;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Dialog)
(use Feature)
(use Window)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
)

(local
	local0
	[local1 25]
	local26
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40]) ; UNUSED
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 899 0 param2) ; "%d"
	)
	(return
		(if (GetInput @temp0 10 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (localproc_1)
	(if (OneOf (gCurRoom style:) 11 12 13 14)
		(gCurRoom drawPic: (gCurRoom picture:) 100 style: 100)
	)
)

(instance debugHandler of Feature
	(properties)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
		(DisposeScript 974)
		(DisposeScript 899)
	)

	(method (handleEvent event &tmp [temp0 160] temp160 temp161 temp162 temp163 temp164 temp165 temp166 temp167 temp168 temp169 temp170 temp171 temp172 temp173 temp174 temp175 temp176 temp177)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_a
						(for
							((= temp162 (gCast first:)))
							temp162
							((= temp162 (gCast next: temp162)))
							
							(= temp164 (NodeValue temp162))
							(Format ; "class: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x"
								@temp0
								899
								1
								((temp164 -super-:) name:)
								(temp164 view:)
								(temp164 loop:)
								(temp164 cel:)
								(temp164 x:)
								(temp164 y:)
								(temp164 z:)
								(temp164 heading:)
								(temp164 priority:)
								(temp164 signal:)
								(if (temp164 isKindOf: Actor)
									(temp164 illegalBits:)
								else
									-1
								)
							)
							(if
								(not
									(Print
										addText: @temp0
										window: SysWindow
										title: (temp164 name:)
										addIcon:
											(temp164 view:)
											(temp164 loop:)
											(temp164 cel:)
										init:
									)
								)
								(break)
							)
						)
					)
					(KEY_ALT_b
						(Unknown_Class_101 doit:)
					)
					(KEY_ALT_c
						(localproc_1)
						(Show 4)
					)
					(KEY_ALT_d
						(dCastD doit:)
					)
					(KEY_ALT_e
						(Format ; "name: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x OnControl: $%x Origin on: $%x"
							@temp0
							899
							2
							(gEgo name:)
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
							(gEgo x:)
							(gEgo y:)
							(gEgo z:)
							(gEgo heading:)
							(gEgo priority:)
							(gEgo signal:)
							(gEgo illegalBits:)
							(gEgo onControl:)
							(gEgo onControl: 1)
						)
						(Print
							addText: @temp0
							addIcon:
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							init:
						)
					)
					(KEY_ALT_f
						(gFeatures eachElementDo: #perform showFeatureCode 0)
						(gCast eachElementDo: #perform showFeatureCode 1)
						(NameFeatureCode init:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 6 {Variable No.})
						(= temp162 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 6 {Value})
						(= [gEgo temp162] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(Print
							addText: {Global number:}
							addEdit: @temp0 6 0 12
							init:
						)
						(= temp162 (ReadNumber @temp0))
						(if (IsObject [gEgo temp162])
							(Format
								@temp0
								{ Global %d: %s }
								temp162
								([gEgo temp162] name:)
							)
						else
							(Format
								@temp0
								{ Global %d: %d }
								temp162
								[gEgo temp162]
							)
						)
						(Prints @temp0)
					)
					(KEY_ALT_i
						(dInvD doit:)
					)
					(KEY_ALT_j
						(JustifyText init:)
					)
					(KEY_ALT_k
						(= temp160 (GetPort))
						(SetPort 0)
						(= temp171 5)
						(= temp172 16)
						(= temp167 15)
						(= temp168 80)
						(= temp170 (+ temp167 (* 34 temp171)))
						(= temp169 (+ temp168 (* 10 temp172)))
						(= temp165 (Graph grSAVE_BOX temp167 temp168 temp170 temp169 1))
						(Graph grFILL_BOX temp167 temp168 temp170 temp169 1 255)
						(for ((= temp166 0)) (< temp166 256) ((++ temp166))
							(Graph
								grFILL_BOX
								(+ temp167 temp171 (* temp171 (/ temp166 8)))
								(+ temp168 temp172 (* 16 (mod temp166 8)))
								(+
									temp167
									temp171
									temp171
									(* temp171 (/ temp166 8))
								)
								(+
									temp168
									temp172
									temp172
									(* temp172 (mod temp166 8))
								)
								1
								temp166
							)
						)
						(Graph grUPDATE_BOX temp167 temp168 temp170 temp169 1)
						(repeat
							(= temp161 (Event new:))
							(if
								(or
									(== (temp161 type:) evMOUSEBUTTON)
									(== (temp161 type:) evKEYBOARD)
								)
								(break)
							)
							(temp161 dispose:)
						)
						(temp161 dispose:)
						(Graph grRESTORE_BOX temp165)
						(Graph grUPDATE_BOX temp167 temp168 temp170 temp169 1)
						(SetPort temp160)
					)
					(KEY_ALT_l
						(= temp0 0)
						(= temp162 (GetNumber {Flag No.}))
						(SetFlag temp162)
					)
					(KEY_ALT_m
						(= temp0 0)
						(= temp162 (GetNumber {Flag No.}))
						(ClearFlag temp162)
					)
					(KEY_ALT_n
						(= temp0 0)
						(= temp162 (GetNumber {Flag No.}))
						(Printf @temp0 {%d} (IsFlag temp162))
					)
					(KEY_ALT_o
						((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
					)
					(KEY_ALT_p
						(localproc_1)
						(Show 2)
					)
					(KEY_ALT_q
						(gGame detailLevel: 1)
					)
					(KEY_ALT_r
						(Format ; "name: %s number: %d current pic: %d style: %d horizon: %d north: %d south: %d east: %d west: %d script: %s"
							@temp0
							899
							3
							(gCurRoom name:)
							gCurRoomNum
							(gCurRoom curPic:)
							(gCurRoom style:)
							(gCurRoom horizon:)
							(gCurRoom north:)
							(gCurRoom south:)
							(gCurRoom east:)
							(gCurRoom west:)
							(if (IsObject (gCurRoom script:))
								((gCurRoom script:) name:)
							else
								{..none..}
							)
						)
						(Print width: 120 addText: @temp0 init:)
						(gGame showMem:)
					)
					(KEY_ALT_s
						(= temp0 0)
						(if
							(Print
								addText: {Which Format?}
								addButton: 0 {String} 0 12
								addButton: 1 {Message} 50 12
								init:
							)
							(= temp174 (GetNumber {Noun?} 0))
							(= temp175 (GetNumber {Verb?} 0))
							(= temp176 (GetNumber {Case?} 0))
							(= temp177 (GetNumber {Sequence?} 0))
							(Message msgGET temp174 temp175 temp176 temp177 @temp0)
						else
							(GetInput @temp0 50 {String to display?})
						)
						(= temp167 (GetNumber {Y Parameter?} 0))
						(= temp168 (GetNumber {X Parameter?} 0))
						(= temp162 (GetNumber {Box Width?} 0))
						(if (not (= temp163 (GetNumber {Font Number?} 0)))
							(= temp163 gUserFont)
						)
						(Print
							posn: temp168 temp167
							width: temp162
							font: temp163
							addText: @temp0
							init:
						)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if (> (= temp162 (GetNumber {Teleport to:})) 0)
							(gLongSong stop:)
							(gCurRoom newRoom: temp162)
						)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gTheIconBar enable: 0 1 2 3 4 5)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_w
						(Unknown_Class_102 doit:)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_QUESTION
						(Prints
							{Debug options:      (Page 1 of 5)\n\n   A - Show cast\n   B - Polygon editor\n   C - Show control map\n   D - Place an actor\n   E - Show ego info\n   F - Show feature outlines\n   G - Set global\n}
						)
						(Prints
							{Debug options:      (Page 2 of 5)\n\n   H - Show global\n   I - Get inventory item\n   J - Justify text on screen\n   K - Show palette\n   L - Set flag\n   M - Clear flag\n   N - Show flag\n}
						)
						(Prints
							{Debug options:      (Page 3 of 5)\n\n   O - QA Note Logger\n   P - Show priority map\n   Q - Set Detail to 1\n   R - Show room info/free memory\n   S - Show a string or message\n   T - Teleport\n   U - Give HandsOn\n}
						)
						(Prints
							{Debug options:      (Page 4 of 5)\n\n   V - Show visual map\n   W - Feature writer\n   X,Z - Quick quit\n}
						)
						(Prints
							{Debug options:      (Page 5 of 5)\n\n  A=Alt, C=Ctrl, L=Left shift, R=Right shift\n\n  Left click:\n    A       Move ego\n    CL      Show ego\n    CR      Show room\n    CA      Show position\n}
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(switch (event modifiers:)
					($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
					($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
					($000c ; emALT | emCTRL
						(event claimed: 1)
						(Format @temp0 899 4 (event x:) (event y:)) ; "%d/%d"
						(= temp160
							(Print
								posn: 160 10
								font: 999
								modeless: 1
								addText: @temp0
								init:
							)
						)
						(while (!= evMOUSERELEASE ((= temp161 (Event new:)) type:))
							(temp161 dispose:)
						)
						(temp161 dispose:)
						(temp160 dispose:)
					)
					($0005 ; emCTRL | emRIGHT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_r)
						(self handleEvent: event)
					)
					($0006 ; emCTRL | emLEFT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_e)
						(self handleEvent: event)
					)
					($0009 0) ; emALT | emRIGHT_SHIFT
					($000a 0) ; emALT | emLEFT_SHIFT
					(emRIGHT_SHIFT 0)
					(emLEFT_SHIFT 0)
					(emCTRL 0)
					(emALT
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp161 (Event new:)) type:))
							(= temp173
								(if global132
									global132
								else
									(User alterEgo:)
								)
							)
							(temp173
								posn: (temp161 x:) (- (temp161 y:) 10)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp161 dispose:)
						)
						(temp161 dispose:)
					)
				)
			)
		)
	)
)

(instance dInvD of Dialog
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (gInventory first:)))
			temp5
			((= temp5 (gInventory next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(++ temp3)
			(if (temp6 isKindOf: InvI)
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
			)
			(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
			)
			(if (> (+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1)) 140)
				(= temp1 4)
				(+= temp0 (+ temp2 10))
				(= temp2 0)
			)
		)
		(= window gSystemWindow)
		(self setSize:)
		(= local0 (DButton new:))
		(local0
			text: {Outta here!}
			setSize:
			moveTo: (- nsRight (+ 4 (local0 nsRight:))) nsBottom
		)
		(local0 move: (- (local0 nsLeft:) (local0 nsRight:)) 0)
		(self add: local0 setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0)
		(self init:)
		(self open: 4 15)
		(= temp0 local0)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 local0)
				)
				(break)
			)
			(gEgo get: (Inv indexOf: (temp0 value:)))
		)
		(self dispose:)
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
			($0040 ; direction
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

(instance showFeatureCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if param2
			(= temp0 (param1 brTop:))
			(= temp1 (param1 brLeft:))
			(= temp3 (param1 brBottom:))
			(= temp2 (param1 brRight:))
			(Graph grDRAW_LINE temp0 temp1 temp0 temp2 global126)
			(Graph grDRAW_LINE temp3 temp1 temp3 temp2 global126)
			(Graph grDRAW_LINE temp0 temp1 temp3 temp1 global126)
			(Graph grDRAW_LINE temp0 temp2 temp3 temp2 global126)
		else
			(= temp0 (param1 nsTop:))
			(= temp1 (param1 nsLeft:))
			(= temp3 (param1 nsBottom:))
			(= temp2 (param1 nsRight:))
			(Graph grDRAW_LINE temp0 temp1 temp0 temp2 global119)
			(Graph grDRAW_LINE temp3 temp1 temp3 temp2 global119)
			(Graph grDRAW_LINE temp0 temp1 temp3 temp1 global119)
			(Graph grDRAW_LINE temp0 temp2 temp3 temp2 global119)
		)
		(= temp4 (- (param1 y:) 1))
		(= temp5 (- (param1 x:) 1))
		(= temp7 (+ (param1 y:) 1))
		(= temp6 (+ (param1 x:) 1))
		(Graph grDRAW_LINE temp4 temp5 temp4 temp6 global129)
		(Graph grDRAW_LINE (+ temp4 1) temp5 (+ temp4 1) temp6 global129)
		(Graph grDRAW_LINE temp7 temp5 temp7 temp6 global129)
		(= temp8 (Min temp0 temp4))
		(= temp9 (Min temp1 temp5))
		(= temp11 (Max temp3 temp7))
		(= temp10 (Max temp2 temp6))
		(Graph grREDRAW_BOX temp8 temp9 (+ temp11 1) (+ temp10 1))
	)
)

(class NameFeatureCode of Code
	(properties)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gGame setCursor: 999)
		(self doit:)
	)

	(method (dispose)
		(DrawStatus 0)
		(DrawStatus { } global119 0)
		(if
			(Print
				addText: {Erase outlines?}
				addButton: 0 {No} 0 12
				addButton: 1 {Yes} 40 12
				init:
			)
			(DrawPic (gCurRoom picture:) 100)
			(if gAddToPics
				(gAddToPics doit:)
			)
		)
		(gKeyDownHandler delete: self)
		(gTheDoits delete: self)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event claimed: 1)
			(return 1)
		)
	)

	(method (doit &tmp temp0 [temp1 40] temp41 [temp42 10])
		(while (not (self handleEvent: (= temp41 (Event new:))))
			(temp41 localize:)
			(OnMeAndLowY init:)
			(gFeatures eachElementDo: #perform OnMeAndLowY temp41)
			(gCast eachElementDo: #perform OnMeAndLowY temp41)
			(if (= temp0 (OnMeAndLowY theObj:))
				(cond
					((and (temp0 onMeCheck:) (!= (temp0 onMeCheck:) 26505))
						(Format @temp42 899 5 (temp0 onMeCheck:)) ; "[control $%x]"
					)
					((temp0 respondsTo: #view)
						(Format ; "[V:%d, L:%d, C:%d]"
							@temp42
							899
							6
							(temp0 view:)
							(temp0 loop:)
							(temp0 cel:)
						)
					)
					(else
						(Format @temp42 899 7 {}) ; "%s"
					)
				)
				(DrawStatus
					(Format ; "%d, %d: %s (%s) %s"
						@temp1
						899
						8
						(temp41 x:)
						(temp41 y:)
						(temp0 name:)
						((temp0 -super-:) name:)
						@temp42
					)
				)
			)
			(temp41 dispose:)
		)
		(temp41 dispose:)
		(self dispose:)
	)
)

(class JustifyText of Obj
	(properties
		lastX 0
		lastY 0
		unders 0
		font 2510
		color 0
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gTheDoits addToFront: self)
		(= local1 0)
		(GetInput @local1 50 {Enter text (after this, get help with '?')})
		(gTheIconBar curIcon: (gTheIconBar at: 4))
		(= local26 gTheCursor)
		(gGame setCursor: 601 0)
		(self doit: 1)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheDoits delete: self)
		(gGame setCursor: local26 1)
		(UnLoad 133 unders)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 25])
		(= temp1 (event x:))
		(= temp2 (event y:))
		(= temp3 (event type:))
		(= temp4 (event message:))
		(= temp5 (event modifiers:))
		(cond
			((== temp3 evKEYBOARD)
				(switch temp4
					(KEY_ESCAPE
						(Display 899 9 dsRESTOREPIXELS unders)
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
						(= temp6 0)
						(GetInput
							@temp6
							50
							{Enter text (then get help with `?')}
						)
						(if temp6
							(StrCpy @local1 @temp6)
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
			((& temp3 $0040) ; direction
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
				(gGame setCursor: gTheCursor 0 temp1 temp2)
				(self doit:)
			)
		)
	)

	(method (showCoord param1 &tmp [temp0 20])
		(Format @temp0 899 10 (param1 x:) (param1 y:)) ; "Position: %d, %d"
		(Prints @temp0)
		(self dispose:)
	)

	(method (doit param1 &tmp temp0 temp1)
		(if (and argc param1)
			(= lastX (= lastY 0))
		)
		(= temp0 ((User curEvent:) x:))
		(= temp1 ((User curEvent:) y:))
		(if (or (!= temp0 lastX) (!= temp1 lastY))
			(if unders
				(Display 899 9 dsRESTOREPIXELS unders)
			)
			(= unders
				(Display
					@local1
					dsCOORD
					temp0
					temp1
					dsCOLOR
					[global119 color]
					dsBACKGROUND
					(if color global119 else global125)
					dsFONT
					font
					dsSAVEPIXELS
				)
			)
			(= lastX temp0)
			(= lastY temp1)
		)
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
		(= window gSystemWindow)
		(self setSize:)
		(= local0 (DButton new:))
		(local0
			text: {exit}
			setSize:
			moveTo: (- nsRight (+ 4 (local0 nsRight:))) nsBottom
		)
		(local0 move: (- (local0 nsLeft:) (local0 nsRight:)) 0)
		(self add: local0 setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0 temp1)
		(self init:)
		(self open: 4 15)
		(= temp0 local0)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 local0)
				)
				(break)
			)
			(= global132 (temp0 value:))
		)
		(self dispose:)
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
			($0040 ; direction
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

