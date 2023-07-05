;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3330)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	s2_3330 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s2_3330 of PQRoom
	(properties
		noun 5
		picture 3330
	)

	(method (init)
		(super init: &rest)
		(pitFeature init:)
		(robotFeature init:)
		(northE init:)
		(pit init:)
		(host init: hide:)
		((ScriptID 4054 0) changeMusic: 29806) ; kiplandRegion
		(self setScript: movieTrans)
	)

	(method (lashNotify)
		(if
			(and
				(proc4_11 21)
				(proc4_11 11)
				(== global149 2)
				(IsFlag 254)
				(== script flashRoomBPC)
			)
			(self setScript: notifyOfAllen)
			(return -2)
		else
			(return -1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(if (IsFlag 251)
					(self setScript: flashRoomAPC)
				else
					(self setScript: flashRoomBPC)
				)
			)
			(10
				(gMessager say: 4 10 4 1) ; "Hold your fire!!"
			)
			(6
				(if local2
					(self setScript: officerComingOut)
				else
					(gMessager say: 4 10 4 1) ; "Hold your fire!!"
					(++ local2)
				)
			)
			((OneOf theVerb 43 47 45 42 44 46 48 49)
				(if (not (IsFlag 251))
					(gMessager say: 0 theVerb 9 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 3360) (IsFlag 251) (not (global112 curColIdx:))) ; s2_3360
			(global112 startPath: 81 3330)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance movieTrans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 33310 33311)
				(= seconds 1)
			)
			(1
				(gGame handsOn:)
				(denton
					view: 33310
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 525 359
					setPri: 385
					init:
					setCycle: End self
				)
			)
			(2
				(denton setCycle: CT 40 -1 self)
			)
			(3
				(denton setCycle: ROsc -1 40 45 -1)
				(carmichael
					view: 33311
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 536 358
					setPri: 500
					init:
					setCycle: End self
				)
			)
			(4
				(gGame handsOff:)
				(Load rsVIEW 33320 33314 33315 33323)
				(gGame handsOn:)
				(carmichael dispose:)
				(wixell
					view: 33320
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 490 358
					setPri: 390
					init:
					setCycle: End self
				)
				(proc4_6 33330 294 100 0 0 400)
			)
			(5
				(gSwatInterface showHandAni: 4)
				(wixell setCycle: CT 18 -1 self)
			)
			(6
				(wixell setCycle: ROsc -1 18 22 -1)
				(Load rsVIEW 33321 33322)
			)
			(7
				(gGame handsOff:)
				(host setScript: wixSlicePit)
			)
			(8
				(gSwatInterface showHandAni: 3)
				(denton
					view: 33314
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 524 365
					setPri: 378
					setCycle: End
				)
			)
			(9
				(wixell setCycle: End)
			)
			(10
				(gGame handsOn:)
				(self setScript: pacmeyerMoves)
				(global112 startPath: 81 3330)
				(denton
					view: 33315
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 667 116
					setPri: 1
				)
				(wixell view: 33323 loop: 0 cel: 0 posn: 345 117 setPri: 350)
				(if (not gAutoRobot)
					(denton init:)
					(wixell init:)
					(proc4_6 33330 294 100 531 0 400)
				)
				(gAutoRobot caller: pacmeyerMoves)
				(denton setCycle: End)
				(wixell setCycle: CT 65 1 self)
			)
			(11
				(gMessager say: 0 0 2 1) ; "What are you waiting for? Come on!"
				(wixell setCycle: End self)
				(Load rsVIEW 33316 33324 33325)
			)
			(12
				(host setScript: dentonMoves)
				(wixell
					view: 33324
					cycleSpeed: 12
					cel: 0
					posn: 252 116
					setCycle: End self
				)
			)
			(13
				(wixell
					view: 33325
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 233 123
					setPri: 300
					setCycle: CT 25 1 self
				)
			)
			(14
				(wixell setPri: 1 posn: 216 108 setCycle: CT 44 1 self)
			)
			(15
				(wixell setCycle: ROsc -1 44 53)
			)
			(16
				(gGame handsOff:)
				(global112 stopPath:)
				(wixell setCycle: End self)
			)
			(17
				(wixell setCycle: CT 70 -1 self)
			)
			(18
				(wixell setCycle: ROsc -1 70 75)
				(Load rsVIEW 33317 33326)
			)
			(19
				(denton
					view: 33317
					cycleSpeed: 12
					posn: 440 180
					cel: 0
					setCycle: CT 29 1 self
				)
			)
			(20
				(denton setCycle: End self)
				(gFxSound number: 1002 loop: 1 play:)
			)
			(21
				(denton dispose:)
				(wixell
					view: 33326
					cycleSpeed: 6
					loop: 0
					cel: 0
					posn: 303 114
					setCycle: End self
				)
			)
			(22
				(wixell dispose:)
				(proc4_5)
				(proc4_6 33330 285 85 (+ local0 7) 0 200)
			)
			(23
				(proc4_5)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(24
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 97)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance pacmeyerMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gAutoRobot setPri: -1)
			)
			(2
				(proc4_5)
				(proc4_6 33330 285 85 764 0 210)
			)
			(3
				(gAutoRobot setPri: 200)
			)
			(4
				(if (< (client state:) 15)
					(-- state)
					(= cycles 1)
				else
					(client cue:)
				)
			)
			(5
				(if (< (client state:) 18)
					(-- state)
					(= cycles 1)
				else
					(= local0 (proc4_15))
					(client cue:)
					(self dispose:)
				)
			)
		)
	)
)

