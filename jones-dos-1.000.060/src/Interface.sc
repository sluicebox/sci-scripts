;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use KeyMouse)
(use User)
(use Menu)
(use System)

(public
	Print 0
	ShowView 1
	GetInput 2
	GetNumber 3
	Printf 4
	StillDown 6
)

(local
	local0
	[local1 20]
)

(procedure (StillDown param1 &tmp event ret)
	(= event (Event new:))
	(if argc
		(param1 port: (event port:) x: (event x:) y: (event y:))
	)
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (GetInput str maxLen prompt &tmp [temp0 4])
	(if (Print (if (>= argc 3) prompt else {}) #edit str maxLen &rest)
		(StrLen str)
	)
)

(procedure (ShowView txt v l c) ; UNUSED
	(Print txt #icon v l c &rest)
)

(procedure (Print args &tmp temp0 temp1 temp2 temp3 [temp4 6] temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 [temp23 2] temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 [temp33 1000])
	(= global506 1)
	(= temp22 (GetPort))
	(SetPort 0)
	(= temp17 (= temp18 -1))
	(= temp28
		(= temp29
			(= temp20
				(= temp19
					(= temp25 (= temp11 (= temp12 (= temp30 (= temp26 0)))))
				)
			)
		)
	)
	((= temp1 (Dialog new:)) window: gBubbleWindow name: {PrintD})
	(= temp10 (DText new:))
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @temp33)
			(= temp16 2)
		)
		([args 0]
			(StrCpy @temp33 [args 0])
			(= temp16 1)
		)
		(else
			(= temp33 0)
			(= temp16 0)
		)
	)
	(temp10 text: @temp33 moveTo: 5 5 font: gUserFont setSize:)
	(temp1 add: temp10)
	(temp10 setSize: (= temp19 100) mode: 1)
	(for ((= temp16 temp16)) (< temp16 argc) ((++ temp16))
		(switch [args temp16]
			(30
				(++ temp16)
				(temp10 mode: [args temp16])
			)
			(33
				(++ temp16)
				(temp10 font: [args temp16] setSize: temp19)
			)
			(70
				(= temp19 [args (++ temp16)])
				(temp10 setSize: temp19)
			)
			(25
				(++ temp16)
				(temp1 time: [args temp16])
			)
			(80
				(++ temp16)
				(temp1 text: [args temp16])
			)
			(67
				(= temp17 [args (++ temp16)])
				(= temp18 [args (++ temp16)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				(++ temp16)
				((= temp12 (DEdit new:)) text: [args temp16])
				(++ temp16)
				(temp12 max: [args temp16] setSize:)
			)
			(81
				((= [temp4 temp26] (DButton new:))
					text: [args (++ temp16)]
					value: [args (++ temp16)]
					setSize:
				)
				(+= temp25 (+ ([temp4 temp26] nsRight:) 5))
				(++ temp26)
			)
			(82
				(if (IsObject [args (+ temp16 1)])
					(= temp11 ([args (+ temp16 1)] new:))
					(temp11 setSize:)
					(+= temp16 1)
				else
					(= temp11 (DIcon new:))
					(temp11
						view: [args (+ temp16 1)]
						loop: [args (+ temp16 2)]
						cel: [args (+ temp16 3)]
						setSize:
					)
					(+= temp16 3)
				)
			)
			(103
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp20 temp1)
			)
			(35
				(++ temp16)
				(temp1 window: [args temp16])
			)
			(310
				(= temp28 [args (++ temp16)])
				(= temp29 [args (++ temp16)])
				(= temp13 [args (++ temp16)])
				(= temp14 [args (++ temp16)])
			)
			(311
				(if global447
					(= temp31 (KeyMouse prevCursorX:))
					(= temp32 (KeyMouse prevCursorY:))
					(= temp2 (KeyMouse curItem:))
					(= temp3 (KeyMouse listOfCoords:))
					(temp1 standard: 0)
					((= temp15 (List new:)) add:)
					(= temp30 1)
				)
			)
		)
	)
	(if temp11
		(temp11 moveTo: 5 5)
		(temp10 moveTo: (+ 5 (temp11 nsRight:)) (temp10 nsTop:))
		(temp1 add: temp11)
	)
	(temp1 setSize:)
	(if temp12
		(temp12 moveTo: (temp10 nsLeft:) (+ 5 (temp10 nsBottom:)))
		(temp1 add: temp12 setSize:)
	)
	(= temp27
		(if (> temp25 (temp1 nsRight:))
			5
		else
			(- (temp1 nsRight:) temp25)
		)
	)
	(for ((= temp16 0)) (< temp16 temp26) ((++ temp16))
		([temp4 temp16] moveTo: temp27 (temp1 nsBottom:))
		(temp1 add: [temp4 temp16])
		(= temp27 (+ 5 ([temp4 temp16] nsRight:)))
	)
	(temp1 setSize: center:)
	(if (and temp11 (not (StrLen @temp33)))
		(temp11
			moveTo:
				(/
					(-
						(- (temp1 nsRight:) (temp1 nsLeft:))
						(- (temp11 nsRight:) (temp11 nsLeft:))
					)
					2
				)
				5
		)
	)
	(temp1
		moveTo:
			(if (== -1 temp17)
				(temp1 nsLeft:)
			else
				temp17
			)
			(if (== -1 temp18)
				(temp1 nsTop:)
			else
				temp18
			)
	)
	(temp1
		open:
			(if (temp1 text:) 4 else 0)
			(if temp20 15 else -1)
			temp28
			temp29
			temp13
			temp14
	)
	(if temp20
		(= local0 (GetPort))
		(SetPort temp22)
		(return (= gModelessDialog temp20))
	)
	(if
		(and
			(= temp21 (temp1 firstTrue: #checkState 1))
			(not (temp1 firstTrue: #checkState 2))
		)
		(temp21 state: (| (temp21 state:) $0002))
	)
	(if temp30
		(proc0_9 temp1 temp15 0 temp29)
		(KeyMouse setList: temp15)
	)
	(if (== (= temp0 (temp1 doit: temp21)) -1)
		(= temp0 0)
	)
	(if (not (temp1 theItem:))
		(= temp0 1)
	)
	(for ((= temp16 0)) (< temp16 temp26) ((++ temp16))
		(if (== temp0 [temp4 temp16])
			(= temp0 (temp0 value:))
			(break)
		)
	)
	(if (not (temp1 standard:))
		(temp15 release: dispose:)
		(KeyMouse setList: temp3 curItem: temp2)
		(if global447
			(KeyMouse setCursor: temp2)
		)
	)
	(temp1 dispose:)
	(SetPort temp22)
	(= global506 0)
	(return temp0)
)

(procedure (GetNumber string default &tmp [theLine 40]) ; UNUSED
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine 255 0 default) ; "%d"
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (Printf &tmp [str 500])
	(Format @str &rest)
	(Print @str)
)

(class MenuBar of Obj
	(properties
		state 0
	)

	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)

	(method (hide)
		(DrawMenuBar 0)
	)

	(method (add)
		(AddMenu &rest)
	)

	(method (handleEvent event)
		(if state
			(MenuSelect event &rest)
		else
			0
		)
	)
)

(class Item of Obj
	(properties
		type 0
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		underBits 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		client 0
		-oldPort- 0
		keyMouseX 0
		keyMouseY 0
		offsetX 0
		offsetY 0
	)

	(method (hilite param1)
		(self setPort:)
		(HiliteControl self)
		(Wait (/ 25 param1))
		(HiliteControl self)
		(self resetPort:)
	)

	(method (motionCue))

	(method (new &tmp temp0)
		((= temp0 (super new:)) underBits: 0)
		(return temp0)
	)

	(method (setPort)
		(= -oldPort- (GetPort))
		(SetPort
			(if client
				((client window:) window:)
			else
				0
			)
		)
	)

	(method (resetPort)
		(SetPort (if client -oldPort- else 0))
	)

	(method (drag param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (- nsLeft (param1 x:)))
		(= temp3 (- nsTop (param1 y:)))
		(while (StillDown param1)
			(if client
				(param1 localize: ((client window:) window:))
			)
			(if (or (!= temp0 (param1 x:)) (!= temp1 (param1 y:))) ; UNINIT, UNINIT
				(= temp0 (param1 x:))
				(= temp1 (param1 y:))
				(self
					erase:
					moveTo: (+ temp2 (param1 x:)) (+ temp3 (param1 y:))
					draw:
				)
			)
		)
	)

	(method (enable bool)
		(if bool
			(|= state $0001)
		else
			(&= state $fffe)
		)
	)

	(method (select bool)
		(if bool
			(|= state $0008)
		else
			(&= state $fff7)
		)
		(self draw:)
	)

	(method (handleEvent event &tmp ret evtType evt)
		(if (event claimed:)
			(return 0)
		)
		(= ret 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= evtType (event type:)) evKEYBOARD)
						(== (event message:) key)
					)
					(and (== evtType evMOUSEBUTTON) (self check: event))
				)
			)
			(event claimed: 1)
			(= ret (self track: event))
		)
		(return ret)
	)

	(method (check event)
		(return
			(and
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
		)
	)

	(method (track event &tmp in lastIn)
		(if (== 1 (event type:))
			(self setPort:)
			(= lastIn 0)
			(repeat
				(= event (Event new: -32768))
				(if client
					(event localize: ((client window:) window:))
				)
				(if (!= (= in (self check: event)) lastIn)
					(HiliteControl self)
					(= lastIn in)
				)
				(event dispose:)
				(breakif (not (StillDown)))
			)
			(if in
				(HiliteControl self)
			)
			(self resetPort:)
			(return in)
		else
			(if (and (== (event type:) 4) (== (event message:) key))
				(self hilite: 1)
			)
			(return self)
		)
	)

	(method (isType param1)
		(return (== type param1))
	)

	(method (checkState param1)
		(return (& state param1))
	)

	(method (doit)
		(return value)
	)

	(method (setSize))

	(method (move param1 param2)
		(+= nsRight param1)
		(+= nsLeft param1)
		(+= nsTop param2)
		(+= nsBottom param2)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)

	(method (draw param1)
		(self setPort:)
		(if (or (and (!= type 6) (!= type 7)) (and argc param1))
			(self erase:)
			(if (& state $0040)
				(= lsTop nsTop)
				(= lsLeft nsLeft)
				(= lsBottom nsBottom)
				(= lsRight nsRight)
				(= underBits
					(Graph
						grSAVE_BOX
						(- nsTop 1)
						(- nsLeft 1)
						(+ nsBottom 1)
						(+ nsRight 1)
						1
					)
				)
			)
		)
		(if type
			(DrawControl self)
		)
		(self resetPort:)
	)

	(method (erase)
		(if underBits
			(self setPort:)
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX (- nsTop 1) (- nsLeft 1) (+ nsBottom 1) (+ nsRight 1) 1)
			(= underBits 0)
			(self resetPort:)
		)
	)

	(method (dispose)
		(if underBits
			(UnLoad 133 underBits)
			(= underBits 0)
			(self erase:)
		)
		(super dispose:)
	)

	(method (cycle))
)

