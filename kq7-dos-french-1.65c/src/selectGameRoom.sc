;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use ExitButton)
(use n021)
(use TransPlane)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use File)
(use Game)
(use Actor)
(use System)

(public
	selectGameRoom 0
)

(local
	[local0 5] = [22 42 62 82 102]
	[local5 10]
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 (View new:))
	(temp0 view: 971 loop: 0 cel: 0 x: 70 y: 47 setPri: 500 init:)
	(while 1
		(= temp1 ((gUser curEvent:) new:))
		(if (== (temp1 type:) 1)
			(break)
		)
		(FrameOut)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp6 30)
	(gNormalCursor cel: 0 init:)
	(= temp1 gCast)
	(= temp0 (Plane new:))
	(temp0
		bitmap: 0
		picture: -2
		setRect: 0 0 319 199
		priority: 2500
		init:
		addCast: (= gCast (Cast new:))
	)
	((View new:) view: 972 loop: 0 cel: 0 x: 165 y: 82 init: setPri: 1000)
	(= temp2 (View new:))
	(temp2 view: 972 loop: 1 cel: 0 x: 130 y: 80 init: setPri: 0)
	(UpdateScreenItem temp2)
	(= temp3 (View new:))
	(temp3 view: 972 loop: 1 cel: 1 x: 204 y: 80 init: setPri: 0)
	(UpdateScreenItem temp3)
	(= temp5 0)
	(while 1
		(= temp4 ((gUser curEvent:) new:))
		(cond
			(
				(and
					(<= (temp2 nsLeft:) (temp4 x:) (temp2 nsRight:))
					(<= (temp2 nsTop:) (temp4 y:) (temp2 nsBottom:))
				)
				(if (< (-- temp6) 0)
					(= temp6 30)
					(if (> (++ temp5) 4)
						(= temp5 0)
					)
					(SetCursor 999 0 temp5)
				)
				(if (== (temp4 type:) 1)
					(while 1
						(= temp4 ((gUser curEvent:) new:))
						(if
							(and
								(<= (temp2 nsLeft:) (temp4 x:) (temp2 nsRight:))
								(<= (temp2 nsTop:) (temp4 y:) (temp2 nsBottom:))
							)
							(temp2 setPri: 1500)
							(UpdateScreenItem temp2)
						else
							(temp2 setPri: 0)
							(UpdateScreenItem temp2)
						)
						(if (== (temp4 type:) 2)
							(temp2 z: 1000)
							(if (<= (temp2 nsLeft:) (temp4 x:) (temp2 nsRight:))
								(if
									(<=
										(temp2 nsTop:)
										(temp4 y:)
										(temp2 nsBottom:)
									)
									(temp0 dispose:)
									(= gCast temp1)
									(return 1)
								else
									(break)
								)
							else
								(break)
							)
						)
						(FrameOut)
					)
				)
			)
			(
				(and
					(<= (temp3 nsLeft:) (temp4 x:) (temp3 nsRight:))
					(<= (temp3 nsTop:) (temp4 y:) (temp3 nsBottom:))
				)
				(if (< (-- temp6) 0)
					(= temp6 30)
					(if (> (++ temp5) 4)
						(= temp5 0)
					)
					(SetCursor 999 0 temp5)
				)
				(if (== (temp4 type:) 1)
					(while 1
						(= temp4 ((gUser curEvent:) new:))
						(if
							(and
								(<= (temp3 nsLeft:) (temp4 x:) (temp3 nsRight:))
								(<= (temp3 nsTop:) (temp4 y:) (temp3 nsBottom:))
							)
							(temp3 setPri: 1500)
							(UpdateScreenItem temp3)
						else
							(temp3 setPri: 0)
							(UpdateScreenItem temp3)
						)
						(if (== (temp4 type:) 2)
							(temp3 z: 1000)
							(if (<= (temp3 nsLeft:) (temp4 x:) (temp3 nsRight:))
								(if
									(<=
										(temp3 nsTop:)
										(temp4 y:)
										(temp3 nsBottom:)
									)
									(temp0 dispose:)
									(= gCast temp1)
									(return 0)
								else
									(break)
								)
							else
								(break)
							)
						)
						(FrameOut)
					)
				)
			)
			(temp5
				(= temp5 0)
				(SetCursor 999 0 0)
			)
		)
		(FrameOut)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(Str format: {%s%s} gCurSaveDir param1)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp6 0)
	(= temp1 (Str newWith: 50 {}))
	(= temp2 (Str newWith: 40 {}))
	(= temp3 (Str newWith: 40 {}))
	([local5 local17] eraseName:)
	(= local18
		(localproc_2
			(temp1 format: {%s%3.3d} param1 ([local5 local17] fileNumber:))
		)
	)
	((= temp4 (File new:)) name: (local18 data:) delete: dispose:)
	(if (!= local15 1)
		((= temp4 (File new:)) name: (local19 data:) open: 1)
		((= temp5 (File new:)) name: (local20 data:) open: 1)
		(temp4 read: temp1 2)
		(while (!= (proc0_3 temp1 0) -1)
			(temp4 read: temp2 36)
			(if (!= (= temp7 (proc0_3 temp1 0)) ([local5 local17] fileNumber:))
				(= temp6 (Max temp7 temp6))
				(temp5 write: temp1 2 write: temp2 36)
			)
			(temp4 read: temp1 2)
		)
		(temp4 delete: dispose:)
		(proc0_2 temp1 0 -1)
		(-- local15)
		(temp1 at: 2 temp6)
		(temp5 write: temp1 3 dispose:)
		(FileIO fiRENAME (local20 data:) (local19 data:))
	else
		((= temp4 (File new:)) name: (local19 data:) delete: dispose:)
		(-- local15)
	)
	([local5 local17] dispose:)
	(local18 dispose:)
	(= local18 0)
	(temp1 dispose:)
	(temp2 dispose:)
	(temp3 dispose:)
	(if (and (< local17 local15) local15)
		(for ((= temp0 local17)) (< temp0 local15) ((++ temp0))
			(= [local5 temp0] [local5 (+ temp0 1)])
			([local5 temp0] value: temp0)
		)
	)
	(= [local5 local15] 0)
	(if (!= local15 0)
		(= local17 (- local15 1))
	else
		(iconPlay enable: 0)
		(selectGameControls delete: iconDelete)
		(iconDelete dispose:)
		(= local15 -1)
		(= local17 -1)
		(gCurRoom newRoom: 30)
	)
	(= global305 (proc21_0))
)

