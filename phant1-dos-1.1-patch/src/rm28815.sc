;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28815)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm28815 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(gEgo setScaler: Scaler 98 62 128 77)
	(gCurRoom picture: 28850)
	(if local0
		(if (not (IsFlag 182))
			(cyrus view: 4387 posn: 64 99)
		else
			(cyrus
				view: 4399
				cel: (/ (cyrus cel:) 2)
				cycleSpeed: 12
				scaleSignal: 1
				posn: 67 109
			)
		)
		(cyrus setCycle: Fwd)
	else
		(stump view: 4397 posn: 67 109)
	)
)

(procedure (localproc_1)
	(gEgo setScaler: Scaler 86 19 150 77)
	(if (== (gCurRoom picture:) -1)
		(gCurRoom picture: 28815)
	else
		(gCurRoom drawPic: 28815)
	)
	(if local0
		(if (not (IsFlag 182))
			(cyrus view: 4388 scaleSignal: 0 posn: 40 90)
		else
			(if (== (cyrus view:) 4399)
				(cyrus cel: (* (cyrus cel:) 2) cycleSpeed: 6)
			)
			(cyrus view: 4398 scaleSignal: 0 posn: 44 92)
		)
		(cyrus setCycle: Fwd)
	else
		(stump view: 4396 posn: 44 92)
	)
)

(instance rm28815 of ScaryRoom
	(properties
		stepSound 1
	)

	(method (drawPic param1)
		(if (and (== gChapter 5) (ResCheck rsPIC (+ param1 1)))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init &tmp temp0 temp1)
		(= temp1 0)
		(cond
			((== gChapter 1)
				(= temp0 904)
			)
			((== gChapter 2)
				(= temp1 915)
				(= temp0 905)
			)
			((== gChapter 3)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 4)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 5)
				(= temp1 917)
				(= temp0 907)
			)
			((== gChapter 6)
				(= temp1 918)
				(= temp0 908)
			)
		)
		(if temp1
			(Load rsSOUND temp1)
		)
		(cond
			((ResCheck rsAUDIO temp0)
				(Load rsAUDIO temp0)
			)
			((ResCheck 140 temp0) ; WAVE
				(Load 140 temp0) ; WAVE
			)
		)
		((ScriptID 30) init:) ; FidgetCode
		(proc1111_6)
		(Load rsPIC 28815)
		(Load rsPIC 28850)
		(gEgo init: fadedY: 90 brightY: 120 setScaler: Scaler 86 19 150 77)
		(if (== gChapter 5)
			(Palette 2 55 135 70) ; PalIntensity
			(gEgo fadePalette: 28100)
		)
		(door init: 1)
		(eastExit init: 2)
		(westExit init: 4)
		(northExit init: 1)
		(= local0 0)
		(cond
			((or (!= gChapter 4) (IsFlag 325) (IsFlag 185))
				(if (>= gChapter 4)
					(stump init:)
				)
			)
			((not (IsFlag 182))
				(cyrus
					init:
					setSpeed: 6
					approachVerbs: 4 ; Do
					setHotspot: 4 3 ; Do, Move
					ignoreActors: 1
				)
				(= local0 1)
			)
			(else
				(if (and (not (== gPrevRoomNum 28860)) (IsFlag 334))
					(ClearFlag 334)
				)
				(if (not (IsFlag 334))
					(Load 140 28040) ; WAVE
					(Lock 140 28040 1) ; WAVE
					(Load 140 28041) ; WAVE
					(Lock 140 28041 1) ; WAVE
					(Load 140 28042) ; WAVE
					(Lock 140 28042 1) ; WAVE
					(cyrus
						init:
						setSpeed: 6
						approachVerbs: 4 ; Do
						setHotspot: 4 3 ; Do, Move
						ignoreActors: 1
					)
					(= local0 1)
					(cyrus
						cel:
							(if (== gPrevRoomNum 28860)
								global225
							else
								(Random 0 (cyrus lastCel:))
							)
						setCycle: Fwd
					)
				)
			)
		)
		(cond
			((== gPrevRoomNum 900)
				(gGame handsOn:)
				(localproc_1)
			)
			((OneOf gPrevRoomNum 2200 2400)
				(localproc_0)
				(gEgo setScale: 0 view: 1680 loop: 0 cel: 0 posn: 182 77)
				(self setScript: fromDoorScr)
			)
			((== gPrevRoomNum 28820)
				(gEgo normalize: 1 posn: 177 90)
				(localproc_1)
			)
			((== gPrevRoomNum 28860)
				(gEgo normalize: 2 posn: 105 90)
				(if (and (== gPrevRoomNum 28860) global125)
					(cyrus doVerb: 4)
					(= global125 0)
				else
					(localproc_1)
				)
			)
			(else
				(localproc_1)
				(gEgo normalize: 0 posn: 4 96)
			)
		)
		(if (not script)
			(if (and (== gChapter 5) (IsFlag 195) (not (IsFlag 380)))
				(SetFlag 380)
				(self setScript: pondFlash)
			else
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
		)
		(super init: &rest)
		(global114 stop: 1)
		(if (== (gGDacSound number:) temp0)
			(if (not (gGDacSound handle:))
				(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
			else
				(gGDacSound setVol: 127)
			)
		else
			(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
		)
		(gGame fadeSpeed: 100)
		(pond init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
	)

	(method (dispose)
		(Lock 140 28040 0) ; WAVE
		(Lock 140 28041 0) ; WAVE
		(Lock 140 28042 0) ; WAVE
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: newRoomNumber)
	)
)

(instance pondFlash of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(gCurRoom drawPic: 28815)
			(gEgo show:)
			(stump show:)
			(pondWater dispose:)
			(gGame handsOn:)
			(localproc_1)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if register
						(self cue:)
					else
						(self setScript: (ScriptID 0 5) self) ; takeLastStep
					)
				)
				(1
					(gGame handsOff:)
					(stump hide:)
					(pondWater init:)
					(gEgo hide:)
					(gCurRoom drawPic: 28805)
					(= seconds 6)
				)
				(2
					(gCurRoom drawPic: 28815)
					(pondWater dispose:)
					(stump show:)
					(gEgo show:)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance pondWater of Prop
	(properties
		view 28806
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 14)
		(self setCycle: Fwd posn: 52 110)
	)
)

