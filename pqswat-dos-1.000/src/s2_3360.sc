;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3360)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use ROsc)
(use Motion)
(use Actor)
(use System)

(public
	s2_3360 0
)

(local
	local0
	local1
	local2
)

(instance s2_3360 of PQRoom
	(properties
		picture 3360
	)

	(method (init)
		(super init: &rest)
		(robotFeature init:)
		(switch gPrevRoomNum
			(3330 ; s2_3330
				(cond
					((global112 flashBanged:)
						(Load rsAUDIO 2991)
						(Load rsVIEW 33602)
						(= local0 1)
						(if (IsFlag 251)
							(self setScript: flashContAPC)
						else
							(self setScript: flashContBPC)
						)
					)
					((>= (global112 curColIdx:) 21)
						(northE init:)
						(doorE init:)
						(self setScript: approachDoor)
					)
					(else
						(gGame handsOn:)
					)
				)
			)
			(3350 ; s2_3350
				(Load rsAUDIO 2991)
				(Load rsVIEW 33602)
				(= local0 1)
				(self setScript: flashContAPC)
			)
		)
	)

	(method (criticalAlert)
		(if (and (== (global112 curColIdx:) 21) (not script))
			(self setScript: approachDoor)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(6
				(if (not local0)
					(gMessager say: 4 theVerb) ; "Hold your fire!!"
				)
			)
			(10
				(if (not local0)
					(if local1
						(self setScript: officerComingOut)
					else
						(gMessager say: 4 theVerb 8) ; "Hold your fire!!"
						(++ local1)
					)
				)
			)
			(16
				(if local0
					(gCurRoom setScript: flashAtPat)
				else
					(gCurRoom setScript: flashAtRoom)
				)
			)
			(42
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "What is it, pup?"
				)
			)
			(43
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "What is it, pup?"
				)
			)
			(44
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "Cover down range, pup."
				else
					(gMessager say: 0 theVerb 12) ; "Roger that!"
				)
			)
			(45
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "Negative! Move up!"
				)
			)
			(46
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "Stay calm, pup."
				)
			)
			(47
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "Unconfirmed..."
				)
			)
			(48
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "Unconfirmed, identify..."
				)
			)
			(49
				(if (== script approachDoor)
					(gMessager say: 0 theVerb 11) ; "Negative. Cover down range."
				)
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

(instance approachDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(switch (global112 curColIdx:)
					(21
						(gGame handsOn:)
						(= local2 (global112 getPercent: 0 95))
					)
					(22
						(= local2 (global112 getPercent: 96 220))
					)
					(23
						(= local2 (global112 getPercent: 221 484))
					)
				)
				(if (> local2 220)
					(gGame handsOff:)
					(= state 1)
				)
				(if (> local2 425)
					(gGame handsOff:)
					(= state 3)
				)
				(proc4_6 33607 127 70 local2 0 -1 1)
			)
			(1
				(gGame handsOff:)
			)
			(2
				(gFxSound number: 1004 setLoop: 1 play: self)
			)
			(3
				(gFxSound number: 1002 setLoop: 1 play:)
			)
			(4
				(Palette 2 0 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(5
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(6
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 97)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashContBPC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 33600 113 98 0 0 -1 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(allen
					view: 33610
					loop: 0
					cel: 0
					posn: 350 210
					setPri: 1
					init:
					setCycle: CT 15 1 self
				)
			)
			(2
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 30 1)
			)
			(3
				(gGame handsOn:)
			)
			(4
				(gMessager say: 0 0 3 1 self) ; "I want you to all back off! I mean it! I'll kill you all!"
			)
			(5
				(allen cel: 31 setCycle: CT 39 1 self)
			)
			(6
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 60 1)
			)
			(7
				(allen cel: 61 setCycle: CT 66 1 self)
			)
			(8
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 80 1)
			)
			(9
				(allen cel: 31 setCycle: CT 39 1 self)
			)
			(10
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 60 1)
			)
			(11
				(allen cel: 61 setCycle: CT 66 1 self)
			)
			(12
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 80 1)
			)
			(13
				(allen setCycle: CT 86 1 self)
			)
			(14
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 89 1 self)
			)
			(15
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 91 1 self)
			)
			(16
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: End self)
			)
			(17
				(gCurRoom setScript: playerKilled)
			)
		)
	)
)

