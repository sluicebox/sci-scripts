;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use n940)
(use Feature)
(use Window)
(use File)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
)

(local
	yesI
	[theText 26]
)

(procedure (GetNum string default &tmp [theLine 40]) ; UNUSED
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine 10 0 default) ; "%d"
	)
	(return
		(if (GetInput @theLine 10 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (CheckScroll)
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
		(DisposeScript 10)
	)

	(method (handleEvent event &tmp [temp0 75] [temp75 75] [temp150 10] temp160 temp161 temp162 temp163 [temp164 8])
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_a
						(for
							((= temp162 (gCast first:)))
							temp162
							((= temp162 (gCast next: temp162)))
							
							(= temp163 (NodeValue temp162))
							(Format ; "class: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x"
								@temp0
								10
								1
								((temp163 superClass:) name:)
								(temp163 view:)
								(temp163 loop:)
								(temp163 cel:)
								(temp163 x:)
								(temp163 y:)
								(temp163 z:)
								(temp163 heading:)
								(temp163 priority:)
								(temp163 signal:)
								(if
									(or
										(== (temp163 superClass:) Actor)
										(== (temp163 superClass:) Ego)
									)
									(temp163 illegalBits:)
								else
									-1
								)
							)
							(Print
								@temp0
								#window
								SysWindow
								#title
								(temp163 name:)
								#icon
								(temp163 view:)
								(temp163 loop:)
								(temp163 cel:)
							)
						)
					)
					(KEY_ALT_b
						(Unknown_Class_100 doit:)
					)
					(KEY_ALT_c
						(CheckScroll)
						(Show 4)
						(Animate (gCast elements:))
						(while (== evNULL ((= event (Event new: $7ffd)) type:)) ; evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | direction | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | $0c00
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
					)
					(KEY_ALT_e
						(Format ; "name: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x OnControl: $%x Origin on: $%x"
							@temp0
							10
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
							@temp0
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
						)
					)
					(KEY_ALT_f
						(gFeatures eachElementDo: #perform showFeatureCode)
						(NameFeatureCode init:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(proc0_26)
						(GetInput @temp0 4 {Variable No.})
						(= temp162 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 4 {Value})
						(proc0_27)
						(= [gEgo temp162] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(proc0_26)
						(GetInput @temp0 4 {Variable No.})
						(proc0_27)
						(= temp162 (ReadNumber @temp0))
						(if (IsObject [gEgo temp162])
							(Format ; "Global %d: %s"
								@temp0
								10
								3
								temp162
								([gEgo temp162] name:)
							)
							(Print @temp0)
						else
							(Format @temp0 10 4 temp162 [gEgo temp162]) ; "Global %d: %d"
							(Print @temp0)
						)
						(= temp0 0)
					)
					(KEY_ALT_i
						(dInvD doit:)
					)
					(KEY_ALT_l
						(if (HaveMem 1536)
							(proc0_26)
							((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
							(proc0_27)
						else
							(Print 10 5) ; "Not Enough Memory!!"
						)
					)
					(KEY_ALT_m
						(Format @temp0 10 0 gLarryDollars) ; "%d"
						(Format @temp150 10 0 gSilvDollars) ; "%d"
						(proc0_26)
						(PrintD
							{Dollars: }
							41
							@temp0
							6
							106
							{Silver:__}
							41
							@temp150
							6
						)
						(proc0_27)
						(gEgo put: 12 0) ; Money
						(gEgo put: 17 0) ; Silver_Dollar
						(if (= gLarryDollars (ReadNumber @temp0))
							(gEgo get: 12) ; Money
						)
						(if (= gSilvDollars (ReadNumber @temp150))
							(gEgo get: 17) ; Silver_Dollar
						)
					)
					(KEY_ALT_n
						(= temp0 0)
						(= temp75 0)
						(= temp150 0)
						(while
							(GetInput
								@temp0
								50
								(GetInput
									@temp0
									50
									{Press "Enter" or "ESC" when done.}
								)
							)
							(Format @temp150 10 6 gCurRoomNum) ; "%d.txt"
							(Format ; ";[R%3d V%3d XY%3d/%3d]"
								@temp75
								10
								7
								gCurRoomNum
								(gEgo view:)
								(gEgo x:)
								(gEgo y:)
							)
							(File
								name: @temp150
								writeString: @temp75 @temp0 {\0d\n}
								close:
							)
							(= temp0 0)
						)
						(File name: @temp150 writeString: {\0d\n} close:)
					)
					(KEY_ALT_p
						(CheckScroll)
						(Show 2)
					)
					(KEY_ALT_q
						(gGame detailLevel: 1)
					)
					(KEY_ALT_r
						(Format ; "name: %s number: %d current pic: %d style: %d horizon: %d north: %d south: %d east: %d west: %d script: %s"
							@temp0
							10
							8
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
						(Print @temp0 #width 120)
						(gGame showMem:)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if
							(>
								(= temp162
									(GetNumber
										{Teleport to}
									)
								)
								0
							)
							(gCurRoom newRoom: temp162)
							(= gTPed temp162)
						)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gTheIconBar enable: 0 1 2 3 4 5 6 7)
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
						(Format @temp0 10 9 (event x:) (event y:)) ; "%d/%d"
						(= temp160 (Print @temp0 #at 160 10 #font 999 #dispose))
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
							((User alterEgo:)
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

	(method (init &tmp lastX lastY widest num el node obj)
		(= widest (= lastX (= lastY 4)))
		(= num 0)
		(for
			((= node (gInventory first:)))
			node
			((= node (gInventory next: node)))
			
			(= obj (NodeValue node))
			(++ num)
			(if (obj isKindOf: InvI)
				(self
					add:
						((= el (DText new:))
							value: obj
							text: (obj name:)
							nsLeft: lastX
							nsTop: lastY
							state: 3
							font: gSmallFont
							setSize:
							yourself:
						)
				)
			)
			(if (< widest (- (el nsRight:) (el nsLeft:)))
				(= widest (- (el nsRight:) (el nsLeft:)))
			)
			(if (> (+= lastY (+ (- (el nsBottom:) (el nsTop:)) 1)) 140)
				(= lastY 4)
				(+= lastX (+ widest 10))
				(= widest 0)
			)
		)
		(= window gSystemWindow)
		(self setSize:)
		(= yesI (DButton new:))
		(yesI
			text: {Outta here!}
			setSize:
			moveTo: (- nsRight (+ 4 (yesI nsRight:))) nsBottom
		)
		(yesI move: (- (yesI nsLeft:) (yesI nsRight:)) 0)
		(self add: yesI setSize: center:)
		(return num)
	)

	(method (doit &tmp el)
		(self init:)
		(self open: 4 15)
		(= el yesI)
		(repeat
			(if
				(or
					(not (= el (super doit: el)))
					(== el -1)
					(== el yesI)
				)
				(break)
			)
			(gEgo get: (Inv indexOf: (el value:)))
		)
		(self dispose:)
	)

	(method (handleEvent event &tmp msg typ)
		(= msg (event message:))
		(switch (= typ (event type:))
			(evKEYBOARD
				(switch msg
					(KEY_UP
						(= msg KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= msg KEY_TAB)
					)
				)
			)
			($0040 ; direction
				(switch msg
					(JOY_UP
						(= msg KEY_SHIFTTAB)
						(= typ evKEYBOARD)
					)
					(JOY_DOWN
						(= msg KEY_TAB)
						(= typ evKEYBOARD)
					)
				)
			)
		)
		(event type: typ message: msg)
		(super handleEvent: event)
	)
)

(instance showFeatureCode of Code
	(properties)

	(method (doit obj &tmp t l r b)
		(= t (obj nsTop:))
		(= l (obj nsLeft:))
		(= b (obj nsBottom:))
		(= r (obj nsRight:))
		(Graph grDRAW_LINE t l t r 1 15)
		(Graph grDRAW_LINE b l b r 1 15)
		(Graph grDRAW_LINE t l b l 1 15)
		(Graph grDRAW_LINE t r b r 1 15)
		(Graph grUPDATE_BOX t l (+ b 1) (+ r 1) 1)
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
		(DrawStatus { } gColBlack 0)
		(gKeyDownHandler delete: self)
		(gTheDoits delete: self)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event claimed: 1)
			(self dispose:)
		)
	)

	(method (doit &tmp obj [str 40])
		(OnMeAndLowY init:)
		(gFeatures eachElementDo: #perform OnMeAndLowY (User curEvent:))
		(if (= obj (OnMeAndLowY theObj:))
			(DrawStatus
				(Format ; "%d, %d   %s"
					@str
					10
					10
					((User curEvent:) x:)
					((User curEvent:) y:)
					(obj name:)
				)
			)
		)
	)
)

