;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use LightRoom)
(use Stem)
(use TrackingProp)
(use Plane)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm880 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 3
	local7
	local8
	local9
	local10
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 0)
	(= temp1 0)
	(if (and (not (IsFlag 342)) (not (IsFlag 336)) (IsFlag 341))
		(= temp0 1)
	)
	(if (and (not (IsFlag 340)) (not (IsFlag 335)) (IsFlag 338))
		(= temp1 1)
	)
	(cond
		((and temp0 temp1)
			(theClamp setCel: 3 doit:)
			(if (not (IsFlag 334))
				(theDevice setCel: 3 doit:)
			)
		)
		(temp0
			(theClamp setCel: 1 doit:)
			(if (not (IsFlag 334))
				(theDevice setCel: 1 doit:)
			)
		)
		(temp1
			(theClamp setCel: 2 doit:)
			(if (not (IsFlag 334))
				(theDevice setCel: 2 doit:)
			)
		)
		(else
			(theClamp setCel: 0 doit:)
			(if (not (IsFlag 334))
				(theDevice setCel: 0 doit:)
			)
		)
	)
)

(instance rm880 of LightRoom
	(properties
		picture -2
		compassDir 1
	)

	(method (init)
		(Lock rsAUDIO 890 1)
		(Lock rsAUDIO 891 1)
		(Lock rsAUDIO 892 1)
		(= local0 (gThePlane priority:))
		(gBackMusic number: 8100 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(backPlane
			picture: -2
			priority: (- ((ScriptID 9 1) priority:) 1) ; PlInterface
			init:
			setBitmap: 4823 0 0
			setRect: 222 80 423 336
			addCast: (backCast plane: backPlane yourself:)
		)
		(vent0 init: backCast setCycle: Fwd x: 1000)
		(vent1 init: backCast setCycle: Fwd x: 1000)
		(valve0 init: backCast)
		(valve1 init: backCast)
		(valve2 init: backCast)
		(valve3 init: backCast)
		(valve4 init: backCast)
		(valve5 init: backCast)
		(valve6 init: backCast)
		(valve7 init: backCast)
		(if (not (IsFlag 335))
			(valve0 setCel: 10)
		)
		(if (not (IsFlag 336))
			(valve1 setCel: 10)
		)
		(if (IsFlag 337)
			(valve2 setCel: 10)
		)
		(if (not (IsFlag 338))
			(vent1 x: 120)
			(valve3 setCel: 10)
		)
		(if (IsFlag 339)
			(valve4 setCel: 10)
		)
		(if (not (IsFlag 340))
			(valve5 setCel: 10)
		)
		(if (not (IsFlag 341))
			(vent0 x: 18)
			(valve6 setCel: 10)
		)
		(if (not (IsFlag 342))
			(valve7 setCel: 10)
		)
		(gThePlane priority: (+ (backPlane priority:) 1))
		(planeView init: setPri: 10)
		(robotLever
			addStem:
				890
				2
				105
				94
				-1
				19200
				-29
				20
				-33
				20
				-39
				21
				-43
				21
				-48
				20
				-53
				20
				-58
				20
				-62
				19
				-67
				18
				-71
				19
				-74
				18
			addStem:
				890
				3
				105
				94
				-1
				19712
				-28
				20
				-22
				19
				-17
				19
				-10
				19
				-4
				18
				1
				17
				8
				15
				13
				17
				18
				16
				26
				16
			addStem:
				890
				4
				104
				94
				-1
				-1
				-27
				20
				-28
				17
				-29
				11
				-30
				7
				-31
				2
				-31
				-2
				-32
				-7
				-32
				-12
				-33
				-16
				-34
				-22
			addStem:
				890
				5
				105
				94
				-1
				-1
				-28
				20
				-27
				24
				-26
				28
				-25
				32
				-24
				36
				-23
				39
				-22
				43
				-20
				46
				-19
				49
				-17
				53
		)
		(pSphereLever
			init:
			setPri: 300
			setPoints:
				-51
				20
				-51
				17
				-51
				14
				-51
				11
				-51
				9
				-51
				6
				-51
				3
				-51
				0
				-50
				-3
				-49
				-5
				-49
				-7
				-48
				-10
				-47
				-12
				-46
				-15
				-45
				-18
				-43
				-20
		)
		(pSpinnerControl
			init:
			setPri: 300
			setPoints:
				13
				7
				13
				7
				14
				6
				15
				5
				15
				3
				15
				1
				15
				-1
				14
				-4
				13
				-6
				12
				-8
				10
				-9
				9
				-10
				6
				-11
				3
				-12
				0
				-12
				-2
				-11
				-4
				-11
				-5
				-10
				-6
				-9
				-6
				-8
				-7
				-8
		)
		(= local10 (pSpinnerControl cel:))
		(pRobotArm init: setPri: 7)
		(pSpinner init: hide: setPri: 3)
		(indicator init: hide:)
		(theClamp init: backCast)
		(if (not (IsFlag 334))
			(theDevice init: backCast setPri: (+ (theClamp priority:) 1))
		)
		(localproc_0)
		(UpdatePlane backPlane)
		(gGame handsOn:)
		(super init: &rest)
		((ScriptID 1 7) newRoom: 870) ; exitBackUp
		(localSound number: 888 setLoop: 1 play:)
	)

	(method (notify)
		(robotLever dispose:)
	)

	(method (dispose &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 0)
		(if (IsFlag 337)
			(++ temp0)
		)
		(if (IsFlag 342)
			(++ temp0)
		)
		(if (and (IsFlag 341) (IsFlag 336))
			(++ temp0)
		)
		(if (>= temp0 2)
			(ClearFlag 275)
		else
			(SetFlag 275)
		)
		(if (IsFlag 340)
			(++ temp1)
		)
		(if (IsFlag 339)
			(++ temp1)
		)
		(if (and (IsFlag 338) (IsFlag 335))
			(++ temp1)
		)
		(if (>= temp1 2)
			(ClearFlag 276)
		else
			(SetFlag 276)
		)
		(backPlane bitmap: 0 dispose:)
		(gBackMusic fade:)
		(gMySoundFX fade:)
		(continueSound stop:)
		(localSound stop:)
		(robotLever dispose:)
		(gThePlane priority: local0)
		(Lock rsAUDIO 890 0)
		(Lock rsAUDIO 891 0)
		(Lock rsAUDIO 892 0)
		(super dispose: &rest)
	)

	(method (doit)
		(vent0 doit:)
		(vent1 doit:)
		(valve0 doit:)
		(valve1 doit:)
		(valve2 doit:)
		(valve3 doit:)
		(valve4 doit:)
		(valve5 doit:)
		(valve6 doit:)
		(valve7 doit:)
		(cond
			((and (< local1 300) (> (gMySoundFX vol:) 63))
				(gMySoundFX setVol: 63)
			)
			((and (> local1 309) (< (gMySoundFX vol:) 64))
				(gMySoundFX setVol: 95)
			)
			((and (< local1 600) (> (gMySoundFX vol:) 95))
				(gMySoundFX setVol: 95)
			)
			((and (> local1 618) (< (gMySoundFX vol:) 96))
				(gMySoundFX setVol: 127)
			)
		)
		(= local6 (pRobotArm loop:))
		(= local7 (pRobotArm cel:))
		(if
			(or
				(robotLever tracking:)
				(and
					(robotLever forcedMove:)
					(> (robotLever destCel:) 0)
					(== (robotLever destStem:) (robotLever curStem:))
				)
			)
			(switch (robotLever curStemIndex:)
				(0
					(if (> ((robotLever stemView:) cel:) 0)
						(switch (pRobotArm loop:)
							(1
								(if (== (pRobotArm cel:) 0)
									(pRobotArm setLoop: 3 setCel: 18)
								else
									(pRobotArm setCel: (+ (pRobotArm cel:) 1))
								)
							)
							(2
								(if (== (pRobotArm cel:) 0)
									(pRobotArm setLoop: 3 setCel: 18)
								else
									(pRobotArm setCel: (- (pRobotArm cel:) 1))
								)
							)
							(3
								(if (< (pRobotArm cel:) 18)
									(pRobotArm setCel: (+ (pRobotArm cel:) 1))
								else
									(pRobotArm setLoop: 1 setCel: 1)
								)
							)
						)
					)
				)
				(1
					(switch (pRobotArm loop:)
						(1
							(if (== (pRobotArm cel:) 0)
								(pRobotArm setLoop: 3 setCel: 18)
							else
								(pRobotArm setCel: (- (pRobotArm cel:) 1))
							)
						)
						(2
							(if (== (pRobotArm cel:) 0)
								(pRobotArm setLoop: 3 setCel: 18)
							else
								(pRobotArm setCel: (+ (pRobotArm cel:) 1))
							)
						)
						(3
							(if (< (pRobotArm cel:) 18)
								(pRobotArm setCel: (+ (pRobotArm cel:) 1))
							else
								(pRobotArm setLoop: 2 setCel: 1)
							)
						)
					)
				)
				(2
					(if (and (== (pRobotArm loop:) 3) (< (pRobotArm cel:) 18))
						(pRobotArm setCel: (+ (pRobotArm cel:) 1))
					)
				)
				(3
					(cond
						((or (== (pRobotArm loop:) 1) (== (pRobotArm loop:) 2))
							(if (pRobotArm cel:)
								(pRobotArm setCel: (- (pRobotArm cel:) 1))
							else
								(pRobotArm setLoop: 3 setCel: 18)
							)
						)
						((and (== (pRobotArm loop:) 3) (pRobotArm cel:))
							(pRobotArm setCel: (- (pRobotArm cel:) 1))
						)
					)
				)
			)
		)
		(cond
			((or (!= (pRobotArm loop:) local6) (!= (pRobotArm cel:) local7))
				(if (not local8)
					(= local8 1)
					(continueSound number: 894 setLoop: -1 play:)
				)
			)
			(local8
				(= local8 0)
				(continueSound stop:)
				(localSound number: 895 setLoop: 1 play:)
			)
		)
		(super doit: &rest)
	)
)

(instance robotLever of StemTracker
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 81 37 114 82 156 133 95 97 61
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: (self approachX:))
		(global105 addToFront: (self approachX:))
	)

	(method (doMouseUp)
		(self moveTo: 0 0)
	)
)

