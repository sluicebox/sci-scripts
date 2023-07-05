;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7500)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use newYorkRegion)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)

(public
	octoCistern 0
	fountainSnd 1
)

(local
	local0
	local1
)

(instance octoCistern of Location
	(properties)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(switch gPrevRoomNum
			(7401 ; octoMoCistern
				(self addPicObj: faceGate faceCistern faceMo faceHD faceGate)
				(cond
					(local1
						(return)
					)
					((> global258 5)
						(= gSound
							((Sound new:)
								loop: -1
								owner: global122
								number: 7505
								play:
								yourself:
							)
						)
					)
					((< 0 global258 5)
						(= gSound
							((Sound new:)
								loop: -1
								owner: global122
								number: 7504
								play:
								yourself:
							)
						)
					)
					(gSound
						(= gSound 0)
					)
				)
			)
			(7501 ; octoCisMO
				(if (== global164 270)
					(self
						addPicObj:
							faceCistern
							faceMo
							faceHD
							faceGate
							faceCistern
					)
				else
					(self
						addPicObj: faceGate faceCistern faceMo faceHD faceGate
					)
				)
			)
			(7506 ; octoCisHDCU
				(self addPicObj: faceHD faceGate faceCistern faceMo faceHD)
			)
			(7509 ; octoCisUniformCU
				(self addPicObj: faceHD faceGate faceCistern faceMo faceHD)
			)
			(7502 ; octoCisternGate
				(self addPicObj: faceMo faceHD faceGate faceCistern faceMo)
			)
			(else
				(self addPicObj: faceGate faceCistern faceMo faceHD faceGate)
			)
		)
	)

	(method (yaw param1)
		(super yaw: param1 &rest)
	)

	(method (serialize param1)
		(= local1 param1)
		(super serialize: param1)
	)
)

(instance hiddenDoor of Sound
	(properties
		number 7501
		flags 5
	)
)

(instance buttonDownSnd of Sound
	(properties
		number 7503
		flags 5
	)
)

(instance fountainSnd of Sound
	(properties
		flags 5
	)
)

(instance faceHD of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(hiddenDoor_180 init:)
		(if (== global258 3)
			(hiddenDoor_180 case: 2)
			(if (IsFlag 199)
				(= picture 7522)
			else
				(= picture 7515)
			)
		else
			(hiddenDoor_180 case: 1)
			(if (IsFlag 199)
				(= picture 7521)
			else
				(= picture 7505)
			)
		)
		(exitToHD init:)
		(uniform init:)
		(isaUniform_180 init:)
		(decryptionCard init: global117)
		(dataCube9 init: global117)
		(dataCube10 init: global117)
		(dataCube11 init: global117)
		(super init:)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 270
		picture 7503
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(exitToGate init:)
	)
)

(instance faceCistern of CameraAngle
	(properties
		picture 7506
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(music1Key init: global117)
		(music2Key init: global117)
		(music3Key init: global117)
		(music4Key init: global117)
		(count0Key init: global117)
		(count1Key init: global117)
		(count2Key init: global117)
		(count3Key init: global117)
		(count4Key init: global117)
		(count5Key init: global117)
		(count6Key init: global117)
		(count7Key init: global117)
		(fountains_0 init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose:)
	)
)

(instance faceMo of CameraAngle
	(properties
		heading 90
		picture 7504
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMo init:)
		(gCurRoom exitN: exitToMo)
		(super init:)
	)
)

