;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
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
		modNum -1
		noun 0
		plane 0
		state 0
		x 0
		y 0
		nsBottom 0
		nsLeft 0
		nsRight 0
		nsTop 0
		heading 0
		case 0
		z 0
		_approachVerbs 0
		actions 0
		approachDist 0
		approachX 0
		approachY 0
		onMeCheck 0
		sightAngle 26505
	)

	(method (init theInitializer)
		(self initialize: (if argc theInitializer else 0))
		(if plane
			(plane addFeature: self)
		else
			(PrintDebug {Feature added to unsupported List: %s} (self name:))
			(gFeatures add: self)
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
		(if plane
			(event localize: plane)
		)
		(cond
			((not (self onMe: event))
				(= ret 0)
			)
			((event claimed:)
				(= ret 1)
			)
			((not (event type:))
				(if
					(and
						scratch
						(or
							(and
								(gTheCursor isInvCursor:)
								(scratch respondsTo: #perform)
							)
							(scratch respondsTo: (gTheCursor verb:))
							(scratch respondsTo: #name)
						)
					)
					(if global141
						(PrintDebug {%s} name)
					)
					(self doVerb: 1)
					(= ret (event claimed: 1))
				)
			)
			((& (event type:) evMOUSEBUTTON)
				(cond
					((== (event modifiers:) emSHIFT)
						(if (gTalkers size:)
							(gMessager cue: 1)
						)
						(if
							(and
								scratch
								(== (gTheCursor verb:) 2)
								(scratch respondsTo: #sel_32)
							)
							(self doVerb: 32)
							(= ret (event claimed: 1))
						)
					)
					(
						(and
							scratch
							(or
								(and
									(gTheCursor isInvCursor:)
									(scratch respondsTo: #perform)
								)
								(scratch respondsTo: (gTheCursor verb:))
							)
						)
						(self doVerb: (gTheCursor verb:))
						(= ret (event claimed: 1))
					)
					((and scratch (scratch respondsTo: #name))
						(self doVerb: 9)
						(= ret (event claimed: 1))
					)
				)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
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
		)
		(if plane
			(event globalize:)
		)
		(return ret)
	)

	(method (notFacing &tmp event)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb &tmp defaultCode who)
		(switch theVerb
			(1
				(gTheCursor hilite:)
				(if (== modNum -1)
					(= modNum (gCurRoom modNum:))
				)
				(if (ResCheck rsMESSAGE modNum)
					(global123 displayOptionsText: modNum noun theVerb case 1)
				)
			)
			(else
				(= defaultCode (if gDoVerbCode gDoVerbCode else dftDoVerb))
				(if (== modNum -1)
					(= modNum (gCurRoom modNum:))
				)
				(if
					(and
						gMsgType
						(ResCheck rsMESSAGE modNum)
						(Message msgGET modNum noun theVerb case 1)
					)
					(global123 displayOptionsText: modNum noun 1 case 1)
					(gMessager say: noun theVerb case 0 0 modNum)
				else
					(defaultCode doit: theVerb self)
				)
			)
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

	(method (setHotspot param1)
		(if (not argc)
			(if scratch
				(self deleteHotspot:)
			)
		else
			(if scratch
				(self deleteHotspot:)
			)
			(= scratch ((ScriptID 80 0) new:)) ; HotSpot
			(scratch respondVerbs: [param1 0] &rest)
			(if plane
				(plane addExtMH: self)
			else
				(gExtMouseHandler add: self)
				(gMouseDownHandler add: self)
			)
		)
	)

	(method (deleteHotspot)
		(if scratch
			(scratch dispose:)
			(= scratch 0)
			(if plane
				(plane deleteExtMH: self)
			else
				(gExtMouseHandler delete: self)
				(gMouseDownHandler delete: self)
			)
		)
	)

	(method (dispose)
		(self setPolygon: 0)
		(self deleteHotspot:)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(if plane
			(plane deleteFeature: self)
		else
			(gFeatures delete: self)
		)
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

