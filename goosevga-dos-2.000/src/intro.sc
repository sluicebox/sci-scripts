;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use GameControls)
(use IconBar)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	local1
	local2
	local3
	[local4 50] = [52 107 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	[local54 250]
	[local304 12]
	local316
	local317
	local318
	[local319 132]
	[local451 13]
	local464
	local465
	local466
	local467
	[local468 8]
	local476
	local477
	local478
	[local479 26] = [33 257 33 65 97 129 161 193 225 257 33 65 97 129 161 193 225 257 33 65 97 129 161 193 225 257]
	[local505 26] = [77 77 102 102 102 102 102 102 102 102 127 127 127 127 127 127 127 127 152 152 152 152 152 152 152 152]
	[local531 27]
)

(procedure (localproc_0 param1 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 param1))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 2)
	)
	(Palette palSET_INTENSITY 0 255 100)
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 param1))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 2)
	)
	(Palette palSET_INTENSITY 0 255 0)
)

(procedure (localproc_2 &tmp [temp0 2] temp2 temp3)
	(= temp3 (+ (= temp2 (* (mod global114 2) 30)) 30))
	(while (and (< temp2 temp3) [local319 temp2])
		(++ temp2)
	)
	(return temp2)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= gSaveSlot 0)) 1 ((++ gSaveSlot))
		(for ((= temp0 0)) (< temp0 local317) ((++ temp0))
			(breakif (== gSaveSlot [local304 temp0]))
		)
		(if (== temp0 local317)
			(break)
		)
	)
	(return gSaveSlot)
)

