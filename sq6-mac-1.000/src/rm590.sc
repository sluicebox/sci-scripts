;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use DText)
(use Str)
(use Inset)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm590 0
)

(local
	[local0 120] = [256 256 256 0 512 512 512 768 256 256 256 512 512 512 768 768 256 256 256 512 512 512 768 768 256 0 256 513 512 512 768 768 0 256 256 512 512 512 0 768 768 768 768 768 1024 0 1024 1280 768 768 768 768 1024 1024 1024 1280 768 768 768 768 1024 1024 1280 1280 768 0 768 1024 1024 1024 1280 1280 768 768 768 0 1024 1024 1280 1280 1280 1536 0 1792 1792 2048 2048 2304 1280 0 1536 1792 2048 2048 2304 2304 1536 1536 1536 1792 2048 2048 2304 2304 1536 1536 1792 1792 2048 2048 2304 2304 1536 1536 1792 1792 2048 2048 2304 0]
	[local120 120] = [2560 2816 3072 3072 3328 3328 0 3328 2560 3072 3072 3072 3328 3328 3328 3328 2560 3072 3072 3072 3328 3328 3328 0 2816 3072 3072 3072 3328 3328 0 3328 0 3072 3072 0 3328 3328 3328 3328 3328 3584 3584 3840 0 4096 4114 0 3328 0 3840 3840 4096 4112 4096 4096 3328 3584 3840 3840 4112 4096 4096 4096 3584 3584 3840 3856 4096 0 4096 4096 3584 3584 3856 3840 4096 4096 4096 4096 4096 4096 4096 4096 4352 4608 4608 4608 4096 4096 4096 4096 4643 4608 4608 4608 4096 4096 4096 4128 4608 0 4608 4608 4096 4096 4128 4096 4608 4608 4608 4608 4096 4128 4096 4352 4608 4608 4608 4608]
	[local240 120] = [4864 4864 4864 4864 4864 4864 0 4864 4864 4864 4864 4864 4864 4864 4864 4864 4864 4864 0 4864 4864 4864 4917 4864 4864 4868 4864 4864 4864 4912 4864 4864 4864 4864 4864 4864 4912 4864 4864 4864 4864 4864 0 4864 5120 5120 5120 5120 4864 4864 4864 4864 5120 5120 5120 5120 4864 4864 4864 4864 5120 5120 0 5120 4864 4870 4864 5120 5120 5120 5120 5120 4864 4864 4864 0 5120 5120 0 5120 5120 5120 5376 5632 0 5888 5888 5888 5120 5376 5376 5632 5632 5888 5888 6144 5120 5376 5376 0 0 5888 5888 6400 5120 5376 5376 5632 5888 0 5888 6400 0 5376 5632 5632 5888 5888 5888 6656]
	[local360 8] = [-9 26 -16 49 -15 72 6 94]
	[local368 8] = [-10 26 0 2 3 -2 5 -7]
	local376
	local377
	[local378 5]
	[local383 8] = [11 21 30 40 49 59 69 78]
	[local391 5] = [6 62 74 87 94]
	[local396 8] = [4 14 24 34 43 53 62 73]
	[local404 6] = [5 4 6 7 8 9]
	local410
	local411
	local412
	local413
	[local414 27] = [0 0 585 0 0 0 0 0 0 0 0 0 0 0 0 586 587 0 588 589 0 0 0 0 0 0 0]
)

(procedure (localproc_0 param1) ; UNUSED
	(return (>> (<< param1 $0008) $0008))
)

(procedure (localproc_1 param1)
	(return (>> param1 $0008))
)

(procedure (localproc_2 param1)
	(return (>> (<< param1 $000c) $000c))
)

(procedure (localproc_3 param1)
	(return (>> (<< param1 $0008) $000c))
)