(instance lookInPond of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						(local0
							(cyrus hide:)
						)
						((gCast contains: stump)
							(stump hide:)
						)
					)
					(proc1111_7 1670 71 33 gEgo 117)
					(gCurRoom drawPic: 28805)
				)
				(1
					(gCurRoom drawPic: 28815)
					(cond
						(local0
							(cyrus show:)
						)
						((gCast contains: stump)
							(stump show:)
						)
					)
					(gGame handsOn:)
					(gEgo normalize: 1 posn: 14 96)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(gCurRoom drawPic: 28815)
					(gGame handsOn:)
					(cond
						(local0
							(cyrus show:)
						)
						((gCast contains: stump)
							(stump show:)
						)
					)
					(gEgo normalize: 1 posn: 14 96)
					(self dispose:)
				)
			)
		)
	)
)

(instance fromDoorScr of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(gEgo normalize: 4 setScaler: Scaler 98 62 128 77 posn: 59 87)
			(if (and (== gChapter 5) (IsFlag 195) (not (IsFlag 380)))
				(SetFlag 380)
				(gCurRoom setScript: pondFlash 0 1)
			else
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		else
			(switch (= state newState)
				(0
					(gEgo setCycle: CT 56 1 self)
				)
				(1
					(gEgo
						normalize: 4
						setScaler: Scaler 98 62 128 77
						posn: 59 87
					)
					(localproc_1)
					(self setScript: (ScriptID 0 5) self 10) ; takeLastStep
				)
				(2
					(if (and (== gChapter 5) (IsFlag 195) (not (IsFlag 380)))
						(SetFlag 380)
						(gCurRoom setScript: pondFlash 0 1)
					else
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance torment of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(gCast eachElementDo: #show)
					(gEgo posn: 80 88 normalize: 5)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== (gCurRoom picture:) -1)
						(gCurRoom picture: 28225)
					else
						(gCurRoom drawPic: 28225)
					)
					(proc1111_7 4380 0 0)
					(cyrus dispose:)
					(= local0 0)
					(SetFlag 334)
					(SetFlag 182)
					(gCast eachElementDo: #hide)
				)
				(1
					(proc1111_7 4381 -8 -40)
					(gCurRoom drawPic: 28852)
				)
				(2
					(proc1111_7 4382 -8 -40)
					(gCurRoom drawPic: 28240)
				)
				(3
					(proc1111_7 4383 9 -31)
					(gCurRoom drawPic: 28230)
				)
				(4
					(proc1111_7 4384 -8 -40)
					(gCurRoom drawPic: 28852)
				)
				(5
					(gCast eachElementDo: #show)
					(gEgo posn: 80 88 normalize: 5)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance findCat of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 317)
					(stump dispose:)
					(gCurRoom drawPic: -1)
					(gEgo hide:)
					(PlayVMD 0 {4970.vmd} 0) ; Open
					(proc26_0 4970 self)
				)
				(1
					(= global125 1)
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(= global125 1)
					(gCurRoom newRoom: 2200)
				)
			)
		)
	)
)