(procedure (localproc_4)
	(SetPort 0 0 200 320 0 0)
	(Graph grFILL_BOX 190 0 200 320 1 0 0 0)
	(Graph grUPDATE_BOX 190 0 200 320 1)
	(SetPort 0 0 190 320 0 0)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (CelWide (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp2 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp1 (+ (param1 nsLeft:) (/ temp0 2)))
	(= temp3 (- (+ (param1 nsTop:) temp2) 1))
	(gGame setCursor: gTheCursor 1 temp1 temp3)
)

(procedure (localproc_6 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (CelWide (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp2 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp1 (+ (param1 nsLeft:) (/ temp0 2)))
	(= temp3 (- (+ (param1 nsTop:) temp2) 1))
	(gGame setCursor: gTheCursor 1 temp1 temp3)
)

(procedure (localproc_7 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ 81 (* local476 17)))
	(if param1
		(= temp2 (/ (= temp1 (- (StrAt @local468 (- local476 1)) 65)) 16))
		(= temp3 (mod temp1 16))
		(DrawCel 803 temp2 temp3 temp0 54 15)
		(localproc_8 1)
	else
		(+= temp0 17)
		(= temp3 (mod local476 2))
		(DrawCel 803 3 temp3 temp0 54 15)
		(localproc_8 0)
	)
	(Graph grUPDATE_BOX 52 temp0 67 (+ temp0 13) 1)
)

(procedure (localproc_8 param1)
	(if (and param1 (>= local476 8))
		(nextBlock hide:)
	else
		(nextBlock show: x: (+ 98 (* local476 17)))
	)
)

(instance intro of Rm
	(properties
		style 10
	)

	(method (init)
		(= global176 1)
		(SetPort 0 0 200 320 0 0)
		(= local1 global60)
		(= global60 320)
		(super init:)
		(gKeyDownHandler add: self)
		(= global107 1)
		(= global114 0)
		(self setScript: introScript)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(Animate (gCast elements:) 0)
		(= global107 0)
		(= global60 local1)
		(super dispose:)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 64] temp64 temp65 temp66 temp67)
		(switch (= state newState)
			(0
				(gGame setCursor: global75 1)
				(if (== global113 100)
					(if (= local316 (StrAt gCurSaveDir 0))
						(if (and (!= temp64 97) (!= temp64 65)) ; UNINIT, UNINIT
							(StrAt gCurSaveDir 2 0)
						)
						(= local317
							(GetSaveFiles (gGame name:) @local54 @local304)
						)
						(= register 0)
						(if local316
							(for
								((= temp64 0))
								(< temp64 local317)
								((++ temp64))
								
								(if (!= (StrAt @local54 (* temp64 36)) 126)
									(++ register)
								)
							)
						)
						(if register
							(= state 8)
						else
							(= global113 200)
						)
					else
						(localproc_4)
						(gCurRoom picture: 0)
						(= global113 200)
					)
				else
					(StrCpy @temp0 {a:})
					(if (= local316 (DeviceInfo 5)) ; SaveDevice
						(StrAt @temp0 0 local316)
					else
						(= local316 (StrAt @temp0 0))
					)
					(if (ValidPath @temp0)
						(StrAt gCurSaveDir 0 local316)
						(if (or (== local316 97) (== local316 65))
							(StrAt gCurSaveDir 2 0)
						)
						(= local317
							(GetSaveFiles (gGame name:) @local54 @local304)
						)
					else
						(DeviceInfo diGET_CURRENT_DEVICE @temp0)
						(ValidPath @temp0)
						(StrAt gCurSaveDir 0 (= local316 0))
						(= local317 0)
					)
				)
				(HandsOn)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(gLongSong fade: 127 4 4 0)
				(if (!= global113 200)
					(= temp65 1)
					(gGame setCursor: global75 1)
					(= register 0)
					(if local316
						(for ((= temp64 0)) (< temp64 local317) ((++ temp64))
							(if (!= (StrAt @local54 (* temp64 36)) 126)
								(++ register)
							)
						)
					)
					(proc0_12 0)
					(= temp64 global169)
					(proc0_12 1)
					(= temp0 (== global169 temp64))
					(= global169 temp64)
					(while 1
						(= temp64 (proc0_12 0))
						(if (and local316 register)
							(= local464
								(if temp0
									(choices
										init: 0 93 1 1 119 2 2 145 3 8 170 8
										show:
									)
								else
									(choices
										init:
											0
											90
											1
											1
											112
											2
											2
											134
											3
											8
											156
											8
											(+ 3 temp64)
											235
											4
										show:
									)
								)
							)
							(choices dispose:)
						else
							(= local464
								(if temp0
									(choices
										init: 0 102 1 1 136 2 8 168 8
										show:
									)
								else
									(choices
										init:
											0
											93
											1
											1
											119
											2
											8
											145
											8
											(+ 3 temp64)
											170
											4
										show:
									)
								)
							)
							(choices dispose:)
						)
						(if (== local464 4)
							(= global169 [global250 (+ temp64 1)])
						else
							(break)
						)
					)
					(if (!= local464 3)
						(gCurRoom picture: 0)
					)
					(SetPort 0 0 200 320 0 0)
				else
					(= local464 2)
				)
				(switch local464
					(1
						(= cycles 1)
						(= local3 601)
					)
					(2
						(gLongSong fade: 0 4 4 0)
						(+= state 2)
						(= ticks 1)
					)
					(3
						(if (and local316 (> local317 0))
							(gLongSong fade: 0 4 4 0)
							(= state 8)
							(= cycles 1)
						else
							(proc0_21 0 90 0)
							(= state 0)
							(= cycles 1)
						)
					)
					(8
						(= gQuit 1)
						(= cycles 3)
					)
					(else
						(StrAt gCurSaveDir 0 (= local316 0))
						(StrAt @global190 2 1)
						(StrAt @global190 3 (+ (localproc_3) 32))
						(StrAt @global190 4 37)
						(StrAt @global190 5 32)
						(MemorySegment 0 @global190 0) ; MS_SAVE_FROM
						(gGame restart:)
					)
				)
			)
			(2
				(SetPort 0 0 200 320 0 0)
				(= temp66 (- (GetTime) 180))
				(gGame setCursor: 7 1)
				(while
					(and (<= local3 618) (== ((= temp67 (Event new:)) type:) evNULL))
					(temp67 dispose:)
					(= gGameTime (GetTime))
					(if (> (Abs (- gGameTime temp66)) 180)
						(gCurRoom picture: local3)
						(DrawPic local3 10 1 global40)
						(RedrawCast)
						(++ local3)
						(= temp66 gGameTime)
					)
				)
				(if (< local3 619)
					(temp67 dispose:)
				)
				(= state 0)
				(= ticks 210)
			)
			(4
				(cond
					((>= local317 12)
						(proc0_21 0 90 1)
						(HandsOff)
						(= state 0)
						(= cycles 1)
					)
					((< (CheckFreeSpace gCurSaveDir 1) 15)
						(if register
							(proc0_21 1 90 2 (CheckFreeSpace gCurSaveDir 1))
						else
							(proc0_21 1 90 3 (CheckFreeSpace gCurSaveDir 1))
							(HandsOff)
							(= gQuit 1)
						)
						(= state 0)
						(= cycles 5)
					)
					(else
						(= temp65 (pickScreen init: show:))
						(pickScreen dispose:)
						(if temp65
							(= temp65 (alphabet init: show:))
							(alphabet dispose:)
							(if temp65
								(localproc_1 8)
								(gGame setCursor: global75 1)
								(Palette palSET_FROM_RESOURCE 999 2)
							else
								(-= state 1)
							)
						else
							(= state 0)
						)
						(= cycles 1)
					)
				)
			)
			(5
				(= global189 (localproc_3))
				(StrAt @global190 4 (+ 32 (localproc_2)))
				(= cycles 1)
			)
			(6
				(StrAt @global190 2 (+ 1 local316))
				(StrAt @global190 3 (+ (localproc_3) 32))
				(StrAt @global190 5 (+ global114 32))
				(MemorySegment 0 @global190 0) ; MS_SAVE_FROM
				(gLongSong fade: 0 4 4 0)
				(gGame setCursor: gWaitCursor)
				(gGame restart:)
			)
			(9
				(= local466 1)
				(= temp65 (pickScreen init: show:))
				(pickScreen dispose:)
				(= local466 0)
				(if temp65
					(localproc_1 8)
					(-- local2)
				else
					(= state 0)
				)
				(= cycles 1)
			)
			(10
				(DoAudio audPLAY 503)
				(= cycles 1)
			)
			(11
				(= gSaveSlot [local304 (= global114 [local451 global114])])
				(= global188 1)
				(= global189 global114)
				(if (CheckSaveGame (gGame name:) gSaveSlot gVersion)
					(StrCpy (+ @global190 6) (+ @local54 (* global114 36) 2))
					(StrAt @global190 2 (+ 1 local316))
					(StrAt @global190 3 (+ gSaveSlot 32))
					(StrAt @global190 4 (StrAt @local54 (* global114 36)))
					(StrAt @global190 5 (StrAt @local54 (+ (* global114 36) 1)))
					(MemorySegment 0 @global190 0) ; MS_SAVE_FROM
					(SetPort 0 0 200 320 0 0)
					(Palette palSET_INTENSITY 0 255 0)
					(Graph grRESTORE_BOX global109)
					(Graph grRESTORE_BOX global110)
					(DrawPic 800 0)
					(Graph grFILL_BOX 3 4 159 262 1 0 0 0)
					(Graph grUPDATE_BOX 0 0 200 320 1)
					(gGame changeScore: 0)
					(gGame restore:)
				else
					(localproc_0 8)
					(proc0_21 0 90 4 30 0 78 {OK} 1)
					(= state -1)
					(= global113 100)
					(= cycles 1)
				)
			)
		)
	)
)

