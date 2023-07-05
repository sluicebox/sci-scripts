;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64950)
(include sci.sh)
(use Main)
(use DuneMover)
(use Str)
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
				(if (< (client sightAngle:) 350)
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
					(= cycles 1)
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
		sightAngle 40
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
		(cond
			((== args 9998)
				(= _approachVerbs -1)
			)
			((and argc gApproachCode [args 0])
				(for ((= i 0)) (< i argc) ((++ i))
					(= theBits (gApproachCode doit: [args i]))
					(self _approachVerbs: (| (self _approachVerbs:) theBits))
				)
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
						(!= plane gInterfacePlane)
						(!= gCurRoomNum 20) ; nameGameRoom
					)
					(cond
						((== self global311)
							(if
								(and
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
									(&
										_approachVerbs
										(gApproachCode doit: (event message:))
									)
								)
								(if
									(and
										(or
											(== gCurRoomNum 1500)
											(== gCurRoomNum 1600)
										)
										global312
									)
									(gEgo
										setMotion:
											DuneMover
											approachX
											(+ (gEgo z:) approachY)
											CueObj
									)
								else
									(gEgo
										setMotion:
											PolyPath
											approachX
											(+ (gEgo z:) approachY)
											CueObj
									)
								)
							else
								(gEgo setMotion: 0)
								(if (self facingMe:)
									(CueObj changeState: 3)
								)
							)
						)
						((not (self isKindOf: (ScriptID 33 0))) ; Dune
							(gGame pragmaFail:)
						)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= ret (event claimed: 1))
				(= global311 self)
				((self scratch:) doit:)
			)
		)
		(return ret)
	)

	(method (notFacing &tmp event)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(= temp2 (Str format: {%d} modNum))
		(temp2 cat: {.msg})
		(if
			(and
				gMsgType
				(FileIO fiEXISTS (temp2 data:))
				(Message msgGET modNum noun theVerb case 1)
			)
			(gMessager say: noun theVerb case 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
		(temp2 dispose:)
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
			(if (& (theActor signal:) $0800)
				(CueObj client: self state: 2 cycles: 0 cue:)
			else
				(self notFacing:)
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
		(if (and global311 global331 (== global311 self))
			(global331 cel: (Max 0 (+ (global331 cel:) 1)))
			(if (== gTheCursor global331)
				(global331 init:)
			)
			(if (not global308)
				(gUser message: (gUser dftMessage:))
			)
			(if (== global331 gNormalCursor)
				(global331 view: 999 setCycle: 0 loop: 0 cel: 0)
				(if (gGame isHandsOn:)
					(global331 init:)
				)
			)
			(= global331 0)
			(= global311 0)
		)
		(if scratch
			(self deleteHotspot:)
		)
		(= plane 0)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gFeatures delete: self)
		(super dispose:)
	)

	(method (setHotspot param1)
		(cond
			((and (== argc 1) (not [param1 0]))
				(if scratch
					(self deleteHotspot:)
				)
			)
			((and (== argc 1) (!= [param1 0] 9998))
				(scratch setProps: [param1 0])
			)
			(else
				(if scratch
					(self deleteHotspot:)
				)
				(= scratch ((ScriptID 17) new:)) ; HotSpot
				(cond
					(
						(or
							(not plane)
							(and
								(== plane gThePlane)
								(not (global123 contains: self))
							)
						)
						(global123 add: self)
					)
					((and global124 (not (global124 contains: self)))
						(global124 add: self)
					)
				)
				(scratch setProps: [param1 0] &rest)
			)
		)
	)

	(method (addRespondVerb param1)
		(if scratch
			(scratch addRespondVerb: param1)
			(cond
				((or (not plane) (== plane gThePlane))
					(global123 add: self)
				)
				(global124
					(global124 add: self)
				)
			)
		)
	)

	(method (deleteHotVerb)
		(if scratch
			(scratch deleteVerbs: &rest)
		)
	)

	(method (deleteHotspot)
		(if scratch
			(scratch dispose:)
			(= scratch 0)
		)
		(cond
			((or (not plane) (== plane gThePlane))
				(global123 delete: self)
			)
			(global124
				(global124 delete: self)
			)
		)
		(if (== global311 self)
			(gUser need_update: 1)
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