(class DText of Item
	(properties
		type 2
		text 0
		font 1
		mode 0
	)

	(method (new &tmp newText)
		((super new:) font: gUserFont yourself:)
	)

	(method (setSize w &tmp [r 4])
		(TextSize @[r 0] text font (if argc w else 0))
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft [r 3]))
	)
)

(class DIcon of Item
	(properties
		type 4
		view 0
		loop 0
		cel 0
		priority -1
	)

	(method (setSize &tmp [r 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class ErasableDIcon of DIcon
	(properties)

	(method (doit param1)
		(if (or (!= argc 1) param1)
			(gASoundEffect play: 23)
		)
		(super doit:)
	)
)

(class DButton of Item
	(properties
		type 1
		state 3
		text 0
		font 0
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] text font)
		(+= [r 2] 2)
		(+= [r 3] 2)
		(= nsBottom (+ nsTop [r 2]))
		(= [r 3] (* (/ (+ [r 3] 15) 16) 16))
		(= nsRight (+ [r 3] nsLeft))
	)
)

(class DEdit of Item
	(properties
		type 3
		state 1
		text 0
		font 0
		max 0
		cursor 0
	)

	(method (track evt)
		(EditControl self evt)
		(return self)
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class DSelector of Item
	(properties
		type 6
		font 0
		x 20
		y 6
		text 0
		cursor 0
		brTop 0
		mark 0
	)

	(method (indexOf what &tmp ptr i)
		(= ptr text)
		(for ((= i 0)) (< i 300) ((++ i))
			(if (== 0 (StrAt ptr 0))
				(return -1)
			)
			(if (not (StrCmp what ptr x))
				(return i)
			)
			(+= ptr x)
		)
	)

	(method (at what)
		(return (+ text (* x what)))
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font)
		(= nsBottom (+ nsTop 20 (* [r 2] y)))
		(= nsRight (+ nsLeft (/ (* [r 3] x 4) 4)))
		(= brTop (= cursor text))
		(= mark 0)
	)

	(method (retreat lines &tmp redraw)
		(= redraw 0)
		(if (== type 7)
			(= mark 0)
			(= redraw 1)
			(Wait 3)
		)
		(while lines
			(if (!= cursor text)
				(= redraw 1)
				(-= cursor x)
				(if mark
					(-- mark)
				else
					(-= brTop x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(if redraw
			(self draw:)
		)
	)

	(method (advance lines &tmp redraw)
		(= redraw 0)
		(if (== type 7)
			(= mark y)
			(= redraw 1)
			(Wait 3)
		)
		(while lines
			(if (StrAt cursor x)
				(= redraw 1)
				(+= cursor x)
				(if (< (+ mark 1) y)
					(++ mark)
				else
					(+= brTop x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(if redraw
			(self draw:)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (event claimed:)
			(return 0)
		)
		(if (== $0040 (event type:)) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_DOWN
					(event message: KEY_DOWN)
				)
				(JOY_UP
					(event message: KEY_UP)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(= temp0 0)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_HOME
						(self retreat: 50)
					)
					(KEY_END
						(self advance: 50)
					)
					($5100 ; PAGEDOWN
						(self advance: (- y 1))
					)
					($4900 ; PAGEUP
						(self retreat: (- y 1))
					)
					(KEY_DOWN
						(self advance: 1)
					)
					(KEY_UP
						(self retreat: 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(if (self check: event)
					(event claimed: 1)
					(cond
						((< (event y:) (+ nsTop 10))
							(repeat
								(self retreat: 1)
								(breakif (not (StillDown)))
							)
						)
						((> (event y:) (- nsBottom 10))
							(repeat
								(self advance: 1)
								(breakif (not (StillDown)))
							)
						)
						((== type 6)
							(TextSize @[temp5 0] {M} font)
							(if
								(>
									(= temp4
										(/
											(- (event y:) (+ nsTop 10))
											[temp5 2]
										)
									)
									mark
								)
								(self advance: (- temp4 mark))
							else
								(self retreat: (- mark temp4))
							)
						)
					)
				)
			)
		)
		(if (and (event claimed:) (& state $0002)) self else 0)
	)
)

(class Dialog of List
	(properties
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
		client 0
		agent 0
		script 0
		menuBarOK 0
		tail 0
		standard 1
		keyMouseList 0
		prevDialog 0
		prevTalker 0
		aTimeClock 0
	)

	(method (setScript param1 param2)
		(if script
			(script dispose:)
		)
		(= script param1)
		(if (>= argc 2)
			(script state: param2)
		)
	)

	(method (add param1 &tmp temp0)
		(super add: param1 &rest)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			([param1 temp0] client: self)
		)
	)

	(method (addAfter param1 &tmp temp0)
		(super addAfter: param1 &rest)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			([param1 temp0] client: self)
		)
	)

	(method (open param1 param2 param3 param4 param5 param6)
		(if (and (PicNotValid) gCast)
			(Animate (gCast elements:) 0)
		)
		(= window (window new:))
		(if (>= argc 7)
			(window underBits: 1)
		)
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: param1
			priority: param2
			open: param3 param4 param5 param6
		)
		(= seconds time)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit def &tmp temp0 temp1 temp2 [temp3 2])
		(= temp0 0)
		(= busy 1)
		(if (<= argc 1)
			(self eachElementDo: #init)
		)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc def)
				def
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(= temp2 0)
		(while (not temp2)
			(if (not gQuit)
				(if (not global528)
					(if (not global529)
						(if (not global521)
							(gSounds eachElementDo: #check)
							(self eachElementDo: #cycle)
							(if (window animateObj:)
								((window animateObj:) cycle: doit:)
							)
							(if global58
								(= global58 0)
								(self eachElementDo: #motionCue)
							)
							(= temp1 (Event new:))
							(if (not (User controls:))
								(temp1 message: JOY_NULL)
							)
							(if script
								(script handleEvent: temp1 doit:)
							)
							(= temp2 (self handleEvent: temp1))
							(temp1 dispose:)
							(self check:)
							(if (or (== temp2 -1) (not busy))
								(= temp2 0)
								(if theItem
									(EditControl theItem 0)
								)
								(break)
							)
						else
							(break)
						)
					else
						(break)
					)
				else
					(break)
				)
			else
				(break)
			)
			(Wait 1)
		)
		(= busy 0)
		(return temp2)
	)

	(method (check &tmp thisSeconds)
		(if seconds
			(= thisSeconds (GetTime 1)) ; SysTime12
			(if (!= lastSeconds thisSeconds)
				(= lastSeconds thisSeconds)
				(if (not (-- seconds))
					(self cue:)
				)
			)
		)
	)

	(method (cue)
		(if (not busy)
			(self dispose:)
		else
			(= busy 0)
		)
	)

	(method (dispose)
		(if script
			(script dispose:)
			(= script 0)
		)
		(if (== self gModelessDialog)
			(SetPort local0)
			(= gModelessDialog (= local0 0))
		)
		(if window
			(window dispose:)
		)
		(= window (= theItem 0))
		(super dispose:)
	)

	(method (advance &tmp obj node)
		(if theItem
			(theItem select: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self next: node)))
					(= node (self first:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
		)
	)

	(method (retreat &tmp obj node)
		(if theItem
			(theItem select: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self prev: node)))
					(= node (self last:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
		)
	)

	(method (handleEvent event &tmp ret eType eMsg)
		(if menuBarOK
			(MenuBar handleEvent: event)
		)
		(event localize: (window window:))
		(if (and (not global443) (not (User controls:)) (not (event message:)))
			(return 0)
		)
		(if
			(and
				client
				(event type:)
				(or
					(< (event x:) 0)
					(> (event x:) (- nsRight nsLeft))
					(< (event y:) 0)
					(> (event y:) (- nsBottom nsTop))
				)
			)
			(client handleEvent: event)
			(return)
		)
		(if
			(or
				(event claimed:)
				(== (event type:) evNULL)
				(and
					(!= evMOUSEBUTTON (event type:))
					(!= evKEYBOARD (event type:))
					(!= $0040 (event type:)) ; direction
					(!= evJOYDOWN (event type:))
				)
			)
			(if theItem
				(EditControl theItem event)
			)
			(return 0)
		)
		(MapKeyToDir event)
		(if (= ret (self firstTrue: #handleEvent event))
			(if theItem
				(EditControl theItem 0)
			)
			(if (or (not (ret checkState: 2)) (ret checkState: 32))
				(if theItem
					(theItem select: 0 ret)
				)
				((= theItem ret) select: 1)
				(= eType ret)
				(= global508 event)
				(= ret (ret doit:))
				(if (and (IsObject eType) (eType checkState: 2))
					(= ret eType)
				)
			)
		else
			(= ret 0)
			(cond
				(
					(and
						(or
							(== (event type:) evJOYDOWN)
							(and
								(== evKEYBOARD (event type:))
								(== KEY_RETURN (event message:))
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(if standard
						(= ret theItem)
						(if theItem
							(EditControl theItem 0)
						)
					else
						(if
							(and
								(IsObject (= eMsg (KeyMouse curItem:)))
								(eMsg respondsTo: #hilite)
							)
							(eMsg hilite: 2 doit:)
						)
						(if (IsObject eMsg)
							(if (eMsg isMemberOf: DButton)
								eMsg
							else
								(eMsg checkState: 2)
							)
						else
							0
						)
						(return)
					)
					(event claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: #checkState 1))
							(or
								(and
									(== evKEYBOARD (event type:))
									(== KEY_RETURN (event message:))
								)
								(== evMOUSEBUTTON (event type:))
								(== evJOYDOWN (event type:))
							)
						)
						(and (== evKEYBOARD (event type:)) (== KEY_ESCAPE (event message:)))
					)
					(event claimed: 1)
					(= ret -1)
				)
				(
					(or
						(and (== evKEYBOARD (event type:)) (== KEY_TAB (event message:)))
						(and
							(== $0040 (event type:)) ; direction
							(or
								(== JOY_DOWN (event message:))
								(== JOY_RIGHT (event message:))
							)
						)
					)
					(if standard
						(self advance:)
					else
						(if theItem
							(theItem select: 0)
						)
						(KeyMouse advance:)
						(if (KeyMouse curItem:)
							((= theItem (KeyMouse curItem:)) select: 1)
						)
					)
					(event claimed: 1)
				)
				(
					(or
						(and (== evKEYBOARD (event type:)) (== KEY_SHIFTTAB (event message:)))
						(and
							(== $0040 (event type:)) ; direction
							(or
								(== JOY_UP (event message:))
								(== JOY_LEFT (event message:))
							)
						)
					)
					(if standard
						(self retreat:)
					else
						(if theItem
							(theItem select: 0)
						)
						(KeyMouse retreat:)
						(if (KeyMouse curItem:)
							((= theItem (KeyMouse curItem:)) select: 1)
						)
					)
					(event claimed: 1)
				)
				(theItem
					(EditControl theItem event)
				)
			)
		)
		(return ret)
	)

	(method (move h v)
		(+= nsRight h)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsBottom v)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (center)
		(self
			moveTo:
				(+
					(window brLeft:)
					(/
						(-
							(- (window brRight:) (window brLeft:))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop:)
					(/
						(-
							(- (window brBottom:) (window brTop:))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)

	(method (setSize &tmp node obj [r 4])
		(if text
			(TextSize @[r 0] text 0 -1)
			(= nsTop [r 0])
			(= nsLeft [r 1])
			(= nsBottom [r 2])
			(= nsRight [r 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(= obj (NodeValue node))
			(if (< (obj nsLeft:) nsLeft)
				(= nsLeft (obj nsLeft:))
			)
			(if (< (obj nsTop:) nsTop)
				(= nsTop (obj nsTop:))
			)
			(if (> (obj nsRight:) nsRight)
				(= nsRight (obj nsRight:))
			)
			(if (> (obj nsBottom:) nsBottom)
				(= nsBottom (obj nsBottom:))
			)
		)
		(+= nsRight 5)
		(+= nsBottom 5)
		(self moveTo: 0 0)
	)
)

(class Controls of List
	(properties)

	(method (draw)
		(self eachElementDo: #setSize eachElementDo: #draw)
	)

	(method (handleEvent event &tmp cont)
		(if (event claimed:)
			(return 0)
		)
		(if
			(and
				(= cont (self firstTrue: #handleEvent event))
				(not (cont checkState: 2))
			)
			(cont doit:)
			(= cont 0)
		)
		(return cont)
	)
)

