;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64897)
(include sci.sh)
(use Main)
(use TPSound)
(use TranslucentPlane)
(use ModalPlane)
(use PushButton)
(use Plane)
(use Polygon)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	oRotInvPlane 0
	voEye 1
	PutAwayEyeItem 2
)

(local
	bAltScroll
	nCels
	nTimeSave
	bRotating
	newCel
	ioEyeItem
	voWhichEye
)

(procedure (SetUpRotatingHotspots &tmp oHotspotVerbList i verb)
	(if (= oHotspotVerbList (poRotView getHotspotVerbList:))
		(for ((= i 0)) (= verb (oHotspotVerbList at: i)) ((++ i))
			(poRotView deleteHotspotVerb: verb)
		)
	)
	(if (= oHotspotVerbList (ioEyeItem oVerbs:))
		(for ((= i 0)) (= verb (oHotspotVerbList at: i)) ((++ i))
			(poRotView addHotspotVerb: verb)
		)
	)
	(poRotView deleteHotspotVerb: 1)
	(if
		(OneOf
			ioEyeItem
			((ScriptID 64001 0) get: 31) ; oInvHandler, ioLocket
			((ScriptID 64001 0) get: 32) ; oInvHandler, ioOpenLocket
			((ScriptID 64001 0) get: 35) ; oInvHandler, ioAmmonia
			((ScriptID 64001 0) get: 36) ; oInvHandler, ioOpenAmmonia
			((ScriptID 64001 0) get: 46) ; oInvHandler, ioBagpipes
		)
		(poRotView addHotspotVerb: 1)
	)
)

(procedure (PutAwayEyeItem oEye)
	(if (and (== argc 0) ioEyeItem voWhichEye)
		(ioEyeItem moveTo: -3)
		(= ioEyeItem 0)
		(voWhichEye view: 60005 loop: 0 cel: 0 noun: 5)
		(oRotInvPlane dispose:)
		(return)
	)
	(if (and ioEyeItem (== oEye voWhichEye))
		(if (not voWhichEye)
			(PrintDebug {Big error -- inconsistent vars in invinset. djm})
			(return)
		)
		(ioEyeItem moveTo: -3)
		(= ioEyeItem 0)
		(voWhichEye view: 60005 loop: 0 cel: 0 noun: 5)
		(oRotInvPlane dispose:)
	)
)

(instance poRotView of Prop
	(properties
		x 300
		y 200
	)

	(method (init)
		(super init: &rest)
		(poRotView signal: (& (poRotView signal:) $efff))
		(= nCels (+ (self lastCel:) 1))
		(SetUpRotatingHotspots)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(ioEyeItem moveTo: -1)
				(switch ioEyeItem
					(((ScriptID 64001 0) get: 31) ; oInvHandler, ioLocket
						((ScriptID 64017 0) set: 118) ; oFlags
						(= ioEyeItem ((ScriptID 64001 0) get: 32)) ; oInvHandler, ioOpenLocket
					)
					(((ScriptID 64001 0) get: 32) ; oInvHandler, ioOpenLocket
						(if (not ((ScriptID 64017 0) test: 119)) ; oFlags
							((ScriptID 64017 0) clear: 118) ; oFlags
						)
						(= ioEyeItem ((ScriptID 64001 0) get: 31)) ; oInvHandler, ioLocket
					)
					(((ScriptID 64001 0) get: 35) ; oInvHandler, ioAmmonia
						(= ioEyeItem ((ScriptID 64001 0) get: 36)) ; oInvHandler, ioOpenAmmonia
						(if
							(and
								(!= gnChapter 5)
								(not ((ScriptID 64017 0) test: 127)) ; oFlags
							)
							((ScriptID 64017 0) set: 127) ; oFlags
							(gMessager say: 1 1 0 0 0 40100) ; "Whew! Smells like ammonia."
						)
					)
					(((ScriptID 64001 0) get: 36) ; oInvHandler, ioOpenAmmonia
						(= ioEyeItem ((ScriptID 64001 0) get: 35)) ; oInvHandler, ioAmmonia
					)
					(((ScriptID 64001 0) get: 46) ; oInvHandler, ioBagpipes
						(switch (Random 0 5)
							(0
								(goSound1 playSound: 50908)
							)
							(1
								(goSound1 playSound: 51102)
							)
							(2
								(goSound1 playSound: 51103)
							)
							(3
								(goSound1 playSound: 51104)
							)
							(4
								(goSound1 playSound: 51105)
							)
							(5
								(goSound1 playSound: 51106)
							)
						)
					)
				)
				(= view (ioEyeItem vCloseup:))
				(ioEyeItem moveTo: -4)
				(voWhichEye
					view: (ioEyeItem vInventory:)
					loop: (ioEyeItem lInventory:)
					cel: (ioEyeItem cInventory:)
					noun: (ioEyeItem noun:)
				)
			)
			(else
				(ioEyeItem doVerb: theVerb)
			)
		)
		(if ioEyeItem
			(SetUpRotatingHotspots)
		)
	)
)