(instance wixSlicePit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wixell
					view: 33321
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 391 358
					setPri: 500
					setCycle: CT 15 1 self
				)
			)
			(1
				(wixell setPri: 350 setCycle: CT 35 1 self)
			)
			(2
				(gSwatInterface showHandAni: 6)
				(SetFlag 251)
				(wixell setCycle: End self)
			)
			(3
				(wixell
					view: 33322
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 381 305
					setCycle: ROsc -1 0 5
				)
				(self dispose:)
			)
		)
	)
)

(instance dentonMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(denton
					view: 33316
					cycleSpeed: 12
					cel: 0
					posn: 610 111
					setCycle: End self
				)
			)
			(1
				(denton setCycle: CT 84 -1 self)
			)
			(2
				(denton setCycle: ROsc -1 84 89)
				(self dispose:)
			)
		)
	)
)

(instance shootPit16 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global112 stopPath:)
				(= ticks 5)
			)
			(1
				(ricochet init:)
				(gFxSound number: 33300 loop: 1 play: self)
			)
			(2
				(gFxSound number: 3470 loop: 1 play:)
				(ricochet dispose:)
				(martinezShot init: setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 3350)
				(deadMartinez setPri: 1 init:)
				(= cycles 2)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(6
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29808 loop: 1 play: self)
				(gFxSound number: 2993 loop: 1 play:)
			)
			(7
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCurRoom drawPic: 3360)
				(deadMartinez dispose:)
				(allen view: 33603 loop: 0 cel: 0 posn: 24 238 setPri: 1 init:)
				(= cycles 2)
			)
			(8
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(9
				(allen setCycle: CT 18 1 self)
			)
			(10
				(allen setCycle: End self)
				(gFxSound number: 33603 loop: 1 play:)
				(gBackMusic2 number: 29808 loop: 1 play:)
			)
			(11
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(12
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootPit45 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global112 stopPath:)
				(Load rsVIEW 33327)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(= seconds 2)
			)
			(1
				(proc4_15)
				(gCast eachElementDo: #perform haltMyself)
				(gBackMusic2 number: 29808 loop: 1 play:)
				(gFxSound number: 33327 loop: 1 play:)
				(allenShootsYou init: setCycle: End self)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(4
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 96)
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
				(gGame handsOff:)
				(gMessager say: 4 10 5 0 self) ; "Hold your fire!!"
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance flashPit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global112 stopPath:)
				(flashBang2 init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(if (IsFlag 251)
					(groupStaggers init:)
				else
					((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
					(gBackMusic2 number: 29808 loop: 1 play:)
					(martinezFalls init: setCycle: End)
					(proc4_6 33302 180 83 0 0 400 1)
				)
				(= cycles 2)
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
				(if (IsFlag 251)
					(groupStaggers setCycle: End self)
				)
			)
			(6
				(global112 threwFlash: 3360)
				(if (IsFlag 251)
					(gCurRoom newRoom: 3360) ; s2_3360
				else
					(gCurRoom newRoom: 3350) ; s2_3350
				)
			)
		)
	)
)

(instance flashRoomBPC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global112 stopPath:)
				(flashBang setPri: 1 init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #hide)
				(flashBang dispose:)
				(runningArea init:)
				(proc4_6 33302 180 83 0 0 400 1 0)
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
				(gGame handsOn:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(allen
					view: 33313
					loop: 0
					cel: 0
					posn: 413 196
					setPri: 1
					init:
					setCycle: End self
				)
				(SetFlag 254)
			)
			(6
				(gGame handsOff:)
				(runningArea dispose:)
				(allen dispose:)
				(gMessager say: 0 0 1 4 self) ; "We all move together. Pup, Wixell, you take the right. Carmichael, Denton, you take the left. I'll go up the middle. Ready to move? Go!"
			)
			(7
				(global112 threwFlash: 3360)
				(gCurRoom newRoom: 3360) ; s2_3360
			)
		)
	)
)