(procedure (localproc_4 &tmp temp0 temp1 temp2)
	(if (not ([local378 0] size:))
		(return)
	)
	(for ((= temp1 1)) (< temp1 ([local378 0] size:)) ((++ temp1))
		(for ((= temp2 1)) (< temp2 5) ((++ temp2))
			(= temp0 ([local378 0] at: temp1))
			(if (!= (temp0 stairSet:) (([local378 0] topStep:) stairSet:))
				(if [local378 temp2]
					(if
						(!=
							(temp0 stairSet:)
							(([local378 temp2] topStep:) stairSet:)
						)
						0
					else
						([local378 temp2] add: temp0)
						([local378 0] delete: temp0)
						(-- temp1)
						(break)
					)
				else
					(= [local378 temp2] (StairSet new:))
					([local378 temp2] add: temp0)
					([local378 0] delete: temp0)
					(-- temp1)
					(break)
				)
			else
				(break)
			)
		)
	)
	(for ((= temp2 0)) (and (< temp2 5) [local378 temp2]) ((++ temp2))
		(for ((= temp1 0)) (< temp1 ([local378 temp2] size:)) ((++ temp1))
			(= temp0 ([local378 temp2] at: temp1))
			(temp0 stairSet: [local378 temp2])
		)
	)
)

(procedure (localproc_5 param1 &tmp temp0)
	(cond
		((== param1 0)
			(= temp0 1)
		)
		((and (< 0 param1) (< param1 7))
			(= temp0 2)
		)
		((== param1 7)
			(= temp0 3)
		)
	)
	((View new:)
		view: 830
		loop: temp0
		cel: 0
		posn: 12 [local396 param1]
		setPri: (+ ((gCurRoom inset:) priority:) 1)
		init:
	)
)

(class QScript of Obj
	(properties
		script 0
		regValue 0
	)

	(method (init param1 param2)
		(= regValue param2)
		(= script param1)
		(super init: &rest)
	)
)

(class StairSet of Set
	(properties)

	(method (topStep)
		(self at: 0)
	)

	(method (bottomStep)
		(self at: (- size 1))
	)

	(method (canWalk param1 param2 &tmp temp0 temp1)
		(= temp1 param1)
		(cond
			((> param1 param2)
				(= temp0 (self at: temp1))
				(while (>= temp1 param2)
					(if (not (temp0 isOpen:))
						(return 0)
					else
						(-- temp1)
						(= temp0 (self at: temp1))
					)
				)
			)
			((< param1 param2)
				(= temp0 (self at: temp1))
				(while (<= temp1 param2)
					(if (not (temp0 isOpen:))
						(return 0)
					else
						(++ temp1)
						(= temp0 (self at: temp1))
					)
				)
			)
			((== param1 param2)
				(if (and (not local376) ((self at: param1) isOpen:))
					(return 1)
				else
					(return 0)
				)
			)
		)
		(return 1)
	)
)

