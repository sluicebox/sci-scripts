;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use rgCastle)
(use NewFeature)
(use KQ6Print)
(use n913)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use System)

(public
	rm860 0
)

(local
	local0
	local1 = 1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(if (> (gEgo y:) 137)
		(= temp1
			(if (>= ((ScriptID 80 5) y:) ((ScriptID 80 6) y:)) ; guard1, guard2
				(ScriptID 80 5) ; guard1
			else
				(ScriptID 80 6) ; guard2
			)
		)
	else
		(= temp1
			(if (<= ((ScriptID 80 5) y:) ((ScriptID 80 6) y:)) ; guard1, guard2
				(ScriptID 80 5) ; guard1
			else
				(ScriptID 80 6) ; guard2
			)
		)
	)
	(switch temp1
		((ScriptID 80 5) ; guard1
			(= temp0 (ScriptID 80 6)) ; guard2
		)
		((ScriptID 80 6) ; guard2
			(= temp0 (ScriptID 80 5)) ; guard1
		)
	)
	(if (< (gEgo y:) 137)
		(if (== temp0 (ScriptID 80 5)) ; guard1
			(= temp2 (>> local6 $0008))
		else
			(= temp2 (>> local7 $0008))
		)
	else
		(= temp2 (temp0 x:))
	)
	(= temp3 (temp1 y:))
	(temp0 cycleSpeed: 5 moveSpeed: 5 setMotion: PolyPath temp2 temp3 param1)
)

(instance rm860 of CastleRoom
	(properties
		noun 2
		picture 860
		style 10
		south 730
		vanishingX 198
		vanishingY 90
		minScaleSize 37
		minScaleY 111
		maxScaleY 177
		moveOtherGuard 1
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 141 117 170 117 113 153 128 153 116 165 98 165 75 179 63 182 45 182 36 178 13 178 0 186 0 -10 319 -10 319 180 221 112 141 112
					yourself:
				)
		)
		(gFeatures
			add: eastDoors roomFeatures floor chairs hideFeature
			eachElementDo: #init
		)
		(super init: &rest)
		((ScriptID 80 0) guard1Code: guardsCode guard2Code: guardsCode) ; rgCastle
		((ScriptID 1015 6) talkWidth: 150 x: 15 y: 20) ; tlkGuardDog1
		((ScriptID 1015 7) talkWidth: 135 x: 160 y: 20) ; tlkGuardDog2
		((ScriptID 80 5) ; guard1
			setScript: (Clone guardPatrol) 0 1
			init:
			noun: 5
			actions: guardDoVerb
			okToCheck: guardCheck
			ignoreActors:
			sightAngle: 45
		)
		((ScriptID 80 6) ; guard2
			setScript: guardPatrol
			init:
			noun: 5
			actions: guardDoVerb
			okToCheck: guardCheck
			ignoreActors:
			sightAngle: 45
		)
		((ScriptID 80 0) setupGuards:) ; rgCastle
		(gEgo
			init:
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(switch gPrevRoomNum
			(870
				(gEgo posn: 173 114)
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0) ; guard2
				(self setScript: getCaught)
			)
			(else
				(gEgo loop: 1 setSpeed: 6 posn: 79 188)
				(self setScript: hideEgo)
			)
		)
		(= spotEgoScr captureEgo)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
		(if (not script)
			(gGame handsOn:)
		)
		(gGlobalSound4 number: 702 loop: 1 play:)
	)

	(method (doit)
		(= local0 (gEgo onControl: 1))
		(= local1 (or (== (gEgo view:) 881) (& local0 $0004)))
		(cond
			(script 0)
			((InRect 0 0 165 117 gEgo)
				(gCurRoom newRoom: 870)
			)
		)
		(super doit: &rest)
	)
)