(class SelectGameRoom of Room
	(properties
		picture 970
		style 14
		exitStyle 0
	)

	(method (init &tmp [temp0 2] temp2 temp3 [temp4 4])
		(= local21 global124)
		(= global124 (Cast new:))
		(= temp2 (Str newWith: 40))
		(= temp3 (IntArray newWith: 4))
		(gThePlane setRect: 0 0 319 199)
		(super init: &rest)
		(RemapColors 2 244 60) ; ByPercent
		(gUser canInput: 1)
		(gGame setCursor: gNormalCursor)
		(if (IsFlag 3)
			(localproc_0)
			(selectGameControls add: iconDelete iconCancel eachElementDo: #init)
			(iconCancel x: (iconDelete x:) y: (+ (iconDelete y:) 21))
		else
			(selectGameControls
				add: iconPlay iconDelete iconCancel
				eachElementDo: #init
			)
		)
		(= local19 (localproc_2 {kq7cdsg.cat}))
		(= local20 (localproc_2 {temp.tmp}))
		(self readSaveDir:)
		(if (< local15 1)
			(iconPlay enable: 0)
		)
		(temp2 dispose:)
		(temp3 dispose:)
	)

	(method (dispose)
		(tPlane dispose:)
		(local19 dispose:)
		(local20 dispose:)
		(if local18
			(local18 dispose:)
		)
		(selectGameControls dispose:)
		(global124 dispose:)
		(= global124 local21)
		(super dispose: &rest)
	)

	(method (readSaveDir &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 (Str newWith: 40 {}))
		(= temp3 (IntArray newWith: 4))
		(if (FileIO fiEXISTS (local19 data:))
			((= temp0 (File new:)) name: (local19 data:) open: 1)
			(= local15 0)
			(temp0 read: temp2 2)
			(while (!= (temp2 at: 0) -1)
				(++ local15)
				(= temp4 (temp2 at: 0))
				(temp0 read: temp2 36)
				((= [local5 (- local15 1)] (SkeletonIcon new:))
					view: 980
					setLoop: 3 1
					setCel: 0
					value: (- local15 1)
					fileNumber: temp4
					x: (if (< (- local15 1) 5) 31 else 150)
					y: [local0 (mod (- local15 1) 5)]
					init:
				)
				(TextSize (temp3 data:) (temp2 data:) 30 0)
				((= local22 (DText new:))
					font: 960
					text: (KString 8 (temp2 data:)) ; StrDup
					fore: 0
					back: 254
					skip: 254
					x: (+ ([local5 (- local15 1)] x:) 25)
					y: (+ ([local5 (- local15 1)] y:) 6)
					setSize:
					setPri: 10
					init:
				)
				([local5 (- local15 1)] fileName: local22)
				(temp0 read: temp2 2)
			)
			(temp0 read: temp2 1 dispose:)
			(= temp5 (temp2 at: 0))
			(for ((= temp1 0)) (< temp1 local15) ((++ temp1))
				(if (== ([local5 temp1] fileNumber:) temp5)
					(= local17 ([local5 temp1] value:))
					(break)
				)
			)
			([local5 local17] select:)
		else
			(Prints {Cat file not Found. Game internal Error!})
		)
		(temp2 dispose:)
		(temp3 dispose:)
	)
)

(instance selectGameRoom of SelectGameRoom
	(properties)
)

(instance sDeleteIcon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(localproc_3 {kq7cdsg.})
				(= ticks 60)
			)
			(2
				(iconDelete setCycle: 0 setCel: 0 enable:)
				(if (!= local17 -1)
					([local5 local17] select:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance selectGameControls of Set
	(properties)
)

(class SelectScaryIcon of Prop
	(properties
		hiliteState 0
		enabled 1
	)

	(method (init)
		(self setPri: 15 ignoreActors: 1 setHotspot: 8 10) ; Do, Exit
		(super init: &rest)
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
			(if hiliteState
				(self setCycle: 0 hiliteState: 0)
			)
			(self setCel: 1)
		else
			(= enabled 1)
			(self setCel: 0)
		)
	)
)

(class SkeletonIcon of Actor
	(properties
		yStep 4
		xStep 6
		moveSpeed 0
		value 0
		fileNumber 0
		hiliteState 0
		enabled 1
		selected 0
		fileName 0
	)

	(method (eraseName)
		(if fileName
			(fileName dispose:)
			(= fileName 0)
		)
	)

	(method (init)
		(self setPri: 15 ignoreActors: 1 setHotspot: 8 10) ; Do, Exit
		(super init: &rest)
	)

	(method (doVerb)
		(self select:)
	)

	(method (select param1)
		(if (and argc (not param1))
			(self setCel: 0)
			(return)
		else
			([local5 local17] select: 0)
			(self setCel: 1 selected: 1)
			(= local17 value)
			(tPlane
				top: y
				left: (+ x 20)
				right: (+ x 80)
				bottom: (+ y 14)
				priority: 500
			)
			(if (not (gPlanes contains: tPlane))
				(tPlane init:)
			)
			(tPlane setSize:)
			(UpdatePlane tPlane)
		)
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
			(if hiliteState
				(self setCycle: 0 hiliteState: 0)
			)
		else
			(= enabled 1)
		)
	)

	(method (dispose)
		(self eraseName:)
		(super dispose: &rest)
	)
)

(instance iconPlay of SelectScaryIcon
	(properties
		x 12
		y 139
		view 980
	)

	(method (doVerb &tmp [temp0 3] temp3 temp4 temp5 temp6)
		(= temp3 0)
		(while (!= ((= temp4 (Event new:)) type:) evMOUSERELEASE)
			(cond
				((self onMe: temp4)
					(if (not temp3)
						(= cel (= temp3 1))
						(UpdateScreenItem self)
						(FrameOut)
					)
				)
				(temp3
					(= cel (= temp3 0))
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			(temp4 dispose:)
		)
		(if (self onMe: temp4)
			(gGame handsOff:)
			(= cel (= temp3 0))
			(UpdateScreenItem self)
			(FrameOut)
			(temp4 dispose:)
			((ScriptID 16 1) hide:) ; scroller
			(gInventory eachElementDo: #hide)
			(if enabled
				(= temp5 ([local5 local17] fileNumber:))
				(for ((= temp6 0)) (< temp6 10) ((++ temp6))
					(if [local5 temp6]
						([local5 temp6] dispose:)
						(= [local5 temp6] 0)
					)
				)
				(gGame smallRestore: temp5)
			)
		)
	)
)

(instance tPlane of TransPlane
	(properties)
)

(instance iconQuit of SelectScaryIcon ; UNUSED
	(properties
		x 159
		y 171
		view 980
	)

	(method (doVerb &tmp temp0 temp1)
		(= temp0 0)
		(while (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE)
			(cond
				((self onMe: temp1)
					(if (not temp0)
						(= cel (= temp0 1))
						(UpdateScreenItem self)
						(FrameOut)
					)
				)
				(temp0
					(= cel (= temp0 0))
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			(temp1 dispose:)
		)
		(if (self onMe: temp1)
			(gGame handsOff:)
			(= cel (= temp0 0))
			(UpdateScreenItem self)
			(FrameOut)
			(temp1 dispose:)
			(= gQuit
				(Print
					posn: 71 82
					font: 0
					addText: {Are you sure you want to quit?} 0 0
					addButton: 1 {Yes} 127 15
					addButton: 0 {No} 168 15
					init:
				)
			)
		)
	)
)

(instance iconDone of SelectScaryIcon ; UNUSED
	(properties
		x 113
		y 171
		view 980
	)

	(method (doVerb)
		(gCurRoom newRoom: 30)
	)
)

(instance iconCancel of SelectScaryIcon
	(properties
		x 214
		y 139
		view 980
		loop 2
	)

	(method (doVerb &tmp temp0 temp1)
		(= temp1 0)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(cond
				((self onMe: temp0)
					(if (not temp1)
						(= cel (= temp1 1))
						(UpdateScreenItem self)
						(FrameOut)
					)
				)
				(temp1
					(= cel (= temp1 0))
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			(temp0 dispose:)
		)
		(if (self onMe: temp0)
			(temp0 dispose:)
			(gGame handsOff:)
			(= cel (= temp1 0))
			(UpdateScreenItem self)
			(FrameOut)
			(gCurRoom newRoom: 30)
		)
	)
)

(instance iconDelete of SelectScaryIcon
	(properties
		x 113
		y 139
		view 980
		loop 1
	)

	(method (doVerb &tmp temp0 temp1 temp2)
		(= temp1 0)
		(while (!= ((= temp2 (Event new:)) type:) evMOUSERELEASE)
			(cond
				((self onMe: temp2)
					(if (not temp1)
						(= cel (= temp1 1))
						(UpdateScreenItem self)
						(FrameOut)
					)
				)
				(temp1
					(= cel (= temp1 0))
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			(temp2 dispose:)
		)
		(if (self onMe: temp2)
			(= cel (= temp1 0))
			(UpdateScreenItem self)
			(FrameOut)
			(temp2 dispose:)
			(if (localproc_1)
				(gCurRoom setScript: sDeleteIcon)
			)
		)
	)
)