(instance pickScreen of GameControls
	(properties)

	(method (init &tmp temp0)
		(if (== local464 2)
			(for ((= local2 0)) (< local2 12) ((++ local2))
				(self
					add:
						((egoChoice new:)
							cel: local2
							message: local2
							nsLeft: (+ 38 (* 45 (mod local2 6)))
							nsTop: (if (< local2 6) 63 else 106)
						)
				)
			)
		else
			(= local2 (= temp0 0))
			(while (< temp0 local317)
				(= local464 @[local54 (* temp0 18)])
				(if (!= (StrAt local464 0) 126)
					(self
						add:
							((egoChoice new:)
								cel: (- (StrAt local464 1) 32)
								nsTop: (if (< local2 6) 63 else 106)
								nsLeft: (+ 38 (* 45 (mod local2 6)))
								message: local2
								modifiers: temp0
								helpStr: (+ @local54 (* 36 temp0) 2)
								init:
							)
					)
					(= [local451 local2] temp0)
					(++ local2)
				)
				(++ temp0)
			)
		)
		(self add: cancelBut dummyIcon)
		(super init: &rest)
	)

	(method (show)
		(= local465 0)
		(= highlightedIcon (= curIcon (self at: 0)))
		(|= state $0020)
		(localproc_1 8)
		(if (not global344)
			(DrawPic 804 0 1)
		)
		(RedrawCast)
		(gGame setCursor: global75 1)
		(Palette palSET_FROM_RESOURCE 999 2)
		(localproc_4)
		(gCurRoom picture: 512)
		(DrawPic 512 0 1)
		(RedrawCast)
		(Graph grUPDATE_BOX 0 0 200 320 1)
		(if (== local464 2)
			(proc0_16 (Format @global300 90 5)) ; "Use the cursor to click on the child of your choice."
		else
			(proc0_16 (Format @global300 90 6)) ; "Choose the game that you wish to continue."
		)
		(self eachElementDo: #show)
		(localproc_0 8)
		(if (HaveMouse)
			(gGame setCursor: gTheCursor 1)
		else
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(RedrawCast)
		(self doit: hide:)
		(proc0_16 0)
		(return (not local465))
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
			(= temp0 (self indexOf: highlightedIcon))
			(switch (event message:)
				(JOY_DOWN
					(if (< temp0 6)
						(= temp1
							(self
								at:
									(if (< (= temp2 (+ temp0 6)) (- size 1))
										temp2
									else
										(- size 2)
									)
							)
						)
					else
						(= temp1 (self at: (- temp0 6)))
					)
					(localproc_5 temp1)
					(self highlight: temp1)
					(event message: JOY_NULL)
				)
				(JOY_UP
					(if (< temp0 6)
						(= temp1
							(self
								at:
									(if (< (= temp2 (+ temp0 6)) (- size 1))
										temp2
									else
										(- size 2)
									)
							)
						)
					else
						(= temp1 (self at: (- temp0 6)))
					)
					(localproc_5 temp1)
					(self highlight: temp1)
					(event message: JOY_NULL)
				)
			)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(= local465 1)
		)
		(super dispatchEvent: event &rest)
	)

	(method (advance)
		(super advance: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super advance:)
		)
	)

	(method (retreat)
		(super retreat: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super retreat:)
		)
	)
)