(instance planeView of View
	(properties
		view 4820
	)

	(method (onMe)
		(return 0)
	)
)

(instance pSphereLever of TrackingProp
	(properties
		x 391
		y 155
		view 890
		cel 7
		cycleSpeed 3
		wrap 0
		advanceKey 18432
		retreatKey 20480
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: (self approachX:))
		(global105 addToFront: (self approachX:))
	)

	(method (doMouseUp)
		(cond
			((> cel 7)
				(self setCycle: CT 7 -1)
			)
			((< cel 7)
				(self setCycle: CT 7 1)
			)
		)
	)

	(method (cue)
		(continueSound number: 891 setLoop: -1 play:)
	)

	(method (doit)
		(cond
			(local2
				(if (== local1 0)
					(cond
						((> cel 13)
							(if (and local3 local4)
								(continueSound stop:)
								(localSound stop:)
								(gCurRoom newRoom: 870)
							else
								(= local3 1)
							)
						)
						((== cel 7)
							(if local3
								(= local4 1)
							)
						)
						((< cel 7)
							(= local4 0)
							(= local3 0)
						)
					)
				)
				(cond
					((> cel 7)
						(cond
							((and (== cel 15) (> local1 1))
								(MovePlaneItems backPlane 0 2 1)
								(-= local1 2)
							)
							((> local1 0)
								(MovePlaneItems backPlane 0 1 1)
								(-- local1)
								(continueSound stop:)
							)
						)
					)
					((and (== cel 0) (< local1 928))
						(MovePlaneItems backPlane 0 -2 1)
						(+= local1 2)
					)
					((and (< cel 7) (< local1 929))
						(MovePlaneItems backPlane 0 -1 1)
						(++ local1)
						(continueSound stop:)
					)
				)
				(if (!= cel 7)
					(UpdatePlane backPlane)
					(FrameOut)
				)
				(cond
					((> cel 7)
						(if (== local5 0)
							(= local5 1)
							(localSound
								stop:
								client: 0
								number: 890
								setLoop: 1
								play: 127 self
							)
						)
					)
					((< cel 7)
						(if (== local5 0)
							(= local5 2)
							(localSound
								stop:
								client: 0
								number: 890
								setLoop: 1
								play: 127 self
							)
						)
					)
					(
						(and
							(== cel 7)
							(or (== local5 1) (== local5 2) (!= local5 0))
						)
						(= local5 0)
						(continueSound stop: client: 0)
						(localSound number: 892 setLoop: 1 play:)
					)
				)
			)
			((< cel 2)
				(gBackMusic stop:)
				(localSound stop:)
				(= local2 1)
				(SetFlag 320)
				((ScriptID 1 7) dispose:) ; exitBackUp
				(self setCel: 7)
				(backPlane setBitmap: 887 0 0 setRect: 222 80 423 336)
				(if keyTrack
					(self keyTrack: 0 tracking: 0)
					(global206 delete: self)
				)
				(self doMouseUp:)
				(proc0_8 891)
				(gMySoundFX
					number: 889
					setLoop: -1
					play:
					setVol: 0
					fade: 63 25 10 0
				)
				(gBackMusic
					number: 8100
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
			)
		)
		(super doit: &rest)
	)
)

