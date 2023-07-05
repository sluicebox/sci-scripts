;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use Array)
(use Polygon)
(use System)

(class CueObj of Script
	(properties
		theVerb 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= ticks 1)
				(gTheDoits add: self)
			)
			(2
				(= ticks 1)
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

(class Hiliter of Obj
	(properties
		client 0
		verbList 0
		insetMember 0
	)

	(method (hotVerbs param1 &tmp temp0)
		(if verbList
			(verbList dispose:)
			(= verbList 0)
		)
		(if (and argc param1)
			(= verbList (IntArray new: 1))
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(verbList at: temp0 [param1 temp0])
			)
		)
		(if (or (and argc (not param1)) (not argc))
			(global105 delete: self)
			(client approachX: 0)
			(self dispose:)
		)
	)

	(method (respondsTo param1 &tmp temp0)
		(if verbList
			(for ((= temp0 0)) (< temp0 (verbList size:)) ((++ temp0))
				(if (== (verbList at: temp0) param1)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (onMe)
		(return (if (client onMe: &rest) 1 else 0))
	)

	(method (initArrow &tmp temp0)
		(cond
			(global110
				(if (>= (global110 view:) 3000)
					(gNormalCursor view: (- (global110 view:) 1000))
				else
					(gNormalCursor view: (global110 view:))
				)
				(if (< 2102 (global110 view:) 2111)
					(= temp0 3)
				else
					(= temp0 2)
				)
				(gNormalCursor loop: temp0 cel: (global110 state:))
				(gGame setCursor: gNormalCursor 1)
			)
			((== (gUser curVerb:) 24)
				(gNormalCursor view: 1100 loop: 12 cel: 0)
			)
			(else
				(gNormalCursor view: 999 loop: 2 cel: 0)
			)
		)
		(if (== (gGame normalizeCode:) -1)
			(gGame setCursor: gNormalCursor 1)
		else
			((gGame normalizeCode:) doit:)
		)
	)

	(method (disposeArrow)
		(cond
			(global110
				(if (>= (global110 view:) 3000)
					(gNormalCursor view: (- (global110 view:) 1000))
				else
					(gNormalCursor view: (global110 view:))
				)
				(gNormalCursor loop: 1 cel: (global110 state:))
				(gGame setCursor: gNormalCursor 1)
			)
			((== (gUser curVerb:) 24)
				(gNormalCursor view: 1100 loop: 11 cel: 0)
			)
			(else
				(gNormalCursor view: 999 loop: 0 cel: 0)
			)
		)
		(if (== (gGame normalizeCode:) -1)
			(gGame setCursor: gNormalCursor 1)
		else
			((gGame normalizeCode:) doit:)
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

	(method (cue))

	(method (init theInitializer)
		(self initialize: (if argc theInitializer else 0))
		(if (self respondsTo: #view)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
		(if (not approachX)
			((= approachX (Hiliter new:)) client: self hotVerbs: 5)
			(if (not global105)
				(= global105 (Set new:))
			)
			(global105 add: approachX)
		)
	)

	(method (initialize theInitializer)
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
		(= ret 0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= ret (event claimed: 1))
				(self doVerb: (event message:))
			)
		)
		(return ret)
	)

	(method (notFacing &tmp event)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb &tmp defaultCode who)
		(= defaultCode (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(defaultCode doit: theVerb self)
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
		(if approachX
			(global105 delete: approachX)
			(if (== global106 approachX)
				(= global106 0)
			)
			(approachX dispose:)
			(= approachX 0)
		)
		(gFeatures delete: self)
		(super dispose:)
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

(class ExitFeature of Feature
	(properties
		curPic 0
		curDir 0
		arrowStyle 3
		nextRoomNum 0
		exitCode 0
		cursorObj 0
	)
)

