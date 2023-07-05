;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use PolyPath)
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
							(IsObject client)
							(IsObject (client actions:))
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
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck 26505
		state 0
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
	)

	(method (init theInitializer)
		(self initialize: (if argc theInitializer else 0))
		(if (self respondsTo: #underBits)
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
		(if (and argc gKq6ApproachCode [args 0])
			(for ((= i 0)) (< i argc) ((++ i))
				(= theBits (gKq6ApproachCode doit: [args i]))
				(self _approachVerbs: (| (self _approachVerbs:) theBits))
			)
		)
	)

	(method (handleEvent event)
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
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
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
						gKq6ApproachCode
						(& _approachVerbs (gKq6ApproachCode doit: (event message:)))
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
		(event claimed:)
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
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
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
				(self notFacing:)
			)
			(return 0)
		)
	)

	(method (isNotHidden)
		(return 1)
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (IsObject theObjOrX)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(return
			(cond
				((& state $0004)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft oX nsRight)
								(<= nsTop oY nsBottom)
							)
						)
						(& onMeCheck (OnControl CONTROL oX oY))
					else
						0
					)
				)
				((IsObject onMeCheck)
					(AvoidPath oX oY onMeCheck)
				)
				(
					(or
						(not (or nsLeft nsRight nsTop nsBottom))
						(and
							(<= nsLeft oX nsRight)
							(<= nsTop oY nsBottom)
						)
					)
					1
				)
				(else 0)
			)
		)
	)

	(method (setName theName)
		(|= state $0001)
		(= name (Memory memALLOC_CRIT (+ (StrLen theName) 1)))
		(StrCpy name theName)
	)

	(method (setOnMeCheck type args &tmp i)
		(switch type
			(26505
				(= onMeCheck type)
				(&= state $fffb)
			)
			(2
				(= onMeCheck [args 0])
				(&= state $fffb)
			)
			(1
				(for
					((= i (= onMeCheck 0)))
					(< i (- argc 1))
					((++ i))
					
					(|= onMeCheck [args i])
				)
				(|= state $0004)
			)
		)
	)

	(method (dispose)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if (and (IsObject onMeCheck) (not (& state $0004)))
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gFeatures delete: self)
		(if (& state $0001)
			(Memory memFREE name)
			(= name 0)
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