(instance pSpinnerControl of TrackingProp
	(properties
		x 118
		y 54
		view 890
		loop 6
		wrap 0
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: (self approachX:))
		(global105 addToFront: (self approachX:))
	)

	(method (doit)
		(cond
			((!= local10 cel)
				(if (== local9 0)
					(= local9 1)
					(spinSound number: 896 play:)
				)
			)
			((== local9 1)
				(= local9 0)
				(spinSound number: 897 play:)
			)
		)
		(super doit: &rest)
	)

	(method (nextCel param1)
		(switch (pRobotArm loop:)
			(1
				(if
					(and
						(<= 265 local1 285)
						(<= 7 (pRobotArm cel:) 9)
						(> param1 cel)
					)
					(valve1 setCycle: End)
					(valveSound play:)
					(ClearFlag 336)
					(localproc_0)
				)
				(if
					(and
						(<= 259 local1 279)
						(<= 7 (pRobotArm cel:) 15)
						(< param1 cel)
					)
					(valve1 setCycle: Beg)
					(valveSound play:)
					(SetFlag 336)
					(localproc_0)
				)
				(if
					(and
						(<= 301 local1 309)
						(== (pRobotArm cel:) 21)
						(> param1 cel)
					)
					(valve2 setCycle: End)
					(valveSound play:)
					(SetFlag 337)
					(localproc_0)
				)
				(if
					(and
						(<= 301 local1 309)
						(== (pRobotArm cel:) 21)
						(< param1 cel)
					)
					(valve2 setCycle: Beg)
					(valveSound play:)
					(ClearFlag 337)
					(localproc_0)
				)
				(if
					(and
						(<= 426 local1 446)
						(<= 13 (pRobotArm cel:) 15)
						(< param1 cel)
					)
					(valve6 setCycle: End)
					(valveSound play:)
					(if (IsFlag 338)
						(steamSound setVol: 90 play:)
					else
						(steamSound setVol: 127)
					)
					(ClearFlag 341)
					(vent0 x: 18)
					(localproc_0)
				)
				(if
					(and
						(<= 409 local1 429)
						(<= 7 (pRobotArm cel:) 15)
						(> param1 cel)
					)
					(valve6 setCycle: Beg)
					(valveSound play:)
					(if (IsFlag 338)
						(steamSound stop:)
					else
						(steamSound setVol: 90)
					)
					(SetFlag 341)
					(vent0 x: 1000)
					(localproc_0)
				)
				(if
					(and
						(<= 481 local1 501)
						(<= 1 (pRobotArm cel:) 6)
						(> param1 cel)
					)
					(valve7 setCycle: End)
					(valveSound play:)
					(ClearFlag 342)
					(localproc_0)
				)
				(if
					(and
						(<= 464 local1 484)
						(<= 3 (pRobotArm cel:) 11)
						(< param1 cel)
					)
					(valve7 setCycle: Beg)
					(valveSound play:)
					(SetFlag 342)
					(localproc_0)
				)
			)
			(2
				(if
					(and
						(<= 189 local1 209)
						(<= 12 (pRobotArm cel:) 17)
						(< param1 cel)
					)
					(valve0 setCycle: End)
					(valveSound play:)
					(ClearFlag 335)
					(localproc_0)
				)
				(if
					(and
						(<= 174 local1 194)
						(<= 12 (pRobotArm cel:) 21)
						(> param1 cel)
					)
					(valve0 setCycle: Beg)
					(valveSound play:)
					(SetFlag 335)
					(localproc_0)
				)
				(if
					(and
						(<= 328 local1 348)
						(<= 19 (pRobotArm cel:) 21)
						(< param1 cel)
					)
					(valve3 setCycle: End)
					(valveSound play:)
					(if (IsFlag 341)
						(steamSound setVol: 90 play:)
					else
						(steamSound setVol: 127)
					)
					(ClearFlag 338)
					(vent1 x: 120)
					(localproc_0)
				)
				(if
					(and
						(<= 320 local1 340)
						(<= 20 (pRobotArm cel:) 21)
						(> param1 cel)
					)
					(valve3 setCycle: Beg)
					(valveSound play:)
					(if (IsFlag 341)
						(steamSound stop:)
					else
						(steamSound setVol: 90)
					)
					(SetFlag 338)
					(vent1 x: 1000)
					(localproc_0)
				)
				(if
					(and
						(<= 394 local1 406)
						(== (pRobotArm cel:) 21)
						(> param1 cel)
					)
					(valve4 setCycle: End)
					(valveSound play:)
					(SetFlag 339)
					(localproc_0)
				)
				(if
					(and
						(<= 394 local1 406)
						(== (pRobotArm cel:) 21)
						(< param1 cel)
					)
					(valve4 setCycle: Beg)
					(valveSound play:)
					(ClearFlag 339)
					(localproc_0)
				)
				(if
					(and
						(<= 413 local1 433)
						(<= 4 (pRobotArm cel:) 9)
						(< param1 cel)
					)
					(valve5 setCycle: End)
					(valveSound play:)
					(ClearFlag 340)
					(localproc_0)
				)
				(if
					(and
						(<= 398 local1 418)
						(<= 4 (pRobotArm cel:) 13)
						(> param1 cel)
					)
					(valve5 setCycle: Beg)
					(valveSound play:)
					(SetFlag 340)
					(localproc_0)
				)
				(if
					(and
						(<= 846 local1 924)
						(<= 4 (pRobotArm cel:) 6)
						(not (IsFlag 334))
						(== (theClamp cel:) 3)
					)
					(SetFlag 334)
					(theDevice x: 1000 doit: dispose:)
					(valveSound play:)
					(gInventory addItem: (ScriptID 9 62)) ; invBarrel
				)
			)
		)
		(super nextCel: param1 &rest)
	)
)