(instance notifyOfAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 1)
				(proc4_15)
				(= cycles 2)
			)
			(1
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(proc4_5)
				(allen dispose:)
				(wixell
					view: 33308
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 333 264
					init:
				)
				(pacmeyer
					view: 33308
					cycleSpeed: 12
					loop: 1
					cel: 0
					posn: 404 249
					init:
				)
				(denton
					view: 33308
					cycleSpeed: 12
					loop: 2
					cel: 0
					posn: 620 210
					setPri: -1
					show:
				)
				(gGame showCloseUp: 33305 180 70 self)
			)
			(3
				(gGame handsOn:)
				(wixell setCycle: CT 15 1 self)
				(pacmeyer setCycle: End)
				(denton setCycle: End)
			)
			(4
				(wixell setPri: 200 setCycle: End self)
			)
			(5
				(gGame handsOff:)
				(gCast eachElementDo: #perform haltMyself)
				(gFxSound number: 35 loop: 1 play: self)
			)
			(6
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(7
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(8
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(9
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 97)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashRoomAPC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashBang setPri: 1 init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(groupStaggers init:)
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
				(groupStaggers setCycle: End self)
			)
			(6
				(gGame handsOff: showCloseUp: 33306 180 70 self 1)
			)
			(7
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
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
					(2
						(= temp0 9008)
					)
					(3
						(= temp0 9020)
					)
					(6
						(= temp0 9018)
					)
					(1
						(= temp0 9014)
					)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: temp0 180 70 self 1)
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

(instance northE of HotSpot
	(properties
		nsRight 165
		nsBottom 343
		type 4097
	)

	(method (doVerb)
		(cond
			(local3
				(global112 stopPath:)
				(gCurRoom newRoom: 3370) ; s2_3370
			)
			((IsFlag 251)
				(gCurRoom newRoom: 3360) ; s2_3360
			)
			(else
				(gCurRoom newRoom: 3390) ; s2_3390
			)
		)
	)
)

(instance pit of HotSpot
	(properties
		type 16385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 236 269 234 335 280 335 322 240 337 236 331
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 360 294 387 313 360 319 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not (IsFlag 251))
					(global112 leftEarly: 1)
				)
				(gCurRoom newRoom: 3350) ; s2_3350
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance runningArea of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 322 89 506 75 503 201 326 195
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if (IsFlag 254)
					(gCurRoom setScript: notifyOfAllen)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pitFeature of Feature
	(properties)

	(method (onMe param1)
		(return (pit onMe: param1))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(cond
					((not (IsFlag 251))
						(gCurRoom setScript: shootPit16)
					)
					(local1
						(gCurRoom setScript: officerComingOut)
					)
					(else
						(gMessager say: 4 10 4 0) ; "Hold your fire!!"
						(++ local1)
					)
				)
			)
			(6
				(gCurRoom setScript: shootPit45)
			)
			(16
				(gCurRoom setScript: flashPit)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1 &rest)) (== (param1 message:) 48))
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 6)
			)
			(10
				(gCurRoom setScript: officerShot 0 6)
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

(instance denton of Prop
	(properties
		noun 3
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 10 7)
			(gCurRoom setScript: officerShot 0 noun)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance carmichael of Prop
	(properties
		noun 2
	)

	(method (cue)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 10 7)
			(gCurRoom setScript: officerShot 0 noun)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance wixell of Prop
	(properties
		noun 1
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 10 7)
			(gCurRoom setScript: officerShot 0 noun)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pacmeyer of Prop
	(properties
		noun 6
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 10 7)
			(gCurRoom setScript: officerShot 0 noun)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance allen of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if (and (IsFlag 254) (== (gCurRoom script:) flashRoomBPC))
					(gCurRoom setScript: notifyOfAllen)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance allenShootsYou of Prop
	(properties
		x 318
		y 182
		view 33327
	)
)

(instance flashBang of Prop
	(properties
		x 363
		y 153
		view 33309
	)
)

(instance flashBang2 of Prop
	(properties
		x 272
		y 329
		view 33319
	)
)

(instance groupStaggers of Prop
	(properties
		x 234
		y 234
		view 33303
	)
)

(instance martinezFalls of Prop
	(properties
		x 197
		y 352
		view 33312
	)
)

(instance martinezShot of Prop
	(properties
		x 180
		y 354
		view 33318
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance deadMartinez of View
	(properties
		x 80
		y 330
		view 33501
	)
)

(instance ricochet of View
	(properties
		x 236
		y 236
		view 33318
		loop 1
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

(instance haltMyself of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #setCycle)
			(param1 setCycle: 0)
		)
	)
)