(instance talkCyrus1Scr of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(cyrus show: cel: 170 setCycle: Fwd)
					(localproc_1)
					(gEgo posn: 80 88 normalize: 5)
					(SetFlag 183)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== (gCurRoom picture:) -1)
						(gCurRoom picture: 28230)
					else
						(gCurRoom drawPic: 28230)
					)
					(cyrus hide:)
					(proc1111_7 4394 -11 -43)
				)
				(1
					(proc1111_7 4395 -18 -36)
					(gCurRoom drawPic: 28854)
				)
				(2
					(cyrus show: cel: 170 setCycle: Fwd)
					(gEgo posn: 80 88 normalize: 5)
					(localproc_1)
					(SetFlag 183)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance missingCat of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 5000 89 29)
					(gCurRoom drawPic: 28805)
					(stump hide:)
				)
				(1
					(gEgo normalize: 1 posn: 14 96)
					(stump show:)
					(gCurRoom drawPic: 28815)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(stump show:)
					(proc1111_6)
					(gEgo normalize: 1 posn: 14 96)
					(gCurRoom drawPic: 28815)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkNothingScr of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: cyrus)
						(cyrus show: cel: 16)
					else
						(cyrus
							init:
							setSpeed: 6
							approachVerbs: 4 3 ; Do, Move
							ignoreActors: 1
							cel: 16
						)
					)
					(gEgo posn: 80 88 normalize: 5)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: cyrus)
						(cyrus hide:)
					else
						(cyrus
							init:
							setSpeed: 6
							approachVerbs: 4 3 ; Do, Move
							ignoreActors: 1
							hide:
						)
					)
					(if (== (gCurRoom picture:) -1)
						(gCurRoom picture: 28854)
					else
						(gCurRoom drawPic: 28854)
					)
					(proc1111_7 4410 -13 -39)
				)
				(1
					(cyrus show: cel: 16)
					(localproc_1)
					(gEgo posn: 80 88 normalize: 5)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkBuildingScr of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(localproc_1)
					(= global115 0)
					(gGame handsOn:)
					(gEgo posn: 80 88 normalize: 5)
					(stump init:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 185)
					(cyrus dispose:)
					(if (== (gCurRoom picture:) -1)
						(gCurRoom picture: 28854)
					else
						(gCurRoom drawPic: 28854)
					)
					(proc1111_7 4400 -31 16)
				)
				(1
					(proc1111_7 4401 -9 -33)
					(gCurRoom drawPic: 28230)
				)
				(2
					(proc1111_7 4402 -74 -37)
					(gCurRoom drawPic: 28240)
				)
				(3
					(proc1111_7 4403 103 3)
					(gCurRoom drawPic: 28854)
				)
				(4
					(gEgo posn: 80 88 normalize: 5)
					(stump init:)
					(localproc_1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance thruDoorFromFarShot of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(= global115 0)
					(gGDacSound fade: 0 4 2 1)
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(localproc_0)
					(gEgo
						view: 1681
						loop: 0
						cel: 0
						setScale: 0
						posn: 174 93
						setCycle: End self
					)
					(gCurRoom drawPic: 28850)
				)
				(1
					(gGDacSound fade: 0 4 2 1)
					(gCurRoom newRoom: 2200)
				)
			)
		)
	)
)

(instance pond of Feature
	(properties
		x 50
		y 150
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 34 30 41 30 47 37 41 47 51 80 39 75 30 75 25 79 28 84 28 92 47 91 56 92 61 95 60 97 0 97 0 94 8 94 19 91 18 77 12 75 6 76 0 78 0 65 12 37 17 43 23 45 34 42 35 37
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (== gChapter 5) (IsFlag 195))
					(if (IsFlag 317)
						(gCurRoom setScript: missingCat)
					else
						(gCurRoom setScript: findCat)
					)
				else
					(gCurRoom setScript: lookInPond)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 55
		nsTop 52
		nsRight 71
		nsBottom 76
		approachX 65
		approachY 70
		x 58
		y 76
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: thruDoorFromFarShot)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nextRoom 28810
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 214
		nsBottom 90
		nextRoom 28820
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 98
		nsTop 1
		nsRight 215
		nsBottom 79
		nextRoom 28860
	)
)

(instance stump of View
	(properties
		x 44
		y 92
		view 4396
	)
)

(instance sfx of Sound
	(properties
		flags 4
	)
)

(instance cyrus of Actor
	(properties
		approachX 60
		approachY 90
		x 44
		y 92
		view 4398
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 182)
			(|= signal $1000)
		)
		(self setCycle: Fwd)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (IsFlag 182) (self isNotHidden:))
			(if (== view 4399)
				(= temp0 12)
			else
				(= temp0 24)
			)
			(-- temp0)
			(cond
				((not local1)
					(if (== cel temp0)
						(= local1 1)
						(sfx number: (Random 28040 28042) setLoop: 1 play:)
					)
				)
				((!= cel temp0)
					(= local1 0)
				)
			)
		)
	)

	(method (dispose)
		(= global225 cel)
		(= local0 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((not (IsFlag 182))
					(gCurRoom setScript: torment)
				)
				((and (not (IsFlag 183)) (not (IsFlag 176)))
					(gGame handsOff:)
					(gCurRoom setScript: talkCyrus1Scr)
				)
				((and (IsFlag 176) (not (IsFlag 348)))
					(gGame handsOff:)
					(SetFlag 348)
					(SetFlag 153)
					(gCurRoom setScript: talkBuildingScr)
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: talkNothingScr)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

