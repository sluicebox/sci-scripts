;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use n011)
(use PolyPath)
(use Polygon)
(use Cursor)
(use System)

(class CueObj of Script
	(properties
		theVerb 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (gCast contains: gEgo)
					(if (OneOf gCurRoomNum 700 400 10102 840) ; sqRm, marienRm, starnSeeRm
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
					else
						(gEgo
							setHeading:
								(GetAngle
									(gEgo x:)
									(gEgo y:)
									(client approachX:)
									(client approachY:)
								)
								self
						)
					)
				else
					(self changeState: 3)
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
		sightAngle 5
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

	(method (init theInitializer)
		(self initialize: (if argc theInitializer else 0))
		(if (self respondsTo: #view)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
		(if (and (not approachX) (not approachY))
			(= approachX x)
			(= approachY y)
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
			((gUser BAD_SELECTOR:)
				((gUser BAD_SELECTOR:) add: self)
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
				(if (not ((GKHotCursor BAD_SELECTOR:) contains: self))
					(event claimed: 1)
					(return)
				)
				(if (> (CueObj state:) 0)
					(event claimed: 1)
					(return)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(= ret (event claimed: 1))
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
						(& _approachVerbs (gApproachCode doit: (event message:)))
					)
					(= global141 self)
					(cond
						(
							(OneOf
								gCurRoomNum
								700 ; sqRm
								400 ; marienRm
								840 ; starnSeeRm
								10102
								420 ; uberRm
								42201 ; rm4220b
								320 ; leberRm
								3210
								4020
								330 ; vgHouseRm
								10102
								300 ; labRm
								542 ; klingRm
								5211
							)
							(gEgo
								setMotion:
									PolyPath
									approachX
									(+ (gEgo z:) approachY)
									CueObj
							)
						)
						((and (== (event message:) $003e) (!= global141 self)) ; >
							(CueObj cue:)
						)
						(else
							(CueObj changeState: 3)
						)
					)
				else
					(gEgo setMotion: 0)
					(if
						(or
							(!= (event message:) $003e) ; >
							(== global141 self)
							(self BAD_SELECTOR:)
						)
						(CueObj changeState: 3)
					else
						(CueObj cue:)
					)
				)
			)
		)
		(return ret)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1)
		(cond
			(argc
				(= temp0 param1)
			)
			((gCast contains: gEgo)
				(= temp0 gEgo)
			)
			(else
				(return 1)
			)
		)
		(if
			(>
				(= temp1
					(Abs
						(-
							(GetAngle (temp0 approachX:) (temp0 approachY:) x y)
							(temp0 heading:)
						)
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(if (<= temp1 sightAngle)
			(return 1)
		else
			(return 0)
		)
	)

	(method (notFacing &tmp event)
		(= global141 self)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb &tmp defaultCode who)
		(= defaultCode (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if
			(and
				gMsgType
				(ResCheck rsMESSAGE modNum)
				(Message msgGET modNum noun theVerb case 1)
			)
			(gMessager say: noun theVerb case 0 0 modNum)
		else
			(defaultCode doit: theVerb self)
			(return)
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
							(GetAngle (theActor approachX:) (theActor approachY:) x y)
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
				(if
					(or
						(& (theActor signal:) $0800)
						(< (gEgo distanceTo: self) approachDist)
					)
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
		(if (gUser BAD_SELECTOR:)
			((gUser BAD_SELECTOR:) delete: self)
		)
		(super dispose:)
	)
)

(class GKFeature of Feature
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 62) ; Do
			(= temp0 0)
			(cond
				(BAD_SELECTOR
					(if BAD_SELECTOR
						(PlayScene BAD_SELECTOR 0 BAD_SELECTOR)
						(= temp0 1)
					else
						(gCurRoom newRoom: BAD_SELECTOR)
					)
					(return 1)
				)
				(temp0
					(if BAD_SELECTOR
						(PlayScene BAD_SELECTOR)
						(= temp0 1)
					)
					(return 1)
				)
				(else
					(if BAD_SELECTOR
						(PlayScene BAD_SELECTOR)
						(= temp0 1)
					)
					(return (super doVerb: theVerb &rest))
				)
			)
		)
		(return (super doVerb: theVerb &rest))
	)
)

(class ExitFeature of GKFeature
	(properties
		BAD_SELECTOR -1
	)

	(method (setCursor param1)
		(param1 view: 998)
		(param1 loop: 0)
		(param1 cel: BAD_SELECTOR)
	)

	(method (doVerb)
		(super doVerb: 62)
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