(instance indicator of Prop
	(properties
		x 383
		y 74
		view 4820
		loop 1
	)

	(method (doit)
		(switch (pRobotArm loop:)
			(1
				(if
					(or
						(and (<= 265 local1 285) (<= 7 (pRobotArm cel:) 9))
						(and (<= 259 local1 279) (<= 7 (pRobotArm cel:) 15))
						(and (<= 301 local1 309) (== (pRobotArm cel:) 21))
						(and (<= 301 local1 309) (== (pRobotArm cel:) 21))
						(and (<= 426 local1 446) (<= 13 (pRobotArm cel:) 15))
						(and (<= 409 local1 429) (<= 7 (pRobotArm cel:) 15))
						(and (<= 481 local1 501) (<= 1 (pRobotArm cel:) 6))
						(and (<= 464 local1 484) (<= 3 (pRobotArm cel:) 11))
					)
					(self show:)
				else
					(self hide:)
				)
			)
			(2
				(if
					(or
						(and (<= 189 local1 209) (<= 12 (pRobotArm cel:) 17))
						(and (<= 174 local1 194) (<= 12 (pRobotArm cel:) 21))
						(and (<= 328 local1 348) (<= 19 (pRobotArm cel:) 21))
						(and (<= 320 local1 340) (<= 20 (pRobotArm cel:) 21))
						(and (<= 394 local1 406) (== (pRobotArm cel:) 21))
						(and (<= 394 local1 406) (== (pRobotArm cel:) 21))
						(and (<= 413 local1 433) (<= 4 (pRobotArm cel:) 9))
						(and (<= 398 local1 418) (<= 4 (pRobotArm cel:) 13))
						(and
							(<= 846 local1 924)
							(<= 4 (pRobotArm cel:) 6)
							(not (IsFlag 334))
						)
					)
					(self show:)
				else
					(self hide:)
				)
			)
		)
	)
)

