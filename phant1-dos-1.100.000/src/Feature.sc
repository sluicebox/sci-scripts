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
		(if global115
			(gTheDoits delete: self)
			(= global115 0)
			(if (gCast contains: gEgo)
				(gEgo setCycle: 0)
			)
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
			(= state (= client 0))
		else
			(switch (= state newState)
				(1
					(if (gCast contains: gEgo)
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
						((ScriptID 0 10) init:) ; fastForward
					else
						(self changeState: 3)
					)
				)
				(2
					(if (& (client state:) $0008)
						(self cue:)
					else
						(gTheDoits add: self)
						(= cycles 3)
					)
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
					(= state (= client 0))
				)
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

	(method (init theInitializer)
		(self initialize: (if argc theInitializer else 0))
		(if (self respondsTo: #view)
			(gCast add: self)
		else
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
		(= ret 0)
		(cond
			((or (event claimed:) (not scratch))
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(if
					(and
						(!= (event message:) (scratch theVerb:))
						(not (scratch respondsTo: (event message:)))
					)
					(return 0)
				)
				(= ret (event claimed: 1))
				(cond
					(
						(and
							(& (gEgo state:) $0002)
							gApproachCode
							(&
								_approachVerbs
								(gApproachCode doit: (event message:))
							)
							(!= global163 self)
						)
						(= global163 self)
						(if
							(and
								(gCast contains: gEgo)
								(not
									(OneOf
										(gEgo view:)
										0
										1
										2
										3
										4
										5
										6
										7
										610
										611
										612
										613
										614
										615
										616
										617
									)
								)
								(== (gEgo script:) (ScriptID 30 1)) ; fidgetScript
							)
							((ScriptID 30 1) register: 1) ; fidgetScript
							(CueObj
								state: 0
								cycles: 0
								client: self
								theVerb: (event message:)
							)
						else
							(CueObj
								state: 0
								cycles: 0
								client: self
								theVerb: (event message:)
								cue:
							)
						)
					)
					(
						(and
							(gCast contains: gEgo)
							(== (gEgo script:) (ScriptID 30 1)) ; fidgetScript
						)
						((ScriptID 30 1) register: 1) ; fidgetScript
						(CueObj
							client: self
							theVerb: (event message:)
							state: 2
						)
						(if (or (global116 contains: self) (gCurRoom inset:))
							((ScriptID 30 1) register: 0) ; fidgetScript
							(CueObj cue:)
						)
					)
					(else
						(CueObj
							client: self
							theVerb: (event message:)
							changeState: 3
						)
					)
				)
			)
			(
				(and
					scratch
					(not (event type:))
					(gUser canInput:)
					(self onMe: event)
				)
				(= ret (event claimed: 1))
				(= global118 self)
				((self scratch:) doit:)
			)
		)
		(return ret)
	)

	(method (approachMe param1)
		(= global125 0)
		(CueObj state: 0 cycles: 0 client: self theVerb: param1)
		(if
			(and
				(gUser canControl:)
				(& (gEgo state:) $0002)
				(>
					(GetDistance (gEgo x:) (gEgo y:) approachX approachY)
					approachDist
				)
				gApproachCode
				(& _approachVerbs (gApproachCode doit: param1))
			)
			(gEgo
				setMotion: PolyPath approachX (+ (gEgo z:) approachY) CueObj
			)
		else
			(self notFacing:)
		)
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
		(if
			(and
				gMsgType
				(ResCheck rsMESSAGE modNum)
				(Message msgGET modNum noun theVerb case 1)
			)
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
		(cond
			((<= theAngle sightAngle)
				(return 1)
			)
			((== sightAngle 26505)
				(return 0)
			)
			((& (theActor signal:) $0800)
				(CueObj client: self state: 2 cycles: 0 cue:)
				(return 0)
			)
			(else
				(self notFacing:)
				(return 0)
			)
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
						(and
							(<= nsLeft oX nsRight)
							(<= nsTop oY nsBottom)
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
		(cond
			((and (== argc 1) (not [param1 0]))
				(if scratch
					(self deleteHotspot:)
				)
			)
			((== argc 1)
				(scratch setProps: [param1 0])
			)
			(else
				(if scratch
					(self deleteHotspot:)
				)
				(= scratch ((ScriptID 23) new:)) ; HotSpot
				(global160 add: self)
				(scratch setProps: [param1 0] &rest)
			)
		)
	)

	(method (deleteHotspot)
		(scratch dispose:)
		(= scratch 0)
		(global160 delete: self)
		(if (== global118 self)
			(= global162 1)
		)
	)

	(method (scaleRect)
		(if (not (IsFlag 127))
			(= nsLeft (+ (>> nsLeft $0001) 85))
			(= nsRight (+ (>> nsRight $0001) 85))
			(= nsTop (+ (>> nsTop $0001) 37))
			(= nsBottom (+ (>> nsBottom $0001) 38))
		)
	)

	(method (cue))

	(method (dispose)
		(self setPolygon: 0)
		(if scratch
			(self deleteHotspot:)
		)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
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