(instance egoChoice of IconI
	(properties
		view 200
		loop 1
		cel 0
		signal 192
	)

	(method (mask))

	(method (show)
		(super show: &rest)
		(self highlight: 0)
		(-= nsLeft 15)
		(+= nsRight 16)
		(+= nsBottom 7)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 [temp4 4] temp8)
		(= temp0 (+ 23 (* (mod message 6) 45)))
		(= temp1 (if (/ message 6) 137 else 93))
		(if local466
			(if param1
				(= temp2 6)
			else
				(= temp2 65)
			)
			(TextSize @temp4 helpStr 800)
			(if (> (- [temp4 3] [temp4 1]) 44)
				(-= temp0 2)
				(= temp8 48)
			else
				(= temp8 45)
			)
			(Display helpStr dsCOORD temp0 temp1 dsCOLOR temp2 dsWIDTH temp8 dsALIGN alCENTER dsFONT 800)
			(Graph grUPDATE_BOX (- temp1 2) (- temp0 2) (+ temp1 8) (+ temp0 52) 1)
		)
	)

	(method (select &tmp [temp0 2])
		(= global114 message)
		(pickScreen state: (& (pickScreen state:) $ffdf))
	)
)

(instance cancelBut of IconI
	(properties
		view 200
		loop 3
		cel 2
		nsLeft 234
		nsTop 31
		signal 193
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop -1)
		else
			(DrawCel view loop 2 nsLeft nsTop -1)
		)
	)

	(method (select)
		(if (super select: &rest)
			(= local465 1)
			(RedrawCast)
			(pickScreen state: (& (pickScreen state:) $ffdf))
		else
			(return 0)
		)
	)
)