(instance hideEgo of Script
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		((ScriptID 80 5) sightAngle: 180) ; guard1
		((ScriptID 80 6) sightAngle: 180) ; guard2
		(super init: &rest)
	)

	(method (doit)
		(if (and (gEgo mover:) (== state 4))
			(gGame handsOff:)
			(if (not local2)
				(= local2 ((User curEvent:) x:))
				(= local3 ((User curEvent:) y:))
				(= cycles 3)
			)
			(gEgo setMotion: 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 3))
				(or
					((ScriptID 80 5) onMe: event) ; guard1
					((ScriptID 80 6) onMe: event) ; guard2
				)
			)
			(gGame handsOff:)
			(CueObj state: 0 cycles: 0 client: (ScriptID 80 5) theVerb: 2) ; guard1
			((CueObj client:) approachX: 111 approachY: 172)
			((ScriptID 80 5) okToCheck: 0) ; guard1
			((ScriptID 80 6) okToCheck: 0) ; guard2
			(= local5 1)
			(gMessager say: 5 2 0 1 self) ; "Alexander decides to take the direct approach with the guard dogs."
			(= next talkToGuards)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 60 180 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					normal: 0
					view: 881
					setLoop: 3
					cel: 0
					x: 78
					y: 188
					setScale:
					scaleX: 142
					scaleY: 142
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 2048)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 2048) ; rgCastle
					(gMessager say: 1 0 6 0 self) ; "Whoa! Alexander runs right into a guard dog patrol!"
				else
					(gMessager say: 1 0 7 0 self) ; "The guard dog patrol is still on duty here."
				)
			)
			(4
				(gGame handsOn:)
			)
			(5
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				((ScriptID 80 5) sightAngle: 40) ; guard1
				((ScriptID 80 6) sightAngle: 40) ; guard2
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo
					reset: 5 900
					posn: (hideFeature approachX:) (hideFeature approachY:)
				)
				(if
					(and
						(CueObj client:)
						((CueObj client:) approachX:)
						(&
							((CueObj client:) _approachVerbs:)
							(gKq6ApproachCode doit: ((gTheIconBar curIcon:) message:))
						)
					)
					(if (== (CueObj client:) hideFeature)
						(= local8 1)
						((CueObj client:) doVerb: (CueObj theVerb:))
					else
						(gEgo
							setMotion:
								PolyPath
								((CueObj client:) approachX:)
								(+ (gEgo z:) ((CueObj client:) approachY:))
								CueObj
						)
					)
				else
					(gEgo setMotion: PolyPath local2 local3)
				)
				(gGame handsOn:)
				(= local2 (= local3 (= register 0)))
				(self dispose:)
			)
		)
	)
)

(instance guardPatrol of Script
	(properties)

	(method (init &tmp [temp0 50])
		(= start -1)
		(super init: &rest)
		(if register
			(= register 0)
			(= register (| (& register $00ff) $c400))
			(= register (| (& register $ff00) $00b3))
			(client posn: (& register $00ff) 147)
			(= state 0)
		else
			(= register (| (& register $00ff) $ce00))
			(= register (| (& register $ff00) $00df))
			(client posn: (>> register $0008) 114)
		)
		(= cycles 1)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo (& register $00ff) 147 self)
			)
			(1
				(client setMotion: MoveTo (>> register $0008) 114 self)
			)
			(2
				(client setHeading: 270 self)
			)
			(3
				(= state -1)
				(= seconds 2)
			)
		)
	)
)

(instance getCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gMessager say: 1 0 2 0 self) ; "Uh, oh! Company!"
			)
			(2
				(gCurRoom spotEgo: (proc80_7))
			)
		)
	)
)

