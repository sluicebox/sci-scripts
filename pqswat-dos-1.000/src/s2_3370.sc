;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3370)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3370 0
)

(local
	local0
	local1
)

(instance s2_3370 of PQRoom
	(properties
		picture 3370
	)

	(method (init)
		(super init: &rest)
		(robotFeat init:)
		(cond
			((== gPrevRoomNum 3330) ; s2_3330
				(Load rsVIEW 33710)
				(Load rsVIEW 6)
				(self setScript: flashCont)
			)
			((>= (global112 curColIdx:) 22)
				(northE init:)
				(doorE init:)
				(self setScript: approachDoor)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (criticalAlert)
		(if (and (== (global112 curColIdx:) 22) (not script))
			(self setScript: approachDoor)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (== script approachDoor)
					(if local0
						(self setScript: officerComingOut)
					else
						(gMessager say: 4 theVerb 4) ; "Hold your fire!"
						(++ local0)
					)
				)
			)
			(6
				(if (== script approachDoor)
					(gMessager say: 4 theVerb) ; "Hold your fire!"
				)
			)
			(16
				(if (== script approachDoor)
					(gCurRoom setScript: flashRoom)
				else
					(gCurRoom setScript: flashAtPat)
				)
			)
			(42
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "What is it, pup?"
				)
			)
			(43
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "What is it, pup?"
				)
			)
			(44
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "Cover down range, pup."
				else
					(gMessager say: 0 theVerb 8) ; "Roger that!"
				)
			)
			(45
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "Negative! Move up!"
				)
			)
			(46
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "Stay calm, pup."
				)
			)
			(47
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "Unconfirmed..."
				)
			)
			(48
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "Unconfirmed, identify..."
				)
			)
			(49
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 7) ; "Negative. Cover down range."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance approachDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(switch (global112 curColIdx:)
					(22
						(= local1 (global112 getPercent: 0 125))
					)
					(23
						(gGame handsOff:)
						(= local1 (global112 getPercent: 126 396))
					)
				)
				(if (> local1 125)
					(gGame handsOff:)
					(= state 1)
				)
				(if (> local1 337)
					(gGame handsOff:)
					(= state 3)
				)
				(proc4_6 33704 52 27 local1 0 -1 1)
			)
			(1
				(gGame handsOff:)
			)
			(2
				(gFxSound number: 1004 loop: 1 play: self)
			)
			(3
				(gFxSound number: 1002 loop: 1 play:)
			)
			(4
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(5
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 97)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashCont of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 33700 14 0 0 0 -1 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(allen
					view: 33710
					loop: 0
					cel: 0
					posn: 339 199
					setPri: 1
					init:
					setCycle: CT 7 1 self
				)
			)
			(2
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: End)
			)
			(3
				(gGame handsOn:)
			)
			(4
				(proc4_5)
				(proc4_6 33706 14 0 0 0 -1 1)
				(self setScript: allenRandomShooting)
			)
			(5
				(self setScript: allenRandomShooting self 1)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)

	(method (dispose)
		(if script
			(script caller: 0)
		)
		(super dispose: &rest)
	)
)

(instance allenRandomShooting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(switch (Random 0 2)
						(0
							(self setScript: allenShot0 self)
						)
						(1
							(self setScript: allenShot1 self)
						)
						(2
							(self setScript: allenShot2 self)
						)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (not register)
					(= state -1)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOff:)
				(allen setLoop: 3 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 7 1 self)
			)
			(4
				(gFxSound number: 35 loop: 1 play: self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance allenShot0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setLoop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(1
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: End self)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance allenShot1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setLoop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(1
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: End self)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance allenShot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setLoop: 2 cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: End self)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance allenShotCU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 33605 180 70 self 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 3450 loop: 1 play: self)
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashAtPat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashBang init: setCycle: End self)
				(gFxSound number: 1003 loop: 1 play:)
			)
			(1
				(gFxSound number: 1002 loop: 1 play: self)
				(whiteScreen init:)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(allen view: 33701 loop: 0 cel: 0 posn: 413 183 init:)
				(UpdateScreenItem allen)
				(WalkieTalkie showFrame: 33701 0 100 95)
				(= global128 33701)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(proc4_6 33701 100 95 0 0 -1 1)
				(gBackMusic2 number: 29808 loop: 1 play:)
			)
			(6
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashBang init: setCycle: End self)
				(gFxSound number: 1003 loop: 1 play:)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(proc4_5)
				(gGame handsOff: showCloseUp: 33306 180 70 self 1)
			)
			(6
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance officerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: showCloseUp: 9012 180 70 self 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 0 stop:)
				(gBackMusic2 number: 29808 loop: 1 play:)
				(gMessager say: 1 10 0 1 self) ; "Cease fire! Cease fire!"
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance officerComingOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(proc4_5)
				(gGame handsOff: showCloseUp: 33306 180 70 self 1)
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
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
		(gCurRoom newRoom: 3400) ; s2_3400
	)
)

(instance doorE of HotSpot
	(properties
		nsLeft 382
		nsTop 76
		nsRight 451
		nsBottom 204
		type 4097
	)

	(method (doVerb)
		(if (and gAutoRobot (== (gAutoRobot robot:) 33704) (> (- (Robot 11) 1) 117)) ; FrameNum
			(global112 leftEarly: 1)
		)
		(gCurRoom newRoom: 3410) ; s2_3410
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1 &rest))
				(> (Robot 11) 87) ; FrameNum
				(> (param1 x:) 370)
				(== (gCurRoom script:) approachDoor)
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot)
			)
			(10
				(gCurRoom setScript: officerShot)
			)
			(180
				(super doVerb: theVerb)
			)
			(179
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance allen of Prop
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1 &rest))
				(== priority 1)
				(or (< (param1 x:) 382) (> (param1 x:) 393))
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: allenShotCU)
			)
			(10
				(gCurRoom setScript: allenShotCU)
			)
			(16
				(gCurRoom setScript: flashAtPat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 475
		y 200
		view 33702
	)
)

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