(instance pRobotArm of Prop
	(properties
		x 141
		y 262
		view 880
		loop 3
	)
)

(instance pSpinner of Prop
	(properties
		view 880
	)

	(method (doit)
		(switch (pRobotArm loop:)
			(1
				(pSpinner show: setCel: (pSpinnerControl cel:))
				(switch (pRobotArm cel:)
					(0
						(pSpinner y: 122)
					)
					(else
						(pSpinner y: 121)
					)
				)
				(switch (pRobotArm cel:)
					(0
						(pSpinner x: 250)
					)
					(1
						(pSpinner x: 250)
					)
					(2
						(pSpinner x: 247)
					)
					(3
						(pSpinner x: 244)
					)
					(4
						(pSpinner x: 242)
					)
					(5
						(pSpinner x: 238)
					)
					(6
						(pSpinner x: 235)
					)
					(7
						(pSpinner x: 231)
					)
					(8
						(pSpinner x: 228)
					)
					(9
						(pSpinner x: 225)
					)
					(10
						(pSpinner x: 222)
					)
					(11
						(pSpinner x: 219)
					)
					(12
						(pSpinner x: 216)
					)
					(13
						(pSpinner x: 213)
					)
					(14
						(pSpinner x: 210)
					)
					(15
						(pSpinner x: 207)
					)
					(16
						(pSpinner x: 204)
					)
					(17
						(pSpinner x: 200)
					)
					(18
						(pSpinner x: 197)
					)
					(19
						(pSpinner x: 194)
					)
					(20
						(pSpinner x: 191)
					)
					(21
						(pSpinner x: 188)
					)
				)
			)
			(2
				(pSpinner show: setCel: (pSpinnerControl cel:))
				(switch (pRobotArm cel:)
					(0
						(pSpinner y: 123)
					)
					(else
						(pSpinner y: 120)
					)
				)
				(switch (pRobotArm cel:)
					(0
						(pSpinner x: 250)
					)
					(1
						(pSpinner x: 251)
					)
					(2
						(pSpinner x: 253)
					)
					(3
						(pSpinner x: 256)
					)
					(4
						(pSpinner x: 260)
					)
					(5
						(pSpinner x: 263)
					)
					(6
						(pSpinner x: 266)
					)
					(7
						(pSpinner x: 270)
					)
					(8
						(pSpinner x: 273)
					)
					(9
						(pSpinner x: 277)
					)
					(10
						(pSpinner x: 280)
					)
					(11
						(pSpinner x: 284)
					)
					(12
						(pSpinner x: 287)
					)
					(13
						(pSpinner x: 291)
					)
					(14
						(pSpinner x: 294)
					)
					(15
						(pSpinner x: 298)
					)
					(16
						(pSpinner x: 301)
					)
					(17
						(pSpinner x: 305)
					)
					(18
						(pSpinner x: 308)
					)
					(19
						(pSpinner x: 312)
					)
					(20
						(pSpinner x: 316)
					)
					(21
						(pSpinner x: 319)
					)
				)
			)
			(3
				(pSpinner hide:)
			)
		)
		(super doit: &rest)
	)
)