(instance DPButton of DIcon ; UNUSED
	(properties
		state 3
	)

	(method (track param1 &tmp temp0)
		(if (== (param1 type:) 1)
			(repeat
				(= param1 (Event new: evPEEK))
				(param1 localize:)
				(if (and (= temp0 (self check: param1)) (not cel))
					(++ cel)
					(self draw:)
				)
				(if (and (not temp0) cel)
					(-- cel)
					(self draw:)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(= temp0 (if cel self else 0))
			(= cel 0)
			(self draw:)
			(return temp0)
		else
			(return self)
		)
	)
)

(instance choices of GameControls
	(properties)

	(method (init param1 &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 3))
			(self
				add:
					((choiceButton new:)
						loop: [param1 temp0]
						message: [param1 (+ temp0 2)]
						nsTop: [param1 (+ temp0 1)]
						yourself:
					)
			)
		)
		(super init:)
	)

	(method (show &tmp temp0)
		(= curIcon (self at: 1))
		(|= state $0020)
		(SetPort 0 0 200 320 0 0)
		(localproc_1 8)
		(if (not global344)
			(DrawPic 804 0 1)
		)
		(RedrawCast)
		(if (!= (gCurRoom picture:) 501)
			(gCurRoom picture: 501)
			(DrawPic 501 0 1)
		)
		(RedrawCast)
		(Graph grUPDATE_BOX 0 0 200 320 1)
		(DoSound sndSET_SOUND 1)
		(self eachElementDo: #show)
		(localproc_0 8)
		(RedrawCast)
		(if (HaveMouse)
			(gGame setCursor: gTheCursor 1)
		else
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(self doit: hide:)
		(highlightedIcon message:)
	)

	(method (dispatchEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance choiceButton of IconI
	(properties
		view 181
		cel 0
		nsLeft 2
		signal 321
	)

	(method (highlight))
)

(instance alphabet of GameControls
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 26) ((++ temp0))
			(self
				add:
					((= [local531 temp0] (letter new:))
						nsLeft: [local479 temp0]
						nsTop: [local505 temp0]
						message: temp0
						yourself:
					)
			)
		)
		(self add: iconBack iconOk iconForward cancelBut2 dummyIcon)
		(super init: &rest)
	)

	(method (show &tmp temp0)
		(= local465 0)
		(= curIcon (self at: 0))
		(|= state $0020)
		(localproc_1 8)
		(if (not global344)
			(DrawPic 804 0 1)
		)
		(RedrawCast)
		(gCurRoom picture: 803)
		(DrawPic 803 0 1)
		(Animate (gCast elements:) 0)
		(self eachElementDo: #show)
		(if (HaveMouse)
			(gGame setCursor: 10 1)
		else
			(gGame
				setCursor:
					10
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(localproc_0 8)
		(= local476 0)
		(nextBlock init: setCycle: Fwd)
		(= local467 gGameTime)
		(self doit: hide:)
		(nextBlock dispose:)
		(return (not local465))
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(= gGameTime (GetTime))
		(if (> (Abs (- gGameTime local467)) 6)
			(= local467 gGameTime)
			(Animate (gCast elements:) 1)
		)
		(if (== (= temp0 (event type:)) evKEYBOARD)
			(if
				(or
					(and (>= (= temp1 (event message:)) KEY_a) (<= temp1 KEY_z))
					(and (>= temp1 KEY_A) (<= temp1 KEY_Z))
				)
				(if (and (>= temp1 KEY_a) (<= temp1 KEY_z))
					(-= temp1 97)
				else
					(-= temp1 65)
				)
				(= temp4 [local531 temp1])
				(localproc_6 temp4)
				(temp4 highlight: select:)
				(= local478 1)
			else
				(switch temp1
					(JOY_UPLEFT
						(iconBack select:)
					)
					(KEY_SPACE
						(iconForward select:)
					)
					(KEY_RETURN
						(if local478
							(event message: JOY_NULL)
							(iconOk select:)
						)
					)
				)
			)
		)
		(if (and (& temp0 $0040) (IsObject highlightedIcon)) ; direction
			(= temp3 (self indexOf: highlightedIcon))
			(switch (event message:)
				(JOY_DOWN
					(if (== (highlightedIcon name:) {letter})
						(cond
							((not temp3)
								(= temp4 (self at: 2))
							)
							((< temp3 2)
								(= temp4 (self at: 10))
							)
							((< temp3 20)
								(= temp4 (self at: (+ temp3 8)))
							)
							(else
								(= temp4 (self at: (- size 3)))
							)
						)
					else
						(= temp4 (self at: 0))
					)
					(localproc_6 temp4)
					(self highlight: temp4)
				)
				(JOY_UP
					(if (== (highlightedIcon name:) {letter})
						(cond
							((< temp3 2)
								(= temp4 (self at: (- size 3)))
							)
							((< temp3 6)
								(= temp4 (self at: 0))
							)
							((< temp3 11)
								(= temp4 (self at: 1))
							)
							((< temp3 29)
								(= temp4 (self at: (- temp3 8)))
							)
							(else
								(= temp4 (self at: 24))
							)
						)
					else
						(= temp4 (self at: (- temp3 6)))
					)
					(localproc_6 temp4)
					(self highlight: temp4)
				)
			)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(= local465 1)
		)
		(super dispatchEvent: event)
	)

	(method (advance)
		(super advance: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super advance:)
		)
	)

	(method (retreat)
		(super retreat: &rest)
		(if (== (highlightedIcon name:) {dummyIcon})
			(super retreat:)
		)
	)
)

(instance dummyIcon of IconI
	(properties
		nsRight 320
		nsBottom 190
	)

	(method (highlight))

	(method (select))

	(method (show))
)

(instance cancelBut2 of IconI
	(properties
		view 803
		loop 5
		cel 2
		nsLeft 129
		nsTop 2
		signal 193
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop -1)
		else
			(DrawCel view loop 2 nsLeft nsTop -1)
		)
	)

	(method (select)
		(if (super select: &rest)
			(= local465 1)
			(RedrawCast)
			(alphabet state: (& (alphabet state:) $ffdf))
		else
			(return 0)
		)
	)
)

(instance iconOk of IconI
	(properties
		view 803
		loop 6
		cel 2
		nsLeft 161
		nsTop 2
		signal 129
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(if (== (StrLen @local468) 0)
				(proc0_21 0 90 7)
			else
				(= temp0 0)
				(for ((= temp1 0)) (< temp1 local317) ((++ temp1))
					(if (not (StrCmp @local468 (+ @local54 (* temp1 36) 2)))
						(= temp0 1)
					)
				)
				(if temp0
					(proc0_21 0 90 8)
				else
					(StrCpy (+ @global190 6) @local468)
					(alphabet state: (& (alphabet state:) $ffdf))
				)
			)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop 15)
		else
			(DrawCel view loop 2 nsLeft nsTop 15)
		)
	)
)

