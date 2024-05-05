;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use invSetupCode)
(use Interface)
(use Print)
(use Dialog)
(use PolyEdit)
(use WriteFeature)
(use Feature)
(use Window)
(use Inventory)
(use User)
(use System)

(public
	debugRm 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(Print
		addText: {Flag Object?} 0 0
		addButton: 1 {yes} 10 20
		addButton: 0 {no} 10 40
		init:
	)
)

(instance debugRm of Feature
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 4] [temp6 200] temp206 temp207 temp208 temp209 temp210 temp211 temp212 temp213 temp214 temp215 temp216 temp217)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Print font: 999)
						(Prints
							{ALT-A - show cAst\nALT-B - show flag value\nALT-C - show Control screen\nALT-E - show Ego\nALT-F - show Features\nALT-G - set Global\nALT-I - get Inventory Item\nALT-J - Note Logger for QA\nALT-K - set flag\nALT-L - cLear flag\nALT-M - show Memory\nALT-O - create Obstacles\nALT-P - show Priority screen\nALT-R - show Room info\nALT-S - Switch mouse actor\nALT-T - Teleport\nALT-U - HandsOn\nALT-V - show Visual screen\nALT-W - Write features\nALT-X - eXit the game\nALT-Y - show pallete}
						)
					)
					(KEY_ALT_a
						(for
							((= temp207 (gCast first:)))
							temp207
							((= temp207 (gCast next: temp207)))
							
							(= temp1 (NodeValue temp207))
							(= temp215
								(CelHigh
									(temp1 view:)
									(temp1 loop:)
									(temp1 cel:)
								)
							)
							(Format
								@temp6
								{NAME: %s\n\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nsignal: $%x\n}
								(temp1 name:)
								(temp1 view:)
								(temp1 loop:)
								(temp1 cel:)
								(temp1 x:)
								(temp1 y:)
								(temp1 z:)
								(temp1 heading:)
								(temp1 priority:)
								(temp1 signal:)
							)
							(Print
								window: SysWindow
								addIcon:
									(temp1 view:)
									(temp1 loop:)
									(temp1 cel:)
									0
									0
								addText: @temp6 0 (+ temp215 5)
								init:
							)
						)
						(Print window: gSystemWindow)
					)
					(KEY_ALT_b
						(= temp6 0)
						(GetInput @temp6 4 {Flag No?})
						(= temp207 (ReadNumber @temp6))
						(cond
							((localproc_0)
								(if (gCurrentRegionFlags test: temp207)
									(Prints {TRUE})
								else
									(Prints {FALSE})
								)
							)
							((IsFlag temp207)
								(Prints {TRUE})
							)
							(else
								(Prints {FALSE})
							)
						)
					)
					(KEY_ALT_c
						(Show 4)
					)
					(KEY_ALT_e
						(= temp217
							(if global109
								global109
							else
								(User alterEgo:)
							)
						)
						(Printf
							{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nillBits: $%x\nonControl: $%x\norigin on: $%x }
							(temp217 name:)
							(temp217 view:)
							(temp217 loop:)
							(temp217 cel:)
							(temp217 x:)
							(temp217 y:)
							(temp217 z:)
							(temp217 heading:)
							(temp217 priority:)
							(temp217 signal:)
							(if (temp217 respondsTo: #onControl)
								(temp217 illegalBits:)
							else
								-1
							)
							(if (temp217 respondsTo: #onControl)
								(temp217 onControl:)
							else
								-1
							)
							(if (temp217 respondsTo: #onControl)
								(temp217 onControl: 1)
							else
								-1
							)
							79
							(temp217 view:)
							(temp217 loop:)
							(temp217 cel:)
						)
					)
					(KEY_ALT_f
						(gFeatures eachElementDo: #perform showFeatureCode)
						(NameFeatureCode init:)
					)
					(KEY_ALT_g
						(= temp6 0)
						(GetInput @temp6 4 {Global No?})
						(= temp207 (ReadNumber @temp6))
						(= temp6 0)
						(if (>= [gEgo temp207] 1000)
							(Printf
								{Global %d's value is $%x.}
								temp207
								[gEgo temp207]
							)
						else
							(Printf
								{Global %d's value is %d.}
								temp207
								[gEgo temp207]
							)
						)
						(if (GetInput @temp6 4 {New Value?})
							(= [gEgo temp207] (ReadNumber @temp6))
						)
					)
					(KEY_ALT_i
						(dInvD doit:)
					)
					(KEY_ALT_k
						(= temp6 0)
						(GetInput @temp6 4 {Flag No?})
						(= temp207 (ReadNumber @temp6))
						(if (localproc_0)
							(gCurrentRegionFlags set: temp207)
						else
							(SetFlag temp207)
						)
					)
					(KEY_ALT_l
						(= temp6 0)
						(GetInput @temp6 4 {Flag No?})
						(= temp207 (ReadNumber @temp6))
						(if (localproc_0)
							(gCurrentRegionFlags clear: temp207)
						else
							(ClearFlag temp207)
						)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_o
						(PolyEdit doit:)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_r
						(Printf
							{name: %s\nnumber: %d\ncurrent pic: %d\nstyle: %d\nhorizon: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nscript: %s }
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
							67
							120
						)
						(gGame showMem:)
					)
					(KEY_ALT_s
						(dCastD doit:)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if (> (= temp207 (GetNumber {Which room number?})) 0)
							(gCurRoom newRoom: temp207)
						)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gTheIconBar enable: 0 1 2 3 7 5 6)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_w
						(WriteCode doit:)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_y
						(= temp206 (GetPort))
						(SetPort 0)
						(= temp215 5)
						(= temp216 16)
						(= temp211 15)
						(= temp212 80)
						(= temp214 (+ temp211 (* 34 temp215)))
						(= temp213 (+ temp212 (* 10 temp216)))
						(= temp209 (Graph grSAVE_BOX temp211 temp212 temp214 temp213 1))
						(Graph grFILL_BOX temp211 temp212 temp214 temp213 1 255)
						(for ((= temp210 0)) (< temp210 256) ((++ temp210))
							(Graph
								grFILL_BOX
								(+ temp211 temp215 (* temp215 (/ temp210 8)))
								(+ temp212 temp216 (* 16 (mod temp210 8)))
								(+
									temp211
									temp215
									temp215
									(* temp215 (/ temp210 8))
								)
								(+
									temp212
									temp216
									temp216
									(* temp216 (mod temp210 8))
								)
								1
								temp210
							)
						)
						(Graph grUPDATE_BOX temp211 temp212 temp214 temp213 1)
						(repeat
							(= temp0 (Event new:))
							(if (or (== (temp0 type:) evMOUSEBUTTON) (== (temp0 type:) evKEYBOARD))
								(break)
							)
							(temp0 dispose:)
						)
						(temp0 dispose:)
						(Graph grRESTORE_BOX temp209)
						(Graph grUPDATE_BOX temp211 temp212 temp214 temp213 1)
						(SetPort temp206)
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
						(= temp206
							(Printf
								{%d/%d}
								(event x:)
								(event y:)
								64
								160
								10
								30
								999
								111
							)
						)
						(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
							(temp0 dispose:)
						)
						(temp0 dispose:)
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
						(= temp217
							(if global109
								global109
							else
								(User alterEgo:)
							)
						)
						(gEgo setMotion: 0)
						(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
							(temp217
								x: (temp0 x:)
								y: (- (temp0 y:) 10)
								startUpd:
							)
							(Animate (gCast elements:) 0)
							(temp0 dispose:)
						)
						(temp0 dispose:)
					)
				)
			)
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
		(DrawStatus 0)
		(DrawStatus { } 0 0)
		(gKeyDownHandler delete: self)
		(gTheDoits delete: self)
	)

	(method (handleEvent event &tmp [temp0 50])
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event claimed: 1)
			(self dispose:)
		)
	)

	(method (doit &tmp temp0 [temp1 40])
		(OnMeAndLowY init:)
		(gFeatures eachElementDo: #perform OnMeAndLowY (User curEvent:))
		(if (= temp0 (OnMeAndLowY theObj:))
			(Format
				@temp1
				{%d, %d______%s}
				((User curEvent:) x:)
				((User curEvent:) y:)
				(temp0 name:)
			)
			(DrawStatus @temp1 67 0)
		)
	)
)

