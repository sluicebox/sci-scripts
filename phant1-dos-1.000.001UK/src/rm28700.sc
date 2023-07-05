;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28700)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm28700 0
)

(instance rm28700 of ScaryRoom
	(properties
		stepSound 1
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init &tmp temp0 temp1 temp2)
		(= temp2 0)
		(= temp1 0)
		(switch gChapter
			(1
				(= temp0 904)
			)
			(2
				(= temp1 915)
				(= temp0 905)
			)
			(3
				(= temp1 916)
				(= temp0 906)
			)
			(4
				(= temp1 916)
				(= temp0 906)
			)
			(5
				(= temp1 917)
				(= temp0 907)
			)
			(6
				(= temp1 918)
				(= temp0 908)
			)
		)
		(if (== (gGDacSound number:) temp0)
			(if (not (gGDacSound handle:))
				(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
			else
				(gGDacSound setVol: 127)
			)
		else
			(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
		)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gPrevRoomNum 28600)
			(proc1111_6)
		)
		(= global115 0)
		(if (and (!= gPrevRoomNum 34100) (!= gPrevRoomNum 4200))
			(= picture 28700)
		)
		(gEgo init: setScaler: Scaler 56 44 116 71)
		(cond
			((== gChapter 5)
				(= picture 28701)
				(gEgo fadePalette: 28100)
				(if (!= gPrevRoomNum 34100)
					(car view: 28702 init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				)
			)
			((not (OneOf gPrevRoomNum 4200 34100))
				(car init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
			)
		)
		(door init: 1)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28300
				(if (== global125 69)
					(proc1111_6)
					(gEgo posn: 104 97 normalize: 7)
					(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
					(gGame handsOn:)
					(= global125 0)
				else
					(gEgo normalize: 0 posn: 10 100)
					(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				)
			)
			(28600
				(gEgo posn: 284 89 normalize: 1)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28110
				(gEgo normalize: 1 posn: 180 107)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28100
				(gEgo normalize: 0 posn: 95 74)
				(car approachX: (gEgo x:))
				(door
					approachY: (- (gEgo x:) 30)
					approachY: (- (gEgo y:) 30)
				)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(4200
				(proc1111_6)
				(gEgo posn: 1000 1000)
				(= temp2 sMikeDies)
			)
			(34100
				(= picture 34260)
				(gGame setIntensity: 0 1)
				(if (gCast contains: gEgo)
					(gEgo hide:)
				)
				(if (gCast contains: car)
					(car hide:)
				)
				(if (and (IsFlag 173) (== gChapter 3))
					(= temp2 chap3EndScr)
				else
					(= global163 car)
					(= temp2 sExitCar)
				)
			)
			(else
				(gEgo normalize: 5 posn: 264 90)
			)
		)
		(if
			(and
				(!= gPrevRoomNum 4200)
				(!= gPrevRoomNum 34100)
				(>= gChapter 4)
				(!= gChapter 5)
				(IsFlag 203)
			)
			(truck init:)
			(if (and (IsFlag 232) (not (IsFlag 337)))
				(truck approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
			)
		)
		(westExit init: 4)
		(eastExit init: 2)
		(northExit init: 1)
		(super init: &rest)
		(if temp2
			(gCurRoom setScript: temp2)
		else
			(gGame handsOn:)
		)
	)
)

(instance chap3EndScr of Script
	(properties)

	(method (dispose)
		(gGDacSound stop:)
		(global114 stop: 1)
		(gCurRoom newRoom: 44) ; chapEndRm
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 1602 82 2 gEgo -1 1)
					(if (== (Platform 2) 2)
						(gGame fade: 0 100 2)
					)
				)
				(1
					(proc1111_6)
					(gGDacSound stop:)
					(global114 stop: 1)
					(gCurRoom drawPic: -1)
					(PlayVMD 0 {3970.vmd} 0) ; Open
					(proc26_0 3970 self)
				)
				(2
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom drawPic: -1)
			(PlayVMD 0 {3970.vmd} 0) ; Open
			(proc26_0 3970)
			(self dispose:)
		)
	)
)

(instance sExitCar of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 28700 picture: 28700)
		(if (== gChapter 5)
			(car view: 28702 init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(car init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(if (or (== gChapter 6) (and (== gChapter 4) (IsFlag 203)))
			(truck init:)
		)
		(gEgo show: normalize: 1 posn: 110 97)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1601 10 -9 gEgo 50)
					(if (== (Platform 2) 2)
						(gGame fade: 0 100 2)
					)
				)
				(1
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(self dispose:)
		)
	)
)

(instance sToDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(gCurRoom drawPic: 34440 picture: 34440)
					(proc1111_7 1570 148 29 gEgo 30 1)
				)
				(1
					(gCurRoom newRoom: 4200)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(gCurRoom newRoom: 4200)
		)
	)
)

(instance sNoGo of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 28701 picture: 28701)
		(car view: 28702 posn: 47 121)
		(gEgo posn: 104 97 normalize: 7)
		(self setScript: (ScriptID 0 5) 0 5) ; takeLastStep
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(car view: 34262 posn: 209 131)
					(proc1111_7 1605 55 46)
					(gCurRoom drawPic: 34261 picture: 34261)
				)
				(1
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sGoToTown of Script
	(properties)

	(method (dispose)
		(if (gCast contains: truck)
			(truck dispose:)
		)
		(cond
			(global115
				(if (Robot 6) ; Exists
					(Robot 10) ; Pause
				)
				(if (== (Platform 2) 2)
					(gGame fade: 100 0 2)
				)
				(proc1111_6)
				(= global115 0)
			)
			((== (Platform 2) 2)
				(gGame fade: 100 0 2)
			)
		)
		(gCurRoom newRoom: 34100)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: car)
						(car dispose:)
					)
					(if (gCast contains: truck)
						(truck dispose:)
					)
					(gEgo hide:)
					(proc1111_7 1603 155 50 gEgo 100 1)
					(gCurRoom drawPic: 34260 picture: 34260)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)
)

(instance sTruck of Script
	(properties)

	(method (dispose)
		(SetFlag 337)
		(gCurRoom drawPic: 28700 picture: 28700)
		(car view: 28701 posn: 47 121)
		(truck view: 28700 approachVerbs: 0 setHotspot: 0 posn: 126 69)
		(gEgo show: posn: 95 74 normalize: 3)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCurRoom drawPic: 28112 picture: 28112)
					(car view: 28113 posn: 215 71)
					(truck view: 28112 posn: 12 112)
					(proc1111_7 4570 29 40)
				)
				(1
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sMikeDies of Script
	(properties)

	(method (dispose)
		(= gNewRoomNum 44) ; chapEndRm
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {5850.vmd} 0) ; Open
					(proc26_0 5850 self)
				)
				(2
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance car of View
	(properties
		approachX 47
		approachY 121
		x 47
		y 121
		view 28701
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gChapter 5)
				(gCurRoom setScript: sNoGo)
			else
				(gCurRoom setScript: sGoToTown)
			)
		else
			(super doVerb: &rest)
		)
	)
)

(instance truck of View
	(properties
		approachX 120
		approachY 74
		x 128
		y 72
		view 28700
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sTruck)
		else
			(super doVerb: &rest)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 20
		nsTop 20
		nsRight 48
		nsBottom 48
		approachX 34
		approachY 49
		x 34
		y 34
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sToDoor)
		else
			(super doVerb: &rest)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		approachY 116
		nextRoom 28300
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 280
		approachX 297
		approachY 97
		nextRoom 28110
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 58
		nsRight 95
		nsBottom 65
		approachX 88
		approachY 61
		nextRoom 28100
	)
)

