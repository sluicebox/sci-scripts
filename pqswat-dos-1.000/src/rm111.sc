;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Interface)
(use DText)
(use Str)
(use Array)
(use Print)
(use Scaler)
(use Feature)
(use Cursor)
(use Timer)
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
	local4
	local5 = 1
	local6 = 1
	local7
	local8
	local9
	local10
	local11 = 100
	local12
	local13
	local14
	local15
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
	local33
	[local34 6]
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
)

(procedure (localproc_0)
	(local29 setLoop: 0 1 setLooper: 0 setCycle: 0)
	(FrameOut)
)

(procedure (localproc_1 &tmp temp0)
	(if (not local13)
		(return)
	)
	(while (local13 size:)
		(DeleteLine (= temp0 (local13 at: 0)) (gCast plane:))
		(local13 delete: temp0)
	)
	(= local13 0)
	(FrameOut)
)

(procedure (localproc_2 param1)
	(= local10 2)
	(localproc_9 {actor's scaler now 0})
	(localproc_1)
	(param1 setScaler: 0 setScale: 0)
	(UpdateScreenItem param1)
)

(procedure (localproc_3 param1 &tmp [temp0 6]) ; UNUSED
	(if local13
		(localproc_1)
	)
	(= local13 (Set new:))
	(SetNowSeen param1)
	(local13
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
	(local13
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
	(local13
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
	(local13
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

(procedure (localproc_4 param1)
	(cond
		(local7
			(proc4_5)
		)
		((act9 onMeCheck:)
			(Robot 7) ; Terminate
			(act9 onMeCheck: 0)
		)
	)
	(if argc
		(gCurRoom picture: param1)
	)
	(if (not (gCast contains: act0))
		(act0 view: 2 setLoop: 0 1 setCycle: 0 init:)
		(act1 init: hide:)
		(act2 init: hide:)
		(act3 init: hide:)
		(act4 init: hide:)
		(act5 init: hide:)
		(act6 init: hide:)
		(act7 init: hide:)
		(act8 init: hide:)
		(act9 init: hide:)
	)
	(if (and (!= (= local29 (gCast at: 0)) palView) (local29 scaler:))
		((local29 scaler:) doit:)
	)
	(= local31 1)
)

(procedure (localproc_5)
	(if (gTimers contains: textTimer)
		(textTimer dispose: delete:)
	)
	(if (and argc local15)
		(local15 dispose:)
	)
	(if (tmpDlg text:)
		(tmpDlg dispose: text: 0)
	)
	(= local15 0)
)

(procedure (localproc_6 param1 param2 &tmp temp0 temp1)
	(= temp0 (Str newWith: 80 {}))
	(if (> argc 1)
		(temp0 format: {%d} param2)
	)
	(= temp1
		(if (GetInput temp0 6 param1)
			(temp0 asInteger:)
		else
			-1
		)
	)
	(temp0 dispose:)
	(return temp1)
)

(procedure (localproc_7)
	(= local10 2)
	(localproc_9 {Scaler tool})
	(gEgo
		view: (local29 view:)
		x: (local29 x:)
		y: (local29 y:)
		z: 0
		setLoop: (local29 loop:)
		cel: (local29 cel:)
		init:
	)
	(local29 x: 1000 y: 1000)
	(UpdateScreenItem local29)
	((ScriptID 14 0) doit:) ; scalerCode
	(= local18 ((gEgo scaler:) frontSize:))
	(= local19 ((gEgo scaler:) backSize:))
	(= local20 ((gEgo scaler:) frontY:))
	(= local21 ((gEgo scaler:) backY:))
	(local29
		x: (gEgo x:)
		y: (gEgo y:)
		setScaler: Scaler local18 local19 local20 local21
	)
	(gEgo z: 1000)
)

(procedure (localproc_8)
	(if (not local5)
		(return 0)
	else
		(if (and (== local6 1) (not local7) (act9 onMeCheck:))
			(if local8
				(local23
					format:
						{(PAUSED) robot: %hu frame: %d of %d x: %d y: %d W: %d H: %d pri: %d pic: %hu}
						local45
						local42
						local41
						local43
						local44
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local9
						(gCurRoom picture:)
				)
			else
				(local23
					format:
						{robot: %hu frame: %d of %d xOffSet: %d yOffSet: %d W: %d H: %d pri: %d pic: %hu}
						local45
						local42
						local41
						local43
						local44
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local9
						(gCurRoom picture:)
				)
			)
		else
			(local23
				format:
					{%s: view: %hu loop: %d cel: %d x:%d y:%d pri: %d pic: %hu\n}
					(local29 name:)
					(local29 view:)
					(local29 loop:)
					(local29 cel:)
					(local29 x:)
					(local29 y:)
					(local29 priority:)
					(gCurRoom picture:)
			)
		)
		(if (local23 data:)
			(localproc_9 (local23 data:))
		)
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3)
	(if (not local5)
		(return 0)
	else
		(localproc_5 0)
		(= local15 (Str format: &rest))
		(= temp2 (local15 size:))
		(switch local10
			(6
				(= temp3 1)
			)
			(2
				(= temp3 1)
			)
			(0
				(= temp3 254)
			)
			(else
				(= temp3 43)
			)
		)
		(cond
			((OneOf local10 6 2)
				(= temp0 (- 145 temp2))
			)
			((OneOf local10 1 3 4)
				(= temp0 (- 135 (/ temp2 2)))
			)
			((or local8 (act9 onMeCheck:))
				(= temp0 20)
			)
			(else
				(= temp0 (- 90 (/ temp2 2)))
			)
		)
		(tmpDlg
			font: 999
			text: (KString 8 (local15 data:)) ; StrDup
			fore: (if (== temp3 1) 43 else 1)
			back: temp3
			setPri: 255
			setSize: 600
			x: temp0
			y: 1
			init: gInterfaceCast
		)
		(if (> (= temp1 (+ (GetTime) (* (/ (* 24 temp2) 10) gTextSpeed))) 360)
			(= temp1 360)
		)
		(if (< temp1 240)
			(= temp1 240)
		)
		(if (not (OneOf local10 0 6))
			(textTimer setTicks: textTimer temp1)
			(= local10 5)
		)
	)
)

(procedure (localproc_10 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (localproc_6 {Scaler fs:}))
	(= temp1 (localproc_6 {Scaler bs:}))
	(= temp2 (localproc_6 {Scaler fy:}))
	(= temp3 (localproc_6 {Scaler by:}))
	(local29 setScaler: Scaler temp0 temp1 temp2 temp3)
)

(procedure (localproc_11 param1 param2 param3 param4 param5 &tmp temp0)
	(Robot 0 param1 gThePlane param5 param2 param3) ; Open
	(= local42 0)
	(Robot 1 0 param2 param3) ; DisplayFrame
	(= temp0 (IntArray new: 4))
	(= local48 (= local41 (Robot 2 (temp0 data:)))) ; FrameInfo
	(temp0 dispose:)
	(act9 onMeCheck: RobotFeature)
	(if local47
		(local47 dispose:)
		(= local47 0)
	)
	(if local46
		(local46 dispose:)
		(= local46 0)
	)
	((= local47 (IntArray new: local41)) init:)
	((= local46 (IntArray new: local41)) init:)
	(= local8 0)
	(= local4 local45)
)

(procedure (localproc_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp7 (DText new:))
	(if (temp7 text:)
		(temp7 dispose: 1 text: 0)
		(UpdatePlane gThePlane)
		(FrameOut)
	)
	(if param1
		((= temp2 (Str new: 500)) copy: param1)
		(= temp4 (temp2 size:))
		(= temp5 (Max (- 140 (/ temp4 2)) 15))
		(= temp6 (Min (- 130 (/ temp4 8)) 118))
		(if (not (temp7 fore:))
			(= temp0 24)
		else
			(= temp0 0)
		)
		(if (not (temp7 back:))
			(= temp1 24)
		else
			(= temp1 0)
		)
		(temp7
			font: 999
			fore: temp0
			back: temp1
			priority: 333
			fixPriority: 1
			x: 40
			y: 17
			text: (KString 8 (temp2 data:)) ; StrDup
			setSize: 200
			plane: gThePlane
			init: gInventoryCast
		)
		(= temp3 (Min (* 2 temp4) 360))
		(= temp3 (Max temp3 180))
		(temp2 dispose:)
	)
)

(procedure (localproc_13 param1 param2 &tmp temp0)
	(if (= temp0 (/ param1 10))
		(localproc_13 temp0 param2)
	)
	(param2 at: local51 (+ (mod param1 10) 48))
	(++ local51)
)

(procedure (localproc_14 param1 param2 &tmp temp0 temp1 temp2)
	(if (< param1 0)
		(= param1 (- 0 param1))
		(param2 at: 0 45)
		(= local51 1)
	else
		(= local51 0)
	)
	(if (= temp1 (/ param1 10))
		(localproc_13 temp1 param2)
	)
	(param2 at: local51 (+ (mod param1 10) 48))
	(++ local51)
	(param2 at: local51 0)
)

(procedure (localproc_15 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (Str new: 400 {}))
	(= temp1 (Str new: 20 {}))
	(= temp2 (Str new: 20 {}))
	(= temp3 (GetNumber {Font: } (Print font:)))
	(temp1 copy: {.fon})
	(localproc_14 temp3 temp0)
	(temp0 cat: temp1)
	(= temp4 (temp0 asInteger:))
	(temp1 format: {})
	(if (ResCheck rsFONT temp4)
		(temp0 format: {Font: %d} temp3)
		(while temp3
			(Print
				font: temp3
				addText: temp0 10 0
				addEdit: temp1 20 10 26
				addEdit: temp2 20 10 40
				posn: 10 120
				init:
			)
			(temp0
				format:
					{%s\n%s\nThe quick brown fox, jumped over the lazy dog!?\n'Oh look -- a chasm.' said the author.\n; ABCDEFGHIJKLMNOPQRSTUVWXYZ\nabcdefghijklmnopqrstuvwxyz\n'1234567890 -=\\~@#$%^&*() +\n}
					(temp1 data:)
					(temp2 data:)
			)
			(Print font: temp3 addText: temp0 init:)
			(= temp3 0)
		)
	else
		(Prints {That is not a valid font.})
	)
	(temp0 dispose:)
	(temp1 dispose:)
	(temp2 dispose:)
)

(instance rm111 of PQRoom
	(properties)

	(method (init)
		(proc4_5)
		(gThePlane picture: -1)
		(UpdatePlane gThePlane)
		(FrameOut)
		(localproc_4 210)
		(super init: &rest)
		(= local22 0)
		(gDirectionHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(= local23 (Str new:))
		(gGame handsOn:)
		(gEgo view: 0 z: 1000 init:)
	)

	(method (doVerb))

	(method (newRoom newRoomNumber)
		(= local1 1)
		(localproc_0)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(localproc_5 0)
		(gEgo z: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp [temp0 3])
		(if
			(and
				(not local7)
				(act9 onMeCheck:)
				(or
					(and (< local42 (- local41 1)) (!= local42 (Robot 11))) ; FrameNum
					((gUser curEvent:) type:)
					(!= local32 gMouseX)
					(!= local33 gMouseY)
				)
			)
			(RobotFeature setNowSeen:)
		)
		(= local32 gMouseX)
		(= local33 gMouseY)
		(if
			(and
				(not (OneOf local10 6 5))
				(or
					local31
					(!= local24 (local29 cel:))
					(!= local26 (local29 x:))
					(!= local27 (local29 y:))
				)
			)
			(localproc_8)
			(= local26 (local29 x:))
			(= local27 (local29 y:))
			(= local24 (local29 cel:))
			(= local31 0)
		)
		(if local30
			(if (!= local29 palView)
				(local29 mover:)
			)
			(local29 x: local32 y: local33)
			(if (not (local29 fixPriority:))
				(local29 priority: local33)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 3] temp8 temp9 temp10 temp11 temp12 temp13 [temp14 3])
		(event localize: (gCast plane:))
		(cond
			((event claimed:))
			((& (event type:) $0010) ; direction
				(if (== local10 5)
					(= local10 0)
					(localproc_5 0)
				)
				(if (and (not local7) (act9 onMeCheck:))
					(event claimed: 1)
					(switch (event message:)
						(JOY_LEFT
							(-- local43)
						)
						(JOY_RIGHT
							(++ local43)
						)
						(JOY_UP
							(-- local44)
						)
						(JOY_DOWN
							(++ local44)
						)
						(JOY_UPRIGHT
							(++ local43)
							(-- local44)
						)
						(JOY_DOWNRIGHT
							(++ local44)
							(++ local43)
						)
						(JOY_DOWNLEFT
							(++ local44)
							(-- local43)
						)
						(JOY_UPLEFT
							(-- local44)
							(-- local43)
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
						(Robot 1 local42 local43 local44) ; DisplayFrame
					)
					(localproc_8)
				else
					(= temp3 (local29 x:))
					(= temp4 (local29 y:))
					(switch (event message:)
						(JOY_LEFT
							(= temp3 (- (local29 x:) 1))
							(= temp4 (local29 y:))
						)
						(JOY_RIGHT
							(= temp3 (+ (local29 x:) 1))
							(= temp4 (local29 y:))
						)
						(JOY_UP
							(= temp3 (local29 x:))
							(= temp4 (- (local29 y:) 1))
						)
						(JOY_DOWN
							(= temp3 (local29 x:))
							(= temp4 (+ (local29 y:) 1))
						)
						(JOY_UPRIGHT
							(= temp4 (- (local29 y:) 1))
							(= temp3 (+ (local29 x:) 1))
						)
						(JOY_DOWNRIGHT
							(= temp4 (+ (local29 y:) 1))
							(= temp3 (+ (local29 x:) 1))
						)
						(JOY_DOWNLEFT
							(= temp4 (+ (local29 y:) 1))
							(= temp3 (- (local29 x:) 1))
						)
						(JOY_UPLEFT
							(= temp4 (- (local29 y:) 1))
							(= temp3 (- (local29 x:) 1))
						)
					)
					(local29 x: temp3 y: temp4)
				)
			)
			((== (event type:) evKEYBOARD)
				(if (== local3 2)
					(cueScript dispose:)
					(localproc_11 local45 local43 local44 gEgo local9)
				)
				(if (== local10 5)
					(= local10 0)
					(localproc_5 0)
				)
				(event claimed: 1)
				(switch (event message:)
					(KEY_DELETE
						(if (not (act9 onMeCheck:))
							(event claimed: 0)
						else
							(= local10 2)
							(localproc_9 {funtion replaced by avirobot})
						)
					)
					(KEY_DIVIDE
						(= temp0 (localproc_6 {Intensity: }))
						(gGame setIntensity: temp0)
					)
					($007c ; |
						(-- local11)
						(gGame setIntensity: local11)
						(= local31 1)
					)
					(KEY_ADD
						(++ local11)
						(gGame setIntensity: local11)
						(= local31 1)
					)
					($003d ; =
						(if local17
							(= temp0 (gCurRoom picture:))
							(gCurRoom drawPic: local17 picture: local17)
							(= local17 temp0)
						else
							(= local17 (gCurRoom picture:))
							(gCurRoom drawPic: -1 picture: -1)
						)
					)
					(KEY_F10
						(if (and (not local7) (act9 onMeCheck:))
							(= local42 0)
							(Robot 1 0 local43 local44) ; DisplayFrame
							(= local31 1)
						)
					)
					(KEY_SPACE
						(cond
							((and (not local7) (not (act9 onMeCheck:))))
							((not local8)
								(= local8 1)
								(Robot 10) ; Pause
							)
							(else
								(= local8 0)
								(Robot 4) ; Play
							)
						)
						(= local31 1)
					)
					(KEY_ESCAPE
						(if local40
							(= local40 0)
							(palView dispose:)
						)
					)
					(KEY_F9
						(if (< (= temp0 (localproc_6 {Priority #?})) 0)
							(= local10 2)
							(localproc_9 {priority released})
							(local29 setPri: -1)
						else
							(local29 priority: temp0 fixPriority: 1)
						)
						(= local31 1)
					)
					(else
						(cond
							((OneOf (event message:) JOY_DOWNRIGHT JOY_DOWNRIGHT)
								(= temp0 (local29 view:))
								(= local10 2)
								(localproc_9 {actors view unloaded from memory})
								(local29 view: 2)
								(localproc_0)
								(UnLoad 128 temp0)
								(Purge 16000)
							)
							((OneOf (event message:) $000f $000f)
								(if (gCurRoom obstacles:)
									(= local10 2)
									(localproc_9 {removing room's obstacles})
									((gCurRoom obstacles:) dispose:)
									(gCurRoom obstacles: 0)
								)
							)
							((OneOf (event message:) KEY_TAB KEY_TAB)
								(if (and (not local7) (act9 onMeCheck:))
									(Printf
										{%hu.rbt\nframe %d of %d\nxOffSet: %d, yOffSet: %d\nwidth: %d, height: %d }
										local45
										local42
										local41
										local43
										local44
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
								((ScriptID 3 0) handleEvent: event) ; debugHandler
							)
							(
								(and
									(OneOf (event message:) KEY_ALT_i KEY_ALT_i)
									local5
								)
								(localproc_5 0)
								(= local5 0)
								(FrameOut)
								((gCast plane:)
									setRect: 0 0 319 199
									drawPic: -1
								)
								(UpdatePlane (gCast plane:))
								(FrameOut)
							)
							((OneOf (event message:) JOY_RIGHT JOY_RIGHT)
								(if (act9 onMeCheck:)
									(switch local3
										(0
											(= local10 2)
											(localproc_9
												{position robot then press ctrl-c again}
											)
											(= local3 1)
										)
										(1
											(Robot 7) ; Terminate
											(act9 onMeCheck: 0)
											(= local10 2)
											(= local7 1)
											(localproc_9
												{checking for robot cues}
											)
											(= local3 2)
											(gCurRoom setScript: cueScript 0 0)
										)
									)
								else
									(= local10 2)
									(localproc_9 {open robot first})
								)
							)
							((OneOf (event message:) JOY_DOWN JOY_DOWN)
								(= temp0 (localproc_6 {Intensity:}))
								(gEgo setIntensity: temp0 0)
							)
							((OneOf (event message:) KEY_T KEY_t)
								(cond
									((or local3 local7)
										(= local7 0)
										(= local10 2)
										(= local3 0)
										(localproc_9 {turned off robot looping})
										(proc4_5)
									)
									((act9 onMeCheck:)
										(= local7 0)
										(Robot 7) ; Terminate
										(Printf {robot terminated})
										(act9 onMeCheck: 0)
										(= local31 1)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_v KEY_ALT_v)
								(= temp13 (Str new:))
								(Print
									font: gUserFont
									addTitle: {input vmd movie FILE name}
									addEdit: temp13 12 1 5
									init:
								)
								(if (ResCheck 151 (temp13 asInteger:)) ; VMD
									(PlayVMD 0 (temp13 data:)) ; Open
									(PlayVMD 1 174 95) ; Put
									(PlayVMD 21 0 0 639 359) ; Black
									(PlayVMD 14 3 7) ; WaitEvent
									(PlayVMD 6) ; Close
									(temp13 dispose:)
									(UpdatePlane (gCast plane:))
									(FrameOut)
								else
									(Prints {Error: VMD not found.})
								)
							)
							((OneOf (event message:) KEY_s KEY_S)
								(if (local29 scaler:)
									(local29 setScale: 0)
								else
									(localproc_10)
								)
							)
							((OneOf (event message:) KEY_ALT_s KEY_ALT_s)
								(cond
									((!= local29 palView)
										(= temp13 (Str new:))
										(if (local29 scaler:)
											(temp13
												format:
													{Current scaler: %d %d %d %d\nEnter choice or pic no.\n}
													((local29 scaler:)
														frontSize:
													)
													((local29 scaler:)
														backSize:
													)
													((local29 scaler:) frontY:)
													((local29 scaler:) backY:)
											)
										else
											(temp13
												format:
													{Current scaler: none\nEnter choice:\n}
											)
										)
										(switch
											(Print
												font: 999
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
												(localproc_2 local29)
											)
											(2
												(localproc_7)
											)
											(3
												(localproc_10)
											)
										)
										(temp13 dispose:)
										(if (local29 scaler:)
											(= local18
												((local29 scaler:) frontSize:)
											)
											(= local19
												((local29 scaler:) backSize:)
											)
											(= local20
												((local29 scaler:) frontY:)
											)
											(= local21
												((local29 scaler:) backY:)
											)
										)
									)
									((local29 scaler:)
										(localproc_2 local29)
									)
									(else
										(localproc_7)
									)
								)
								(= local31 1)
							)
							((OneOf (event message:) KEY_ALT_w KEY_ALT_w)
								((ScriptID 64948 0) doit:) ; MISSING SCRIPT
							)
							((OneOf (event message:) KEY_ALT_t KEY_ALT_t)
								(if
									(ResCheck
										rsSCRIPT
										(= temp0 (localproc_6 {Teleport to:}))
									)
									(cond
										(local7
											(proc4_5)
										)
										((act9 onMeCheck:)
											(Robot 7) ; Terminate
											(act9 onMeCheck: 0)
										)
									)
									(gCurRoom newRoom: temp0)
								else
									(= local10 4)
									(local23
										format:
											{ERROR: script %hu not found}
											temp0
									)
									(localproc_9 (local23 data:))
								)
							)
							((OneOf (event message:) KEY_p KEY_P)
								(if
									(and
										(!=
											(= local50
												(localproc_6 {Pic #?} local50)
											)
											-1
										)
										(ResCheck rsPIC local50)
									)
									(= local17 (gCurRoom picture:))
									(gCurRoom picture: local50 drawPic: local50)
									(= local31 1)
								else
									(= local10 4)
									(local23
										format:
											{ERROR: picture: %hu not found.}
											local50
									)
									(localproc_9 (local23 data:))
									(= local50 (gCurRoom picture:))
								)
							)
							((OneOf (event message:) KEY_ALT_p KEY_ALT_p)
								(cond
									((not (ResCheck rsVIEW (palView view:)))
										(Printf
											{ERROR: can't find view 1111.v56!}
										)
									)
									((not local40)
										(= local40 1)
										(palView init: setPri: 200)
									)
									(else
										(= local40 0)
										(palView dispose:)
									)
								)
							)
							((OneOf (event message:) KEY_v KEY_V)
								(if (!= (= local22 (localproc_6 {View #?})) -1)
									(if (ResCheck rsVIEW local22)
										(local29 show: cel: 0 view: local22)
										(if (or (< local22 0) (> local22 15))
											(localproc_0)
											(local29 setLoop: 0 1 setCycle: 0)
										)
										(UpdateScreenItem local29)
										(= local31 1)
									else
										(= local10 4)
										(localproc_9
											{View %hu not found.}
											local22
										)
									)
								)
							)
							((OneOf (event message:) KEY_b KEY_B)
								(cond
									((or (== local29 palView) (local29 mover:)))
									((not (local29 lastCel:))
										(= local10 1)
										(local23
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local29 view:)
												(local29 loop:)
										)
										(localproc_9 (local23 data:))
									)
									((not (local29 cel:))
										(local29
											cel: (local29 lastCel:)
											setCycle: Beg
										)
									)
									(else
										(local29 setCycle: Beg)
									)
								)
								(= local31 1)
							)
							((OneOf (event message:) JOY_DOWNLEFT JOY_DOWNLEFT)
								(cond
									((act9 onMeCheck:))
									((not (local29 lastCel:))
										(= local10 1)
										(local23
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local29 view:)
												(local29 loop:)
										)
										(localproc_9 (local23 data:))
									)
									(else
										(local29 setCycle: Fwd)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_l KEY_ALT_l)
								(cond
									((and (not local7) (not (act9 onMeCheck:))))
									(local7
										(= local10 2)
										(localproc_9 {turned off robot looping})
										(= local7 0)
										(proc4_5)
									)
									(else
										(Robot 7) ; Terminate
										(act9 onMeCheck: 0)
										(= local10 2)
										(= local7 1)
										(localproc_9 {robot looping})
										(proc4_6 local45 local43 local44)
										(FrameOut)
									)
								)
							)
							((OneOf (event message:) KEY_l KEY_L)
								(= temp0 -1)
								(cond
									((not (local29 lastLoop:))
										(= local10 3)
										(local23
											format:
												{ERROR: view %hu only has 1 loop!}
												(local29 view:)
										)
										(localproc_9 (local23 data:))
									)
									((== (local29 loop:) (local29 lastLoop:))
										(= temp0 0)
									)
									((!= (local29 loop:) (local29 lastLoop:))
										(= temp0 (+ (local29 loop:) 1))
									)
									(else
										(= temp0 (local29 lastLoop:))
									)
								)
								(if (!= temp0 -1)
									(localproc_0)
									(local29 setLoop: temp0 1)
								)
								(= local31 1)
							)
							((OneOf (event message:) KEY_h KEY_H)
								(if (& (local29 signal:) $0008)
									(local29 show:)
								else
									(local29 hide:)
								)
								(FrameOut)
								(= local31 1)
							)
							((OneOf (event message:) KEY_k KEY_K)
								(cond
									((== local29 palView))
									((local29 looper:)
										(= local10 2)
										(localproc_9
											{curActor's looper turned off}
										)
										(localproc_0)
									)
									(else
										(= local10 2)
										(localproc_9 {reset curActor})
										(localproc_0)
									)
								)
								(= local31 1)
							)
							((OneOf (event message:) KEY_PAUSE KEY_PAUSE)
								(= temp0 (localproc_6 {Sound# ?}))
								(if
									(and
										(not (ResCheck rsAUDIO temp0))
										(not (ResCheck rsAUDIO temp0))
										(not (ResCheck rsSOUND temp0))
									)
									(= local10 4)
									(local23
										format: {Sound %hu not found.} temp0
									)
									(localproc_9 (local23 data:))
								else
									(gFxSound
										number: temp0
										setLoop: (localproc_6 {loop?} 1)
										play:
									)
								)
							)
							((OneOf (event message:) KEY_SHIFT KEY_SHIFT)
								(gFxSound play:)
							)
							((OneOf (event message:) KEY_O KEY_o)
								(if local7
									(= local7 0)
									(proc4_5)
								)
								(= local45 (localproc_6 {file number} local45))
								(if (act9 onMeCheck:)
									(Robot 7) ; Terminate
									(act9 onMeCheck: 0)
								)
								(if (and (!= local45 -1) (ResCheck 150 local45)) ; ROBOT
									(= local9 (localproc_6 {priority} -1))
									(= local43 (localproc_6 {x offset} local43))
									(= local44 (localproc_6 {y offset} local44))
									(localproc_11
										local45
										local43
										local44
										gEgo
										local9
									)
								else
									(= local10 4)
									(local23
										format:
											{ERROR: can't find %hu.rbt}
											local45
									)
									(localproc_9 (local23 data:))
									(if local4
										(= local45 local4)
									)
								)
							)
							((OneOf (event message:) KEY_MENU KEY_MENU)
								(localproc_4)
							)
							((OneOf (event message:) KEY_w KEY_W)
								(if (== local6 1)
									(= local6 2)
								else
									(= local6 1)
								)
								(= local31 1)
							)
							((OneOf (event message:) KEY_f KEY_F)
								(if
									(and
										(act9 onMeCheck:)
										(< local42 (- local41 1))
									)
									(RobotFeature setNowSeen:)
									(++ local42)
									(if (not (local46 at: local42))
										(Robot 1 local42 local43 local44) ; DisplayFrame
									)
								)
								(= local31 1)
							)
							((OneOf (event message:) KEY_r KEY_R)
								(if (act9 onMeCheck:)
									(if (> local42 0)
										(-- local42)
									)
									(if (not (local46 at: local42))
										(Robot 1 local42 local43 local44) ; DisplayFrame
									)
								)
								(= local31 1)
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
										width: 360
										font: 999
										fore: 19
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
							((OneOf (event message:) KEY_e KEY_E)
								(cond
									((or (== local29 palView) (local29 mover:)))
									((not (local29 lastCel:))
										(= local10 1)
										(local23
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local29 view:)
												(local29 loop:)
										)
										(localproc_9 (local23 data:))
									)
									((== (local29 cel:) (local29 lastCel:))
										(local29 cel: 0 setCycle: End)
									)
									(else
										(local29 setCycle: End)
									)
								)
							)
							((OneOf (event message:) KEY_ALT_r KEY_ALT_r)
								(if (act9 onMeCheck:)
									(= local8 0)
									(= local7 0)
									(RobotFeature setNowSeen:)
									(if
										(OneOf
											local42
											0
											local41
											(- local41 1)
										)
										(Robot
											0 ; Open
											local45
											gThePlane
											local9
											local43
											local44
										)
										(= local42 0)
										(Robot 1 0 local43 local44) ; DisplayFrame
									)
									(Robot 4) ; Play
								)
								(= local31 1)
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
								(= temp1 (local29 cel:))
								(if (> (-- temp1) -1)
									(local29 cel: temp1)
								else
									(= temp1 (local29 lastCel:))
									(local29 cel: temp1)
								)
								(= local31 1)
							)
							((OneOf (event message:) KEY_i KEY_I KEY_ALT_e KEY_ALT_e)
								(= temp13 (Str new:))
								(if (local29 scaler:)
									(temp13
										format:
											{%s %d %d %d %d}
											((local29 scaler:) name:)
											((local29 scaler:) frontSize:)
											((local29 scaler:) backSize:)
											((local29 scaler:) frontY:)
											((local29 scaler:) backY:)
									)
								else
									(temp13 format: {%s} {none})
								)
								(Printf
									{name: %s\nclass: %s\nview: %hu\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaler: %s\n}
									((gCast at: (gCast indexOf: local29))
										name:
									)
									(((gCast at: (gCast indexOf: local29))
											-super-:
										)
										name:
									)
									((gCast at: (gCast indexOf: local29))
										view:
									)
									((gCast at: (gCast indexOf: local29))
										loop:
									)
									((gCast at: (gCast indexOf: local29))
										cel:
									)
									((gCast at: (gCast indexOf: local29))
										x:
									)
									((gCast at: (gCast indexOf: local29))
										y:
									)
									((gCast at: (gCast indexOf: local29))
										z:
									)
									((gCast at: (gCast indexOf: local29))
										heading:
									)
									((gCast at: (gCast indexOf: local29))
										priority:
									)
									((gCast at: (gCast indexOf: local29))
										signal:
									)
									(temp13 data:)
								)
								(temp13 dispose:)
							)
							((OneOf (event message:) KEY_c KEY_C KEY_n KEY_N)
								(cond
									((not (local29 lastCel:))
										(= local10 1)
										(local23
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local29 view:)
												(local29 loop:)
										)
										(localproc_9 (local23 data:))
									)
									((== (local29 cel:) (local29 lastCel:))
										(local29 cel: 0)
									)
									(else
										(= temp1 (+ (local29 cel:) 1))
										(local29 cel: temp1)
									)
								)
								(= local31 1)
							)
							((== (event message:) KEY_F2)
								(localproc_15)
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
								(= local29
									(gCast
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
								(= local24 (local29 cel:))
								(if (< (local29 view:) 16)
									(localproc_0)
								)
								(local29 cel: local24 show:)
								(= local31 1)
							)
						)
					)
				)
			)
			((== (event type:) evMOUSEBUTTON)
				(if (== local10 5)
					(= local10 0)
					(localproc_5 0)
				)
				(cond
					((== local3 2)
						(cueScript dispose:)
						(localproc_11 local45 local43 local44 gEgo local9)
					)
					(local7
						(proc4_5)
						(proc4_6
							local45
							(+ (event x:) local43)
							(+ (event y:) local44)
						)
					)
					(
						(and
							(act9 onMeCheck:)
							(RobotFeature onMe: (event x:) (event y:))
						)
						(RobotFeature setNowSeen:)
						(event claimed: 1)
						(= temp8 (- (event x:) local43))
						(= temp9 (- (event y:) local44))
						(while
							(!=
								((= temp10 ((gUser curEvent:) new:)) type:)
								2
							)
							(temp10 localize: (gCurRoom plane:))
							(RobotFeature setNowSeen:)
							(Robot
								1 ; DisplayFrame
								local42
								(= local43 (- (temp10 x:) temp8))
								(= local44 (- (temp10 y:) temp9))
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
						(if (= local28 (gCast firstTrue: #onMe event))
							(if (!= (= local29 local28) palView)
								(= local25 (local29 loop:))
								(= local24 (local29 cel:))
								(localproc_0)
								(local29 cel: local24 setLoop: local25 1 show:)
								(if (> (local29 view:) 15)
									(local29 setCycle: 0)
								)
								(UpdateScreenItem local29)
								(FrameOut)
								(= temp13
									(Str format: {curActor: %s} (local29 name:))
								)
								(localproc_12 (temp13 data:))
							)
						else
							(= local28 0)
						)
						(= local31 1)
					)
					(else
						(local29 x: local32 y: local33)
						(= local30 1)
						(= local31 1)
					)
				)
			)
			((== (event type:) evMOUSERELEASE)
				(= local30 0)
				(if (and (!= local29 palView) (local29 scaler:))
					((local29 scaler:) doit:)
				)
			)
			(else
				(gGame handleEvent: event)
			)
		)
		(event claimed: 1)
	)

	(method (cue)
		(if local7
			(proc4_6 local45 local43 local44)
		else
			(gFxSound pause: 0)
		)
	)

	(method (dispose)
		(if (not local1)
			(localproc_0)
			(gDirectionHandler delete: self)
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
			(localproc_5 0)
			(gEgo z: 0)
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
					{The Elite Tester V1.0\nAlt-o: Polygon Editor\nAlt-i: Turn OFF Interface\nm: Toggle Mover\nAlt-s: Set Scaler\ns: Manual-toggle Scaler\nAlt-t: Teleport\np: Picture\n=: Toggle picture\nAlt-p: Toggle Palette\nv: View\nAlt-v: Volume\nF2: Test Font\n}
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
		view 0
		signal 26657
	)
)

(instance act1 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act2 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act3 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act4 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act5 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act6 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act7 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act8 of Actor
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act9 of Actor
	(properties
		x 160
		y 100
		view 0
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
		view 999
	)
)

(instance textTimer of Timer
	(properties)

	(method (cue)
		(= local10 0)
		(= local31 1)
		(localproc_5 0)
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
		(if (>= (= local42 (Robot 11)) local41) ; FrameNum
			(= local42 (- local41 1))
		)
		(= local31 1)
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
				(= local2 (Str with: {cue at: }))
				(proc4_6 local45 local43 local44 0 gEgo local9 1)
			)
			(1
				(if (gEgo robot:)
					(++ register)
					(= temp0 (Str format: {%d } (Robot 11))) ; FrameNum
					(local2 cat: temp0)
					(= local10 6)
					(localproc_9 (local2 data:))
					(temp0 dispose:)
					(-- state)
				else
					(= temp0 (Str with: {robot done }))
					(if register
						(temp0 cat: local2)
					)
					(= local10 2)
					(localproc_9 (temp0 data:))
					(local2 dispose:)
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
		(proc4_5)
		(Robot 7) ; Terminate
		(act9 onMeCheck: 0)
		(= local31 1)
		(= local7 0)
		(= local3 0)
		(= local41 0)
		(= local42 0)
		(= local10 0)
		(localproc_5 0)
		(super dispose: &rest)
	)
)