(instance voEye of View
	(properties
		noun 5
		x 246
		y 90
		view 60005
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 74 266 75 283 82 283 89 271 98 247 99 225 98 206 90 205 83 217 74 237 72
					yourself:
				)
		)
	)

	(method (onMe theObjOrX theY &tmp oX oY bOn)
		(if (== argc 1)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(cond
			(
				(and
					(= bOn
						(or
							(super onMe: oX oY)
							(IsOnMe oX oY self 1)
						)
					)
					gInventItem
					(not ioEyeItem)
				)
				(if (and inLeft (inLeft respondsTo: #cel))
					(inLeft cel: 1)
				)
			)
			((and inLeft (inLeft respondsTo: #cel))
				(inLeft cel: 0)
			)
		)
		(return bOn)
	)

	(method (doit &tmp nX nY)
		(= nX (- gMouseX (plane left:)))
		(= nY (- gMouseY (plane top:)))
		(self onMe: nX nY)
		(super doit: &rest)
	)

	(method (testHotspotVerb theVerb)
		(if
			(or
				(and
					(not ioEyeItem)
					(or
						((ScriptID 64001 0) getVerbItem: theVerb) ; oInvHandler
						((ScriptID 64001 1) getVerbItem: theVerb) ; oBoogleHandler
					)
				)
				(and ioEyeItem (== theVerb 1))
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(if (and ioEyeItem (== theVerb 1)) ; Do
			(if (== ioEyeItem ((ScriptID 64001 0) get: 52)) ; oInvHandler, ioCrystcorder
				(gCurRoom deleteRoomPlane: (ScriptID 56000 1)) ; poCrystCorderCu
			else
				(oRotInvPlane dispose:)
			)
			(ioEyeItem moveTo: -2)
			(= ioEyeItem 0)
			(= voWhichEye 0)
			(= view 60005)
			(= cel (= loop 0))
			(= noun 5)
			(return)
		)
		(if gInventItem
			(= ioEyeItem gInventItem)
			(= voWhichEye self)
			(gInventItem moveTo: -4)
			(= view (ioEyeItem vInventory:))
			(= loop (ioEyeItem lInventory:))
			(= cel (ioEyeItem cInventory:))
			(= noun (ioEyeItem noun:))
			(if (== ioEyeItem ((ScriptID 64001 0) get: 52)) ; oInvHandler, ioCrystcorder
				(gCurRoom addRoomPlane: (ScriptID 56000 1)) ; poCrystCorderCu
			else
				(poScanner init: (voWhichEye plane:) hide: setScript: soScanObject)
			)
		)
	)
)

(instance poScanner of Prop
	(properties
		x 199
		y 73
		view 60004
		loop 20
		cycleSpeed 3
	)
)

(instance oLeftLaser of Prop
	(properties
		x 3
		y 247
		view 60004
		loop 22
		cycleSpeed 3
	)
)

(instance oRightLaser of Prop
	(properties
		x 451
		y 247
		view 60004
		loop 23
		cycleSpeed 3
	)
)

(instance oLaserPlane of Plane
	(properties
		picture -2
		priority 610
	)
)

(instance oScanSound of TPSound
	(properties)
)

(instance soScanObject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oScanSound preload: 60014 60026)
				(= ticks 1)
			)
			(1
				(oScanSound playSound: 60014)
				(poScanner cel: 0 show: setCycle: End self)
			)
			(2
				(poScanner hide:)
				(oScanSound stop:)
				(oLaserPlane init: 93 162 558 424)
				(oLeftLaser init: oLaserPlane setCel: 0 hide:)
				(oRightLaser init: oLaserPlane setCel: 0 hide:)
				(= ticks 1)
				(oScanSound playSound: 60026)
			)
			(3
				(oLeftLaser show: setCycle: End self)
				(oRightLaser show: setCycle: End)
			)
			(4
				(oRotInvPlane init:)
				(poRotView
					view: (ioEyeItem vCloseup:)
					setPri: 100
					init: (oRotInvPlane getMainCast:)
				)
				(oRotateForward setButton: 1 doSelect:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(oLeftLaser dispose:)
		(oRightLaser dispose:)
		(if (oLaserPlane oMyFeatures:)
			(oLaserPlane dispose:)
		)
		(oScanSound stop:)
		(super dispose:)
		(poScanner dispose:)
	)
)

(instance foOpaque of OpaqueFeature
	(properties)
)

(instance oRotInvPlane of TranslucentPlane
	(properties
		priority 610
	)

	(method (init &tmp [temp0 3])
		(super init: 4 4 635 319)
		(if (not ioEyeItem)
			(return)
		)
		(foOpaque init: self)
		(oRotateReverse init: (ScriptID 64002 1)) ; oInterfacePlane
		(oStepReverse init: (ScriptID 64002 1)) ; oInterfacePlane
		(oStop init: (ScriptID 64002 1)) ; oInterfacePlane
		(oStepForward init: (ScriptID 64002 1)) ; oInterfacePlane
		(oRotateForward init: (ScriptID 64002 1)) ; oInterfacePlane
		(oButtonGroup init:)
		((ScriptID 64002 5) hide:) ; oPause
		((ScriptID 64002 4) hide:) ; oRewind
		((ScriptID 64002 6) hide:) ; oFastForward
		(UpdatePlane self)
	)

	(method (dispose)
		(if (poScanner script:)
			(poScanner dispose:)
		else
			(oRotateReverse dispose:)
			(oStepReverse dispose:)
			(oStop dispose:)
			(oStepForward dispose:)
			(oRotateForward dispose:)
			(oButtonGroup dispose:)
			((ScriptID 64002 5) show:) ; oPause
			((ScriptID 64002 4) show:) ; oRewind
			((ScriptID 64002 6) show:) ; oFastForward
			(super dispose: &rest)
		)
	)
)

(instance oRotateReverse of RadioButton
	(properties
		noun 79
		x 237
		y 30
		view 60004
		loop 2
	)

	(method (doSelect)
		(poRotView setCycle: Fwd)
	)
)

(instance oStepReverse of PushButton
	(properties
		noun 77
		x 277
		y 30
		view 60004
		loop 3
	)

	(method (doClick)
		(poRotView setCycle: 0)
		(if (> (= newCel (+ (poRotView cel:) 1)) (poRotView lastCel:))
			(= newCel 0)
		)
		(poRotView cel: newCel)
		(= nTimeSave (+ gGameTime 20))
	)

	(method (doHeld)
		(if (> gGameTime nTimeSave)
			(poRotView setCycle: 0)
			(if (> (= newCel (+ (poRotView cel:) 1)) (poRotView lastCel:))
				(= newCel 0)
			)
			(poRotView cel: newCel)
			(= nTimeSave (+ gGameTime 5))
		)
	)

	(method (doSelect)
		(poRotView setCycle: 0)
		(oRotateReverse setButton: 0)
		(oRotateForward setButton: 0)
	)
)

(instance oStop of PushButton
	(properties
		noun 80
		x 317
		y 30
		view 60004
		loop 4
	)

	(method (doSelect)
		(poRotView setCycle: 0)
		(oRotateReverse setButton: 0)
		(oRotateForward setButton: 0)
	)
)

(instance oStepForward of PushButton
	(properties
		noun 76
		x 358
		y 30
		view 60004
		loop 5
	)

	(method (doClick)
		(poRotView setCycle: 0)
		(if (< (= newCel (- (poRotView cel:) 1)) 0)
			(= newCel (poRotView lastCel:))
		)
		(poRotView cel: newCel)
		(= nTimeSave (+ gGameTime 20))
	)

	(method (doHeld)
		(if (> gGameTime nTimeSave)
			(if (< (= newCel (- (poRotView cel:) 1)) 0)
				(= newCel (poRotView lastCel:))
			)
			(poRotView cel: newCel)
			(= nTimeSave (+ gGameTime 5))
		)
	)

	(method (doSelect)
		(poRotView setCycle: 0)
		(oRotateReverse setButton: 0)
		(oRotateForward setButton: 0)
	)
)

(instance oRotateForward of RadioButton
	(properties
		noun 78
		x 399
		y 30
		view 60004
		loop 6
	)

	(method (doSelect)
		(poRotView setCycle: Rev)
	)
)

(instance oButtonGroup of RadioGroup
	(properties)

	(method (init)
		(super init: &rest)
		(self add: oRotateReverse oRotateForward)
	)
)

