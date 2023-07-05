;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use RamaRoom)
(use ExitFeature)
(use SaveManager)
(use Compass)
(use SoundManager)
(use n1111)
(use Plane)
(use Actor)
(use System)

(public
	Location 0
	proc21_1 1
)

(procedure (proc21_1 param1 param2 &tmp temp0 temp1)
	(if (and param1 param2)
		(= temp0 (param1 heading:))
		(if (< (= temp1 (param2 heading:)) temp0)
			(+= temp1 360)
		)
		(return (- temp1 temp0))
	else
		(return 0)
	)
)

(class Location of RamaRoom
	(properties
		heading -1
		picObj 0
		angle -1
		exitNE 0
		exitN 0
		exitNW 0
	)

	(method (init)
		((= plane (= global116 topPlane))
			init: 30 40 624 332
			priority: 7
			addCast: roomCast
		)
		(= global117 roomCast)
		(gCast add: roomCast)
		(if picObj
			(self picture: (picObj picture:) heading: (picObj heading:))
		)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (== modNum -1)
			(self modNum: (global122 modNum:))
		)
		(= gLeftExit leftExit)
		(= gRightExit rightExit)
		(= gUpExit upExit)
		(= gDownExit downExit)
	)

	(method (dispose)
		(if picObj
			(picObj dispose:)
			(= picObj 0)
		)
		(gCast delete: roomCast)
		(global116 deleteExtMH: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(self heading: -1)
		(self angle: -1)
		(super dispose:)
	)

	(method (addPicObj param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(= temp2 [param1 0])
		(for ((= temp3 0)) (< temp3 argc) ((++ temp3))
			(= temp0 [param1 temp3])
			(if (== heading (temp0 heading:))
				(= temp2 temp0)
			)
			(if (temp0 picture:)
				(Load rsPIC (temp0 picture:))
			)
			(temp0 left: temp1)
			(if (!= temp3 0)
				(temp1 right: temp0)
			)
			(= temp1 temp0)
		)
		(if (not picObj)
			(switch angle
				(90
					(if (temp2 up:)
						(self setPicObj: (temp2 up:))
					else
						(self setPicObj: temp2)
					)
				)
				(-90
					(if (temp2 down:)
						(self setPicObj: (temp2 down:))
					else
						(self setPicObj: temp2)
					)
				)
				(else
					(self setPicObj: temp2)
				)
			)
		else
			(Compass update:)
		)
	)

	(method (setPicObj param1)
		(if picObj
			(picObj dispose:)
		)
		(if argc
			(param1 init:)
			(self
				picObj: param1
				heading: (param1 heading:)
				angle: (param1 angle:)
				edgeN: (param1 edgeN:)
				edgeS: (param1 edgeS:)
				edgeE: (param1 edgeE:)
				edgeW: (param1 edgeW:)
			)
			(if (SoundManager initialized:)
				(SoundManager panSFXLocs:)
			)
			(if global150
				((ScriptID 10 0) init:) ; debugRm
			)
		)
		(if (and picObj Compass)
			(Compass update:)
		)
	)

	(method (yaw param1)
		(switch param1
			(1
				(if (picObj right:)
					(self setPicObj: (picObj right:))
				)
			)
			(-1
				(if (picObj left:)
					(self setPicObj: (picObj left:))
				)
			)
		)
	)

	(method (pitch param1 &tmp temp0)
		(switch param1
			(1
				(if (picObj down:)
					(self setPicObj: (picObj down:))
				)
			)
			(-1
				(if (picObj up:)
					(self setPicObj: (picObj up:))
				)
			)
		)
	)

	(method (forward param1)
		(switch param1
			(1
				(if exitN
					(exitN doVerb: 9)
				)
			)
			(2
				(if exitNE
					(exitNE doVerb: 9)
				)
			)
			(8
				(if exitNW
					(exitNW doVerb: 9)
				)
			)
		)
	)

	(method (doVerb))

	(method (newRoom)
		(Compass clear:)
		(if (and (!= exitStyle -1) (& exitStyle $0100))
			(if picObj
				(picObj showBlack: 1)
			)
			(= exitStyle -1)
		)
		(super newRoom: &rest)
	)

	(method (serialize param1 &tmp temp0)
		(if (and argc param1)
			(super serialize: param1)
			(self picObj: 0)
			(self drawPic: 61)
			(self heading: (SaveManager readWord:))
			(self angle: (SaveManager readWord:))
			(= gCurRoom self)
		else
			(super serialize: param1)
			(SaveManager writeWord: heading)
			(SaveManager writeWord: angle)
		)
	)
)

(class CameraAngle of Obj
	(properties
		heading 0
		picture 0
		edgeW 32
		edgeE 560
		edgeS 260
		left 0
		right 0
		edgeN 32
		down 0
		up 0
		angle 0
		showBlack 0
	)

	(method (init)
		(cond
			((or (self left:) (self right:))
				(self angle: 0)
			)
			((self down:)
				(self angle: 90)
			)
			((self up:)
				(self angle: -90)
			)
			(else
				(self angle: -1)
			)
		)
		(if showBlack
			(gCurRoom drawPic: 61 0)
			(FrameOut)
		)
		(gCurRoom drawPic: picture)
		(if edgeN
			(upExit init:)
		)
		(if edgeS
			(downExit init:)
		)
		(if edgeE
			(rightExit init:)
		)
		(if edgeW
			(leftExit init:)
		)
	)

	(method (dispose)
		(gCurRoom exitN: 0 exitNE: 0 exitNW: 0)
		(roomCast dispose:)
		(global116 addCast: roomCast)
		((global116 theFtrs:) eachElementDo: #dispose release:)
		(if showBlack
			(gCurRoom drawPic: 61)
			(FrameOut)
			(= showBlack 0)
		)
		(proc1111_6)
		(super dispose:)
	)
)

(class CloseupLocation of Location
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(super init:)
		(if (>= argc 2)
			(closeCameraAngle edgeW: param2)
		else
			(closeCameraAngle edgeW: 0)
		)
		(if (>= argc 3)
			(closeCameraAngle edgeE: param3)
		else
			(closeCameraAngle edgeE: 0)
		)
		(if (>= argc 4)
			(closeCameraAngle edgeN: param4)
		else
			(closeCameraAngle edgeN: 0)
		)
		(if (>= argc 5)
			(closeCameraAngle edgeS: 0)
			(= edgeS param5)
		else
			(backupExit init:)
		)
		(closeCameraAngle picture: param1 heading: (self heading:) showBlack: 1)
		(self setPicObj: closeCameraAngle)
	)

	(method (yaw param1)
		(switch param1
			(1
				(= global164 270)
			)
			(-1
				(= global164 90)
			)
		)
		(self newRoom: gPrevRoomNum)
	)

	(method (pitch)
		(= global164 0)
		(self newRoom: gPrevRoomNum)
	)
)

(instance closeCameraAngle of CameraAngle
	(properties
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
	)

	(method (dispose)
		(super dispose: &rest)
		(= showBlack 1)
	)
)

(instance leftExit of ExitFeature
	(properties
		nsBottom 288
		nsLeft 0
		nsRight 88
		nsTop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: leftCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom yaw: -1)
			)
		)
	)
)

(instance upExit of ExitFeature
	(properties
		nsBottom 46
		nsRight 464
		nsTop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: upCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom pitch: -1)
			)
		)
	)
)

(instance rightExit of ExitFeature
	(properties
		nsBottom 290
		nsLeft 531
		nsRight 589
		nsTop 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: rightCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom yaw: 1)
			)
		)
	)
)

(instance downExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 89
		nsRight 461
		nsTop 254
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: downCursor)
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

(instance backupExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 89
		nsRight 461
		nsTop 254
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: backupCursor)
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

(instance topPlane of Plane
	(properties)
)

(instance roomCast of Cast
	(properties)
)

(instance rightCursor of View
	(properties
		cel 1
		view 600
	)
)

(instance leftCursor of View
	(properties
		view 600
	)
)

(instance left180Cursor of View ; UNUSED
	(properties
		view 600
	)
)

(instance right180Cursor of View ; UNUSED
	(properties
		cel 1
		view 600
	)
)

(instance upCursor of View
	(properties
		cel 7
		view 600
	)
)

(instance downCursor of View
	(properties
		cel 8
		view 600
	)
)

(instance backupCursor of View
	(properties
		cel 5
		view 600
	)
)