(instance captureEgo of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 (((ScriptID 80 5) script:) register:)) ; guard1
				(= local7 (((ScriptID 80 6) script:) register:)) ; guard2
				((ScriptID 80 5) setScript: 0 setMotion: 0 okToCheck: 0) ; guard1
				((ScriptID 80 6) setScript: 0 setMotion: 0 okToCheck: 0) ; guard2
				(Face register gEgo self)
			)
			(1
				(gMessager say: 1 0 3 1 self) ; "Mite! Look at this!"
			)
			(2
				(cond
					((not (gEgo facingMe: (ScriptID 80 5))) ; guard1
						(Face (ScriptID 80 5) gEgo self) ; guard1
					)
					((not (gEgo facingMe: (ScriptID 80 6))) ; guard2
						(Face (ScriptID 80 6) gEgo self) ; guard2
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(localproc_0 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 1 0 3 2 self) ; "Hi. Uh...nice castle."
			)
			(6
				(gMessager say: 1 0 3 3 self) ; "Cheeky, isn't he? Grab 'im, Jowels!"
			)
			(7
				(gMessager say: 1 0 3 4 self) ; "I bet this is the foreigner we were told to look out for!"
			)
			(8
				((proc80_7) setScript: (ScriptID 80 4) self 1) ; guardsGetEgo
			)
			(9
				(gMessager say: 1 0 3 5 self oneOnly: 0) ; "Well, let's lock him up and go tell Saladin. He'll tell us what kind of fish we've caught."
			)
			(10
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance talkToGuards of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0) ; guard2
				((ScriptID 80 5) approachX: 0 approachY: 0) ; guard1
				(if (not local5)
					(gMessager say: 5 2 0 1 self) ; "Alexander decides to take the direct approach with the guard dogs."
				else
					(= cycles 1)
				)
			)
			(1
				(if local1
					(gEgo setMotion: PolyPath 111 172 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (not (gEgo facingMe: (ScriptID 80 5))) ; guard1
					(Face (ScriptID 80 5) gEgo self) ; guard1
				else
					(= cycles 1)
				)
			)
			(3
				(= cycles 1)
			)
			(4
				(gMessager say: 5 2 0 2 self oneOnly: 0) ; "Er, hello there. Could you tell me how I might go about getting an audience with the vizier?"
			)
			(5
				(gCurRoom spotEgo: (proc80_7))
			)
		)
	)
)

(instance eastDoors of NewFeature
	(properties
		heading 270
		noun 3
		sightAngle 90
		onMeCheck 2
		approachX 237
		approachY 139
		normal 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom spotEgo: (proc80_7))
			)
			(1 ; Look
				(if (not local4)
					(++ local4)
					(gMessager say: noun theVerb 8) ; "There are two thick wooden doors on the east wall."
				else
					(gMessager say: noun theVerb 9) ; "There are two thick wooden doors on the east wall. The doors have keyholes, but Alexander can't get close enough to look through them."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doSpecial param1)
		(switch param1
			(5
				(gMessager say: noun param1 0 0 NewFeature) ; "Alexander decides to make a try for one of the doors on the east wall."
			)
			(else
				(super doSpecial:)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		noun 10
		onMeCheck 8
	)

	(method (onMe param1)
		(= x (param1 x:))
		(= y (param1 y:))
		(= sightAngle 26505)
		(return (super onMe: param1))
	)
)

(instance hideFeature of Feature
	(properties
		nsTop 64
		nsBottom 176
		nsRight 73
		approachX 60
		approachY 180
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(local8
						(= local8 0)
					)
					((!= (gCurRoom script:) hideEgo)
						(gCurRoom setScript: hideEgo)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance guardDoVerb of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(cond
			((== theVerb 2) ; Talk
				(gCurRoom setScript: talkToGuards)
			)
			((== theVerb 37) ; nightingale
				(KQ6Print posn: -1 10 say: 0 5 37 0 1 init:) ; "Alexander walks into the hallway to show the guards the mechanical nightingale."
				(gEgo
					setMotion:
						PolyPath
						((CueObj client:) x:)
						((CueObj client:) y:)
				)
			)
			(else
				(= temp0 0)
			)
		)
	)
)

(instance guardsCode of Code
	(properties)

	(method (doit)
		(return (and (not local1) (!= (gCurRoom script:) hideEgo)))
	)
)

(instance guardCheck of Code
	(properties)

	(method (doit param1)
		(return (or (< 90 (param1 heading:) 270) (<= (gEgo y:) (param1 y:))))
	)
)

(instance roomFeatures of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(return
			(or
				(and (& $0200 temp0) (= noun 6))
				(and (& $0100 temp0) (= noun 7))
			)
		)
	)
)

(instance floor of NewFeature
	(properties
		noun 8
		onMeCheck 128
	)

	(method (init)
		(super init: &rest)
		(= normal 0)
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== (gTheIconBar curInvIcon:) (gInventory at: 27)) ; nightingale
						(= _approachVerbs -32768)
						(= approachX 154)
						(= approachY 141)
					)
					(and
						(not (= _approachVerbs 0))
						(not (= approachX 0))
						(not (= approachY 0))
					)
				)
			)
		)
	)

	(method (doSpecial param1)
		(switch param1
			(37
				(gMessager say: 8 37 0 0 self) ; "Alexander walks into the hallway to use the mechanical nightingale."
			)
			(else
				(super doSpecial:)
			)
		)
	)
)