(class StepController of Obj
	(properties
		active 0
		queue 0
		qScript 0
		lastStep 0
	)

	(method (init param1 &tmp temp0 temp1)
		(if (not queue)
			(= queue (Set new:))
		)
		(super init: &rest)
		(if (!= param1 1)
			(= temp0 (param1 stairSet:))
			(if lastStep
				(= temp1 ((lastStep stairSet:) indexOf: lastStep))
			else
				(= temp1 (- (temp0 size:) 1))
			)
			(cond
				((temp0 canWalk: temp1 (temp0 indexOf: param1))
					(self fillQueue: param1)
				)
				(local376
					(gMessager say: 3 3 1 0) ; "As much fun as it is to see you plant your face on the granite floor, we advise against it. After all, you'll just have to clean up the blood afterwards."
				)
				(else
					(gMessager say: 3 3 10 0) ; "I don't see how I can walk up there."
				)
			)
		)
		(= active 1)
		(self cue:)
	)

	(method (fillQueue param1 &tmp temp0 temp1 temp2 temp3)
		(if (not queue)
			(= queue (Set new:))
		)
		(= temp1 (- ((param1 stairSet:) size:) 1))
		(= temp2 ((param1 stairSet:) indexOf: param1))
		(= temp2 (- temp1 temp2))
		(if lastStep
			(= temp3 ((param1 stairSet:) indexOf: lastStep))
			(= temp3 (- temp1 temp3))
		)
		(cond
			((not local376)
				(queue
					addToEnd:
						((QScript new:)
							init: (approachFiles new:) param1
							yourself:
						)
				)
				(for ((= temp0 0)) (<= temp0 temp2) ((++ temp0))
					(queue
						addToEnd:
							((QScript new:)
								init:
									(stepUp new:)
									((param1 stairSet:) at: (- temp1 temp0))
								yourself:
							)
					)
				)
				(= lastStep param1)
			)
			((> temp2 temp3)
				(for ((= temp0 (+ temp3 1))) (<= temp0 temp2) ((++ temp0))
					(queue
						addToEnd:
							((QScript new:)
								init:
									(stepUp new:)
									((param1 stairSet:) at: (- temp1 temp0))
								yourself:
							)
					)
				)
				(= lastStep param1)
			)
			((< temp2 temp3)
				(for ((= temp0 temp3)) (> temp0 temp2) ((-- temp0))
					(queue
						addToEnd:
							((QScript new:)
								init:
									(stepDown new:)
									((param1 stairSet:) at: (- temp1 temp0))
								yourself:
							)
					)
				)
				(= lastStep param1)
			)
			((== temp2 temp3) 0)
		)
	)

	(method (goToBottom &tmp temp0)
		(if (and local376 lastStep)
			(= temp0 ((lastStep stairSet:) bottomStep:))
			(self fillQueue: temp0)
			(queue
				addToEnd:
					((QScript new:) init: (stepOffStairs new:) temp0 yourself:)
			)
			(self init: 1)
			(= lastStep 0)
		)
	)

	(method (openDrawer param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (param1 stairSet:))
		(= temp0 (temp2 indexOf: param1))
		(++ temp0)
		(= temp1 (temp2 at: temp0))
		(if lastStep
			(= temp3 ((lastStep stairSet:) indexOf: lastStep))
		else
			(= temp3 (- (temp2 size:) 1))
		)
		(cond
			((== temp3 temp0)
				(queue
					addToEnd:
						((QScript new:)
							init: (openPuzzleDrawer new:) param1
							yourself:
						)
				)
				(self init: 1)
				(return 1)
			)
			((temp2 canWalk: temp3 temp0)
				(self fillQueue: temp1)
				(queue
					addToEnd:
						((QScript new:)
							init: (openPuzzleDrawer new:) param1
							yourself:
						)
				)
				(self init: 1)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (cue)
		(if (not (queue isEmpty:))
			(if qScript
				(queue delete: qScript)
				(qScript dispose:)
			)
			(= qScript (queue at: 0))
			(if (and qScript (qScript isMemberOf: QScript))
				(gEgo setScript: (qScript script:) self (qScript regValue:))
			else
				(= active 0)
			)
		else
			(= active 0)
		)
	)

	(method (checkValid param1)
		(if
			(or
				(and local376 lastStep (not (param1 stairSet:)))
				(and
					local376
					lastStep
					(param1 stairSet:)
					(not ((param1 stairSet:) contains: lastStep))
				)
			)
			(return 0)
		else
			(return 1)
		)
	)

	(method (dispose)
		(if queue
			(queue dispose:)
			(= queue 0)
		)
		(= lastStep 0)
		(super dispose: &rest)
	)
)

(class Drawer of Prop
	(properties
		noun 3
		sightAngle 40
		stairSet 0
		files 0
	)

	(method (init)
		(gWalkHandler addToEnd: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(or
				local376
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					(== (event message:) JOY_DOWNRIGHT)
					(local377 checkValid: self)
					(self isNigelRead:)
				)
			)
			(= sightAngle 26505)
		else
			(= sightAngle 40)
		)
		(super handleEvent: event &rest)
	)

	(method (isOpen)
		(return (!= cel 0))
	)

	(method (isNigelRead &tmp temp0)
		(cond
			((IsFlag 134)
				(return 1)
			)
			((and files (== [local404 (- files 1)] 6))
				(return 1)
			)
			(
				(and
					(not files)
					stairSet
					(= temp0 (stairSet firstTrue: #files))
					(== [local404 (- (temp0 files:) 1)] 6)
				)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3 ; Walk
				(cond
					((not (local377 checkValid: self))
						(gMessager say: 3 3 11 0) ; "That looks like a heckuva jump. Maybe I should get off these files first."
					)
					((and stairSet (not (stairSet firstTrue: #isOpen)))
						(super doVerb: theVerb &rest)
						(return)
					)
					((and stairSet (not (local377 active:)))
						(local377 init: self)
					)
					(else
						(super doVerb: theVerb &rest)
						(return)
					)
				)
			)
			(4 ; Do
				(cond
					((not (local377 checkValid: self))
						(gMessager say: 3 3 11 0) ; "That looks like a heckuva jump. Maybe I should get off these files first."
					)
					((not (self isNigelRead:))
						(gMessager say: 3 4 12 0) ; "THAT drawer isn't even CLOSE to a drawer that starts with the letter R."
					)
					((and files (< loop 2) (not local376) (not (self isOpen:)))
						(self setScript: openLowerDrawer)
					)
					(
						(and
							local376
							(== loop (gEgo loop:))
							(== 583 (gEgo view:))
							(gEgo cel:)
						)
						(gMessager say: 3 3 2 0) ; "General Drawer Failure. Please step off and try another approach."
					)
					((and files (== loop 4))
						(if (not (= temp0 (local377 openDrawer: self)))
							(if local376
								(gMessager say: 3 3 2 0) ; "General Drawer Failure. Please step off and try another approach."
							else
								(gMessager say: 3 3 3 0) ; "Crud. I can't seem to reach it from here."
							)
						)
					)
					((and local376 files (< loop 4))
						(if
							(and
								(not (= temp0 (local377 openDrawer: self)))
								local376
							)
							(gMessager say: 3 3 2 0) ; "General Drawer Failure. Please step off and try another approach."
						)
					)
					(local376
						(gMessager say: 3 3 2 0) ; "General Drawer Failure. Please step off and try another approach."
					)
					((self isOpen:)
						(self setScript: sCloseDrawer)
					)
					(else
						(self setScript: sOpenDrawer)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(class FolderText of DText
	(properties
		invItem -1
		folderPos -1
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(= temp0 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(self doVerb: (event message:))
				(= temp0 (event claimed: 1))
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (if (> nsBottom 5) nsBottom else 5))
		(= temp1 (if (> nsRight 50) nsRight else 50))
		(return
			(and
				(<= (+ nsLeft x) (param1 x:) (+ temp1 x))
				(<= (+ nsTop y) (param1 y:) (+ temp0 y))
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= invItem -1)
					(gEgo get: [local391 invItem])
					(switch [local391 invItem]
						(6
							(gGame points: 2 432)
						)
						(62
							(gGame points: 2 435)
						)
						(74
							(gGame points: 2 433)
						)
						(87
							(gGame points: 2 434)
						)
						(94
							(gGame points: 2 436)
						)
					)
					((gCurRoom inset:) setScript: folderGone 0 folderPos)
					(= invItem -1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm590 of SQRoom
	(properties
		noun 1
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 120])
		(if (not gFileRoomRow)
			(= gFileRoomRow 2)
		)
		(switch gFileRoomRow
			(1
				(= picture 590)
			)
			(2
				(= picture 5903)
			)
			(3
				(= picture 5906)
			)
		)
		(= local377 (StepController new:))
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -10 139 945 139 945 122 -10 122
					yourself:
				)
		)
		(gEgo
			posn: 0 132
			init:
			normalize:
			setScript: egoEntersRoom
			code: scrollCode
		)
		(= temp4 (Str newWith: 80 {}))
		(switch gFileRoomRow
			(1
				(for ((= temp2 0)) (<= temp2 2) ((++ temp2))
					(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
						(for ((= temp1 0)) (<= temp1 7) ((++ temp1))
							(= [temp9 temp3]
								[local0
									(= temp3 (+ (* 40 temp2) (* 8 temp0) temp1))
								]
							)
						)
					)
				)
			)
			(2
				(for ((= temp2 0)) (<= temp2 2) ((++ temp2))
					(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
						(for ((= temp1 0)) (<= temp1 7) ((++ temp1))
							(= [temp9 temp3]
								[local120
									(= temp3 (+ (* 40 temp2) (* 8 temp0) temp1))
								]
							)
						)
					)
				)
			)
			(3
				(for ((= temp2 0)) (<= temp2 2) ((++ temp2))
					(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
						(for ((= temp1 0)) (<= temp1 7) ((++ temp1))
							(= [temp9 temp3]
								[local240
									(= temp3 (+ (* 40 temp2) (* 8 temp0) temp1))
								]
							)
						)
					)
				)
			)
			(else
				(= temp9 0)
			)
		)
		(for ((= temp2 0)) (< temp2 5) ((++ temp2))
			(= [local378 temp2] 0)
		)
		(= [local378 0] (StairSet new:))
		(for ((= temp2 0)) (<= temp2 2) ((++ temp2))
			(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
				(for ((= temp1 0)) (<= temp1 7) ((++ temp1))
					(= temp3 (+ (* 40 temp2) (* 8 temp0) temp1))
					(if
						(and
							(= temp8 (localproc_1 [temp9 temp3]))
							(not (localproc_3 [temp9 temp3]))
							(not (localproc_2 [temp9 temp3]))
						)
						(Message msgGET 590 noun 0 0 temp8 (temp4 data:))
						((DText new:)
							text: (KString 8 (temp4 data:)) ; StrDup
							fore: 0
							font: 490
							x: (+ 18 (* temp1 40) (* temp2 320))
							y: (+ 10 (* temp0 22))
							setPri: 5
							setSize: 10
							init:
						)
					)
					(if
						(or
							(localproc_3 [temp9 temp3])
							(localproc_2 [temp9 temp3])
						)
						(= temp6 (localproc_3 [temp9 temp3]))
						(= temp7 (localproc_2 [temp9 temp3]))
						(= temp5 (- 4 temp0))
						((= temp8 (Drawer new:))
							view: [local414 (localproc_1 [temp9 temp3])]
							loop: temp5
							cel: 0
							x: (+ 5 (* temp1 40) (* temp2 320))
							y: (+ 6 (* temp0 22))
							files: temp7
							init:
						)
						(if (!= temp5 4)
							(temp8
								approachVerbs: 4 ; Do
								approachX: (+ (temp8 x:) [local360 (* temp5 2)])
								approachY:
									(+ (temp8 y:) [local360 (+ (* temp5 2) 1)])
							)
						)
						(if temp6
							(temp8 stairSet: temp6)
							([local378 0] add: temp8)
						)
					)
				)
			)
		)
		(temp4 dispose:)
		(localproc_4)
		(allFiles init:)
		(exit580 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		((self plane:) setRect: 0 0 961 138)
		(UpdatePlane plane)
		(self buildPic:)
		(if (!= (gGSound1 number:) 580)
			(gGSound1 number: 580 setLoop: -1 play:)
		)
		(gWalkHandler addToFront: self)
	)

	(method (buildPic)
		(switch gFileRoomRow
			(1
				(AddPicAt plane 5901 320 0)
				(AddPicAt plane 5902 640 0)
			)
			(2
				(AddPicAt plane 5904 320 0)
				(AddPicAt plane 5905 640 0)
			)
			(3
				(AddPicAt plane 5907 320 0)
				(AddPicAt plane 5908 640 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (& (event type:) evMOVE)
			(cond
				(
					(and
						(= temp0 (gCast firstTrue: #onMe event))
						(temp0 isMemberOf: Drawer)
					)
					(super handleEvent: event &rest)
				)
				(local376
					(= local410 (event x:))
					(= local411 (event y:))
					(local377 goToBottom:)
					(event claimed: 1)
					(return 1)
				)
				(else
					(= local410 0)
					(= local411 0)
					(super handleEvent: event &rest)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose &tmp temp0)
		(if local377
			(local377 dispose:)
		)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if [local378 temp0]
				([local378 temp0] release: dispose:)
				(= [local378 temp0] 0)
			)
		)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		((self plane:) setRect: 0 0 319 138)
		(super dispose: &rest)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 (gEgo xStep:))
		(if
			(and
				(> (+ (gEgo x:) temp1) 220)
				(> temp3 325)
				(gEgo mover:)
				(> (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:)
				setRect: (- temp1 temp0) temp2 (- temp3 temp0) temp4
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (gEgo x:) temp1) 100)
				(< temp1 -5)
				(gEgo mover:)
				(< (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:)
				setRect: (+ temp1 temp0) temp2 (+ temp3 temp0) temp4
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance egoEntersRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 30 (gEgo y:) self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance approachFiles of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 ((register stairSet:) bottomStep:))
				(gEgo
					setMotion: MoveTo (+ -21 (temp0 x:)) (+ 28 (temp0 y:)) self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stepUp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local376)
					(= local376 1)
				)
				(if (& (gEgo state:) $0002)
					(gEgo state: (& (gEgo state:) $fffd))
				)
				(= temp0 (* 2 (register loop:)))
				(gEgo
					view: 583
					loop: (register loop:)
					cel: 0
					posn:
						(+ [local368 temp0] (register x:))
						(+ [local368 (+ temp0 1)] (register y:))
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stepDown of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 (* 2 (register loop:)))
				(gEgo
					view: 583
					loop: (register loop:)
					posn:
						(+ [local368 temp0] (register x:))
						(+ [local368 (+ temp0 1)] (register y:))
				)
				(gEgo cel: (gEgo lastCel:) setSpeed: 6 setCycle: Beg self)
			)
			(1
				(= temp1
					((register stairSet:)
						at: (+ ((register stairSet:) indexOf: register) 1)
					)
				)
				(gEgo loop: (temp1 loop:))
				(= temp0 (* 2 (temp1 loop:)))
				(gEgo
					posn:
						(+ [local368 temp0] (temp1 x:))
						(+ [local368 (+ temp0 1)] (temp1 y:))
					cel: (gEgo lastCel:)
				)
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stepOffStairs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 (* 2 (register loop:)))
				(gEgo
					view: 583
					loop: (register loop:)
					posn:
						(+ [local368 temp0] (register x:))
						(+ [local368 (+ temp0 1)] (register y:))
				)
				(gEgo cel: (gEgo lastCel:) setSpeed: 6 setCycle: Beg self)
			)
			(1
				(if (not (& (gEgo state:) $0002))
					(gEgo state: (| (gEgo state:) $0002))
				)
				(if (not (gEgo loop:))
					(= local376 0)
					(= temp0 ((register stairSet:) bottomStep:))
					(gEgo
						posn: (+ -21 (temp0 x:)) (+ 28 (temp0 y:))
						normalize: 0
						setMotion: PolyPath local410 local411 self
					)
					(= local410 0)
					(= local411 0)
				else
					(= ticks 1)
				)
			)
			(2
				(gGame handsOn:)
				(if local412
					(= local412 0)
					(exit580 doVerb: (exit580 message:))
				)
				(self dispose:)
			)
		)
	)
)

(instance openPuzzleDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 584
					loop: 0
					cel: 0
					posn: (+ (gEgo x:) 33) (+ (gEgo y:) -15)
					setPri: (- (register priority:) 1)
					setSpeed: 7
					setCycle: CT 3 1 self
				)
				(register setCycle: End self)
			)
			(1 0)
			(2
				(if (and (== (register loop:) 4) (not gLookedAtNigelFile))
					(self setScript: frigginCheaters self)
				else
					(= ticks 1)
				)
			)
			(3
				(gCurRoom setInset: insideFile self register)
			)
			(4
				(gEgo setCycle: End self)
				(register setCycle: Beg)
			)
			(5
				(gEgo
					view: 583
					loop: (- (register loop:) 1)
					posn: (- (gEgo x:) 33) (- (gEgo y:) -15)
					setPri: -1
				)
				(gEgo cel: (gEgo lastCel:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance frigginCheaters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 4 13 1 self) ; "(crackly) Now, now, now (PATRONIZING)... what have we here? You haven't found the clue to this file's existence, yet somehow you know ... Perhaps subtracting a few hundred points from your score will teach you!"
			)
			(1
				(if (> gScore 200)
					(= local413 200)
					(gTheIconBar trickScore: 200)
				else
					(= local413 gScore)
					(gTheIconBar trickScore: gScore)
				)
				(= cycles 2)
			)
			(2
				(gMessager say: 3 4 13 2 self) ; "Nyah! Nyah! Nyah! Cheaters never prosper!"
			)
			(3
				(= ticks 120)
			)
			(4
				(gTheIconBar updateScore: local413)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 582
					loop: (client loop:)
					cel: 0
					setSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(1
				(gGSound2 number: 591 loop: 0 play: setVol: 127)
				(if (== (client loop:) 1)
					(client setPri: 99)
				)
				(client setCycle: End self)
				(gEgo setCycle: End)
			)
			(2
				(if (!= (client loop:) 3)
					(gEgo x: (- (gEgo x:) 10))
					(client approachX: (- (client approachX:) 10))
				)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (client loop:) 3)
					(gEgo x: (+ (gEgo x:) 10))
				)
				(gEgo view: 582 loop: (client loop:) setSpeed: 6)
				(gEgo cel: (gEgo lastCel:) setCycle: CT 4 -1 self)
			)
			(1
				(gGSound2 number: 592 loop: 0 play: setVol: 127)
				(client setCycle: Beg self)
				(gEgo setCycle: Beg)
			)
			(2
				(if (== (client loop:) 1)
					(client setPri: -1)
				)
				(if (!= (client loop:) 3)
					(client approachX: (+ (client approachX:) 10))
				)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance folderGone of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((== register 0)
						(= temp0 1)
					)
					((and (< 0 register) (< register 7))
						(= temp0 2)
					)
					((== register 7)
						(= temp0 3)
					)
				)
				((View new:)
					view: 830
					loop: temp0
					cel: 0
					posn: 12 [local396 register]
					setPri: (+ ((gCurRoom inset:) priority:) 1)
					init:
				)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openLowerDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 591 592) ; WAVE
				(gEgo
					view: 582
					loop: (client loop:)
					cel: 0
					setSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(1
				(gGSound2 number: 591 loop: 0 play: setVol: 127)
				(client setCycle: End self)
				(gEgo setCycle: End)
			)
			(2
				(gCurRoom setInset: insideFile self client)
			)
			(3
				(gEgo setCycle: CT 4 -1 self)
			)
			(4
				(gGSound2 number: 592 loop: 0 play: setVol: 127)
				(client setCycle: Beg self)
				(gEgo setCycle: Beg)
			)
			(5
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance inView of View
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

(instance allFiles of Feature
	(properties
		noun 3
		sightAngle 40
		x 158
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 0 119 955 119 955 0 yourself:)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(or
					(== (event message:) JOY_UP)
					(== (event message:) JOY_DOWNRIGHT)
					(== (event message:) JOY_UPRIGHT)
				)
			)
			(= x (event x:))
		)
		(super handleEvent: event &rest)
	)

	(method (facingMe)
		(if local376
			(return 1)
		else
			(super facingMe: &rest)
		)
	)
)

(instance exit580 of ExitFeature
	(properties
		nsTop 30
		nsRight 25
		nsBottom 138
		approachX -10
		approachY 130
		x 7
		y 95
		nextRoom 580
		message 8
	)

	(method (doVerb theVerb)
		(if (and (== theVerb message) local376 (not (local377 active:)))
			(= local410 approachX)
			(= local411 approachY)
			(= local412 1)
			(local377 goToBottom:)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(self doVerb: message)
	)
)

(instance insideFile of Inset
	(properties
		view 830
		x 86
		y 15
		disposeNotOnMe 1
		noun 13
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(gTheIconBar setupExit: 1)
		(gGame handsOn:)
		(super init: &rest)
		(= temp1 (Str newWith: 80 {}))
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= temp3 0)
			(= temp4 -1)
			(Message
				msgGET
				590
				3
				1
				[local404 (- (register files:) 1)]
				(+ temp0 1)
				(temp1 data:)
			)
			(if (!= (= temp3 (temp1 indexOf: 42)) -1)
				(= temp2 (temp1 subStr: (+ temp3 1) 1))
				(= temp4 (- (temp2 asInteger:) 1))
				(temp2 dispose:)
				(temp1 at: temp3 0)
			)
			(if (and (!= temp4 -1) (gEgo has: [local391 temp4]))
				(localproc_5 temp0)
			)
			((FolderText new:)
				text: (KString 8 (temp1 data:)) ; StrDup
				fore: 0
				font: 490
				x: 20
				y: [local383 temp0]
				setSize: 60
				setPri: (self priority:)
				invItem: temp4
				folderPos: (if (!= temp4 -1) temp0 else -1)
				init:
			)
		)
		(temp1 dispose:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(if (not (== view -1))
			(inView view: view loop: loop cel: cel setPri: 0 ignoreActors: 1)
			(plane setBitmap: inView 0)
		)
	)

	(method (restore)
		(self drawInset:)
		(UpdatePlane plane)
		(FrameOut)
		(if inset
			(inset restore:)
		)
	)

	(method (doit)
		(if (not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
			(cond
				(
					(and
						(gUser canInput:)
						(not (self onMe: (gUser curEvent:)))
						(!= gTheCursor gTheExitCursor)
					)
					(gGame setCursor: gTheExitCursor 1)
				)
				(
					(and
						(gUser canInput:)
						(self onMe: (gUser curEvent:))
						(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gTheIconBar setupExit: 0)
		(gGame handsOff:)
		(super dispose:)
	)
)