(instance letter of IconI
	(properties
		view 803
		loop 2
		cel 2
		signal 129
	)

	(method (select)
		(if (and (super select: &rest) (< local476 8))
			(gSfx number: 597 play:)
			(StrAt @local468 local476 (+ message 65))
			(++ local476)
			(localproc_7 1)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop 15)
		else
			(DrawCel view loop 2 nsLeft nsTop 15)
		)
	)
)

(instance iconBack of IconI
	(properties
		view 803
		loop 2
		cel 2
		nsLeft 97
		nsTop 2
		signal 129
	)

	(method (select)
		(if (and (super select: &rest) local476)
			(gSfx number: 597 play:)
			(-- local476)
			(StrAt @local468 local476 0)
			(localproc_7 0)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop 15)
		else
			(DrawCel view loop 2 nsLeft nsTop 15)
		)
	)
)

(instance iconForward of IconI
	(properties
		view 803
		loop 2
		cel 2
		nsLeft 193
		nsTop 2
		signal 129
	)

	(method (select)
		(if (and (super select: &rest) local476 (< local476 8))
			(StrAt @local468 local476 32)
			(++ local476)
			(localproc_8 1)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop 15)
		else
			(DrawCel view loop 2 nsLeft nsTop 15)
		)
	)
)

(instance nextBlock of Prop
	(properties
		x 98
		y 52
		view 803
		loop 4
		priority 15
		signal 16
		cycleSpeed 19
	)
)

