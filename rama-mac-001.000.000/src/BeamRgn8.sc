;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2047)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use cplainRegion)
(use n1111)
(use Feature)
(use Actor)
(use System)

(public
	BeamRgn8 0
)

(instance BeamRgn8 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2046 ; BeamRgn7
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
		((ScriptID 200 0) addMigrant: 107) ; cplainRegion
	)

	(method (dispose)
		(= global161 0)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2052) ; BiotHanger1
			(picObj showBlack: 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2125
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== gPrevRoomNum 2052) ; BiotHanger1
			(= showBlack 1)
		)
		(super init: &rest)
		(= showBlack 0)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2128
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(concaveLens init: global117)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2127
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= showBlack 1)
		(hangerExit_180 init:)
		(if (proc1111_24 119)
			(gCurRoom setScript: spider_Pacing)
		else
			(if (== (proc70_9 46) 2054)
				(ladder init: global117)
			)
			(= picture 2184)
		)
		(super init: &rest)
		(entrance_180 init:)
	)

	(method (dispose)
		(if (proc1111_24 119)
			(= global161
				(if gAutoRobot
					(Robot 11) ; FrameNum
				else
					0
				)
			)
			(proc1111_6)
			(spider_Pacing dispose:)
		)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2126
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(sevenExit_270 init:)
		(super init: &rest)
	)
)

(instance spider_Pacing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= state 0)
				(proc1111_7 2127 250 126 global161 0 -1 1 self)
				(= global161 0)
			)
		)
	)
)

(instance ladder of View
	(properties
		x 310
		y 154
		view 2020
	)
)

(instance concaveLens of MigratingView
	(properties
		x 339
		y 309
		view 2021
		cel 7
		invItemID 107
	)
)

(instance entrance_180 of Feature
	(properties
		noun 13
		nsLeft -1
		nsTop -1
		nsRight 590
		nsBottom 204
		x 294
		y 101
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hangerExit_180 of ExitFeature
	(properties
		nsLeft 55
		nsTop 0
		nsRight 539
		nsBottom 210
		x 297
		y 105
		nextRoom 2052
	)
)

(instance sevenExit_270 of ExitFeature
	(properties
		nsLeft 63
		nsTop 84
		nsRight 544
		nsBottom 235
		x 303
		y 159
		nextRoom 2046
	)
)

