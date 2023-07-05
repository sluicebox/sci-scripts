;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3150)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use ROsc)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3150 0
)

(local
	local0
	local1
)

(instance s2_3150 of PQRoom
	(properties
		picture 3150
	)

	(method (init)
		(super init: &rest)
		((ScriptID 4054 0) changeMusic: 29805) ; kiplandRegion
		(if (== global108 4)
			(northE init:)
		else
			(eastE init:)
		)
		(westE init:)
		(robotFeat init:)
		(if (== global108 4)
			(gGame handsOn:)
			(gCurRoom setScript: sPlot1Script)
		else
			(switch gPrevRoomNum
				(3110 ; s2_3110
					(if (global112 leftEarly:)
						(self setScript: sEgoRunsIn)
					else
						(Load rsVIEW 31507)
						(Load rsVIEW 31508)
						(Load rsAUDIO 29810)
						(allen init:)
						(hector init:)
						(gGame handsOn:)
						(self setScript: sPlot2Script)
					)
				)
				(else
					(gGame handsOn:)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(cond
					((== global108 4)
						(gMessager say: 3 theVerb) ; "Cease fire!!"
					)
					((not local0)
						(= local0 1)
						(gMessager say: 3 theVerb 4) ; "Cease fire!"
					)
					(else
						(gCurRoom setScript: sSecondShot)
					)
				)
			)
			(10
				(cond
					((== global108 4)
						(gMessager say: 3 theVerb) ; "Cease fire!!"
					)
					((not local0)
						(= local0 1)
						(gMessager say: 3 theVerb 4) ; "Cease fire!"
					)
					(else
						(gCurRoom setScript: sSecondShot)
					)
				)
			)
			(16
				(global112 threwFlash: 3150)
				(cannister setScript: sFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sSecondShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 6 3 0 self) ; "Cease fire! Trailer! Officer coming out!"
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sEgoRunsIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 31501
					loop: 0
					cel: 0
					posn: 618 360
					init:
					setCycle: CT 59 1 self
				)
			)
			(1
				(gEgo dispose: view: 0)
				(gGame showCloseUp: 31510 -1 -1 self 1)
			)
			(2
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance sPlot1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gMessager say: 0 0 1 0 self) ; "Pup! Cover left!"
			)
			(2
				(= seconds 5)
			)
			(3
				(gCurRoom setScript: sPlot1TimerExpired)
			)
		)
	)
)

(instance sPlot1TimerExpired of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 3170) ; s2_3170
			)
		)
	)
)

(instance sPlot2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(westE dispose:)
				(eastE dispose:)
				(proc4_6 31505 -5 134 0 0 -1 1)
			)
			(2
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(self setScript: plot2AssocScript self)
			)
			(3
				(if script
					(proc4_5)
					(= global128 31505)
					(WalkieTalkie showFrame: 31505 332 -5 134)
					(script cue:)
				)
			)
			(4
				(gGame handsOff:)
				(allen setLoop: 2 setCel: 1 setCycle: End)
				(hector setLoop: 2 setCel: 1 setCycle: End)
				(proc4_6 31505 -5 134 333 0 -1 1)
			)
			(5
				(hector dispose:)
			)
			(6
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 64)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance plot2AssocScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setCycle: End self)
				(hector setCycle: End)
			)
			(1
				(allen setLoop: 1 setCel: 0 setCycle: ROsc -1 0 195)
				(hector setLoop: 1 setCel: 0 setCycle: ROsc -1 0 195)
			)
			(2
				(allen setCycle: End self)
				(hector setCycle: End)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sOfficerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9012 -1 -1 self 1)
			)
			(1
				(gMessager say: 5 10 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(SetFlag 100)
				(SetFlag 94)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(Load rsAUDIO 1002)
				(global112 threwFlash: 3200)
				(cannister
					view: 31500
					loop: 0
					cel: 0
					posn: 237 292
					init:
					setCycle: End self
				)
			)
			(1
				(if
					(and
						(== global128 31505)
						(or
							(and (not (allen loop:)) (< 0 (allen cel:) 21))
							(allen loop:)
						)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gFxSound number: 1002 loop: 1 play:)
				(cannister view: 6 loop: 0 cel: 0 posn: 289 179 setPri: 600)
				(if (== global108 4)
					0
				else
					(eastE dispose:)
					(northE dispose:)
					(westE dispose:)
					(allen setCycle: 0)
					(hector setCycle: 0)
					(proc4_5)
					(WalkieTalkie showFrame: 31503 0 -6 132)
					(= global128 31503)
				)
				(= cycles 2)
			)
			(3
				(cannister hide:)
				(gCurRoom setScript: sFlashBangCont)
			)
		)
	)
)