(instance flashContAPC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 33601 66 88 0 0 300 1)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(allen
					view: 33611
					loop: 0
					cel: 0
					posn: 368 222
					init:
					setCycle: CT 3 1 self
				)
			)
			(1
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 11 1 self)
			)
			(2
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 19 1 self)
			)
			(3
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 80 1)
			)
			(4
				(gGame handsOn:)
			)
			(5
				(allen cel: 21 setCycle: CT 17 -1 self)
			)
			(6
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 9 -1)
			)
			(7
				(allen cel: 9 setCycle: CT 11 1 self)
			)
			(8
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 21 1 self)
			)
			(9
				(allen setCycle: ROsc -1 40 70 1)
			)
			(10
				(allen cel: 21 setCycle: CT 17 -1 self)
			)
			(11
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 9 -1)
			)
			(12
				(allen setCycle: CT 7 -1 self)
			)
			(13
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 3 -1 self)
			)
			(14
				(allen setCycle: End)
				(gMessager say: 0 0 2 1 self) ; "Back off! I'll shoot! I'll kill you all!"
			)
			(15
				(gCurRoom setScript: playerKilled)
			)
		)
	)
)

(instance playerKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Palette 2 0 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(1
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(flashBang setPri: 1 init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(whiteScreen init:)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(allen view: 33602 loop: 0 cel: 0 posn: 410 225 init:)
				(UpdateScreenItem allen)
				(pacmeyer
					view: 33602
					loop: 1
					cel: 0
					posn: 190 280
					setPri: 300
					init:
				)
				(= cycles 1)
			)
			(2
				(whiteScreen dispose:)
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
				(gBackMusic2 number: 29808 loop: 1 play:)
				(pacmeyer setCycle: End self)
				(gMessager say: 0 16 0 1) ; "Pacmeyer to Ten David. We have shots fired. Suspect down; wound self inflicted. We still must clear location..."
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

(instance flashAtRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashBang setPri: 1 init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 1000) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
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

(instance allenKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: showCloseUp: 33605 180 70 self 1)
			)
			(1
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

(instance robotShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 9012 180 70 self 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 0 stop:)
				(gBackMusic2 number: 29808 loop: 1 play: self)
				(gMessager say: 1 10 0 1) ; "Cease fire! Cease fire!"
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
		(gCurRoom newRoom: 3370) ; s2_3370
	)
)

(instance doorE of HotSpot
	(properties
		nsLeft 379
		nsTop 101
		nsRight 437
		nsBottom 199
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3410) ; s2_3410
	)
)

(instance allen of Prop
	(properties)

	(method (onMe param1 &tmp temp0)
		(return
			(and
				(super onMe: param1)
				(or
					(and
						(!= priority 1)
						(or (< (param1 x:) 309) (< 359 (param1 x:) 378))
					)
					(> 426 (param1 x:) 401)
					(> (param1 x:) 458)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 10 6)
			(gCurRoom setScript: allenKilled)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1 &rest)) (not local0))
			(cond
				((and (< (Robot 11) 100) (< (param1 x:) 250)) ; FrameNum
					(= temp0 1)
				)
				((and (> (Robot 11) 100) (< (param1 x:) 200)) ; FrameNum
					(= temp0 1)
				)
				((> (param1 x:) 360)
					(= temp0 1)
				)
				(else
					(= temp0 0)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: robotShot)
			)
			(10
				(gCurRoom setScript: robotShot)
			)
			(16
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties)
)

(instance flashBang of Prop
	(properties
		x 410
		y 300
		view 33604
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