(instance exitToMo of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7401
		exitStyle 256
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 9) gSound)
			(gSound dispose:)
			(= gSound 0)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance exitToGate of Feature
	(properties
		nsBottom 226
		nsLeft 152
		nsRight 421
		nsTop 131
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7502) ; octoCisternGate
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uniform of Feature
	(properties)

	(method (init)
		(if (IsFlag 199)
			(self nsLeft: 68 nsTop: 235 nsRight: 179 nsBottom: 270)
		else
			(self nsLeft: 97 nsTop: 231 nsRight: 191 nsBottom: 270)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7509) ; octoCisUniformCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToHD of Feature
	(properties
		nsBottom 187
		nsLeft 247
		nsRight 345
		nsTop 69
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7506) ; octoCisHDCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class CisternKey of View
	(properties
		number 0
		view 7500
		upCel 0
		downCel 0
		theShow 0
	)

	(method (init)
		(&= signal $efff)
		(if (== global258 (self number:))
			(= cel downCel)
			(if ((self theShow:) robot:)
				((self theShow:) setUpLoop: play:)
			)
			(= local0 self)
		else
			(= cel upCel)
		)
		(super init: global117 &rest)
		(self setHotspot: 2 144)
	)

	(method (cue)
		(if
			(and
				local0
				(or (!= local0 self) (!= (local0 cel:) (local0 upCel:)))
			)
			(local0 startPlaying:)
		else
			(= local0 0)
			(= global258 0)
		)
	)

	(method (startPlaying)
		(theShow init: 1 0 play:)
		(if (not gSound)
			(= gSound (Sound new:))
		)
		(cond
			((> (self number:) 5)
				(gSound
					loop: -1
					number: 7505
					owner: global122
					play: 0 0
					fade: 127 10 10 0
				)
			)
			((< 0 (self number:) 5)
				(gSound
					loop: -1
					number: 7505
					owner: global122
					play: 0 0
					fade: 127 10 10 0
				)
			)
		)
	)

	(method (stopPlaying)
		(theShow stop: self 1)
		(if gSound
			(gSound fade: 0 10 10 1)
			(= gSound 0)
		)
	)

	(method (depress &tmp temp0)
		(= temp0 local0)
		(= local0 self)
		(= global258 (self number:))
		(cond
			(temp0
				(if
					(SetFlag
						(switch number
							(1 200)
							(2 201)
							(3 202)
							(4 203)
							(5 204)
							(6 205)
							(7 206)
							(8 207)
							(9 208)
							(10 209)
							(11 210)
							(12 211)
						)
					)
					(proc201_1 9)
				)
				(temp0 up:)
			)
			((not (theShow isPlaying:))
				(self startPlaying:)
			)
		)
		(= cel downCel)
		(buttonDownSnd play:)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (up)
		(self cel: upCel)
		(if (== local0 self)
			(= local0 0)
			(= global258 0)
		)
		(UpdateScreenItem self)
		(FrameOut)
		(self stopPlaying:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gTheCursor isInvCursor:)
						(== 114 (proc70_7 (gTheCursor invItem:)))
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (!= cel upCel)
					(self up:)
				else
					(self depress:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance decryptionCard of View
	(properties
		x 112
		y 235
		cel 2
		view 7521
	)

	(method (init)
		(if
			(and
				(== (proc70_9 32) 7509)
				(== (proc70_9 31) 2005)
				(IsFlag 199)
			)
			(super init: global117)
		)
	)
)

(instance dataCube9 of View
	(properties
		x 101
		y 237
		view 7521
	)

	(method (init)
		(if (and (== (proc70_9 23) 7509) (IsFlag 199))
			(super init: global117)
		)
	)
)

(instance dataCube10 of View
	(properties
		x 107
		y 236
		cel 1
		view 7521
	)

	(method (init)
		(if (and (== (proc70_9 24) 7509) (IsFlag 199))
			(super init: global117)
		)
	)
)

(instance dataCube11 of View
	(properties
		x 122
		y 234
		cel 3
		view 7521
	)

	(method (init)
		(if (and (== (proc70_9 25) 7509) (IsFlag 199))
			(super init: global117)
		)
	)
)

(instance music1Key of CisternKey
	(properties
		noun 38
		x 24
		y 240
		number 1
		downCel 1
	)

	(method (init)
		(self theShow: music1)
		(super init: &rest)
	)

	(method (depress)
		(if (not (SetFlag 198))
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7200)
		)
		(super depress: &rest)
	)
)

(instance music2Key of CisternKey
	(properties
		noun 38
		x 43
		y 239
		number 2
		downCel 2
	)

	(method (init)
		(self theShow: music2)
		(super init: &rest)
	)

	(method (depress)
		(if (not (SetFlag 198))
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7200)
		)
		(super depress: &rest)
	)
)

(instance music3Key of CisternKey
	(properties
		noun 38
		x 61
		y 237
		number 3
		downCel 3
	)

	(method (init)
		(self theShow: music3)
		(super init: &rest)
	)

	(method (stopPlaying)
		(hiddenDoor play:)
		(super stopPlaying: &rest)
	)

	(method (startPlaying)
		(super startPlaying: &rest)
	)

	(method (depress)
		(hiddenDoor play:)
		(if (not (SetFlag 198))
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7200)
		)
		(super depress: &rest)
	)
)

