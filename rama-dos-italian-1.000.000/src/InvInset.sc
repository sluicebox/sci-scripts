;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use InvInitialize)
(use SpinProp)
(use n1111)
(use VMDMovie)
(use Print)
(use Inset)
(use Feature)
(use User)
(use Actor)
(use System)

(public
	InvInset 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1)
	(return (== (proc70_7 param1) 33))
)

(procedure (localproc_1 param1)
	(return (== (proc70_7 param1) 114))
)

(procedure (localproc_2 param1 &tmp temp0)
	(if (or (not argc) (not param1))
		(return 0)
	)
	(= temp0
		(switch (proc70_7 param1)
			(45 1200)
			(3 1201)
			(124 1202)
			(34 1203)
			(40 1204)
			(5 1205)
			(115 1205)
			(123 1205)
			(41 1205)
			(42 1205)
			(43 1205)
			(8 1206)
			(16 1207)
			(117 1208)
			(118 1209)
			(119 1210)
			(120 1211)
			(121 1212)
			(80 1213)
			(122 1214)
			(38 1215)
			(35 1216)
			(108 1217)
			(else 76)
		)
	)
	(return (ScriptID temp0 0))
)

(class InvInset of Inset
	(properties
		priority 10
		x 0
		y 0
	)

	(method (resetInvObj param1 &tmp temp0)
		(cond
			(global125
				(= temp0 (global125 myInvObj:))
			)
			(
				(or
					(and (localproc_0 param1) (== local2 1))
					(and (localproc_1 param1) (== local2 2))
				)
				(= temp0 param1)
			)
			(else
				(switch local2
					(1
						((= global125 SpinProp) myInvObj: param1)
						(proc70_1 33 1)
					)
					(2
						((= global125 SpinProp) myInvObj: param1)
						(proc70_1 114 1)
					)
				)
				(= temp0 0)
			)
		)
		(if (!= temp0 param1)
			(if global125
				(global125 dispose: myInvObj: param1)
			)
			(if temp0
				(if (== (proc70_7 temp0) 124)
					(proc70_8 temp0)
				else
					(proc70_1 (proc70_7 temp0) 1)
				)
			)
			(gCast eachElementDo: #dispose)
			(plane picture: -1)
			(self start: param1 drawPic:)
		)
	)

	(method (drawPic param1)
		(if (and argc param1)
			(plane drawPic: param1)
		)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (start param1 &tmp temp0 temp1 temp2 temp3)
		((= global125 (localproc_2 param1)) setInvObj: param1)
		(cond
			(
				(and
					(param1 isPreRendered:)
					(not (or (localproc_0 param1) (localproc_1 param1)))
				)
				(global125 setController: turn)
				(= temp0 (- (- (plane right:) (plane left:)) 492))
				(= temp1 (- (- (plane bottom:) (plane top:)) 292))
				(/= temp0 2)
				(/= temp1 2)
				(turn
					nsLeft: temp0
					nsRight: (+ temp0 492)
					nsTop: temp1
					nsBottom: (+ temp1 292)
					plane: (self plane:)
					setSpinProp: global125
					addControls: leftCR
					addControls: rightCR
					init:
				)
				(leftCR init: turn)
				(rightCR init: turn)
				(= temp2 (- (plane right:) (plane left:)))
				(= temp3 (- (plane bottom:) (plane top:)))
				(/= temp2 2)
				(/= temp3 2)
				(global125
					view: (param1 closeView:)
					loop: 0
					cel: 0
					posn: temp2 temp3
					cycleSpeed: 6
					setCursor: touchCursor
					init:
				)
				(if (gTheCursor isInvCursor:)
					(= local0 1)
				)
			)
			((localproc_0 param1)
				(= local2 1)
				(gGame saveRobot: 1)
				(self setTitle:)
				(turn dispose:)
				(leftCR dispose:)
				(rightCR dispose:)
				(falStaff_Burps play:)
			)
			((localproc_1 param1)
				(= local2 2)
				(gGame saveRobot: 1)
				(self setTitle:)
				(turn dispose:)
				(leftCR dispose:)
				(rightCR dispose:)
				(puck_Flourish play:)
			)
			(else
				(self setScript: noArt)
			)
		)
	)

	(method (setTitle)
		(cond
			(global125 0)
			((== local2 1)
				(global123 displayOptionsText: 90 ((proc70_6 33) noun:) 0 4 1)
			)
			((== local2 2)
				(global123 displayOptionsText: 90 ((proc70_6 114) noun:) 0 4 1)
			)
		)
	)

	(method (init param1 param2 param3 param4 param5)
		(SetFlag 14)
		(= y (= x 0))
		(if (not plane)
			((= plane (gThePlane new:))
				back: 0
				picture: -1
				setRect: 30 40 624 332
				setInsetRect: 30 40 624 332
			)
		)
		(super init: param1 param2 param3 param4)
		(self start: param5)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evKEYBOARD)
				(== (event message:) KEY_ESCAPE)
				(User canInput:)
				(User canControl:)
			)
			(self setScript: delayDispose)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doit)
		(self setTitle:)
		(super doit: &rest)
	)

	(method (dispose &tmp temp0)
		(= temp0 0)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(if global125
			(= temp0 (global125 myInvObj:))
		)
		(if (and local0 temp0)
			(= local0 0)
			(if
				(and
					(gTheCursor invItem:)
					(!= (gTheCursor invItem:) temp0)
					(!= (proc70_7 (gTheCursor invItem:)) 39)
				)
				(proc70_1 -1 1)
			)
			(if (<= (temp0 owner:) -1)
				(gTheCursor setInvCursor: temp0)
			)
		)
		(if global125
			(global125 dispose:)
			(= global125 0)
		)
		(super dispose: &rest)
		(if (and local1 (gPlanes contains: local1))
			(local1 dispose:)
			(= local1 0)
		)
		(if local2
			(= local2 0)
			(gGame saveRobot: 0)
		)
		(ClearFlag 14)
	)
)