(instance showFeatureCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (param1 nsTop:))
		(= temp1 (param1 nsLeft:))
		(= temp3 (param1 nsBottom:))
		(= temp2 (param1 nsRight:))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp2 1 8)
		(Graph grDRAW_LINE temp3 temp1 temp3 temp2 1 8)
		(Graph grDRAW_LINE temp0 temp1 temp3 temp1 1 8)
		(Graph grDRAW_LINE temp0 temp2 temp3 temp2 1 8)
		(Graph grUPDATE_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) 1)
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
			(if (> (+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1)) 130)
				(= temp1 4)
				(+= temp0 (+ temp2 10))
				(= temp2 0)
			)
		)
		(= window gSystemWindow)
		(self setSize:)
		(= local1 (DButton new:))
		(local1
			text: {I want it ALL!}
			setSize:
			moveTo: (- nsRight (+ 4 (local1 nsRight:))) nsBottom
		)
		(local1 move: (- (local1 nsLeft:) (local1 nsRight:)) 0)
		(self add: local1 setSize: center:)
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

	(method (doit &tmp temp0 temp1)
		(self init:)
		(self open: 4 15)
		(= temp0 local0)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 local1)
					(== temp0 local0)
				)
				(break)
			)
			(gEgo get: (gInventory indexOf: (temp0 value:)))
		)
		(if (== temp0 local1)
			(for ((= temp1 0)) (< temp1 (gInventory size:)) ((++ temp1))
				(if ((gInventory at: temp1) isKindOf: EcoInvI)
					(gEgo get: temp1)
				)
			)
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
			(= global109 (temp0 value:))
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

