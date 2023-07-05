;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
(include sci.sh)
(use Main)
(use SQRoom)
(use ego_20)
(use Interface)
(use DText)
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
(use System)

(public
	rm411 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4
	local5
	local6
	local7 = 100
	local8
	local9
	local10
	local11
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
	[local26 2]
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
)

(procedure (localproc_0)
	(local21 setLoop: 0 1 setLooper: 0 setCycle: 0)
	(FrameOut)
)

(procedure (localproc_1 &tmp temp0)
	(if (not local9)
		(return)
	)
	(while (local9 size:)
		(DeleteLine (= temp0 (local9 at: 0)) (gCast plane:))
		(local9 delete: temp0)
	)
	(= local9 0)
	(FrameOut)
)

(procedure (localproc_2 param1) ; UNUSED
	(= local6 2)
	(localproc_9 {actor's scaler now 0})
	(localproc_1)
	(param1 setScaler: 0 setScale: 0)
	(UpdateScreenItem param1)
)

(procedure (localproc_3 param1 &tmp [temp0 6]) ; UNUSED
	(if local9
		(localproc_1)
	)
	(= local9 (Set new:))
	(SetNowSeen param1)
	(local9
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
	(local9
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
	(local9
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
	(local9
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
		(local3
			(localproc_12)
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
		(act0 view: 900 normalize: 2 setLoop: 0 1 setCycle: 0 init:)
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
	(= local21 (gCast at: 0))
	(if (local21 scaler:)
		((local21 scaler:) doit:)
	)
	(= local23 1)
)

(procedure (localproc_5)
	(if (gTimers contains: textTimer)
		(textTimer dispose: delete:)
	)
	(if (and argc local11)
		(local11 dispose:)
	)
	(if (tmpDlg text:)
		(tmpDlg dispose: text: 0)
	)
	(= local11 0)
)

(procedure (localproc_6 param1 &tmp temp0)
	(local34 at: local29 param1)
)

(procedure (localproc_7) ; UNUSED
	(= local6 2)
	(localproc_9 {Scaler tool})
	(gEgo
		view: (local21 view:)
		x: (local21 x:)
		y: (local21 y:)
		z: 0
		setLoop: (local21 loop:)
		cel: (local21 cel:)
		init:
	)
	(local21 x: 1000 y: 1000)
	(UpdateScreenItem local21)
	((ScriptID 35 0) doit:) ; scalerCode
	(local21
		x: (gEgo x:)
		y: (gEgo y:)
		setScaler:
			Scaler
			((gEgo scaler:) frontSize:)
			((gEgo scaler:) backSize:)
			((gEgo scaler:) frontY:)
			((gEgo scaler:) backY:)
	)
	(gEgo z: 1000)
)

(procedure (localproc_8)
	(if (not local1)
		(return 0)
	else
		(if (and (== local2 1) (not local3) (act9 onMeCheck:))
			(if local4
				(local15
					format:
						{(PAUSED) robot: %hu frame: %d of %d x: %d y: %d W: %d H: %d pri: %d pic: %hu}
						local32
						local29
						local28
						local30
						local31
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local5
						(gCurRoom picture:)
				)
			else
				(local15
					format:
						{robot: %hu frame: %d of %d xOffSet: %d yOffSet: %d W: %d H: %d pri: %d pic: %hu}
						local32
						local29
						local28
						local30
						local31
						(- (RobotFeature nsRight:) (RobotFeature nsLeft:))
						(- (RobotFeature nsBottom:) (RobotFeature nsTop:))
						local5
						(gCurRoom picture:)
				)
			)
		else
			(local15
				format:
					{%s: view: %hu loop: %d cel: %d x:%d y:%d pri: %d pic: %hu\n}
					(local21 name:)
					(local21 view:)
					(local21 loop:)
					(local21 cel:)
					(local21 x:)
					(local21 y:)
					(local21 priority:)
					(gCurRoom picture:)
			)
		)
		(if (local15 data:)
			(localproc_9 (local15 data:))
		)
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3)
	(if (not local1)
		(return 0)
	else
		(localproc_5 0)
		(= local11 (Str format: &rest))
		(= temp2 (local11 size:))
		(switch local6
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
			((== local6 2)
				(= temp0 (- 145 temp2))
			)
			((OneOf local6 1 3 4)
				(= temp0 (- 135 (/ temp2 2)))
			)
			((or local4 (act9 onMeCheck:))
				(= temp0 20)
			)
			(else
				(= temp0 (- 90 (/ temp2 2)))
			)
		)
		(if (> (= temp1 (+ (GetTime) (* (/ (* 24 temp2) 10) gTextSpeed))) 360)
			(= temp1 360)
		)
		(if (< temp1 240)
			(= temp1 240)
		)
		(if (!= local6 0)
			(textTimer setTicks: textTimer temp1)
			(= local6 5)
		)
	)
)

(procedure (localproc_10 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp0 (GetNumber {Scaler fs:}))
	(= temp1 (GetNumber {Scaler bs:}))
	(= temp2 (GetNumber {Scaler fy:}))
	(= temp3 (GetNumber {Scaler by:}))
	(local21 setScaler: Scaler temp0 temp1 temp2 temp3)
)

(procedure (localproc_11 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2)
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
	(WalkieTalkie
		doRobot:
			param1
			temp1
			temp2
			(if (not (> argc 7)) self else 0)
			(if (> argc 3) param4 else gEgo)
			(if (> argc 4) param5 else -1)
			(if (> argc 5) param6 else 0)
	)
)

(procedure (localproc_12 param1 param2 &tmp temp0 temp1 temp2)
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
	(WalkieTalkie killRobot: temp1 temp2)
)

(instance rm411 of SQRoom
	(properties)

	(method (init)
		(localproc_12)
		(gThePlane picture: -1)
		(UpdatePlane gThePlane)
		(FrameOut)
		(localproc_4 -1)
		(super init: &rest)
		(= local14 0)
		(gGSound1 number: 0 stop:)
		(gGSound2 number: 0 stop:)
		(gDirectionHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(= local15 (Str new:))
		(gGame setCursor: testCursor)
		(gEgo z: 1000 init:)
	)

	(method (newRoom newRoomNumber)
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
				(not local3)
				(act9 onMeCheck:)
				(or
					(and (< local29 (- local28 1)) (!= local29 (Robot 11))) ; FrameNum
					((gUser curEvent:) type:)
					(!= local24 gMouseX)
					(!= local25 gMouseY)
				)
			)
			(RobotFeature setNowSeen:)
		)
		(= local24 gMouseX)
		(= local25 gMouseY)
		(if
			(and
				(!= local6 5)
				(or
					local23
					(!= local16 (local21 cel:))
					(!= local18 (local21 x:))
					(!= local19 (local21 y:))
				)
			)
			(localproc_8)
			(= local18 (local21 x:))
			(= local19 (local21 y:))
			(= local16 (local21 cel:))
			(= local23 0)
		)
		(if local22
			(local21 x: local24 y: local25)
			(if (not (local21 fixPriority:))
				(local21 priority: local25)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(event localize: (gCast plane:))
		(cond
			((event claimed:))
			((& (event type:) $0010) ; direction
				(if (== local6 5)
					(= local6 0)
					(localproc_5 0)
				)
				(if (and (not local3) (act9 onMeCheck:))
					(event claimed: 1)
					(switch (event message:)
						(JOY_LEFT
							(Robot 1 local29 (-- local30) local31 -1 local5) ; DisplayFrame
						)
						(JOY_RIGHT
							(Robot 1 local29 (++ local30) local31 -1 local5) ; DisplayFrame
						)
						(JOY_UP
							(Robot 1 local29 local30 (-- local31) -1 local5) ; DisplayFrame
						)
						(JOY_DOWN
							(Robot 1 local29 local30 (++ local31) -1 local5) ; DisplayFrame
						)
						(else
							(event claimed: 0)
						)
					)
					(localproc_8)
				else
					(switch (event message:)
						(JOY_LEFT
							(= temp3 (- (local21 x:) 1))
							(= temp4 (local21 y:))
						)
						(JOY_RIGHT
							(= temp3 (+ (local21 x:) 1))
							(= temp4 (local21 y:))
						)
						(JOY_UP
							(= temp3 (local21 x:))
							(= temp4 (- (local21 y:) 1))
						)
						(JOY_DOWN
							(= temp3 (local21 x:))
							(= temp4 (+ (local21 y:) 1))
						)
					)
					(local21 x: temp3 y: temp4)
				)
			)
			((== (event type:) evKEYBOARD)
				(if (== local6 5)
					(= local6 0)
					(localproc_5 0)
				)
				(event claimed: 1)
				(switch (event message:)
					(KEY_DIVIDE
						(= temp0 (GetNumber {Intensity: }))
						(gGame setIntensity: temp0)
					)
					($007c ; |
						(-- local7)
						(gGame setIntensity: local7)
						(= local23 1)
					)
					(KEY_F10
						(if (and (not local3) (act9 onMeCheck:))
							(Robot 1 (= local29 0) local30 local31 local5) ; DisplayFrame
							(= local23 1)
						)
					)
					(KEY_F9
						(if (< (= temp0 (GetNumber {Priority #?})) 0)
							(= local6 2)
							(localproc_9 {priority released})
							(local21 setPri: -1)
						else
							(local21 priority: temp0 fixPriority: 1)
						)
						(= local23 1)
					)
					(KEY_SPACE
						(cond
							((and (not local3) (not (act9 onMeCheck:))))
							((not local4)
								(= local4 1)
								(Robot 10) ; Pause
							)
							(else
								(= local4 0)
								(Robot 4) ; Play
							)
						)
						(= local23 1)
					)
					(else
						(cond
							((== (event message:) KEY_QUESTION)
								(gCurRoom setScript: helpScript)
							)
							((OneOf (event message:) KEY_1 KEY_ALT_b)
								(if (act9 onMeCheck:)
									(if (> local29 0)
										(-- local29)
									)
									(if (not (local33 at: local29))
										(Robot 1 local29 local30 local31 local5) ; DisplayFrame
									)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_2 KEY_ALT_f)
								(if
									(and
										(act9 onMeCheck:)
										(< local29 (- local28 1))
									)
									(RobotFeature setNowSeen:)
									(++ local29)
									(if (not (local33 at: local29))
										(Robot 1 local29 local30 local31 local5) ; DisplayFrame
									)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_3 KEY_ALT_i)
								(if (and (not local3) (act9 onMeCheck:))
									(Printf
										{%hu.rbt\nframe %d of %d\nxOffSet: %d, yOffSet: %d\nwidth: %d, height: %d }
										local32
										local29
										local28
										local30
										local31
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
							((OneOf (event message:) KEY_4 KEY_ALT_k)
								(cond
									(local3
										(= local3 0)
										(= local6 2)
										(localproc_12)
									)
									((act9 onMeCheck:)
										(= local3 0)
										(Robot 7) ; Terminate
										(act9 onMeCheck: 0)
										(= local23 1)
									)
								)
							)
							((OneOf (event message:) KEY_5 KEY_ALT_o)
								(if local3
									(= local3 0)
									(localproc_12)
								)
								(= local32 (GetNumber {file number} local32))
								(if (act9 onMeCheck:)
									(Robot 7) ; Terminate
									(act9 onMeCheck: 0)
								)
								(if (!= local32 -1)
									(= local5 (GetNumber {priority} -1))
									(= local30 (GetNumber {x offset} local30))
									(= local31 (GetNumber {y offset} local31))
									(Robot
										0 ; Open
										local32
										gThePlane
										local5
										local30
										local31
									)
									(Robot
										1 ; DisplayFrame
										(= local29 0)
										local30
										local31
										local5
									)
									(= temp0 (IntArray new: 4))
									(= local35
										(= local28 (Robot 2 (temp0 data:))) ; FrameInfo
									)
									(temp0 dispose:)
									(act9 onMeCheck: RobotFeature)
									(if local34
										(local34 dispose:)
										(= local34 0)
									)
									(if local33
										(local33 dispose:)
										(= local33 0)
									)
									((= local34 (IntArray new: local28)) init:)
									((= local33 (IntArray new: local28)) init:)
									(= local4 0)
									(= local0 local32)
								else
									(= local6 4)
									(local15
										format:
											{ERROR: can't find %hu.rbt}
											local32
									)
									(localproc_9 (local15 data:))
									(if local0
										(= local32 local0)
									)
								)
							)
							((OneOf (event message:) KEY_e KEY_E KEY_6 KEY_ALT_p)
								(cond
									((act9 onMeCheck:)
										(= local4 0)
										(RobotFeature setNowSeen:)
										(if
											(OneOf
												local29
												local28
												(- local28 1)
											)
											(Robot
												0 ; Open
												local32
												gThePlane
												local5
												local30
												local31
											)
											(Robot
												1 ; DisplayFrame
												(= local29 0)
												local30
												local31
												local5
											)
										)
										(Robot 4) ; Play
									)
									((not (local21 lastCel:))
										(= local6 1)
										(local15
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local21 view:)
												(local21 loop:)
										)
										(localproc_9 (local15 data:))
									)
									((== (local21 cel:) (local21 lastCel:))
										(local21 cel: 0 setCycle: End)
									)
									(else
										(local21 setCycle: End)
									)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_7 KEY_ALT_s)
								(if (not local3)
									(if
										(!=
											(= local32
												(GetNumber {Robot number: })
											)
											-1
										)
										(= temp0 (GetNumber {Cel number: }))
										(= temp5 (GetNumber {x: }))
										(= temp6 (GetNumber {y: }))
										(WalkieTalkie
											showFrame: local32 temp0 temp5 temp6
										)
										(act9 onMeCheck: RobotFeature)
										(RobotFeature setNowSeen:)
									else
										(= local6 4)
										(local15
											format:
												{ERROR: can't find %hu.rbt}
												local32
										)
										(localproc_9 (local15 data:))
									)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_8 KEY_ALT_t)
								(if (not (act9 onMeCheck:))
									(event claimed: 0)
								else
									(= temp11 (GetNumber {Cue value?}))
									(localproc_6 temp11)
								)
							)
							((OneOf (event message:) KEY_p KEY_P)
								(if
									(!=
										(= local37
											(GetNumber {Pic #?} local37)
										)
										-1
									)
									(= local13 (gCurRoom picture:))
									(gCurRoom picture: local37 drawPic: local37)
									(= local23 1)
								else
									(= local6 4)
									(local15
										format:
											{ERROR: picture: %hu not found.}
											local37
									)
									(localproc_9 (local15 data:))
									(= local37 (gCurRoom picture:))
								)
							)
							((OneOf (event message:) KEY_m KEY_M)
								(if (myTmpMusic number:)
									(myTmpMusic stop:)
								)
								(if
									(!=
										(= local38
											(GetNumber {Sound: #?} local38)
										)
										-1
									)
									(myTmpMusic number: local38 play:)
								)
							)
							((OneOf (event message:) KEY_n KEY_N)
								(gCurRoom setScript: fadeTheSound)
							)
							((OneOf (event message:) KEY_v KEY_V)
								(if (!= (= local14 (GetNumber {View #?})) -1)
									(if (ResCheck rsVIEW local14)
										(local21 show: cel: 0 view: local14)
										(if (or (< local14 0) (> local14 15))
											(localproc_0)
											(local21 setLoop: 0 1 setCycle: 0)
										)
										(UpdateScreenItem local21)
										(= local23 1)
									else
										(= local6 4)
										(localproc_9
											{View %hu not found.}
											local14
										)
									)
								)
							)
							((OneOf (event message:) KEY_b KEY_B)
								(cond
									((not (local21 lastCel:))
										(= local6 1)
										(local15
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local21 view:)
												(local21 loop:)
										)
										(localproc_9 (local15 data:))
									)
									((not (local21 cel:))
										(local21
											cel: (local21 lastCel:)
											setCycle: Beg
										)
									)
									(else
										(local21 setCycle: Beg)
									)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_f KEY_F)
								(cond
									((act9 onMeCheck:))
									((not (local21 lastCel:))
										(= local6 1)
										(local15
											format:
												{ERROR: view: %hu loop %d only has 1 cel!}
												(local21 view:)
												(local21 loop:)
										)
										(localproc_9 (local15 data:))
									)
									(else
										(local21 setCycle: Fwd)
									)
								)
							)
							((OneOf (event message:) KEY_l KEY_L)
								(= temp0 -1)
								(cond
									((not (local21 lastLoop:))
										(= local6 3)
										(local15
											format:
												{ERROR: view %hu only has 1 loop!}
												(local21 view:)
										)
										(localproc_9 (local15 data:))
									)
									((== (local21 loop:) (local21 lastLoop:))
										(= temp0 0)
									)
									((!= (local21 loop:) (local21 lastLoop:))
										(= temp0 (+ (local21 loop:) 1))
									)
									(else
										(= temp0 (local21 lastLoop:))
									)
								)
								(if (!= temp0 -1)
									(localproc_0)
									(local21 setLoop: temp0 1)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_h KEY_H)
								(if (& (local21 signal:) $0008)
									(local21 show:)
								else
									(local21 hide:)
								)
								(FrameOut)
								(= local23 1)
							)
							((OneOf (event message:) KEY_k KEY_K)
								(if (local21 looper:)
									(= local6 2)
									(localproc_9 {curActor's looper turned off})
									(localproc_0)
								else
									(= local6 2)
									(localproc_9 {reset curActor})
									(localproc_0)
								)
								(= local23 1)
							)
							((OneOf (event message:) KEY_i KEY_I)
								(= temp13 (Str new:))
								(temp13 format: {%s} {none})
								(Printf
									{name: %s\nclass: %s\nview: %hu\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaler: %s\n}
									((gCast at: (gCast indexOf: local21))
										name:
									)
									(((gCast at: (gCast indexOf: local21))
											-super-:
										)
										name:
									)
									((gCast at: (gCast indexOf: local21))
										view:
									)
									((gCast at: (gCast indexOf: local21))
										loop:
									)
									((gCast at: (gCast indexOf: local21))
										cel:
									)
									((gCast at: (gCast indexOf: local21))
										x:
									)
									((gCast at: (gCast indexOf: local21))
										y:
									)
									((gCast at: (gCast indexOf: local21))
										z:
									)
									((gCast at: (gCast indexOf: local21))
										heading:
									)
									((gCast at: (gCast indexOf: local21))
										priority:
									)
									((gCast at: (gCast indexOf: local21))
										signal:
									)
									(temp13 data:)
								)
								(temp13 dispose:)
							)
							((== (event message:) KEY_SUBTRACT)
								(= temp1 (local21 cel:))
								(if (> (-- temp1) -1)
									(local21 cel: temp1)
								else
									(= temp1 (local21 lastCel:))
									(local21 cel: temp1)
								)
								(= local23 1)
							)
							((== (event message:) $003d) ; =
								(if (== (local21 cel:) (local21 lastCel:))
									(local21 cel: 0)
								else
									(= temp1 (+ (local21 cel:) 1))
									(local21 cel: temp1)
								)
								(= local23 1)
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
								(= local21
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
								(= local16 (local21 cel:))
								(if (< (local21 view:) 16)
									(localproc_0)
								)
								(local21 cel: local16 show:)
								(= local23 1)
							)
						)
					)
				)
			)
			((== (event type:) evMOUSEBUTTON)
				(if (== local6 5)
					(= local6 0)
					(localproc_5 0)
				)
				(cond
					(local3
						(localproc_12)
						(localproc_11
							local32
							(+ (event x:) local30)
							(+ (event y:) local31)
						)
					)
					(
						(and
							(act9 onMeCheck:)
							(RobotFeature onMe: (event x:) (event y:))
						)
						(RobotFeature setNowSeen:)
						(event claimed: 1)
						(= temp8 (- (event x:) local30))
						(= temp9 (- (event y:) local31))
						(while
							(!=
								((= temp10 ((gUser curEvent:) new:)) type:)
								2
							)
							(temp10 localize: (gCurRoom plane:))
							(RobotFeature setNowSeen:)
							(Robot
								1 ; DisplayFrame
								local29
								(= local30 (- (temp10 x:) temp8))
								(= local31 (- (temp10 y:) temp9))
								local5
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
						(if (= local20 (gCast firstTrue: #onMe event))
							(= local21 local20)
							(= local17 (local21 loop:))
							(= local16 (local21 cel:))
							(localproc_0)
							(local21 cel: local16 setLoop: local17 1 show:)
							(if (> (local21 view:) 15)
								(local21 setCycle: 0)
							)
							(UpdateScreenItem local21)
							(FrameOut)
							(= temp13
								(Str format: {curActor: %s} (local21 name:))
							)
						else
							(= local20 0)
						)
						(= local23 1)
					)
					(else
						(local21 x: local24 y: local25)
						(= local22 1)
						(= local23 1)
					)
				)
			)
			((== (event type:) evMOUSERELEASE)
				(= local22 0)
				(if (local21 scaler:)
					((local21 scaler:) doit:)
				)
			)
			(else
				(gGame handleEvent: event)
			)
		)
		(event claimed: 1)
	)

	(method (cue)
		(if local3
			(localproc_11 local32 local30 local31)
		else
			(sfx pause: 0)
		)
	)

	(method (dispose)
		(myTmpMusic dispose:)
		(super dispose: &rest)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Prints
					{ (1) Alt-B           Retreat robot frame\n(2) Alt-F           Advance robot frame\n(3) Alt-I           Show robot info\n(4) Alt-K           Kill robot\n(5) Alt-O           Open robot\n(6) Alt-P           Play robot\n(7) Alt-T           Tag robot frame for cue\n(8) Alt-S           Single robot frame.\nSPACEBAR        Pause robot\n}
				)
				(= cycles 2)
			)
			(1
				(Prints
					{ F:              Forward\nB:              BegLoop\nE:              EndLoop\n\n+:              Next cel\n-:              Previous Cel\n\nV:              View\nL:              Loop\nH:              Hide-show actor\nI:              Actor Information\nK:              Normalize Actor\n\nM:              Test Sound\nN:              Fade an active sound\nP:              Picture\n\nF9:             Set priority\n0-9:            Choose actor\n}
				)
				(self dispose:)
			)
		)
	)
)

(instance act0 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act1 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act2 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act3 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance myTmpMusic of Sound
	(properties)
)

(instance act4 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act5 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act6 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act7 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act8 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance act9 of ego
	(properties
		x 160
		y 100
		view 0
		signal 26657
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance sfx2 of Sound ; UNUSED
	(properties
		flags 5
	)
)

(instance _411_dat of File ; UNUSED
	(properties
		name {411.dat}
	)
)

(instance testCursor of Cursor
	(properties
		view 953
	)
)

(instance textTimer of Timer
	(properties)

	(method (cue)
		(= local6 0)
		(= local23 1)
		(localproc_5 0)
	)
)

(instance changeFile of File ; UNUSED
	(properties)

	(method (open &tmp temp0)
		(= temp0 (Str format: {%d.alt} local32))
		(self name: (KString 8 (temp0 data:))) ; StrDup
		(temp0 dispose:)
		(super open: &rest)
	)

	(method (write param1)
		(if (not handle)
			(self open:)
		)
		(if handle
			(FileIO fiWRITE handle param1)
		)
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
		(if (>= (= local29 (Robot 11)) local28) ; FrameNum
			(= local29 (- local28 1))
		)
		(= local23 1)
	)
)

(instance tmpDlg of DText
	(properties)
)

(instance fadeTheSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (myTmpMusic number:)
					(myTmpMusic fade: self)
				else
					(= cycles 10)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