(instance noArt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(Prints {No Art})
				(= ticks 1)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance delayDispose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(client dispose:)
			)
		)
	)
)

(instance puck_Flourish of VMDMovie
	(properties
		movieName 1052
		frameRate 15
		endPic 201
	)

	(method (close)
		(if gVMDMovie
			(if (== gVMDMovie self)
				(if endPic
					(InvInset drawPic: endPic)
				)
				(self doVerb: 3)
			)
			(PlayVMD 6) ; Close
			(= gVMDMovie 0)
		)
	)
)

(instance falStaff_Burps of VMDMovie
	(properties
		movieName 1051
		endPic 200
	)

	(method (close)
		(if gVMDMovie
			(if (== gVMDMovie self)
				(if endPic
					(InvInset drawPic: endPic)
				)
				(self doVerb: 3)
			)
			(PlayVMD 6) ; Close
			(= gVMDMovie 0)
		)
	)
)

(class ControlFeature of Feature
	(properties
		isDown 0
		whoToSpin 0
		controlList 0
		hotVerb 0
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 11)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(if controlList
			(controlList release: dispose:)
			(= controlList 0)
		)
		(super dispose: &rest)
		(= plane 0)
	)

	(method (addControls param1)
		(if (and argc param1)
			(if (not controlList)
				(= controlList (Set new:))
			)
			(controlList add: param1)
		)
	)

	(method (setSpinProp param1)
		(if (and argc param1)
			(= whoToSpin param1)
		)
	)

	(method (setTitle)
		(if (and whoToSpin (whoToSpin myInvObj:))
			(global123
				displayOptionsText: 90 ((whoToSpin myInvObj:) noun:) 0 4 1
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(event localize: plane)
		(cond
			((event claimed:)
				(return 1)
			)
			((not whoToSpin)
				(event globalize:)
				(return 0)
			)
			((and isDown (not (self onMe: event)) (whoToSpin isRotate:))
				(= isDown 0)
				(whoToSpin stopRotate:)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					scratch
					(self onMe: event)
					(or
						(not (whoToSpin onMe: event))
						(not (whoToSpin scratch:))
					)
					(scratch respondsTo: (gTheCursor verb:))
					(= temp0 (controlList firstTrue: #onMe event))
				)
				(= isDown 1)
				(temp0 action:)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					isDown
					(& (event type:) evMOUSERELEASE)
					(self onMe: event)
					(whoToSpin isRotate:)
				)
				(= isDown 0)
				(whoToSpin stopRotate: 0)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					isDown
					(whoToSpin isRotate:)
					(= temp0 (controlList firstTrue: #onMe event))
				)
				(temp0 setCursor: hotVerb setTitle: action:)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(self onMe: event)
					(not (event type:))
					(= temp0 (controlList firstTrue: #onMe event))
				)
				(temp0 setCursor: hotVerb setTitle:)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			((and (self onMe: event) (not (event type:)))
				(self setTitle:)
			)
			(else
				(event globalize:)
			)
		)
	)
)

(class ControlRect of Obj
	(properties
		cursor 0
		left 0
		right 0
		bottom 0
		top 0
		controller 0
		titleMsg -1
	)

	(method (init param1 param2 param3 param4 param5)
		(self controller: param1)
		(if (> argc 1)
			(self left: param2 top: param3 right: param4 bottom: param5)
		)
		(super init: &rest)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if
				(or
					(not (or left right top bottom))
					(and (<= left temp0 right) (<= top temp1 bottom))
				)
				1
			else
				0
			)
		)
	)

	(method (setCursor param1)
		(gTheCursor setTempCursor: cursor param1)
	)

	(method (setTitle)
		(global123 displayOptionsText: 90 titleMsg 0 4 1)
	)

	(method (action))
)

(instance leftCR of ControlRect
	(properties
		right 183
		bottom 290
		top 1
	)

	(method (init)
		(self cursor: ltCursor titleMsg: 95)
		(super init: &rest)
	)

	(method (action)
		(cond
			((or (not controller) (not (controller whoToSpin:)))
				(return)
			)
			((not ((controller whoToSpin:) isRotate:))
				((controller whoToSpin:) setRotate: 0)
			)
			(
				(and
					((controller whoToSpin:) isRotate:)
					(!= ((controller whoToSpin:) getRotate:) 0)
				)
				((controller whoToSpin:) setRotate: 0)
			)
		)
	)
)

(instance rightCR of ControlRect
	(properties
		left 384
		right 590
		bottom 290
		top 2
	)

	(method (init)
		(self cursor: rtCursor titleMsg: 94)
		(super init: &rest)
	)

	(method (action)
		(cond
			((or (not controller) (not (controller whoToSpin:)))
				(return)
			)
			((not ((controller whoToSpin:) isRotate:))
				((controller whoToSpin:) setRotate: 1)
			)
			(
				(and
					((controller whoToSpin:) isRotate:)
					(!= ((controller whoToSpin:) getRotate:) 1)
				)
				((controller whoToSpin:) setRotate: 1)
			)
		)
	)
)

(instance turn of ControlFeature
	(properties
		hotVerb 2
	)
)

(instance ltCursor of View
	(properties
		cel 1
		view 600
	)
)

(instance rtCursor of View
	(properties
		view 600
	)
)

(instance exCursor of View ; UNUSED
	(properties
		cel 6
		view 600
	)
)

(instance touchCursor of View
	(properties
		cel 10
		view 600
	)
)