(instance backPlane of Plane
	(properties)
)

(instance backCast of Cast
	(properties)
)

(instance vent0 of Prop
	(properties
		x 18
		y 307
		view 882
	)
)

(instance vent1 of Prop
	(properties
		x 120
		y 367
		view 882
		loop 1
	)
)

(instance valve0 of Prop
	(properties
		x 132
		y 318
		view 881
	)
)

(instance valve1 of Prop
	(properties
		x 65
		y 393
		view 881
		loop 1
	)
)

(instance valve2 of Prop
	(properties
		x 17
		y 432
		view 881
		loop 2
	)
)

(instance valve3 of Prop
	(properties
		x 151
		y 455
		view 881
		loop 3
	)
)

(instance valve4 of Prop
	(properties
		x 159
		y 530
		view 881
		loop 4
	)
)

(instance valve5 of Prop
	(properties
		x 107
		y 542
		view 881
		loop 5
	)
)

(instance valve6 of Prop
	(properties
		x 46
		y 554
		view 881
		loop 6
	)
)

(instance valve7 of Prop
	(properties
		x 75
		y 610
		view 881
		loop 7
	)
)

(instance theClamp of View
	(properties
		x 51
		y 1057
		view 883
	)
)

(instance theDevice of View
	(properties
		x 51
		y 1057
		view 883
		loop 1
	)
)

(instance localSound of Sound
	(properties)
)

(instance continueSound of Sound
	(properties)
)

(instance spinSound of Sound
	(properties)
)

(instance valveSound of Sound
	(properties
		number 929
	)
)

(instance steamSound of Sound
	(properties
		number 926
		loop -1
	)
)

