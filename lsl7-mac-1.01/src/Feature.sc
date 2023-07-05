;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use oInvHandler)
(use L7TalkWindow)
(use soFlashCyberSniff)
(use FeatureInfo)
(use Polygon)
(use Actor)
(use System)

(class CueObj of Script
	(properties
		theVerb 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(client x:)
							(client y:)
						)
						self
				)
				(gTheDoits add: self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gTheDoits delete: self)
				(if
					(not
						(and
							client
							(client actions:)
							((client actions:) doVerb: theVerb)
						)
					)
					(client doVerb: theVerb)
				)
				(= state 0)
			)
		)
	)
)

(class Feature of Obj
	(properties
		heading 0
		noun 0
		case 0
		modNum -1
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		sightAngle 26505
		actions 0
		onMeCheck 0
		state 0
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		plane 0
		x 0
		y 0
		z 0
	)

	(method (init param1 param2)
		(self initialize: (if (> argc 1) param2 else 0))
		(cond
			(argc
				(= plane param1)
			)
			((and gCurRoom (gCurRoom plane:))
				(= plane (gCurRoom plane:))
			)
			(else
				(= plane gThePlane)
			)
		)
		((plane oMyFeatures:) add: self)
	)

	(method (initialize theInitializer)
		(if (not scratch)
			(= scratch (FeatureInfo new:))
		)
		(cond
			((and argc theInitializer)
				(self perform: theInitializer)
			)
			(gFtrInitializer
				(self perform: gFtrInitializer)
			)
		)
	)

	(method (approachVerbs args &tmp i theBits)
		(= _approachVerbs 0)
		(if (and argc gApproachCode [args 0])
			(for ((= i 0)) (< i argc) ((++ i))
				(= theBits (gApproachCode doit: [args i]))
				(self _approachVerbs: (| (self _approachVerbs:) theBits))
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (!= (event plane:) plane)
			(event localize: plane)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((self hogStatus:)
				(event claimed: 1)
				(if (& (event type:) evMOUSERELEASE)
					(gOEventHandler unregisterEventHog: self)
					(self hogStatus: 0)
					(if (not (self onMe: event))
						(return 1)
					)
					(= temp1 0)
					(if
						(and
							(not (self forceCursor:))
							(==
								(= temp1
									((ScriptID 64038 0) handleFeature: self) ; oPopupMenuHandler
								)
								-1
							)
						)
						(return)
					)
					(CueObj state: 0 cycles: 0 client: self theVerb: temp1)
					(cond
						(
							(and
								(gUser canControl:)
								(not (self forceCursor:))
								(self testApproachVerb: temp1)
								(not (self testExceptionVerb: temp1))
								(& (gEgo state:) $0002)
								(>
									(GetDistance
										(gEgo x:)
										(gEgo y:)
										approachX
										approachY
									)
									approachDist
								)
								(gEgo plane:)
								((gEgo plane:) isEnabled:)
								(gEgo isNotHidden:)
								(== (gEgo plane:) (self plane:))
								(!= self gEgo)
							)
							(if (and (== approachX 0) (== approachY 0))
								(gEgo walkTo: x (+ (gEgo z:) y) CueObj)
							else
								(gEgo
									walkTo:
										approachX
										(+ (gEgo z:) approachY)
										CueObj
								)
							)
						)
						(
							(or
								((ScriptID 64017 0) test: 204) ; oFlags
								(self testExceptionVerb: temp1)
								(self forceCursor:)
								(not gEgo)
								(not (gEgo plane:))
								(not ((gEgo plane:) isEnabled:))
								(not (gEgo isNotHidden:))
								(!= (gEgo plane:) (self plane:))
								(== self gEgo)
							)
							(CueObj changeState: 3)
						)
						(else
							(gEgo setMotion: 0)
							(CueObj cue:)
						)
					)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(self onMe: event)
					(self isNotHidden:)
					(or (self forceCursor:) (self getHotspotVerbList:))
				)
				(event claimed: 1)
				(if (and (& (event type:) evMOUSEBUTTON) (not (event modifiers:)))
					(gOEventHandler registerEventHog: self)
					(self hogStatus: 1)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (notFacing &tmp event)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb &tmp [temp0 2] temp2 temp3 temp4)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if
			(and
				(!= theVerb 12) ; Other...
				(!= theVerb 112) ; Other...
				(!= theVerb 70) ; Huh?
				gMsgType
				(Message msgGET modNum noun theVerb case 1)
			)
			(gMessager say: noun theVerb case 0 0 modNum)
			(if (and (proc64040_1 theVerb) ((ScriptID 64040 2) oPlane:)) ; L7TalkWindow
				((ScriptID 64040 2) addTopic: theVerb) ; L7TalkWindow
			)
			(return)
		)
		(if (proc64040_1 theVerb)
			(if (= temp2 (GetNumMessages modNum noun 70 case))
				(= temp3 (GetRandomNumber 1 temp2))
				(gMessager say: noun 70 case temp3 0 modNum)
			else
				(PrintDebug {No default topics for object %s (%d)} name self)
			)
			(return)
		)
		(if
			(and
				(!= theVerb 12) ; Other...
				(!= theVerb 112) ; Other...
				(!= theVerb 70) ; Huh?
				gMsgType
				(proc64037_3 theVerb)
				(Message msgGET modNum noun 161 case 1)
			)
			(gMessager say: noun 161 case 0 0 modNum)
			(return)
		)
		(self normalizeRect:)
		(= temp4
			(Abs (+ (* 7 nsLeft) (* 23 nsRight) (* 43 nsTop) (* 87 nsBottom)))
		)
		(if (= temp2 (GetNumCases 16 0 theVerb))
			(= temp3 (+ (mod temp4 temp2) 1))
			(gMessager say: 0 theVerb temp3 0 0 16)
			(return)
		)
		(if (= temp2 (GetNumMessages 16 0 theVerb 0))
			(gMessager say: 0 theVerb 0 0 0 16)
			(return)
		)
		(if (and (proc64037_3 theVerb) (= temp2 (GetNumCases 16 0 161)))
			(= temp3 (+ (mod temp4 temp2) 1))
			(gMessager say: 0 161 temp3 0 0 16)
			(return)
		)
		(if (= temp2 (GetNumCases 16 0 69))
			(= temp3 (+ (mod temp4 temp2) 1))
			(gMessager say: 0 69 temp3 0 0 16)
			(return)
		)
		(PrintDebug {No default verb handler messages})
	)

	(method (facingMe act &tmp theActor theAngle)
		(cond
			(argc
				(= theActor act)
			)
			((gCast contains: gEgo)
				(= theActor gEgo)
			)
			(else
				(return 1)
			)
		)
		(if
			(>
				(= theAngle
					(Abs
						(-
							(GetAngle (theActor x:) (theActor y:) x y)
							(theActor heading:)
						)
					)
				)
				180
			)
			(= theAngle (- 360 theAngle))
		)
		(if (<= theAngle sightAngle)
			(return 1)
		else
			(if (!= sightAngle 26505)
				(if (& (theActor signal:) $0800)
					(CueObj client: self state: 2 cycles: 0 cue:)
				else
					(self notFacing:)
				)
			)
			(return 0)
		)
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (== argc 1)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return
			(cond
				((not onMeCheck)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft oX nsRight)
								(<= nsTop oY nsBottom)
							)
						)
						1
					else
						0
					)
				)
				((onMeCheck isKindOf: List)
					(onMeCheck firstTrue: #onMe oX oY)
				)
				(else
					(onMeCheck onMe: oX oY)
				)
			)
		)
	)

	(method (setName theName strObj &tmp locStrObj)
		(if (== theName 2)
			(= locStrObj (strObj new:))
			(= name (locStrObj data:))
			(locStrObj data: 0)
			(locStrObj dispose:)
		else
			(= name theName)
		)
	)

	(method (setPolygon args)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(cond
			((or (not argc) (== args 0))
				(return)
			)
			((== argc 1)
				(= onMeCheck [args 0])
			)
			(else
				(= onMeCheck (List new:))
				(onMeCheck add: args &rest)
			)
		)
	)

	(method (createPoly args)
		(if onMeCheck
			(onMeCheck dispose:)
		)
		(= onMeCheck (Polygon new:))
		(onMeCheck init: args &rest type: 0)
	)

	(method (dispose)
		(self setPolygon: 0)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gFeatures delete: self)
		(if (and plane (plane oMyFeatures:))
			((plane oMyFeatures:) delete: self)
		)
		(if gOEventHandler
			(gOEventHandler notifyDispose: self)
		)
		(if scratch
			(scratch dispose:)
			(= scratch 0)
		)
		(super dispose:)
	)

	(method (addHotspotVerb &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to addHotspotVerb to non-inited feature})
			(return 0)
		)
		(if (not (= temp0 (scratch hotspotVerbList:)))
			(scratch hotspotVerbList: (= temp0 (Set new:)))
		)
		(return (temp0 add: &rest))
	)

	(method (deleteHotspotVerb &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to deleteHotspotVerb of non-inited feature})
			(return 0)
		)
		(return
			(and (= temp0 (scratch hotspotVerbList:)) (temp0 delete: &rest))
		)
	)

	(method (testHotspotVerb param1 &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to testHotspotVerb of non-inited feature})
			(return 0)
		)
		(if (= temp0 (scratch hotspotVerbList:))
			(return (temp0 contains: param1))
		else
			(return 0)
		)
	)

	(method (getHotspotVerbList)
		(if scratch
			(return (scratch hotspotVerbList:))
		else
			(return 0)
		)
	)

	(method (addExceptionVerb &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to add exception verb to non-inited feature})
			(return 0)
		)
		(if (not (= temp0 (scratch oExceptionVerbs:)))
			(scratch oExceptionVerbs: (= temp0 (Set new:)))
		)
		(return (temp0 add: &rest))
	)

	(method (deleteExceptionVerb &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to delete exception verb of non-inited feature})
			(return 0)
		)
		(return
			(and (= temp0 (scratch oExceptionVerbs:)) (temp0 delete: &rest))
		)
	)

	(method (testExceptionVerb param1 &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to test exception verb of non-inited feature})
			(return 0)
		)
		(if (= temp0 (scratch oExceptionVerbs:))
			(return (temp0 contains: param1))
		else
			(return 0)
		)
	)

	(method (addApproachVerb &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to add approach verb to non-inited feature})
			(return 0)
		)
		(if (not (= temp0 (scratch oApproachVerbs:)))
			(scratch oApproachVerbs: (= temp0 (Set new:)))
		)
		(return (temp0 add: &rest))
	)

	(method (deleteApproachVerb &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to delete approach verb of non-inited feature})
			(return 0)
		)
		(return (and (= temp0 (scratch oApproachVerbs:)) (temp0 delete: &rest)))
	)

	(method (testApproachVerb param1 &tmp temp0)
		(if (not scratch)
			(PrintDebug {Tried to test approach verb of non-inited feature})
			(return 0)
		)
		(if (and global208 (global208 contains: param1))
			(return 1)
		)
		(if (= temp0 (scratch oApproachVerbs:))
			(return (temp0 contains: param1))
		else
			(return 0)
		)
	)

	(method (forceCursor param1)
		(if (not scratch)
			(return 0)
		)
		(if (== argc 0)
			(return (scratch forceCursor:))
		else
			(return (scratch forceCursor: param1))
		)
	)

	(method (myPriority param1 &tmp temp0)
		(cond
			((self isKindOf: View)
				(= temp0 self)
				(if argc
					(return (temp0 setPri: param1))
				else
					(return (temp0 priority:))
				)
			)
			(argc
				(return (= y param1))
			)
			(else
				(return y)
			)
		)
	)

	(method (setRect param1 param2 param3 param4)
		(= nsTop param2)
		(= nsLeft param1)
		(= nsRight param3)
		(= nsBottom param4)
	)

	(method (normalizeRect &tmp temp0 temp1 temp2)
		(if (and onMeCheck (== 0 nsLeft nsRight nsTop nsBottom))
			(= temp0 onMeCheck)
			(if (not (temp0 respondsTo: #points))
				(= temp0 (temp0 at: 0))
			)
			(= temp1 (temp0 points:))
			(= nsLeft (temp1 at: 0))
			(= nsRight (temp1 at: 0))
			(= nsTop (temp1 at: 1))
			(= nsBottom (temp1 at: 1))
			(for ((= temp2 2)) (< temp2 (* 2 (temp0 size:))) ((+= temp2 2))
				(= nsLeft (Min nsLeft (temp1 at: temp2)))
				(= nsRight (Max nsRight (temp1 at: temp2)))
				(= nsTop (Min nsTop (temp1 at: (+ temp2 1))))
				(= nsBottom (Max nsBottom (temp1 at: (+ temp2 1))))
			)
		)
	)

	(method (getName &tmp temp0)
		(if (not (= temp0 (MakeMessageText noun 68 case 1 gCurRoomNum 1)))
			(= temp0 (MakeMessageText noun 68 0 1 gCurRoomNum 1))
		)
		(return temp0)
	)

	(method (handleTopic)
		(return 0)
	)

	(method (stopHogging)
		(gOEventHandler unregisterEventHog: self)
		(self hogStatus: 0)
	)

	(method (hogStatus param1)
		(if (not scratch)
			(return 0)
		)
		(if (== argc 0)
			(return (scratch bImAHog:))
		else
			(return (scratch bImAHog: param1))
		)
	)
)

(instance dftDoVerb of Code ; UNUSED
	(properties)

	(method (doit)
		(return 1)
	)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

