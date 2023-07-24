;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use Location)
(use RamaInterface)
(use VMDMovie)
(use Interface)
(use Str)
(use Array)
(use Print)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Cursor)
(use Timer)
(use Sound)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	rm111 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5 = 1
	local6
	local7
	local8
	local9 = 6
	local10 = 100
	local11
	local12
	[local13 3]
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	[local33 6]
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
	local50
	local51
	local52
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(if (and argc param1)
		(= temp1 param1)
	else
		(= temp1 0)
	)
	(if (> argc 1)
		(= temp2 param2)
	else
		(= temp2 gEgo)
	)
	(WalkieTalkie killRobot: 0)
)

(procedure (localproc_1)
	(if local28
		(local28 setLoop: 0 1 setLooper: 0 setCycle: 0)
		(FrameOut)
	)
)

(procedure (localproc_2 &tmp temp0)
	(if (not local12)
		(return)
	)
	(while (local12 size:)
		(DeleteLine (= temp0 (local12 at: 0)) (local50 plane:))
		(local12 delete: temp0)
	)
	(= local12 0)
	(FrameOut)
)

(procedure (localproc_3 param1)
	(= local9 2)
	(tmpDlg display: {actor's scaler now 0})
	(localproc_2)
	(param1 setScaler: 0 setScale: 0)
	(UpdateScreenItem param1)
)

(procedure (localproc_4 param1 &tmp [temp0 6]) ; UNUSED
	(if local12
		(localproc_2)
	)
	(= local12 (Set new:))
	(SetNowSeen param1)
	(local12
		add:
			(AddLine
				(local50 plane:)
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
	(local12
		add:
			(AddLine
				(local50 plane:)
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
	(local12
		add:
			(AddLine
				(local50 plane:)
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
	(local12
		add:
			(AddLine
				(local50 plane:)
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
	(cond
		(local6
			(localproc_0)
		)
		((act9 onMeCheck:)
			(Robot 7) ; Terminate
			(act9 onMeCheck: 0)
		)
	)
	(if argc
		(gCurRoom picture: param1 drawPic: param1)
	)
	(if (not (local50 contains: act0))
		(act0 setLoop: 0 1 setCycle: 0 init: local50 hide:)
		(act1 init: local50 hide:)
		(act2 init: local50 hide:)
		(act3 init: local50 hide:)
		(act4 init: local50 hide:)
		(act5 init: local50 hide:)
		(act6 init: local50 hide:)
		(act7 init: local50 hide:)
		(act8 init: local50 hide:)
		(act9 init: local50 hide:)
	)
	(if
		(and
			(= local28 (local50 at: 0))
			(!= local28 palView)
			(local28 respondsTo: #scaler)
			(local28 scaler:)
		)
		((local28 scaler:) doit:)
	)
	(= local30 1)
)

(procedure (localproc_6)
	(= local9 2)
	(tmpDlg display: {Scaler tool})
	(gEgo
		view: (local28 view:)
		x: (local28 x:)
		y: (local28 y:)
		z: 0
		setLoop: (local28 loop:)
		cel: (local28 cel:)
		init:
	)
	(local28 x: 1000 y: 1000)
	(UpdateScreenItem local28)
	((ScriptID 11 0) doit:) ; MISSING SCRIPT
	(= local17 ((gEgo scaler:) frontSize:))
	(= local18 ((gEgo scaler:) backSize:))
	(= local19 ((gEgo scaler:) frontY:))
	(= local20 ((gEgo scaler:) backY:))
	(local28
		x: (gEgo x:)
		y: (gEgo y:)
		setScaler: Scaler local17 local18 local19 local20
	)
	(gEgo z: 1000)
)

(procedure (localproc_7)
	(cond
		((not local4)
			(return 0)
		)
		((and (== local5 1) (not local6) (act9 onMeCheck:))
			(if local7
				(tmpDlg
					display:
						{(PAUSED) robot: %hu frame: %d of %d x: %d y: %d W: %d H: %d pri: %d pic: %hu}
						local44
						local41
						local40
						local42
						local43
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local8
						(gCurRoom picture:)
				)
			else
				(tmpDlg
					display:
						{robot: %hu frame: %d of %d xOffSet: %d yOffSet: %d W: %d H: %d pri: %d pic: %hu}
						local44
						local41
						local40
						local42
						local43
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local8
						(gCurRoom picture:)
				)
			)
		)
		(else
			(tmpDlg
				display:
					{%s: view: %hu loop: %d cel: %d x:%d y:%d pri: %d pic: %hu Mem: %u\n}
					(local28 name:)
					(local28 view:)
					(local28 loop:)
					(local28 cel:)
					(local28 x:)
					(local28 y:)
					(local28 priority:)
					(gCurRoom picture:)
					(MemoryInfo 0)
			)
		)
	)
)

(procedure (localproc_8 &tmp temp0)
	(if (not local4)
		(return 0)
	else
		(tmpDlg display: &rest)
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (GetNumber {Scaler fs:}))
	(= temp1 (GetNumber {Scaler bs:}))
	(= temp2 (GetNumber {Scaler fy:}))
	(= temp3 (GetNumber {Scaler by:}))
	(local28 setScaler: Scaler temp0 temp1 temp2 temp3)
)

(procedure (localproc_10 param1 param2 param3 &tmp temp0 temp1 temp2)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp2 param3)
	else
		(= temp2 0)
	)
	((= gAutoRobot (WalkieTalkie new:))
		plane: global116
		doRobot: param1 temp1 temp2 rm111 act9 0 0
	)
	(= global107 param1)
)

(procedure (localproc_11 param1 param2 param3 param4 param5 &tmp temp0)
	(Robot 0 param1 global116 param5 param2 param3) ; Open
	(= local41 0)
	(Robot 1 0 param2 param3) ; DisplayFrame
	(= temp0 (IntArray new: 4))
	(= local47 (= local40 (Robot 2 (temp0 data:)))) ; FrameInfo
	(temp0 dispose:)
	(act9 onMeCheck: RobotFeature)
	(if local46
		(local46 dispose:)
		(= local46 0)
	)
	(if local45
		(local45 dispose:)
		(= local45 0)
	)
	((= local46 (IntArray new: local40)) init:)
	((= local45 (IntArray new: local40)) init:)
	(= local7 0)
	(= local3 local44)
)

(procedure (localproc_12 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (Str new:))
	(testVMDMovie
		options: 0
		plane: -1
		priority: -1
		loop: 0
		rgbBoost: 0
		frameRate: -1
		cacheSize: 0
	)
	(= temp2 (IntArray with: 0 0 0 0))
	(Text 0 (temp2 data:) {A} gUserFont 320) ; TextSize
	(= temp3 (+ (temp2 at: 3) 6))
	(testVMDMovie movieName: (GetNumber {VMD Movie Number: }))
	(repeat
		(switch
			(= temp1
				((Print new:)
					addTitle: {VMD Put options}
					mode: 1
					addText: {Select Put Option} 0 (* 0 temp3)
					addButton: 1 {Pixel Double} 0 (* 2 temp3)
					addButton: 4 {Black Lines} 0 (* 3 temp3)
					addButton: 256 {Stretch Vertical} 0 (* 4 temp3)
					addButton: 64 {Leave Last Frame} 0 (* 5 temp3)
					addButton: 16 {Boost RGB} 0 (* 6 temp3)
					addButton: 32 {Leave Black Frame} 0 (* 7 temp3)
					addButton: 128 {Black Pal} 0 (* 8 temp3)
					addButton: -1 {Use Graphics Mngr} 0 (* 9 temp3)
					addButton: -2 {Loop} 0 (* 10 temp3)
					addButton: -3 {Set Cache Size} 0 (* 11 temp3)
					addButton: -4 {Set Frame Rate} 0 (* 12 temp3)
					addButton: 0 {Show Movie} 0 (* 15 temp3)
					init:
				)
			)
			(-1
				(testVMDMovie plane: global116)
			)
			(-2
				(testVMDMovie loop: 1)
			)
			(-3
				(testVMDMovie cacheSize: (GetNumber {Cache Size:}))
				(if (<= 0 (= temp4 (GetNumber {Percent PreLoad:})) 100)
					(testVMDMovie preLoadPCT: temp4)
				)
			)
			(-4
				(testVMDMovie frameRate: (GetNumber {Percent boost:}))
			)
			(0
				(break)
			)
			(else
				(if (== temp1 16)
					(= temp4 (GetNumber {Percent boost:}))
					(if (<= 0 temp4 100)
						(testVMDMovie rgbBoost: temp4)
						(testVMDMovie
							options: (| (testVMDMovie options:) temp1)
						)
					)
				else
					(testVMDMovie options: (| (testVMDMovie options:) temp1))
				)
			)
		)
	)
	(if (not (testVMDMovie open:))
		(Prints {File not found})
		(return 0)
	)
	(testVMDMovie play:)
	(testVMDMovie close:)
	(return (temp0 dispose:))
)

(instance rm111 of Location
	(properties)

	(method (init)
		(localproc_0)
		(gThePlane picture: -1)
		(UpdatePlane gThePlane)
		(FrameOut)
		(super init: &rest)
		(= gTesterSound testerSound)
		(= local51 global112)
		(global124 casts: (Set new:))
		(= global112 (Cast new:))
		(global124 addCast: global112)
		(global112 plane: global124)
		(= local50 global117)
		(localproc_5)
		(= local21 1)
		(gDirectionHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(= local22 (Str new:))
		(tmpDlg init: ((global124 casts:) at: 0))
	)

	(method (doVerb))

	(method (newRoom newRoomNumber)
		(global112 dispose:)
		(global124 addCast: local51)
		(= local0 1)
		(localproc_1)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(tmpDlg dispose:)
		(gEgo z: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp [temp0 3])
		(if
			(and
				(not local6)
				(act9 onMeCheck:)
				(or
					(and (< local41 (- local40 1)) (!= local41 (Robot 11))) ; FrameNum
					((gUser curEvent:) type:)
					(!= local31 gMouseX)
					(!= local32 gMouseY)
				)
			)
			(RobotFeature setNowSeen:)
		)
		(= local31 (- gMouseX (global116 left:)))
		(= local32 (- gMouseY (global116 top:)))
		(if
			(and
				(not (OneOf local9 6 5))
				(or
					local30
					(!= local23 (local28 cel:))
					(!= local25 (local28 x:))
					(!= local26 (local28 y:))
				)
			)
			(localproc_7)
			(if local28
				(= local25 (local28 x:))
				(= local26 (local28 y:))
				(= local23 (local28 cel:))
			)
			(= local30 0)
		)
		(if local29
			(local28 x: local31 y: local32)
			(if (not (local28 fixPriority:))
				(local28 priority: local32)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 3] temp8 temp9 temp10 temp11 temp12 temp13 [temp14 3])
		(event localize: (local50 plane:))
		(cond
			((event claimed:))
			((not (event type:))
				(localproc_7)
			)
			((& (event type:) $0010) ; direction
				(if (== local9 5)
					(= local9 0)
				)
				(if (and (not local6) (act9 onMeCheck:))
					(event claimed: 1)
					(switch (event message:)
						(JOY_LEFT
							(-- local42)
						)
						(JOY_RIGHT
							(++ local42)
						)
						(JOY_UP
							(-- local43)
						)
						(JOY_DOWN
							(++ local43)
						)
						(JOY_UPRIGHT
							(++ local42)
							(-- local43)
						)
						(JOY_DOWNRIGHT
							(++ local43)
							(++ local42)
						)
						(JOY_DOWNLEFT
							(++ local43)
							(-- local42)
						)
						(JOY_UPLEFT
							(-- local43)
							(-- local42)
						)
						(JOY_NULL)
						(else
							(Printf
								{(event message?) %d}
								(event message:)
							)
							(event claimed: 0)
						)
					)
					(if (event claimed:)
						(Robot 1 local41 local42 local43) ; DisplayFrame
					)
					(localproc_7)
				else
					(= temp3 (local28 x:))
					(= temp4 (local28 y:))
					(switch (event message:)
						(JOY_LEFT
							(= temp3 (- (local28 x:) 1))
							(= temp4 (local28 y:))
						)
						(JOY_RIGHT
							(= temp3 (+ (local28 x:) 1))
							(= temp4 (local28 y:))
						)
						(JOY_UP
							(= temp3 (local28 x:))
							(= temp4 (- (local28 y:) 1))
						)
						(JOY_DOWN
							(= temp3 (local28 x:))
							(= temp4 (+ (local28 y:) 1))
						)
						(JOY_UPRIGHT
							(= temp4 (- (local28 y:) 1))
							(= temp3 (+ (local28 x:) 1))
						)
						(JOY_DOWNRIGHT
							(= temp4 (+ (local28 y:) 1))
							(= temp3 (+ (local28 x:) 1))
						)
						(JOY_DOWNLEFT
							(= temp4 (+ (local28 y:) 1))
							(= temp3 (- (local28 x:) 1))
						)
						(JOY_UPLEFT
							(= temp4 (- (local28 y:) 1))
							(= temp3 (- (local28 x:) 1))
						)
					)
					(local28 x: temp3 y: temp4)
				)
			)
			((== (event type:) evKEYBOARD)
				(if (== local2 2)
					(cueScript dispose:)
					(localproc_11 local44 local42 local43 gEgo local8)
				)
				(if (== local9 5)
					(= local9 0)
				)
				(event claimed: 1)
				(switch (event message:)
					(KEY_DELETE
						(if (not (act9 onMeCheck:))
							(event claimed: 0)
						else
							(= local9 2)
							(tmpDlg display: {funtion replaced by avirobot})
						)
					)
					(KEY_DIVIDE
						(= temp0 (GetNumber {Intensity: }))
						(gGame setIntensity: temp0)
					)
					($007c ; |
						(-- local10)
						(gGame setIntensity: local10)
						(= local30 1)
					)
					(KEY_ADD
						(++ local10)
						(gGame setIntensity: local10)
						(= local30 1)
					)
					($003d ; =
						(if local16
							(= temp0 (gCurRoom picture:))
							(gCurRoom drawPic: local16 picture: local16)
							(= local16 temp0)
						else
							(= local16 (gCurRoom picture:))
							(gCurRoom drawPic: -1 picture: -1)
						)
					)
					(KEY_F10
						(if (and (not local6) (act9 onMeCheck:))
							(= local41 0)
							(Robot 1 0 local42 local43) ; DisplayFrame
							(= local30 1)
						)
					)
					(KEY_SPACE
						(cond
							((and (not local6) (not (act9 onMeCheck:))))
							((not local7)
								(= local7 1)
								(Robot 10) ; Pause
							)
							(else
								(= local7 0)
								(Robot 4) ; Play
							)
						)
						(= local30 1)
					)
					(KEY_ESCAPE
						(if local39
							(= local39 0)
							(palView dispose:)
						)
					)
					(KEY_F9
						(if (< (= temp0 (GetNumber {Priority #?})) 0)
							(= local9 2)
							(tmpDlg display: {priority released})
							(local28 setPri: -1)
						else
							(local28 priority: temp0 fixPriority: 1)
						)
						(= local30 1)
					)
					(else
						(cond
							((OneOf (event message:) JOY_DOWNRIGHT JOY_DOWNRIGHT)
								(= temp0 (local28 view:))
								(= local9 2)
								(tmpDlg
									display: {actors view unloaded from memory}
								)
								(local28 view: 2)
								(localproc_1)
								(UnLoad 128 temp0)
								(Purge 16000)
							)
							((OneOf (event message:) $000f $000f)
								(if (gCurRoom obstacles:)
									(= local9 2)
									(tmpDlg
										display: {removing room's obstacles}
									)
									((gCurRoom obstacles:) dispose:)
									(gCurRoom obstacles: 0)
								)
							)
							((OneOf (event message:) KEY_TAB KEY_TAB)
								(if (and (not local6) (act9 onMeCheck:))
									(Printf
										{%hu.rbt\nframe %d of %d\nxOffSet: %d, yOffSet: %d\nwidth: %d, height: %d }
										local44
										local41
										local40
										local42
										local43
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
								(event claimed: 0)
								((ScriptID 10 0) handleEvent: event) ; debugRm
							)
							((OneOf (event message:) JOY_RIGHT JOY_RIGHT)
								(if (act9 onMeCheck:)
									(switch local2
										(0
											(= local9 2)
											(tmpDlg
												display:
													{position robot then press ctrl-c again}
											)
											(= local2 1)
										)
										(1
											(Robot 7) ; Terminate
											(act9 onMeCheck: 0)
											(= local9 2)
											(= local6 1)
											(tmpDlg
												display:
													{checking for robot cues}
											)
											(= local2 2)
											(gCurRoom setScript: cueScript 0 0)
										)
									)
								else
									(= local9 2)
									(tmpDlg display: {open robot first})
								)
							)
							((OneOf (event message:) JOY_DOWN JOY_DOWN)
								(= temp0 (GetNumber {Intensity:}))
								(gEgo setIntensity: temp0 0)
							)
							((OneOf (event message:) KEY_T KEY_t)
								(cond
									((or local2 local6)
										(= local6 0)
										(= local9 2)
										(= local2 0)
										(tmpDlg
											display: {turned off robot looping}
										)
										(localproc_0)
									)
									((act9 onMeCheck:)
										(= local6 0)
										(Robot 7) ; Terminate
										(act9 onMeCheck: 0)
										(= local30 1)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_v KEY_ALT_v)
								(localproc_12)
							)
							((OneOf (event message:) KEY_ALT_z KEY_ALT_z))
							((OneOf (event message:) KEY_m KEY_M)
								(localproc_12)
							)
							((OneOf (event message:) KEY_s KEY_S)
								(if (local28 scaler:)
									(local28 setScale: 0)
								else
									(localproc_9)
								)
							)
							((OneOf (event message:) KEY_ALT_s KEY_ALT_s)
								(cond
									((!= local28 palView)
										(= temp13 (Str new:))
										(if (local28 scaler:)
											(temp13
												format:
													{Current scaler: %d %d %d %d\nEnter choice or pic no.\n}
													((local28 scaler:)
														frontSize:
													)
													((local28 scaler:)
														backSize:
													)
													((local28 scaler:) frontY:)
													((local28 scaler:) backY:)
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
												addButton: 3 {20200} 65 35
												addButton: 4 {20100} 3 50
												addButton: 5 {10700} 65 50
												addButton: 6 {13100} 3 65
												addButton: 7 {1800} 65 65
												addButton: 8 {1801} 3 80
												addButton: 9 {18100} 65 80
												addButton: 10 {18200} 3 95
												addButton:
													11
													{manual input}
													65
													95
												init:
											)
											(1
												(localproc_3 local28)
											)
											(2
												(localproc_6)
											)
											(3
												(local28
													setScaler:
														Scaler
														135
														77
														130
														97
												)
											)
											(4
												(local28
													setScaler:
														Scaler
														100
														47
														130
														98
												)
											)
											(5
												(local28
													setScaler:
														Scaler
														192
														71
														162
														98
												)
											)
											(6
												(local28
													setScaler:
														Scaler
														181
														50
														165
														87
												)
											)
											(7
												(local28
													setScaler:
														Scaler
														93
														93
														122
														121
												)
											)
											(8
												(local28
													setScaler:
														Scaler
														88
														87
														120
														119
												)
											)
											(9
												(local28
													setScaler:
														Scaler
														149
														84
														135
														102
												)
											)
											(10
												(local28
													setScaler:
														Scaler
														156
														84
														152
														97
												)
											)
											(11
												(localproc_9)
											)
										)
										(temp13 dispose:)
										(if (local28 scaler:)
											(= local17
												((local28 scaler:) frontSize:)
											)
											(= local18
												((local28 scaler:) backSize:)
											)
											(= local19
												((local28 scaler:) frontY:)
											)
											(= local20
												((local28 scaler:) backY:)
											)
										)
									)
									((local28 scaler:)
										(localproc_3 local28)
									)
									(else
										(localproc_6)
									)
								)
								(= local30 1)
							)
							((OneOf (event message:) KEY_ALT_w KEY_ALT_w)
								((ScriptID 64948 0) doit:) ; Class_64948_0
							)
							((OneOf (event message:) KEY_ALT_t KEY_ALT_t)
								(if
									(ResCheck
										rsSCRIPT
										(= temp0 (GetNumber {Teleport to:}))
									)
									(cond
										(local6
											(localproc_0)
										)
										((act9 onMeCheck:)
											(Robot 7) ; Terminate
											(act9 onMeCheck: 0)
										)
									)
									(if gCurRoom
										(gCurRoom newRoom: temp0)
									else
										(gRegions eachElementDo: #newRoom temp0)
										(= gNewRoomNum temp0)
									)
								else
									(= local9 4)
									(tmpDlg
										display:
											{ERROR: script %hu not found}
											temp0
									)
								)
							)
							((OneOf (event message:) KEY_p)
								(if
									(and
										(!=
											(= local49
												(GetNumber {Pic #?} local49)
											)
											-1
										)
										(ResCheck rsPIC local49)
									)
									(= local16 (gCurRoom picture:))
									(gCurRoom picture: local49 drawPic: local49)
									(= local30 1)
								else
									(= local9 4)
									(tmpDlg
										display:
											{ERROR: picture: %hu not found.}
											local49
									)
									(= local49 (gCurRoom picture:))
								)
							)
							((== (event message:) KEY_P)
								(local50 eachElementDo: #dispose)
								(if (== local50 global117)
									(= local50 global112)
								else
									(= local50 global117)
								)
								(localproc_5)
							)
							((OneOf (event message:) KEY_ALT_p KEY_ALT_p)
								(if
									(==
										(= local21
											(GetNumber
												{X Posn [ESC Centers]}
												(local28 x:)
											)
										)
										-1
									)
									(= local21
										(-
											296
											(>>
												(-
													(CelWide
														(local28 view:)
														(local28 loop:)
														(local28 cel:)
													)
													1
												)
												$0001
											)
										)
									)
								)
								(local28 x: local21)
								(UpdateScreenItem local28)
								(FrameOut)
								(if
									(==
										(= local21
											(GetNumber
												{Y Posn [ESC Centers]}
												(local28 y:)
											)
										)
										-1
									)
									(= local21
										(-
											146
											(>>
												(-
													(CelHigh
														(local28 view:)
														(local28 loop:)
														(local28 cel:)
													)
													1
												)
												$0001
											)
										)
									)
								)
								(local28 y: local21)
								(UpdateScreenItem local28)
								(FrameOut)
							)
							((OneOf (event message:) KEY_v KEY_V)
								(if (!= (= local21 (GetNumber {View #?})) -1)
									(if (ResCheck rsVIEW local21)
										(local28 show: cel: 0 view: local21)
										(if (or (< local21 0) (> local21 15))
											(localproc_1)
											(local28 setLoop: 0 1 setCycle: 0)
										)
										(if
											(and
												(OneOf
													local21
													2006
													2004
													2000
												)
												(not local52)
											)
											((= local52 (View new:))
												bitmap:
													(Bitmap
														0 ; Create
														593
														293
														0
														0
														gScreenWidth
														gScreenHeight
														1
													)
												x: 0
												y: 0
												priority: 500
												fixPriority: 1
											)
											(Bitmap
												5 ; AddRect
												(local52 bitmap:)
												0
												0
												592
												292
												238
											)
											(RemapColors 1 238 0 75 1) ; ByRange
											(local52 init: global117)
										)
										(UpdateScreenItem local28)
										(= local30 1)
									else
										(= local9 4)
										(tmpDlg
											display:
												{View %hu not found.}
												local21
										)
									)
								)
							)
							((OneOf (event message:) KEY_b KEY_B)
								(cond
									(
										(or
											(== local28 palView)
											(local28 mover:)
											(act9 onMeCheck:)
										))
									((not (local28 lastCel:))
										(= local9 1)
										(tmpDlg
											display:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local28 view:)
												(local28 loop:)
										)
									)
									((not (local28 cel:))
										(local28
											cel: (local28 lastCel:)
											setCycle: Beg
										)
									)
									(else
										(local28 setCycle: Beg)
									)
								)
								(= local30 1)
							)
							((OneOf (event message:) JOY_DOWNLEFT JOY_DOWNLEFT)
								(cond
									((act9 onMeCheck:))
									((not (local28 lastCel:))
										(= local9 1)
										(tmpDlg
											display:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local28 view:)
												(local28 loop:)
										)
									)
									(else
										(local28 setCycle: Fwd)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_l KEY_ALT_l)
								(cond
									((and (not local6) (not (act9 onMeCheck:))))
									(local6
										(= local9 2)
										(tmpDlg
											display: {turned off robot looping}
										)
										(= local6 0)
										(localproc_0)
									)
									(else
										(Robot 7) ; Terminate
										(act9 onMeCheck: 0)
										(= local9 2)
										(= local6 1)
										(tmpDlg display: {robot looping})
										(localproc_10 local44 local42 local43)
										(FrameOut)
									)
								)
							)
							((OneOf (event message:) KEY_l KEY_L)
								(= temp0 -1)
								(cond
									((not (local28 lastLoop:))
										(= local9 3)
										(tmpDlg
											display:
												{ERROR: view %hu only has 1 loop!}
												(local28 view:)
										)
									)
									((== (local28 loop:) (local28 lastLoop:))
										(= temp0 0)
									)
									((!= (local28 loop:) (local28 lastLoop:))
										(= temp0 (+ (local28 loop:) 1))
									)
									(else
										(= temp0 (local28 lastLoop:))
									)
								)
								(if (!= temp0 -1)
									(localproc_1)
									(local28 setLoop: temp0 1)
								)
								(= local30 1)
							)
							((OneOf (event message:) KEY_h KEY_H)
								(if (& (local28 signal:) $0008)
									(local28 show:)
								else
									(local28 hide:)
								)
								(FrameOut)
								(= local30 1)
							)
							((OneOf (event message:) KEY_k KEY_K)
								(cond
									((== local28 palView))
									((local28 looper:)
										(= local9 2)
										(tmpDlg
											display:
												{curActor's looper turned off}
										)
										(localproc_1)
									)
									(else
										(= local9 2)
										(tmpDlg display: {reset curActor})
										(localproc_1)
									)
								)
								(= local30 1)
							)
							((OneOf (event message:) KEY_PAUSE KEY_PAUSE)
								(= temp0 (GetNumber {Sound# ?}))
								(if
									(and
										(not (ResCheck rsAUDIO temp0))
										(not (ResCheck 140 temp0)) ; WAVE
										(not (ResCheck rsSOUND temp0))
									)
									(= local9 4)
									(tmpDlg
										display: {Sound %hu not found.} temp0
									)
								else
									(gTesterSound number: temp0)
									(= temp0 (GetNumber {loop?}))
									(gTesterSound setLoop: temp0 play:)
								)
							)
							((OneOf (event message:) KEY_SHIFT KEY_SHIFT)
								(gTesterSound play:)
							)
							((OneOf (event message:) KEY_O KEY_o)
								(if local6
									(= local6 0)
									(localproc_0)
								)
								(= local44 (GetNumber {file number} local44))
								(if (act9 onMeCheck:)
									(Robot 7) ; Terminate
									(act9 onMeCheck: 0)
								)
								(if (and (!= local44 -1) (ResCheck 22 local44))
									(= local8 (GetNumber {priority} -1))
									(= local42 (GetNumber {x offset} local42))
									(= local43 (GetNumber {y offset} local43))
									(localproc_11
										local44
										local42
										local43
										gEgo
										local8
									)
								else
									(= local9 4)
									(tmpDlg
										display:
											{ERROR: can't find %hu.rbt}
											local44
									)
									(if local3
										(= local44 local3)
									)
								)
							)
							((OneOf (event message:) KEY_MENU KEY_MENU)
								(local50 eachElementDo: #dispose)
								(localproc_5)
							)
							((OneOf (event message:) KEY_w KEY_W)
								(if (== local5 1)
									(= local5 2)
								else
									(= local5 1)
								)
								(= local30 1)
							)
							((OneOf (event message:) KEY_f KEY_F)
								(if
									(and
										(act9 onMeCheck:)
										(< local41 (- local40 1))
									)
									(RobotFeature setNowSeen:)
									(++ local41)
									(if (not (local45 at: local41))
										(Robot 1 local41 local42 local43) ; DisplayFrame
									)
								)
								(= local30 1)
							)
							((OneOf (event message:) KEY_r KEY_R)
								(if (act9 onMeCheck:)
									(if (> local41 0)
										(-- local41)
									)
									(if (not (local45 at: local41))
										(Robot 1 local41 local42 local43) ; DisplayFrame
									)
								)
								(= local30 1)
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
										(= local7 0)
										(= local6 0)
										(RobotFeature setNowSeen:)
										(if
											(OneOf
												local41
												0
												local40
												(- local40 1)
											)
											(Robot
												0 ; Open
												local44
												global116
												local8
												local42
												local43
											)
											(= local41 0)
											(Robot 1 0 local42 local43) ; DisplayFrame
										)
										(Robot 4) ; Play
									)
									(
										(or
											(== local28 palView)
											(local28 mover:)
											(act9 onMeCheck:)
										))
									((not (local28 lastCel:))
										(= local9 1)
										(tmpDlg
											display:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local28 view:)
												(local28 loop:)
										)
									)
									((== (local28 cel:) (local28 lastCel:))
										(local28 cel: 0 setCycle: End)
									)
									(else
										(local28 setCycle: End)
									)
								)
								(= local30 1)
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
								(= temp1 (local28 cel:))
								(if (> (-- temp1) -1)
									(local28 cel: temp1)
								else
									(= temp1 (local28 lastCel:))
									(local28 cel: temp1)
								)
								(= local30 1)
							)
							((OneOf (event message:) KEY_i KEY_I KEY_ALT_e KEY_ALT_e)
								(= temp13 (Str new:))
								(if (local28 scaler:)
									(temp13
										format:
											{%s %d %d %d %d}
											((local28 scaler:) name:)
											((local28 scaler:) frontSize:)
											((local28 scaler:) backSize:)
											((local28 scaler:) frontY:)
											((local28 scaler:) backY:)
									)
								else
									(temp13 format: {%s} {none})
								)
								(Printf
									{name: %s\nclass: %s\nview: %hu\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaler: %s\n}
									((local50 at: (local50 indexOf: local28))
										name:
									)
									(((local50 at: (local50 indexOf: local28))
											Super:
										)
										name:
									)
									((local50 at: (local50 indexOf: local28))
										view:
									)
									((local50 at: (local50 indexOf: local28))
										loop:
									)
									((local50 at: (local50 indexOf: local28))
										cel:
									)
									((local50 at: (local50 indexOf: local28))
										x:
									)
									((local50 at: (local50 indexOf: local28))
										y:
									)
									((local50 at: (local50 indexOf: local28))
										z:
									)
									((local50 at: (local50 indexOf: local28))
										heading:
									)
									((local50 at: (local50 indexOf: local28))
										priority:
									)
									((local50 at: (local50 indexOf: local28))
										signal:
									)
									(temp13 data:)
								)
								(temp13 dispose:)
							)
							((OneOf (event message:) KEY_c KEY_C KEY_n KEY_N)
								(cond
									((not (local28 lastCel:))
										(= local9 1)
										(tmpDlg
											display:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local28 view:)
												(local28 loop:)
										)
									)
									((== (local28 cel:) (local28 lastCel:))
										(local28 cel: 0)
									)
									(else
										(= temp1 (+ (local28 cel:) 1))
										(local28 cel: temp1)
									)
								)
								(= local30 1)
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
								(= local28
									(local50
										at:
											(switch (event message:)
												(KEY_0 0)
												(KEY_1 1)
												(KEY_2 2)
												(KEY_3 3)
												(KEY_4 4)
												(KEY_5 5)
												(KEY_6 6)
												(KEY_7 7)
												(KEY_8 8)
												(KEY_9 9)
											)
									)
								)
								(= local23 (local28 cel:))
								(if (< (local28 view:) 16)
									(localproc_1)
								)
								(local28 cel: local23 show:)
								(= local30 1)
							)
						)
					)
				)
			)
			((== (event type:) evMOUSEBUTTON)
				(if (== local9 5)
					(= local9 0)
				)
				(cond
					((== local2 2)
						(cueScript dispose:)
						(localproc_11 local44 local42 local43 gEgo local8)
					)
					(local6
						(localproc_0)
						(localproc_10
							local44
							(+ (event x:) local42)
							(+ (event y:) local43)
						)
					)
					(
						(and
							(act9 onMeCheck:)
							(RobotFeature onMe: (event x:) (event y:))
						)
						(RobotFeature setNowSeen:)
						(event claimed: 1)
						(= temp8 (- (event x:) local42))
						(= temp9 (- (event y:) local43))
						(while
							(!=
								((= temp10 ((gUser curEvent:) new:)) type:)
								2
							)
							(temp10 localize: (gCurRoom plane:))
							(RobotFeature setNowSeen:)
							(Robot
								1 ; DisplayFrame
								local41
								(= local42 (- (temp10 x:) temp8))
								(= local43 (- (temp10 y:) temp9))
							)
							(temp10 dispose:)
							(localproc_7)
							(FrameOut)
						)
						(temp10 dispose:)
						(localproc_7)
						(FrameOut)
					)
					((& (event modifiers:) $000b) ; emALT | emSHIFT
						(if (= local27 (local50 firstTrue: #onMe event))
							(if (!= (= local28 local27) palView)
								(= local24 (local28 loop:))
								(= local23 (local28 cel:))
								(localproc_1)
								(local28 cel: local23 setLoop: local24 1 show:)
								(if (> (local28 view:) 15)
									(local28 setCycle: 0)
								)
								(UpdateScreenItem local28)
								(FrameOut)
								(= temp13
									(Str format: {curActor: %s} (local28 name:))
								)
							)
						else
							(= local27 0)
						)
						(= local30 1)
					)
					(else
						(local28 x: local31 y: local32)
						(= local29 1)
						(= local30 1)
					)
				)
			)
			((== (event type:) evMOUSERELEASE)
				(= local29 0)
				(if (and (!= local28 palView) (local28 scaler:))
					((local28 scaler:) doit:)
				)
			)
			(else
				(gGame handleEvent: event)
			)
		)
		(event claimed: 1)
	)

	(method (cue)
		(if local6
			(localproc_10 local44 local42 local43)
		else
			(gTesterSound pause: 0)
		)
	)

	(method (dispose)
		(if local52
			(local52 dispose:)
			(= local52 0)
		)
		(if (not local0)
			(localproc_1)
			(gDirectionHandler delete: self)
			(gKeyDownHandler delete: self)
			(gEgo z: 0)
		)
		(= gTesterSound 0)
		(super dispose: &rest)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Prints
					{The Elite Tester V1.0\nAlt-o: Polygon Editor\nAlt-i: Turn OFF Interface\nm: Toggle Mover\nAlt-s: Set Scaler\ns: Manual-toggle Scaler\nAlt-t: Teleport\np: Picture\nP: Toggle Planes\n=: Toggle picture\nAlt-p: Toggle Palette\nv: View\nAlt-v: Volume\n}
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
					{ o: Open robot\nf: Advance robot frame\nr: Retreat robot frame\nDELETE: Delete robot frame\nctrl-c: Tag robot frame for cue\nalt-r: Play robot\nt: Terminate robot\nctrl-i: Show robot info\nd: Display single robot frame.\n}
				)
				(self dispose:)
			)
		)
	)
)

(instance act0 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act1 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act2 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act3 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act4 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act5 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act6 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act7 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act8 of Actor
	(properties
		x 160
		y 100
		view 1
		signal 26657
	)
)

(instance act9 of Actor
	(properties
		x 160
		y 100
		view 1
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

(instance testCursor of Cursor ; UNUSED
	(properties
		view 9960
	)
)

(instance textTimer of Timer
	(properties)

	(method (cue)
		(= local9 0)
		(= local30 1)
	)
)

(class RobotFeature of Feature
	(properties)

	(method (setNowSeen &tmp temp0)
		(= temp0 (IntArray new: 4))
		(Robot 2 (temp0 data:)) ; FrameInfo
		(= nsLeft (temp0 at: 0))
		(= nsTop (temp0 at: 1))
		(= nsRight (temp0 at: 2))
		(= nsBottom (temp0 at: 3))
		(temp0 dispose:)
		(if (>= (= local41 (Robot 11)) local40) ; FrameNum
			(= local41 (- local40 1))
		)
		(= local30 1)
	)
)

(instance tmpDlg of MonitorDlg
	(properties
		x 50
		y 355
		fore 255
		font 0
		width 550
	)

	(method (init param1)
		(self setPri: 500)
		(super init: param1 { })
	)

	(method (draw &tmp temp0)
		(if (gTimers contains: textTimer)
			(textTimer dispose: delete:)
		)
		(super draw: &rest)
		(if
			(>
				(= temp0
					(+
						(GetTime)
						(* (/ (* 24 (KString 8 (tmpDlg text:))) 10) gTextSpeed) ; StrLen
					)
				)
				360
			)
			(= temp0 360)
		)
		(if (< temp0 240)
			(= temp0 240)
		)
		(if (not (OneOf local9 0 6))
			(textTimer setTicks: textTimer temp0)
			(= local9 5)
		)
	)

	(method (setText &tmp temp0)
		(if (not text)
			(= text (KArray 8 (KArray 9 { }))) ; ArrayDup, ArrayGetData
		)
		(KString 10 text &rest) ; StrFormatAt
	)
)

(instance cueScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local1 (Str with: {cue at: }))
				(localproc_10 local44 local42 local43 gEgo local8 1)
			)
			(1
				(if (gEgo robot:)
					(++ register)
					(= temp0 (Str format: {%d } (Robot 11))) ; FrameNum
					(local1 cat: temp0)
					(= local9 6)
					(localproc_8 (local1 data:))
					(temp0 dispose:)
					(-- state)
				else
					(= temp0 (Str with: {robot done }))
					(if register
						(temp0 cat: local1)
					)
					(= local9 2)
					(localproc_8 (temp0 data:))
					(local1 dispose:)
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
		(localproc_0)
		(Robot 7) ; Terminate
		(act9 onMeCheck: 0)
		(= local30 1)
		(= local6 0)
		(= local2 0)
		(= local40 0)
		(= local41 0)
		(= local9 0)
		(super dispose: &rest)
	)
)

(instance testVMDMovie of VMDMovie
	(properties
		waitEvents 7
		showCursor 1
	)
)

(instance testerSound of Sound
	(properties)
)