(instance music4Key of CisternKey
	(properties
		noun 38
		x 79
		y 237
		number 4
		downCel 4
	)

	(method (init)
		(self theShow: music4)
		(super init: &rest)
	)

	(method (depress)
		(if (not (SetFlag 198))
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7200)
		)
		(super depress: &rest)
	)
)

(instance count0Key of CisternKey
	(properties
		x 232
		y 236
		number 5
		downCel 5
	)

	(method (init)
		(self theShow: count0)
		(super init: &rest)
	)

	(method (startPlaying))

	(method (stopPlaying)
		(self cue:)
	)
)

(instance count1Key of CisternKey
	(properties
		noun 39
		x 248
		y 235
		number 6
		downCel 6
	)

	(method (init)
		(self theShow: count1)
		(super init: &rest)
	)
)

(instance count2Key of CisternKey
	(properties
		noun 39
		x 264
		y 235
		number 7
		downCel 7
	)

	(method (init)
		(self theShow: count2)
		(super init: &rest)
	)
)

(instance count3Key of CisternKey
	(properties
		noun 39
		x 280
		y 235
		number 8
		downCel 8
	)

	(method (init)
		(self theShow: count3)
		(super init: &rest)
	)
)

(instance count4Key of CisternKey
	(properties
		noun 39
		x 295
		y 235
		number 9
		downCel 9
	)

	(method (init)
		(self theShow: count4)
		(super init: &rest)
	)
)

(instance count5Key of CisternKey
	(properties
		noun 39
		x 312
		y 235
		number 10
		downCel 10
	)

	(method (init)
		(self theShow: count5)
		(super init: &rest)
	)
)

(instance count6Key of CisternKey
	(properties
		noun 39
		x 326
		y 233
		number 11
		downCel 11
	)

	(method (init)
		(self theShow: count6)
		(super init: &rest)
	)
)

(instance count7Key of CisternKey
	(properties
		noun 39
		x 343
		y 232
		number 12
		downCel 12
	)

	(method (init)
		(self theShow: count7)
		(super init: &rest)
	)
)

(instance music1 of RobotPlayer
	(properties
		robot 7503
		startRobot 7502
		endRobot 7504
		robotX 151
		robotY 50
	)
)

(instance music2 of RobotPlayer
	(properties
		robot 7506
		startRobot 7505
		endRobot 7507
		robotX 216
		robotY 55
	)
)

(instance music3 of RobotPlayer
	(properties
		robot 7509
		startRobot 7508
		endRobot 7510
		robotX 272
		robotY 56
	)
)

(instance music4 of RobotPlayer
	(properties
		robot 7512
		startRobot 7511
		endRobot 7513
		robotX 343
		robotY 54
	)
)

(instance count0 of RobotPlayer
	(properties)
)

(instance count1 of RobotPlayer
	(properties
		robot 7515
		startRobot 7514
		endRobot 7516
		robotX 374
		robotY 109
	)
)

(instance count2 of RobotPlayer
	(properties
		robot 7518
		startRobot 7517
		endRobot 7519
		robotX 185
		robotY 109
	)
)

(instance count3 of RobotPlayer
	(properties
		robot 7521
		startRobot 7520
		endRobot 7522
		robotX 310
		robotY 109
	)
)

(instance count4 of RobotPlayer
	(properties
		robot 7524
		startRobot 7523
		endRobot 7525
		robotX 185
		robotY 109
	)
)

(instance count5 of RobotPlayer
	(properties
		robot 7527
		startRobot 7526
		endRobot 7528
		robotX 248
		robotY 109
	)
)

(instance count6 of RobotPlayer
	(properties
		robot 7530
		startRobot 7529
		endRobot 7531
		robotX 185
		robotY 109
	)
)

(instance count7 of RobotPlayer
	(properties
		robot 7533
		startRobot 7532
		endRobot 7534
		robotX 185
		robotY 109
	)
)

(instance isaUniform_180 of Feature
	(properties
		noun 40
		nsBottom 249
		nsLeft 97
		nsRight 175
		nsTop 231
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance fountains_0 of Feature
	(properties
		noun 37
		nsBottom 208
		nsLeft 175
		nsRight 413
		nsTop 110
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hiddenDoor_180 of Feature
	(properties
		noun 34
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 65 324 66 341 116 326 169 270 167 256 111 273 65
					yourself:
				)
		)
	)
)