(instance sFlashBangCont of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(1
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(if (== global108 4)
					(gCurRoom setScript: sPlot1TimerExpired)
				else
					(gGame handsOn:)
					(if (and (not (allen loop:)) (not (allen cel:)))
						(proc4_5)
						(gCurRoom setScript: sFlashBangPlot2)
					else
						(SetFlag 98)
						(SetFlag 93)
						(global112 threwFlash: 3150)
						(gCurRoom setScript: hectorGetsShot)
					)
				)
			)
		)
	)
)

(instance sFlashBangPlot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: flashPlot2AssocScript self)
				(proc4_6 31503 -6 132 0 0 -1 1)
			)
			(1
				(if script
					(proc4_5)
					(= global128 31503)
					(WalkieTalkie showFrame: 31503 244 -6 132)
					(script cue:)
				)
			)
			(2
				(gGame handsOff:)
				(allen setLoop: 2 setCel: 7 setCycle: End)
				(hector setLoop: 2 setCel: 7 setCycle: End)
				(proc4_5)
				(proc4_6 31503 -6 132 245 0 -1 1)
			)
			(3
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 64)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashPlot2AssocScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen view: 31507 setLoop: 0 setCel: 0 setCycle: End self)
				(hector view: 31508 setLoop: 0 setCel: 0 setCycle: End)
			)
			(1
				(allen setLoop: 1 setCel: 0 setCycle: ROsc -1 0 210)
				(hector setLoop: 1 setCel: 0 setCycle: ROsc -1 0 210)
			)
			(2
				(allen setCycle: End self)
				(hector setCycle: End)
			)
			(3
				(allen setLoop: 2 setCel: 0 setCycle: CT 6 1 self)
				(hector setLoop: 2 setCel: 0 setCycle: CT 6 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance shootPat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 global128)
				(proc4_5)
				(= global128 31505)
				(WalkieTalkie showFrame: 31505 347 -5 134)
				(allen setLoop: 2 setCel: 1 setCycle: CT 14 1 self)
				(hector setLoop: 2 setCel: 1 setCycle: CT 14 1)
			)
			(1
				(proc4_5)
				(proc4_6 31505 -5 134 347 0 -1 1)
				(allen setCycle: End)
				(hector setCycle: End)
			)
			(2
				(hector dispose:)
			)
			(3
				(SetFlag 98)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gEgo awardMedal: 65)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shotPatAfterFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(allen setLoop: 2 setCel: 7 setCycle: End)
				(hector setLoop: 2 setCel: 7 setCycle: End)
				(proc4_5)
				(proc4_6 31503 -6 132 250 0 -1 1)
			)
			(1
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 65)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance hectorGetsShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 31511 -1 -1 self 1)
			)
			(1
				(if (not (global112 flashBanged:))
					(SetFlag 100)
					(SetFlag 93)
					(SetFlag 98)
					(gEgo awardMedal: 64)
				)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3200) ; s2_3200
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3170) ; s2_3170
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 3230) ; s2_3230
	)
)

(instance wood of View ; UNUSED
	(properties
		x 55
		y 141
		view 31504
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannister of Prop
	(properties)
)

(instance allen of Prop
	(properties
		x 63
		y 194
		view 31505
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(or
					(not (<= 104 (param1 x:) 146))
					(not (<= 150 (param1 y:) 203))
				)
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (global112 flashBanged:)
					(gCurRoom setScript: shotPatAfterFlash)
				else
					(gCurRoom setScript: shootPat)
				)
			)
			(6
				(if (global112 flashBanged:)
					(gCurRoom setScript: shotPatAfterFlash)
				else
					(gCurRoom setScript: shootPat)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties
		x 63
		y 194
		view 31506
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(or
					(not (<= 104 (param1 x:) 146))
					(not (<= 150 (param1 y:) 203))
				)
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: hectorGetsShot)
			)
			(6
				(gCurRoom setScript: hectorGetsShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

