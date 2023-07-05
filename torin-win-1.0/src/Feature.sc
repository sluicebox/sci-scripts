;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use FeatureInfo)
(use PolyPath)
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

	(method (init oPlane theInitializer)
		(self initialize: (if (> argc 1) theInitializer else 0))
		(cond
			(argc
				(= plane oPlane)
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

	(method (handleEvent event &tmp ret)
		(if (!= (event plane:) plane)
			(event localize: plane)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(self onMe: event)
					(self isNotHidden:)
					(or (self forceCursor:) (self testHotspotVerb: global101))
				)
				(if (& (event type:) evMOUSEBUTTON)
					(CueObj state: 0 cycles: 0 client: self theVerb: global101)
					(if
						(and
							(gUser canControl:)
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
							gApproachCode
							(& _approachVerbs (gApproachCode doit: global101))
						)
						(gEgo
							setMotion:
								PolyPath
								approachX
								(+ (gEgo z:) approachY)
								CueObj
						)
					else
						(gEgo setMotion: 0)
						(if (self facingMe:)
							(CueObj changeState: 3)
						)
					)
				)
				(event claimed: 1)
				(return)
			)
		)
		(return 0)
	)

	(method (notFacing &tmp event)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb &tmp defaultCode who)
		(= defaultCode (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb case 1))
			(gMessager say: noun theVerb case 0 0 modNum)
		else
			(defaultCode doit: theVerb self)
		)
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

	(method (addHotspotVerb &tmp hvList)
		(if (not scratch)
			(PrintDebug {Tried to addHotspotVerb to non-inited feature})
			(return 0)
		)
		(if (not (= hvList (scratch hotspotVerbList:)))
			(scratch hotspotVerbList: (= hvList (Set new:)))
		)
		(return (hvList add: &rest))
	)

	(method (deleteHotspotVerb &tmp hvList)
		(if (not scratch)
			(PrintDebug {Tried to deleteHotspotVerb of non-inited feature})
			(return 0)
		)
		(return
			(and (= hvList (scratch hotspotVerbList:)) (hvList delete: &rest))
		)
	)

	(method (testHotspotVerb verb &tmp hvList)
		(if (not scratch)
			(PrintDebug {Tried to testHotspotVerb of non-inited feature})
			(return 0)
		)
		(if (= hvList (scratch hotspotVerbList:))
			(return (hvList contains: verb))
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

	(method (forceCursor cursor)
		(if (not scratch)
			(return 0)
		)
		(if (== argc 0)
			(return (scratch forceCursor:))
		else
			(return (scratch forceCursor: cursor))
		)
	)

	(method (myPriority nPri &tmp oSelf)
		(cond
			((self isKindOf: View)
				(= oSelf self)
				(if argc
					(return (oSelf setPri: nPri))
				else
					(return (oSelf priority:))
				)
			)
			(argc
				(return (= y nPri))
			)
			(else
				(return y)
			)
		)
	)

	(method (setRect nLeft nTop nRight nBottom)
		(= nsTop nTop)
		(= nsLeft nLeft)
		(= nsRight nRight)
		(= nsBottom nBottom)
	)

	(method (normalizeRect &tmp oPoly oPolyCoords i)
		(if (and onMeCheck (== 0 nsLeft nsRight nsTop nsBottom))
			(= oPoly onMeCheck)
			(if (not (oPoly respondsTo: #points))
				(= oPoly (oPoly at: 0))
			)
			(= oPolyCoords (oPoly points:))
			(= nsLeft (oPolyCoords at: 0))
			(= nsRight (oPolyCoords at: 0))
			(= nsTop (oPolyCoords at: 1))
			(= nsBottom (oPolyCoords at: 1))
			(for ((= i 2)) (< i (* 2 (oPoly size:))) ((+= i 2))
				(= nsLeft (Min nsLeft (oPolyCoords at: i)))
				(= nsRight (Max nsRight (oPolyCoords at: i)))
				(= nsTop (Min nsTop (oPolyCoords at: (+ i 1))))
				(= nsBottom (Max nsBottom (oPolyCoords at: (+ i 1))))
			)
		)
	)
)

(instance dftDoVerb of Code
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

