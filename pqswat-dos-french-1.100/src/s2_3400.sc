;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3400)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Motion)
(use Actor)
(use System)

(public
	s2_3400 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance s2_3400 of PQRoom
	(properties
		picture 3400
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(robotFeature init:)
		(if (>= (global112 curColIdx:) 23)
			(self setScript: approachDoor)
		)
		(gGame handsOn:)
	)

	(method (criticalAlert)
		(if (and (== (global112 curColIdx:) 23) (not script))
			(self setScript: approachDoor)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(6
				(gMessager say: 4 theVerb) ; "Hold your fire!!"
			)
			(10
				(if local0
					(self setScript: officerComingOut)
				else
					(gMessager say: 4 theVerb 5) ; "Hold your fire!!"
					(++ local0)
				)
			)
			(16
				(gCurRoom setScript: throwFlash)
			)
			(43
				(if (>= (++ local2) 2)
					(self setScript: gettingTiredOfThis)
				else
					(wixell setScript: doCloseUp 0 34005)
				)
			)
			(44
				(wixell setScript: doCloseUp 0 34004)
			)
			(45
				(if (>= (++ local1) 2)
					(self setScript: officerComingOut 0 34003)
				else
					(wixell setScript: doCloseUp 0 34002)
				)
			)
			(49
				(if (>= (++ local3) 2)
					(self setScript: gettingTiredOfThis)
				else
					(wixell setScript: doCloseUp 0 34005)
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
				(switch (global112 curColIdx:)
					(23
						(= local4 (global112 getPercent: 0 134))
					)
				)
				(wixell view: 34020 loop: 0 posn: 629 208)
				(denton view: 34010 loop: 0 setPri: 1 posn: 628 268)
				(cond
					((not local4)
						(= register 34030)
						(= local4 0)
						(wixell cel: 0 setPri: 450)
						(denton cel: 0)
					)
					((<= local4 79)
						(= register 34030)
						(= local4 (Min 50 local4))
						(wixell cel: 13 setPri: 450)
						(denton cel: 10)
					)
					((<= 80 local4 94)
						(= register 34031)
						(-= local4 80)
						(wixell cel: 35 setPri: 266)
						(denton cel: 36)
					)
					((>= local4 95)
						(= register 34031)
						(= local4 (Min (- local4 80) 15))
						(wixell cel: 56 setPri: 266)
						(denton cel: 63)
					)
				)
				(wixell init:)
				(denton init:)
				(if (< (wixell cel:) 13)
					(wixell setCycle: CT 13 1)
				else
					(wixell setCycle: End)
					(denton setCycle: End)
				)
				(if (> local4 60)
					(= state 1)
				)
				(proc4_6 register 303 115 local4 0 -1 1)
			)
			(1
				(wixell setCycle: CT 25 1 self)
				(denton setCycle: End)
			)
			(2
				(wixell setPri: 266 setCycle: End self)
			)
			(3
				(switch register
					(34030
						(= register 34031)
						(-- state)
					)
					(34031
						(gGame handsOff:)
						(= register 34032)
					)
					(else
						(= register 0)
					)
				)
				(if register
					(proc4_6 register 303 115 0 0 -1 1)
				else
					(= cycles 1)
				)
			)
			(4
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance throwFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashBang init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
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
				(gCurRoom setScript: officerComingOut)
			)
		)
	)
)

(instance officerShot of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch register
					(robotFeature
						(= temp0 9012)
					)
					(wixell
						(= temp0 9014)
					)
					(denton
						(= temp0 9020)
					)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: temp0 180 70 self 1)
			)
			(1
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if register
					(= temp0 register)
				else
					(= temp0 34001)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: temp0 180 70 self 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance doCloseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame
					handsOff:
					saveRobot: 1
					showCloseUp: register 180 70 self
				)
			)
			(1
				(gGame saveRobot: 0 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gettingTiredOfThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 34006 180 70 self)
			)
			(1
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
		(if (< (wixell cel:) 37)
			(global112 leftEarly: 1)
		)
		(gCurRoom newRoom: 3410) ; s2_3410
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 self)
			)
			(10
				(gCurRoom setScript: officerShot 0 self)
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

(instance wixell of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 self)
				(return 1)
			)
			(10
				(gCurRoom setScript: officerShot 0 self)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 self)
				(return 1)
			)
			(10
				(gCurRoom setScript: officerShot 0 self)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 485
		y 305
		view 34007
	)
)

