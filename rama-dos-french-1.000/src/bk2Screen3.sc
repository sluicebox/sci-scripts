;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4111)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use n1111)
(use Plane)
(use Feature)
(use Actor)
(use System)

(public
	bk2Screen3 0
)

(local
	local0 = 30
	local1 = 40
	local2 = 1000
)

(instance bk2Screen3 of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		((= plane countPlane) init: 0 0 1000 332)
		(super init: 4111)
		(scrollRightButn init:)
		(scrollLeftButn init:)
		(backUpExit init:)
		((self plane:) setRect: local0 local1 local2 332)
		(UpdatePlane (self plane:))
		(FrameOut)
		(self edgeW: 0 edgeE: 0)
		(NUMERALDISP_270 init:)
		(if (proc1111_24 47)
			(proc1111_31 9)
			(SetFlag 47)
		)
	)

	(method (pitch)
		(if (< local0 30)
			(gCurRoom setScript: sScrollHome)
		else
			(self newRoom: gPrevRoomNum)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
			(= local1 (SaveManager readWord:))
			(= local2 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
			(SaveManager writeWord: local1)
			(SaveManager writeWord: local2)
		)
	)

	(method (dispose)
		(scrollRightButn dispose:)
		(scrollLeftButn dispose:)
		(backUpExit dispose:)
		(countPlane dispose:)
		(super dispose:)
	)
)

(instance scrollRightCursr of View
	(properties
		cel 13
		view 600
	)
)

(instance scrollLeftCursor of View
	(properties
		cel 14
		view 600
	)
)

(class ScrollFeature of Feature
	(properties
		keyMessage 0
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(event localize: plane)
		(if (and (not (event type:)) (self onMe: event))
			(self doVerb: 1)
			(event claimed: 1)
			(return)
		)
		(if
			(or
				(and (& (event type:) evMOUSE) (not (self onMe: event)))
				(not (event type:))
				(not (gUser input:))
			)
			(super handleEvent: event)
			(return)
		)
		(if (& (event type:) $0014) ; direction | evKEYBOARD
			(if (and (!= keyMessage -1) (== keyMessage (event message:)))
				(self doVerb: 2)
				(event claimed: 1)
			)
			(event claimed:)
			(return)
		)
		(if (& (event type:) evMOUSEBUTTON)
			(self trace: event)
		)
		(event claimed:)
	)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 0)
		(= temp1 (= temp3 0))
		(while 1
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 type: 0 message: 0 modifiers: 0 y: 0 x: 0 plane: 0)
			(GetEvent 3 param1)
			(param1 localize: plane)
			(cond
				((& (param1 type:) $0002)
					(break)
				)
				(
					(and
						(self onMe: param1)
						(or
							(not temp3)
							(and
								(< temp1 40)
								(= temp1 (Abs (- temp3 gGameTime)))
								0
							)
							(and (>= temp1 40) (<= (-- temp2) 0))
						)
					)
					(= temp3 gGameTime)
					(= temp2 20)
					(self doVerb: 2)
				)
			)
		)
		(param1 claimed: 1)
	)
)

(instance scrollRightButn of ScrollFeature
	(properties
		nsBottom 332
		nsRight 624
		nsTop 40
		keyMessage 3
	)

	(method (init)
		(= plane global124)
		(= nsLeft 574)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (<= (Abs local0) 408)
					(gTheCursor setTempCursor: scrollRightCursr)
				)
			)
			(2
				(if (<= (Abs local0) 408)
					(-= local0 10)
					(-= local1 0)
					(-= local2 local0)
					((bk2Screen3 plane:) setRect: local0 local1 local2 332)
					(UpdatePlane (bk2Screen3 plane:))
					(FrameOut)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scrollLeftButn of ScrollFeature
	(properties
		nsBottom 332
		nsLeft 30
		nsTop 40
		keyMessage 7
	)

	(method (init)
		(= nsRight 50)
		(= plane global124)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (< local0 30)
					(gTheCursor setTempCursor: scrollLeftCursor)
				)
			)
			(2
				(if (< local0 30)
					(+= local0 10)
					(+= local1 0)
					(+= local2 local0)
					((bk2Screen3 plane:) setRect: local0 local1 local2 332)
					(UpdatePlane (bk2Screen3 plane:))
					(FrameOut)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance countPlane of Plane
	(properties)
)

(instance backUpExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 89
		nsRight 1000
		nsTop 254
	)

	(method (init)
		(super init:)
		(= plane (bk2Screen3 plane:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: backupCursor)
			)
			(9
				(if (< local0 30)
					(gCurRoom setScript: sScrollHome)
				else
					(PrintDebug {calling pitch from backUpExit})
					(gCurRoom pitch:)
				)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom pitch: 1)
			)
		)
	)
)

(instance backupCursor of View
	(properties
		cel 5
		view 600
	)
)

(instance sScrollHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(scrollLeftButn doVerb: 2)
				(= cycles 1)
			)
			(2
				(if (< local0 30)
					(= state 0)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(gCurRoom pitch:)
				(self dispose:)
			)
		)
	)
)

(instance NUMERALDISP_270 of Feature
	(properties
		noun 25
		nsBottom 279
		nsLeft 2
		nsRight 590
		nsTop 8
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

