;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 901)
(include sci.sh)
(use Main)
(use DText)
(use Array)
(use Print)
(use Game)
(use Actor)
(use System)

(public
	selectGameRoom 0
)

(local
	[local0 5] = [91 126 161 196 231]
	[local5 10]
	local15
	local16
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (param1 cel:))
	(param1 cel: param2)
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp2 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: (ScriptID 0 11)) ; overlayPlane
		(cond
			((param1 onMe: temp0)
				(if (== (param1 cel:) temp1)
					(param1 cel: param2)
					(= temp2 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp1)
				(param1 cel: temp1)
				(= temp2 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(param1 cel: temp1)
	(UpdateScreenItem param1)
	(return temp2)
)

(instance selectGameRoom of Room
	(properties
		picture 9800
		style 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(gThePlane setRect: 0 0 319 199)
		(super init: &rest)
		(Load rsFONT 999)
		(= global121 0)
		(gUser canInput: 1)
		(gGame setCursor: gNormalCursor 1)
		(= temp0 0)
		(= local15 0)
		(for ((= temp2 0)) (< temp0 10) ((= temp2 0))
			(cond
				((== (= temp1 (gSaveManager saveFileName: temp0)) -1)
					(= temp2 0)
				)
				((and (IsFlag 34) (& (gSaveManager getSaveType: temp0) $0002))
					(= temp2 1)
				)
				((and (not (IsFlag 34)) (== (gSaveManager getSaveType: temp0) 1))
					(= temp2 1)
				)
			)
			(if temp2
				(++ local15)
				(= local16 temp0)
				((= [local5 (- local15 1)] (SkeletonIcon new:))
					view: 9905
					setLoop: (if (IsFlag 34) 4 else 3) 1
					setCel: 0
					value: (- local15 1)
					fileNumber: temp0
					x: [local0 (mod (- local15 1) 5)]
					y: (if (< (- local15 1) 5) 21 else 54)
					init:
				)
				(= temp3 (IntArray newWith: 4 {}))
				(Text 0 (temp3 data:) (temp1 data:) 999 0)
				((= temp5 (DText new:))
					font: 999
					text: (KString 8 (temp1 data:)) ; StrDup
					fore: 24
					back: 254
					x:
						(-
							([local5 (- local15 1)] x:)
							(/ (- (temp3 at: 2) (temp3 at: 0)) 2)
						)
					y: (+ ([local5 (- local15 1)] y:) 13)
					setSize:
					setPri: (+ (GetHighPlanePri) 1)
					init:
				)
				([local5 (- local15 1)] fileName: temp5)
				(temp3 dispose:)
			)
			(if (!= temp1 -1)
				(temp1 dispose:)
			)
			(++ temp0)
		)
		(= temp4 (gSaveManager getCurrentSave:))
		(for ((= temp0 0)) (< temp0 local15) ((++ temp0))
			(if (== ([local5 temp0] fileNumber:) temp4)
				(= local16 ([local5 temp0] value:))
				(break)
			else
				(= local16 0)
			)
		)
		([local5 local16] select:)
		(UpdateScreenItem [local5 local16])
		(if (IsFlag 152)
			(selectGameControls add: iconDelete iconDone eachElementDo: #init)
			(Print addText: 0 0 0 4 -1 -1 901 init:) ; "You have reached the maximum number of bookmarks allowed. You must delete one or more bookmarks in order to make room for a new one."
		else
			(selectGameControls
				add: iconPlay iconDelete iconCancel
				eachElementDo: #init
			)
		)
		(if (< local15 1)
			(iconPlay dispose:)
		)
	)
)

(instance sDeleteIcon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gSaveManager delete: ([local5 local16] fileNumber:))
				(-- local15)
				([local5 local16] dispose:)
				(if (and (< local16 local15) local15)
					(for ((= temp0 local16)) (< temp0 local15) ((++ temp0))
						(= [local5 temp0] [local5 (+ temp0 1)])
						([local5 temp0] value: temp0)
					)
				)
				(= [local5 local15] 0)
				(if (!= local15 0)
					(= local16 (- local15 1))
				else
					(iconPlay dispose:)
					(selectGameControls delete: iconDelete)
					(iconDelete dispose:)
					(= local15 -1)
					(= local16 -1)
				)
				(= cycles 2)
			)
			(2
				(= global124 (gSaveManager saveFileCnt:))
				(if (< local15 1)
					(self dispose:)
					(gCurRoom newRoom: 91) ; saveRest
				else
					(= ticks 60)
				)
			)
			(3
				(if (!= local16 -1)
					([local5 local16] select:)
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

	(method (dispose)
		(self eraseName:)
		(super dispose:)
	)

	(method (init)
		(self setPri: 15 ignoreActors: 1 setHotspot: 4 3) ; Do, Move
		(super init: &rest)
	)

	(method (doVerb)
		(self select:)
	)

	(method (select)
		([local5 local16] selected: 0 setCel: 0)
		(UpdateScreenItem [local5 local16])
		(self setCel: 1 selected: 1)
		(= local16 value)
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
)

(instance passScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 6])
		(switch (= state newState)
			(0
				(= global124 ([local5 local16] fileNumber:))
				(gCast eachElementDo: #dispose)
				(= cycles 2)
			)
			(1
				(if (gGSound1 handle:)
					(gGSound1 fade: 0 1 40 1 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gSaveManager setCurrentSave: global124)
				(gNormalCursor view: 9960)
				(Lock rsVIEW 9905 0)
				(Lock rsVIEW 9808 0)
				(gGame restore: global124)
			)
		)
	)
)

(instance iconPlay of View
	(properties
		x 14
		y 76
		view 9905
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(passScr init:)
		)
	)
)

(instance iconDone of View
	(properties
		x 14
		y 106
		view 9905
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(if (== (gSaveManager saveFileCnt:) 10)
				(gCurRoom newRoom: 91) ; saveRest
			else
				(gCurRoom newRoom: 902) ; nameGameRoom
			)
		)
	)
)

(instance iconCancel of View
	(properties
		x 14
		y 106
		view 9905
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(gCurRoom newRoom: 91) ; saveRest
		)
	)
)

(instance iconDelete of View
	(properties
		x 14
		y 136
		view 9905
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if
			(and
				(localproc_0 self 1)
				(Print
					addText: 0 0 0 1 -1 -1 901 ; "Are you sure you want to  delete the selected game?"
					addButton: 1 0 0 0 2 0 16 1 ; MISSING MESSAGE
					addButton: 0 0 0 0 3 0 34 1 ; MISSING MESSAGE
					init:
				)
			)
			(gCurRoom setScript: sDeleteIcon)
		)
	)
)

