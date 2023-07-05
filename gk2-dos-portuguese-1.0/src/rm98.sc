;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use GK2Room)
(use Interface)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Scaler)
(use Feature)
(use Cursor)
(use Timer)
(use Sound)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	rm98 0
)

(local
	local0 = 2
	local1
	local2 = 627
	local3
	local4
	local5
	local6
	local7 = 1
	local8
	local9
	local10
	local11
	local12
	local13 = 25
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21 = 1
	local22 = 1
	local23
	local24
	local25
	local26
	local27 = 100
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
	[local50 6]
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
)

(procedure (localproc_0)
	(local45 setLoop: 0 1 setLooper: 0 setCycle: 0 setCel: 0)
	(FrameOut)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2)
	(= temp1 (gThePlane left:))
	(= temp2 (gThePlane right:))
	(cond
		((== (gCurRoom picture:) 7001)
			(= local3 960)
		)
		((== (gCurRoom picture:) 4003)
			(= local3 1920)
		)
	)
	(cond
		((== param1 1)
			(-= local1 local0)
			(-= local2 local0)
		)
		((== param1 0)
			(+= local1 local0)
			(+= local2 local0)
		)
	)
	(if (> (- gScreenWidth local1) local3)
		(+= local1 local0)
	)
	(if (> local1 0)
		(= local1 0)
	)
	(gThePlane setRect: local1 15 local3 349)
	(UpdatePlane gThePlane)
	(localproc_8)
)

(procedure (localproc_2 &tmp temp0)
	(if (not local29)
		(return)
	)
	(while (local29 size:)
		(DeleteLine (= temp0 (local29 at: 0)) (gCast plane:))
		(local29 delete: temp0)
	)
	(= local29 0)
	(FrameOut)
)

