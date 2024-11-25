;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use PQRoom)
(use Button)
(use SwatFile)
(use Plane)
(use Motion)
(use Actor)
(use System)

(public
	metroExt 0
)

(local
	local0 = 5
	[local1 5] = [6302 6304 6306 6307 6309]
	local6 = 4
	[local7 4] = [6301 6303 6305 6308]
	local11
	local12
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local12 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(queryView init:)
	(queryYes init:)
	(queryNo init:)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(gGame handsOn:)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(= local11 0)
	(while (not local11)
		(if ((= temp2 (Event new: evMOUSE)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gGame handsOff:)
	(temp1 dispose:)
	(return (== local11 1))
)

(instance metroExt of PQRoom
	(properties
		picture 6300
	)

	(method (init)
		(if (== (gBackMusic number:) 6007)
			(Lock rsAUDIO 6007 0)
		)
		(Load rsAUDIO 3501)
		(super init: &rest)
		(americanFlag init:)
		(if (Random 0 2)
			(outProp init:)
		)
		(if (Random 0 4)
			(inProp init:)
		)
		(if (or (not (IsFlag 73)) (IsFlag 113) (not (gBackMusic handle:)))
			(gBackMusic number: 3501 loop: -1 play:)
		)
		(self setScript: enterMetro)
	)

	(method (dispose)
		(gBackMusic fade: 0 2 21 1)
		(super dispose: &rest)
	)
)

(instance enterMetro of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((gCast contains: outProp)
						(outProp setCycle: CT 20 1 self)
						(if (gCast contains: inProp)
							(inProp setCycle: CT 20 1)
						)
					)
					((gCast contains: inProp)
						(inProp setCycle: CT 20 1 self)
					)
					(else
						(= seconds 3)
					)
				)
			)
			(1
				(if
					(and
						(IsFlag 75)
						(== (SwatFile readIt: 0) 1)
						(not (localproc_0))
					)
					(SetFlag 116)
					(gGame setCallUp: (gGame callUpTime:))
					(ClearFlag 75)
				)
				(= cycles 1)
			)
			(2
				(= temp0 6000)
				(cond
					((IsFlag 75)
						(= temp0 6000)
					)
					((and (IsFlag 73) (not (IsFlag 113)))
						(= temp0 6200)
					)
					(else
						(ClearFlag 93)
						(ClearFlag 94)
						(ClearFlag 95)
						(ClearFlag 96)
						(ClearFlag 97)
						(ClearFlag 98)
						(ClearFlag 99)
						(ClearFlag 101)
						(ClearFlag 102)
					)
				)
				(ClearFlag 73)
				(ClearFlag 113)
				(if (== temp0 6000)
					(gGame getDisc: 1)
				)
				(gCurRoom newRoom: temp0)
			)
		)
	)
)

(instance americanFlag of Prop
	(properties
		x 568
		y 2
		view 63010
		cel 14
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(self setScript: waveFlag)
	)
)

(instance waveFlag of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles (Random 1 40))
			)
			(1
				(= state 0)
				(= temp0 (Random 1 13))
				(americanFlag cycleSpeed: (Random 7 12))
				(cond
					((> temp0 (americanFlag cel:))
						(americanFlag setCycle: CT temp0 1 self)
					)
					((< temp0 (americanFlag cel:))
						(americanFlag setCycle: CT temp0 -1 self)
					)
					(else
						(= cycles (Random 1 40))
					)
				)
			)
		)
	)
)

(instance outProp of Prop
	(properties)

	(method (init)
		(= view [local1 (Random 0 (- local0 1))])
		(= loop (= cel 0))
		(switch view
			(6302
				(self posn: 265 303)
			)
			(6304
				(self posn: 180 305 setPri: 10)
			)
			(6306
				(self posn: 214 315 setPri: 10)
			)
			(6307
				(self posn: 67 211 setPri: 10)
			)
			(6309
				(self posn: 67 318 setPri: 10)
			)
		)
		(super init: &rest)
	)
)

(instance inProp of Prop
	(properties)

	(method (init &tmp temp0)
		(= temp0 1)
		(while temp0
			(= temp0 0)
			(= view [local7 (Random 0 (- local6 1))])
			(= loop (= cel 0))
			(switch view
				(6301
					(if
						(and
							(gCast contains: outProp)
							(OneOf (outProp view:) 6304 6306)
						)
						(= temp0 1)
					else
						(self posn: 411 283)
					)
				)
				(6303
					(if
						(and
							(gCast contains: outProp)
							(OneOf (outProp view:) 6304 6306)
						)
						(= temp0 1)
					else
						(self posn: 329 311 setPri: 10)
					)
				)
				(6305
					(self posn: 230 369 setPri: 10)
				)
				(6308
					(if
						(and
							(gCast contains: outProp)
							(OneOf (outProp view:) 6306 6307 6304)
						)
						(= temp0 1)
					else
						(self posn: 379 284 setPri: 10)
					)
				)
			)
		)
		(super init: &rest)
	)
)

(instance queryView of View
	(properties
		priority 150
		fixPriority 1
		view 156
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance queryYes of Button
	(properties
		priority 151
		fixPriority 1
		view 156
		loop 1
		keyMessage 121
	)

	(method (init)
		(= x (+ (queryView x:) 16))
		(= y (+ (queryView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(= local11 1)
	)
)

(instance queryNo of Button
	(properties
		priority 151
		fixPriority 1
		view 156
		loop 1
		upCel 2
		downCel 3
		keyMessage 110
	)

	(method (init)
		(= x (+ (queryView x:) 166))
		(= y (+ (queryView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(= local11 2)
	)
)