(procedure (localproc_3 param1)
	(= local26 2)
	(localproc_9 {actor's scaler now 0})
	(localproc_2)
	(param1 setScaler: 0 setScale: 0)
	(UpdateScreenItem param1)
)

(procedure (localproc_4 param1 &tmp [temp0 6]) ; UNUSED
	(if local29
		(localproc_2)
	)
	(= local29 (Set new:))
	(SetNowSeen param1)
	(local29
		add:
			(AddLine
				(gCast plane:)
				(param1 nsLeft:)
				(- (param1 nsTop:) 1)
				(param1 nsRight:)
				(- (param1 nsTop:) 1)
				200
				1
				0
				0
				1
			)
	)
	(local29
		add:
			(AddLine
				(gCast plane:)
				(param1 nsRight:)
				(- (param1 nsTop:) 1)
				(param1 nsRight:)
				(param1 nsBottom:)
				200
				1
				0
				0
				1
			)
	)
	(local29
		add:
			(AddLine
				(gCast plane:)
				(param1 nsRight:)
				(param1 nsBottom:)
				(param1 nsLeft:)
				(param1 nsBottom:)
				200
				1
				0
				0
				1
			)
	)
	(local29
		add:
			(AddLine
				(gCast plane:)
				(param1 nsLeft:)
				(param1 nsBottom:)
				(param1 nsLeft:)
				(- (param1 nsTop:) 1)
				200
				1
				0
				0
				1
			)
	)
	(FrameOut)
)

(procedure (localproc_5 param1)
	(StopRobot)
	(if argc
		(gCurRoom picture: param1)
	)
	(if (not (gCast contains: act0))
		(act0 init:)
		(= local45 act0)
	)
	(if (local45 scaler:)
		((local45 scaler:) doit:)
	)
	(= local47 1)
)

(procedure (localproc_6)
	(if (gTimers contains: textTimer)
		(textTimer dispose: delete:)
	)
	(if (and argc local31)
		(local31 dispose:)
	)
	(if (tmpDlg text:)
		(tmpDlg dispose: text: 0)
	)
	(= local31 0)
)

(procedure (localproc_7)
	(= local26 2)
	(localproc_9 {Scaler tool})
	(gEgo
		view: (local45 view:)
		x: (local45 x:)
		y: (local45 y:)
		z: 0
		setLoop: (local45 loop:)
		cel: (local45 cel:)
		init:
	)
	(local45 x: 1000 y: 1000)
	(UpdateScreenItem local45)
	((ScriptID 29 0) doit:) ; scalerCode
	(= local34 ((gEgo scaler:) frontSize:))
	(= local35 ((gEgo scaler:) backSize:))
	(= local36 ((gEgo scaler:) frontY:))
	(= local37 ((gEgo scaler:) backY:))
	(local45
		x: (gEgo x:)
		y: (gEgo y:)
		setScaler: Scaler local34 local35 local36 local37
	)
	(gEgo z: 1000)
)

(procedure (localproc_8)
	(if (not local21)
		(return 0)
	else
		(if (and (== local22 1) (not local23) (act9 onMeCheck:))
			(if local24
				(local39
					format:
						{(PAUSED) robot: %hu frame: %d of %d x: %d y: %d W: %d H: %d pri: %d pic: %hu}
						local61
						local58
						local57
						local59
						local60
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local25
						(gCurRoom picture:)
				)
			else
				(local39
					format:
						{robot: %hu frame: %d of %d xOffSet: %d yOffSet: %d W: %d H: %d pri: %d pic: %hu}
						local61
						local58
						local57
						local59
						local60
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local25
						(gCurRoom picture:)
				)
			)
		else
			(local39
				format:
					{%s: view: %hu loop: %d cel: %d x:%d y:%d pri: %d pic: %hu\n}
					(local45 name:)
					(local45 view:)
					(local45 loop:)
					(local45 cel:)
					(local45 x:)
					(local45 y:)
					(local45 priority:)
					(gCurRoom picture:)
			)
		)
		(if (local39 data:)
			(localproc_9 (local39 data:))
		)
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3)
	(if (not local21)
		(return 0)
	else
		(localproc_6 0)
		(= local31 (Str format: &rest))
		(= temp2 (local31 size:))
		(switch local26
			(6
				(= temp3 14)
			)
			(2
				(= temp3 14)
			)
			(0
				(= temp3 254)
			)
			(else
				(= temp3 43)
			)
		)
		(cond
			((OneOf local26 6 2)
				(= temp0 (- 145 temp2))
			)
			((OneOf local26 1 3 4)
				(= temp0 (- 135 (/ temp2 2)))
			)
			((or local24 (act9 onMeCheck:))
				(= temp0 20)
			)
			(else
				(= temp0 (- 90 (/ temp2 2)))
			)
		)
		(tmpDlg
			font: 0
			text: (KString 8 (local31 data:)) ; StrDup
			fore: 15
			back: temp3
			setPri: 255
			setSize: 300
			x: (- temp0 local1)
			y: 317
			init:
		)
		(if (> (= temp1 (+ (GetTime) (* (/ (* 24 temp2) 10) gTextSpeed))) 360)
			(= temp1 360)
		)
		(if (< temp1 240)
			(= temp1 240)
		)
		(if (not (OneOf local26 0 6))
			(textTimer setTicks: textTimer temp1)
			(= local26 5)
		)
	)
)

(procedure (localproc_10 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (GetNumber {Scaler fs:}))
	(= temp1 (GetNumber {Scaler bs:}))
	(= temp2 (GetNumber {Scaler fy:}))
	(= temp3 (GetNumber {Scaler by:}))
	(local45 setScaler: Scaler temp0 temp1 temp2 temp3)
)

(procedure (localproc_11 param1 param2 param3 param4 param5 &tmp temp0)
	(Robot 0 param1 gThePlane param5 param2 param3) ; Open
	(= local58 0)
	(Robot 1 0 param2 param3) ; DisplayFrame
	(= temp0 (IntArray new: 4))
	(= local64 (= local57 (Robot 2 (temp0 data:)))) ; FrameInfo
	(temp0 dispose:)
	(act9 onMeCheck: RobotFeature)
	(if local63
		(local63 dispose:)
		(= local63 0)
	)
	(if local62
		(local62 dispose:)
		(= local62 0)
	)
	((= local63 (IntArray new: local57)) init:)
	((= local62 (IntArray new: local57)) init:)
	(= local24 0)
	(= local20 local61)
)

(instance rm98 of GK2Room
	(properties)

	(method (init)
		(StopRobot)
		(gThePlane picture: -1)
		(UpdatePlane gThePlane)
		(FrameOut)
		(localproc_5 -1)
		(super init: &rest)
		(= local38 8)
		(gDirectionHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(= local39 (Str new:))
		(gGame setCursor: testCursor)
	)

	(method (doVerb))

	(method (newRoom newRoomNumber)
		(= local9 1)
		(localproc_0)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(localproc_6 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp [temp0 3])
		(if
			(and
				(not local23)
				(act9 onMeCheck:)
				(or
					(and (< local58 (- local57 1)) (!= local58 (Robot 11))) ; FrameNum
					((gUser curEvent:) type:)
					(!= local48 gMouseX)
					(!= local49 gMouseY)
				)
			)
			(RobotFeature BAD_SELECTOR:)
		)
		(= local48 gMouseX)
		(= local49 gMouseY)
		(if
			(and
				(not (OneOf local26 6 5))
				(or
					local47
					(!= local40 (local45 cel:))
					(!= local42 (local45 x:))
					(!= local43 (local45 y:))
				)
			)
			(localproc_8)
			(= local42 (local45 x:))
			(= local43 (local45 y:))
			(= local40 (local45 cel:))
			(= local47 0)
		)
		(if local46
			(local45 x: local48 y: local49)
			(if (not (local45 fixPriority:))
				(local45 priority: local49)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 3] temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16)
		(event localize: (gCast plane:))
		(cond
			((event claimed:)
				(if local5
					(PrintDebug {event claimed})
				)
			)
			(
				(and
					(== (event type:) evKEYBOARD)
					local6
					(OneOf (event message:) KEY_LEFT KEY_RIGHT KEY_DOWN KEY_UP)
				)
				(event claimed: 1)
				(switch (event message:)
					(KEY_LEFT
						(-- local59)
					)
					(KEY_RIGHT
						(++ local59)
					)
					(KEY_UP
						(-- local60)
					)
					(KEY_DOWN
						(++ local60)
					)
					(JOY_UPRIGHT
						(++ local59)
						(-- local60)
					)
					(JOY_DOWNRIGHT
						(++ local60)
						(++ local59)
					)
					(JOY_DOWNLEFT
						(++ local60)
						(-- local59)
					)
					(JOY_UPLEFT
						(-- local60)
						(-- local59)
					)
					(JOY_NULL)
					(else
						(if local5
							(PrintDebug {(event message?) %d} (event message:))
						)
						(event claimed: 0)
					)
				)
				(if (Robot 6) ; Exists
					(Robot 1 local58 local59 local60) ; DisplayFrame
				)
				(localproc_8)
			)
			(
				(and
					(== (event type:) evKEYBOARD)
					local7
					(OneOf
						(event message:)
						KEY_UP
						KEY_DOWN
						KEY_LEFT
						KEY_RIGHT
						$4900 ; PAGEUP
						$5100 ; PAGEDOWN
						KEY_HOME
						KEY_END
					)
				)
				(= temp3 (local45 x:))
				(= temp4 (local45 y:))
				(switch (event message:)
					(KEY_LEFT
						(= temp3 (- (local45 x:) 1))
						(= temp4 (local45 y:))
					)
					(KEY_RIGHT
						(= temp3 (+ (local45 x:) 1))
						(= temp4 (local45 y:))
					)
					(KEY_UP
						(= temp3 (local45 x:))
						(= temp4 (- (local45 y:) 1))
					)
					(KEY_DOWN
						(= temp3 (local45 x:))
						(= temp4 (+ (local45 y:) 1))
					)
					($4900 ; PAGEUP
						(= temp4 (- (local45 y:) 1))
						(= temp3 (+ (local45 x:) 1))
					)
					($5100 ; PAGEDOWN
						(= temp4 (+ (local45 y:) 1))
						(= temp3 (+ (local45 x:) 1))
					)
					(KEY_END
						(= temp4 (+ (local45 y:) 1))
						(= temp3 (- (local45 x:) 1))
					)
					(KEY_HOME
						(= temp4 (- (local45 y:) 1))
						(= temp3 (- (local45 x:) 1))
					)
				)
				(if local5
					(PrintDebug
						{Actors new X is %d actors new y is %d}
						temp3
						temp4
					)
				)
				(local45 x: temp3 y: temp4)
				(FrameOut)
				(event claimed: 1)
				(localproc_8)
			)
			((and (== (event type:) evKEYBOARD) (not (event claimed:)))
				(if (== local11 2)
					(cueScript dispose:)
					(localproc_11 local61 local59 local60 gEgo local25)
				)
				(if (== local26 5)
					(= local26 0)
					(localproc_6 0)
				)
				(event claimed: 1)
				(switch (event message:)
					(KEY_DELETE
						(if (not (act9 onMeCheck:))
							(event claimed: 0)
						else
							(= local26 2)
							(localproc_9 {funtion replaced by avirobot})
						)
					)
					(KEY_DIVIDE
						(= temp0 (GetNumber {Intensity: }))
						(gGame BAD_SELECTOR: temp0)
					)
					($007c ; |
						(-- local27)
						(gGame BAD_SELECTOR: local27)
						(= local47 1)
					)
					(KEY_ADD
						(++ local27)
						(gGame BAD_SELECTOR: local27)
						(= local47 1)
					)
					($003d ; =
						(if local33
							(= temp0 (gCurRoom picture:))
							(gCurRoom drawPic: local33 picture: local33)
							(= local33 temp0)
						else
							(= local33 (gCurRoom picture:))
							(gCurRoom drawPic: -1 picture: -1)
						)
					)
					(KEY_F10
						(if (and (not local23) (act9 onMeCheck:))
							(= local58 0)
							(Robot 1 0 local59 local60) ; DisplayFrame
							(= local47 1)
						)
					)
					(KEY_SPACE
						(cond
							((and (not local23) (not (act9 onMeCheck:))))
							((not local24)
								(= local24 1)
								(Robot 10) ; Pause
							)
							(else
								(= local24 0)
								(Robot 4) ; Play
							)
						)
						(= local47 1)
					)
					(KEY_ESCAPE
						(if local56
							(= local56 0)
							(palView dispose:)
						)
					)
					(KEY_F9
						(if (< (= temp0 (GetNumber {Priority #?})) 0)
							(= local26 2)
							(localproc_9 {priority released})
							(local45 setPri: -1)
						else
							(local45 priority: temp0 fixPriority: 1)
						)
						(= local47 1)
					)
					(else
						(cond
							((OneOf (event message:) JOY_DOWNRIGHT JOY_DOWNRIGHT)
								(= temp0 (local45 view:))
								(= local26 2)
								(localproc_9 {actors view unloaded from memory})
								(local45 view: 2)
								(localproc_0)
								(UnLoad 128 temp0)
								(Purge 16000)
							)
							((OneOf (event message:) $000f $000f)
								(if (gCurRoom obstacles:)
									(= local26 2)
									(localproc_9 {removing room's obstacles})
									((gCurRoom obstacles:) dispose:)
									(gCurRoom obstacles: 0)
								)
							)
							((OneOf (event message:) KEY_TAB KEY_TAB)
								(if (and (not local23) (act9 onMeCheck:))
									(Printf
										{%hu.rbt\nframe %d of %d\nxOffSet: %d, yOffSet: %d\nwidth: %d, height: %d }
										local61
										local58
										local57
										local59
										local60
										(-
											(RobotFeature nsRight:)
											(RobotFeature nsLeft:)
										)
										(-
											(RobotFeature nsBottom:)
											(RobotFeature nsTop:)
										)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_o KEY_ALT_o)
								(event claimed: 0 message: KEY_ALT_f)
								((ScriptID 99 0) handleEvent: event) ; debugRm
							)
							((OneOf (event message:) KEY_ALT_i KEY_ALT_i)
								(if local21
									(= local21 0)
									(SetFlag 1)
									(gThePlane
										setRect: 12 15 627 479
										priority: 5000
									)
									(UpdatePlane gThePlane)
									(FrameOut)
								else
									(= local21 1)
									(SetFlag 1)
									(gThePlane setRect: 12 15 627 349 priority: 1)
									(UpdatePlane gThePlane)
									(FrameOut)
								)
							)
							((OneOf (event message:) JOY_RIGHT JOY_RIGHT)
								(if (act9 onMeCheck:)
									(switch local11
										(0
											(= local26 2)
											(localproc_9
												{position robot then press ctrl-c again}
											)
											(= local11 1)
										)
										(1
											(Robot 7) ; Terminate
											(act9 onMeCheck: 0)
											(= local26 2)
											(= local23 1)
											(localproc_9
												{checking for robot cues}
											)
											(= local11 2)
											(gCurRoom setScript: cueScript 0 0)
										)
									)
								else
									(= local26 2)
									(localproc_9 {open robot first})
								)
							)
							((OneOf (event message:) JOY_DOWN JOY_DOWN)
								(= temp0 (GetNumber {Intensity:}))
								(gEgo BAD_SELECTOR: temp0 0)
							)
							((OneOf (event message:) KEY_T KEY_t)
								(cond
									((or local11 local23)
										(= local23 0)
										(= local26 2)
										(= local11 0)
										(localproc_9 {turned off robot looping})
										(StopRobot)
									)
									((act9 onMeCheck:)
										(= local23 0)
										(Robot 7) ; Terminate
										(Printf {robot terminated})
										(act9 onMeCheck: 0)
										(= local47 1)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_a KEY_ALT_a)
								(if (== (Platform 0) 1)
									(Prints
										{AVI playback not available in DOS}
									)
								else
									(= temp13 (Str new:))
									(Print
										font: gUserFont
										addTitle: {AVI filename?}
										addEdit: temp13 12 1 5
										init:
									)
									(= local16 (GetNumber {x offset} local16))
									(= local17 (GetNumber {y offset} local17))
									(Printf {looking for movie %s} temp13)
									(Prints temp13)
									(= local12 (ShowMovie 1 0 local15)) ; Put
									(temp13 dispose:)
									(Printf
										{movieerror is code %d}
										local12
									)
									(if (!= local12 0)
										(Prints
											{Error opening avi..use full name ie. 100.avi }
										)
									else
										(ShowMovie 1 7) ; Put
										(ShowMovie 1 11 0) ; Put
										(ShowMovie 1 1 local16 local17) ; Put
										(ShowMovie 1 2) ; Put
										(= local19 (ShowMovie 1 10)) ; Put
										(Printf {Movie status %d} local19)
										(ShowMovie 1 6) ; Put
										(= local18 (ShowMovie 1 8)) ; Put
										(Printf
											{Movie is %d frames long}
											local18
										)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_v KEY_ALT_v)
								(= temp13 (Str new:))
								(Print
									font: gUserFont
									addTitle: {vmd movie file name?}
									addEdit: temp13 12 1 5
									init:
								)
								(if (ResCheck 151 (temp13 asInteger:)) ; VMD
									(if
										(Print
											addText: {Black lines?}
											addButton: 0 {no} 0 12
											addButton: 1 {yes} 0 26
											init:
										)
										(= local8 1)
									else
										(= local8 0)
									)
									(cond
										(
											(Print
												addText: {Double Size?}
												addButton: 0 {no} 0 12
												addButton: 1 {yes} 0 26
												init:
											)
											(if local8
												(= temp16 37)
											else
												(= temp16 33)
											)
										)
										(local8
											(= temp16 36)
										)
										(else
											(= temp16 32)
										)
									)
									(= temp14 12)
									(= temp15 14)
									(if
										(= local13
											(GetNumber {RGB boost %} local13)
										)
										(if local5
											(Printf
												{boosting brightness %d }
												local13
											)
										)
										(|= temp16 $0010)
									)
									(gCurRoom drawPic: -1)
									(PlayVMD 0 (temp13 data:) 0) ; Open
									(temp13 dispose:)
									(if local13
										(if local5
											(Printf
												{boosting..p3 is %d}
												temp16
											)
										)
										(PlayVMD
											1 ; Put
											temp14
											temp15
											temp16
											local13
											0
											236
										)
									else
										(PlayVMD 1 temp14 temp15 temp16) ; Put
									)
									(PlayVMD 21 12 15 627 349) ; Black
									(PlayVMD 14 7) ; WaitEvent
									(PlayVMD 6) ; Close
									(gCurRoom drawPic: (gCurRoom picture:))
									(UpdatePlane (gCast plane:))
									(FrameOut)
								else
									(Prints {Movie file not found})
								)
							)
							((OneOf (event message:) KEY_s KEY_S)
								(if (local45 scaler:)
									(local45 setScale: 0)
								else
									(localproc_10)
								)
							)
							((OneOf (event message:) KEY_ALT_s KEY_ALT_s)
								(cond
									((!= local45 palView)
										(= temp13 (Str new:))
										(if (local45 scaler:)
											(temp13
												format:
													{Current scaler: %d %d %d %d\nEnter choice or pic no.\n}
													((local45 scaler:)
														frontSize:
													)
													((local45 scaler:)
														backSize:
													)
													((local45 scaler:) frontY:)
													((local45 scaler:) backY:)
											)
										else
											(temp13
												format:
													{Current scaler: none\nEnter choice:\n}
											)
										)
										(switch
											(Print
												font: 0
												addText: temp13 3 2
												addButton: 0 {NEVER MIND} 3 20
												addButton: 1 {scaler OFF} 65 20
												addButton: 2 {scaler tool} 3 35
												addButton:
													3
													{manual input}
													65
													95
												init:
											)
											(1
												(localproc_3 local45)
											)
											(2
												(localproc_7)
											)
											(3
												(localproc_10)
											)
										)
										(temp13 dispose:)
										(if (local45 scaler:)
											(= local34
												((local45 scaler:) frontSize:)
											)
											(= local35
												((local45 scaler:) backSize:)
											)
											(= local36
												((local45 scaler:) frontY:)
											)
											(= local37
												((local45 scaler:) backY:)
											)
										)
									)
									((local45 scaler:)
										(localproc_3 local45)
									)
									(else
										(localproc_7)
									)
								)
								(= local47 1)
							)
							((OneOf (event message:) KEY_ALT_w KEY_ALT_w)
								((ScriptID 64948 0) doit:) ; MISSING SCRIPT
							)
							((OneOf (event message:) KEY_ALT_t KEY_ALT_t)
								(if
									(ResCheck
										rsSCRIPT
										(= temp0 (GetNumber {Teleport to:}))
									)
									(cond
										(local23
											(StopRobot)
										)
										((act9 onMeCheck:)
											(Robot 7) ; Terminate
											(act9 onMeCheck: 0)
										)
									)
									(gCurRoom newRoom: temp0)
								else
									(= local26 4)
									(local39
										format:
											{ERROR: script %hu not found}
											temp0
									)
									(localproc_9 (local39 data:))
								)
							)
							((OneOf (event message:) KEY_p KEY_P)
								(if
									(and
										(!=
											(= local66
												(GetNumber {Pic #?} local66)
											)
											-1
										)
										(ResCheck rsPIC local66)
									)
									(= local33 (gCurRoom picture:))
									(gCurRoom picture: local66 drawPic: local66)
									(= local47 1)
								else
									(= local26 4)
									(local39
										format:
											{ERROR: picture: %hu not found.}
											local66
									)
									(localproc_9 (local39 data:))
									(= local66 (gCurRoom picture:))
								)
							)
							((OneOf (event message:) KEY_ALT_p KEY_ALT_p)
								(cond
									((not (ResCheck rsVIEW (palView view:)))
										(Printf
											{ERROR: can't find view 1111.v56!}
										)
									)
									((not local56)
										(= local56 1)
										(palView init: setPri: 200)
									)
									(else
										(= local56 0)
										(palView dispose:)
									)
								)
							)
							((OneOf (event message:) KEY_v KEY_V)
								(if (!= (= local38 (GetNumber {View #?})) -1)
									(if (ResCheck rsVIEW local38)
										(local45 show: cel: 0 view: local38)
										(if (or (< local38 0) (> local38 15))
											(localproc_0)
											(local45 setLoop: 0 1 setCycle: 0)
										)
										(if (== local38 20211)
											(RemapColors 2 243 150) ; ByPercent
										)
										(UpdateScreenItem local45)
										(= local47 1)
									else
										(= local26 4)
										(localproc_9
											{View %hu not found.}
											local38
										)
									)
								)
							)
							((OneOf (event message:) KEY_b KEY_B)
								(cond
									(
										(or
											(== local45 palView)
											(local45 mover:)
											(act9 onMeCheck:)
										))
									((not (local45 lastCel:))
										(= local26 1)
										(local39
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local45 view:)
												(local45 loop:)
										)
										(localproc_9 (local39 data:))
									)
									((not (local45 cel:))
										(local45
											cel: (local45 lastCel:)
											setCycle: Beg
										)
									)
									(else
										(local45 setCycle: Beg)
									)
								)
								(= local47 1)
							)
							((OneOf (event message:) JOY_DOWNLEFT JOY_DOWNLEFT)
								(cond
									((act9 onMeCheck:))
									((not (local45 lastCel:))
										(= local26 1)
										(local39
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local45 view:)
												(local45 loop:)
										)
										(localproc_9 (local39 data:))
									)
									(else
										(local45 setCycle: Fwd)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_l KEY_ALT_l)
								(cond
									((and (not local23) (not (act9 onMeCheck:))))
									(local23
										(= local26 2)
										(localproc_9 {turned off robot looping})
										(= local23 0)
										(StopRobot)
									)
									(else
										(Robot 7) ; Terminate
										(act9 onMeCheck: 0)
										(= local26 2)
										(= local23 1)
										(localproc_9 {robot looping})
										(PlayRobot local61 local59 local60)
										(FrameOut)
									)
								)
							)
							((OneOf (event message:) KEY_l KEY_L)
								(= temp0 -1)
								(cond
									((not (local45 lastLoop:))
										(= local26 3)
										(local39
											format:
												{ERROR: view %hu only has 1 loop!}
												(local45 view:)
										)
										(localproc_9 (local39 data:))
									)
									((== (local45 loop:) (local45 lastLoop:))
										(= temp0 0)
									)
									((!= (local45 loop:) (local45 lastLoop:))
										(= temp0 (+ (local45 loop:) 1))
									)
									(else
										(= temp0 (local45 lastLoop:))
									)
								)
								(if (!= temp0 -1)
									(localproc_0)
									(local45 setLoop: temp0 1)
								)
								(= local47 1)
							)
							((OneOf (event message:) KEY_h KEY_H)
								(if (& (local45 signal:) $0008)
									(local45 show:)
								else
									(local45 hide:)
								)
								(FrameOut)
								(= local47 1)
							)
							((OneOf (event message:) KEY_k KEY_K)
								(cond
									((== local45 palView))
									((local45 looper:)
										(= local26 2)
										(localproc_9
											{curActor's looper turned off}
										)
										(localproc_0)
									)
									(else
										(= local26 2)
										(localproc_9 {reset curActor})
										(localproc_0)
									)
								)
								(= local47 1)
							)
							((OneOf (event message:) KEY_PAUSE KEY_PAUSE)
								(= temp0 (GetNumber {Sound# ?}))
								(if
									(and
										(not (ResCheck rsAUDIO temp0))
										(not (ResCheck 140 temp0)) ; WAVE
										(not (ResCheck rsSOUND temp0))
									)
									(= local26 4)
									(local39
										format: {Sound %hu not found.} temp0
									)
									(localproc_9 (local39 data:))
								else
									(gDac
										number: temp0
										setLoop: (GetNumber {loop?} 1)
										play:
									)
								)
							)
							((OneOf (event message:) KEY_SHIFT KEY_SHIFT)
								(gDac play:)
							)
							((OneOf (event message:) KEY_O KEY_o)
								(if local23
									(= local23 0)
									(StopRobot)
								)
								(= local61 (GetNumber {file number} local61))
								(if (act9 onMeCheck:)
									(Robot 7) ; Terminate
									(act9 onMeCheck: 0)
								)
								(if (and (!= local61 -1) (ResCheck 22 local61))
									(= local25 (GetNumber {priority} -1))
									(= local59 (GetNumber {x offset} local59))
									(= local60 (GetNumber {y offset} local60))
									(localproc_11
										local61
										local59
										local60
										gEgo
										local25
									)
									(= local7 0)
									(= local6 1)
									(= local22 1)
								else
									(= local26 4)
									(local39
										format:
											{ERROR: can't find %hu.rbt}
											local61
									)
									(localproc_9 (local39 data:))
									(if local20
										(= local61 local20)
									)
								)
							)
							((OneOf (event message:) KEY_MENU KEY_MENU)
								(localproc_5)
							)
							((OneOf (event message:) KEY_ALT_d KEY_ALT_d)
								(if local5
									(= local5 0)
									(Prints {debug disabled})
								else
									(= local5 1)
									(Prints {debug enabled})
								)
							)
							((== (event message:) $003c) ; <
								(localproc_1 0)
							)
							((== (event message:) $003e) ; >
								(localproc_1 1)
							)
							((OneOf (event message:) KEY_RETURN KEY_RETURN)
								(= local0
									(GetNumber
										{scroll step in pixels?}
										local0
									)
								)
							)
							((OneOf (event message:) $000e $000e)
								(gThePlane setRect: 0 15 627 349)
								(UpdatePlane gThePlane)
							)
							((OneOf (event message:) KEY_w KEY_W)
								(if (== local22 1)
									(= local22 2)
									(= local7 1)
									(= local6 0)
									(if local5
										(PrintDebug {View selected})
									)
								else
									(= local22 1)
									(= local6 1)
									(= local7 0)
									(if local5
										(PrintDebug {Bot selected})
									)
								)
								(= local47 1)
							)
							((OneOf (event message:) KEY_f KEY_F)
								(if
									(and
										(act9 onMeCheck:)
										(< local58 (- local57 1))
									)
									(RobotFeature BAD_SELECTOR:)
									(++ local58)
									(if (not (local62 at: local58))
										(Robot 1 local58 local59 local60) ; DisplayFrame
									)
								)
								(= local47 1)
							)
							((OneOf (event message:) KEY_r KEY_R)
								(if (act9 onMeCheck:)
									(if (> local58 0)
										(-- local58)
									)
									(if (not (local62 at: local58))
										(Robot 1 local58 local59 local60) ; DisplayFrame
									)
								)
								(= local47 1)
							)
							(
								(OneOf
									(event message:)
									KEY_q
									KEY_Q
									KEY_CONTROL
									KEY_CONTROL
									KEY_ALT_x
									KEY_ALT_x
								)
								(if
									((= temp12 (Print new:))
										width: 160
										font: 0
										fore: 1
										back: 24
										addTitle: {Have a nice day!}
										addText: {QUIT?} 1 1
										addButton: 1 {YES} 1 15
										addButton: 0 {NO} 30 15
										init:
									)
									(gGame quitGame:)
								)
							)
							((OneOf (event message:) KEY_F1 KEY_QUESTION)
								(gCurRoom setScript: helpScript)
							)
							((OneOf (event message:) KEY_e KEY_E KEY_ALT_r KEY_ALT_r)
								(cond
									((act9 onMeCheck:)
										(= local24 0)
										(= local23 0)
										(RobotFeature BAD_SELECTOR:)
										(if
											(OneOf
												local58
												0
												local57
												(- local57 1)
											)
											(Robot
												0 ; Open
												local61
												gThePlane
												local25
												local59
												local60
											)
											(= local58 0)
											(Robot 1 0 local59 local60) ; DisplayFrame
										)
										(Robot 4) ; Play
									)
									(
										(or
											(== local45 palView)
											(local45 mover:)
											(act9 onMeCheck:)
										))
									((not (local45 lastCel:))
										(= local26 1)
										(local39
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local45 view:)
												(local45 loop:)
										)
										(localproc_9 (local39 data:))
									)
									((== (local45 cel:) (local45 lastCel:))
										(local45 cel: 0 setCycle: End)
									)
									(else
										(local45 setCycle: End)
									)
								)
								(= local47 1)
							)
							(
								(OneOf
									(event message:)
									KEY_ALT_f
									KEY_ALT_f
									KEY_ALT_b
									KEY_ALT_b
									KEY_ALT_c
									KEY_ALT_c
									KEY_ALT_n
									KEY_ALT_n
								)
								(= temp1 (local45 cel:))
								(if (> (-- temp1) -1)
									(local45 cel: temp1)
								else
									(= temp1 (local45 lastCel:))
									(local45 cel: temp1)
								)
								(= local47 1)
							)
							((OneOf (event message:) KEY_i KEY_I KEY_ALT_e KEY_ALT_e)
								(= temp13 (Str new:))
								(if (local45 scaler:)
									(temp13
										format:
											{%s %d %d %d %d}
											((local45 scaler:) name:)
											((local45 scaler:) frontSize:)
											((local45 scaler:) backSize:)
											((local45 scaler:) frontY:)
											((local45 scaler:) backY:)
									)
								else
									(temp13 format: {%s} {none})
								)
								(Printf
									{name: %s\nclass: %s\nview: %hu\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaler: %s\n}
									((gCast at: (gCast indexOf: local45))
										name:
									)
									(((gCast at: (gCast indexOf: local45))
											-super-:
										)
										name:
									)
									((gCast at: (gCast indexOf: local45))
										view:
									)
									((gCast at: (gCast indexOf: local45))
										loop:
									)
									((gCast at: (gCast indexOf: local45))
										cel:
									)
									((gCast at: (gCast indexOf: local45))
										x:
									)
									((gCast at: (gCast indexOf: local45))
										y:
									)
									((gCast at: (gCast indexOf: local45))
										z:
									)
									((gCast at: (gCast indexOf: local45))
										heading:
									)
									((gCast at: (gCast indexOf: local45))
										priority:
									)
									((gCast at: (gCast indexOf: local45))
										signal:
									)
									(temp13 data:)
								)
								(temp13 dispose:)
							)
							((OneOf (event message:) KEY_c KEY_C KEY_n KEY_N)
								(cond
									((not (local45 lastCel:))
										(= local26 1)
										(local39
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local45 view:)
												(local45 loop:)
										)
										(localproc_9 (local39 data:))
									)
									((== (local45 cel:) (local45 lastCel:))
										(local45 cel: 0)
									)
									(else
										(= temp1 (+ (local45 cel:) 1))
										(local45 cel: temp1)
									)
								)
								(= local47 1)
							)
							(
								(OneOf
									(event message:)
									KEY_0
									KEY_1
									KEY_2
									KEY_3
									KEY_4
									KEY_5
									KEY_6
									KEY_7
									KEY_8
									KEY_9
								)
								(switch (event message:)
									(KEY_0
										(act0 init:)
										(= local45 act0)
									)
									(KEY_1
										(act1 init:)
										(= local45 act1)
									)
									(KEY_2
										(act2 init:)
										(= local45 act2)
									)
									(KEY_3
										(act3 init:)
										(= local45 act3)
									)
									(KEY_4
										(act4 init:)
										(= local45 act4)
									)
									(KEY_5
										(act5 init:)
										(= local45 act5)
									)
									(KEY_6
										(act6 init:)
										(= local45 act6)
									)
									(KEY_7
										(act7 init:)
										(= local45 act7)
									)
									(KEY_8
										(act8 init:)
										(= local45 act8)
									)
									(KEY_9
										(act9 init:)
										(= local45 act9)
									)
								)
								(= local47 1)
							)
						)
					)
				)
			)
			((& (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(if local5
					(PrintDebug {event type is mousedown})
				)
				(cond
					(local7
						(local45 x: gMouseX y: gMouseY)
					)
					((== local11 2)
						(cueScript dispose:)
						(localproc_11 local61 local59 local60 gEgo local25)
					)
					(local23
						(StopRobot)
						(PlayRobot
							local61
							(+ (event x:) local59)
							(+ (event y:) local60)
						)
					)
					(
						(and
							(Robot 6) ; Exists
							(RobotFeature onMe: (event x:) (event y:))
						)
						(RobotFeature BAD_SELECTOR:)
						(= local7 0)
						(= temp8 (- (event x:) local59))
						(= temp9 (- (event y:) local60))
						(while
							(!=
								((= temp10 ((gUser curEvent:) new:)) type:)
								2
							)
							(temp10 localize: (gCurRoom plane:))
							(RobotFeature BAD_SELECTOR:)
							(Robot
								1 ; DisplayFrame
								local58
								(= local59 (- (temp10 x:) temp8))
								(= local60 (- (temp10 y:) temp9))
							)
							(temp10 dispose:)
							(localproc_8)
							(FrameOut)
						)
						(temp10 dispose:)
						(localproc_8)
						(FrameOut)
					)
					((& (event modifiers:) $000b) ; emALT | emSHIFT
						(if (= local44 (gCast firstTrue: #onMe event))
							(if (!= (= local45 local44) palView)
								(= local41 (local45 loop:))
								(= local40 (local45 cel:))
								(localproc_0)
								(local45 cel: local40 setLoop: local41 1 show:)
								(if (> (local45 view:) 15)
									(local45 setCycle: 0)
								)
								(UpdateScreenItem local45)
								(FrameOut)
								(= temp13
									(Str format: {curActor: %s} (local45 name:))
								)
							)
						else
							(= local44 0)
						)
						(= local47 1)
					)
				)
			)
			((== (event type:) evMOUSERELEASE)
				(= local46 0)
				(if (and (!= local45 palView) (local45 scaler:))
					((local45 scaler:) doit:)
				)
			)
			(else
				(if local5
					(PrintDebug {event handled by thegame})
				)
				(gGame handleEvent: event)
			)
		)
		(event claimed: 1)
	)

	(method (cue)
		(if local23
			(PlayRobot local61 local59 local60)
		else
			(gDac pause: 0)
		)
	)

	(method (dispose)
		(if (not local9)
			(localproc_0)
			(gDirectionHandler delete: self)
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
			(localproc_6 0)
		)
		(super dispose: &rest)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Prints
					{The Elite Tester V1.0\nAlt-o: Polygon Editor\nAlt-i: Toggle Full Screen\nm: Toggle Mover\nAlt-s: Set Scaler\ns: Manual-toggle Scaler\nAlt-t: Teleport\np: Picture\n=: Toggle picture\nAlt-p: Toggle Palette\nv: View\nctrl-d: Unload current View \nAlt-v: VMD player\nAlt-A: AVI player\n}
				)
				(= cycles 2)
			)
			(1
				(Prints
					{ e: EndLoop\nb: BegLoop\nctrl-f: Forward\nl: loop\nh: Hide-show actor\nk: Normalize Actor\nCtrl-s: Play Sound\nCtrl-p: Play sFx\nF9: Set Pri\nCtrl-b: Actor lastCel\nCtrl-r: Reset room\ni: curActor Information\nn: nextCel-LastCel\nAlt-n: Previous Cel\n0-9: Actors\n}
				)
				(= cycles 2)
			)
			(2
				(Prints
					{ o: Open robot\nf: Advance robot frame\nr: Retreat robot frame\nDELETE: Delete robot frame\nctrl-c: Tag robot frame for cue\ne,alt-r: Play robot\nt: Terminate robot\nctrl-i: Show robot info\nd: Display single robot frame.\n<,>: Scroll large Pics left and right\nctrl-m: Change scroll step size\nctrl-n: Reset plane rectangle (for scrolled pics)\nAlt-d: Toggle debug on/off\n}
				)
				(self dispose:)
			)
		)
	)
)

(instance act0 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act1 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act2 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act3 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act4 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act5 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act6 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act7 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act8 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance act9 of GK2Ego
	(properties
		x 160
		y 100
		view 8
		signal 26657
	)
)

(instance palView of View
	(properties
		x 67
		y 15
		priority 200
		fixPriority 1
		view 1111
		signal 26657
	)
)

(instance _111_dat of File ; UNUSED
	(properties
		name {111.dat}
	)
)

(instance testCursor of Cursor
	(properties
		view 9960
	)
)

(instance textTimer of Timer
	(properties)

	(method (cue)
		(= local26 0)
		(= local47 1)
		(localproc_6 0)
	)
)

(class RobotFeature of Feature
	(properties)

	(method (BAD_SELECTOR &tmp temp0)
		(= temp0 (IntArray new: 4))
		(Robot 2 (temp0 data:)) ; FrameInfo
		(= nsLeft (temp0 at: 0))
		(= nsTop (temp0 at: 1))
		(= nsRight (temp0 at: 2))
		(= nsBottom (temp0 at: 3))
		(temp0 dispose:)
		(if (>= (= local58 (Robot 11)) local57) ; FrameNum
			(= local58 (- local57 1))
		)
		(= local47 1)
	)
)

(instance tmpDlg of DText
	(properties)
)

(instance cueScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local10 (Str with: {cue at: }))
				(PlayRobot local61 local59 local60 gEgo local25 1)
			)
			(1
				(if (gEgo robot:)
					(++ register)
					(= temp0 (Str format: {%d } (Robot 11))) ; FrameNum
					(local10 cat: temp0)
					(= local26 6)
					(localproc_9 (local10 data:))
					(temp0 dispose:)
					(-- state)
				else
					(= temp0 (Str with: {robot done }))
					(if register
						(temp0 cat: local10)
					)
					(= local26 2)
					(localproc_9 (temp0 data:))
					(local10 dispose:)
					(temp0 dispose:)
					(= seconds 5)
				)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(StopRobot)
		(Robot 7) ; Terminate
		(act9 onMeCheck: 0)
		(= local47 1)
		(= local23 0)
		(= local11 0)
		(= local57 0)
		(= local58 0)
		(= local26 0)
		(localproc_6 0)
		(super dispose: &rest)
	)
)

(instance overlayPlane of Plane ; UNUSED
	(properties)
)

(instance gDac of Sound
	(properties)
)

